using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.wsTraslado;
using VIDUC;

namespace viducWMS

{
  
    
    
    public partial class wf_AreasDespacho : Form
    {

        #region VARIABLES GLOBALES ---------------------------------------//
        //inicialización de Variables Globales
        private static int Compa;
        private static string UsuarioSistema;
        private static int Bodega;
        private static int   Proformas;
        public static string CodigoProducto;
        public static string NombreProducto;
        public static int Cantidades;
        public static string Ubicacion;
        public static string NombreProforma;
        public static string AreaDespacho;
        private static int IdDetDespacho;
        private static bool Estado;

        #endregion

        #region LLAMANDO LA CAPA DE SERVICIOS--------------------------------------//

        viducWMS.wsTraslado.wsTrasladoBodegaBodega Proxy = new viducWMS.wsTraslado.wsTrasladoBodegaBodega();
        List<areaDespacho> AreasDespacho = new List<areaDespacho>();
        List<ubicacionProducto> UbicacionProducto = new List<ubicacionProducto>();

        #endregion 
        
        #region METODO GENERAL DE PARAMETROS ---------------//

        public wf_AreasDespacho(int Compania, int Proforma, string Usuario, int  BodegaRecibe,string  CodProducto, string NomProducto,int  Cantidad, string NomProforma, int DetDespacho, bool IdEstado)
        {
            InitializeComponent();
            Compa = Compania;
            UsuarioSistema = Usuario;
            Bodega = BodegaRecibe;
            CodigoProducto = CodProducto;
            NombreProducto = NomProducto;
            NombreProforma = NomProforma;
            IdDetDespacho = DetDespacho;
            Proformas = Proforma;
            Cantidades = Cantidad;
            Estado = IdEstado;
            txtAreaDespachar.Focus();
            AreasParaDespacho();
            UbicacionBodega();
            txtDescripcionProducto.Text = "Producto: " + CodigoProducto + " - " + NombreProducto;
        
        }
        #endregion

        #region OBTENIENDO AREAS DE DESPACHO------------------------------------//

        private void AreasParaDespacho()
        {
            try
            {

                // Lista de estador proformas 
                AreasDespacho= Proxy.findAreasDespacho(Compa, true, Bodega, true).ToList<areaDespacho>();
                // Llenando origen de datos proformas
                dgAreasDespacho.DataSource = CargarAreas();
                //refresca el Grid con el Origen de Datos
                dgAreasDespacho.Refresh();
            }
            catch (Exception)
            {
                dgAreasDespacho.DataSource = null;


            }
        }
        #endregion

        #region CREANDO EL DATAGRID CON SU VALORES ---------------------------------//

        private DataTable CargarAreas()
        {

            DataTable dt = new DataTable();
            //Nombrando las columnas que tendra el Datable 
            dt.Columns.Add("Código Area");
            dt.Columns.Add("Nombre Area");



            //Creando una fila por cada recorredo
            DataRow row = dt.NewRow();
            //Recorriendo las lista que devuelve el metodo
            foreach (var Item in AreasDespacho)
            {
                row = dt.NewRow();

                row["Código Area"] = Item.areaDespachoPK.id.ToString();
                row["Nombre Area"] = Item.nombre.ToString();
                //Agregando la Fila al Datatable
                dt.Rows.Add(row);
            }


            //Retorna el Datatable
            return dt;

        }
        #endregion

        #region CALCELAR PRODUCTO ---------------------//
        private void Cancelar()
        {
            wf_DespachoProducto fm = new wf_DespachoProducto(Compa, Proformas, UsuarioSistema, Bodega, NombreProforma, 5, "TRASLADO");
            fm.Show();
            fm.Activate();
            Visible = false;

        }

        #endregion

        #region OPCIONES DE CLIC --------------------------------//
      
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            Cancelar();
        }

        #endregion 

        #region METODO PRODUCTO PARA DESPACHO -------------------//

