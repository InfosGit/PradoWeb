using System;
using System.Collections.Generic;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using colorFilaGrid.colorFila;
using VIDUC;
using viducWMS.wsTraslado;



namespace viducWMS
{
    public partial class wf_DespachoProducto : Form
    {

        #region VARIABLES GLOBALES ---------------------------------------//
        //inicialización de Variables Globales
        private static int Compa;
        private static int Proforma;
        private static string UsuarioSistema;
        private static int Bodega;
        private static string Estado;
        public static string NombreProducto;
        public static string NombreProforma;
        private static int DetProforma;
        private static int Estadoprof;
        private static string EstadoBandera;
        private static int EstadoProforma;
        


        #endregion

        #region LLAMANDO LA CAPA DE SERVICIOS--------------------------------------//

        viducWMS.wsTraslado.wsTrasladoBodegaBodega Proxy = new viducWMS.wsTraslado.wsTrasladoBodegaBodega();
        List<detSolicitud> ListaProducto = new List<detSolicitud>();
        List<ubicacionProducto> Ubicacion = new List<ubicacionProducto>();
        #endregion

        #region METODO GENERAL DE PARAMETROS-----------------------------//
       
        public wf_DespachoProducto(int codCompania, int CodProforma, string usurio, int BodegaPeticion,string NomProforma, int IdEstadoProforma, string Bandera)
        {

            try
            {
                // Inicializacion de proceso
                InitializeComponent();
                // Asigna  a la variable el valor de compañia 
                Compa = codCompania;
                // Asigna el codigo de proforma 
                Proforma = CodProforma;
                // Obteniendo el usuario del sistema
                UsuarioSistema = usurio;
                // Asignando el valor de bodega a la variable Global
                Bodega = BodegaPeticion;
                // Nombre de la prforma
                NombreProforma = NomProforma;                                    
                // Obteniendo el estado de la proforma seleccionada
                Estadoprof = IdEstadoProforma;
                // Obteniendo el nombre del producto
                txtDescripcion.Text = "Solicitud: " + CodProforma + " - " + NomProforma;
                // Carga los datos en el GRID
                CargarDatos();
                EstadoBandera = Bandera;
                // Esta proforma si es picking
                dgProformaProducto.Focus();
                clicGRID();
                if (IdEstadoProforma == 5)
                {
                    //Envia el elemento que se ha seleccionado
                    chkSeleccioneTodos.Visible = true;
                    //txtCodProducto.ReadOnly = false;
                }
               
                //Estado Profoma
                EstadoProforma = IdEstadoProforma;
             
            }
            catch (Exception)
            {
                   //MessageBox.Show(clsMensajesGenerales.noDatos());
            }

        }
        #endregion

        #region OBTENIENDO LA LISTA DE VALORES DE LA CAPA DE SERVICIO --------------//

        //Caragar datos en el GRID
        private void CargarDatos()
        {
            try
            {

                //Llama el metodo del de la capa de servicio para obtener la lista de productos 
                ListaProducto = Proxy.findProductosProforma(Compa, true, Proforma, true).ToList<detSolicitud>();
                //Asigna el origen de datatable de productos
           
                dgProformaProducto.DataSource = CargarPrducto();
               

            }
            catch (Exception)
            {
                // Envia una excepcion, cuando se obtiene el listado de productos
                MessageBox.Show(clsMensajesGenerales.ErrorComunicacion());
                
            }
        }
        #endregion

        #region CREANDO EL DATAGRID CON SU VALORES ---------------------------------//

