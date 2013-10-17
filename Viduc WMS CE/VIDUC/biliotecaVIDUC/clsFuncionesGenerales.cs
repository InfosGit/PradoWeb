using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using VIDUC;


namespace biliotecaVIDUC
{
  
    #region FUNCIONES GENERALES -------------------------//

    public class clsFuncionesGenerales
    {
        #region LLENAR COMBOBOX DE ESTADO PROFORMA

        public static void ListaEastadoProforma(ComboBox Combo)
        {
            List<LlenarComboBox> Lista = new List<LlenarComboBox>();
            Lista.Add(new LlenarComboBox("**SELECCIONE ESTADO**", "N"));
            Lista.Add(new LlenarComboBox("SOLICITADAS", "C"));
            Lista.Add(new LlenarComboBox("PICKEADAS", "P"));
            Lista.Add(new LlenarComboBox("DESPACHADAS", "D"));
            Lista.Add(new LlenarComboBox("FACTURADAS", "F"));
            Combo.DataSource = Lista;
            Combo.ValueMember = "Valor";
            Combo.DisplayMember = "Nombre";
           
        }
        #endregion 

        #region LLENAR COMBOBOX SOLICITUD TRASLADO 
      
        public static void EstadoSolicitudesTraslado(ComboBox Combo)
        {
            List<CmbSolicitudesTraslado> Lista = new List<CmbSolicitudesTraslado>();
            Lista.Add(new CmbSolicitudesTraslado("**SELECCIONE ESTADO**", "N"));
            Lista.Add(new CmbSolicitudesTraslado("CARGADO", "S"));
            Lista.Add(new CmbSolicitudesTraslado("PICKEADO", "D"));
            Lista.Add(new CmbSolicitudesTraslado("TRALADADO", "T"));
           
            Combo.DataSource = Lista;
            Combo.ValueMember = "Valor";
            Combo.DisplayMember = "Nombre";

        }
        #endregion 
        
        #region LLENAR COMBOBOX ESTADO SOLICITUD

        public static void EstadoSolicitud(ComboBox Combo)
        {
            List<ComboBoxSolicitudes> Lista = new List<ComboBoxSolicitudes>();
            Lista.Add(new ComboBoxSolicitudes("CREADAS", 1));
            Lista.Add(new ComboBoxSolicitudes("RECIBIDA", 2));
            Lista.Add(new ComboBoxSolicitudes("UBICADA", 3));
            Lista.Add(new ComboBoxSolicitudes("CANCELADA", 4));

            Combo.DataSource = Lista;
            Combo.ValueMember = "Valor";
            Combo.DisplayMember = "Nombre";

        }
        #endregion 

        #region INDICE DE LA COLUMNA SELECCIONADA DEL GRID--------------//
        
        public static string filaSeleccionadaGrid(DataGrid Grid, int columna)
        { 
            // Obtiene el indice de la columna seleccionada
            int Indice=Grid.CurrentRowIndex;
            // Obtiene el valor de la columna que necesita
            string Valor=Convert.ToString(Grid[Indice, columna]);

        return Valor;
        }
        #endregion

        #region SOLO NUMERO CAJA DE TEXTO ---------------------------------------//
        
        public static void  SoloNumero( KeyPressEventArgs e)
        {
            //Verifica si la tecla que esta presionando es un numero o una diferente
            if (!(char.IsNumber(e.KeyChar)) && (e.KeyChar != (char)Keys.Back))
            {
                //Notifica que el valor que esta ingresando no es numerico
                MessageBox.Show(clsMensajesGenerales.soloNumero()); 
                e.Handled = true;
                
            }
    
        }
        #endregion

    }
    #endregion 

    #region LLENANDO COMBOBOX ESTADO DE PROFORMA ----------------//

    public class LlenarComboBox
    {
        public string Nombre { get; set; }
        public string Valor { get; set; }

        public LlenarComboBox(string nombre, string valor)
        {
            this.Nombre = nombre;
            this.Valor = valor;
        }
        public override string ToString()
        {
            return Nombre;
        }

    }
    #endregion

    #region LLENANDO COMBOBOX SOLITUDES ------------//

    public class ComboBoxSolicitudes
    {
        public string Nombre { get; set; }
        public int Valor { get; set; }

        public ComboBoxSolicitudes(string nombre, int valor)
        {
            this.Nombre = nombre;
            this.Valor = valor;
        }
        public override string ToString()
        {
            return Nombre;
        }

    }
    #endregion

    #region LLENANDO COMBOBOX SOLITUDES DE TRASLADO -------------//

    public class CmbSolicitudesTraslado
    {
        public string Nombre { get; set; }
        public string Valor { get; set; }

        public CmbSolicitudesTraslado(string nombre, string valor)
        {
            this.Nombre = nombre;
            this.Valor = valor;
        }
        public override string ToString()
        {
            return Nombre;
        }

    }
    #endregion

}
