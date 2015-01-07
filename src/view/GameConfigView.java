package view;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;



import controller.GameConfigController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameConfigView extends AbstractView {
	
	public JTextField txtUsername;
	public JButton btnValider;
	public JButton btnAnnuler;
	public JRadioButton rdbtnDemo;
	public JRadioButton rdbtn1Joueur;
	public JRadioButton rdbtn2Joueur;
	public JRadioButton rdbtnBattleship;
	public JRadioButton rdbtnAlerteRouge;
	public JRadioButton rdbtnArtillerie;
	public JRadioButton rdbtn12;
	public JRadioButton rdbtn10;
	public JRadioButton rdbtn15;
	public JRadioButton rdbtnFacile;
	public JRadioButton rdbtnMedium;
	public JRadioButton rdbtnDifficile;
	public JSpinner spinnerPorteAvion;
	public JSpinner spinnerSousMarin;
	public JSpinner spinnerCuirassésFurtif;
	public JSpinner spinnerZodiac;
	public ButtonGroup bg0 = new ButtonGroup();
	public ButtonGroup bg1 = new ButtonGroup();
	public ButtonGroup bg2 = new ButtonGroup();
	public ButtonGroup bg3 = new ButtonGroup();
	
	

	/**
	 * Create the panel.
	 */
	public GameConfigView(GameConfigController c) {
		super(c);
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
		
	    rdbtnBattleship = new JRadioButton("Bataille Navalle\r\n");
		rdbtnBattleship.setSelected(true);
		rdbtnBattleship.setActionCommand("BatailleNavalle");
		panel_2.add(rdbtnBattleship);
		
		rdbtnAlerteRouge = new JRadioButton("Alerte Rouge");
		rdbtnAlerteRouge.setActionCommand("AlerteRouge");
		panel_2.add(rdbtnAlerteRouge);
		
		rdbtnArtillerie = new JRadioButton("Artillerie");
		rdbtnArtillerie.setActionCommand("Artillerie");
		panel_2.add(rdbtnArtillerie);
		
		//Bg3 Choix du type de la bataille
		bg3.add(rdbtnBattleship);
		bg3.add(rdbtnAlerteRouge);
		bg3.add(rdbtnArtillerie);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblTypeDePartie = new JLabel("Type de partie :");
		panel_1.add(lblTypeDePartie);
			
		
	    rdbtnDemo = new JRadioButton("Demo");
		rdbtnDemo.setSelected(true);
		rdbtnDemo.setActionCommand("Demo"); 
		panel_1.add(rdbtnDemo);
		
	    rdbtn1Joueur = new JRadioButton("1 Joueur");
	    rdbtn1Joueur.setActionCommand("1 Joueur");
		panel_1.add(rdbtn1Joueur);
		
		rdbtn2Joueur = new JRadioButton("2 Joueur");
		rdbtn2Joueur.setActionCommand("2Joueur");
		rdbtn2Joueur.setEnabled(false);
		panel_1.add(rdbtn2Joueur);
		
		//BtnGroup du mode de jeu
		bg0.add(rdbtnDemo);
		bg0.add(rdbtn1Joueur);
		bg0.add(rdbtn2Joueur);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JLabel lblTailleDeLa = new JLabel("Taille de la carte :");
		panel_3.add(lblTailleDeLa);
		
		rdbtn10 = new JRadioButton("10*10");
		rdbtn10.setSelected(true);
		rdbtn10.setActionCommand("10");
		panel_3.add(rdbtn10);
		
	    rdbtn12 = new JRadioButton("12*12");
	    rdbtn12.setActionCommand("12");
		panel_3.add(rdbtn12);
		
	    rdbtn15 = new JRadioButton("15*15");
	    rdbtn15.setActionCommand("15");
		panel_3.add(rdbtn15);
		
		//bg1 de la taille de la map
		bg1.add(rdbtn10);
		bg1.add(rdbtn12);
		bg1.add(rdbtn15);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JLabel lblDifficultDeLia = new JLabel("Difficult\u00E9 de l'IA :");
		panel_4.add(lblDifficultDeLia);
		
		rdbtnFacile = new JRadioButton("Facile");
		rdbtnFacile.setSelected(true);
		rdbtnFacile.setActionCommand("Facile");
		panel_4.add(rdbtnFacile);
		
	    rdbtnMedium = new JRadioButton("Interm\u00E9diaire");
	    rdbtnMedium.setActionCommand("Medium");
		panel_4.add(rdbtnMedium);
		
		rdbtnDifficile = new JRadioButton("Difficile");
		rdbtnDifficile.setActionCommand("Difficile");
		panel_4.add(rdbtnDifficile);
		
		//bg2 difficulté de la partie
		bg2.add(rdbtnFacile);
		bg2.add(rdbtnMedium);
		bg2.add(rdbtnDifficile);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		
		JLabel lblNombreDeBateau = new JLabel("Nombre de bateau :");
		panel_5.add(lblNombreDeBateau);
		
		JLabel lblPorteAvion = new JLabel("Porte avion");
		panel_5.add(lblPorteAvion);
		
	    spinnerPorteAvion = new JSpinner();
		spinnerPorteAvion.setModel(new SpinnerNumberModel(1, 0, 5, 1));
		panel_5.add(spinnerPorteAvion);
		
		JLabel lblNewLabel_1 = new JLabel("Sous-Marin");
		panel_5.add(lblNewLabel_1);
		
	    spinnerSousMarin = new JSpinner();
		spinnerSousMarin.setModel(new SpinnerNumberModel(1, 0, 5, 1));
		panel_5.add(spinnerSousMarin);
		
		JLabel lblNewLabel_2 = new JLabel("Cuirass\u00E9s furtif");
		panel_5.add(lblNewLabel_2);
		
		spinnerCuirassésFurtif = new JSpinner();
		spinnerCuirassésFurtif.setModel(new SpinnerNumberModel(2, 0, 5, 1));
		panel_5.add(spinnerCuirassésFurtif);
		
		JLabel lblNewLabel_3 = new JLabel("Zodiac");
		panel_5.add(lblNewLabel_3);
		
		spinnerZodiac = new JSpinner();
		spinnerZodiac.setModel(new SpinnerNumberModel(1, 0, 5, 1));
		panel_5.add(spinnerZodiac);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(controller);
		panel_6.add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(controller);
		panel_6.add(btnAnnuler);
		//test
	}

}
