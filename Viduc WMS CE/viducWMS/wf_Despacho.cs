using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Web.Services;
using viducWMS.wsTraslado;
using viducWMS.ws_Servicios;
using VIDUC;
using biliotecaVIDUC;


namespace viducWMS
{
    public partial class wf_Despacho : Form
    {
        #region VARIABLES GLOBALES ---------------------------------------//
        //inicialización de Variables Globales
           private static int Compa;
           private static string UsuarioSistema;
          private  static int Bodega;
        #endregion 

        #region LLAMANDO LA CAPA DE SERVICIOS--------------------------------------//

          viducWMS.wsTraslado.wsTrasladoBodegaBodega Proxy = new viducWMS.wsTraslado.wsTrasladoBodegaBodega();
          viducWMS.ws_Servicios.VIDUCWebService Proxys = new viducWMS.ws_Servicios.VIDUCWebService();
          List<viducWMS.wsTraslado.solicitud> ListaEstadoProforma = new List<viducWMS.wsTraslado.solicitud>();
          List<viducWMS.ws_Servicios.estadoSolicitud> estadoSolicitud = new List<viducWMS.ws_Servicios.estadoSolicitud>();
          List<ComboBoxSolicitudes> Lista = new List<ComboBoxSolicitudes>();
        
        //Maneja el listado de solicitudes  
           List<viducWMS.wsTraslado.detSolicitud> ListaProducto = new List<viducWMS.wsTraslado.detSolicitud>();

         #endregion 

        #region METODO GENERAL ----------------------------------//

          public wf_Despacho(int Compania, int BodegaPeticion, string Usuario)
            {
                     //Iinicializando componentes               
                    InitializeComponent();
                    //Asinando el valor de compañia a la Compa
                    Compa = Compania;
                    UsuarioSistema = Usuario;
                    Bodega = BodegaPeticion;
                    EstadoSolicitudes();
                   

                   
                   
                    
                

            }
          #endregion 

        #region OBTENIENDO EL ESTADO DE PROFORMAS------------------------------------//
          
         private void EstadoProforma(int compania, int Proforma)
         {
             try
             {
                 //Obtiene  la lista del combobox
                 ComboBoxSolicitudes estado = cmbEstadoProforma.SelectedItem as ComboBoxSolicitudes;
                 if (estado.Valor != 0)
                 {
                     // Lista de estador proformas 
                    var item = Proxy.findProformasByEstado(compania, true, Proforma, true);
                    if (item != null)
                    {
                        ListaEstadoProforma = Proxy.findProformasByEstado(compania, true, Proforma, true).ToList<viducWMS.wsTraslado.solicitud>();
                        // Llenando origen de datos proformas
                        dgProformas.DataSource = CargarProformas();
                    }
                    else
                    {
                        //Limpia el origen de Datos

                        dgProformas.DataSource = null;
                    }
                 }
                 else
                 {
                     //Limpia el origen de Datos

                     dgProformas.DataSource = null;
                 }
             }
             catch (Exception ex)
             {
                 //Limpia el origen de datos
                 MessageBox.Show(ex.Message);
                 dgProformas.DataSource = null;
                 
                 
             }
         }
          #endregion

        #region CREANDO EL DATAGRID CON SU VALORES ---------------------------------//
         
        private DataTable CargarProformas()
         {
                      
            DataTable dt = new DataTable();
           //Nombrando las columnas que tendra el Datable 
             dt.Columns.Add("Número proforma");
             dt.Columns.Add("Cliente");
             dt.Columns.Add("Items");
      
            
             
            //Creando una fila por cada recorredo
            DataRow row = dt.NewRow();
            //Recorriendo las lista que devuelve el metodo
           foreach (var Item in ListaEstadoProforma)
            {
                row = dt.NewRow();

                row["Número proforma"] = Item.solicitudPK.codSolicitud;
                row["Cliente"] = Item.vtaMovPforma.nomCliente;
                //Llama el metodo del de la capa de servicio para obtener la lista de productos 
               ListaProducto = Proxy.findProductosProforma(Compa, true, Convert.ToInt32(Item.solicitudPK.codSolicitud), true).ToList<viducWMS.wsTraslado.detSolicitud>();
               //Muestra la cantiad de item de los productos.

                row["Items"] = ListaProducto.Count;
              
               //Agregando la Fila al Datatable
                dt.Rows.Add(row);
            }
           
          
            //Retorna el Datatable
            return dt;

         }
        #endregion

