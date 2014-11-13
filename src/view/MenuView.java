package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;

public class MenuView extends JPanel {

	public JButton btnPlay;
	public JButton btnQuit;
	public JButton btnCredits;
	
	public MenuView() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		btnPlay = new JButton("Play");
		add(btnPlay);
		
		btnQuit = new JButton("Quit");
		add(btnQuit);
		
	    btnCredits = new JButton("Credits");
		add(btnCredits);

	}

}
