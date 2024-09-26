package vista.Cliente;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import mundo.Constructora;
import vista.InterfaceDialogs;
import vista.InterfaceEliminar;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JDialogCliente extends JDialog implements InterfaceDialogs, InterfaceEliminar {
	
	private static final long serialVersionUID = 1L;

	JPanel panel_cen;
	
	private Constructora auxObjConstructora;

	private jPanelCrearCliente objPCrearCliente;
	private jPanelEliminarCliente objPEliminarCliente;
	private jPanelImprimirCliente objPImprimirCliente;
	private jPanelEditarCliente objPEditarCliente;

	public JDialogCliente(Constructora objConstructora) {

		this.auxObjConstructora = objConstructora;
		
		this.objPCrearCliente = new jPanelCrearCliente(this.auxObjConstructora);
		this.objPEliminarCliente = new jPanelEliminarCliente(this.auxObjConstructora);
		this.objPImprimirCliente = new jPanelImprimirCliente(this.auxObjConstructora);
		this.objPEditarCliente = new jPanelEditarCliente(this.auxObjConstructora);
		
		lanzar_componentes();
	}
	
	public void lanzar_componentes(){
		
		setSize(600, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel_sup = new JPanel();
		getContentPane().add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblGestinClientes = new JLabel("Gesti\u00F3n Clientes");
		lblGestinClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblGestinClientes);
		
		JPanel panel_iz = new JPanel();
		getContentPane().add(panel_iz, BorderLayout.WEST);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				crear();
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminar();
			}
		});
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				imprimir();
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editar();
			}
		});
		GroupLayout gl_panel_iz = new GroupLayout(panel_iz);
		gl_panel_iz.setHorizontalGroup(
			gl_panel_iz.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_iz.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_iz.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCrear)
						.addComponent(btnEliminar)
						.addComponent(btnEditar)
						.addComponent(btnImprimir))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_iz.setVerticalGroup(
			gl_panel_iz.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_iz.createSequentialGroup()
					.addGap(32)
					.addComponent(btnCrear)
					.addGap(32)
					.addComponent(btnEditar)
					.addGap(27)
					.addComponent(btnEliminar)
					.addGap(31)
					.addComponent(btnImprimir)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		panel_iz.setLayout(gl_panel_iz);
		
		panel_cen = new JPanel();
		getContentPane().add(panel_cen, BorderLayout.CENTER);
		panel_cen.setLayout(new BorderLayout(0, 0));
	}
	
	public void crear(){
		
		
		/*Eliminamos los paneles ya creados*/
		this.panel_cen.remove(objPImprimirCliente);
		this.panel_cen.remove(objPEliminarCliente);
		this.panel_cen.remove(objPEditarCliente);
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPCrearCliente);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
	}
	
	public void eliminar(){
		
		/*Eliminamos los paneles ya creados*/
		this.panel_cen.remove(objPCrearCliente);
		this.panel_cen.remove(objPImprimirCliente);
		this.panel_cen.remove(objPEditarCliente);
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPEliminarCliente);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
	}
	
	public void editar(){
		
		/*Eliminamos los paneles ya creados*/
		this.panel_cen.remove(objPCrearCliente);
		this.panel_cen.remove(objPEliminarCliente);
		this.panel_cen.remove(objPImprimirCliente);
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPEditarCliente);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
	}
	
	public void imprimir(){
		
		/*Eliminamos los paneles ya creados*/
		this.panel_cen.remove(objPCrearCliente);
		this.panel_cen.remove(objPEliminarCliente);
		this.panel_cen.remove(objPEditarCliente);
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPImprimirCliente);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
	}
	
	

}
