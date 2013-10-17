using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.wsTraslado;
using biliotecaVIDUC;

namespace viducWMS
{
    public partial class wf_DespachoProductoValidacion : Form
       
    {

        #region VARIABLES GLOBALES ---------------------------------------//
       
        //inicialización de Variables Globales
        private static int Compa;
        private static string UsuarioSistema;
        private static int Bodega;
        private static int Proformas;
        //public static int CodigoProducto;
        public static string NombreProducto;
        public static int Cantidades;
        public static string Ubicaciones;
        public static string NombreProforma;
        public static int DetEstado;
        public static string  EstadoCancelarF;
        private static int EstadoProforma;
        
        public static int index;
        public static int IndiceRegistro;
      

        #endregion

        #region LLAMANDO LA CAPA DE SERVICIOS--------------------------------------//

        viducWMS.wsTraslado.wsTrasladoBodegaBodega Proxy = new viducWMS.wsTraslado.wsTrasladoBodegaBodega();
        List<detSolicitud> ListaProducto = new List<detSolicitud>();
        List<ubicacionProducto> Ubicacion = new List<ubicacionProducto>();
       
        #endregion

        #region PARAMETRO GLOBALES ------------------------------//

        public wf_DespachoProductoValidacion(int IdCompania, int IdBodega, string IdUsuario, int IdProforma, int Indice, string EstadoCancelar, string NombrePro, int IdEstadoProforma)
        {
            InitializeComponent();
            // Obtiene Compañia
            Compa=IdCompania;
            // Obtiene Bodega
            Bodega=IdBodega;
            // Usuario del sistema
            UsuarioSistema= IdUsuario;
            // Proformas que se esta trabajando
            Proformas = IdProforma;
            // Codigo detalle de proforma
            txtCodProforma.Text = IdProforma.ToString();
            // Indice del registro 
            IndiceRegistro = Indice;
            // Llenando el registro del GRID 
            ListadoRegistroGrid(Indice);
            // Cantidad de picking completo  
            chkImcompletoPicking.Enabled = false;
            // Valida la ubicacion del producto
            txtValidarUbicacion.Focus();
            // Cantidad piking
            txtCantidadPicking.Text = "";
            // Despacho producto cancelar
            EstadoCancelarF = EstadoCancelar;
            // Nombre de la Proforma
            NombreProforma = NombrePro;
            // Estado de la proforma
            EstadoProforma = IdEstadoProforma;
        }

        #endregion
        
        #region ACTIVAR O DESACTIVAR  OBJETOS-----------------------//

        private void EstadoObjeto(bool Estado)
        {
            txtValidarCondigo.Enabled = Estado;
            txtValidarUbicacion.Enabled = Estado;
            txtCodConfirmacion.Enabled = Estado;
            
        }
        
        #endregion
             
