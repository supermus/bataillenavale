package core;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.MenuView;
import controller.AbstractController;
import controller.MenuController;

public class BatailleNavale{
	
	private static JFrame window;
	private static AbstractController controller;
	
	public BatailleNavale()
	{
		System.out.println("Creation de batailleNavale");
	}
	
	public static void init()
	{
		System.out.println("Initialisation...");
		controller = new MenuController();
		window = new JFrame();
		window.add(controller.getView());
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	public static void changeScreen(AbstractController c)
	{
		System.out.println("Nouveau controller : " + c.toString());
		window.getContentPane().removeAll();
		controller = c;
		window.add(c.getView());
		window.setVisible(true);
		window.pack();
	}

}
