using AppTiendaElectrodomesticos.accesoDatos;
using AppTiendaElectrodomesticos.logica;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AppTiendaElectrodomesticos
{
    public partial class FrmInicio : Form
    {
        public FrmInicio()
        {
            InitializeComponent();
        }


        //Crear clases
        Tienda objTienda = new Tienda();
        Electrodomestico objElectro = new Electrodomestico();
        Datos objDt = new Datos();


        //Boton Registrar Tienda
        private void btRegistrarTienda_Click(object sender, EventArgs e)
        {
            //variables
            int nit,r;
            string nombre, fechaCreacion;

            //capturar datos
            nit = int.Parse(txtNit.Text);
            nombre = txtNombreTienda.Text;
            fechaCreacion = txtFechaCreacion.Text;

            //Enviar variables a la logica

            r = objTienda.ingresarTienda(nit, nombre, fechaCreacion);

            //Comprobar que pudo hacer la conexion correcta y enviar mensaje
            if (r > 0)
            {

                borrarTxtTienda();
                MessageBox.Show("Tienda registrada", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);

            }
            else 
            {

                MessageBox.Show("Tienda no registrada", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Error);

            }

        }

        //Boton Registrar Electrodomestico
        private void btRegistrarElectro_Click(object sender, EventArgs e)
        {

            //variables
            int serial, AnioFab, nitTienda, r;
            string tipo, marca, paisOrigen;

            //capturar datos
            serial = int.Parse(txtSerial.Text);
            tipo = cbxTipo.SelectedItem.ToString();
            marca = txtMarca.Text;
            paisOrigen = txtPaisOrigen.Text;
            AnioFab = int.Parse(txtAnioFabricacion.Text);
            nitTienda = int.Parse(txtNitTienda.Text);


            //Enviar variables a la logica

            r = objElectro.ingresarElectrodomestico(serial, tipo, marca, paisOrigen, AnioFab, nitTienda);

            //Comprobar que pudo hacer la conexion correcta y enviar mensaje
            if (r > 0)
            {

                borrarTxtElectro();
                MessageBox.Show("Electrodoméstico registrado", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);

            }
            else
            {

                MessageBox.Show("Electrodoméstico no registrado", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Error);

            }

        }

        //Consultar electrodomesticos con NIT
        private void btBuscar_Click(object sender, EventArgs e)
        {
            //Crear DS vacio
            DataSet dsResultado = new DataSet();

            //LLenar el DS con el metodo de consulta SELECT
            dsResultado = objElectro.consultarElectrodomesticosNit(int.Parse(txtNitBuscar.Text));

            //Guardar el DS en la grilla
            dgvDatos.DataSource = dsResultado;

            //Asignar las tablas en la grilla con la referencia
            dgvDatos.DataMember = "ResultadoDatos";

        }


        //Boton Eliminar

        //Eliminar Tienda
        private void btETienda_Click(object sender, EventArgs e)
        {

            //variables
            int nit, r;

            //capturar datos
            nit = int.Parse(txtETienda.Text);

            //Enviar variables a la logica

            r = objTienda.eliminarTienda(nit);

            //Comprobar que pudo hacer la conexion correcta y enviar mensaje
            if (r > 0)
            {

                txtETienda.Text = "";
                MessageBox.Show("Tienda eliminada", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);
                MessageBox.Show("Electrodomésticos de la tienda eliminados", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);

            }
            else
            {

                MessageBox.Show("Tienda no eliminada", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Error);

            }

        }

        //Eliminar Electrodomestico
        private void btEElectro_Click(object sender, EventArgs e)
        {

            //variables
            int serial, r;

            //capturar datos
            serial = int.Parse(txtEElectro.Text);

            //Enviar variables a la logica
            r = objElectro.eliminarElectrodomestico(serial);

            //Comprobar que pudo hacer la conexion correcta y enviar mensaje
            if (r > 0)
            {

                txtEElectro.Text = "";
                MessageBox.Show("Electrodoméstico eliminado", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);

            }
            else
            {

                MessageBox.Show("Electrodoméstico no eliminado", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Error);

            }

        }


        //Boton consultas
        private void btConsulta_Click(object sender, EventArgs e)
        {
            //Crear DS vacio
            DataSet dsResultado = new DataSet();

            //LLenar el DS con el metodo de consulta SELECT
            dsResultado = realizarConsulta();

            //Guardar el DS en la grilla
            dgvConsulta.DataSource = dsResultado;

            //Asignar las tablas en la grilla con la referencia
            dgvConsulta.DataMember = "ResultadoDatos";

            txtConsulta.Text = "";


        }

        public DataSet realizarConsulta() 
        {
            //Crear Data Set vacio
            DataSet miDS = new DataSet();

            //Crear la consulta
            String consulta;
            consulta = txtConsulta.Text;

            //Enviar la consulta
            miDS = objDt.ejecutarSELECT(consulta);

            //Retornar el DS
            return miDS;

        }



        //Borrar campos
        public void borrarTxtTienda() 
        {

            txtNit.Text = "";
            txtNombreTienda.Text = "";
            txtFechaCreacion.Text = "";

        }

        public void borrarTxtElectro()
        {

            txtSerial.Text = "";
            cbxTipo.Text = "";
            txtMarca.Text = "";
            txtPaisOrigen.Text = "";
            txtAnioFabricacion.Text = "";
            txtNitTienda.Text = "";

        }


        //Botones Salir
        private void btSalir2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btSalir1_Click_1(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btSalir3_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btSalir4_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btSalir5_Click(object sender, EventArgs e)
        {
            this.Close();
        }

    }
}
