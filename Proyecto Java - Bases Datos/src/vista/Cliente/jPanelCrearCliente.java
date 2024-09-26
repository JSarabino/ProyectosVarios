package vista.Cliente;

import javax.swing.JPanel;

import mundo.Constructora;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import mundo.Cliente;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class jPanelCrearCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private Constructora auxObjConstructora;
	private JTextField textNombre;
	private JTextField textIdentificacion;
	private JTextField textNacionalidad;
	private JTextField textTelefono;
	private JTextField textEdad;
	
	/*Cliente que va a saludar*/
	
	Cliente objSaludar = new Cliente();
	
	public jPanelCrearCliente(Constructora objConstructora) {
		setBorder(new LineBorder(Color.ORANGE, 3, true));
		
		this.auxObjConstructora = objConstructora;
		
		lanzar_componentes();
	}
	
	public void lanzar_componentes(){
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblAgregarCliente = new JLabel("Agregar Cliente");
		lblAgregarCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblAgregarCliente);
		
		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblIdentificacin = new JLabel("Identificaci\u00F3n");
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		JLabel lblEdad = new JLabel("Edad");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		textIdentificacion = new JTextField();
		textIdentificacion.setColumns(10);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		
		textEdad = new JTextField();
		textEdad.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crear();
			}
		});
		
		JLabel lblEjemploDePolimrfismo = new JLabel("Ejemplo de polim\u00F3rfismo en un saludo: ");
		
		JLabel labelSaludo = new JLabel("----");
		/*Cambiamos lo que dice la etiqueta*/
		
		labelSaludo.setText(this.objSaludar.saludo());
		
		
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGap(95)
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnCrear)
								.addGroup(gl_panel_cen.createSequentialGroup()
									.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombre)
										.addComponent(lblIdentificacin)
										.addComponent(lblNacionalidad)
										.addComponent(lblTelefono)
										.addComponent(lblEdad))
									.addGap(64)
									.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
										.addComponent(textEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEjemploDePolimrfismo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelSaludo)))
					.addContainerGap(135, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEjemploDePolimrfismo)
						.addComponent(labelSaludo))
					.addGap(28)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificacin)
						.addComponent(textIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNacionalidad)
						.addComponent(textNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdad)
						.addComponent(textEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCrear)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_cen.setLayout(gl_panel_cen);
	}
	
	public void crear(){
		
		try{
			
				
				Cliente objCliente = new Cliente();
				
				objCliente.cambiarNombre(this.textNombre.getText());;
				objCliente.cambiarIdentificacion(Integer.parseInt(this.textIdentificacion.getText()));
				objCliente.cambiarNacionalidad(this.textNacionalidad.getText());
				objCliente.cambiarTelefono(this.textTelefono.getText());
				objCliente.cambiarEdad(Integer.parseInt(this.textEdad.getText()));
				objCliente.cambiarRefConstructora(this.auxObjConstructora);
				
				this.auxObjConstructora.agregar_cliente(objCliente);

				JOptionPane.showMessageDialog(this, "Cliente creado","Crear cliente",JOptionPane.INFORMATION_MESSAGE);
				
				
				this.textNombre.setText("");
				this.textIdentificacion.setText("");
				this.textNacionalidad.setText("");
				this.textTelefono.setText("");
				this.textEdad.setText("");
				
			
			
		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Datos no validos o vacios. ","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
