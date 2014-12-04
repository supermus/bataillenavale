package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.AbstractController;
import core.Const;

public class AboutView extends AbstractView {

	/**
	 * Create the panel.
	 */
	
	public AboutView(AbstractController c) {
		super(c);
		setLayout(null);
		this.setPreferredSize(new Dimension(447, 308));
	
		JLabel lblNewLabel = new JLabel("Version: ");
		lblNewLabel.setBounds(330, 41, 58, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 108, 430, 163);
		textArea.setText("dsfsd\r\nfds\r\ns\r\ndfd\r\n");
		textArea.setEditable(false);
		add(textArea);
		
		JLabel lblVer = new JLabel("0.0.0");
		lblVer.setBounds(390, 41, 48, 27);
		lblVer.setText(Const.VERSION);
		add(lblVer);
		
		JLabel lblNewLabel_1 = new JLabel("Bataille Navale Game");
		lblNewLabel_1.setBounds(0, 0, 450, 40);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("About:");
		lblNewLabel_2.setBounds(10, 88, 46, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Retour Menu");
		btnNewButton.setBounds(168, 277, 111, 23);
		btnNewButton.addActionListener(c);
		add(btnNewButton);

	}
}