        private DataTable CargarPrducto()
        {

            DataTable dt = new DataTable();
            
            //Nombrando las columnas que tendra el Datable 
            dt.Columns.Add("Número");
            dt.Columns.Add("Código");
            dt.Columns.Add("Nombre");
            dt.Columns.Add("U.Medida");
            dt.Columns.Add("C. Solicitada");
            dt.Columns.Add("C. Pickeada");
            dt.Columns.Add("Estado");
         

                
            //Creando una fila por cada recorredo
                DataRow row;
            //Recorriendo las lista que devuelve el metodo
            //Estado del producto
                string Estado = "";
            
            // Chequeo de producto
            CheckBox chequeo = new CheckBox();  
            
            foreach (var Item in ListaProducto)
            {
               
                //Creando la filas 
                row = dt.NewRow();
                // Codigo detalle de la solicitud
                                            
               //Agregando un checkbook a una columna;
               
                //Agrega el estado del chequeo
                             
                //Numero de ITEM
                row["Número"] = Item.detSolicitudPK.codDetSolicitud.ToString();
                // Muestra el código del producto
                row["Código"] = Item.productos.productosPK.codProd.ToString();
                //Muestra la unidad de medida del producto
                row["U.Medida"] = Item.productos.unidadMedida;
                // Muestra el nombre del producto                             
                row["Nombre"] = Item.productos.nombre.ToString();
                // C. Solicitada = Cantidad Solicitada
                row["C. Solicitada"] = Item.cantidadSolicitada.ToString();
                //Cantidad Pickeada
                row["C. Pickeada"] = Item.cantidadDespachada.ToString();
                // Estado del producto
                
                Estado = Convert.ToString(Item.estado.Trim());
                if (Estado == "N")
                {
                    //Estado de solicitud
                    row["Estado"] = "SOLICITADO";               
                }
                else 
                    if (Estado=="P")
                    {
                        // Estado Pickeado
                        row["Estado"] = "PICKEADO";
                    }

                    else
                        if (Estado == "D")
                        {
                            // Estado Despacho
                            row["Estado"] = "DESPACHADO";
                        }

             
               //Agregando la Fila al Datatable
                dt.Rows.Add(row);
            }


            //Retorna el Datatable
            return dt;

        }
        #endregion

        #region OBTENDIENDO EL CODIGO DEL PRODUCTO----------//

        private void ClicGridDespacho(int detProforma, string CodProducto, string NomProducto, int Cantidad, string Estado)
        {
            try
            {

               //Ubicacion de producto
                string UbicacionProducto;
                     
                //Obteniendo Ubicacion de producto    
                Ubicacion = Proxy.findUbicacionesBodegaProducto(Compa, true, Bodega,true, CodProducto).ToList<ubicacionProducto>();
       
                    if (Ubicacion != null)
                    {
                      //Recorre la lista de producto 
                       foreach (var UbicacionItem in Ubicacion)
                        {
                            // Obtiene la ubicacion del producto por: Anaquel+Area+Nivel;
                            UbicacionProducto = UbicacionItem.ubicacionProductoPK.anaquel + UbicacionItem.ubicacionProductoPK.area + UbicacionItem.ubicacionProductoPK.bodega;
                        }

                        //Obteniendo el estado del producto
                        if (Estado != "S")
                        {
                            if (chkSeleccioneTodos.Checked != true)
                            {
                                // Area de despacho Areas de despacho  ---------------------------- //
                                wf_AreasDespacho fm = new wf_AreasDespacho(Compa, Proforma, UsuarioSistema, Bodega, CodProducto, NomProducto, Cantidad, NombreProforma, detProforma, false);
                                fm.Show();
                                fm.Activate();
                                Visible = false;

                            }
                          
                          else
                            {
                                // Llama al area de despacho
                                wf_AreasDespacho fm = new wf_AreasDespacho(Compa, Proforma, UsuarioSistema, Bodega, CodProducto, NomProducto, Cantidad, NombreProforma, detProforma, true);
                                fm.Show();
                                fm.Activate();
                                Visible = false;

                            }
                        }
                        else
                        {
                            // Muestra el mensaje que despacho esta listo
                            MessageBox.Show(clsMensajesGenerales.DespachoListo());
                        }
                   
                    

                }

              
               
                //Devolviendo el focus a la caja de texto
               
            }
            catch (Exception)
            {
                MessageBox.Show(clsMensajesGenerales.UbicacionProducto());
            }
        }


