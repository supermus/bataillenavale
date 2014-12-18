package controller;

import java.awt.event.ActionEvent;

import model.Game;
import model.Orientation;
import model.ship.AircraftCarrier;
import model.ship.Ironclad;
import model.ship.Submarine;
import model.ship.Zodiac;
import view.GameConfigView;
import view.GameContainerView;

public class GameController extends AbstractController {
	
	Game game;
	
	public GameController(Game g)
	{
		this.game = g;
		this.view = new GameContainerView(this, g);
		GameContainerView containerView = (GameContainerView) view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		
	}
	

}