        #region LISTADO DE PRODUCTOS A RECORRER -------///

   
        private void ListadoRegistroFinal()
        {

            string UbicacionProducto="";

            try
            {
                //Obteniendo el listado de productos que se van a recoger
                ListaProducto = Proxy.findProductosProforma(Compa, true, Proformas, true).ToList<detSolicitud>();

                string CodProducto;
                string Estado;
                
                if (index >= 0 && index < ListaProducto.Count)
                {
                    //Obteniendo el codigo del producto
                    CodProducto = Convert.ToString(ListaProducto[ListaProducto.Count - 1].productos.productosPK.codProd);
                    txtCodigo.Text = CodProducto.ToString();
                    txtCantidad.Text = ListaProducto[ListaProducto.Count - 1].cantidadSolicitada.ToString();
                    txtDescripcion.Text = ListaProducto[ListaProducto.Count - 1].productos.nombre.ToString();
                    txtCantidadPicking.Text = ListaProducto[index].cantidadDespachada.ToString();
                    chkImcompletoPicking.Checked = Convert.ToBoolean(ListaProducto[index].incompleta);
                    Estado = ListaProducto[index].estado.ToString();
                    DetEstado = Convert.ToInt32(ListaProducto[index].detSolicitudPK.codDetSolicitud);


                   //Muestra todas las ubicaciones de todos los productos 
                    Ubicacion = Proxy.findUbicacionesBodegaProducto(Compa, true, Bodega, true, CodProducto).ToList<ubicacionProducto>();

                    //Determinando si el producto de la ubicacion
                    if (Ubicacion != null)
                    {
                        foreach (var UbicacionItem in Ubicacion)
                        {
                            //Obtiene la ubicacion del producto por: Anaquel+Area+Nivel;
                            UbicacionProducto = UbicacionItem.ubicacionProductoPK.anaquel + UbicacionItem.ubicacionProductoPK.area + UbicacionItem.ubicacionProductoPK.nivel;
                            // Ubicacion de los productos
                            txtUbicacion.Text = UbicacionProducto.ToString();
                            // Unidades Existentes
                            txtUniExistencia.Text = UbicacionItem.cantidad.ToString() + " Uni.";
                        }
                    }



                    if (Estado == "N")
                    {
                        txtEstado.Text = "No";
                        txtValidarUbicacion.Focus();
                        EstadoObjeto(true);
                        txtValidarUbicacion.Text = "";
                        txtValidarCondigo.Text = "";
                        txtCantidadPicking.Text = "";
                        txtCodConfirmacion.Text = "";
                        chkImcompletoPicking.Checked = false;
                    }
                    else if (Estado == "P")
                    {
                        txtEstado.Text = "Pickeado";
                        EstadoObjeto(false);
                        txtCantidadPicking.Enabled = false;
                        txtValidarCondigo.Text = CodProducto.ToString();
                        txtValidarUbicacion.Text = txtUbicacion.Text;
                        txtCantidadPicking.Text = ListaProducto[index].cantidadDespachada.ToString();
                        txtCodConfirmacion.Text = txtUbicacion.Text;


                    }

                }


            }
            catch (Exception)
            { 
              //Mensaje de error de lo que ha ocurrido
            }

        }

        private void ListadoRegistroInicio()
        {

            string UbicacionProducto="";
            try
            {
                //Obteniendo el listado de productos que se van a recoger
                ListaProducto = Proxy.findProductosProforma(Compa, true, Proformas, true).ToList<detSolicitud>();

                string CodProducto;
                string Estado;
                if (index >= 0 && index < ListaProducto.Count)
                {
                    //Obteniendoe el codigo del producto
                    CodProducto = Convert.ToString(ListaProducto[0].productos.productosPK.codProd);
                    txtCodigo.Text = CodProducto.ToString();
                    //Obteniendo la cantidad de productos que se van a despachar
                    txtCantidad.Text = ListaProducto[0].cantidadSolicitada.ToString();
                    // Obteniendo descripcion del producto
                    txtDescripcion.Text = ListaProducto[0].productos.nombre.ToString();
                    //Canbtidad de producto Pickeada
                    txtCantidadPicking.Text = ListaProducto[index].cantidadDespachada.ToString();
                    //Determina si hay producto faltante en base a los solicitado
                    chkImcompletoPicking.Checked = Convert.ToBoolean(ListaProducto[index].incompleta);
                    //Obtiene el estado de producto que se esta pickeando
                    Estado = ListaProducto[index].estado.ToString();

                    DetEstado = Convert.ToInt32(ListaProducto[index].detSolicitudPK.codDetSolicitud);


                    // Obteniendo la ubicacion de producto----------//
                    Ubicacion = Proxy.findUbicacionesBodegaProducto(Compa, true, Bodega, true, CodProducto).ToList<ubicacionProducto>();

                    //Determinando si el producto de la ubicacion
                    if (Ubicacion != null)
                    {
                        foreach (var UbicacionItem in Ubicacion)
                        {
                            //Obtiene la ubicacion del producto por: Anaquel+Area+Nivel;
                            UbicacionProducto = UbicacionItem.ubicacionProductoPK.anaquel + UbicacionItem.ubicacionProductoPK.area + UbicacionItem.ubicacionProductoPK.nivel;
                            //Ubicacion de los productos
                            txtUbicacion.Text = UbicacionProducto.ToString();
                            txtUniExistencia.Text = UbicacionItem.cantidad.ToString() + " Uni.";
                        }
                    }

                   

                    //Obteniendo el estado de l producto si ha sido pickeado o no
                    //N= No Pickeado
                    //P= Pickeado
                    if (Estado == "N")
                    {
                        txtEstado.Text = "No";
                        txtValidarUbicacion.Focus();
                        EstadoObjeto(true);
                        txtValidarUbicacion.Text = "";
                        txtValidarCondigo.Text = "";
                        txtCantidadPicking.Text = "";
                        txtCodConfirmacion.Text = "";
                        chkImcompletoPicking.Checked = false;
                    }
                    else if (Estado == "P")
                    {
                        txtEstado.Text = "Pickeado";
                        EstadoObjeto(false);
                        txtCantidadPicking.Enabled = false;
                        txtValidarCondigo.Text = CodProducto.ToString();
                        txtValidarUbicacion.Text = txtUbicacion.Text;
                        txtCantidadPicking.Text = ListaProducto[index].cantidadDespachada.ToString();
                        txtCodConfirmacion.Text = txtUbicacion.Text;


                    }

                }
            }

            catch (Exception)
            { 
            //Error que general la aplicacion
            }



        }

