package controller;

import java.awt.event.ActionEvent;

import core.BatailleNavale;
import model.Game;
import view.GameContainerView;
import view.MenuView;
import view.ScoreView;


public class ScoreViewController extends AbstractController {
	
	 private static Game game;
	 
	 	public static Game getGame() {
		return game;
	}

	public ScoreViewController(Game g)
	{
		this.game = g;
		this.view = new ScoreView(this);
	}
	
	

	public void actionPerformed(ActionEvent e) {
		
		ScoreView scoreView = (ScoreView) view;
		
		if(e.getSource() == (scoreView.btnValidate))
		{
			BatailleNavale.changeScreen(new MenuController());
			
		}
		
	}

}
