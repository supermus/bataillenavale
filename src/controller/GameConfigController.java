package controller;

import java.awt.event.ActionEvent;

import core.BatailleNavale;
import view.GameConfigView;

public class GameConfigController extends Controller{

	private BatailleNavale batailleNavale;
	
	
	public GameConfigController(){
		  
		    
			view = new GameConfigView();
		}
	

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == ((GameConfigView)view).btnValider){
				
				
			}
			else if (e.getSource() == ((GameConfigView)view).btnAnnuler){
				System.out.println("Retour au MENU");
				batailleNavale.changeScreen(new MenuController(batailleNavale));
			}
			
		}

}
