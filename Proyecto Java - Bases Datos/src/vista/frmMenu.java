package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mundo.Constructora;
import vista.Constructora.JDialogConstructora;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Constructora objConstructora;


	public frmMenu() {
		
		objConstructora = new Constructora();
		
		lanzar_componentes();

	}
	
	
	/*Metodo para despejar el constructor del JFrame*/
	public void lanzar_componentes(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(400, 250);//Dar medidas a la ventana
		setLocationRelativeTo(null);//Hacer que la ventana salga en la mitad de la pantalla
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_sup = new JPanel();
		contentPane.add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblConstructora = new JLabel("Constructora");
		lblConstructora.setForeground(Color.ORANGE);
		lblConstructora.setFont(new Font("Stencil", Font.PLAIN, 16));
		panel_sup.add(lblConstructora);
		
		JPanel panel_cen = new JPanel();
		contentPane.add(panel_cen, BorderLayout.CENTER);
		
		JButton btnGestionConstructora = new JButton("Gestion Constructora");
		btnGestionConstructora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lanzar_constructora();
			}
		});
		btnGestionConstructora.setForeground(Color.BLACK);
		btnGestionConstructora.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(102)
					.addComponent(btnGestionConstructora)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(67)
					.addComponent(btnGestionConstructora)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		panel_cen.setLayout(gl_panel_cen);
	}
	
	public void lanzar_constructora(){
		
		JDialogConstructora objJDConstructora = new JDialogConstructora(this,false,objConstructora);
		objJDConstructora.setVisible(true);
	}
}
