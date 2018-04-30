import java.awt.Color;
import java.awt.Font;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.JLabel;



public class FirstPanel extends JPanel {
	
	private int score = 0;
	private int highScore = 0;
	
	private int ulx = 10, uly = 10;
	private final int SIDE_LENGTH = 25, UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
	private int currentDirection = 1;
	
	private int pelletCoordx, pelletCoordy = 50;
	
	/**
	 * Create the panel.
	 */

	public FirstPanel() {
		setBackground(Color.BLACK);
		setLayout(null);

		JLabel scoreLabel = new JLabel("Score: " + String.format("%02d", score));
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setBounds(6, 21, 138, 37);
		scoreLabel.setFont(new Font("Futura", Font.PLAIN, 20));
		add(scoreLabel);
		
		JLabel Lblsnake = new JLabel("SNAKE");
		Lblsnake.setBounds(156, 5, 137, 54);
		Lblsnake.setForeground(Color.WHITE);
		Lblsnake.setFont(new Font("Futura", Font.PLAIN, 40));
		add(Lblsnake);
	
		JLabel lblHighScore = new JLabel("High Score: " + String.format("%02d", highScore));

		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setBounds(359, 0, 48, 32);
		lblHighScore.setFont(new Font("Futura", Font.PLAIN, 20));
		add(lblHighScore);
		
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "moveUp");
		getActionMap().put("moveUp", new MoveAction(UP));
		
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");
		getActionMap().put("moveDown", new MoveAction(DOWN));

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
		getActionMap().put("moveLeft", new MoveAction(LEFT));
		
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
		getActionMap().put("moveRight", new MoveAction(RIGHT));
		
		Timer timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dx, dy;
				switch(currentDirection) {
					case UP:
						dx = 0;
						dy = -10;
						break;
						
					case DOWN:
						dx = 0;
						dy = 10;
						break;
						
					case LEFT:
						dx = -10;
						dy = 0;
						break;
						
					case RIGHT:
						dx = 10;
						dy = 0;
						break;
						
					default:
						dx = 0;
						dy = 0;
				}
				ulx += dx;
				uly += dy;
				repaint();
				
			}
			
		});
		timer.start();
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillRect(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
		g.setColor(Color.RED);
		g.fillRect(pelletCoordx, pelletCoordy, SIDE_LENGTH, SIDE_LENGTH);
		
	}
	
	private class MoveAction extends AbstractAction {
		private int direction;
		
		public MoveAction(int direction) {
			this.direction = direction;
		}
		
		public void actionPerformed(ActionEvent e) {
			currentDirection = direction;
			repaint();
			
		}
		

	}
}
