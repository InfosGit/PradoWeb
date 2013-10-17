using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using VIDUC;
using viducWMS.ws_Servicios;

namespace viducWMS
{
    public partial class wf_ProductosTrasladar : Form
    {



        #region VARIABLES GLOBALES ---------------------------------//
        //inicialización de Variables Globales
        public static int Compa;
        public static int Solicitudes;
        public static string BodegaActual;
        public static int codProduct;
        public static string Anaquel;
        public static string Area;
        public static string Nivel;
        public static int Cantidades;
        public static string EstadoProducto;
        public static string ubicaciones;
        public static string Descrip;
        public static string UsuarioSistema;
        public static string CodigoProducto;
        public static int UnidadesSolicitadas;

        #endregion

        #region Llamando la capa de servicios ----------------------------//

        viducWMS.ws_Servicios.VIDUCWebService Proxy = new viducWMS.ws_Servicios.VIDUCWebService();
        List<detSolicitud> detalleSolicitud = new List<detSolicitud>();


        #endregion

        #region Metodo general  de paso de parametros -----------//

        public wf_ProductosTrasladar(int Compania, int Solicitud, string Usuario)
        {
            InitializeComponent();
            Compa = Compania;
            Solicitudes = Solicitud;
            UsuarioSistema = Usuario;
        }

        #endregion

        #region CARGAR DATOS
        private void CargarGrid()
        {
            try
            {
                
                detalleSolicitud = Proxy.findDetallesSolicitud(Compa, true,Solicitudes,true ).ToList<detSolicitud>();
                //Cargar los productos en el GRID
                dgProductosTrasladar.DataSource = crearGrid();
                dgProductosTrasladar.Refresh();
                dgProductosTrasladar.Parent.Refresh();
            }
            catch (Exception)
            {
                //Notifica que la lista no encontro ningun valor
                MessageBox.Show(clsMensajesGenerales.noDatos());
            }
        }
        #endregion

        #region CREANDO EL GRID
        private DataTable crearGrid()
        {


            DataTable dt = new DataTable();
            dt.Columns.Add("Orden de compra");
            dt.Columns.Add("Código");
            dt.Columns.Add("Descripción");
            dt.Columns.Add("Cantidad solicitada");
            dt.Columns.Add("Cantidad recibida");
            dt.Columns.Add("Estado");

            DataRow row = dt.NewRow();
            foreach (var item in detalleSolicitud)
            {
                row = dt.NewRow();
                //*****************************************************************************************revisar ************************
           //     row["Orden de compra"] = item.detOrdenCompra.ordenCompra1.ordenCompraPK.id;
                row["Código"] = item.productos.productosPK.codProd.ToString();
                row["Descripción"] = item.productos.nombre.ToString();
                row["Cantidad solicitada"] = item.cantidadSolicitada.ToString();
                row["Cantidad recibida"] = item.cantidadRecibida.ToString();
                row["Estado"] = item.estado.ToString();
                dt.Rows.Add(row);


            }



            return dt;



        }
        #endregion

    }
}