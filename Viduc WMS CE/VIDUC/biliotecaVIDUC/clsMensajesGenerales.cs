
using System;
using System.Linq;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Text;
using System.Windows.Forms;
using VIDUC;



namespace VIDUC
{
    public class clsMensajesGenerales
    {
        #region VARIABLES GLOBALES ------------------------------//
        
        #endregion

        #region SELECCION DE FILA--------------------------------//
      
        //Ha seleccionado una fila valida del GRID
        public static string  FilaValida()
        {
            return  "Seleciona una Fila Valida";
        }

        //No ha seleccionado una fila valida del GRID
        public static string FilaNoValida()
        {
            return  "Seleciona una Fila Valida";
        }
       #endregion 

        #region SOLO NUMEROS-----------------------//

        //Registro guardado con exito
        public static string soloNumero()
        {
            return "Este campo solo permite valores númericos 0-9";
        }

      
        #endregion 

        #region GUARDAR UN REGISTRO -----------------------//
        
        //Registro guardado con exito
        public static string GuadarExito()
        {
            return "Datos guardados con Exito";
        }

        //Registro no guardado con exito
        public static string GuardarFallido()
        {
            return "Se ha producido un error de Guardado";
        }
        #endregion 

        #region ACTUALIZAR UN REGISTRO -----------------------//

        //Registro guardado con exito
        public static  string ActualizarExito()
        {
            return   "Datos actualizados con Exito";
        }

        //Registro no guardado con exito
        public static string ActualizarFallido()
        {
            return "Se ha producido un error de Actualización";
        }
        #endregion 

        #region ELIMINACION DE UN REGISTRO -----------------------//

        //Registro eliminado con exito
        public static string EliminarExito()
        {
            return "Datos actualizados con Exito";
        }

        //Registro no eliminado con exito
        public static string EliminarFallido(TextBox Mensaje)
        {
            return Mensaje.Text = "Se ha producido un error de Actualización";
        }
        #endregion 

        #region NO HAY REGISTRO QUE MOSTRAR -----------------------//

        //Registro eliminado con exito
        public static string noDatos()
        {
            return "No hay datos que mostrar";
        }
        #endregion

        #region PRODUCTO HA SIDO RECICIBIDO-----------------------//

        //Producto recibido eliga otro
        public static string ProductoRecibido()
        {
            return "Producto ha sido confirmado, como recibido";
        }


        //Esto producto ya estas recibido
        public static string ProductoYaRecibido()
        {
            return "Este producto ya esta recibido, por favor seleccione otro";
        }

        //Esto producto ya estas recibido
        public static string SolicitudCerrada()
        {
            return "Solicitud ha sido cerrada, exitosamente.";
        }

        #endregion 

        #region SELECCIONE UN PRODUCTO -----------------------//

        //Registro eliminado con exito
        public static  string Producto()
        {
            return "Seleccion un producto valido";
        }

        #endregion 
        
        #region USUARIO CON PWD IVALIDO -----------------------//

        //Registro eliminado con exito
        public static string LoginUsuario()
        {
            return "Usuario o contraseña Invalida, verificar datos";
        }

        //Error de comunicacion con los servicios
        public static string ErrorComunicacion()
        {
            return "Error de comunicación";
        }


        #endregion 

        #region PROFORMA VALIDA -----------------------//

        //Registro eliminado con exito
        public static string Proformavalida()
        {
            return "Seleccione una proforma valida";
        }

        #endregion

        #region MENSAJES DE DESPACHO DE PRODUCTO -------//
         
                #region  LISTO PARA DESPACHO
                //Producto listo para ser despachado

                public static string Despacho()
                 {
                    return "Producto listo para ser despachado";
                 }
            #endregion

                #region  LISTO PARA DESPACHO
                //Producto ya esta listo para ser despachado
                public static string DespachoListo()
                {
                    return "Este producto ya esta en despacho";
                }
                #endregion

                #region  LISTO PARA DESPACHO
                //Producto ya esta listo para ser despachado
                public static string NoDespacho()
                {
                    return "Ha ocurrido un error en el proceso";
                }
                #endregion

                #region  PRODUCTO NO EXISTE EN EL LISTADO
                //Producto no existe en listadi que se desea despachar
                public static string DespachoProducto()
                {
                    return "Producto no existe en listado a despachar";
                }
                #endregion

                #region  SELECCIONAR PODUCTO
                //Producto no existe en listadi que se desea despachar
                public static string DespachoProdSeleccionado()
                {
                    return "Debe seleccionar un producto";
                }
                #endregion

                #region  ORDEN PROFORMA
                //Producto no existe en listadi que se desea despachar
                public static string ordenProforma()
                {
                    return "Orden proforma esta depachada";
                }
                #endregion

                #region  UBICACION PRODUCTO
                //Producto no existe en listadi que se desea despachar
                public static string UbicacionProducto()
                {
                    return "Este producto no tiene ubicación";
                }
                #endregion


                #region  UBICACION PRODUCTO
                //Producto no existe en listadi que se desea despachar
                public static string ProductoNoExiste()
                {
                    return "Producto no existe en listado a recibir";
                }
                #endregion

                #region  SOLICICTUD DE TRASLADO LISTA
                //Producto no existe en listadi que se desea despachar
                public static string SolcitudTraslado()
                {
                    return "Solicitud de traslado lista para ser despachada";
                }
                #endregion

        #endregion

        #region  UBICACION -----------------------//

           //Ubicacion realizada con exito
           #region  UBICACION -----------------------//
           public static string UbicacionS()
            {
              return "Ubicación realizada con éxito";
            }
            #endregion
          
           //Ubicacion no se puedo realizar
           #region  UBICACION -----------------------//
           public static string UbicacionN()
           {
               return "Ubicación no se ha podido realizar";
           }
           #endregion
          //Ubicacion no existe para esta bodega
           #region  UBICACION -----------------------//
           public static string UbicacionBodega()
           {
               return "Ubicación no existe para esta bodega";
           }
           #endregion

           #region  LISTA PRODUCTO -----------------------//
           public static string ListaProducto()
           {
               return "Producto no pertenece a la lista a recibir";
           }
           #endregion

        #endregion

        #region  solo solicitudes que se puede procesar --------------------//
        
        public static string SolicitudesProcesar()
        {
           //Solo solicitudes que se pueden procesar 
            return   "Solo puede procesar solicitudes: 'CREADAS' o 'RECIBIDAS'";
        }
           #endregion

        #region  ProductoUbicado ------------------------------///

        public static string ProductoUbicado()
        {
            //Solo solicitudes que se pueden procesar 
            return "Este producto ya fue ubicado, seleccione otro";
        }
        #endregion

        #region  UBICACION DE PRODUCTO

        public static string ListadoCerrado()
        {
            //Solo solicitudes que se pueden procesar 
            return "Listado de productos ha sido ubicado con éxito";
        }
        #endregion

        #region  Unidades a despachar x producto

        public static string UnidadesProducto()
        {
            //Solo solicitudes que se pueden procesar 
            return "Debe colocar las unidades a despachar de este producto";
        }
        #endregion
                     
        #region  Notificaciones ------------------------------///

        public static string Notificacion()
        {
            //Solo solicitudes que se pueden procesar 
            return "Este producto ya fue ubicado, seleccione otro";
        }
        #endregion

    }
}
