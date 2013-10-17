using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.ws_Servicios;
using VIDUC;
using colorFilaGrid.colorFila;
using biliotecaVIDUC;


namespace viducWMS
{
    public partial class wf_Recepcion : Form
    {
       

        #region VARIABLES GLOBALES ---------------------------------//
       
        //inicialización de Variables Globales
        public static int Compa;
        public static int Solicitudes;
        public static int  BodegaActual;
        public static int codProduct;
        public static string Anaquel;
        public static string Area;
        public static string Nivel;
        public static int Cantidades;
        public static string EstadoProducto;
        public static string ubicaciones;
        public static string Descrip;
        public static string UsuarioSistema;
        public static string CodigoProducto;
        public static int UnidadesSolicitadas;

        #endregion
           
        #region Llamando la capa de servicios ----------------------------//                
            viducWMS.ws_Servicios.VIDUCWebService Proxy = new viducWMS.ws_Servicios.VIDUCWebService();
            List<detSolicitud> detalleSolicitud = new List<detSolicitud>(); 
        #endregion

        #region METODO GENERAL DE CAPTURA DEL PARAMETROS ---------------------------------//

        public wf_Recepcion(int Compania, int solicitud, int Bodegas, string Usuario)
        {
            InitializeComponent();
            Compa =Compania;
            Solicitudes = solicitud;
            BodegaActual = Bodegas;
            UsuarioSistema = Usuario;
            // Cargar informacion del GRIDgf
            CargarGrid();
            dgUbicaciones.Focus();
            clicGRID();
          
        }
        #endregion
        
        #region CARGAR DATOS ----------------------------//
        private void CargarGrid()
        {
            try
            {
                //Obtiene el listado de los productos
                //Codigo producto
                //Descripcion del producto
                //Cantidad solicitada
                //Cantidad recibida
                //Estado de producto
                detalleSolicitud = Proxy.findDetallesSolicitud(Compa, true, Solicitudes, true).ToList<detSolicitud>();
                //Cargar los productos en el GRID
                dgUbicaciones.DataSource = crearGrid();
            }
            catch (Exception ex)
            {
                //Notifica que la lista no encontro ningun valor
                MessageBox.Show(ex.Message);
            }
        }
        #endregion

        #region CREANDO EL GRID  ------------------------------//

        private DataTable crearGrid()
        { 
         
            DataTable dt = new DataTable();
            dt.Columns.Add("Correlativo");
            dt.Columns.Add("Código producto");
            dt.Columns.Add("Descripción");
            dt.Columns.Add("U.Medida");
            dt.Columns.Add("Cantidad solicitada");
            dt.Columns.Add("Cantidad recibida");
            dt.Columns.Add("Proveedor");
            dt.Columns.Add("Estado");
            
            DataRow row = dt.NewRow();
            string Estado = "";
            string orden = string.Empty;
            string proveedor = string.Empty;
            foreach (var item in detalleSolicitud)
            {
                row = dt.NewRow();
                //Revisar orden de compra si es el codico correcto
               // item.productos.
               // item.solicitud.ordenCompra.codProv;
                row["Correlativo"]=item.detSolicitudPK.codDetSolicitud.ToString();   
                row["Código producto"] = item.productos.productosPK.codProd.ToString();
                row["Descripción"] = item.productos.nombre.ToString();
                row["U.Medida"] = item.productos.unidadMedida;
                row["Cantidad solicitada"] = item.cantidadSolicitada.ToString();
                row["Cantidad recibida"] = item.cantidadRecibida.ToString();
                row["Proveedor"] = item.productos.proveedores.nombre.ToString();
                //Determinar recibido 
                //Estado de producto
                Estado=Convert.ToString(item.estado.Trim());
                //Verifica los estados
                if (Estado == "I")
                {
                    row["Estado"] = "IMCOMPLETO";
                }
                else
                    if (Estado == "C")
                    {
                        row["Estado"] = "SOLICITADO";
                    }
                    else
                    {
                        row["Estado"] = "RECIBIDO";
                    }                  
                dt.Rows.Add(row);
           
               }

            //lblEncabezado.Text = "No Orden de Compra: " + orden + " - Proveedor: " + proveedor;
            return dt;

       
        
        }
        #endregion

        #region SERVICIO QUE ACTUALIZA LOS DATOS -----------------------//

