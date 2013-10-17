using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.ws_Servicios;
using biliotecaVIDUC;
using VIDUC;

namespace viducWMS
{
    public partial class wf_UbicacionesTransalado : Form
    {
        //inicialización de Variables Globales
        viducWMS.ws_Servicios.VIDUCWebService Proxy = new viducWMS.ws_Servicios.VIDUCWebService();
        List<datosProductoSolicitudRecepcion> DatosBodega = new List<datosProductoSolicitudRecepcion>();
        public static int Compa;
        public static int Ordenes;
        public static int BodegaPeticion;
        public static string UbicacionNueva;
        public static string Producto;
        public static string Anaquel;
        public static string Area;
        public static string Nivel;
        public static int UnidadesExistentes;
        public static string UsuarioSistema;

        public wf_UbicacionesTransalado(int Compania, int Orden, int Bodegas, string CodProd, int Unidad, string Usuario)
        {
            try
            {
                InitializeComponent();
                Compa = Compania;
                Ordenes = Orden;
                BodegaPeticion = Bodegas;
                Producto = CodProd;
                UnidadesExistentes = Unidad;
                DatosBodega = Proxy.findUbicacionesBodegaSugeridasProducto(Compa, true, BodegaPeticion, true, Producto).ToList<datosProductoSolicitudRecepcion>();
                UsuarioSistema = Usuario;
                dgUbicaciones.DataSource = CargarTabla();
                dgUbicaciones.Focus();
                dgUbicaciones.SelectionBackColor = Color.Green;
            }
            catch (Exception )
            {
                MessageBox.Show(clsMensajesGenerales.noDatos());
            }
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Cancelar();
        }



        private void dgUbicaciones_Click(object sender, EventArgs e)
        {
            ClickGrid();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            GuadarDatos();
        }

        private void dgUbicaciones_KeyPress(object sender, KeyPressEventArgs e)
        {
            char? letter = e.KeyChar;
            char? tab = '\t';
            char? enter = '\r';
            char? Numeral = '#';
            char? Asterisco = '*';

            if (letter == tab)
            {
                ClickGrid();
                dgUbicaciones.Focus();

            }
            else if (letter == enter)
            {
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

     
        private DataTable CargarTabla()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("ID");
            dt.Columns.Add("Descripción");
            dt.Columns.Add("Bodega");



            DataRow row = dt.NewRow();
            foreach (var item in DatosBodega)
            {
                row = dt.NewRow();
                row["ID"] = item.codBodega.ToString();
                row["Descripción"] = item.ubicacion.ToString();
                row["Bodega"] = item.codBodega.ToString();
                dt.Rows.Add(row);
            }

            return dt;

        }
        private void GuadarDatos()
        {
            try
            {
                string Anaquel1 = Anaquel.Substring(0, 1);
                string Area1 = Area.Substring(1, 1);
                string Nivel1 = Nivel.Substring(2, 1);


                bool Valor;
                Proxy.actualizarExistenciasBodega(Compa, true, Ordenes, true, UnidadesExistentes, true, Producto,  BodegaPeticion,true, Convert.ToInt32(Anaquel1), true, Area1, Convert.ToInt32(Nivel1), true, "S", UsuarioSistema, out Valor, out Valor);
                if (Valor == true)
                {
                    Cancelar();
                }
                else
                {
                    MessageBox.Show("No Se Pudo Efectuar El Proceso");
                }


            }
            catch (Exception )
            {
                MessageBox.Show("Datos No Seleccionados", "Error", MessageBoxButtons.OK, MessageBoxIcon.Hand, MessageBoxDefaultButton.Button1);

            }
        }
        private void ClickGrid()
        {
            try
            {
                int Index = dgUbicaciones.CurrentRowIndex;
                UbicacionNueva = dgUbicaciones[Index, 0].ToString();
                Anaquel = dgUbicaciones[Index, 1].ToString();
                Area = dgUbicaciones[Index, 1].ToString();
                Nivel = dgUbicaciones[Index, 1].ToString();
                dgUbicaciones.SelectionBackColor = Color.Green;
            }
            catch (Exception )
            {
                MessageBox.Show("Seleccione Una Fila");
            }
        }
        private void Cancelar()
        {

            //// Activa el Formulario de Menu
            //wf_Traslado Menu = new wf_Traslado(Compa, Ordenes, BodegaPeticion, UsuarioSistema);
            //Menu.Show();
            //Menu.Activate();


            //oculta el Formulario Actual
            this.Visible = false;
        }

    }
}