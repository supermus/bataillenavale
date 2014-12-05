package controller;

import java.awt.event.ActionEvent;

import model.Game;
import view.GameContainerView;
import view.MenuView;
import view.ScoreView;


public class ScoreViewController extends AbstractController {
	
	 Game game;

	public ScoreViewController(Game g)
	{
		this.game = g;
		this.view = new ScoreView(this);
	}
	
	

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
