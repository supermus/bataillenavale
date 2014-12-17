package controller;

import java.awt.event.ActionEvent;

import model.Game;
import view.GameContainerView;

public class GameController extends AbstractController {
	
	Game game;
	
	public GameController(Game g){
		this.game = g;
		this.view = new GameContainerView(this);
		((GameContainerView)this.view).setModel(this.game);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}
	

}
