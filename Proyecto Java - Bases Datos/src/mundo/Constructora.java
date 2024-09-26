package mundo;

import java.util.ArrayList;

public class Constructora {
	
	/*ATRIBUTOS*/
	
	private String nombre;
	
	private int identificador;
	
	private ArrayList<Trabajador> Trabajadores;
	
	private ArrayList<Cliente> Clientes;
	
	

	/*CONSTRUCTORES*/
	/*CONSTRUCTOR VACIO*/
	
	public Constructora(){
		
		Trabajadores = new ArrayList<Trabajador>();
		Clientes = new ArrayList<Cliente>();
	}

	/*CONSTRUCTOR CON PARAMETROS*/
	
	public Constructora(String pNombre, int pIdentificador){
		
		nombre = pNombre;
		identificador = pIdentificador;
		Trabajadores = new ArrayList<Trabajador>();
		Clientes = new ArrayList<Cliente>();
	}


	/*GETTERS AND SETTERS*/
	
	public String darNombre() {
		return nombre;
	}

	public void cambiarNombre(String pNombre) {
		nombre = pNombre;
	}

	public int darIdentificador() {
		return identificador;
	}

	public void cambiarIdentificador(int pIdentificador) {
		identificador = pIdentificador;
	}

	public ArrayList<Trabajador> darTrabajadores() {
		return Trabajadores;
	}

	public void cambiarTrabajadores(ArrayList<Trabajador> pTrabajadores) {
		Trabajadores = pTrabajadores;
	}
	
	public ArrayList<Cliente> darClientes() {
		return Clientes;
	}

	public void cambiarClientes(ArrayList<Cliente> clientes) {
		Clientes = clientes;
	}

	/*MÉTODOS U OPERACIONES*/
	
	
	/*Metodo de composicion donde la constructora crea el trabajador por lo tanto
	 * si la constructora desaparece los trabajadores tambien.
	 * Recibe los datos por medio de parametros para crear el objeto Trabajador y por ultmo
	 * lo arregla a la lista de trabajadores de la constructora*/
	
	public void crear_trabajador(String pNombre, int pIdentificacion, int pEdad, TipoCargo pCargo, String pFechaNacimiento, Constructora pRefConstructora){
		
		Trabajador objTrabajador = new Trabajador(pNombre, pIdentificacion, pEdad, pCargo, pFechaNacimiento, pRefConstructora);
		
		this.Trabajadores.add(objTrabajador);
		
	}
	
	/*Metodo de agregación donde la constructora agrega un objeto cliente 
	 * ya creado en el jPanelCrearCliente. */
	
	public void agregar_cliente(Cliente objCliente){
		
		this.Clientes.add(objCliente);
	}

}
