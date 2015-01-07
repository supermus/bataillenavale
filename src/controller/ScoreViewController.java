package controller;

import java.awt.event.ActionEvent;

import model.Game;
import view.ScoreView;
import core.BatailleNavale;


public class ScoreViewController extends AbstractController {

	private static Game game;

	/**
	 * Constructeur par défaut de ScoreViewController
	 * Il associe la vue ScoreView
	 */
	public ScoreViewController(Game g)
	{
		this.game = g;
		this.view = new ScoreView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ScoreView scoreView = (ScoreView) view;

		if(e.getSource() == (scoreView.btnValidate))
		{
			BatailleNavale.changeScreen(new MenuController());

		}

	}

}
