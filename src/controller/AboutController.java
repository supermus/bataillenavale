package controller;

import java.awt.event.ActionEvent;

import view.AboutView;
import core.BatailleNavale;

public class AboutController extends AbstractController {

	/**
	 * Constructeur par défaut de AboutController
	 * Il associe la vue AboutView
	 */
	public AboutController()
	{
		view = new AboutView(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MenuController menu = new MenuController();
		BatailleNavale.changeScreen(menu);

	}

}
