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
				
				((GameConfigView)view).bg0.getSelection().
				
				//If pour les JRadioButton du mode de jeux
				if(((GameConfigView)view).rdbtnDemo.isSelected()){
				
				}
				else if(((GameConfigView)view).rdbtn1Joueur.isSelected()){
				
				}
				else if(((GameConfigView)view).rdbtn2Joueur.isSelected()){
				
				}
				
				//If pour les JRadioButton de la taille de la map
				if(((GameConfigView)view).rdbtn10.isSelected()){
					
				}
				else if(((GameConfigView)view).rdbtn12.isSelected()){
					
				}
				else if(((GameConfigView)view).rdbtn15.isSelected()){
	
				}
				
				// If pour les JRadioButton type de bataille
				if(((GameConfigView)view).rdbtnAlerteRouge.isSelected()){
					
				}
				else if(((GameConfigView)view).rdbtnArtillerie.isSelected()){
					
				}
				else if(((GameConfigView)view).rdbtnBattleship.isSelected()){
	
				}
				
				//If pour les JRadioButton pour la difficultée
				if(((GameConfigView)view).rdbtnDifficile.isSelected()){
					
				}
				else if(((GameConfigView)view).rdbtnFacile.isSelected()){
					
				}
				else if(((GameConfigView)view).rdbtnMedium.isSelected()){
					
				}
			
			
		
				
				}
			else if (e.getSource() == ((GameConfigView)view).btnAnnuler){
				System.out.println("Retour au MENU");
				batailleNavale.changeScreen(new MenuController(batailleNavale));
			}
			System.out.println("Aucun passage dans les event");
			
		}

}
