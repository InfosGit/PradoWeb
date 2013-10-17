using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Xml;
using System.Windows.Forms;
using System.Data;
using System.IO;
using System.Reflection;
using System.Collections.Specialized;


namespace viducWMS
{
    class clsLeerXML
    {
       
        #region LLAMANDO ELEMTOS DEL XML

        private static NameValueCollection m_settings;
            private static string m_settingsPath;

            static clsLeerXML()
            {
                m_settingsPath = Path.GetDirectoryName(System.Reflection.Assembly.GetExecutingAssembly().GetName().CodeBase);
                m_settingsPath += @"\urlServiciosWeb.xml";

                if (!File.Exists(m_settingsPath))
                    throw new FileNotFoundException(m_settingsPath + " Elemento no ha sido encontrado.");

                //Instanciando nuevo servicio de XML
                System.Xml.XmlDocument xdoc = new XmlDocument();
                // Cargando y leyendo XML
                xdoc.Load(m_settingsPath);
                //Obteniendo nodo Principal de XML
                XmlElement root = xdoc.DocumentElement;
                System.Xml.XmlNodeList nodeList = root.ChildNodes.Item(0).ChildNodes;

                // Add settings to the NameValueCollection.
                m_settings = new NameValueCollection();
                //Agregando la URL ala variables  "TrasladoBodega"
                m_settings.Add("TrasladoBodega", nodeList.Item(0).Attributes["value"].Value);
                //Agregando la URL VIDUCServicio a la Bodega
                m_settings.Add("VIDUCServicio", nodeList.Item(1).Attributes["value"].Value);
                //Obteniendo la capara de servicio de Conteo Fisico
                m_settings.Add("wsConteo", nodeList.Item(2).Attributes["value"].Value);
                //Porcentajemasmenos
                m_settings.Add("MasMenos", nodeList.Item(3).Attributes["value"].Value);

            }
       
        #endregion

        #region ENTIDADES 

            public static void Update()
            {
                XmlTextWriter tw = new XmlTextWriter(m_settingsPath, System.Text.UTF8Encoding.UTF8);
                tw.WriteStartDocument();
                tw.WriteStartElement("configuration");
                tw.WriteStartElement("appSettings");

                for (int i = 0; i < m_settings.Count; ++i)
                {
                    tw.WriteStartElement("add");
                    tw.WriteStartAttribute("key", string.Empty);
                    tw.WriteRaw(m_settings.GetKey(i));
                    tw.WriteEndAttribute();

                    tw.WriteStartAttribute("value", string.Empty);
                    tw.WriteRaw(m_settings.Get(i));
                    tw.WriteEndAttribute();
                    tw.WriteEndElement();
                }

                tw.WriteEndElement();
                tw.WriteEndElement();

                tw.Close();
            }

            public static string TrasladoBodega
            {
                get { return m_settings.Get("TrasladoBodega"); }
                set { m_settings.Set("TrasladoBodega", value); }
            }

            public static string VIDUCServicio
            {
                get { return m_settings.Get("VIDUCServicio"); }
                set { m_settings.Set("VIDUCServicio", value); }
            }

            public static string wsConteo
            {
                get { return m_settings.Get("wsConteo"); }
                set { m_settings.Set("wsConteo", value); }
            }

            public static string MasMenos
            {
                get { return m_settings.Get("MasMenos"); }
                set { m_settings.Set("MasMenos", value); }
            }
        #endregion

    }
   
}
