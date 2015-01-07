package core;

import javax.swing.JFrame;

import controller.AbstractController;
import controller.MenuController;

public class BatailleNavale{

	private static JFrame window;
	private static AbstractController controller;

	public static void main(String[] args)
	{
		// initialisation de la fen�tre
		System.out.println("Initialisation...");
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		// chargement du menu
		changeScreen(new MenuController());
	}

	/**
	 * Permet de passer d'un �cran � un autre (ex: menu -> �cran de config de partie)
	 * @param c Le controller � utiliser
	 */
	public static void changeScreen(AbstractController c)
	{
		System.out.println("Nouveau controller : " + c.toString());
		window.getContentPane().removeAll();
		controller = c;
		window.add(c.getView());
		window.setVisible(true);
		window.setResizable(false);
		window.pack();
	}

}