        private void ListadoRegistroGrid(int Indice)
        {
         try
          {

            string UbicacionProducto = "";
           
                
            // Obteniendo el listado de productos que se van a recoger
            ListaProducto = Proxy.findProductosProforma(Compa, true, Proformas, true).ToList<detSolicitud>();

            string CodProducto;
            string Estado;
            // String Cantidad Pikeada;

          

            if (Indice >= 0 && Indice < ListaProducto.Count)
            {
                //Obteniendo el codigo del producto
                CodProducto = Convert.ToString(ListaProducto[Indice].productos.productosPK.codProd);
                txtCodigo.Text = CodProducto.ToString();
                
                //------------------------------revisar -----------------------------------------------//
                // Cantidad encontrada
                txtCantidad.Text = ListaProducto[Indice].cantidadSolicitada.ToString();
                // Descripcion del producto-Nombre
                txtDescripcion.Text = ListaProducto[Indice].productos.nombre.ToString();
                // Cantidad que se esta pickeando  
                txtCantidadPicking.Text = ListaProducto[Indice].cantidadDespachada.ToString();
                // Determina si esta incompleto o no la cantidad que se esta pickeando
                chkImcompletoPicking.Checked = Convert.ToBoolean(ListaProducto[Indice].incompleta);
                // Estado en que esta el producto, este puede ser N-Solicitado, P-Pickeado
                Estado = ListaProducto[Indice].estado.ToString();
                // Estado del detalle del producto
                DetEstado = Convert.ToInt32(ListaProducto[Indice].detSolicitudPK.codDetSolicitud);

               // Obtiene la ubicación del producto
               Ubicacion = Proxy.findUbicacionesBodegaProducto(Compa, true, Bodega, true, CodProducto).ToList<ubicacionProducto>();
              

                // Determinando si el producto de la ubicacion
                if (Ubicacion != null)
                {
                    foreach (var UbicacionItem in Ubicacion)
                    {
                        // Obtiene la ubicacion del producto por: Anaquel+Area+Nivel;
                        UbicacionProducto = UbicacionItem.ubicacionProductoPK.anaquel + UbicacionItem.ubicacionProductoPK.area + UbicacionItem.ubicacionProductoPK.nivel;
                        // Ubicacion del producto
                        txtUbicacion.Text = UbicacionProducto.ToString();
                        // Unidades existentes para el producto en la ubicacion
                        txtUniExistencia.Text = UbicacionItem.cantidad.ToString() + " Uni.";
                    }
                }



                //Obteniendo el estado de l producto si ha sido pickeado o no
                //N= SOLICITADO
                //P= PICKEADO
                if (Estado == "N")
                {
                    txtEstado.Text = "SOLICITADO";
                    txtValidarUbicacion.Focus();
                    EstadoObjeto(true);
                    txtValidarUbicacion.Text = "";
                    txtValidarCondigo.Text = "";
                    txtCantidadPicking.Text = "";
                    txtCodConfirmacion.Text = "";
                    chkImcompletoPicking.Checked = false;
                }
                else if (Estado == "P")
                {
                    txtEstado.Text = "PICKEADO";
                    EstadoObjeto(false);
                    txtCantidadPicking.Enabled = false;
                    txtValidarCondigo.Text = CodProducto.ToString();
                    txtValidarUbicacion.Text = txtUbicacion.Text;
                    txtCantidadPicking.Text = ListaProducto[index].cantidadDespachada.ToString();
                    txtCodConfirmacion.Text = txtUbicacion.Text;


                }

            }

                }
             catch (Exception)
             {
                 //Error que se esta produciendo  si no hay ubicacion
             }


        }

