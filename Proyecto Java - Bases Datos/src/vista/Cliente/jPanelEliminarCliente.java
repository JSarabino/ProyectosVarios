package vista.Cliente;

import javax.swing.JPanel;

import mundo.Constructora;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class jPanelEliminarCliente extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Constructora auxObjConstructora;
	private int clienteAeliminar;
	private JTextField textCliente;

	public jPanelEliminarCliente(Constructora objConstructora) {
		setBorder(new LineBorder(Color.ORANGE, 3, true));

		this.auxObjConstructora = objConstructora;

		lanzar_componentes();
	}

	public void lanzar_componentes(){
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblEliminarCliente = new JLabel("Eliminar Cliente");
		lblEliminarCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblEliminarCliente);
		
		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.SOUTH);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		
		textCliente = new JTextField();
		textCliente.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminar(clienteAeliminar);
			}
		});
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				verificar();
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(118)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEliminar)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addComponent(lblIdentificacion)
							.addGap(18)
							.addComponent(textCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnVerificar)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(137, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(108)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificacion)
						.addComponent(textCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVerificar))
					.addGap(18)
					.addComponent(btnEliminar)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		panel_cen.setLayout(gl_panel_cen);
	}
	
	public void verificar(){
		
		try{
			
			boolean band = false;
				
			for (int i=0; i< this.auxObjConstructora.darClientes().size(); i++){
				
				if(Integer.parseInt(this.textCliente.getText()) == this.auxObjConstructora.darClientes().get(i).darIdentificacion()){
					
					JOptionPane.showMessageDialog(this, "Cliente encontrado","Eliminar Cliente",JOptionPane.INFORMATION_MESSAGE);
					band = true;
					
					clienteAeliminar = i;//Guarda la posicion del cliente a eliminar
					
					i = this.auxObjConstructora.darTrabajadores().size(); //iguala i al largo de la lista de clientes para salirse del ciclo
				}	
			}
			
			if(band == false){
				
				JOptionPane.showMessageDialog(this, "No se encontro el cliente","Eliminar Cliente",JOptionPane.ERROR_MESSAGE);
				
				this.textCliente.setText("");
			}
		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Identificación no valida o vacia ","Eliminar Cliente",JOptionPane.INFORMATION_MESSAGE);
			this.textCliente.setText("");
			
		}
	}
	
	public void eliminar(int i){
		
		try{
			
			
			if(Integer.parseInt(this.textCliente.getText()) != this.auxObjConstructora.darClientes().get(i).darIdentificacion()){
					
				JOptionPane.showMessageDialog(null, "Primero verifique la identificación.");
				this.textCliente.setText("");
					
			}else{
					
					
				this.auxObjConstructora.darClientes().remove(i);
					
				JOptionPane.showMessageDialog(this, "Cliente Eliminado","Eliminar Cliente",JOptionPane.INFORMATION_MESSAGE);
					
				this.textCliente.setText("");
					
			}
				
			
		}catch(IndexOutOfBoundsException e){
			
			JOptionPane.showMessageDialog(this, "No hay clientes","Elminar Cliente", JOptionPane.ERROR_MESSAGE);
			
		}catch(NumberFormatException e){
			
			
			JOptionPane.showMessageDialog(this, "La identificacion no es valida o esta vacia ","Error",JOptionPane.ERROR_MESSAGE);
			this.textCliente.setText("");
		}
	}
}
