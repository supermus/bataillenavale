package controller;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class Controller implements ActionListener {

	protected JPanel view;
	
	public JPanel getView()
	{
		return view;
	}

}
