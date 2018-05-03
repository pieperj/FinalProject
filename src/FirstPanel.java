import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class FirstPanel extends JPanel {
	
	private int score = 0;
	private int highScore = 1;
	
	private int ulx = 100, uly = 100;
	private final int SIDE_LENGTH = 20, UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
	private int currentDirection = 1;
	
	private int tempdx = 20;
	private int tempdy = 80;
	private int[] possiblex = new int[19];
	private int[] possibley = new int[16];
	
	private int pelletCoordx, pelletCoordy;
	
	/**
	 * Create the panel.
	 */
	
	public FirstPanel() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		for(int i = 0; i < possiblex.length; i++) {
			possiblex[i] = tempdx;
			tempdx += 20;
		}
		
		for(int i = 0; i < possibley.length; i++) {
			possibley[i] = tempdy;
			tempdy += 20;
		}
		
		System.out.println(Arrays.toString(possiblex));
		System.out.println(Arrays.toString(possibley));
		
		JLabel scoreLabel = new JLabel("Score: " + String.format("%d", score));
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setBounds(6, 21, 138, 37);
		scoreLabel.setFont(new Font("Futura", Font.PLAIN, 20));
		
		add(scoreLabel);
		
		JLabel Lblsnake = new JLabel("SNAKE");
		Lblsnake.setBounds(143, 5, 137, 54);
		Lblsnake.setForeground(Color.WHITE);
		Lblsnake.setFont(new Font("Futura", Font.PLAIN, 40));
		add(Lblsnake);
	
		JLabel lblHighScore = new JLabel("High Score: " + String.format("%d", highScore));

		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setBounds(292, 8, 138, 63);
		lblHighScore.setFont(new Font("Futura", Font.PLAIN, 20));
		add(lblHighScore);
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblGameOver.setForeground(Color.RED);
		lblGameOver.setBounds(106, 134, 243, 54);
		
		
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "moveUp");
		getActionMap().put("moveUp", new MoveAction(UP));
		
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");
		getActionMap().put("moveDown", new MoveAction(DOWN));

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
		getActionMap().put("moveLeft", new MoveAction(LEFT));
		
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
		getActionMap().put("moveRight", new MoveAction(RIGHT));
		
		pelletCoordx = possiblex[(int)(Math.random()*possiblex.length)];
		pelletCoordy = possibley[(int)(Math.random()*possibley.length)];
		
		
		Timer timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dx, dy;
				
				if(ulx <= 410 && ulx >= 10 && uly >= 70 && uly <= 390) {
	
					switch(currentDirection) {
					case UP:
						dx = 0;
						dy = -20;
						break;
						
					case DOWN:
						dx = 0;
						dy = 20;
						break;
						
					case LEFT:
						dx = -20;
						dy = 0;
						break;
						
					case RIGHT:
						dx = 20;
						dy = 0;
						break;
						
					default:
						dx = 0;
						dy = 0;
				}
				if(ulx == pelletCoordx && uly == pelletCoordy) {
					score+=100;
					scoreLabel.setText("Score: " + String.format("%d", score));
					pelletCoordx = possiblex[(int)(Math.random()*possiblex.length)];
					pelletCoordy = possibley[(int)(Math.random()*possibley.length)];
					repaint();
				}
					
					
				ulx += dx;
				uly += dy;
				repaint();
				}
				
				else {
					add(lblGameOver);
					if(score > highScore) {
						highScore = score;
						lblHighScore.setText("High Score: " + String.format("%02d", highScore));

					}
				}
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
		
		//sets white borders
		g.setColor(Color.WHITE);
		g.drawLine(0, 60, 450, 60);
		g.drawLine(439, 60, 439, 430);
		g.drawLine(0, 60, 0, 430);
		g.drawLine(0, 422, 450, 422);
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