        private void ActualizarRecibido(int Orden)
        {

            try
            {
                //Obtiene elc odigo del producto
                string codproducto = Convert.ToString(txtCodProducto.Text);
                //Cantidad de producto que se esta recibiendo
                int cantidad = Convert.ToInt32(txtUnidadesRecibidas.Text);
                bool resultado, resultadocierre;

                //Actualiza los datos
                resultado = Proxy.recibirProducto(Compa, true, Solicitudes, true, Orden, true, cantidad, true, txtFactura.Text.Trim());
                //Pregunta si la bandera ha retornado algun valor
                if (resultado == true)
                {

                    //Muestra el mensaje de que producto ha sido recibido con exito
                    //Mensaje que se tiene que entragar al usuario 
                    MessageBox.Show("Producto ha sido recibido exitosamente");
                    //Resultado de cierre de verificacion de solicitud
                    resultadocierre = Proxy.verificarRecepcionSolicitud(Compa, true, Solicitudes, true);
                    //Pregunta el resultado obtenido es TRUE
                    if (resultadocierre == true)
                    {
                        //Confirma que la solicitud ha sido cerrada con exito con todos sus productos
                        MessageBox.Show(clsMensajesGenerales.SolicitudCerrada());
                        // Llamar en metodo cancelar que regresa al registro padre
                        Cancelar();
                    }
                    //Limpiar cajas de texto
                    limpiarTXT();
                    clicGRID();
                }
                else
                {
                    MessageBox.Show("Cantidad de producto recibido, no puede ser mayor o menor al margen de tolerancia:(+/-)" + clsLeerXML.MasMenos);
                    limpiarTXT();
                }

            }
            catch (Exception)
            { 
                //Mensaje de la exepcion que que prococo la ejecucion del servicio
              
            }
        }

        #endregion 
           
        #region CANCELAR ----------------------------------------///

        private void Cancelar()
        {
            wf_Solicitudes fm = new wf_Solicitudes(Compa, BodegaActual, UsuarioSistema);
            fm.Show();
            fm.Activate();
            this.Visible = false;

        }
        #endregion

        #region PRODUCTO RECIBIDO  --------------------------------//

        private void ProductoRecibido()
        {

               string EstadoEncontrado = "";
               string IdProducto = "";
               bool Encontrado = false;
               int Orden = 0;
               int porcentaje;
               int Unidades=0, unidadesMas=0, UnidadesMenos=0;
               double masMenos=0;
               int UnidadesPikeadas = 0, totalUnidades=0;
            
              // Magnificaciones unidades 
 
               if (txtFactura.Text != "" && txtCodProducto.Text != "" && txtUnidadesRecibidas.Text != "")
                {

                    // Revisando sin producto pertenece a la lista
                   
                   foreach (var item in detalleSolicitud)
                    {
                        // Codigo del producto
                        IdProducto = Convert.ToString(item.productos.productosPK.codProd);

                        // Codigo de producto
                        if (txtCodProducto.Text == IdProducto)
                        {
                            Encontrado = true;
                            UnidadesSolicitadas = Convert.ToInt32(item.cantidadSolicitada);
                            Orden = Convert.ToInt32(item.detSolicitudPK.codDetSolicitud);
                            EstadoEncontrado = Convert.ToString(item.estado);
                            UnidadesPikeadas = Convert.ToInt32(item.cantidadRecibida);
                           
                        }
                    }
                   
                   // Si estado es diferente de recibido entonces ejecuta la actualizacion
                    if (Encontrado == true)
                   // if (Encontrado == true && EstadoEncontrado != "R")
                    {
                        
                        // Unidades existentes
                        Unidades = Convert.ToInt32(txtUnidadesRecibidas.Text);
                        //Total de unidades a pickear
                       totalUnidades = Unidades + UnidadesPikeadas;
                        // Obteniendo el porcentaje que va a restar
                        masMenos = Convert.ToDouble(clsLeerXML.MasMenos);
                        // Porcentaje de descuento mas o menos 
                        porcentaje =Convert.ToInt32( Math.Round(UnidadesSolicitadas*(masMenos/100)));
                        // Unidades nimimas que se puede recibir 
                        UnidadesMenos = UnidadesSolicitadas - porcentaje;
                        // Unidades maximas que se pueden obtener
                        unidadesMas = UnidadesSolicitadas + porcentaje;

                        //Toma la decision de la unidades en el nivel de tolerancia 
                        if (totalUnidades>=UnidadesMenos && totalUnidades <= unidadesMas)
                        {
                            // Actualizar recibido
                            ActualizarRecibido(Orden);
                            //Recarga el Grid con los Datos
                            CargarGrid();
                            //Limpia la cajas de texto
                            limpiarTXT();
                        }
                        else
                        {
                            MessageBox.Show("Cantidad de producto recibido, no puede ser mayor o menor a la solicitado o al margen de tolerancia:(+/-)" + clsLeerXML.MasMenos);
                            limpiarTXT();
                        }
                    }
                    //Caso contrario notifica al usuario que ese producto ya ha sido recibido y confirmado
                    else
                    {
                        MessageBox.Show("Producto ya fue recibido o no pertenece a lista de producto que se esta recibiendo");
                        limpiarTXT();
                    }
                }
                else
                {

                    MessageBox.Show("Código de producto, cantidad y numero de factura son obligatorios");
                    limpiarTXT();
                }
            
            
        }

