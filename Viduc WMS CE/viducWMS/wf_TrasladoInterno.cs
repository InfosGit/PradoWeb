using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using viducWMS.wsTraslado;

namespace viducWMS
{
    public partial class wf_TrasladoInterno : Form
    {
  
        #region VARIABLES GLOBALES ---------------------------------------//
        //inicialización de Variables Globales
        private static int Compania;
        private static string Usuario;
        private static int Bodega;
        private static string Accion;
        private static bool Todos;
    

        #endregion

        #region LLAMANDO LA CAPA DE SERVICIOS--------------------------------------//

        wsTrasladoBodegaBodega Proxy = new wsTrasladoBodegaBodega();
        List<areaDespacho> AreasDespacho = new List<areaDespacho>();
        List<ubicacionProducto> Listadoproductos = new List<ubicacionProducto>();

        #endregion 
               
        #region PARAMETROS GENERALES ----------------------------//

        public wf_TrasladoInterno(int IdCompania, int IdBodega, string IdUsuario, string IdAccion)
         {
            InitializeComponent();
            //Compañia a la que pertenece el usuario
            Compania = IdCompania;
            //Obtiene el codigo de bodega
            Bodega = IdBodega;
            //Codigo del usuario que esta trabajando con la app
            Usuario = IdUsuario;
            Accion = IdAccion;
            //Enviando focus a la caja de texto
            txtUbicacionOrigen.Focus();
            //Cargando los datos
            CargarDatos();

            if (Accion == "PETP")
            { 
            lbTitulo.Text="Poner en transito producto";
            }
            else
                if (Accion=="REUP")
                {
                    lbTitulo.Text="Ubicación de producto";
                    chkTodos.Visible = false;
                }

          }
        #endregion
    
