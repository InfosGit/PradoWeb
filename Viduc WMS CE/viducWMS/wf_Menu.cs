using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using VIDUC;

namespace viducWMS
{
    public partial class wf_Menu : Form
    {

        #region VARIABLES GLOBALES --------------------------//
        //Inicialización de Variables Globales
         public static int Compa;
         public static int Bodegas;
         public static string UsuarioSistema;

        #endregion

        #region METODO GENERAL DE USO DE VARIABLES -----------------//

         public wf_Menu(int Compania, int Bodega, string Usuario)
        {
            try
            {
                //Inicializa Los Componente y Asigna Valores a Variables
               InitializeComponent();
               Compa = Compania;
               Bodegas = Bodega;
               UsuarioSistema = Usuario;
               
            }
            catch (Exception )
            {
                MessageBox.Show("Error de Comunicación");
            }

        }

        #endregion

        #region   ACCIONES DE CLIC ------------------------------//

        private void btnTransalado_Click(object sender, EventArgs e)
        {
            // Muestra Opción de Transalado de Producto
            MostrarTransalado();
        }

        private void btnInventario_Click(object sender, EventArgs e)
        {
            // Muestra Opción de Inventario
            MostrarInventario();
        }

        private void btnCerrar_Click(object sender, EventArgs e)
        {
            //Devuelve a Pantalla Login
            Exit();
        }

        private void btnRecepcion_Click(object sender, EventArgs e)
        {
            // Muestra Opción de Recepción de Producto
            MostrarRecepcion();
        }

        #endregion 

        #region OCPIONES POR TECLAS-----------------------------//

        private void wf_Menu_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Asigna Valores de Comparacion  por teclas
            char? tecla= e.KeyChar;
            char? Recepcion = '1';
            char? Translado = '2';
            char? Despachos= '3';
            char? Inventario = '4';
            char? Conteo= '5';
            char? Salir = '#';

            //Accede a la opcion de recepcion
            if (tecla == Recepcion)
            {
                MostrarRecepcion();
            }
            //Accede a la opcion de traslado
            else if (tecla== Translado)
            {
                MostrarTransalado();
            }
            //Accede a la opcion de despacho
            else if (tecla == Despachos)
            {
                Despacho();
            }
            //Accede a la opcion de Inventario
            else if (tecla == Inventario)
            {
                MostrarInventario();
            }
            //Accede a la opcion de Conteo
            else if (tecla == Conteo)
            {
                ConteoFisico();
            }
            else if (tecla == Salir)
            {
                Exit();
            }
        }
        #endregion

        #region OPCIONES DE MENU------------------//

         private void Exit()
        {
            // Activa el Formulario de Login
            wf_Login frm = new wf_Login();
         
            frm.Show();
            frm.Activate();

            //oculta el Formulario Actual
            this.Visible = false;
        }
         private void MostrarRecepcion()
        {
            //Activa el Formulario de Solicitudes
            wf_menuRecepcion frm = new wf_menuRecepcion(Compa, Bodegas, UsuarioSistema);
            frm.Show();
            frm.Activate();

            //oculta el Formulario Actual
            this.Visible = false;
        }
         private void MostrarTransalado()
        {
            // Activa el Formulario de Solicitud Trasalado
            wf_SubMenuTransalado frm = new wf_SubMenuTransalado(Compa, Bodegas, UsuarioSistema);
            frm.Show();
            frm.Activate();

            //oculta el Formulario Actual
            this.Visible = false;
        }
         private void MostrarInventario()
        {
            // Activa el Formulario de Inventario
            wf_MenuConsulta frm = new wf_MenuConsulta(Compa, Bodegas, UsuarioSistema);
            frm.Show();
            frm.Activate();

            //culta el Formulario Actual
            this.Visible = false;
        }
        
           
          //Ubicacion de prooducto

         public void Despacho()
         {
             // Activa el Formulario de Solicitud Trasalado
             wf_Despacho frm = new wf_Despacho(Compa, Bodegas, UsuarioSistema);
             frm.Show();
             frm.Activate();

         }
        
        #endregion 
       
        #region ACCEDIENTO A DESPACHO -----------------------------//

         private void btnDespacho_Click(object sender, EventArgs e)
         {
            //Llama el metdo que llena el DropDowlist 
            Despacho();
         }
        #endregion

        #region ACCEDIENDO AL CONTEO FISICO-----------------------------------//

         private void ConteoFisico()
         {

             wf_Ajustes fm = new wf_Ajustes(Compa, Bodegas, UsuarioSistema);
             fm.Show();
             fm.Activate();
             this.Visible = false;
         }
         private void btnConteoFisico_Click(object sender, EventArgs e)
        {
            ConteoFisico();

        }
        #endregion

    }
}