        private void DespachoTodos(int detProforma, string CodProducto, string NomProducto, int Cantidad, string Estado)
        {
            try
            {

                //Ubicacion de producto
                string UbicacionProducto;

                //Obteniendo Ubicacion de producto    
                Ubicacion = Proxy.findUbicacionesBodegaProducto(Compa, true, Bodega, true, CodProducto).ToList<ubicacionProducto>();

                if (Ubicacion != null)
                {
                    //Recorre la lista de producto 
                    foreach (var UbicacionItem in Ubicacion)
                    {
                        // Obtiene la ubicacion del producto por: Anaquel+Area+Nivel;
                        UbicacionProducto = UbicacionItem.ubicacionProductoPK.anaquel + UbicacionItem.ubicacionProductoPK.area + UbicacionItem.ubicacionProductoPK.bodega;
                    }

                    //Obteniendo el estado del producto
                    if (Estado != "S")
                    {
                        if (chkSeleccioneTodos.Checked != true)
                        {
                            // Area de despacho Areas de despacho  ---------------------------- //
                            wf_AreasDespacho fm = new wf_AreasDespacho(Compa, Proforma, UsuarioSistema, Bodega, CodProducto, NomProducto, Cantidad, NombreProforma, detProforma, false);
                            fm.Show();
                            fm.Activate();
                            Visible = false;

                        }

                        else
                        {
                            // Llama al area de despacho
                            wf_AreasDespacho fm = new wf_AreasDespacho(Compa, Proforma, UsuarioSistema, Bodega, CodProducto, NomProducto, Cantidad, NombreProforma, detProforma, true);
                            fm.Show();
                            fm.Activate();
                            Visible = false;

                        }
                    }
                    else
                    {
                        // Muestra el mensaje que despacho esta listo
                        MessageBox.Show(clsMensajesGenerales.DespachoListo());
                    }



                }



                //Devolviendo el focus a la caja de texto

            }
            catch (Exception)
            {
                MessageBox.Show(clsMensajesGenerales.UbicacionProducto());
            }
        }
        #endregion

        #region PERMITE RETORNAS AL PROFORMAS (despacho)----------//

        private void Cancelar()
        {                                      
            wf_Despacho fm = new wf_Despacho(Compa, Bodega, UsuarioSistema);
            fm.Show();
            fm.Activate();
            this.Visible = false;

        }
       
        private void CancelarTraslado()
        {
           //Solicitud de traslado 
            wf_SolicitudTransalado fm = new wf_SolicitudTransalado(Compa, Bodega, UsuarioSistema);
            //Muestra pantalla
            fm.Show();
            //Envia el focus a la pantalla
            fm.Activate();
            //Quita de la vista la pantalla donde se esta
            this.Visible = false;

        }
        #endregion

        #region CLIC EN EL BOTON ACEPTAR------------------------------------//

      

        #endregion

        #region CLIC EN EL BOTON CANCELAR ----------------------------------//

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            try
            {

                if (EstadoBandera == "TRASLADO")
                {
                    // Determina el valor que se cancela
                    CancelarTraslado();
                }
                else if (EstadoBandera == "DESPACHO")
                {
                    // Cacela el proceso que se esta realizando
                    Cancelar();
                }
            }
            catch (Exception)
            { 
                    // Mensaje cuando envia la excepcion
            }


        }
        #endregion

        #region CLIC EN EL GRID --------------------//

            #region CLIC EN EL GRID
        
        private void clicGRID()
        {
            int Indice = dgProformaProducto.CurrentRowIndex;
            txtCodProducto.Text=dgProformaProducto[Indice, 1] +"-"+  dgProformaProducto[Indice, 2];
        }
        
        #endregion

            #region DOBLE CLIC ENE L GRID
        
