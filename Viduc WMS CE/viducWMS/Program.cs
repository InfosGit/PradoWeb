using System;
using System.Linq;
using System.Collections.Generic;
using System.Windows.Forms;

namespace viducWMS
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [MTAThread]
        static void Main()
        {
            // Aplicacion que reinicia
            Application.Run(new wf_Login());

          //  Application.Run(new prueba());
        }
    }
}