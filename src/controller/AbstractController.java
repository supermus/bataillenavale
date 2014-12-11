package controller;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.Game;

public abstract class AbstractController implements ActionListener {

	protected Game game;
	protected JPanel view;
	
	public JPanel getView()
	{
		return view;
	}

}