        #region GUARDA ESTADO  ----------------------------//

       
        private void GuardarTraslado()
        {
            //Declaracion de variables privadas para el metodo
            string Ubicacion, ConfirmaUbi, CodProducto, Area="";
            string UbicacionD, AreaD="";
            int LargoDestino=0;
            int Unidades, Anaquel=0, Nivel=0, AnaquelD=0, NivelD=0;
            
            // Obtiene los resultados de la ejecucion de los servicios
            bool Verificacion = false, ResultadoTransito = false, ResultadoUbicacion = false;

            if (txtCodProducto.Text != "" && txtUbicacionOrigen.Text != "" && txtConfUbicacion.Text != "" && txtUnidades.Text != "")
            {
                //Pregunta si la ubicacion destino es la misma

                if (txtUbicacionOrigen.Text != txtConfUbicacion.Text)
                {
                    //Obtiene la ubicacion donde escaneada del producto
                    Ubicacion = Convert.ToString(txtUbicacionOrigen.Text.Trim());
                    //Obteniendo ubicacion destino
                    UbicacionD= Convert.ToString(txtConfUbicacion.Text.Trim());
                    //Obtiene el Código del producto escaneado de la ubicacion
                    CodProducto = Convert.ToString(txtCodProducto.Text);
                    //Unidades que se van trasladar del producto
                    Unidades = Convert.ToInt32(txtUnidades.Text);
                    //Confirma la ubicacion de donde esta tomando el producto
                    ConfirmaUbi = Convert.ToString(txtConfUbicacion.Text);

                    //Determinando el alrgo de la cadena 
                     LargoDestino = txtConfUbicacion.Text.Length;

                    //Obteniendo el largo de la cadena
                    int LargoUbicacion = Ubicacion.Length;

                    try
                    {

                        //Pregunta si e codigo que esta tomando de la ubicacion
                        //Tiene un codigo de cuatro, lo que significia que el anaquel
                        // es mayor   que 10
                        if (LargoUbicacion == 4)
                        {
                            Anaquel = Convert.ToInt32(Ubicacion.Substring(0, 2));
                            Area = Convert.ToString(Ubicacion.Substring(2, 1));
                            Nivel = Convert.ToInt32(Ubicacion.Substring(3, 1));
                        }
                        else if (LargoUbicacion == 3)
                        {
                            Anaquel = Convert.ToInt32(Ubicacion.Substring(0, 1));
                            Area = Convert.ToString(Ubicacion.Substring(1, 1));
                            Nivel = Convert.ToInt32(Ubicacion.Substring(2, 1));
                        }     
                        
                        
                    
                        // Cuando se quiere poner en transito el producto                                             
                        
                        // Determinado el ancho de la cadena 
                        if (LargoDestino==4)
                         {
                            AnaquelD = Convert.ToInt32(UbicacionD.Substring(0, 2));
                            AreaD = Convert.ToString(UbicacionD.Substring(2, 4));
                            NivelD = Convert.ToInt32(UbicacionD.Substring(3, 1));
                         }
                        
                        // Determina si el ancho es del anaquel no excede o pasa de 9 
                        else  if(LargoDestino==3)
                         {
                            
                            // Obteniendo el Anaquel Origen
                            AnaquelD = Convert.ToInt32(UbicacionD.Substring(0, 1));
                            // Obteniendo Area
                            AreaD = Convert.ToString(UbicacionD.Substring(1, 1));
                            // Obteniendo Nivel
                            NivelD = Convert.ToInt32(UbicacionD.Substring(2, 1));
                         }

                   
                      //Obteniendo el resultado de la ejecucion
                       
                        Verificacion = Proxy.validarUbicacionOrigen(Compania, Bodega, Anaquel, Area, Nivel, CodProducto);

                        
                            //PETP = Poner En Transito Producto
                            if (Accion == "PETP")
                            {

                                //Verifica el resultado obtenido

                                if (Verificacion == true)
                                {
                                   // Ejecuta el resultado del Servicio 
                                    ResultadoTransito = Proxy.ponerEnTransito(Compania, true, Bodega, Anaquel, Area, Nivel, CodProducto, Unidades,  AnaquelD, AreaD, NivelD);

                                   // ResultadoTransito = Proxy.ponerEnTransito(Compania, true, Bodega, Anaquel, Area, Nivel, CodProducto, Unidades, chkSeleccion.Checked, true, 1, "TRAN1", 1);
                             
                                if (ResultadoTransito == true)
                                {
                                    // Muestra el mensaje  del producto
                                    MessageBox.Show("Producto ha sido puesto en nueva ubicación, éxitosamente");
                                    // Limpia los datos
                                    LimpiarTXT();
                                    //Recargando Datos
                                    CargarDatos();
                                    
                                }
                                else 
                                {
                                    // Muestra el mensaje del producto
                                    MessageBox.Show("Producto no ha podido ser puesto en nueva ubicacion, verificar datos");
                                    // Limpia las cajas de texto
                                    LimpiarTXT();
                                }
                                
                              }    //Cierra el IF que verifca que la ubicacion y codigo de producto exista
                              else
                              {
                                    //Notifica al usuario lo que esta sucediendo
                                    MessageBox.Show("Producto no existe en esta ubicación");
                                    //Limpia la caja de texto y vuelve el foco a ubicacion
                                    LimpiarTXT();
                              }
                            
                        }
                        

                        //Realiza la    Ubicacion del Producto
                            else  if (Accion == "REUP")
                            {   
                                //Resultado de la ubicacion de producto
                                if (Todos == false)
                                {
                                    ResultadoUbicacion = Proxy.trasladoInterno(Compania, Bodega, CodProducto, Anaquel, Area, Nivel, AnaquelD, AreaD, NivelD, Unidades);
                                }
                                else
                                {
                                    //Ubica desde carretilla todos
                                    ResultadoUbicacion = Proxy.ubicarDesdeCarretilla(Compania, Bodega, Usuario, AnaquelD, AreaD, Nivel);
                                }
                                if (ResultadoUbicacion == true)
                                {
                                    MessageBox.Show("Producto ha sido ubicado éxitosamente");
                                    //Limpiar cajas de texto
                                    LimpiarTXT();
                                    //Recargando Datos
                                    CargarDatos();
                                }
                                else
                                {
                                    MessageBox.Show("Producto no ha podido ser ubicado, verificar datos");
                                    //Limpia las cajas de texto y vuel el focos a la ubicacion.
                                    LimpiarTXT();
                                }
                                
                            }
                            
                    } //Cierra en try para capturar las exepciones en caso que se dieran

                    catch (Exception)
                    { 
                          //Envia en mensaje notificando que se ha generado un error
                    
                    }
                } //cierra el If que Verifica que las dos ubicacion sea iguales
                else
                {
                    MessageBox.Show("Las ubicaciones no coinciden, favor verificar");
                    LimpiarTXT();
                }
            }//Cierra el If que verifica que las cajas de texto no esten vacias
            else
            {
                MessageBox.Show("Todos lo campos son obligatorios");
                LimpiarTXT();
            }

        }

        #endregion