        #endregion
        
        #region ACCIONES DE CLIC EN BOTON -----------------------------//

        private void btnAgregarProducto_Click(object sender, EventArgs e)
        {
            ProductoRecibido();

        }

      
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            Cancelar();
        }

        #endregion 

        #region COLOR FILA-------------------------------------//

            private void colorFila()
        {

            //try
            //{
            //    clsColorFilaCincoGrid col = new  clsColorFilaCincoGrid(dgUbicaciones);
            //    col.ColorEspecial = Color.YellowGreen;
            //    col.ColorOriginal = Color.WhiteSmoke;
            //    col.ColorTextoEspecial = Color.Black;
            //    col.ColorTextoOriginal = Color.Black;
            //    col.TextoAEvaluar = "R";
            //}
            //catch (Exception)
            //{
            //    //Mensaje de error colores del GRID no funcionan
            //}


        }

        #endregion

        #region CUANDO CARGA EL CLIC ----------------------------------//

        private void wf_Recepcion_Load(object sender, EventArgs e)
        {
         colorFila();
        }

        #endregion

        #region OPCIONES DE TECLA -------------------------------------------------------------------------//

        #endregion

        #region LIMPIAR CAJAS DE TEXTO ----------------------------//
        private void limpiarTXT()
        {
            txtCodProducto.Text = "";
            txtUnidadesRecibidas.Text = "";
            txtCodProducto.Focus();
        }
        #endregion

        #region CUANDO PRESIONA UN TECLA ---------------------------------//
         
        //Cuando presion tecla
        private void txtUnidadesRecibidas_KeyPress(object sender, KeyPressEventArgs e)
         {

                 //solo permite numeración
                 clsFuncionesGenerales.SoloNumero(e);

         }
        
        #endregion

       
        private void ValidarEnter()
        {
            if (txtFactura.Text != string.Empty && txtCodProducto.Text != string.Empty && txtUnidadesRecibidas.Text != string.Empty)
            {
                ProductoRecibido();
                txtFactura.Enabled = false;
            }
            else
            {
                MessageBox.Show("No se permiten campos vacios");
      
            }
        }



        private void txtFactura_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Down || e.KeyCode == Keys.Enter)
            {
                txtCodProducto.Focus();
            }
        }

        private void txtCodProducto_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Down || e.KeyCode == Keys.Enter)
            {
                txtUnidadesRecibidas.Focus();
            }
            if (e.KeyCode == Keys.Up)
            {
                txtFactura.Focus();
            }
        }

        private void txtUnidadesRecibidas_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                ValidarEnter();
            }
            if (e.KeyCode == Keys.Up)
            {
                txtCodProducto.Focus();
            }
        }

        private void dgUbicaciones_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Down || e.KeyCode == Keys.Up)
            {
                clicGRID();
            }
            if (e.KeyCode == Keys.Enter)
            {
                if (txtFactura.Enabled == false)
                {
                    txtUnidadesRecibidas.Focus();
                }
                else
                {
                    txtFactura.Focus();
                }
            }
        }

        private void clicGRID()
        {
            int Indice = dgUbicaciones.CurrentRowIndex;
            txtCodProducto.Text = dgUbicaciones[Indice, 1].ToString();
            //txtUnidadesRecibidas.Text = dgUbicaciones[Indice, 4].ToString();
        }

        private void dgUbicaciones_Click(object sender, EventArgs e)
        {
            if (dgUbicaciones.VisibleRowCount > 0)
            {
                clicGRID();
            }
        }

    }
}   