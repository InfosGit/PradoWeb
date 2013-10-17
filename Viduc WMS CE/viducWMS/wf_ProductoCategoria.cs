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
    public partial class wf_ProductoCategoria : Form
    {
        public static string Bodegas;
        public static int Compania;
        public static int codProduct;
        public static string NombreProducto;
        public static string BodegaPeticion;
        public static string Anaquel;
        public static string Area;
        public static string Nivel;
        public static int Cantidades;
        public static string EstadoProducto;
        public static string ubicaciones;
        public static string Descrip;
        public static string UsuarioSistema;

        viducWMS.ws_Servicios.VIDUCWebService Proxy = new viducWMS.ws_Servicios.VIDUCWebService();
        List<datosProductoSolicitud> DatosProducto = new List<datosProductoSolicitud>();


        public wf_ProductoCategoria(int Compa, string BodegaPeticion, string Usuario)
        {
            try
            {
                InitializeComponent();
                Bodegas = BodegaPeticion;
                Compania = Compa;
                UsuarioSistema = Usuario;
                DatosProducto = Proxy.findProductosSolicitudRecepcion(Compa, true, 1, true).ToList<datosProductoSolicitud>();
                dataGrid1.DataSource = CargarTabla();
                dataGrid1.Focus();
                dataGrid1.SelectionBackColor = Color.Green;
            }
            catch (Exception )
            {
                MessageBox.Show("No Hay Datos a Mostrar");
            }

        }
        private void btnSalir_Click(object sender, EventArgs e)
        {
            //Cancelar();
        }
        private void btnAceptar_Click(object sender, EventArgs e)
        {
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
            char? Numeral = '#';

            //Asigna Valores de Comparacion  por teclas
            if (letter == tab)
            {
                ClickGrid();
                dataGrid1.Focus();

            }
            else if (letter == Numeral)
            {
                //Cancelar();
            }
        }
        private void wf_ProductoCategoria_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Asigna Valores de Comparacion  por teclas
            char? letter = e.KeyChar;
            char? tab = '\t';
            char? Numeral = '#';

            //Asigna Valores de Comparacion  por teclas
            if (letter == tab)
            {
                ClickGrid();
                dataGrid1.Focus();

            }
            else if (letter == Numeral)
            {
                //Cancelar();
            }
        }


        //private void Cancelar()
        //{
        //    // Activa el Formulario de SolicitudInventario
        //    wf_SolicitudInventario Menu = new wf_SolicitudInventario(Compania, Bodegas, UsuarioSistema);
        //    Menu.Show();
        //    Menu.Activate();


        //    //oculta el Formulario Actual
        //    this.Visible = false;
        //}

        private void ClickGrid()
        {
            try
            {
                int Index = dataGrid1.CurrentRowIndex;
                codProduct = Convert.ToInt32(dataGrid1[Index, 0].ToString());
                Cantidades = Convert.ToInt32(dataGrid1[Index, 1].ToString());
                Descrip = dataGrid1[Index, 2].ToString();
                Anaquel = dataGrid1[Index, 3].ToString();
                Area = dataGrid1[Index, 3].ToString();
                Nivel = dataGrid1[Index, 3].ToString();
                ubicaciones = dataGrid1[Index, 3].ToString();
                dataGrid1.SelectionBackColor = Color.Green;
             
            }
            catch (Exception )
            {
                MessageBox.Show("Seleccione Una Fila");
            }
        }
        private DataTable CargarTabla()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("Código");
            dt.Columns.Add("Cantidad");
            dt.Columns.Add("Descripción");
            dt.Columns.Add("Ubicación");

            DataRow row = dt.NewRow();
            foreach (var item in DatosProducto)
            {
                row = dt.NewRow();

                row["Código"] = item.codProducto.ToString();
                row["Descripción"] = item.nomProducto.ToString();
                row["Cantidad"] = item.cantidad.ToString();
                row["Ubicación"] = item.ubicacion.ToString();

                dt.Rows.Add(row);
            }

            return dt;

        }

    }
}