        #region LIMPIAR CAJAS DE TEXTO ---------------------//
        private void LimpiarTXT()
        {
            txtCodProducto.Text = "";
            txtConfUbicacion.Text = "";
            txtUbicacionOrigen.Text = "";
            txtUnidades.Text = "";
            txtUbicacionOrigen.Focus();
        }
        #endregion
     
        #region CANCELAR --------------------///

        private void Cancelar()
        {

            // Activa el Formulario de Menu
            MenuTrasladoInterno Menu = new MenuTrasladoInterno(Compania, Bodega, Usuario);
            Menu.Show();
            Menu.Activate();


            //oculta el Formulario Actual
            this.Visible = false;
        }

        #endregion

        #region DATOS DEL GRID -----------------------------//

       #region CREACION DE GRID --------------------------//

        private void CargarDatos()
        {
            try
            {
                //Poniendo de listado de productos en transito  -----------------------------------------Quitar Parametro quemado
                Listadoproductos=Proxy.listarProductosEnTransito(Compania, Bodega, Usuario).ToList<ubicacionProducto>();
                // Asigna el origen de datos
                dgListadProductos.DataSource = crearGrid();
            }
            catch (Exception)
            { 
                //Error que se ha generado
                
            }

        }
       
        #endregion
   
            #region CREACION DE GRID --------------------------//

        private DataTable crearGrid()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("Código");
            dt.Columns.Add("Descripción");
            dt.Columns.Add("U.Medida");
            dt.Columns.Add("Cantidad");



            DataRow row = dt.NewRow();
            foreach (var item in Listadoproductos)
            {
                row = dt.NewRow();
                row["Código"] = item.productos.productosPK.codProd.ToString();
                row["Descripción"] = item.productos.nombre.ToString();
                row["U.Medida"] = item.productos.unidadMedida;
                row["Cantidad"] = item.cantidad.ToString();
                dt.Rows.Add(row);
            }

            return dt;

        }

        #endregion

        #endregion

        #region OPCIONES DE CLIC ----------------------------//

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Cancelar();
        }
        #endregion
    
        #region Cuando presiona una tecla en caja de texto ----------------------//

        private void txtUbicacionOrigen_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) ||e.KeyCode==Keys.Enter)
            {
                if (txtUbicacionOrigen.Text != "")
                {
                    this.txtCodProducto.Focus();
                }
                else
                {
                    MessageBox.Show("Ecanee ubicación de producto");
                    txtUbicacionOrigen.Focus();
                }
            }
            if (e.KeyCode == Keys.Down)
            {
                txtCodProducto.Focus();
            }
        }

        private void txtCodProducto_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {
                if (txtCodProducto.Text != "")
                {
                    this.txtUnidades.Focus();
                }
                else
                {
                    MessageBox.Show("Ecanee código del producto");
                    txtCodProducto.Focus();
                }
            }
            if (e.KeyCode == Keys.Down)
            {
                txtUnidades.Focus();
            }
            if (e.KeyCode == Keys.Up)
            {
                txtUbicacionOrigen.Focus();
            }
        }

        private void txtConfUbicacion_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == (Keys.RButton | Keys.Back | Keys.Space) || e.KeyCode == Keys.Enter)
            {
                if (txtConfUbicacion.Text != "")
                {
                    GuardarTraslado();  
                }
                else
                {
                    MessageBox.Show("Confirme ubicación de producto");
                    txtConfUbicacion.Focus();

                }
            }
            if (e.KeyCode == Keys.Up)
            {
                txtUnidades.Focus();
            }
        }

        #endregion

        #region Chekeo de Ubicacion directa  -------------------------//
        
            private void chkSeleccion_Click(object sender, EventArgs e)
        {
            if (chkTodos.Checked == true)
            {
                Todos = true;
            }
            else
            {
                Todos = false;
            }

        }
        
        #endregion 

        #region DESABILITAR CAJAS DE TEXTO ----------------------//
            private void LIMPIAR_TXT()
            {
                txtCodProducto.Enabled = false;
               

                txtUnidades.Enabled = false;
                txtUbicacionOrigen.Enabled = false;
            }
        #endregion

            private void txtUnidades_KeyUp(object sender, KeyEventArgs e)
            {
                if (e.KeyCode == Keys.Down || e.KeyCode == Keys.Enter)
                {
                    txtConfUbicacion.Focus();
                }
                if (e.KeyCode == Keys.Up)
                {
                    txtCodProducto.Focus();
                }
            }
    }
}