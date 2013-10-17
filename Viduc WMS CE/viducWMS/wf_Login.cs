using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.ws_Servicios;
using System.Reflection;

using VIDUC;
using biliotecaVIDUC;






namespace viducWMS
{
    public partial class wf_Login : Form
    {
        #region VARIABLES GLOBALES
       
        //Inicialización de Variables Globales
         public static string UsuarioSistema;
        //Obteniendo acceso al los servicios para obtener el metodo a tulizar
            viducWMS.ws_Servicios.VIDUCWebService Proxy = new viducWMS.ws_Servicios.VIDUCWebService();
            List<datosUsuario> DatosUsuario = new List<datosUsuario>();
        #endregion
       
        public wf_Login()
        {
            try
            {
               
                //Inicializa Los Componente y muestra el foco en el text de usuario
                InitializeComponent();
                txtUsuario.Focus();
              
            }

            catch (Exception )
            {
               //Mensaje que indentifica el error de comunicacion la BD
                MessageBox.Show("Error de comunicación");
            }
        }


        private void btnSalir_Click(object sender, EventArgs e)
        {
            //Termina el Proceso de la Aplicación
            Application.Exit();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            try
            {
                //Metodo que Busca Los Datos en una lista y  devuelve si Tiene Permisos de Acceso
                Logearse();
            }
            catch (Exception)
            {
                MessageBox.Show(clsMensajesGenerales.ErrorComunicacion());
            }
        }

        #region LOGUEO DE USUARIO 
            
         private void Logearse()
        {
            //Determina si el usuario o contraseña o ambos estan vacio 
            
             if (txtUsuario.Text.Trim() == "" || txtPassword.Text.Trim() == "")
            {
               // Notifica que usuario o contraseña que ha ingresado es invalido
                MessageBox.Show(clsMensajesGenerales.LoginUsuario());
               //Limpia la contraseña que ha ingresado
                 Limpiar();
               // Envia el focus al caja de texto del usuario  
                 txtUsuario.Focus();
             }
            else
            {
               //Obtiene el metodo del servicio que permite validar el El usuario con su contraseña
                 DatosUsuario = Proxy.validarUsuario(txtUsuario.Text.Trim(), txtPassword.Text.Trim()).ToList<datosUsuario>();
               //Recorriendo la lista que retorna el servicio de validar usuarios
                 foreach (var item in DatosUsuario)
                {
                    if (item.logeado == true)
                    {
                        int Compania = Convert.ToInt32(item.codCompania);
                        int  Bodega = Convert.ToInt32(item.codBodega);
                        UsuarioSistema = txtUsuario.Text.Trim();

                        //Activa el Formulario de Menu
                        wf_Menu Menu = new wf_Menu(Compania, Bodega, UsuarioSistema);
                        Menu.Show();

                        //oculta el Formulario Actual
                        this.Visible = false;
                        Limpiar();

                    }
                    else
                    {
                        //Mensaje de Error de usuario o contraseña de usuario 
                        MessageBox.Show(clsMensajesGenerales.LoginUsuario());
                        Limpiar();
                    }
                }
            }
        }
       
        #endregion
       
        #region LIMPIAR CAJAS DE TEXTO
        //Limpia Las Variables
            private void Limpiar()
            {
                txtPassword.Text = "";
            }
        #endregion 

            private void txtUsuario_KeyUp(object sender, KeyEventArgs e)
            {
                
                if (e.KeyCode == Keys.Enter || e.KeyCode == Keys.Down)
                {
                    txtPassword.Focus();
                }
            }

            private void txtPassword_KeyUp(object sender, KeyEventArgs e)
            {
                if (e.KeyCode == Keys.Up)
                {
                    txtUsuario.Focus();
                }
                if (e.KeyCode == Keys.Enter)
                {
                    Logearse();
                }
            }


          
    }
}