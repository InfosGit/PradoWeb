using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.ws_Servicios;
using System.IO;
using System.Reflection;
using System.Windows.Forms.Layout;
using VIDUC;
using colorFilaGrid.colorFila;



 



//--- Set the Decode Assembly Namespace(s) ---


namespace viducWMS
{
    public partial class wf_RecepcionProducto : Form
    {


        #region VARIABLES GLOBALES ---------------------------------//
        //inicialización de Variables Globales
        private static int Compa;
        private static int Solicitudes=0;
        private static int BodegaActual;
        //Codigo del prodcuto
        private static string codProduct;
        // private static string Anaquel;
        // private static string Area;
        // private static string Nivel;
        private static int Cantidades;
        // Obtiene la descripcion del producto
        private static string Descrip;
        // Obtiene el Usuario que se esta conectando
        private static string UsuarioSistema;
        // Private static string CodigoProducto;
        private static int OrdenCompra;
        // Nombre de la proforma
        private static string Nombre;
        private static string Cod;       

        #endregion

        #region Llamando la capa de servicios ----------------------------//
        
            viducWMS.ws_Servicios.VIDUCWebService Proxy = new viducWMS.ws_Servicios.VIDUCWebService();
            List<viducWMS.ws_Servicios.ubicacionProducto> DatosProducto = new List<viducWMS.ws_Servicios.ubicacionProducto>();
            List<viducWMS.ws_Servicios.ubicacionProducto> DatosBusqueda = new List<viducWMS.ws_Servicios.ubicacionProducto>();
        
        #endregion

        #region Metodo General de Parametros --------//

             //Se pasa los parametros al metodo general   
         public wf_RecepcionProducto(int Compania, int Bodegas, string Usuario)
        {
              InitializeComponent();
                //Incialización del Formulario y asignacion de valores
                 
                 UsuarioSistema = Usuario;
                 Compa = Compania;
                 BodegaActual = Bodegas;
                 //Carga todos los datos
                 CargarDatos();
                 //Envia el focus para el scaneo de producto
                 //txbProducto.Focus();
                 dgProductos.Focus();
                 clicGRID();

                

        }
           
            #endregion
         private void clicGRID()
         {
             int Indice = dgProductos.CurrentRowIndex;
             txbProducto.Text = dgProductos[Indice, 0].ToString() + " - " + dgProductos[Indice,1].ToString();
             Cod = dgProductos[Indice, 0].ToString();
             
         }

        #region ACCIONES DE CLIC --------------------------------//

         private void btnSalir_Click(object sender, EventArgs e)
        {
            Cancelar();
        }       
        
      
    
        
       
       
        private void btnComentario_Click(object sender, EventArgs e)
        {
            Descripcion(Cod);
            if (codProduct == "")
            {
                MessageBox.Show(clsMensajesGenerales.Producto());
            }
            
        }
        
        private void lblProducto_KeyPress(object sender, KeyPressEventArgs e)
        {
            KeyPressGrid(e);
        }
       
        private void KeyPressGrid(KeyPressEventArgs e)
        {
            //Asigna Valores de Comparacion  por teclas
            char? letter = e.KeyChar;
            char? tab = '\t';
            char? Numeral = '#';
            char? Asterisco = '*';

            //Realiza la Asignación de Funcionalidad
            if (letter == tab)
            {
                ClickGrid();
                dgProductos.Focus();

            }
           
            else if (letter == Numeral)
            {
                Cancelar();
            }
            else if (letter == Asterisco)
            {
                Descripcion(Cod);
                if (codProduct == "")
                {
                    MessageBox.Show(clsMensajesGenerales.FilaNoValida());
                }
               
            }
        }

                #endregion
   
        #region CUANDO DA CLIC EN EL GRID
        
        private void ClickGrid()
        {
            try
            {
                // Inicializa Variables con Valores del Grid
                int Index = dgProductos.CurrentRowIndex;
                txbProducto.Text = dgProductos[Index, 1].ToString();
                OrdenCompra =Convert.ToInt32(dgProductos[Index, 0].ToString());
                txbProducto.Focus();
            }
            catch (Exception)
            {
                MessageBox.Show(clsMensajesGenerales.FilaNoValida());
            }
        }

        #endregion
      
        #region CARGA LOS DATOS EN EL GRID --------------------------//
        //Caragar datos 3n 3l GRID
        private void CargarDatos()
        {
            try
            {
             DatosProducto = Proxy.findProductosAreaRecepcion(Compa, BodegaActual).ToList<ubicacionProducto>();
             dgProductos.DataSource = CargarTabla();

            }
            catch (Exception )
            {
               
              //Excepcion
            }
        }

        #endregion

        #region SE CREA EN GRID MANUALMENTE ---------------------------------//

