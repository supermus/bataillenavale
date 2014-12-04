package controller;

import java.awt.event.ActionEvent;

import view.GameConfigView;
import view.GameContainerView;
import core.BatailleNavale;

public class GameController extends AbstractController {
	
	private BatailleNavale batailleNavale;
	
	public GameController(BatailleNavale bn){
		  
		batailleNavale = bn;
		view = new GameContainerView(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
