package core;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.MenuView;
import controller.Controller;
import controller.MenuController;

public class BatailleNavale{
	
	private JFrame window;
	private Controller controller;
	private JPanel view;
	
	public BatailleNavale()
	{
		System.out.println("Nouvelle instance de BatailleNavale");
	}
	
	public void init()
	{
		System.out.println("Initialisation...");
		this.controller = new MenuController();
		this.view = new MenuView();
	}
	
	public void changeScreen(Controller c, JPanel v)
	{
		this.controller = c;
		this.view = v;
	}

}
