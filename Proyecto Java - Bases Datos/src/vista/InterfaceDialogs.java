package vista;

public interface InterfaceDialogs {
	
	
	/*Un pequeño ejemplo de interface*/
	
	/*La interface nos permite en pocas palabras "Heredar" de diferentes "padres", es decir
	 * en la herencia la clase padre tiene unos atributos y métodos que las clases hijas 
	 * pueden implementar en sus clases, sin embargo, estas clases hijas  no podran heredar
	 * de diferentes padres. Esta es la principal diferencia entre la herencia y una interface,
	 * además, una interface no solo permite que una clase pueda heredar de diferentes padres
	 * sino que tambien los obliga a implementar sus metodos.
	 * 
	 * 
	 * Otra caracteristica de una interface, radica en que una interface no anula
	 * la posibilidad de heredar. Un ejemplo de esto se encuentra en las clases JDialogs
	 * y jPanels donde de por si estan heredando de la clase padre JDialog y JPanel lo podemos
	 * saber porque las clases estan implementando la palabra reservada "extends" que se utiliza
	 * para la herencia en java.
	 * 
	 * Con lo dicho anteriormente las clases jDialog que heredan de JDialog tambien 
	 * implementaran esta interface utilizando la palabra reservada "implements", 
	 * lo cual las obliga a implementar los siguientes métodos: */
	void crear();
	void editar();
	void imprimir();

}
