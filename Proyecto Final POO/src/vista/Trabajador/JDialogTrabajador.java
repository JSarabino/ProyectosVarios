package vista.Trabajador;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import mundo.Constructora;
import vista.InterfaceDialogs;
import vista.InterfaceEliminar;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogTrabajador extends JDialog implements InterfaceDialogs, InterfaceEliminar {
	
	private static final long serialVersionUID = 1L;

	private JButton btnCrear;
	
	JPanel panel_cen;

	private Constructora auxObjConstructora;
	
	private jPanelCrearTrabajador objPCrearTrabajador;
	
	private jPanelEliminarTrabajador objPEliminarTrabajador;
	
	private jPanelImprimirTrabajador objPImprimirTrabajador;
	
	private jPanelEditarTrabajador objPEditarTrabajador;

	public JDialogTrabajador(Constructora objConstructora) {
		
		auxObjConstructora = objConstructora;
		
		
		objPCrearTrabajador = new jPanelCrearTrabajador(auxObjConstructora);
		objPEliminarTrabajador = new jPanelEliminarTrabajador(auxObjConstructora);
		objPImprimirTrabajador = new jPanelImprimirTrabajador(auxObjConstructora);
		objPEditarTrabajador = new jPanelEditarTrabajador(auxObjConstructora);
		
		
		lanzar_componentes();
	}

	
	public void lanzar_componentes(){
		
		setSize(600, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel panel_sup = new JPanel();
			getContentPane().add(panel_sup, BorderLayout.NORTH);
			{
				JLabel lblGestionTrabajador = new JLabel("Gestion Trabajador");
				lblGestionTrabajador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
				panel_sup.add(lblGestionTrabajador);
			}
		}
		{
			JPanel panel_iz = new JPanel();
			getContentPane().add(panel_iz, BorderLayout.WEST);
			{
				btnCrear = new JButton("Crear");
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						crear();
					}
				});
			}
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					eliminar();
				}
			});
			JButton btnImrpimir = new JButton("Imrpimir");
			btnImrpimir.addActionListener(new ActionListener() {
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
					.addGroup(Alignment.TRAILING, gl_panel_iz.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnImrpimir)
						.addContainerGap())
					.addGroup(gl_panel_iz.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnEliminar)
						.addContainerGap(12, Short.MAX_VALUE))
					.addGroup(gl_panel_iz.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnEditar)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(gl_panel_iz.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnCrear)
						.addContainerGap(22, Short.MAX_VALUE))
			);
			gl_panel_iz.setVerticalGroup(
				gl_panel_iz.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_iz.createSequentialGroup()
						.addGap(49)
						.addComponent(btnCrear)
						.addGap(27)
						.addComponent(btnEditar)
						.addGap(28)
						.addComponent(btnEliminar)
						.addGap(28)
						.addComponent(btnImrpimir)
						.addContainerGap(112, Short.MAX_VALUE))
			);
			panel_iz.setLayout(gl_panel_iz);
		}
		{
			panel_cen = new JPanel();
			getContentPane().add(panel_cen, BorderLayout.CENTER);
			panel_cen.setLayout(new BorderLayout(0, 0));
		}
	}
	
	public void crear(){
		
		/*Eliminamos los paneles ya creados*/
		this.panel_cen.remove(objPEliminarTrabajador);
		this.panel_cen.remove(objPImprimirTrabajador);
		this.panel_cen.remove(objPEditarTrabajador);
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPCrearTrabajador);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
		
	}
	
	public void editar(){
		
		this.panel_cen.remove(objPEliminarTrabajador);
		this.panel_cen.remove(objPImprimirTrabajador);
		this.panel_cen.remove(objPCrearTrabajador);
		
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPEditarTrabajador);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
	}
	
	public void eliminar(){
		
		this.panel_cen.remove(objPCrearTrabajador);
		this.panel_cen.remove(objPImprimirTrabajador);
		this.panel_cen.remove(objPEditarTrabajador);
		
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPEliminarTrabajador);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
	}
	
	public void imprimir(){
		
		this.panel_cen.remove(objPCrearTrabajador);
		this.panel_cen.remove(objPEliminarTrabajador);
		this.panel_cen.remove(objPEditarTrabajador);
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPImprimirTrabajador);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
	}
}
