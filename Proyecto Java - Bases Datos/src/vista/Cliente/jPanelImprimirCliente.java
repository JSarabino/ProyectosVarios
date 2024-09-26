package vista.Cliente;

import javax.swing.JPanel;

import mundo.Constructora;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class jPanelImprimirCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private Constructora auxObjConstructora;
	private JTable table;
	
	public jPanelImprimirCliente(Constructora objConstructora) {
		setBorder(new LineBorder(Color.ORANGE, 3, true));

		this.auxObjConstructora = objConstructora;
		
		lanzar_componentes();
	}
	
	public void llenar_tabla(){
		
		Object matriz[][] = new Object [this.auxObjConstructora.darClientes().size()][5];
		
		for(int i = 0 ; i<this.auxObjConstructora.darClientes().size();i++) {
			
			matriz[i][0] = this.auxObjConstructora.darClientes().get(i).darNombre();
			matriz[i][1] = this.auxObjConstructora.darClientes().get(i).darIdentificacion();
			matriz[i][2] = this.auxObjConstructora.darClientes().get(i).darNacionalidad();
			matriz[i][3] = this.auxObjConstructora.darClientes().get(i).darTelefono();
			matriz[i][4] = this.auxObjConstructora.darClientes().get(i).darEdad();

		}
		
		table.setModel(new javax.swing.table.DefaultTableModel(matriz, new String []{"Nombre", "Identificación", "Nacionalidad", "Telefono", "Edad"}));
		
	}

	public void lanzar_componentes(){
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblImprimirClientes = new JLabel("Imprimir Clientes");
		lblImprimirClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblImprimirClientes);
		
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
					.addContainerGap()
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
						.addComponent(btnActualizar, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(25)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnActualizar)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Identificación", "Nacionalidad", "Telefono", "Edad"
			}
		));
		scrollPane.setViewportView(table);
		panel_cen.setLayout(gl_panel_cen);
	}
}
