package view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class GameConfigView extends JPanel {
	private JTextField txtUsername;

	/**
	 * Create the panel.
	 */
	public GameConfigView() {
		setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Pseudo");
		panel.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setText("Pseudo\r\n");
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JLabel lblGameMode = new JLabel("Mode de jeu :");
		panel_2.add(lblGameMode);
		
		JRadioButton rdbtnBattleship = new JRadioButton("Bataille Navalle\r\n");
		panel_2.add(rdbtnBattleship);
		
		JRadioButton rdbtnAlerteRouge = new JRadioButton("Alerte Rouge");
		panel_2.add(rdbtnAlerteRouge);
		
		JRadioButton rdbtnArtillerie = new JRadioButton("Artillerie");
		panel_2.add(rdbtnArtillerie);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblTypeDePartie = new JLabel("Type de partie :");
		panel_1.add(lblTypeDePartie);
		
		JRadioButton rdbtnDemo = new JRadioButton("Demo");
		panel_1.add(rdbtnDemo);
		
		JRadioButton rdbtnJ = new JRadioButton("1 Joueur");
		panel_1.add(rdbtnJ);
		
		JRadioButton rdbtnJoueur = new JRadioButton("2 Joueur");
		panel_1.add(rdbtnJoueur);

	}

}
