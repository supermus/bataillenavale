package core;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.MenuView;
import controller.AbstractController;
import controller.MenuController;

public class BatailleNavale{
	
	private static JFrame window;
	private static AbstractController controller;
	
	public static void main(String[] args)
	{
		// initialisation de la fenêtre
		System.out.println("Initialisation...");
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		// chargement du menu
		controller = new MenuController();
		window.add(controller.getView());
		window.pack();
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
