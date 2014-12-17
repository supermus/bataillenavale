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
	private int mapSize;

	/**
	 * Create the panel.
	 */
	public GridView() {
		super(new GameController(null));
		isHuman = false;
		mapSize = 2;
		setLayout(new GridLayout(2, 2, 1, 1));

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
		this.mapSize = mapSize;
		setLayout(new GridLayout(mapSize, mapSize, 1, 1));
		cells = new JLabel[mapSize][mapSize];
		for(int i = 0; i<mapSize; i++) {
			for(int j = 0; j<mapSize; j++)
			{
				Image newimg = new ImageIcon("assets/water.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH);


				JLabel btn = new JLabel( new ImageIcon(newimg) );

				/*ImageIcon water = new ImageIcon("assets/v_5_5.png");
				btn.setIcon(water);
				btn.setPreferredSize(new Dimension(50,50));*/
				cells[i][j] = btn;
				btn.addMouseListener(this);
				add(btn);
			}
		}

		Image newimg = new ImageIcon("assets/hit.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH);
		cells[0][0].setIcon(new ImageIcon(newimg));

		Image newimg2 = new ImageIcon("assets/boat1.png").getImage().getScaledInstance(400/mapSize, 400/mapSize,  java.awt.Image.SCALE_SMOOTH);
		cells[0][1].setIcon(new ImageIcon(newimg2));
	}

	@Override
	public void update(Observable arg0, Object arg1) {


	}

	public boolean isHuman()
	{
		return isHuman;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!isHuman) {
			// TODO Auto-generated method stub
			JLabel l = (JLabel) arg0.getSource();
			System.out.println(l.getLocation().getX()/(mapSize*4) + ";" + l.getLocation().getY()/(mapSize*4));

		}

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
