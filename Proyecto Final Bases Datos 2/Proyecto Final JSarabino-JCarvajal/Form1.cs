using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Proyecto_Final_JSarabino_JCarvajal.logica;



//Juan Camilo Sarabino Alegria
//Julian Camilo Carvajal

namespace Proyecto_Final_JSarabino_JCarvajal
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //Creo objeto tabla
        DiccionarioDatos objDiccDatos = new DiccionarioDatos();

        string nomTablaCreada = "TBL_PRUEBA";

        private void btnCrearTabla_Click(object sender, EventArgs e)
        {

            //Manejo de respuesta
            bool respuesta = false;

            //Obtener los datos de las cajas de texto
            string nombreTabla = txtNombreTabla.Text;
            string nomColumna1 = txtColumna1.Text;
            string nomColumna2 = txtColumna2.Text;
            string nomColumna3 = txtColumna3.Text;

            //Obtener los datos de los combo box
            string tipoColumna1 = cmbTipoDato1.Text;
            string tipoColumna2 = cmbTipoDato2.Text;
            string tipoColumna3 = cmbTipoDato3.Text;

            //Obtener el nombre de la tabla para los demas metodos
            nomTablaCreada = txtNombreTabla.Text;

            //Enviar datos para el manejo de la lógica
            respuesta = objDiccDatos.EnviarDatosTabla(nombreTabla, 
                                             nomColumna1, nomColumna2, nomColumna3,
                                             tipoColumna1, tipoColumna2, tipoColumna3,
                                             rbNoNulo1, rbSiNulo1, rbNoNulo2, rbSiNulo2, rbNoNulo3, rbSiNulo3);

            if (respuesta == true) MessageBox.Show("Correcto");
            if (respuesta == false) MessageBox.Show("Incorrecto");
            

        }

        private void btnConcularTabla_Click(object sender, EventArgs e)
        {
            //Crear un DataSet vacio
            DataSet dt = new DataSet();

            //Enviar al metodo (se llena el DataSet)
            dt = objDiccDatos.ConsultarMetaDatosTabla();

            //Cargar datos en el datagridview
            dgvDatosTabla.DataSource = dt;
            dgvDatosTabla.DataMember = "MetadatosTabla";

            ArrayList TipoDatos = new ArrayList();
            ArrayList cantTipoDatos = new ArrayList();

            string valor1, valor2;

            foreach (DataRow drow in dt.Tables[1].Rows) 
            {
                valor1 = drow["TipoDato"].ToString();
                TipoDatos.Add(valor1);
                valor2 = drow["Cantidad"].ToString();
                cantTipoDatos.Add(valor2);
            }
            chtVisorTipoDatos.Series[0].Points.DataBindXY(TipoDatos, cantTipoDatos);

        }

        private void btnParticiones_Click(object sender, EventArgs e)
        {
            //Crear un DataSet vacio
            DataSet dt = new DataSet();

            //Enviar al metodo (se llena el DataSet)
            dt = objDiccDatos.ConsultarParticiones();


            ArrayList tipoParticion = new ArrayList();
            ArrayList cantTipoParticion = new ArrayList();

            string valor1, valor2;

            foreach (DataRow drow in dt.Tables[0].Rows)
            {
                valor1 = drow["Particionada"].ToString();
                tipoParticion.Add(valor1);
                valor2 = drow["Cantidad"].ToString();
                cantTipoParticion.Add(valor2);
            }
            chtTablaParticiones.Series[0].Points.DataBindXY(tipoParticion, cantTipoParticion);
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
