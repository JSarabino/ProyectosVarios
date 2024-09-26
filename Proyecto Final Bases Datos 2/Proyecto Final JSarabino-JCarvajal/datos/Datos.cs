using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Oracle.DataAccess.Client;
using System.Data;

namespace Proyecto_Final_JSarabino_JCarvajal.datos
{
    class Datos
    {

        //Establezco la cadena de conexion a oracle
        OracleConnection ora_conn = new OracleConnection(@"Data Source=LOCALHOST;User ID=prueba;Password=oracle");

        //Metodo para crear la tabla
        public bool CrearTabla(string nombreTabla,
                                     string nomColumna1, string nomColumna2, string nomColumna3,
                                     string tipoColumna1, string tipoColumna2, string tipoColumna3,
                                     string esNulo1, string esNulo2, string esNulo3) 
        {
            try 
            {


                //Abrimos la conexion
                ora_conn.Open();
                //Creamos un comando que recibe el nombre del procedimiento almacenado y la conexion donde esta dicho procedimiento
                OracleCommand ora_cmd = new OracleCommand("prueba.pag_tabla.prc_crear_tabla", ora_conn);
                ora_cmd.CommandType = CommandType.StoredProcedure;

                //Indicar parametros y de que tipo son
                ora_cmd.Parameters.Add("p_nombre_tabla", OracleDbType.Varchar2, nombreTabla, ParameterDirection.Input);
                ora_cmd.Parameters.Add("p_nombre_columna1", OracleDbType.Varchar2, nomColumna1, ParameterDirection.Input);
                ora_cmd.Parameters.Add("p_nombre_columna2", OracleDbType.Varchar2, nomColumna2, ParameterDirection.Input);
                ora_cmd.Parameters.Add("p_nombre_columna3", OracleDbType.Varchar2, nomColumna3, ParameterDirection.Input);
                ora_cmd.Parameters.Add("p_tipo_columna1", OracleDbType.Varchar2, tipoColumna1, ParameterDirection.Input);
                ora_cmd.Parameters.Add("p_tipo_columna2", OracleDbType.Varchar2, tipoColumna2, ParameterDirection.Input);
                ora_cmd.Parameters.Add("p_tipo_columna3", OracleDbType.Varchar2, tipoColumna3, ParameterDirection.Input);
                ora_cmd.Parameters.Add("p_nulo_columna1", OracleDbType.Varchar2, esNulo1, ParameterDirection.Input);
                ora_cmd.Parameters.Add("p_nulo_columna2", OracleDbType.Varchar2, esNulo2, ParameterDirection.Input);
                ora_cmd.Parameters.Add("p_nulo_columna3", OracleDbType.Varchar2, esNulo3, ParameterDirection.Input);


                //Ejecuto el procedimiento almacenado
                ora_cmd.ExecuteNonQuery();
                ora_conn.Close();
                return true;

            } catch (Exception e) 
            {
                ora_conn.Close();
                return false;
            }
            
        }


        public DataSet ObtenerDatosTabla()
        {
            try 
            {
                ora_conn.Open();

                OracleCommand ora_cmd = new OracleCommand("prueba.pag_tabla.prc_consultar_tabla", ora_conn);

                ora_cmd.Parameters.Add("p_cursor_tabla", OracleDbType.RefCursor, ParameterDirection.Output);
                ora_cmd.Parameters.Add("p_cursor_columnas", OracleDbType.RefCursor, ParameterDirection.Output);
                ora_cmd.CommandType = CommandType.StoredProcedure;

                OracleDataAdapter da = new OracleDataAdapter(ora_cmd);

                DataSet ds = new DataSet();

                da.Fill(ds, "MetadatosTabla");

                da.Fill(ds, "DatosColumnas");

                ora_conn.Close();
                return ds;

            } finally 
            {
                if (ora_conn.State == ConnectionState.Open) 
                {
                    ora_conn.Close();
                }
            }

        }

        public DataSet ObtenerDatosParticion() 
        {
            ora_conn.Open();

            OracleCommand ora_cmd = new OracleCommand("prueba.pag_tabla.prc_consultar_particiones", ora_conn);

            ora_cmd.Parameters.Add("p_cursor_particiones", OracleDbType.RefCursor, ParameterDirection.Output);
            ora_cmd.CommandType = CommandType.StoredProcedure;

            OracleDataAdapter da = new OracleDataAdapter(ora_cmd);

            DataSet ds = new DataSet();

            da.Fill(ds, "InfoParticiones");

            ora_conn.Close();
            return ds;
        }


    }
}
