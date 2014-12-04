package view;

import javax.swing.JPanel;

import controller.AbstractController;

public class AbstractView extends JPanel {

	protected AbstractController controller;
	
	public void setController(AbstractController c)
	{
		this.controller = c;
	}
}
