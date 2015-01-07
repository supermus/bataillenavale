package controller;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.Game;

public abstract class AbstractController implements ActionListener {

	protected Game game; // objet contenant la partie
	protected JPanel view; // vue associ�e au controller

	/**
	 * Retourne la vue associ�e
	 * @return Vue associ�e au controller
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
