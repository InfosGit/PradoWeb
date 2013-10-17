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

namespace viducWMS
{
    public partial class wf_SubMenuTransalado : Form
    {
        
        #region DECLARACION DE VARIABLES GLOBALES -------------//
        
        //inicialización de Variables Globales
            public static int Compa;
            public static int BodegaPeticion;
            public static string UsuarioSistema;

            viducWMS.ws_Servicios.VIDUCWebService Proxy = new viducWMS.ws_Servicios.VIDUCWebService();
            List<datosSolicitudRecepcion> DatosProducto = new List<datosSolicitudRecepcion>();

        #endregion 

        #region METODO GENERAL -----------------------------//

        public wf_SubMenuTransalado(int Compania, int Bodegas, string Usuario)
        {
            try
            {
                // Incialización del Formulario y asignacion de valores
                InitializeComponent();
                // Obteniendo el número de compañia o código
                Compa = Compania;
                // Obteniendo el código de la bodega de petición
                BodegaPeticion = Bodegas;
                // Obteniendo el usuario que esta ingresando al sistema
                UsuarioSistema = Usuario;
            }
            catch (Exception)
            {
                // Muestra el mensaje de error de lo que esta sucediendo
                MessageBox.Show(clsMensajesGenerales.ErrorComunicacion());

            }
        }

        #endregion 

        #region OPCIONES DE CLIC ---------------------------//

        private void btnRecepcion_Click(object sender, EventArgs e)
        {
            TransladoOrigen();
        }

        private void btnTransalado_Click(object sender, EventArgs e)
        {
            TransladoDestino();
        }      
        
        private void btnCerrar_Click(object sender, EventArgs e)
        {
            //Cancelar el producto
            Cancelar();
        }


        #endregion 
        
        #region METODO GENERALES ------------------------//

        private void Cancelar()
        {
           
            // Activa el Formulario de Menu
            wf_Menu Menu = new wf_Menu(Compa, BodegaPeticion, UsuarioSistema);
            // Oculta el Formulario Actual
            Menu.Show();
            // Activa el nuevo formulario(menu principal)
            Menu.Activate();
            // Oculta el formulario presente 
            this.Visible = false;
        }

        private void TransladoOrigen()
        {
         

            // Activa el formulario de Menu
            wf_SolicitudTransalado Menu = new wf_SolicitudTransalado(Compa, BodegaPeticion, UsuarioSistema);
            Menu.Show();
            Menu.Activate();
            this.Visible = false;
        }

        private void TransladoDestino()
        {
       

            // Activa el Formulario de Menu
            MenuTrasladoInterno Menu = new MenuTrasladoInterno(Compa, BodegaPeticion, UsuarioSistema);
            Menu.Show();
            Menu.Activate();
            this.Visible = false;
        }

        #endregion 

    }
}