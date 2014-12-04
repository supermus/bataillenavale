package controller;

import java.awt.event.ActionEvent;

import view.AboutView;
import core.BatailleNavale;

public class AboutController extends AbstractController {
	private BatailleNavale batailleNavale;
	
	public AboutController(BatailleNavale bn)
	{
		batailleNavale = bn;
		view = new AboutView(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MenuController menu = new MenuController(batailleNavale);
		batailleNavale.changeScreen(menu);
		
	}

}
