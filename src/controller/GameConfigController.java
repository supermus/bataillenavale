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
				player = new Human(speudo);
				
			//Méthode pour les JRadioButton du mode de jeux
			if(((GameConfigView)view).rdbtnDemo.isSelected()){
				
			}
			else if(((GameConfigView)view).rdbtn1Joueur.isSelected()){
				
			}
			else if(((GameConfigView)view).rdbtn2Joueur.isSelected()){
				
			}
			
			
			
				
				
			}
			else if (e.getSource() == ((GameConfigView)view).btnAnnuler){
				System.out.println("Retour au MENU");
				batailleNavale.changeScreen(new MenuController(batailleNavale));
			}
			System.out.println("Aucun passage dans les event");
			
		}

}
