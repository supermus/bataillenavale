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
		this.controller = new MenuController(this);
		this.view = controller.getView();
		this.window = new JFrame();
		this.window.add(view);
		this.window.pack();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setVisible(true);
		
	}
	
	public void changeScreen(Controller c)
	{
		System.out.println("Nouveau controller : " + c.toString());
		this.window.getContentPane().removeAll();
		this.controller = c;
		this.view = c.getView();
		this.window.add(view);
		this.window.setVisible(true);
		this.window.pack();
	}

}
