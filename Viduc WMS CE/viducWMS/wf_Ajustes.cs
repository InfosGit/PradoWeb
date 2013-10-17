using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.ws_Conteo;


namespace viducWMS
{
    
    
    public partial class wf_Ajustes : Form
    {


        #region VARIABLES GLOBALES ---------------------------------------//
        //inicialización de Variables Globales
        private static int Compa;
        private static string UsuarioSistema;
        private static int Bodega;
         public static string CodigoProducto;
        public static string NombreProducto;
        public static int Cantidades;
        public static string Ubicacion;
        public static string NombreProforma;

        #endregion

        #region CAPA DE SERVICIOS ---------------------------------------//
        //Llamando la capara de servicios
        ConteoWebService proxy = new ConteoWebService();
        List<invFisicoDet> listaProducto = new List<invFisicoDet>();
        #endregion

        #region METODO GENERAL -----------------------------------//

        public wf_Ajustes( int IdCompania, int IdBodega, string IdUsu)

        {
            InitializeComponent();
            Compa=IdCompania;//Compañia
            Bodega = IdBodega;//Codigo de la bodega
            UsuarioSistema = IdUsu;//Usuario de Bodega
            cargarDatos();
            dgProdRecuento.Focus();
            //clicGRID();
        }
        #endregion

        #region  CANCELAR -------------------------//
        private void Cancelar()
        {
            //Pasa los parametros al metodo contructor
            wf_Menu fm = new wf_Menu(Compa, Bodega, UsuarioSistema);
            //Muestra en formulario
            fm.Show();
            //Activa el formulario del menu principal
            fm.Activate();
            //Quita el Forma de la vista del usuario
            this.Visible = false;
        }
        #endregion

        #region OPCIONES DE CLIC -------------------------------------//
        
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            //Cancelando el proceso
            Cancelar();
        }

        #endregion 

        #region CONFIRMA CONTEO FISICO -------------------------//

        private void ConfirmaConteoFisico()
        {
            string IdUbicacion =Convert.ToString( txtUbicacion.Text.Trim());
            string IdProducto = Convert.ToString(txtCodProducto.Text.Trim());
            string IdUbicacionC, IdProductoC;
            int n_list = 0, n_inv = 0;
            bool Bandera=false;
            int Correlativo=0;
            DateTime Fecha=DateTime.Now;
            int LargoCadena, Anaquel=0, Nivel=0;
            string Area="",Cadena="";
            int unidadesEnt;
            
            if (txtCodProducto.Text != "" && txtUbicacion.Text != "" && txtUnidades.Text != "" && txtConfUbicacion.Text != "")
            {
                foreach (var Item in listaProducto)
                {
                    IdProductoC = Convert.ToString(Item.codigo);
                    IdUbicacionC = Convert.ToString(Item.anaquel + Item.area + Item.nivel);

                    if (IdUbicacion == IdUbicacionC && IdProducto == IdProductoC)
                    {
                        Bandera = true;
                        Correlativo = Convert.ToInt32(Item.invFisicoDetPK.correl);
                        Fecha = Convert.ToDateTime(Item.invFisicoDetPK.fecha);
                        n_inv = Convert.ToInt32(Item.invFisicoDetPK.noInventario);
                        n_inv = Convert.ToInt32(Item.invFisicoDetPK.noListado);

                    }
                   
                }


                //Pregunta si la bandera es verdadera o false

                if (Bandera == true)
                {
                  
                   //obtiene el Largo de la Ubicacion
                    LargoCadena=txtUbicacion.Text.Length;
                    //Obtiene el valor de la Ubicacion
                    Cadena=Convert.ToString(txtUbicacion.Text.Trim());
                    //Unidades encontradas
                    CodigoProducto = Convert.ToString(txtCodProducto.Text);
                    unidadesEnt=Convert.ToInt32(txtUnidades.Text);
                   
                    if (LargoCadena==4)
                    {
                        Anaquel=  Convert.ToInt32(Cadena.Substring(0,2));
                        Area=Convert.ToString(Cadena.Substring(2,1));
                        Nivel=  Convert.ToInt32(Cadena.Substring(3,1));
                    }
                    else  if (LargoCadena==3)
                    {
                        Anaquel=  Convert.ToInt32(Cadena.Substring(0,1));
                        Area=Convert.ToString(Cadena.Substring(1,1));
                        Nivel=  Convert.ToInt32(Cadena.Substring(2,1));
                    }
                    bool resultado = proxy.registrarConteoFisico(Compa, Fecha, true, Bodega, Correlativo, CodigoProducto, Anaquel, Area, Nivel, unidadesEnt, n_inv, n_list);
                    if (resultado == true)
                    {
                        
                        MessageBox.Show("Cantidad de producto ha sido confirmada");
                        limpiaTXT();
                    }
                    else
                    {
                        MessageBox.Show("Cantidad de producto no ha podido ser confirmada");
                        limpiaTXT();
                    }
                }
                else
                {
                    MessageBox.Show("Ubicación o código de producto no coinciden");
                    limpiaTXT();
                }
                
            }
            else
            {
                MessageBox.Show("Todos lo campos son obligatorios");
            }
        }

