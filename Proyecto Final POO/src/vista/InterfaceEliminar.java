package vista;

public interface InterfaceEliminar {

	/*Continuación de la interface simple
	 * 
	 * A pesar de que esta interface solo utiliza un metodo sirve para demostrar
	 * la herencia multiple que se puede lograr con una interface, ya que en los JDialogs
	 * Cliente y trabajador se utilizan dos metodos para eliminar un trabajador o un cliente, sin embargo,
	 * el JDialog constructora no lo utiliza, asi utilizando la palabra reservada "implements" seguida de 
	 * la interface primera y la segunda separadas por coma podremos heredar los metodos de amas interface.
	 */
	void eliminar();
	
}
