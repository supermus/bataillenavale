package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.JButton;

import controller.AbstractController;

import java.awt.GridLayout;

public class MenuView extends AbstractView {

	private AbstractController controller;
	public JButton btnPlay;
	public JButton btnQuit;
	public JButton btnCredits;
	
	public MenuView(AbstractController controller) {
		this.controller = controller;
		setLayout(new GridLayout(0, 1, 0, 0));
		
		btnPlay = new JButton("Play");
		btnPlay.addActionListener(controller);
		add(btnPlay);
		
		btnQuit = new JButton("Quit");
		btnQuit.addActionListener(controller);
		add(btnQuit);
		
	    btnCredits = new JButton("Credits");
	    btnCredits.addActionListener(controller);
		add(btnCredits);

	}

}