         private void ProductoDespachado()
         {

            try
            {
                int index = dgAreasDespacho.CurrentRowIndex;
                //Para obtener el resultado de la ejecución
                bool resultado, resultadoEstado;
                bool AreaDespachoRes;
                //Inicializando variables
                int Anaquel = 0, Nivel = 0, Largo;

                string Area = "";

                //Obteniendo el largo de código del ubicacion en bodega
                Largo = Ubicacion.Length;
                if (Largo == 4)
                {
                    // Obteniendo la posicion del Anaquel
                    Anaquel = Convert.ToInt32(Ubicacion.Substring(0, 2));
                    // Obteniendo el area de bodega donde esta ubicado el producto
                    Area = Convert.ToString(Ubicacion.Substring(2, 1));
                    // Obteniendo el nivel donde esta el producto
                    Nivel = Convert.ToInt32(Ubicacion.Substring(3, 1));
                }
                else if (Largo == 3)
                {
                    Anaquel = Convert.ToInt32(Ubicacion.Substring(0, 1));
                    Area = Convert.ToString(Ubicacion.Substring(1, 1));
                    Nivel = Convert.ToInt32(Ubicacion.Substring(2, 1));
                }

                //Se captura el valor en una variable
                AreaDespacho = Convert.ToString(txtAreaDespachar.Text);

                //   Pregunta el si la funcion encontro o no en el listado el producto
                if (txtAreaDespachar.Text != "")
                {
                    //Areas de despacho 
                    AreaDespachoRes = Proxy.validarAreaDespacho(Compa, Bodega, txtAreaDespachar.Text.Trim());

                    if (AreaDespachoRes == true)
                    {

                        // Pasa los parametros al metodo de Label capa de servicio
                        if (Estado == false)
                        {
                            resultado = Proxy.despacharProductoProforma(Compa, true, Proformas, true, IdDetDespacho, true, CodigoProducto, Bodega, true, AreaDespacho);
                            //  Verifica si el proceso se ejecuto correctamente
                        }
                        else
                        {
                            resultado = Proxy.despacharTodaProforma(Compa, true, Proformas, true, Bodega, true, AreaDespacho);
                            //  Verifica si el proceso se ejecuto correctamente
                        }
                            if (resultado == true)
                        {
                          
                             //Muestra el mensaje que el producto ha sido despachado
                             MessageBox.Show(clsMensajesGenerales.Despacho());
                            //Refresco el grid para que muestre el proceso ejecutado
                            resultadoEstado = Proxy.validarDespachoProforma(Compa, true, Proformas, true);


                            //Si ha retornado "true" es por que se ha ejecutado con exito el proceso
                            if (resultadoEstado == true)
                            {
                                //Notifica al usuario que la proforma ha sido despachada
                                MessageBox.Show("La lista de productos ha sido despachada, éxitosamente");

                            }

                            Cancelar();

                        }
                        else
                        {
                            MessageBox.Show("Producto ya ha sido despachado");
                            txtAreaDespachar.Text = "";
                            txtAreaDespachar.Focus();
                            Cancelar();

                        }

                    }   //If que verificia si el resultado es el correcto   de area de despacho
                    else
                    {
                        MessageBox.Show("Area de despacho invalida o no esta disponible");
                        txtAreaDespachar.Text = "";
                        txtAreaDespachar.Focus();
                    }


                }// Cierra el IF  que determina si el producto existe o no, en el listado de producto
                else
                {

                    MessageBox.Show(clsMensajesGenerales.UnidadesProducto());
                    dgAreasDespacho.SelectionBackColor = Color.White;
                }
            }

            catch (Exception)
            { 
            
            }
        }

        #endregion

        #region UBICACIONES BODEGA PRODUCTO  ------------------------//
        
        private void UbicacionBodega()
        {
            try
            {
                //Obteniendo la ubicacion de Producto
                UbicacionProducto = Proxy.findUbicacionesBodegaProducto(Compa, true, Bodega, true, CodigoProducto).ToList<ubicacionProducto>();
                foreach (var Item in UbicacionProducto)
                {
                    //La ubicacion del producto en Bodega esta constituida por anaquel +area + nivel
                    // El Anaquel representa un valor entero de 1-99
                    // El Area .lo comprende una letra de A-Z
                    // El Nivel lo comprende un numero de 1-9
                    // La union de estos tres elementos constituyen la ubicación de bodega del producto
                    Ubicacion = Convert.ToString(
                                                    Item.ubicacionProductoPK.anaquel 
                                                  + Item.ubicacionProductoPK.area 
                                                  + Item.ubicacionProductoPK.nivel );
                }
            }
            catch (Exception)
            {
                MessageBox.Show(clsMensajesGenerales.UbicacionProducto());
            }
        }
        #endregion

        #region ACCIONES DE CLIC --------------------------------//

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            ProductoDespachado();
        }

        private void dgAreasDespacho_Click(object sender, EventArgs e)
        {

            //Obtenie el valor del index de la fila seleccionada
            int Index = dgAreasDespacho.CurrentRowIndex;
            //Llena la caja de texto con el valor perteneciente al index de la columna 0
            txtAreaDespachar.Text = Convert.ToString(dgAreasDespacho[Index, 0]).ToString();
            
         }

        #endregion

        #region CUANDO PRESIONA UNA TECLA ----------------------//

        private void txtAreaDespachar_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {
                //Ubicacion  de producto en bodega
               ProductoDespachado();
            }
        }

        #endregion

        private void dgAreasDespacho_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                //Obtenie el valor del index de la fila seleccionada
                int Index = dgAreasDespacho.CurrentRowIndex;
                //Llena la caja de texto con el valor perteneciente al index de la columna 0
                txtAreaDespachar.Text = Convert.ToString(dgAreasDespacho[Index, 0]).ToString();
            }
        }

    }
}