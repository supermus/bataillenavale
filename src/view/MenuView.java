package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;

public class MenuView extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuView() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Play");
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quit");
		add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Credits");
		add(btnNewButton);

	}

}