        #endregion

        #region   OPCIONES DE CLIC DE BOTON ---------------------------//

        private void btnSiguiente_Click(object sender, EventArgs e)
        {
            index++;
            //Pregunta si esta en la ultima posicion del registro
            if (index > ListaProducto.Count - 1)
            {
                //Muestra el mensaje si lleha a l ultimo registro
                MessageBox.Show("Este es el último registro de la lista");
                index--;
            }
           
           ListadoRegistroGrid(index);
           
        }

        private void btnAnterior_Click(object sender, EventArgs e)
        {
            index--;
             // Si regresa el primer registro 
           if (index < 0)
            {
                MessageBox.Show("Este es el primer registro de la lista");
                index++;
            }
            ListadoRegistroGrid(index);
        }

        private void btnFin_Click(object sender, EventArgs e)
        {
            index=0;
            ListadoRegistroGrid(index);
        }

        private void btnFinal_Click(object sender, EventArgs e)
        {
            ListadoRegistroFinal();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            Cancelar();
        }

      
        #endregion

        #region VALIDANDO UBICACION Y CODIGO DE PRODUCTO  ----------------//

        private void validarProducto()
        {
        
          int Anaquel=0, Nivel=0, LargoCadena;
           string Area="", Cadena;
            if (txtUbicacion.Text!="")
           {
             LargoCadena= txtValidarUbicacion.Text.Length;
             Cadena=txtValidarUbicacion.Text;
               
                if (LargoCadena==4)
                {
                //Obteniendo el anaquel de la Ubicacion
                    Anaquel=Convert.ToInt32(Cadena.Substring(0,2));
                //Obteniendo el Area de la Ubicacion
                    Area=Cadena.Substring(2,1);
                //Obteniendo el Nivel de la ubicacion del producto
                    Nivel=Convert.ToInt32(Cadena.Substring(3,1));
                }
                else if (LargoCadena==3)
                {
                //Obteniendo el anaquel de la Ubicacion
                    Anaquel=Convert.ToInt32(Cadena.Substring(0,1));
                //Obteniendo el Area de la Ubicacion
                    Area=Cadena.Substring(1,1);
                //Obteniendo el Nivel de la ubicacion del producto
                    Nivel=Convert.ToInt32(Cadena.Substring(2,1));
                }

           }
            if (txtValidarUbicacion.Text != "")
            {
                
                    bool validacion=Proxy.validarProductoUbicacionPicking(Compa, true,  Bodega,true,  Anaquel, true, Area, Nivel, true, txtCodigo.Text);
                    if (validacion==true)
                    {
                        txtCantidadPicking.Enabled = true;
                        txtCantidadPicking.ReadOnly = false;
                       txtCantidadPicking.Focus();
                    }
                    else
                    {
                    MessageBox.Show("Código o ubicación de producto incorrecta");
                    txtValidarUbicacion.Text = "";
                    txtValidarCondigo.Text = "";
                    txtValidarCondigo.Focus();
                    }
                }
           
        }

    #endregion

        #region CANCELAR--------------------------//
        
        private void Cancelar()
        {
            wf_DespachoProducto fm= new wf_DespachoProducto(Compa, Proformas, UsuarioSistema, Bodega, NombreProforma, EstadoProforma, EstadoCancelarF);
            fm.Show();
            fm.Activate();
            this.Visible=false;

        }
    #endregion

        #region OPCIONES DE TECLADO -------------------------//

