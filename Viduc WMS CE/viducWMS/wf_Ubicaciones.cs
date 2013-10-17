using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.ws_Servicios;
using viducWMS.wsTraslado;
using VIDUC;
using biliotecaVIDUC;

namespace viducWMS
{
    public partial class wf_Ubicaciones : Form
    {
        #region VARIABLES GLOBALES -------------------------------------//
        //inicialización de Variables Globales
        VIDUCWebService Proxy = new VIDUCWebService();
    
        List<datosProductoSolicitudRecepcion> DatosBodega = new List<datosProductoSolicitudRecepcion>();
        List<datosProductoSolicitudRecepcion> DatosBusqueda = new List<datosProductoSolicitudRecepcion>();
        public static int Compa;
        public static int Solicitudes;
        public static int Ordenenes;
        public static int BodegaPeticion;
        public static string UbicacionNueva;
        public static string Producto;
        public static string Anaquel;
        public static string Area;
        public static string Nivel;
        public static int UnidadesExistentes;
        public static string UsuarioSistema;
        #endregion

        #region METODO GENERAL ----------------------------------------------------//

        public wf_Ubicaciones(int Compania, int Solicitud, int Bodegas, string CodProd, int Unidad, string Usuario, string Nombre)
        {
            try
            {
                //Inicialización de formulario y asignación de valores
                InitializeComponent();
                Compa = Compania;
                Solicitudes = Solicitud;
                BodegaPeticion = Bodegas;
                Producto = CodProd;
                UnidadesExistentes = Unidad;
                DatosBodega = Proxy.findUbicacionesBodegaSugeridasProducto(Compa, true, BodegaPeticion, true, Producto).ToList<datosProductoSolicitudRecepcion>();
                UsuarioSistema = Usuario;
                dgUbicaciones.DataSource = CargarTabla();
                dgUbicaciones.Focus();
                clicGRID();
                
                txtProducto.Text = "Producto: " + Producto + "-" + Nombre + "\nCantidad: " + Unidad;
               
            }
            catch (Exception )
            {
                MessageBox.Show(clsMensajesGenerales.noDatos());
            }
        }

        #endregion

        #region AGREGAR CANTIDAD Y DESCERIPCION AL PRODUCTO ---------//

        private void Descripcion()
        {
            try
            {
                if (txtUbicacion.Text.Trim() == "")
                {
                }
                else
                {
                    DatosBusqueda = Proxy.findUbicacionesBodegaSugeridasPorProducto(Compa, true, BodegaPeticion, true, Producto,  txtUbicacion.Text.Trim()).ToList<datosProductoSolicitudRecepcion>();
                    foreach (var item in DatosBusqueda)
                    {
                        if (item.ubicacion == txtUbicacion.Text.Trim())
                        {
                            Anaquel = item.ubicacion.ToString();
                            Area = item.ubicacion.ToString();
                            Nivel = item.ubicacion.ToString();
                        }
                    }
                }
            }
            catch (Exception )
            {
                MessageBox.Show(clsMensajesGenerales.UbicacionBodega());
            }
        }

        #endregion 
       
        
        #region CREACION DE GRID --------------------------//

        private DataTable CargarTabla()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("ID");
            dt.Columns.Add("Ubicación");



            DataRow row = dt.NewRow();
            foreach (var item in DatosBodega)
            {
                row = dt.NewRow();
                row["ID"] = item.codBodega.ToString();
                row["Ubicación"] = item.ubicacion.ToString();
                dt.Rows.Add(row);
            }

            return dt;

        }

       #endregion

        #region Guarda los Datos de Ubicacion --------------------//

        private void GuadarDatos()
        {
            try
            {
                //Determina el la cadena que se esta extrayendo
                string ubicacion = Convert.ToString(txtUbicacion.Text);
                //Determina el largo de la columna
                int largo = ubicacion.Length;
                int Anaquel=0, Nivel=0;
                string Area = "";
                if (largo==4)
                {
                 //Obtiene dos valores ya que el valor sobre pasa de 10 y es menos de 99
                   Anaquel = Convert.ToInt32(ubicacion.Substring(0, 2));
                  //Obteniendoe el ara donde esta ubicado el producto
                   Area = ubicacion.Substring(2, 1);
                  //Niveld el anaquel donde esta el producto
                    Nivel = Convert.ToInt32(ubicacion.Substring(3, 1));
                }
                else if (largo==3)
                {
                    //Obtiene un valor ya que el valor sobre pasa de 10 y es menos de 99
                   Anaquel = Convert.ToInt32(ubicacion.Substring(0, 1));
                   Area = ubicacion.Substring(1, 1);
                   Nivel = Convert.ToInt32(ubicacion.Substring(2, 1));
                }
              


                bool Valor=false;
               
                Valor = Proxy.ubicarProducto(Compa, Producto,BodegaPeticion, Anaquel, Area, Nivel,Convert.ToInt32(txtUnidades.Text)) ;

                if (Valor == true)
                {
                    MessageBox.Show(clsMensajesGenerales.UbicacionS());
                    Cancelar();
                  
                }
                else
                {
                    MessageBox.Show(clsMensajesGenerales.UbicacionN());
                    limpiarTXT();
                }


            }
            catch (Exception )
            {
                MessageBox.Show(clsMensajesGenerales.GuardarFallido());
                limpiarTXT();
            }
        }
        
      
        #region Cancelar Solicitud -----------------------------------//

