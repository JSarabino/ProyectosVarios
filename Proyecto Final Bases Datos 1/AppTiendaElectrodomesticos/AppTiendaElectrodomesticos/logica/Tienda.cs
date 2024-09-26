using AppTiendaElectrodomesticos.accesoDatos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AppTiendaElectrodomesticos.logica
{
    class Tienda
    {
        //Crear objeto datos
        Datos objDt = new Datos(); 

        public int ingresarTienda(int nit, string nombre, string fechaCreacion) 
        {
            //variables
            int resultado;
            string consulta;

            //armar consulta
            consulta = "insert into tblTienda(tienNit, tienNombre, tienFechaCreacion) values(" +
                nit + ",'" + nombre + "','" + fechaCreacion + "')";

            //Enviar a la capa de datos
            resultado = objDt.ejecutarDML(consulta);
            return resultado;

        }


        //Eliminar Tienda
        public int eliminarTienda(int nit) 
        {

            //variables
            int resultadoTienda, resultadoElectro;
            string consultaTienda, consultaElectro;


            //armar consultas
            consultaElectro = "delete from tblElectrodomestico where tienNit = " + nit;
            consultaTienda = "delete from tblTienda where tienNit = " + nit;

            //Enviar a la capa de datos
            resultadoElectro = objDt.ejecutarDML(consultaElectro);

            //Resultados
            if (resultadoElectro > 0)
            {
                resultadoTienda = objDt.ejecutarDML(consultaTienda);
                return resultadoTienda;
            }
            else 
            {
                return resultadoElectro;
            }

        }

    }
}
