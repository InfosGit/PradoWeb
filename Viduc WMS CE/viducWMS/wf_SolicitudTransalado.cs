using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.wsTraslado;
using VIDUC;
using biliotecaVIDUC;

namespace viducWMS
{
    public partial class wf_SolicitudTransalado : Form
    {

        #region DECLARACION DE VARIABLES GLOBALES ---------------------------//
        //inicialización de Variables Globales
       
        private  static int Compa;
        private  static int Solicitud;
        private  static int BodegaPeticion;
      
        private  static string UsuarioSistema;
        private  static string Descripcion;

        #endregion 

        #region LLAMANDO LA CAPA DE SERVICIOS ----------------------------//

        wsTrasladoBodegaBodega Proxy = new wsTraslado.wsTrasladoBodegaBodega();
        viducWMS.ws_Servicios.VIDUCWebService Proxys = new viducWMS.ws_Servicios.VIDUCWebService();
        List<solicitud> DatosSolicitud = new List<solicitud>();
        List<viducWMS.ws_Servicios.estadoSolicitud> estadoSolicitud = new List<viducWMS.ws_Servicios.estadoSolicitud>();
        List<ComboBoxSolicitudes> Lista = new List<ComboBoxSolicitudes>();
        
        #endregion
        
        #region METODO GENERAL DE PASO DE PARAMETROS------------------------------------//

        public wf_SolicitudTransalado(int Compania, int Bodegas, string Usuario)
        {
            
                //Incialización del Formulario y asignacion de valores
                InitializeComponent();

                Compa = Compania;
                BodegaPeticion = Bodegas;
                UsuarioSistema = Usuario;
                EstadoSolicitudes();
                //Llenando el Grid Cuando Carga
               
          
           
        }

        #endregion

        #region OPCIONES DE CLIC -------------------------------//

      
        
        private void btnSalir_Click(object sender, EventArgs e)
        {
            Cancelar();
        }

        private void dgSolicitudes_KeyPress(object sender, KeyPressEventArgs e)
        {
            char? letter = e.KeyChar;
           
            char? Numeral = '#';

            
           if (letter == Numeral)
            {
                Cancelar();
            }
        }

        #endregion 

        #region LLENANDO EL GRID -------------------//

        private void llenaraGRID()
        {
            try
            {
                //Obeniendo el estado de la solictud de traslado
                ComboBoxSolicitudes cmb = cmbSolictudesTraslado.SelectedItem as ComboBoxSolicitudes;
                int  Estado = Convert.ToInt32(cmb.Valor);

                //Obteniendo el listado de las Solictudes de traslado
                DatosSolicitud = Proxy.findProformasTraslado(Compa, true, Estado, true).ToList<solicitud>();
                //Llenar el origen de esos Datos 
                if (DatosSolicitud != null)
                {
                    dgSolicitudesTraslado.DataSource = CargarTabla();
                }
                else
                {
                    MessageBox.Show(clsMensajesGenerales.noDatos());
                    dgSolicitudesTraslado.DataSource = null;
                }

                //Envia el Focus a ese GRID
            }
            catch (Exception)

            {
                
                dgSolicitudesTraslado.DataSource = null;

            }
       
        }
        #endregion

        #region    CREANDO EL GRID ---------------------///

        private DataTable CargarTabla()
        {
            //Creando un Tabla de datos
            DataTable dt = new DataTable();
            dt.Columns.Add("Código Solicitud");
            dt.Columns.Add("Decripción");
           dt.Columns.Add("Estado");

            DataRow row = dt.NewRow();
            foreach (var item in DatosSolicitud)
            {
                row = dt.NewRow();
                row["Código Solicitud"] = item.solicitudPK.codSolicitud.ToString();
                row["Decripción"] = item.descripcion.ToString();
                row["Estado"] = item.estado.ToString();
            
                dt.Rows.Add(row);
            }

            return dt;

        }

        #endregion 

        #region doble CLIC EN EL GRID --------------------------------//