        private void CancelarSolicitud()
        {
            wf_Solicitudes fm = new wf_Solicitudes(Compa, BodegaPeticion, UsuarioSistema);
            fm.Show();
            fm.Activate();
            this.Visible = false;
        }
        #endregion
        

        #endregion
      
        #region CANCELA EL PROCESO --------------------------//
        
        private void Cancelar()
        {

            // Activa el Formulario de Menu
            wf_RecepcionProducto Menu = new wf_RecepcionProducto(Compa, BodegaPeticion, UsuarioSistema);
            Menu.Show();
            Menu.Activate();


            //oculta el Formulario Actual
            this.Visible = false;
        }
        
        #endregion

        #region CUANDO PRESIONA UNA TECLA -----------------------//

        private void keyPressGrid(KeyPressEventArgs e)
        {
            // Asignación de Valores para Comparacion
            char? letter = e.KeyChar;
            char? tab = '\t';
            char? enter = '\r';
            char? Numeral = '#';
            char? Asterisco = '*';

            //Asignación de Funcionalidad 
            if (letter == tab)
            {
           
                dgUbicaciones.Focus();

            }
            else if (letter == enter)
            {
                Descripcion();
                GuadarDatos();
            }
            else if (letter == Numeral)
            {
                Cancelar();
            }
            else if (letter == Asterisco)
            {
               
            }
        }

        #endregion

        #region EJECUCION DE METOS EN EVENTOS DE OBJETOS ---------------//

        private void lblProducto_KeyPress(object sender, KeyPressEventArgs e)
        {
            keyPressGrid(e);
        }
        
        private void btnSalir_Click(object sender, EventArgs e)
        {
            Cancelar();
        }

      
        private void btnAceptar_Click(object sender, EventArgs e)
        {
            UbicarProducto();
        }

        private void dgUbicaciones_KeyPress(object sender, KeyPressEventArgs e)
        {
           // keyPressGrid(e);
        }

        private void lblProducto_KeyDown(object sender, KeyEventArgs e)
        {
           // Descripcion();
        }
       
        #endregion

        #region UBICAR PRODUCTO

        private void UbicarProducto()
        {
            int numUnidades = Convert.ToInt32(txtUnidades.Text);

            if (txtUbicacion.Text != "")
            {   

                if (numUnidades <= UnidadesExistentes)
                {

                    GuadarDatos();

                }
                else
                {
                    MessageBox.Show("Número de unidades no puede exceder a las pendientes por ubicar");
                    limpiarTXT();
                }
            }
        }
        #endregion

        #region CUANDO PRESIONA UNA TECLA -----------------------------//

        private void txtUnidades_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != (char)Keys.Enter)
            {
                clsFuncionesGenerales.SoloNumero(e);
            }
        }

        private void txtConfirUbicacion_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {
                if (txtUbicacion.Text != "" && txtUnidades.Text!="" && txtConfirUbicacion.Text!="")
                {
                    if (txtUbicacion.Text == txtConfirUbicacion.Text)
                    {
                        UbicarProducto();
                    }
                    else
                    {
                        MessageBox.Show("Las ubicaciones no coinciden, favor verificar");
                        limpiarTXT();
                    }
                }
                else
                {
                    //Limpia la cajas de texto cuando no se ha podido confirmas ubicaciones
                    limpiarTXT();
                    

                    
                }
            }
            if (e.KeyCode == Keys.Up)
            {
                txtUnidades.Focus();
            }
        }

        private void dgUbicaciones_CurrentCellChanged(object sender, EventArgs e)
        {
            DataGridCell estilo;
            estilo = dgUbicaciones.CurrentCell;
            int fila = estilo.RowNumber;

            if (Convert.ToString(dgUbicaciones[fila, 0]) == "S")
            {
                dgUbicaciones.BackColor = Color.Green;
            }
            if (Convert.ToString(dgUbicaciones[fila, 0]) == "R")
            {
                dgUbicaciones.BackColor = Color.Yellow;
            }

        }

        private void txtUbicacion_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {
                if (txtUbicacion.Text != "")
                {
                    this.txtUnidades.Focus();
                }
                else
                {
                    txtUbicacion.Focus();
                }
            }

            if (e.KeyCode == Keys.Down)
            {
                txtUnidades.Focus();
            }
        }


        #endregion

        #region     LIMPIAR CAJAS DE TEXTO -----------------------//

        private void limpiarTXT()
        {
            txtConfirUbicacion.Text = "";
            txtUbicacion.Text = "";
            txtUnidades.Text = "";
            txtUbicacion.Focus();

        }
        #endregion

        private void txtUnidades_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Down)
            {
                txtConfirUbicacion.Focus();
            }
            if (e.KeyCode == Keys.Up)
            {
                txtUbicacion.Focus();
            }
            if (e.KeyCode == Keys.Enter)
            {
    
                txtConfirUbicacion.Focus();
            }
        }

        private void dgUbicaciones_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Down || e.KeyCode == Keys.Up)
            {
                clicGRID();
            }
            if (e.KeyCode == Keys.Enter)
            {
                txtUnidades.Focus();
            }
        }

        private void clicGRID()
        {
            int Indice = dgUbicaciones.CurrentRowIndex;
            txtUbicacion.Text = dgUbicaciones[Indice, 1].ToString();
            txtConfirUbicacion.Text = dgUbicaciones[Indice, 1].ToString();
        }

        private void dgUbicaciones_Click(object sender, EventArgs e)
        {
            clicGRID();
        }


    }
}