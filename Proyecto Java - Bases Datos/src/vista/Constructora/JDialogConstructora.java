package vista.Constructora;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import mundo.Constructora;
import vista.InterfaceDialogs;
import vista.Cliente.JDialogCliente;
import vista.Trabajador.JDialogTrabajador;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JDialogConstructora extends JDialog  implements InterfaceDialogs{
	
	private static final long serialVersionUID = 1L;

	/*Volvemos global el panel central para dibujar loss jPanel crear e imprimir*/
	
	JPanel panel_cen;
	
	/*Auxiliar para manimular los datos de la constructora*/
	private Constructora auxObjConstructora;
	
	/*JPanels para la constructora*/
	
	private jPanelCrearConstructora objPCrearConstructora;
	
	private jPanelImprimirConstructora objPImprimirConstructora;
	
	private jPanelEditarConstructora objPEditarConstructora;

	public JDialogConstructora(Frame padre, boolean modo, Constructora objConstructora) {
		
		/*Datos de herencia del jFrame padre*/
		super(padre,modo);
		
		auxObjConstructora = objConstructora;
		
		objPCrearConstructora = new jPanelCrearConstructora(auxObjConstructora);
		objPImprimirConstructora = new jPanelImprimirConstructora(auxObjConstructora);
		objPEditarConstructora = new jPanelEditarConstructora(auxObjConstructora);
		
		
		lanzar_componentes();
	}
	
	public void lanzar_componentes(){
		
		setSize(600, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel_sup = new JPanel();
			getContentPane().add(panel_sup, BorderLayout.NORTH);
			{
				JLabel lblGestinConstructora = new JLabel("Gesti\u00F3n Constructora");
				lblGestinConstructora.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
				panel_sup.add(lblGestinConstructora);
			}
		}
		{
			JPanel panel_iz = new JPanel();
			getContentPane().add(panel_iz, BorderLayout.WEST);
			JButton btnCrear = new JButton("Crear");
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					crear();
				}
			});
			JButton btnImprimir = new JButton("Imprimir");
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					imprimir();
				}
			});
			
			JButton btnTrabajadores = new JButton("Gestión Trabajador");
			btnTrabajadores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					lanzar_trabajadores();
				}
			});
			
			JButton button = new JButton("Gestión Clientes");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					lanzar_clientes();
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
							.addComponent(button)
							.addComponent(btnTrabajadores)
							.addComponent(btnCrear)
							.addComponent(btnImprimir)
							.addComponent(btnEditar))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			gl_panel_iz.setVerticalGroup(
				gl_panel_iz.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_iz.createSequentialGroup()
						.addGap(66)
						.addComponent(btnCrear)
						.addGap(20)
						.addComponent(btnEditar)
						.addGap(18)
						.addComponent(btnImprimir)
						.addGap(18)
						.addComponent(button)
						.addGap(28)
						.addComponent(btnTrabajadores)
						.addContainerGap(71, Short.MAX_VALUE))
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
		this.panel_cen.remove(objPImprimirConstructora);
		this.panel_cen.remove(objPEditarConstructora);
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPCrearConstructora);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
	}
	
	public void editar(){
		
		/*Eliminamos los paneles ya creados*/
		this.panel_cen.remove(objPImprimirConstructora);
		this.panel_cen.remove(objPCrearConstructora);
		
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPEditarConstructora);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
	}
	
	public void imprimir(){
		
		/*Eliminamos los paneles ya creados*/
		this.panel_cen.remove(objPCrearConstructora);
		this.panel_cen.remove(objPEditarConstructora);
		
		/*Dibujamos el panel*/
		this.panel_cen.add(objPImprimirConstructora);
		this.panel_cen.revalidate();
		this.panel_cen.repaint();
	}
	
	public void lanzar_trabajadores(){
		
		JDialogTrabajador objDialogTrabajador = new JDialogTrabajador(this.auxObjConstructora);
		objDialogTrabajador.setVisible(true);
	}
	
	public void lanzar_clientes(){
		
		JDialogCliente objDialogCliente = new JDialogCliente(this.auxObjConstructora);
		objDialogCliente.setVisible(true);
	}
}
