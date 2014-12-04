package view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.GameController;

public class GridView extends AbstractView implements Observer, MouseListener {
	
	private JLabel[][] cells;
	private boolean isHuman;

	/**
	 * Create the panel.
	 */
	public GridView(GameController c) {
		super(c);
		isHuman = false;
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
	
	public GridView(GameController c, int mapSize, boolean showShips, boolean isHuman) {
		super(c);
		this.isHuman = isHuman;
		setLayout(new GridLayout(mapSize, mapSize, 0, 0));
		cells = new JLabel[mapSize][mapSize];
		for(int i = 0; i<mapSize; i++)
			for(int j = 0; j<mapSize; j++)
			{
				Image newimg = new ImageIcon("assets/v_5_5.png").getImage().getScaledInstance((int)(400/mapSize), (int)(400/mapSize),  java.awt.Image.SCALE_SMOOTH);  


				JLabel btn = new JLabel( new ImageIcon(newimg) );
				
				/*ImageIcon water = new ImageIcon("assets/v_5_5.png");
				btn.setIcon(water);
				btn.setPreferredSize(new Dimension(50,50));*/
				cells[i][j] = btn;
				btn.addMouseListener(this);
				add(btn);
			}
		
		Image newimg = new ImageIcon("assets/h_2_1.png").getImage().getScaledInstance((int)(400/mapSize), (int)(400/mapSize),  java.awt.Image.SCALE_SMOOTH);
		cells[0][0].setIcon(new ImageIcon(newimg));
		
		Image newimg2 = new ImageIcon("assets/h_2_2.png").getImage().getScaledInstance((int)(400/mapSize), (int)(400/mapSize),  java.awt.Image.SCALE_SMOOTH);
		cells[0][1].setIcon(new ImageIcon(newimg2));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isHuman()
	{
		return isHuman;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!isHuman)
			
		// TODO Auto-generated method stub
		System.out.println(arg0.getSource().toString());
		
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
