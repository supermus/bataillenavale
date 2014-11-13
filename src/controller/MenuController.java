package controller;

import java.awt.event.ActionEvent;

import core.BatailleNavale;
import view.GameConfigView;
import view.MenuView;

public class MenuController extends Controller {
	
	private MenuView menuView;
	private BatailleNavale batailleNavale;
	

	
	
	public MenuController()
	{
		menuView = new MenuView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == menuView.btnPlay){
			batailleNavale.changeScreen(new GameConfigController(), new GameConfigView());
			
		}
		else if (e.getSource() == menuView.btnQuit){
			
		}
		else if (e.getSource() == menuView.btnCredits){
			
		}
		
	}


}
