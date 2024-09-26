package vista.Trabajador;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import mundo.Constructora;
import mundo.TipoCargo;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class jPanelEditarTrabajador extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textBuscar;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textIdentificacion;


	private Constructora auxObjConstructora;
	private int trabajadorAeditar;
	
	JDateChooser dateNacimiento;
	JComboBox<TipoCargo> comboBox;
	JButton btnEditar;
	JButton btnBuscar;
	
	public jPanelEditarTrabajador(Constructora objConstructora) {

		auxObjConstructora = objConstructora;
		
		lanzar_componentes();
	}
	
	public void lanzar_componentes(){
		
		setBorder(new LineBorder(Color.YELLOW, 3, true));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblEditarTrabajador = new JLabel("Editar Trabajador");
		lblEditarTrabajador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblEditarTrabajador);
		
		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);
		
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
		
		JLabel lblEdad = new JLabel("Edad");
		
		JLabel lblIdentificacin_1 = new JLabel("Identificaci\u00F3n");
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		
		JLabel lblCargo = new JLabel("Cargo");
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setColumns(10);
		
		textEdad = new JTextField();
		textEdad.setEnabled(false);
		textEdad.setColumns(10);
		
		textIdentificacion = new JTextField();
		textIdentificacion.setEnabled(false);
		textIdentificacion.setColumns(10);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editar(trabajadorAeditar);
			}
		});
		btnEditar.setEnabled(false);
		
		dateNacimiento = new JDateChooser();
		dateNacimiento.getCalendarButton().setEnabled(false);
		
		comboBox = new JComboBox<TipoCargo>();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel<TipoCargo>(TipoCargo.values()));
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(89)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIdentificacin)
								.addComponent(lblNombre)
								.addComponent(lblEdad))
							.addGap(18)
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(textEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnEditar)
									.addGroup(gl_panel_cen.createSequentialGroup()
										.addComponent(textBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnBuscar)))))
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIdentificacin_1)
								.addComponent(lblNacimiento)
								.addComponent(lblCargo))
							.addGap(18)
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(dateNacimiento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textIdentificacion))))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBuscar)
						.addComponent(textBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdentificacin))
					.addGap(18)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdad)
						.addComponent(textEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificacin_1)
						.addComponent(textIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNacimiento)
						.addComponent(dateNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCargo)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditar))
					.addContainerGap(32, Short.MAX_VALUE))
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
	
	public void buscar(){
		
		try{
			
			boolean band = false;
			
			for (int i=0; i< auxObjConstructora.darTrabajadores().size(); i++){
					
				if(Integer.parseInt(this.textBuscar.getText()) == auxObjConstructora.darTrabajadores().get(i).darIdentificacion()){
						
					JOptionPane.showMessageDialog(this, "Trabajador encontrado","Editar Trabajador",JOptionPane.INFORMATION_MESSAGE);
					band = true;
						
					trabajadorAeditar = i;//Guarda la posicion del trabajador a editar
						
					i = auxObjConstructora.darTrabajadores().size(); //iguala i al largo de la lista de trabajadores para salirse del ciclo
					
					//Activar los campos
					
					this.textNombre.setEnabled(true);
					this.textIdentificacion.setEnabled(true);
					this.textEdad.setEnabled(true);
					this.dateNacimiento.setEnabled(true);
					this.comboBox.setEnabled(true);
					
					
					//Activar boton de editar
					
					this.btnEditar.setEnabled(true);
					
					//Descativar campos de buscar
					
					this.textBuscar.setEditable(false);
					this.btnBuscar.setEnabled(false);
					
				}
			}
				
			if(band == false){
					
				JOptionPane.showMessageDialog(this, "No se encontro el  trabajador","Editar Trabajador",JOptionPane.ERROR_MESSAGE);
					
				this.textBuscar.setText("");
			}
			

		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Identificación no valida o vacia ","Error", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public void editar(int i){
		
		
			try{
				//Convertir Fecha de nacimiento
				
				TipoCargo cargo;
				int j;
				
				j = this.comboBox.getSelectedIndex();
				cargo = this.comboBox.getItemAt(j);
				
				//Convertir ComboBox
				
				String fechaNacimiento = convertir_fecha(dateNacimiento); 
				
				
				auxObjConstructora.darTrabajadores().get(i).cambiarNombre(this.textNombre.getText());
				auxObjConstructora.darTrabajadores().get(i).cambiarIdentificacion(Integer.parseInt(this.textIdentificacion.getText()));
				auxObjConstructora.darTrabajadores().get(i).cambiarEdad(Integer.parseInt(this.textEdad.getText()));
				auxObjConstructora.darTrabajadores().get(i).cambiarFechaNacimiento(fechaNacimiento);
				auxObjConstructora.darTrabajadores().get(i).cambiarCargo(cargo);
						
				this.textNombre.setText("");
				this.textIdentificacion.setText("");
				this.textEdad.setText("");
						
				JOptionPane.showMessageDialog(this, "Datos actualizados","Editar Trabajador",JOptionPane.INFORMATION_MESSAGE);
				this.textBuscar.setText("");
						
				//Desactivar los campos
						
				this.textNombre.setEnabled(false);
				this.textIdentificacion.setEnabled(false);
				this.textEdad.setEnabled(false);
				this.dateNacimiento.setEnabled(false);
				this.comboBox.setEnabled(false);
						
				//desactivar boton de editar
						
				this.btnEditar.setEnabled(false);
						
				//Ativar campos de buscar
						
				this.textBuscar.setEditable(true);
				this.btnBuscar.setEnabled(true);		
			
		}catch(IndexOutOfBoundsException e){
			
			JOptionPane.showMessageDialog(this, "No hay trabajadores","Error", JOptionPane.ERROR_MESSAGE);
			this.textBuscar.setText("");
			
		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Hay datos no validos o vacios","Editar Trabajador",JOptionPane.INFORMATION_MESSAGE);
		}catch(NullPointerException e){
			
			JOptionPane.showMessageDialog(this, "Digite los datos y la fecha de nacimiento","Editar Trabajador",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
