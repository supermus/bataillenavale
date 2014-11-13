package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.Controller;

public class AboutView extends JPanel {

	/**
	 * Create the panel.
	 */
	private Controller controlleur;
	
	public AboutView(Controller control) {
		this.controlleur = control;
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Version: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(88, 49, 61, 27);
		add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("dsfsd\r\nfds\r\ns\r\ndfd\r\n");
		textArea.setEditable(false);
		textArea.setBounds(10, 108, 430, 163);
		add(textArea);
		
		JLabel lblVer = new JLabel("ver1");
		lblVer.setBounds(194, 55, 46, 14);
		add(lblVer);
		
		JLabel lblNewLabel_1 = new JLabel("Bataille Navale Game");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(136, 0, 190, 54);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("About:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 88, 46, 14);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Retour Menu");
		btnNewButton.setBounds(168, 277, 111, 23);
		btnNewButton.addActionListener(controlleur);
		add(btnNewButton);

	}
}
