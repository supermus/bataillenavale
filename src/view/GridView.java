package view;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class GridView extends JPanel {
	
	private ArrayList<JButton> cells;

	/**
	 * Create the panel.
	 */
	public GridView() {
		setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnNewButton_1 = new JButton();
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton();
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton();
		add(btnNewButton_3);
		
		JButton btnNewButton = new JButton();
		add(btnNewButton);
		
	}
	
	public GridView(int mapSize, boolean showShips) {
		setLayout(new GridLayout(mapSize, mapSize, 0, 0));
		cells = new ArrayList<JButton>();
		for(int i = 0; i<mapSize; i++)
			for(int j = 0; j<mapSize; j++)
				cells.add(new JButton((i+1)+";"+(j+1)));
		
		Iterator<JButton> it = cells.iterator();
		while(it.hasNext())
		{
			JButton btn = it.next();
			btn.setPreferredSize(new Dimension(50,50));
			add(btn);
		}
	}

}
