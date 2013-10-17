using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.ws_Servicios;

using Symbol.Barcode;
using biliotecaVIDUC;
using VIDUC;

namespace viducWMS
{
    public partial class wf_BusquedaProducto : Form
    {
        //Inicialización de Variables Globales
        VIDUCWebService Proxy = new VIDUCWebService();
        
        List<productos> BusquedaProducto = new List<productos>();
        

        public static int Compa;
        public static int Ordenes;
        public static int codProduct;
        public static string NombreProducto;
        public static int BodegaPeticion;
        public static string Anaquel;
        public static string Area;
        public static string Nivel;
        public static int Cantidades;
        public static string EstadoProducto;
        public static string ubicaciones;
        public static string Descrip;
        public static string UsuarioSistema;
        /// <summary>
        /// Declaración de Variables para Código de Barras
        /// </summary>
     

        public wf_BusquedaProducto(int Compania,  int Bodega, string Usuario, string Producto)
        {
            try
            {
                //Asignación de Valores a Variables Globales
                InitializeComponent();
                Compa = Compania;
                Ordenes = 2;
                BodegaPeticion = Bodega;
                UsuarioSistema = Usuario;
                txbDescripcion.Text = Producto;
                if (Producto != "")
                {
                    GridBusqueda(Producto);
                }
            }
            catch (Exception )
            {
                MessageBox.Show(clsMensajesGenerales.noDatos());
            }
        }

      

        #region OPCIONES DE CLIC ----------------------------///

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Cancelar();
        }
      

        #endregion
        
        #region CANCELAR -------------------------//
        private void Cancelar()
        {

            //txbCantidad.Text = "";
            // Activa el Formulario de SubMenu
            wf_SubMenu Menu = new wf_SubMenu(Compa, BodegaPeticion, UsuarioSistema);
            Menu.Show();
            Menu.Activate();

            //oculta el Formulario Actual
            this.Visible = false;
        }
        #endregion 

        #region CLIC EN EL GRID-------------------------//
       
        private void ClickGrid()
        {
            try
            {
                int Indice = dgProductos.CurrentRowIndex;
                string CodPro, Nombre, Marca;

                CodPro = dgProductos[Indice, 0].ToString();
                Nombre = dgProductos[Indice, 1].ToString();
                Marca = dgProductos[Indice, 2].ToString();

                // Activa el Formulario de DatosProducto

                wf_BusquedaProductoDet Menu = new wf_BusquedaProductoDet(Compa,BodegaPeticion, UsuarioSistema, CodPro, Nombre, Marca);
                Menu.Show();
                Menu.Activate();
                //oculta el Formulario Actual
                this.Visible = false;

            }
            catch (Exception)
            {
                MessageBox.Show("Seleccione Una Fila");
            }
        }
        #endregion

        #region CARGANDO DATOS DEL RESULTADO DE LA BUSQUEDA ----------------------//

        private void GridBusqueda( string Nombre)
        {

            try
            {
                if (txbDescripcion.Text != "")
                {
                    BusquedaProducto = Proxy.findProductosByNombre(Compa, Nombre).ToList<productos>();
                    dgProductos.DataSource = creandoGridBusqueda();
                   
                }
                
            }
            catch (Exception)

            {
                MessageBox.Show(clsMensajesGenerales.noDatos());
                dgProductos.DataSource = null;
                txbDescripcion.Text = "";
                txbDescripcion.Focus();
            }

        }

        #endregion

        #region CREANDO EN GRID DE BUSQUEDA -----------------------//

        private DataTable creandoGridBusqueda()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("Código");
            dt.Columns.Add("Descripción");
            dt.Columns.Add("Marca");


            DataRow row = dt.NewRow();
            foreach (var item in BusquedaProducto)
            {
                row = dt.NewRow();

                row["Código"] = item.productosPK.codProd;
                row["Descripción"] = item.nombre;
                row["Marca"] = item.marcas.desMarca.ToString();
                

                dt.Rows.Add(row);
            }

            return dt;

        }
        #endregion

        private void btnBuscar_Click(object sender, EventArgs e)
        {
           
            GridBusqueda(txbDescripcion.Text);
        }

        private void dgProductos_DoubleClick(object sender, EventArgs e)
        {
            ClickGrid();
        }



        private void txbDescripcion_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter)
            {

                     GridBusqueda(txbDescripcion.Text);

            }
        }

       

        

    }
}