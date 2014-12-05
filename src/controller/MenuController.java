package controller;

import java.awt.event.ActionEvent;

import model.Game;
import core.BatailleNavale;
import view.GameConfigView;
import view.MenuView;

public class MenuController extends AbstractController {
	
	public MenuController()
	{
		view = new MenuView(this);
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ((MenuView)view).btnPlay){
			System.out.println("Appel de PLAY");
			BatailleNavale.changeScreen(new GameConfigController());
			
		}
		else if (e.getSource() == ((MenuView)view).btnQuit){
			System.exit(0); 
		}
		else if (e.getSource() == ((MenuView)view).btnCredits){
			System.out.println("Appel de About");
			BatailleNavale.changeScreen(new AboutController());
		}
		
	}


}
