package controller;

import java.awt.event.ActionEvent;

import view.GameConfigView;
import core.BatailleNavale;

public class GameController extends  Controller {
	
	private BatailleNavale batailleNavale;
	
	public GameController(BatailleNavale bn){
		  
		batailleNavale = bn;
		view = new GameConfigView(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