        #endregion
     
        #region CARGAR DATOS ------------------------//

        private void cargarDatos()
        {
            try
            {
                listaProducto = proxy.findUbicacionesUsuario(UsuarioSistema).ToList<invFisicoDet>();
                dgProdRecuento.DataSource = crearGrid();
            }
            catch (Exception)
            { 
            //Se ha producido una exepcion
            }

        }

        #endregion

        #region CREANDO EL DATAGRID CON SU VALORES ---------------------------------//

        private DataTable crearGrid()
        {

            DataTable dt = new DataTable();
            //Nombrando las columnas que tendra el Datable 
            dt.Columns.Add("Fecha");
            dt.Columns.Add("Código");
            dt.Columns.Add("Producto");
            dt.Columns.Add("U. Medida");
            dt.Columns.Add("Ubicación");



            //Creando una fila por cada recorredo
            DataRow row = dt.NewRow();
            //Recorriendo las lista que devuelve el metodo
            foreach (var Item in listaProducto)
            {
                row = dt.NewRow();
                
                

                row["Fecha"] = Item.invFisicoDetPK.fecha;
                row["Código"] = Item.codigo;
                row["Producto"] = Item.descripcion;
                row["U. Medida"] = Item.umedida;
                row["Ubicación"] = Item.anaquel + Item.area + Item.nivel;
                //Agregando la Fila al Datatable
                dt.Rows.Add(row);
            }


            //Retorna el Datatable
            return dt;

        }
        #endregion

        private void txtConfUbicacion_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {
                ConfirmaConteoFisico();
            }
            if (e.KeyCode == Keys.Up)
            {
                txtUnidades.Focus();
            }
        }

        #region LIMPIA TXT-------------------------//

        private void limpiaTXT()
        {
            txtUbicacion.Text = "";
            txtCodProducto.Text = "";
            txtUnidades.Text = "";
            txtConfUbicacion.Text = "";
            txtUbicacion.Focus();
        }

        #endregion

        private void txtUbicacion_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter || e.KeyCode == Keys.Down)
            {
                txtCodProducto.Focus();
            }
        }

        private void txtCodProducto_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter || e.KeyCode == Keys.Down)
            {
                txtUnidades.Focus();
            }
            if (e.KeyCode == Keys.Up)
            {
                txtUbicacion.Focus();
            }
        }

        private void txtUnidades_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter || e.KeyCode == Keys.Down)
            {
                txtConfUbicacion.Focus();
            }
            if (e.KeyCode == Keys.Up)
            {
                txtCodProducto.Focus();
            }
        }

        private void dgProdRecuento_KeyUp(object sender, KeyEventArgs e)
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
            int Indice = dgProdRecuento.CurrentRowIndex;
            txtCodProducto.Text = dgProdRecuento[Indice, 1].ToString();
            txtUbicacion.Text = dgProdRecuento[Indice, 4].ToString();
        }

        private void dgProdRecuento_Click(object sender, EventArgs e)
        {
            clicGRID();
        }
    }
}