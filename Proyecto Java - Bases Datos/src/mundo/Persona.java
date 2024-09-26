/**
 * 
 */
package mundo;

/**
 * @author Juan Camilo Sarabino Alegria
 *
 */
public abstract class Persona {
	
	/*ATRIBUTOS*/
	
	private String nombre;
	
	private int identificacion;
	
	private int edad;
	

	/*CONSTRUCTORES*/
	/*CONSTRUCTOR VACIO*/
	
	public Persona(){
		
	}

	/*CONSTRUCTOR CON PARAMETROS*/
	
	public Persona(String pNombre, int pIdentificacion, int pEdad){
		
		nombre = pNombre;
		identificacion = pIdentificacion;
		edad = pEdad;
	}


	/*GETTERS AND SETTERS*/
	
	public String darNombre() {
		return nombre;
	}

	public void cambiarNombre(String pNombre) {
		nombre = pNombre;
	}

	public int darIdentificacion() {
		return identificacion;
	}

	public void cambiarIdentificacion(int pIdentificacion) {
		identificacion = pIdentificacion;
	}

	public int darEdad() {
		return edad;
	}

	public void cambiarEdad(int pEdad) {
		edad = pEdad;
	}

	/*MÉTODOS U OPERACIONES*/
	
	
	/*Ejemplo de polimorfismo
	 * 
	 * En este método polmorfico vamos a observar como al ser de tipo abstract 
	 * las clases que hereden de esta clase Persona seran obligadas a implementar 
	 * este metodo, además de que nos permitirá implementar en cada una de las clases hijas
	 * este método de manera diferente pues esta es su gran utilidad.*/

	
	public abstract String saludo();

}
