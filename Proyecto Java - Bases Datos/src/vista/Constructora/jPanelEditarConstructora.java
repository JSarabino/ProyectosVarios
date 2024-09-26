package vista.Constructora;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import mundo.Constructora;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class jPanelEditarConstructora extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textIdentiicador;
	
	private Constructora auxObjConstructora;

	public jPanelEditarConstructora(Constructora objConstructora) {

		auxObjConstructora = objConstructora;
		
		lanzar_componentes();
	}
	
	public void lanzar_componentes(){
		
		setBorder(new LineBorder(Color.RED, 3, true));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);
		
		JLabel lblEditarConstructora = new JLabel("Editar Constructora");
		lblEditarConstructora.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_sup.add(lblEditarConstructora);
		
		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblIdentificador = new JLabel("Identificador");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		textIdentiicador = new JTextField();
		textIdentiicador.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editar();
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(105)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEditar)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblIdentificador))
							.addGap(31)
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(textIdentiicador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(167, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(78)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificador)
						.addComponent(textIdentiicador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnEditar)
					.addContainerGap(90, Short.MAX_VALUE))
		);
		panel_cen.setLayout(gl_panel_cen);
	}
	
	public void editar(){
		
		try{
			

				
				this.auxObjConstructora.cambiarNombre(this.textNombre.getText());
				this.auxObjConstructora.cambiarIdentificador(Integer.parseInt(this.textIdentiicador.getText()));

				
				this.textNombre.setText("");
				this.textIdentiicador.setText("");

				
				JOptionPane.showMessageDialog(this, "Datos actualizados","Editar Constructora",JOptionPane.INFORMATION_MESSAGE);
				
			
			
		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Datos no validos o vacios", "Editar Constructora", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}

}