        private void productoSeleccionado()
        {
               string  CodPro="", Nombre="";
               int  Cantidad=0;
               int IndicePrincipal;
               IndicePrincipal = dgProformaProducto.CurrentRowIndex;
               string EstadoSoli = "";
               
               bool Bandera = false;
              
               // Obtiene la cantidad de Proforma de Compra
               string codProCompa = Convert.ToString(dgProformaProducto[IndicePrincipal, 1]);

               try
               {
                   foreach (var Item in ListaProducto)
                   {

                       //Codigo del producto
                       CodPro = Item.productos.productosPK.codProd;

                       // Compara si el codigo que esta escaneando
                       // Se encuentra en la lista pendiente pendiente 
                       // de poner en despacho
                       if (CodPro==codProCompa)
                       {
                          
                           //Estadi de la proforma
                           Estado = Item.estado.ToString();
                           //Codifo del estado de la proform
                           DetProforma = Convert.ToInt32(Item.detSolicitudPK.codDetSolicitud);
                           //Nombre del producto que va a despachar
                           Nombre = Item.productos.nombre.ToString();
                           //Indice del producto-Posicion del producto que se va Pikear
                           //Cantidad que se esta despachando
                           Cantidad = Convert.ToInt32(Item.cantidadRecibida);
                           //bandera para ver si encontro o no el producto
                           Bandera = true;
                          //Obteniendo el estado de la solictud
                           EstadoSoli = Item.solicitud.estado;
                       }
                   }

                 // revisa el resultado que  obtiene en la bandera 
                   if (Bandera == true)
                   {

                       //Pregunta si e producto esta pickeado (P)
                       if (Estado == "P" && EstadoSoli=="P")
                       {
                           ClicGridDespacho(DetProforma, CodPro, Nombre, Cantidad, Estado);
                       }

                       //Pregunta si e producto no esta pickeado (N)
                       else if (Estado == "N")
                       {
                           Siguiente(IndicePrincipal);
                       }
                       
                       //Pregunta si e producto esta en estado despachado
                       else if (Estado == "D")
                       {
                           MessageBox.Show("Producto ha sido despachado");
                           txtCodProducto.Text = "";
                           txtCodProducto.Focus();
                       }
                       else
                       {
                           txtCodProducto.Text = "";
                           txtCodProducto.Focus();
                       }


                   }
                   else//Cierra el If que determina que el producto encontrado es el correcto
                   {
                       txtCodProducto.Text = "";
                       MessageBox.Show("Producto no pertenece al listado a despachar");
                       txtCodProducto.Focus();
                   }
               }
               catch (Exception)
               {
                  //Error de lo que esta pasando
                   txtCodProducto.Focus();
               }
        }
        #endregion

        #endregion
            
        #region CUANDO SE PRESIONA UNA TECLA ----------------------------//
        //Accion cuando presiona un tecla, independiente la que sea
        private void wf_DespachoProducto_KeyDown(object sender, KeyEventArgs e)
        {

        }


        private void txtCodProducto_KeyUp(object sender, KeyEventArgs e)
        {
            //Cuando presiona la tecla de scaneo de codigo de barra
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {
                
                //Código de producto
              
                if (txtCodProducto.Text != "")
                {

                    // Ejecuta accion con producto seleccionado
                    productoSeleccionado();
                }
                else
                {
                    // En caso que la caja de texto este vacia
                    txtCodProducto.Focus();
                }
            }
        }
        #endregion

        #region CLIC EN EL BOTON SIGUIENTE ----------------------------------//
        private void btnSiguiente_Click(object sender, EventArgs e)
        {
            string EstadoProducto = Convert.ToString(dgProformaProducto[0, 4]);

            if (EstadoProducto != "D")
            {
                Siguiente(0);
            }
            else
            {
                MessageBox.Show("Producto ha sido despachado");
                txtCodProducto.Text = "";
                txtCodProducto.Focus();
            }
        }
        #endregion

        #region MUESTRA EL DETALLE DEL PRODUCTO -----------------------//
       
        private void Siguiente( int Indice)
        {
           
            wf_DespachoProductoValidacion fm = new wf_DespachoProductoValidacion(Compa, Bodega, UsuarioSistema, Proforma, Indice, EstadoBandera, NombreProforma, Estadoprof);
            fm.Show();
            fm.Activate();
            this.Visible = false;
        }
        
        #endregion

        #region COLOR FILA----------------------------//
       
