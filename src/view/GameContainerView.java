package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;

public class GameContainerView extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameContainerView() {
		this.setPreferredSize(new Dimension(1024, 720));
		setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel grid1 = new GridView(8, true);
		JPanel grid2 = new GridView(8, true);
		JPanel info = new InfoView();
		JButton placeholder = new JButton("Vue manquante");

		add(grid1);
		add(grid2);
		add(info);
		add(placeholder);
	}

}
