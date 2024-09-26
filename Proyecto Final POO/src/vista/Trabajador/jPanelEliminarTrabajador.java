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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelEliminarTrabajador extends JPanel {

	private static final long serialVersionUID = 1L;

	private int trabajadorAeliminar;
	
	private Constructora auxObjConstructora;
	private JTextField textIdentificacion;

	public jPanelEliminarTrabajador(Constructora objConstructora) {
		
		auxObjConstructora = objConstructora;
		
		lanzar_componentes();		
	}
	
	public void lanzar_componentes(){
		
		setBorder(new LineBorder(Color.YELLOW, 3, true));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblEliminarTrabajador = new JLabel("Eliminar Trabajador");
		lblEliminarTrabajador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblEliminarTrabajador);
		
		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		
		textIdentificacion = new JTextField();
		textIdentificacion.setColumns(10);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				verificar_trabajador();
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminar_trabajador(trabajadorAeliminar);
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(114)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEliminar)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addComponent(lblIdentificacion)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnVerificar)))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificacion)
						.addComponent(textIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVerificar))
					.addGap(27)
					.addComponent(btnEliminar)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		panel_cen.setLayout(gl_panel_cen);
	}
	
	public void verificar_trabajador(){
		
		try{
			
			boolean band = false;
				
			for (int i=0; i< this.auxObjConstructora.darTrabajadores().size(); i++){
				
				if(Integer.parseInt(this.textIdentificacion.getText()) == this.auxObjConstructora.darTrabajadores().get(i).darIdentificacion()){
					
					JOptionPane.showMessageDialog(this, "Trabajador encontrado","Eliminar Trabajador",JOptionPane.INFORMATION_MESSAGE);
					band = true;
					
					trabajadorAeliminar = i;//Guarda la posicion del trabajador a eliminar
					
					i = this.auxObjConstructora.darTrabajadores().size(); //iguala i al largo de la lista de trabajadores para salirse del ciclo
				}	
			}
			
			if(band == false){
				
				JOptionPane.showMessageDialog(this, "No se encontro el trabajador","Eliminar Trabajador",JOptionPane.ERROR_MESSAGE);
				
				this.textIdentificacion.setText("");
			}
		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Identificación no valida o vacia ","Eliminar Trabajador",JOptionPane.INFORMATION_MESSAGE);
			this.textIdentificacion.setText("");
			
		}
	}
	
	
	
	public void eliminar_trabajador(int i){
		
		try{
			
				
			if(Integer.parseInt(this.textIdentificacion.getText()) != this.auxObjConstructora.darTrabajadores().get(i).darIdentificacion()){
					
				JOptionPane.showMessageDialog(null, "Primero verifique la identificación.");
				this.textIdentificacion.setText("");
					
			}else{
					
					
				this.auxObjConstructora.darTrabajadores().remove(i);
					
				JOptionPane.showMessageDialog(this, "Trabajador Eliminado","Eliminar Trabajador",JOptionPane.INFORMATION_MESSAGE);
					
				this.textIdentificacion.setText("");
					
			}
				
			
		}catch(IndexOutOfBoundsException e){
			
			JOptionPane.showMessageDialog(this, "No hay trabajadores","Elminar Trabajador", JOptionPane.ERROR_MESSAGE);
			
		}catch(NumberFormatException e){
			
			
			JOptionPane.showMessageDialog(this, "La identificacion no es valida o esta vacia ","Error",JOptionPane.ERROR_MESSAGE);
			this.textIdentificacion.setText("");
		}
	}
}