        private void txtValidarCondigo_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {
                if (txtValidarCondigo.Text!= "")
                {
                    txtCantidadPicking.Focus();
                }
                else
                {
                    MessageBox.Show("Escanee código del producto");
                    txtValidarCondigo.Focus();
                }
            }
            if (e.KeyCode == Keys.Down)
            {
                txtCantidadPicking.Focus();
            }
            if (e.KeyCode == Keys.Up)
            {
                txtValidarUbicacion.Focus();
            }
        }

    
        private void txtValidarUbicacion_KeyUp(object sender, KeyEventArgs e)
        {
            //Cuando presiona la tecla
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {

                if (txtValidarUbicacion.Text != "")
                {
                    txtValidarCondigo.Focus();
                }
                else
                {
                    MessageBox.Show("Escaneé la ubicación del producto");
                    txtValidarUbicacion.Focus();
                  
                }
            }
            if (e.KeyCode == Keys.Down)
            {
                txtValidarCondigo.Focus();
            }

            
        }

       
        #endregion

        #region GUARDAR CANTIDAD DE PRODUCTOS-----------------------//

        private void CantidadProducto()
        {

            int Anaquel = 0, Nivel = 0, LargoCadena;
            string Area = "", Cadena;
            int CantidadSolicitada, CantidadConfirmada;
            

            //Pregunta que las cajas de texto esta vacia

            if (txtValidarUbicacion.Text != "" && txtCodConfirmacion.Text != "" && txtCantidadPicking.Text != "")
            {
                LargoCadena = txtValidarUbicacion.Text.Length;
                Cadena = txtValidarUbicacion.Text;
                bool Imcompleto, Resultado = false, Pickeado;
                //Obteniendo la cantidad de producto solicitada
                CantidadSolicitada = Convert.ToInt32(txtCantidad.Text);
                //Cantidad de producto encontrado y a confirmar
                CantidadConfirmada = Convert.ToInt32(txtCantidadPicking.Text);

                if (CantidadConfirmada <= CantidadSolicitada)
                {
                    

                    if (CantidadConfirmada < CantidadSolicitada)
                    {
                        chkImcompletoPicking.Checked = true;
                    }
                    //Obteniendo el valor de si ha sido chekeado o no el producto
                    Imcompleto = chkImcompletoPicking.Checked;

                    if (LargoCadena == 4)
                    {
                        //Obteniendo el anaquel de la Ubicacion
                        Anaquel = Convert.ToInt32(Cadena.Substring(0, 2));
                        //Obteniendo el Area de la Ubicacion
                        Area = Cadena.Substring(2, 1);
                        //Obteniendo el Nivel de la ubicacion del producto
                        Nivel = Convert.ToInt32(Cadena.Substring(3, 1));

                    }
                    else if (LargoCadena == 3)
                    {
                        //Obteniendo el anaquel de la Ubicacion
                        Anaquel = Convert.ToInt32(Cadena.Substring(0, 1));
                        //Obteniendo el Area de la Ubicacion
                        Area = Cadena.Substring(1, 1);
                        //Obteniendo el Nivel de la ubicacion del producto
                        Nivel = Convert.ToInt32(Cadena.Substring(2, 1));
                     
                    }

                    try
                    {
                        Resultado = Proxy.pickingProductoProforma(Compa, true,
                                                                       Proformas, true,
                                                                       DetEstado, true,
                                                                       txtValidarCondigo.Text,
                                                                       Bodega, true,
                                                                       Anaquel, true,
                                                                       Area, Nivel, true,
                                                                       Convert.ToInt32(txtCantidadPicking.Text), true, Imcompleto, true);
                    }
                    catch (Exception)
                    {
                       //Envia un mensaje de que se ha dado una excepcion
                        LimpiarTXT(); 
                    }

                    if (Resultado == true)
                    {

                       

                        DialogResult mensaje = MessageBox.Show("¿Listado de productos ha sido pickeado, Desea continuar?", "VIDU WMS", MessageBoxButtons.YesNo, MessageBoxIcon.Question, MessageBoxDefaultButton.Button1);

                        if (mensaje == DialogResult.Yes)
                        {
                            //Icrementa en una unidad el indice del registro para continuar aumentando
                            IndiceRegistro = IndiceRegistro + 1;

                            ListadoRegistroGrid(IndiceRegistro);

                            //Verifica si el listado ha sido cerrado con exito

                            Pickeado = Proxy.verificarPickingProforma(Compa, true, Proformas, true);
                          
                            if (Pickeado == true)
                            {
                                // 
                                MessageBox.Show("Lista ha sido pickeada con éxito");
                                Cancelar();
                            }
                        }

                        else
                        {
                            Cancelar();
                        }

                        //Pickeado = Proxy.verificarPickingProforma(Compa, true, Proformas, true);
                        //if (Pickeado == true)
                        //{

                        //    MessageBox.Show("Lista ha sido pickeada con éxito");
                        //    Cancelar();
                        //}
                        
                        
                    }
                    else
                    {
                        MessageBox.Show("Producto no ha sido pickeado");
                        //Limpia las cajas de texto 
                        LimpiarTXT();
                    }


                } //Cierra el if que pregunta que la cantidad no debe ser excedida  a la solicitada

                else
                {
                    MessageBox.Show("Cantidad confirmada no puede exceder la solicitada");
                    LimpiarTXT();
                }
            
            
            }  
           

        }

