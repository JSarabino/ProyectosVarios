package vista.Trabajador;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mundo.Constructora;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import mundo.TipoCargo;
import mundo.Trabajador;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class jPanelCrearTrabajador extends JPanel {

	private static final long serialVersionUID = 1L;
	private Constructora auxObjConstructora;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textIdentificacion;
	
	
	/*Volver jComboBox global*/
	JComboBox<TipoCargo> comboBoxCargo;
	
	/*Volver global el jCalendar */
	JDateChooser dateNacimiento;
	
	/*Trabajador que saludará*/
	
	/*Importancia de un constructor vacio*/
	Trabajador objSaludar = new Trabajador();
	
	public jPanelCrearTrabajador(Constructora objConstructora) {
		
		auxObjConstructora = objConstructora;

		lanzar_componentes();
	}

	public void lanzar_componentes(){
		
		setBorder(new LineBorder(Color.YELLOW, 3, true));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblCrearTrabajador = new JLabel("Crear Trabajador");
		lblCrearTrabajador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblCrearTrabajador);
		
		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblEdad = new JLabel("Edad");
		
		JLabel lblIdentificacin = new JLabel("Identificaci\u00F3n");
		
		JLabel lblCargo = new JLabel("Cargo");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		textEdad = new JTextField();
		textEdad.setColumns(10);
		
		textIdentificacion = new JTextField();
		textIdentificacion.setColumns(10);
		
		comboBoxCargo = new JComboBox<TipoCargo>();
		comboBoxCargo.setModel(new DefaultComboBoxModel<TipoCargo>(TipoCargo.values()));
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				crear_trabajador();
			}
		});
		
		dateNacimiento = new JDateChooser();
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		
		JLabel lblEjemploDePolimrfismo = new JLabel("Ejemplo de polim\u00F3rfismo en un saludo:");
		
		JLabel labelSaludo = new JLabel("----");
		/*Cambiamos lo que dice la etiqueta*/
		
		labelSaludo.setText(this.objSaludar.saludo());
		
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCrear)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblIdentificacin)
								.addComponent(lblEdad)
								.addComponent(lblNacimiento)
								.addComponent(lblCargo))
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_cen.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
									.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
										.addComponent(dateNacimiento, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
										.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(textEdad)
											.addComponent(textNombre)
											.addComponent(textIdentificacion))))
								.addGroup(gl_panel_cen.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(164, Short.MAX_VALUE))
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEjemploDePolimrfismo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelSaludo)
					.addContainerGap(200, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEjemploDePolimrfismo)
						.addComponent(labelSaludo))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdad)
						.addComponent(textEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificacin)
						.addComponent(textIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addComponent(lblNacimiento)
							.addGap(24)
							.addComponent(lblCargo))
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addComponent(dateNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBoxCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(27)
					.addComponent(btnCrear)
					.addGap(20))
		);
		panel_cen.setLayout(gl_panel_cen);
	}
	
	
	
	public String convertir_fecha(JDateChooser fecha){
		
		String dia = Integer.toString(fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes = Integer.toString(fecha.getCalendar().get(Calendar.MONTH)+1);
		String año = Integer.toString(fecha.getCalendar().get(Calendar.YEAR));
		
		String txtFecha = (dia+"-"+mes+"-"+año);
		
		return txtFecha;
	}
	
	public void crear_trabajador(){
		
		
		try{
			
			/*Obtener la eleccion del jComboBox*/
			
			TipoCargo cargo;
			int i;
			
			i = this.comboBoxCargo.getSelectedIndex();
			cargo = this.comboBoxCargo.getItemAt(i);
			
			/*Volver String el jCalendar*/
			
			String fechaNacimiento = convertir_fecha(dateNacimiento);
			
			/*Volver entero la edad y la identificacion*/
			
			int edad;
			int identificacion;
			
			edad = Integer.parseInt(this.textEdad.getText());
			identificacion = Integer.parseInt(this.textIdentificacion.getText());
			
			/*Crear el trabajador*/
			
			this.auxObjConstructora.crear_trabajador(
					textNombre.getText(),
					identificacion,
					edad,
					cargo,
					fechaNacimiento,
					auxObjConstructora);
			
			JOptionPane.showMessageDialog(this, "Trabajador Creado","Crear Trabajador",JOptionPane.INFORMATION_MESSAGE);
			
			this.textNombre.setText("");
			this.textIdentificacion.setText("");
			this.textEdad.setText("");
			
		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Datos no validos o vacios","Crear Trabajador",JOptionPane.INFORMATION_MESSAGE);
		}catch(NullPointerException e){
			
			JOptionPane.showMessageDialog(this, "Digite los datos y la fecha de nacimiento","Crear Trabajador",JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
