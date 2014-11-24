package controller;

import java.awt.event.ActionEvent;

import model.Human;
import model.Player;
import core.BatailleNavale;
import view.GameConfigView;

public class GameConfigController extends Controller{

	private BatailleNavale batailleNavale;
	private Player player;
	private String speudo;
	private String ModeJeux;
	private String TailleMap;
	private String Difficulter;
	private String TypeBataille;
	
	
	public GameConfigController(BatailleNavale bn){
		  
			batailleNavale = bn;
			view = new GameConfigView(this);
		}
	

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == ((GameConfigView)view).btnValider){
				System.out.println("Début d'une partie");
				speudo =((GameConfigView)view).txtUsername.getText();
				System.out.println(speudo);
				player = new Human(speudo);
				
				// Nombre de joeur de la partie
				ModeJeux=((GameConfigView)view).bg0.getSelection().getActionCommand();
				System.out.println(ModeJeux);
				
				//Taille de la map
				TailleMap=((GameConfigView)view).bg1.getSelection().getActionCommand();
				System.out.println(TailleMap);
				
				//Dificulter de la partie
				Difficulter=((GameConfigView)view).bg2.getSelection().getActionCommand();
				System.out.println(Difficulter);
				
				//Dificulter de la partie
				Difficulter=((GameConfigView)view).bg3.getSelection().getActionCommand();
				System.out.println(Difficulter);
				
				}
			else if (e.getSource() == ((GameConfigView)view).btnAnnuler){
				System.out.println("Retour au MENU");
				batailleNavale.changeScreen(new MenuController(batailleNavale));
			}
			System.out.println("Aucun passage dans les event");
			
		}

}
