package vista.Cliente;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;

import mundo.Constructora;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelEditarCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textBuscar;
	private JTextField textNombre;
	private JTextField textIdentificacion;
	private JTextField textNacionalidad;
	private JTextField textTelefono;
	private JTextField textEdad;

	private Constructora auxObjConstructora;
	private int clienteAeditar;
	JButton btnEditar;
	JButton btnBuscar;
	
	public jPanelEditarCliente(Constructora objConstructora) {

		auxObjConstructora = objConstructora;
		lanzar_componentes();
	}
	
	public void lanzar_componentes(){
		
		setBorder(new LineBorder(Color.ORANGE, 3, true));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblEditarCliente = new JLabel("Editar Cliente");
		lblEditarCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel.add(lblEditarCliente);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		JLabel lblIdentificacin = new JLabel("Identificaci\u00F3n");
		
		textBuscar = new JTextField();
		textBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buscar();
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblIdentificacin_1 = new JLabel("Identificaci\u00F3n");
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		JLabel lblEdad = new JLabel("Edad");
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setColumns(10);
		
		textIdentificacion = new JTextField();
		textIdentificacion.setEnabled(false);
		textIdentificacion.setColumns(10);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setEnabled(false);
		textNacionalidad.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setEnabled(false);
		textTelefono.setColumns(10);
		
		textEdad = new JTextField();
		textEdad.setEnabled(false);
		textEdad.setColumns(10);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editar(clienteAeditar);
			}
		});
		btnEditar.setEnabled(false);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdentificacin)
						.addComponent(lblNombre)
						.addComponent(lblIdentificacin_1)
						.addComponent(lblNacionalidad)
						.addComponent(lblTelefono)
						.addComponent(lblEdad))
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEditar))
						.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscar)))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificacin)
						.addComponent(textBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificacin_1)
						.addComponent(textIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNacionalidad)
						.addComponent(textNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdad)
						.addComponent(textEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditar))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

	}
	
	public void buscar(){
		
		try{
			
				
			boolean band = false;
			
			for (int i=0; i< auxObjConstructora.darClientes().size(); i++){
					
				if(Integer.parseInt(this.textBuscar.getText()) == auxObjConstructora.darClientes().get(i).darIdentificacion()){
						
					JOptionPane.showMessageDialog(this, "Cliente encontrado","Editar cliente",JOptionPane.INFORMATION_MESSAGE);
					band = true;
						
					clienteAeditar = i;//Guarda la posicion del cliente a editar
						
					i = auxObjConstructora.darClientes().size(); //iguala i al largo de la lista de clientes para salirse del ciclo
					
					//Activar los campos
					
					this.textNombre.setEnabled(true);
					this.textIdentificacion.setEnabled(true);
					this.textNacionalidad.setEnabled(true);
					this.textTelefono.setEnabled(true);
					this.textEdad.setEnabled(true);
					
					//Activar botod de editar
					
					this.btnEditar.setEnabled(true);
					
					//Descativar campos de buscar
					
					this.textBuscar.setEditable(false);
					this.btnBuscar.setEnabled(false);
					
				}
			}
				
			if(band == false){
					
				JOptionPane.showMessageDialog(this, "No se encontro el  cliente","Editar cliente",JOptionPane.ERROR_MESSAGE);
					
				this.textBuscar.setText("");
			}
			

		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Identificación no valida o vacia ","Error", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}

	public void editar(int i){
		
		try{
						
				auxObjConstructora.darClientes().get(i).cambiarNombre(this.textNombre.getText());
				auxObjConstructora.darClientes().get(i).cambiarIdentificacion(Integer.parseInt(this.textIdentificacion.getText()));
				auxObjConstructora.darClientes().get(i).cambiarNacionalidad(this.textNacionalidad.getText());
				auxObjConstructora.darClientes().get(i).cambiarTelefono(this.textTelefono.getText());
				auxObjConstructora.darClientes().get(i).cambiarEdad(Integer.parseInt(this.textEdad.getText()));
						
				this.textNombre.setText("");
				this.textIdentificacion.setText("");
				this.textNacionalidad.setText("");
				this.textTelefono.setText("");
				this.textEdad.setText("");
						
				JOptionPane.showMessageDialog(this, "Datos actualizados","Editar cliente",JOptionPane.INFORMATION_MESSAGE);
				this.textBuscar.setText("");
						
				//Desactivar los campos
						
				this.textNombre.setEnabled(false);
				this.textIdentificacion.setEnabled(false);
				this.textNacionalidad.setEnabled(false);
				this.textTelefono.setEnabled(false);
				this.textEdad.setEnabled(false);
						
				//desactivar boton de editar
						
				this.btnEditar.setEnabled(false);
						
				//Ativar campos de buscar
						
				this.textBuscar.setEditable(true);
				this.btnBuscar.setEnabled(true);		
			
		}catch(IndexOutOfBoundsException e){
			
			JOptionPane.showMessageDialog(this, "No hay cleintes","Error", JOptionPane.ERROR_MESSAGE);
			this.textBuscar.setText("");
			
		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Hay datos no validos o vacios","Editar cliente",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