        private void ClickGrid()
        {
            try
            {
                //Agrega Valor a Variables Globales

                int Index = dgSolicitudesTraslado.CurrentRowIndex;
                Solicitud = Convert.ToInt32(dgSolicitudesTraslado[Index, 0].ToString());
                Descripcion = dgSolicitudesTraslado[Index, 1].ToString();
             

                ComboBoxSolicitudes estado= cmbSolictudesTraslado.SelectedItem as ComboBoxSolicitudes;

                // Activa el Formulario de Translado
               // wf_TrasladoOrigenProducto Menu = new wf_TrasladoOrigenProducto(Compa, Solicitud, BodegaPeticion, UsuarioSistema, Descripcion);
                  wf_DespachoProducto Menu = new wf_DespachoProducto(Compa, Solicitud, UsuarioSistema, BodegaPeticion, Descripcion, estado.Valor, "TRASLADO");
                  Menu.Show();
                  Menu.Activate();

                //Oculta el Formulario Actual
                this.Visible = false;

            }
            catch (Exception)
            {
                MessageBox.Show(clsMensajesGenerales.FilaNoValida());
            }
        }

#endregion

        #region CANCELAR -----------------//

        private void Cancelar()
        {
            // Activa el Formulario de Menu
            wf_SubMenuTransalado Menu = new wf_SubMenuTransalado(Compa, BodegaPeticion, UsuarioSistema);
            //Muestra el el GRID
            Menu.Show();
            //Activa el GRID
            Menu.Activate();
            this.Visible = false;
        }

        #endregion

        #region OPCIONES DE SELECCION Y LLENADO

        private void cmbSolictudesTraslado_SelectedIndexChanged(object sender, EventArgs e)
        {
           //Llamando el metodo que llena el Grid cuando se da clic 
           //en el Dropdowlist de estado de solicitud

            ComboBoxSolicitudes lista = cmbSolictudesTraslado.SelectedItem as ComboBoxSolicitudes;
            if (lista.Valor != 0)
            {
                llenaraGRID();
            }
         
        }

    

        #endregion

        #region PRESIONADO DE TECLA ----------------------------------//
       
        private void dgSolicitudesTraslado_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                string estado = Convert.ToString(clsFuncionesGenerales.filaSeleccionadaGrid(dgSolicitudesTraslado, 2));
                if (estado != "D")
                {
                    //LLama la opcion para mostrar el detalle de productos de la lista
                    ClickGrid();
                }
                else
                {
                    MessageBox.Show("Solo se puede ver el detalle de estado: CARGADO");
                }
            }
        }

        #endregion
  
        #region CARGAR ESTADO DE SOLICITUDES-----------------------------------------//

        public void EstadoSolicitudes()
        {
            try
            {
                estadoSolicitud = Proxys.findEstadosSolicitud().ToList<viducWMS.ws_Servicios.estadoSolicitud>();
                Lista.Add(new ComboBoxSolicitudes("**SELECCIONE ESTADO**", 0));

                foreach (var Item in estadoSolicitud)
                {

                    //Agregando los estados a lista de estados de solicitud
                    Lista.Add(new ComboBoxSolicitudes(Item.nombre, Convert.ToInt32(Item.id)));

                }

                //Listado de origen de datos
                cmbSolictudesTraslado.DataSource = Lista;
                cmbSolictudesTraslado.ValueMember = "Valor";
                cmbSolictudesTraslado.DisplayMember = "Nombre";
            }
            catch (Exception)
            {
                dgSolicitudesTraslado.DataSource = null;
                //Poner un mensaje de error en la excepcion
            }
        }

        #endregion

        #region DOBLE CLIC EN EL GRID------------------------------------------//

        private void dgSolicitudesTraslado_DoubleClick(object sender, EventArgs e)
        {

            string estado = Convert.ToString(clsFuncionesGenerales.filaSeleccionadaGrid(dgSolicitudesTraslado, 2));
            
            if (estado != "D")
            {
                //LLama la opcion para mostrar el detalle de productos de la lista
                ClickGrid();
                
            }
            else
            {
                MessageBox.Show("Solo se puede ver el detalle de estado: SOLICITADA");
            }
        }

        #endregion

        private void dgSolicitudesTraslado_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                string estado = Convert.ToString(clsFuncionesGenerales.filaSeleccionadaGrid(dgSolicitudesTraslado, 2));

                if (estado != "D")
                {
                    //LLama la opcion para mostrar el detalle de productos de la lista
                    ClickGrid();

                }
                else
                {
                    MessageBox.Show("Solo se puede ver el detalle de estado: SOLICITADA");
                }
            }
        }

        private void cmbSolictudesTraslado_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                dgSolicitudesTraslado.Focus();
            }
        }

    }
}