package mundo;

public class Cliente extends Persona {

	/*ATRIBUTOS*/
	
	private String telefono;
	
	private String nacionalidad;
	
	
	/*REFERENCIAS*/
	
	private Constructora refConstructora;

	/*CONSTRUCTORES*/
	/*CONSTRUCTOR VACIO*/

	public Cliente(){
		
		
	}
	/*CONSTRUCTOR CON PARAMETROS*/
	
	public Cliente(String pNombre, int pIdentificacion, int pEdad, String pTelefono, String pNacionalidad, Constructora pRefConstructora){
		
		super(pNombre, pIdentificacion, pEdad);
		
		telefono = pTelefono;
		nacionalidad = pNacionalidad;
		refConstructora = pRefConstructora;
		
	}


	/*GETTERS AND SETTERS*/
	
	public String darTelefono() {
		return telefono;
	}

	public void cambiarTelefono(String pTelefono) {
		this.telefono = pTelefono;
	}

	public String darNacionalidad() {
		return nacionalidad;
	}

	public void cambiarNacionalidad(String pNacionalidad) {
		this.nacionalidad = pNacionalidad;
	}

	public Constructora darRefConstructora() {
		return refConstructora;
	}

	public void cambiarRefConstructora(Constructora pRefConstructora) {
		this.refConstructora = pRefConstructora;
	}

	/*MÉTODOS U OPERACIONES*/
	
	/*Método polimórfico*/
	
	@Override
	public String saludo() {
		
		
		
		return "Hola, que tal...me gustaria contratarlos";
	}
	
}
