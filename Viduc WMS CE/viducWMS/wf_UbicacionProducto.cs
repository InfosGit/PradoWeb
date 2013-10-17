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
    public partial class wf_UbicacionProducto : Form
    {
        //Inicialización de Variables Globales
        public static int Compa;
        public static int Solicitudes;
        public static int Ordenes;
        public static int BodegaActual;
        public static string codProduct;
        public static string Anaquel;
        public static string Area;
        public static string Nivel;
        public static int Cantidades;
        public static string EstadoProducto;
        public static string ubicaciones;
        public static string Descrip;
        public static string UsuarioSistema;

        VIDUCWebService Proxy = new VIDUCWebService();
        List<datosProductoSolicitudRecepcion> DatosProducto = new List<datosProductoSolicitudRecepcion>();

        public wf_UbicacionProducto(int Compania, int solicitud, int Bodegas, string Usuario)
        {
            try
            {
                // Inicialización del Formulario y Asignación de Información
                CargarDatos(Compania, solicitud, Bodegas);
                this.dataGrid1.Focus();
                UsuarioSistema = Usuario;
                
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
        private void btnRuta_Click(object sender, EventArgs e)
        {
            CambiarRuta();
        }
        private void btnAceptar_Click(object sender, EventArgs e)
        {
            GuadarDatos();
        }
        private void dataGrid1_Click(object sender, EventArgs e)
        {
            ClickGrid();
        }
        private void dataGrid1_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Asigna Valores de Comparacion  por teclas
            char? letter = e.KeyChar;
            char? tab = '\t';
            char? enter = '\r';
            char? Cero = '0';
            char? Numeral = '#';
            char? Asterisco = '*';

            //Asigna Valores de Comparacion  por teclas
            if (letter == tab)
            {
                ClickGrid();
                dataGrid1.Focus();

            }
            else if (letter == enter)
            {
                GuadarDatos();
            }
            else if (letter == Cero)
            {
                CambiarRuta();
            }
            else if (letter == Numeral)
            {
                Cancelar();
            }
            else if (letter == Asterisco)
            {
                if (codProduct == "")
                {
                    MessageBox.Show("Seleccione Un Producto");
                }
                else
                {
                   
                }
            }

        }
        private void wf_RecepcionProducto_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Asigna Valores de Comparacion  por teclas
            char? letter = e.KeyChar;
            char? tab = '\t';
            char? enter = '\r';
            char? Cero = '0';
            char? Numeral = '#';

            //Asigna Valores de Comparacion  por teclas
            if (letter == tab)
            {
                ClickGrid();
                dataGrid1.Focus();

            }
            else if (letter == enter)
            {
                GuadarDatos();
            }
            else if (letter == Cero)
            {
                CambiarRuta();
            }
            else if (letter == Numeral)
            {
                Cancelar();
            }
        }
        private void btnComentario_Click(object sender, EventArgs e)
        {
            if (codProduct == "")
            {
                MessageBox.Show("Seleccione un Producto");
            }
           
        }

        private void ClickGrid()
        {
            try
            {
                int Index = dataGrid1.CurrentRowIndex;
                codProduct = Convert.ToString(dataGrid1[Index, 0].ToString());
                Cantidades = Convert.ToInt32(dataGrid1[Index, 1].ToString());
               // lblProducto.Text = "Producto: " + dataGrid1[Index, 2].ToString() + "  Cantidad: " + Cantidades.ToString();
                Anaquel = dataGrid1[Index, 3].ToString();
                Area = dataGrid1[Index, 3].ToString();
                Nivel = dataGrid1[Index, 3].ToString();
                ubicaciones = dataGrid1[Index, 3].ToString();
                Descrip = dataGrid1[Index, 2].ToString();
            }
            catch (Exception )
            {
                MessageBox.Show("Seleccione una Fila");
            }
        }
     
        private void CargarDatos(int Compania, int solicitud, int Bodegas)
        {
            try
            {
                InitializeComponent();
                Compa = Compania;
                Solicitudes = solicitud;
                BodegaActual = Bodegas;
                DatosProducto = Proxy.findProductosSolicitudRecepcionAreaRecibir(Compa, true, Solicitudes, true).ToList<datosProductoSolicitudRecepcion>();

                dataGrid1.DataSource = CargarTabla();
            }
            catch (Exception )
            {
                MessageBox.Show(clsMensajesGenerales.noDatos());
            }
        }
        private void CambiarRuta()
        {
            if (codProduct == "")
            {
                MessageBox.Show("Seleccione un producto");
            }
            else
            {


                // Activa el Formulario de Menu
                wf_Ubicaciones Menu = new wf_Ubicaciones(Compa, Solicitudes, BodegaActual, codProduct, Cantidades, UsuarioSistema, "");
                Menu.Show();
                Menu.Activate();

                //oculta el Formulario Actual
                this.Visible = false;
            }
        }
        private void Cancelar()
        {


            // Activa el Formulario de RecepcionProducto
            wf_RecepcionProducto Menu = new wf_RecepcionProducto(Compa, BodegaActual, UsuarioSistema);
            Menu.Show();
            Menu.Activate();
            //oculta el Formulario Actual
            this.Visible = false;
        }
        private DataTable CargarTabla()
        {

            DataTable dt = new DataTable();
            dt.Columns.Add("Código");
            dt.Columns.Add("Cantidad");
            dt.Columns.Add("Descripción");
            dt.Columns.Add("Estado");

            DataRow row = dt.NewRow();
            foreach (var item in DatosProducto)
            {
                row = dt.NewRow();
                row["Código"] = item.codProducto.ToString();
                row["Descripción"] = item.nomProducto.ToString();
                row["Cantidad"] = item.cantidad.ToString();
                row["Estado"] = item.estProducto.ToString();
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
                Proxy.actualizarExistenciasBodega(Compa, true, Solicitudes, true, Cantidades, true, codProduct, BodegaActual,true,  Convert.ToInt32(Anaquel1), true, Area1, Convert.ToInt32(Nivel1), true, "S", UsuarioSistema, out Valor, out Valor);
                if (Valor == true)
                {
                    MessageBox.Show("Proceso Realizado Correctamente");
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

    }
}