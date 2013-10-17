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
    public partial class wf_menuRecepcion : Form
    {

        #region VARIABLES GLOBALES ----------------------------------//
        //inicialización de Variables Globales
          public static int Compa;
          public static int Ordenes;
          public static int BodegaPeticion;
          public static int codProduct;
          public static string UsuarioSistema;
          public static int EstadoSolicitud;
          public static bool Bandera;
        
        #endregion

        #region METODO GENERAL DE CARGA    -------------------------//

        public wf_menuRecepcion(int Compania, int Bodegas, string Usuario)
        {
            InitializeComponent();
           
            // Asignación  
            Compa = Compania;
            // Bodega de las solicitudes 
            BodegaPeticion = Bodegas;
            // Usuario  del sistema que se ha logueado
            UsuarioSistema = Usuario;
           
        }

        #endregion

        #region PROCESO DE CLIC-----------------------------------//

            private void Solicidudes()
        {
            //Activa el Formulario de Solicitudes
            wf_Solicitudes frm = new wf_Solicitudes(Compa, BodegaPeticion, UsuarioSistema);
            frm.Show();
            frm.Activate();

            //oculta el Formulario Actual
            this.Visible = false;
        }

            private void Ubicacion()
        {
            //Activa el Formulario de Solicitudes
            wf_RecepcionProducto frm = new wf_RecepcionProducto(Compa,BodegaPeticion, UsuarioSistema);
            frm.Show();
            frm.Activate();

            //oculta el Formulario Actual
            this.Visible = false;
        }
          
            private void Principal()
            {
                //Activa el Formulario de Solicitudes
                wf_Menu frm = new wf_Menu(Compa, BodegaPeticion, UsuarioSistema);
                frm.Show();
                frm.Activate();

                //oculta el Formulario Actual
                this.Visible = false;
            } 

        #endregion

            #region CLIC EN LOS BOTONES DE MENU ---------------------------//

            private void btnRecepcion_Click(object sender, EventArgs e)
            {
                Solicidudes();
            }

            private void btnTransalado_Click(object sender, EventArgs e)
            {
                Ubicacion();
            }

            private void btnCerrar_Click(object sender, EventArgs e)
            {
                Principal();
            }

            #endregion 
    }
}