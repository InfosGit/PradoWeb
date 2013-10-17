using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace viducWMS
{
    public partial class wf_MenuConsulta : Form
    {
        //Inicialización de Variables Globales
        public static int Compa;
        public static int Ordenes;
        public static int Bodegas;
        public static string UsuarioSistema;

        public wf_MenuConsulta(int Compania, int BodegaPeticion, string Usuario)
        {
            try
            {
                // Inicialización del Formulario y Asignación de Información
                InitializeComponent();
                Compa = Compania;
                Bodegas = BodegaPeticion;
                UsuarioSistema = Usuario;
            }
            catch (Exception )
            {
               // MessageBox.Show("Error de Comunicación");
            }
        }

        private void btnProductos_Click(object sender, EventArgs e)
        {
          // MostrarInventario();
        }
        private void btnCerrar_Click(object sender, EventArgs e)
        {
            Cancelar();
        }
        private void wf_MenuConsulta_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Asigna Valores de Comparacion  por teclas
            char? letter = e.KeyChar;
            char? Categoria = '1';
            char? Todos = '2';
            char? Numeral = '#';

            //Asigna Valores de Comparacion  por teclas
            if (letter == Todos)
            {
              //  MostrarInventario();

            }
            else if (letter == Categoria)
            {
                MostrarBusqueda();

            }
            else if (letter == Numeral)
            {
                Cancelar();
            }
        }
        private void btnCategoria_Click(object sender, EventArgs e)
        {
            MostrarBusqueda();
        }


        private void Cancelar()
        {
            // Activa el Formulario de Menu
            wf_Menu Menu = new wf_Menu(Compa, Bodegas, UsuarioSistema);
            Menu.Show();
            Menu.Activate();


            //oculta el Formulario Actual
            this.Visible = false;
        }
        //private void MostrarInventario()
        //{
        //    // Activa el Formulario de Solicitud de Inventario
        //    wf_SolicitudInventario frm = new wf_SolicitudInventario(Compa, Bodegas, UsuarioSistema);
        //    frm.Show();
        //    frm.Activate();

        //    //oculta el Formulario Actual
        //    this.Visible = false;
        //}
        private void MostrarBusqueda()
        {
            // Activa el Formulario de SubMenu
            wf_SubMenu frm = new wf_SubMenu(Compa, Bodegas, UsuarioSistema);
            frm.Show();
            frm.Activate();

            //oculta el Formulario Actual
            this.Visible = false;
        }

        private void wf_MenuConsulta_KeyDown(object sender, KeyEventArgs e)
        {
            if ((e.KeyCode == System.Windows.Forms.Keys.Up))
            {
                // Up
            }
            if ((e.KeyCode == System.Windows.Forms.Keys.Down))
            {
                // Down
            }
            if ((e.KeyCode == System.Windows.Forms.Keys.Left))
            {
                // Left
            }
            if ((e.KeyCode == System.Windows.Forms.Keys.Right))
            {
                // Right
            }
            if ((e.KeyCode == System.Windows.Forms.Keys.Enter))
            {
                // Enter
            }

        }

        

    }
}