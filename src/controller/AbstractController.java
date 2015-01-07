package controller;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.Game;

public abstract class AbstractController implements ActionListener {

	protected Game game; // objet contenant la partie
	protected JPanel view; // vue associée au controller

	/**
	 * Retourne la vue associée
	 * @return Vue associée au controller
	 */
	public JPanel getView()
	{
		return view;
	}

	/**
	 * Retourne l'objet contenant la partie (ou null)
	 * @return La partie (ou null)
	 */
	public Game getGame()
	{
		return game;
	}

}