         private DataTable CargarTabla()
        {

           //--------------- Cracion de tablas --------------------//
            
            DataTable dt = new DataTable();
            
            dt.Columns.Add("Código"); // Muestra el codigo del producto
            dt.Columns.Add("Descripción"); // Descripcion
            dt.Columns.Add("U.Medida"); // Unidad de Medida
            dt.Columns.Add("Unidades en existencia"); // Unidades en existencia
                  
            DataRow row;

            foreach (var item in DatosProducto)
            {
                row = dt.NewRow();
                
                //--------------- Revisar documento --------------------//
                row["Código"] = item.productos.productosPK.codProd.ToString();
                row["Descripción"] = item.productos.nombre.ToString();
                row["U.Medida"] = item.productos.unidadMedida;
                row["Unidades en existencia"] = item.cantidad.ToString();
               
                dt.Rows.Add(row);

              }
            

                
            return dt;

        }

        #endregion

        #region CANCELAR EL PRODUCTO ------------------------------//
         
          private void Cancelar()
        {

            // Activa el Formulario de Bodegas
            wf_menuRecepcion Menu = new wf_menuRecepcion(Compa, BodegaActual, UsuarioSistema);
            Menu.Show();
            Menu.Activate();

            //oculta el Formulario Actual
            this.Visible = false;
        }

         #endregion

        #region Descripcion y cantidad de productos -------------------------//

        private void Descripcion(string cod)
        {
            Boolean Bandera = false;
            string CodigoProducto="";

            try
            {
              //  DatosBusqueda = Proxy.findProductosAreaRecepcion(Compa,BodegaActual).ToList<ubicacionProducto>();
                //Obteniendo el codigo del producto que se esta escaneando
                CodigoProducto =cod;
              
                 

                        foreach (var item in DatosProducto)
                        {
                            if (item.productos.productosPK.codProd == CodigoProducto)
                            {
                                Bandera = true;
                                //Obteniendo el codigo de producto
                                codProduct = Convert.ToString(item.productos.productosPK.codProd);
                                //Descripcion de todo Producto 
                                txbProducto.Text = codProduct+" - " + item.productos.nombre.ToString();
                                Cantidades = Convert.ToInt32(item.cantidad);
                                Nombre = item.productos.nombre.ToString();
                               // Descripcion 
                                Descrip = item.productos.nombre.ToString();
                               

                            }

                        }
                    //Cierra el If que determina si la lista no devuelve ningun resultado

                        if (Bandera == true)
                        {
                            if (Cantidades != 0)
                            {
                                // Activa el Formulario de Ubicaciones
                                wf_Ubicaciones Menu = new wf_Ubicaciones(Compa, Solicitudes, BodegaActual, codProduct, Cantidades, UsuarioSistema, Nombre);
                                Menu.Show();
                                Menu.Activate();

                                //oculta el Formulario Actual
                                this.Visible = false;
                            }
                            else
                            {
                                MessageBox.Show(clsMensajesGenerales.ProductoUbicado());


                            }
                        }
                       else
                        {
                            CodigoProducto = "";
                            txbProducto.Text = "";
                            MessageBox.Show("Producto. no pertenece al listado que esta pendiente de ubicación");
                            txbProducto.Focus();
                            
                        }

                
            }
            catch (Exception)
            {
                    //Erro que se ha producido
                    txbProducto.Focus();
            }
        }

        #endregion

        #region COLOR FILA
        private void colorFila()
        {

            try
            {
                //clsColorFilaGrid col = new clsColorFilaGrid(dgProductos);
                //col.ColorEspecial = Color.Green;
                //col.ColorOriginal = Color.YellowGreen;
                //col.ColorTextoEspecial = Color.WhiteSmoke;
                //col.ColorTextoOriginal = Color.Black;
                //col.TextoAEvaluar = "U";
            }
            catch (Exception)
            { 
            //Mensaje de error colores del GRID no funcionan
            }


        }
        #endregion

        private void wf_RecepcionProducto_Load(object sender, EventArgs e)
        {
           //Muestra el color de la fila
            colorFila();
        }

        private void txbProducto_KeyUp(object sender, KeyEventArgs e)
        {


            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {
                
                //Determina que no deje vacio el codigo del producto
                if (txbProducto.Text.Trim() != "")
                {
                    int l = Cod.Length;
                    int id = Convert.ToInt32(txbProducto.Text.Trim().Substring(0,l));
                    if (Cod == id.ToString().Substring(0, l))
                    {
                        
                        //Muestra la descripcion del producto
                        Descripcion(Cod);
                    }
                    else
                    {
                        Cod = id.ToString();
                        //Muestra la descripcion del producto
                        Descripcion(Cod);
                    }
                 }
                else
                {
                    //LLeva el focus al producto
                    txbProducto.Focus();
                }
            }
        }

        private void dgProductos_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Up || e.KeyCode == Keys.Down)
            {              
                clicGRID();
            }

            if (e.KeyCode == Keys.Enter)
            {
                txbProducto.Focus();
            }
        }

        private void dgProductos_Click(object sender, EventArgs e)
        {
            if (dgProductos.VisibleRowCount > 0)
            {
                clicGRID();
            }
        }


    }
}