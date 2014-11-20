package view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameConfigView extends JPanel {
	
	private JTextField txtUsername;
	public JButton btnValider;
	public JButton btnAnnuler;
	

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
		rdbtnBattleship.setSelected(true);
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
		rdbtnDemo.setSelected(true);
		panel_1.add(rdbtnDemo);
		
		JRadioButton rdbtnJ = new JRadioButton("1 Joueur");
		panel_1.add(rdbtnJ);
		
		JRadioButton rdbtnJoueur = new JRadioButton("2 Joueur");
		panel_1.add(rdbtnJoueur);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JLabel lblTailleDeLa = new JLabel("Taille de la carte :");
		panel_3.add(lblTailleDeLa);
		
		JRadioButton radioButton = new JRadioButton("10*10");
		panel_3.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("12*12");
		panel_3.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("15*15");
		panel_3.add(radioButton_2);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JLabel lblDifficultDeLia = new JLabel("Difficult\u00E9 de l'IA :");
		panel_4.add(lblDifficultDeLia);
		
		JRadioButton rdbtnFacile = new JRadioButton("Facile");
		rdbtnFacile.setSelected(true);
		panel_4.add(rdbtnFacile);
		
		JRadioButton rdbtnMedium = new JRadioButton("Interm\u00E9diaire");
		panel_4.add(rdbtnMedium);
		
		JRadioButton rdbtnDifficile = new JRadioButton("Difficile");
		panel_4.add(rdbtnDifficile);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		
		JLabel lblNombreDeBateau = new JLabel("Nombre de bateau :");
		panel_5.add(lblNombreDeBateau);
		
		JLabel lblPorteAvion = new JLabel("Porte avion");
		panel_5.add(lblPorteAvion);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 0, 5, 4));
		panel_5.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Sous-Marin");
		panel_5.add(lblNewLabel_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 0, 5, 4));
		panel_5.add(spinner_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cuirass\u00E9s furtif");
		panel_5.add(lblNewLabel_2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(2, 0, 5, 4));
		panel_5.add(spinner_2);
		
		JLabel lblNewLabel_3 = new JLabel("Zodiac");
		panel_5.add(lblNewLabel_3);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 0, 5, 4));
		panel_5.add(spinner_3);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_6.add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		panel_6.add(btnAnnuler);
		//test
	}

}
