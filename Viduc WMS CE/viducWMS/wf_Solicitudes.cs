using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.ws_Servicios;
using VIDUC;
using biliotecaVIDUC;

namespace viducWMS
{
    public partial class wf_Solicitudes : Form
    {
        #region VARIABLES GLOBALES ----------------------------------//
        //inicialización de Variables Globales
        public static int Compa;
        public static int Ordenes;
        public static int BodegaPeticion;
        public static int codProduct;
        public static string UsuarioSistema;
        public static int EstadoSolicitud;
        public static bool Bandera;
        #endregion

        #region  ACCEDIENDO A LA CAPA DE SERVICIOS ------------------------------------//

        viducWMS.ws_Servicios.VIDUCWebService Proxy = new viducWMS.ws_Servicios.VIDUCWebService();
        List<datosSolicitudRecepcion> DatosProducto = new List<datosSolicitudRecepcion>();
        List<estadoSolicitud> Solicitud = new List<estadoSolicitud>();
        //Estado De socitudes
               
         List<ComboBoxSolicitudes> Lista = new List<ComboBoxSolicitudes>();

        #endregion

        #region METODO GENERAL DE PARAMETROS -----------------------------//

        public wf_Solicitudes(int Compania, int Bodegas, string Usuario)
        {
                //Inicialización del Formulario y asignacion de valores
                InitializeComponent();
               // EstadoSolicitudes();
               
               // Asignacion  
                Compa = Compania;
                // Bodega de las solicitudes 
                BodegaPeticion = Bodegas;
                // Usuario  del sistema que se ha logueado
                UsuarioSistema = Usuario;
                // Obteniendo los datos del producto 
                cargarDatos();
  
            
           

            //clsFuncionesGenerales.EstadoSolicitud(cmbSolicitudes);



        }

        #endregion
      

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Cancelar();
        }

        private void dgSolicitudes_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Asigna Valores de Comparacion  por teclas
            char? letter = e.KeyChar;
            //char? Tab = '\t';
            char? Numeral = '#';

                     
            if (letter == Numeral)
            {
                Cancelar();
            }
        }

        private DataTable CargarTabla()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("No OC");
            dt.Columns.Add("Fecha");
            dt.Columns.Add("Ubicación");
            dt.Columns.Add("Recepción");
            dt.Columns.Add("Prioridad");
            dt.Columns.Add("Estado");
            dt.Columns.Add("Solicitud");

            DataRow row = dt.NewRow();
            foreach (var item in DatosProducto)
            {
                row = dt.NewRow();
                row["No OC"] = item.ordenCompra.ToString();
                row["Fecha"] = item.fechaHoraCreacion.ToString();
                row["Ubicación"] = item.nomBodega.ToString();
                row["Recepción"] = item.fechaHoraRecepcion.ToString();
                row["Prioridad"] = item.strPrioridad.ToString();
                row["Estado"] = item.strEstado.ToString();
                row["Solicitud"] = item.codSolicitud.ToString();
                dt.Rows.Add(row);
            }
                                   
            return dt;

        }

        private void ClickGrid()
        {
            try
            {
                //Agrega Valor a Variables Globales

              
              
                      
                    UbicarProducto();
                       
                  
              
            }
            catch (Exception ex)
            {
                MessageBox.Show(clsMensajesGenerales.FilaNoValida()+ex);
            }
        }

        private void Cancelar()
        {
            //oculta el Formulario Actual
            // Activa el Formulario de Menu
            wf_menuRecepcion Menu = new wf_menuRecepcion(Compa, BodegaPeticion, UsuarioSistema);
            Menu.Show();
            Menu.Activate();
            this.Visible = false;
        }

        private void wf_Solicitudes_Load(object sender, EventArgs e)
        {
            
           
           
        }

        private void cmbSolicitudes_SelectedIndexChanged(object sender, EventArgs e)
        {

            
                //Carga los valores del Grid cuando 
                //selecciona un estado de solicitud valido
                    cargarDatos();
           
            
            
        }

        #region CARGAR DATOS DE SOLICITUDES ------------------------------///

        public void cargarDatos()
        {
            try
            {
              
                //Estado de la solicitud que selecionada 
                    
                
                        DatosProducto = Proxy.findSolicitudesRecepcionBodega(Compa, true, BodegaPeticion, true, 1, true).ToList<datosSolicitudRecepcion>();
                        dgSolicitudes.DataSource = CargarTabla();
                        dgSolicitudes.Focus();
                   

              
                   
              
           
              
            }
            catch (Exception)

            {
                dgSolicitudes.DataSource = null;
            }
        }

        #endregion

       #region UBICACION PRODUCTO

        private void UbicarProducto()
        {
           
              int index=dgSolicitudes.CurrentRowIndex;
            // Activa el Formulario de Menu
              Ordenes = Convert.ToInt32(dgSolicitudes[index, 6]);
        
            wf_Recepcion Menu = new wf_Recepcion(Compa, Ordenes, BodegaPeticion, UsuarioSistema);
             Menu.Show();
             Menu.Activate();
             this.Visible = false;


        }

        #endregion 

        private void dgSolicitudes_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            { 
            //Eejecuta la accion de presionando la tecla enter
                ClickGrid();
            }
          
        }

        private void cmbSolicitudes_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.D1)
            {
                dgSolicitudes.Focus();
            }
        }

        private void dgSolicitudes_DoubleClick(object sender, EventArgs e)
        {
            if (dgSolicitudes.VisibleRowCount > 0)
            {
                ClickGrid();
            }
        }



 

    }
}