package vista.Constructora;

import javax.swing.JPanel;

import mundo.Constructora;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelCrearConstructora extends JPanel {

	private static final long serialVersionUID = 1L;

	JButton btnCrear;

	private Constructora auxObjConstructora;
	private JTextField textNombre;
	private JTextField textIdentificador;
	
	public jPanelCrearConstructora(Constructora objConstructora) {
		
		auxObjConstructora = objConstructora;
		
		lanzar_componentes();
	}
	
	public void lanzar_componentes(){
		
		setBorder(new LineBorder(Color.RED, 3, true));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblCrearConstructora = new JLabel("Crear Constructora");
		lblCrearConstructora.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblCrearConstructora);
		
		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblIdentificador = new JLabel("Identificador");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		textIdentificador = new JTextField();
		textIdentificador.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crear_constructora();
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(111)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCrear)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblIdentificador))
							.addGap(37)
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(textIdentificador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(97)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificador)
						.addComponent(textIdentificador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnCrear)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		panel_cen.setLayout(gl_panel_cen);
	}
	
	public void crear_constructora(){
	
		try{
			
			/*Llenar los datos de la constructora*/
			this.auxObjConstructora.cambiarNombre(this.textNombre.getText());
			this.auxObjConstructora.cambiarIdentificador(Integer.parseInt(this.textIdentificador.getText()));
			
			/*Imprimir mensaje de informacion*/
			
			JOptionPane.showMessageDialog(this, "Constructora creada con exito","Crear Constructora", JOptionPane.INFORMATION_MESSAGE);
			
			/*Vaciar los valores de las cajas de texto*/
			this.textNombre.setText("");
			this.textIdentificador.setText("");
			
			/*Desactivar boton de crear*/
			
			btnCrear.setEnabled(false);
			
		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Datos no validos o vacios","Crear Constructora", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
