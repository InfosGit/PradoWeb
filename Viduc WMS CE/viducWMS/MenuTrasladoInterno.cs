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
    public partial class MenuTrasladoInterno : Form
    {

        #region VARIABLES BLOBALES ---------------------///

        private static string Usuario;
        private static int Bodega;
        private static int Compania;
        #endregion
     
        #region PARAMETRO DE VARIABLES ---------------------///

        public MenuTrasladoInterno( int IdCompania, int IdBodega, string IdUsuario)
        {
            InitializeComponent();
            Compania = IdCompania;
            Usuario = IdUsuario;
            Bodega = IdBodega;
        }
        #endregion
     
        #region Acciones Botones ----------------------------------------//

        private void btnRecepcion_Click(object sender, EventArgs e)
        {
            TrasladoInterno("PETP");
        }

        private void btnTransalado_Click(object sender, EventArgs e)
        {
            TrasladoInterno("REUP");
        }

        private void btnCerrar_Click(object sender, EventArgs e)
        {
            Cancelar();
        }
      

       
        #endregion 

        #region Traslado interno de productos --------------------------//
       
         private void TrasladoInterno(string Accion)
         {
            wf_TrasladoInterno menu = new wf_TrasladoInterno(Compania, Bodega, Usuario, Accion);
            menu.Activate();
            menu.Show();
            this.Visible = false;
            
          }
        #endregion 

        #region Cancelar ---------------------------------------//
         private void Cancelar()
         {
             wf_SubMenuTransalado menu = new wf_SubMenuTransalado(Compania, Bodega, Usuario);
             menu.Activate();
             menu.Show();
             this.Visible = false;
         }
        #endregion

        


    }
}