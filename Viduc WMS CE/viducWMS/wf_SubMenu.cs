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
    public partial class wf_SubMenu : Form
    {
        //Inicialización de Variables Globales
        public static int Compa;
        public static int Ordenes;
        public static int BodegaPeticion;
        public static string codProduct;
        public static string UsuarioSistema;
        viducWMS.ws_Servicios.VIDUCWebService Proxy = new viducWMS.ws_Servicios.VIDUCWebService();
        List<datosSolicitudRecepcion> DatosProducto = new List<datosSolicitudRecepcion>();

        public wf_SubMenu(int Compania, int Bodegas, string Usuario)
        {
            try
            {
                // Inicialización del Formulario y Asignación de Información
                InitializeComponent();
                Compa = Compania;
                BodegaPeticion = Bodegas;
                UsuarioSistema = Usuario;
                //---------------------------------Corregir esta vaina-------------------------///////
                int Estado= 1; 
                DatosProducto = Proxy.findSolicitudesRecepcionBodega(Compa, true, BodegaPeticion, true, Estado, true).ToList<datosSolicitudRecepcion>();

            }
            catch (Exception )
            {
               // MessageBox.Show("Error de Comunicación");

            }
        }
        private void btnCerrar_Click(object sender, EventArgs e)
        {
            Cancelar();
        }
        private void btnProductos_Click(object sender, EventArgs e)
        {
            MostrarProducto();
        }
        private void btnCategoria_Click(object sender, EventArgs e)
        {
            MostrarProductoCategoria();
        }
       
        private void wf_SolicitudInventario_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Asigna Valores de Comparacion  por teclas
            char? letter = e.KeyChar;
            char? Categoria = '1';
            char? Todos = '2';
            char? Numeral = '#';

            //Asigna Valores de Comparacion  por teclas
            if (letter == Todos)
            {
                MostrarProducto();

            }
            else if (letter == Categoria)
            {
                MostrarProductoCategoria();

            }
           
            else if (letter == Numeral)
            {
                Cancelar();
            }
        }

        private void MostrarProducto()
        {

            // Activa el Formulario de Busqueda de Producto
            wf_BusquedaProducto Menu = new wf_BusquedaProducto(Compa, BodegaPeticion, UsuarioSistema, "");
            Menu.Show();
            Menu.Activate();


            //oculta el Formulario Actual
            this.Visible = false;
        }
        private void MostrarProductoCategoria()
        {

            //// Activa el Formulario de Producto Categoria
            //wf_ProductoCategoriaB Menu = new wf_ProductoCategoriaB(Compa, BodegaPeticion, UsuarioSistema);
            //Menu.Show();
            //Menu.Activate();


            ////oculta el Formulario Actual
            //this.Visible = false;
        }
        
        private void Cancelar()
        {

            // Activa el Formulario de _Menu de Consulta
            wf_MenuConsulta Menu = new wf_MenuConsulta(Compa, BodegaPeticion, UsuarioSistema);
            Menu.Show();
            Menu.Activate();


            //oculta el Formulario Actual
            this.Visible = false;
        }

        private void btnUbicacion_Click(object sender, EventArgs e)
        {

        }

    }
}