        #region LLENA EL ESTADO DE PROFORMA ------------------------//
            public void comboProformas()
         {
             clsFuncionesGenerales.ListaEastadoProforma(cmbEstadoProforma);
         }
        #endregion
          
        #region CAMBIO DE ITEM ---------------------------------//

            private void cmbEstadoProforma_SelectedIndexChanged(object sender, EventArgs e)
         {

             //Determino el valor que he seleccionado de la lista
             ComboBoxSolicitudes estado =  cmbEstadoProforma.SelectedItem  as ComboBoxSolicitudes;
            //Captura el valor del value de la proforma el cual es el estado(C, S, D, F)
           
             //Determina so mp ha selecciado ningun valor de la lista
             if ((estado.Valor != 0) )
             {
                 int Proforma = Convert.ToInt32(estado.Valor);

                 EstadoProforma(Compa, Proforma);
             }
             else
             {
                 dgProformas.DataSource = null;
             }


         }
            #endregion 

        #region OBTENIENDO LOS CODIGO DE DETALLE DE PRODUCTO DE PROFORMA ---------//

            private void ClicGridDespacho()
        {
            try
            {
                int CodSolicitd;
                string NomProducto;
                // Inicializa Variables con Valores del Grid
                int Index = dgProformas.CurrentRowIndex;

                //Cargando el valor del codigo de la proforma
                CodSolicitd = Convert.ToInt32(dgProformas[Index, 0].ToString());
                //Obteniendo el nombre de la proforma que se ha seleccionado
                NomProducto = Convert.ToString(dgProformas[Index, 1].ToString());

                DetalleProducto(CodSolicitd, NomProducto);
               
            }
            catch (Exception)
            {
                MessageBox.Show(clsMensajesGenerales.FilaNoValida());
            }
        }
    #endregion 

        #region OPCIONES DE CLIC ----------------------------//

            private void dgProformas_DoubleClick(object sender, EventArgs e)
            {
                ClicGridDespacho();
            }
     

           private void btnCancelar_Click(object sender, EventArgs e)
           {
             wf_Menu fm = new wf_Menu(Compa, Bodega, UsuarioSistema);
             fm.Show();
             fm.Activate();
             this.Visible = false;
           }
     
     #endregion

        #region MOSTRANDO EL DETALLE DEL PRODUCTO ------------//

       private void DetalleProducto(int codSolicitud, string NomProducto)
       {
        
            ComboBoxSolicitudes lista = cmbEstadoProforma.SelectedItem as ComboBoxSolicitudes;
            if ((lista.Valor == 1) || (lista.Valor == 5))
            {
                wf_DespachoProducto fm = new wf_DespachoProducto(Compa, codSolicitud, UsuarioSistema, Bodega, NomProducto, lista.Valor, "DESPACHO");
                fm.Show();
                fm.Activate();
                this.Visible = false;
            }
            else
            {
                MessageBox.Show("El despacho solo aplica para proformas en estado:'CREADAS' y 'PICKEADAS'");
            }

        
     }
        #endregion 
         
        #region CARGAR ESTADO DE SOLICITUDES-----------------------------------------//

       public void EstadoSolicitudes()
       {
           try
           {
               estadoSolicitud = Proxys.findEstadosSolicitud().ToList<viducWMS.ws_Servicios.estadoSolicitud>();
               Lista.Add(new ComboBoxSolicitudes("**SELECCIONE ESTADO**", 0));

               foreach (var Item in estadoSolicitud)
               {

                   //Agregando los estados a lista de estados de solicitud
                   Lista.Add(new ComboBoxSolicitudes(Item.nombre, Convert.ToInt32(Item.id)));

               }

               //Listado de origen de datos
               cmbEstadoProforma.DataSource = Lista;
               cmbEstadoProforma.ValueMember = "Valor";
               cmbEstadoProforma.DisplayMember = "Nombre";
           }
           catch (Exception)
           {
                  dgProformas.DataSource = null;
               
           }
       }

       #endregion

       private void dgProformas_KeyUp(object sender, KeyEventArgs e)
       {
           if (e.KeyCode == Keys.Enter)
           {
               ClicGridDespacho();
           }
       }

     
    }
}