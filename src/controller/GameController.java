package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import model.Game;
import view.GameContainerView;

public class GameController extends AbstractController implements MouseListener {

	/**
	 * Constructeur par défaut de GameController
	 * Il associe la vue GameContainerView
	 */
	public GameController(Game g)
	{
		this.game = g;
		this.view = new GameContainerView(this, g);
		GameContainerView containerView = (GameContainerView) view;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		GameContainerView containerView = (GameContainerView) view;
		String boatType, orientation;
		int x, y;
		if(e.getSource()== containerView.btnValidate )
		{
			//Extraction des données
			boatType = containerView.comboBoxBoat.getName();
			orientation = containerView.comboBoxOrien.getName();
			x = (int) containerView.spinnerAxeX.getValue();
			y = (int) containerView.spinnerAxeY.getValue();
			//game.getPlayer().get(0).placeBoat(boatType, new Position(x,y), size, orientation);
		}

		if(e.getSource() == containerView.btnRemoveLastBoat){

		}

		if(e.getSource()== containerView.btnGameStart){

		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JLabel l = (JLabel) arg0.getSource();
		System.out.println((int)(l.getLocation().getX()/(400/game.getMapSize())) + ";" + (int)(l.getLocation().getY()/(400/game.getMapSize())));

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


}
