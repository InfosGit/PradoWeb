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
    public partial class wf_DatosProducto : Form
    {
        //inicialización de Variables Globales
        public static string Bode;
        public static int Compa;
        public static string UsuarioSistema;

        public wf_DatosProducto(string CodProducto, string Cantidad, string ubicacion, string Descripcion, int Compania, string Bodega, string Usuario)
        {
            try
            {
                //Incialización del Formulario y asignacion de valores
                InitializeComponent();
                Bode = Bodega;
                Compa = Compania;
                CargaDatos(CodProducto, Cantidad, ubicacion, Descripcion, Usuario);
            }
            catch (Exception )
            {
                MessageBox.Show("Error de Comunicación");
            }

        }

        private void CargaDatos(string CodProducto, string Cantidad, string ubicacion, string Descripcion, string Usuario)
        {
            txbCodProducto.Text = CodProducto;
            txbCantidad.Text = Cantidad;
            txbDescripcion.Text = Descripcion;
            txbUbicacion.Text = ubicacion;
            UsuarioSistema = Usuario;
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            GuardarDatos();
        }

        private void GuardarDatos()
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
                GuardarDatos();
            }
            if (e.KeyCode == Keys.Up)
            {
                txbDescripcion.Focus();
            }
        }
      

    }
}