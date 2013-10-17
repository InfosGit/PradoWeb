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
    public partial class prueba : Form
    {
        public prueba()
        {
            InitializeComponent();
        }





        private void txtPrueba_KeyUp(object sender, KeyEventArgs e)
        {
                       
        }

        #region  LLENAR GRID----------------------//
        //        
        private void llenarGrid()
         {
             dgDatosPrueba.DataSource = llenarDatos();
         }

        private DataTable llenarDatos() 
        {
            DataTable dt= new DataTable();
            dt.Columns.Add("Seleccione");
            dt.Columns.Add("Código");
            dt.Columns.Add("Nombre del pais");
            
            DataRow fila=  dt.NewRow();
            
          
                   
            

            return dt;
        }
            

        #endregion


        private void textBtxtsuma_KeyUp(object sender, KeyEventArgs e)
        {
            //Tecla que esta presionando el usuario

            //if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Tab)
            //{
     
            //}


            if (e.KeyCode == Keys.Tab || e.KeyCode == Keys.Enter || e.KeyCode == Keys.Play || e.KeyCode == Keys.MButton || e.KeyCode == Keys.RButton)
            {
                if (txtPrueba.Text != "")
                {
                    MessageBox.Show("La suma es:" + Convert.ToInt32(txtPrueba.Text) + Convert.ToInt32(textBtxtsuma.Text));
                }
            }

        }
    }
}