using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.ws_Servicios;

namespace viducWMS
{
    public partial class wf_BusquedaProductoDet : Form
    {

        #region Variables -----------------------//
        public static string  Producto;
        public static string Usuario;
        public static int Bodega;
        public static string Marca;
        public static string NombreProducto;
        private static int Compania;

        //Inicialización de Variables Globales
        VIDUCWebService Proxy = new VIDUCWebService();
         List<ubicacionProducto> detalleProducto = new List<ubicacionProducto>();

        #endregion

        public wf_BusquedaProductoDet( int IdCompania, int IdBodega, string  IdUsuario, string  CodProd, string Nombre, string MarcaPro)
        {
            InitializeComponent();
            Producto =  CodProd;
            NombreProducto = Nombre;
            Bodega = IdBodega;
            Usuario = IdUsuario;
            Marca = MarcaPro;
            Compania=IdCompania;
            txtCodigo.Text = Producto;
            txtDescripcion.Text = NombreProducto;
            txtMarca.Text = Marca;
            GridBusqueda(Producto);

        }


        
        
        private void btnSalir_Click(object sender, EventArgs e)
        {
            Cancelar();
        }
        #region CARGANDO DATOS DEL RESULTADO DE LA BUSQUEDA ----------------------//

        private void GridBusqueda(string Nombre)
        {

            try
            {
               
                    detalleProducto = Proxy.findUbicacionesByProducto(Compania, txtCodigo.Text.Trim()).ToList<ubicacionProducto>();
                 
                     dgProductos.DataSource = creandoGridBusqueda();
                    
                   
               

            }
            catch (Exception)
            {
              //Error que genera cuando se compila
                dgProductos.DataSource = null;
            }

        }

        #endregion

        #region CREANDO EN GRID DE BUSQUEDA -----------------------//

        private DataTable creandoGridBusqueda()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("Ubicación");
            dt.Columns.Add("Cantidad");
  
            DataRow row ;
            foreach (var item in detalleProducto)
            {
                row = dt.NewRow();

                row["Ubicación"] = item.ubicacionProductoPK.anaquel + item.ubicacionProductoPK.area + item.ubicacionProductoPK.nivel;
                row["Cantidad"] = item.cantidad;
                dt.Rows.Add(row);
            }

            return dt;

        }
        #endregion


        #region CANCELAR -------------------------//
        private void Cancelar()
        {

            //txbCantidad.Text = "";
            // Activa el Formulario de SubMenu
            wf_BusquedaProducto Menu = new wf_BusquedaProducto(Compania, Bodega, Usuario, NombreProducto);
            Menu.Show();
            Menu.Activate();

            //oculta el Formulario Actual
            this.Visible = false;
        }
        #endregion
    }
}