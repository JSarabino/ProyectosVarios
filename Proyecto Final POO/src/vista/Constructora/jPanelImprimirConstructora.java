package vista.Constructora;

import javax.swing.JPanel;

import mundo.Constructora;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelImprimirConstructora extends JPanel {

	private static final long serialVersionUID = 1L;
	/*volvemos globales las etiqutas que vamos a editar*/
	JLabel labelNombre;
	JLabel labelIdentificador;
	
	private Constructora auxObjConstructora;
	
	public jPanelImprimirConstructora(Constructora objConstructora) {

		auxObjConstructora = objConstructora;
		
		lanzar_componentes();
	}
	
	public void lanzar_componentes(){
		
		setBorder(new LineBorder(Color.RED, 3, true));
		setForeground(Color.RED);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblImprimirConstructora = new JLabel("Imprimir Constructora");
		lblImprimirConstructora.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblImprimirConstructora);
		
		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblIdentificador = new JLabel("Identificador");
		
		labelNombre = new JLabel("----");
		
		labelIdentificador = new JLabel("-----");
		
		JButton btnActulizar = new JButton("Actulizar");
		btnActulizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				llenar_datos();
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(122)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnActulizar)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblIdentificador))
							.addGap(42)
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(labelIdentificador)
								.addComponent(labelNombre))))
					.addContainerGap(173, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(labelNombre))
					.addGap(29)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificador)
						.addComponent(labelIdentificador))
					.addGap(40)
					.addComponent(btnActulizar)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		panel_cen.setLayout(gl_panel_cen);
	}
	
	public void llenar_datos(){
		
		
		this.labelNombre.setText(this.auxObjConstructora.darNombre());
		this.labelIdentificador.setText(Integer.toString(this.auxObjConstructora.darIdentificador()));
	}

}
