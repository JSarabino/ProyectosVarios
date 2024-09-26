package mundo;

public class Trabajador extends Persona {
	
	
	
	/*ATRIBUTOS*/
	
	private TipoCargo cargo;
	
	private String fechaNacimiento;
	
	
	/*Referencias*/
	
	private Constructora refConstructora;
	
	/*CONSTRUCTORES*/
	/*CONSTRUCTOR VACIO*/
	
	public Trabajador(){
		
	}

	/*CONSTRUCTOR CON PARAMETROS*/
	
	public Trabajador(String pNombre, int pIdentificacion, int pEdad, TipoCargo pCargo, String pFechaNacimiento, Constructora pRefConstructora){
		super(pNombre, pIdentificacion, pEdad);
		
		cargo = pCargo;
		fechaNacimiento = pFechaNacimiento;
		refConstructora = pRefConstructora;
	}


	/*GETTERS AND SETTERS*/
	
	public TipoCargo darCargo() {
		return cargo;
	}

	public void cambiarCargo(TipoCargo pCargo) {
		cargo = pCargo;
	}

	public String darFechaNacimiento() {
		return fechaNacimiento;
	}

	public void cambiarFechaNacimiento(String pFechaNacimiento) {
		fechaNacimiento = pFechaNacimiento;
	}

	public Constructora darRefConstructora() {
		return refConstructora;
	}

	public void setRefConstructora(Constructora pRefConstructora) {
		refConstructora = pRefConstructora;
	}


	/*MÉTODOS U OPERACIONES*/
	
	/*Método polimórfico*/
	
	@Override
	public String saludo() {

		return "Hola, que tal...vengo por el anuncio de empleo";
	}
	

}
