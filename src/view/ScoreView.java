package view;

import controller.AbstractController;
import controller.ScoreViewController;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import model.Game;

public class ScoreView extends AbstractView implements Observer {
	
	private static Game game;
	
	
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
	public JButton btnValidate;

	public ScoreView(ScoreViewController c) {
		super(c);
		setLayout(new GridLayout(5, 3, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Victoire du Joueur : ");
		panel.add(lblNewLabel);
		
		lblNamePlayerVic = new JLabel(c.getGame().winner().getNom());
		panel.add(lblNamePlayerVic);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblTempsDeLa = new JLabel("Temps de la partie : ");
		panel_1.add(lblTempsDeLa);
		
		lblTime = new JLabel("Temps");
		panel_1.add(lblTime);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		lblNomDuJoueur1 = new JLabel("Nom du joueur :"+c.getGame().getPlayer().get(0).getNom()+"  ");
		panel_2.add(lblNomDuJoueur1);
		
		JLabel lblNewLabel2 = new JLabel("Bateau coul\u00E9 : ");
		panel_2.add(lblNewLabel2);
		
		lblboatDestroyed1 = new JLabel(""+c.getGame().getPlayer().get(0).nbrboathits(c.getGame().getPlayer().get(1)));
		panel_2.add(lblboatDestroyed1);
		
		JLabel lblNewLabel_4 = new JLabel("Tir r\u00E9ussi :");
		panel_2.add(lblNewLabel_4);
		
		lblShootSucces1 = new JLabel(""+c.getGame().getPlayer().get(0).getHits());
		panel_2.add(lblShootSucces1);
		
		JLabel lblNewLabel_7 = new JLabel("Tir rat\u00E9 :");
		panel_2.add(lblNewLabel_7);
		
		lblShootMiss1 = new JLabel(""+c.getGame().getPlayer().get(0).getMiss());
		panel_2.add(lblShootMiss1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel_2.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		lblNomDuJoueur2 = new JLabel("Nom du joueur :" + c.getGame().getPlayer().get(1).getNom());
		panel_3.add(lblNomDuJoueur2);
		
		JLabel label_1 = new JLabel("Bateau coul\u00E9 : ");
		panel_3.add(label_1);
		
		lblboatDestroyed2 = new JLabel(""+c.getGame().getPlayer().get(1).nbrboathits(c.getGame().getPlayer().get(0)));
		panel_3.add(lblboatDestroyed2);
		
		JLabel label_3 = new JLabel("Tir r\u00E9ussi :");
		panel_3.add(label_3);
		
		lblShootSucces2 = new JLabel(""+c.getGame().getPlayer().get(1).getHits());
		panel_3.add(lblShootSucces2);
		
		JLabel label_5 = new JLabel("Tir rat\u00E9 :");
		panel_3.add(label_5);
		
		lblShootMiss2 = new JLabel(""+c.getGame().getPlayer().get(1).getMiss());
		panel_3.add(lblShootMiss2);
		
		JLabel label_7 = new JLabel("");
		panel_3.add(label_7);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		btnValidate = new JButton("Valider");
		btnValidate.addActionListener(controller);
		panel_4.add(btnValidate);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		
		
	}
		
	public void setModel(Game g)
	{
		this.game = g;
		this.game.addObserver(this);
		this.update(null, null); 
	}
		
}


