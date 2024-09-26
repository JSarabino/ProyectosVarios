using AppTiendaElectrodomesticos.accesoDatos;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AppTiendaElectrodomesticos.logica
{
    class Electrodomestico
    {

        //Crear objeto datos
        Datos objDt = new Datos();

        public int ingresarElectrodomestico(int serial, string tipo, string marca, string paisOrigen, int anioFab, int nitTienda)
        {
            //variables
            int resultado;
            string consulta;

            //armar consulta
            consulta = "insert into tblElectrodomestico(electSerial, electTipo, electMarca, electPaisOrigen, electAnioFabricacion, tienNit) values(" 
                + serial + ",'" + tipo + "','" + marca + "','" + paisOrigen + "'," + anioFab + "," + nitTienda + ")";

            //Enviar a la capa de datos
            resultado = objDt.ejecutarDML(consulta);
            return resultado;

        }


        public DataSet consultarElectrodomesticosNit(int nit) 
        {
            //Crear Data Set vacio
            DataSet miDS = new DataSet();

            //Crear la consulta
            String consulta;
            consulta = "select electSerial \"Serial\", electTipo \"Tipo\", electMarca \"Marca\", electPaisOrigen \"País de origen\", electAnioFabricacion \"Año de fabricación\", tienNit \"Nit de la tienda\" from tblElectrodomestico where tienNit = " + nit;

            //Enviar la consulta
            miDS = objDt.ejecutarSELECT(consulta);

            //Retornar el DS
            return miDS;

        }

        //Eliminar Electrodomestico
        public int eliminarElectrodomestico(int serial)
        {
            //variables
            int resultado;
            string consulta;

            //armar consulta
            consulta = "delete from tblElectrodomestico where electSerial = " + serial;

            //Enviar a la capa de datos
            resultado = objDt.ejecutarDML(consulta);
            return resultado;

        }

    }
}
