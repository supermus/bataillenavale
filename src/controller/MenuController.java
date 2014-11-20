package controller;

import java.awt.event.ActionEvent;

import core.BatailleNavale;
import view.MenuView;

public class MenuController extends Controller {
	
	private BatailleNavale batailleNavale;
	
	public MenuController(BatailleNavale bn)
	{
		batailleNavale = bn;
		view = new MenuView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ((MenuView)view).btnPlay){
			System.out.println("Appel de PLAY");
			batailleNavale.changeScreen(new GameConfigController(batailleNavale));
			
		}
		else if (e.getSource() == ((MenuView)view).btnQuit){
			System.exit(0); 
		}
		else if (e.getSource() == ((MenuView)view).btnCredits){
			System.out.println("Appel de About");
			batailleNavale.changeScreen(new AboutController(batailleNavale));
		}
		
	}


}
