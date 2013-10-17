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
    public partial class wf_DatosProductoUbicacion : Form
    {
        //inicialización de Variables Globales
        public static string Bode;
        public static int Compa;
        public static string UsuarioSistema;


        public wf_DatosProductoUbicacion(string CodProducto, string Cantidad, string ubicacion, string Descripcion, int Compania, string Bodega, string Usuario)
        {
            try
            {
                //Incialización del Formulario y asignacion de valores
                InitializeComponent();
                Bode = Bodega;
                Compa = Compania;
                UsuarioSistema = Usuario;
                CargaDatos(CodProducto, Cantidad, ubicacion, Descripcion);
            }
            catch (Exception )
            {
                MessageBox.Show("Error de Comunicación");
            }

        }
        private void btnSalir_Click(object sender, EventArgs e)
        {
            Cancelar();
        }
        private void btnAceptar_Click(object sender, EventArgs e)
        {
            CargarDatos();
        }

        private void CargarDatos()
        {
            int Cantidad;
            if (txbCantidadReal.Text.Length == 0)
            {
                Cantidad = Convert.ToInt32(txbCantidad.Text);
            }
            else
            {
                try
                {
                    Cantidad = Convert.ToInt32(txbCantidadReal.Text);
                }
                catch (Exception )
                {
                    MessageBox.Show("Digite Un Valor Entero/Númerico");
                    txbCantidadReal.Text = "";
                }
            }
        }
        private void Cancelar()
        {

            //// Activa el Formulario de Menu


            //wf_ProductoUbicacion menu = new wf_ProductoUbicacion(Compa, Bode, UsuarioSistema);
            //menu.Show();
            //menu.Activate();

            ////oculta el Formulario Actual
            //this.Visible = false;
        }
        private void CargaDatos(string CodProducto, string Cantidad, string Descripcion, string ubicacion)
        {
            //Asignando Valores a Textbox
            txbCodProducto.Text = CodProducto;
            txbCantidad.Text = Cantidad;
            txbDescripcion.Text = Descripcion;
            txbUbicacion.Text = ubicacion;
        }

        private void txbCodProducto_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter || e.KeyCode == Keys.Down)
            {
                txbCantidad.Focus();
            }
        }

        private void txbCantidad_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter || e.KeyCode == Keys.Down)
            {
                txbUbicacion.Focus();
            }
            if (e.KeyCode == Keys.Up)
            {
                txbCodProducto.Focus();
            }
        }

        private void txbUbicacion_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter || e.KeyCode == Keys.Down)
            {
                txbDescripcion.Focus();
            }
            if (e.KeyCode == Keys.Up)
            {
                txbCantidad.Focus();
            }
        }

        private void txbDescripcion_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter || e.KeyCode == Keys.Down)
            {
                txbCantidadReal.Focus();
            }
            if (e.KeyCode == Keys.Up)
            {
                txbUbicacion.Focus();
            }
        }

        private void txbCantidadReal_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {
                CargarDatos();
            }
            if (e.KeyCode == Keys.Up)
            {
                txbDescripcion.Focus();
            }
        }

    }
}