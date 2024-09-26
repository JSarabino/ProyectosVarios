package vista.Trabajador;

import javax.swing.JPanel;

import mundo.Constructora;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelImprimirTrabajador extends JPanel {

	private static final long serialVersionUID = 1L;
	private Constructora auxObjConstructora;
	private JTable table;
	
	public jPanelImprimirTrabajador(Constructora objConstructora) {

		auxObjConstructora = objConstructora;
		
		lanzar_componentes();
	}
	
	public void llenar_tabla(){
		
		Object matriz[][] = new Object [this.auxObjConstructora.darTrabajadores().size()][5];
		
		for(int i = 0 ; i<this.auxObjConstructora.darTrabajadores().size();i++) {
			
			matriz[i][0] = this.auxObjConstructora.darTrabajadores().get(i).darNombre();
			matriz[i][1] = this.auxObjConstructora.darTrabajadores().get(i).darIdentificacion();
			matriz[i][2] = this.auxObjConstructora.darTrabajadores().get(i).darEdad();
			matriz[i][3] = this.auxObjConstructora.darTrabajadores().get(i).darCargo();
			matriz[i][4] = this.auxObjConstructora.darTrabajadores().get(i).darFechaNacimiento();

		}
		
		table.setModel(new javax.swing.table.DefaultTableModel(matriz, new String []{"Nombre", "Identificación", "Edad", "Cargo", "FNacimiento"}));
		
	}
	
	public void lanzar_componentes(){
		
		setBorder(new LineBorder(Color.YELLOW, 3, true));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblImprimirTrabajador = new JLabel("Imprimir Trabajador");
		lblImprimirTrabajador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblImprimirTrabajador);
		
		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				llenar_tabla();
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnActualizar)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(22)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnActualizar)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Identificaci\u00F3n", "Edad", "Cargo", "FNacimiento"
			}
		));
		scrollPane.setViewportView(table);
		panel_cen.setLayout(gl_panel_cen);
	}
}
