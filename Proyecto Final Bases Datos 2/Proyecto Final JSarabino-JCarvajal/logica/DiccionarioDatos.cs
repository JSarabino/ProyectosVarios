using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Threading.Tasks;
using System.Windows.Forms;
using Proyecto_Final_JSarabino_JCarvajal.datos;

namespace Proyecto_Final_JSarabino_JCarvajal.logica
{
    class DiccionarioDatos
    {
        Datos objDatos = new Datos();

        public bool EnviarDatosTabla(string nombreTabla,
                                     string nomColumna1, string nomColumna2, string nomColumna3,
                                     string tipoColumna1, string tipoColumna2, string tipoColumna3,
                                     RadioButton rbNoNulo1, RadioButton rbSiNulo1,
                                     RadioButton rbNoNulo2, RadioButton rbSiNulo2,
                                     RadioButton rbNoNulo3, RadioButton rbSiNulo3)
        {

            bool correcto;

            //Checamos si es nulo o no para enviar los datos
            string esNulo1 = EsNulo(rbNoNulo1, rbSiNulo1);
            string esNulo2 = EsNulo(rbNoNulo2, rbSiNulo2);
            string esNulo3 = EsNulo(rbNoNulo3, rbSiNulo3);

            correcto = objDatos.CrearTabla(nombreTabla,
                                     nomColumna1, nomColumna2, nomColumna3,
                                     tipoColumna1, tipoColumna2, tipoColumna3,
                                     esNulo1, esNulo2, esNulo3);
            

            return correcto;
        }

        private string EsNulo(RadioButton rbNoNulo, RadioButton rbSiNulo) 
        {
            string respuestaNulo = "";

            if (rbNoNulo.Checked == true)
                respuestaNulo = "NOT NULL";

            if (rbSiNulo.Checked == true)
                respuestaNulo = "NULL";

            return respuestaNulo;
        }


        public DataSet ConsultarMetaDatosTabla() 
        {
            DataSet conjuntoDatos = new DataSet();
            conjuntoDatos = objDatos.ObtenerDatosTabla();
            return conjuntoDatos;
        }

        public DataSet ConsultarParticiones() 
        {
            DataSet conjuntoDatosPar = new DataSet();
            conjuntoDatosPar = objDatos.ObtenerDatosParticion();
            return conjuntoDatosPar;
        }

    }
}