        #endregion

        #region CANCELAR DESPACHO -----------------------//

        private void CancelarDespacho()
        {
            wf_Despacho fm = new wf_Despacho(Compa, Bodega, UsuarioSistema);
            fm.Show();
            fm.Activate();
            this.Visible = false;
        }

        private void CancelarTraslado()
        {
            wf_SolicitudTransalado fm = new wf_SolicitudTransalado(Compa, Bodega, UsuarioSistema);
            fm.Show();
            fm.Activate();
            this.Visible = false;
        }
        #endregion

        #region    PRESIONANDO TECLA -----------------------//

        private void txtCantidadPicking_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != (char)Keys.Enter)
            {
                clsFuncionesGenerales.SoloNumero(e);
            }
        }

        private void txtCodConfirmacion_KeyUp(object sender, KeyEventArgs e)
        {

          //Determina la tecla de Scan que se ha presionado
          if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
           {
            
            if( txtCodConfirmacion.Text!="")
            {
           
                //Variables de declaracion 
                string Ubicacion1, Ubicacion2, Ubicacion3;
                string codProd1, CodProd2;
                Ubicacion1 = txtUbicacion.Text;
                Ubicacion2 = txtValidarUbicacion.Text;
                Ubicacion3 = txtCodConfirmacion.Text;

                codProd1 = txtCodigo.Text;
                CodProd2 = txtValidarCondigo.Text;

                if (Ubicacion1 == Ubicacion2 && Ubicacion2 == Ubicacion3 && codProd1 == CodProd2)
                {

                    CantidadProducto();
                }
                else
                {
                    MessageBox.Show("Producto o ubicación no coinciden, favor verificar");
                    LimpiarTXT();

                }
            }  //Cierra el IF
           
            else
            {
                MessageBox.Show("Escanee ubicación para confirmación");
                txtCodConfirmacion.Focus();
            }
            }
          if (e.KeyCode == Keys.Up)
          {
              txtCantidadPicking.Focus();
          }

        }

        #endregion

        #region LIMPIAR CAJAS DE TEXTO -----------------------//

            private void LimpiarTXT()
        {
            txtCantidadPicking.Text = "";
            txtCodConfirmacion.Text = "";
            txtValidarCondigo.Text = "";
            txtValidarUbicacion.Text = "";
            txtValidarUbicacion.Focus();
        }

        #endregion

        #region VA AL PRIMER REGISTRO DE LA LISTA --------------------------------//
       
        private void btninicio_Click(object sender, EventArgs e)
        {
           ListadoRegistroInicio();
        }
       
        #endregion 

        private void txtCantidadPicking_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Down || e.KeyCode == Keys.Enter)
            {
                txtCodConfirmacion.Focus();
            }
            if (e.KeyCode == Keys.Up)
            {
                txtValidarCondigo.Focus();
            }
        }
    
    
    }
}