        private void colorFila()
        {

            //try
            //{
            //    clsColorFilaGrid col = new clsColorFilaGrid(dgProformaProducto);
            //    col.ColorEspecial = Color.YellowGreen;
            //    col.ColorOriginal = Color.WhiteSmoke;
            //    col.ColorTextoEspecial = Color.Black;
            //    col.ColorTextoOriginal = Color.Black;
            //    col.TextoAEvaluar = "P";
            //}
            //catch (Exception)
            //{
            //    //Mensaje de error colores del GRID no funcionan
            //}


        }
        #endregion

        #region PONIENDO COLOR A LA FILAS DEL GRID SEGUN EL ESTADO------------------------//

        private void wf_DespachoProducto_Load(object sender, EventArgs e)
        {
            colorFila();
        }
        #endregion
   
        #region OPCIONES DE CLIC EN EL GRID --------------------------------//

        private void dgProformaProducto_Click(object sender, EventArgs e)
        {
            //Id Estado proforma 

            //if (EstadoProforma != 5)
            //{
                clicGRID();
            //}

           
        }

        private void dgProformaProducto_DoubleClick(object sender, EventArgs e)
        {
            if (txtCodProducto.Text != "")
            {
                // Ejecuta accion con producto seleccionado
                productoSeleccionado();
            }
            else
            {
                // En caso que la caja de texto este vacia
                txtCodProducto.Focus();
            }
        }

        #endregion

        private void chkSeleccioneTodos_Click(object sender, EventArgs e)
        {
            
            //Revisa si ha chekeado la opcion de poner todos los productos en Area de despacho
            if (chkSeleccioneTodos.Checked == true)
            {
                txtCodProducto.ReadOnly = true;
                TodosDespacho();
            }
            else
            {
                txtCodProducto.ReadOnly = true;
            }
        }


        #region CUANDO SE QUIERE OPERAR TODOS LOS DATOS ---------------------------------------//
        private void TodosDespacho()
        {
            string CodPro = "", Nombre = "";
            int Cantidad = 0;
            string EstadoSoli = "";

            bool Bandera = false;

            // Obtiene la cantidad de Proforma de Compra
            string codProCompa = Convert.ToString(dgProformaProducto[0, 1]);

            try
            {
                
                foreach (var Item in ListaProducto)
                {

                    //Codigo del producto
                    CodPro = Item.productos.productosPK.codProd;
                     var estado = Item.estado;

                    if (estado == "D")
                    {
                        MessageBox.Show("Uno o todos los productos de esta proforma ya han sido despachados");
                        chkSeleccioneTodos.Checked = false;
                        return;
                    }


                    // Compara si el codigo que esta escaneando
                    // Se encuentra en la lista pendiente pendiente 
                    // de poner en despacho
                    if (CodPro == codProCompa)
                    {

                        //Estadi de la proforma
                        Estado = Item.estado.ToString();
                        //Codifo del estado de la proform
                        DetProforma = Convert.ToInt32(Item.detSolicitudPK.codDetSolicitud);
                        //Nombre del producto que va a despachar
                        Nombre = Item.productos.nombre.ToString();
                        //Indice del producto-Posicion del producto que se va Pikear
                        //Cantidad que se esta despachando
                        Cantidad = Convert.ToInt32(Item.cantidadRecibida);
                        //bandera para ver si encontro o no el producto
                        Bandera = true;
                        //Obteniendo el estado de la solictud
                        EstadoSoli = Item.solicitud.estado;
                    }
                }

                // revisa el resultado que  obtiene en la bandera 
                if (Bandera == true)
                {

                    //Pregunta si e producto esta pickeado (P)
                   
                        DespachoTodos(DetProforma, CodPro, Nombre, Cantidad, Estado);
                   
                           


                }
               
            }
            catch (Exception)
            {
                //Error de lo que esta pasando
                txtCodProducto.Focus();
            }
        }
        
        #endregion

        private void dgProformaProducto_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                if (txtCodProducto.Text != "")
                {
                    // Ejecuta accion con producto seleccionado
                    productoSeleccionado();
                }
                else
                {
                    // En caso que la caja de texto este vacia
                    txtCodProducto.Focus();
                }
            }
            if (e.KeyCode == Keys.Up || e.KeyCode == Keys.Down)
            {
                clicGRID();
            }
        }

    }


  

  
}