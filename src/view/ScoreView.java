package view;

import controller.AbstractController;
import controller.ScoreViewController;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class ScoreView extends AbstractView{
	
	private JLabel lblNamePlayerVic;
	private JLabel lblTime;
	private JLabel lblNomDuJoueur1;
	private JLabel lblboatDestroyed1;
	private JLabel lblShootSucces1;
	private JLabel lblShootMiss1 ;
	private JLabel lblNomDuJoueur2;
	private JLabel lblboatDestroyed2;
	private JLabel lblShootSucces2 ;
	private JLabel lblShootMiss2 ;
	private JButton btnValidate;

	public ScoreView(ScoreViewController c) {
		super(c);
		setLayout(new GridLayout(5, 3, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Victoire du Joueur : ");
		panel.add(lblNewLabel);
		
		lblNamePlayerVic = new JLabel("Nom du Joueur");
		panel.add(lblNamePlayerVic);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblTempsDeLa = new JLabel("Temps de la partie : ");
		panel_1.add(lblTempsDeLa);
		
		lblTime = new JLabel("Temps");
		panel_1.add(lblTime);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		lblNomDuJoueur1 = new JLabel("Nom du joueur :");
		panel_2.add(lblNomDuJoueur1);
		
		JLabel lblNewLabel2 = new JLabel("Bateau coul\u00E9 : ");
		panel_2.add(lblNewLabel2);
		
		lblboatDestroyed1 = new JLabel("nbBat");
		panel_2.add(lblboatDestroyed1);
		
		JLabel lblNewLabel_4 = new JLabel("Tir r\u00E9ussi :");
		panel_2.add(lblNewLabel_4);
		
		lblShootSucces1 = new JLabel("nbTirRes");
		panel_2.add(lblShootSucces1);
		
		JLabel lblNewLabel_7 = new JLabel("Tir rat\u00E9 :");
		panel_2.add(lblNewLabel_7);
		
		lblShootMiss1 = new JLabel("nbRirRat");
		panel_2.add(lblShootMiss1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel_2.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		lblNomDuJoueur2 = new JLabel("Nom du joueur :");
		panel_3.add(lblNomDuJoueur2);
		
		JLabel label_1 = new JLabel("Bateau coul\u00E9 : ");
		panel_3.add(label_1);
		
		lblboatDestroyed2 = new JLabel("nbBat");
		panel_3.add(lblboatDestroyed2);
		
		JLabel label_3 = new JLabel("Tir r\u00E9ussi :");
		panel_3.add(label_3);
		
		lblShootSucces2 = new JLabel("nbTirRes");
		panel_3.add(lblShootSucces2);
		
		JLabel label_5 = new JLabel("Tir rat\u00E9 :");
		panel_3.add(label_5);
		
		lblShootMiss2 = new JLabel("nbRirRat");
		panel_3.add(lblShootMiss2);
		
		JLabel label_7 = new JLabel("");
		panel_3.add(label_7);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		btnValidate = new JButton("Valider");
		panel_4.add(btnValidate);
		// TODO Auto-generated constructor stub
	}

}
