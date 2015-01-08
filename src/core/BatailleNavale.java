package core;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.AbstractController;
import controller.MenuController;

public class BatailleNavale{
	
	private static JFrame window;
	private static AbstractController controller;
	
	

	public static void main(String[] args)
	{
		// initialisation de la fenأھtre
		System.out.println("Initialisation...");
		window = new JFrame("Bataille Navale");
	    
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		// chargement du menu
		changeScreen(new MenuController());
	}
	


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
