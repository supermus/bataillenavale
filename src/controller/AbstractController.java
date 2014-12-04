package controller;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class AbstractController implements ActionListener {

	protected JPanel view;
	
	public JPanel getView()
	{
		return view;
	}

}
