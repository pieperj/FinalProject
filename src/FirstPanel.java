import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;



public class FirstPanel extends JPanel {
	
	private int score = 0;
	public int highScore = 0;
	
	private int ulx = 100, uly = 100;
	private final int SIDE_LENGTH = 20, UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
	private int currentDirection = 1;
	
	private int tempdx = 20;
	private int tempdy = 80;
	
	private int tempCoordx, tempCoordy;
	private int[] possiblex = new int[19];
	private int[] possibley = new int[16];
	
	private int pelletCoordx, pelletCoordy;
	private PanelChangeListener listener;
	
	private boolean scoreAdded = false;
	/**
	 * Create the panel.
	 */
	Snake snake = new Snake(SIDE_LENGTH, ulx, uly);
	//Body b1 = new Body(SIDE_LENGTH, u)
	
	public FirstPanel(PanelChangeListener l) {
		setBackground(Color.BLACK);
		setLayout(null);
		this.listener = l;
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
		scoreLabel.setBounds(6, 18, 100, 42);
		scoreLabel.setFont(new Font("Futura", Font.PLAIN, 20));
		
		add(scoreLabel);
		
		JLabel Lblsnake = new JLabel("SNAKE");
		Lblsnake.setBounds(143, 5, 137, 54);
		Lblsnake.setForeground(Color.WHITE);
		Lblsnake.setFont(new Font("Futura", Font.PLAIN, 40));
		add(Lblsnake);
	
		JLabel lblHighScore = new JLabel("Score: 0");

		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setBounds(344, 18, 100, 42);
		lblHighScore.setFont(new Font("Futura", Font.PLAIN, 20));
		add(lblHighScore);
		
		JLabel lblHigh = new JLabel("High");
		lblHigh.setFont(new Font("Futura", Font.PLAIN, 20));
		lblHigh.setForeground(Color.WHITE);
		lblHigh.setBounds(353, 0, 43, 33);
		add(lblHigh);
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(155, 250, 137, 42);
		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("HomePanel");
				
			}
			
		});
		
		JButton btnRetry = new JButton("Retry");
		//btnRetry.setIcon(new ImageIcon("/Users/risherd/Desktop/Black_Screen.png"));
		
		btnRetry.setBackground(Color.WHITE);
		btnRetry.setForeground(Color.BLACK);
		btnRetry.setBounds(155, 194, 137, 42);
		btnRetry.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("FirstPanel");
			}
			
		});
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblGameOver.setBackground(Color.BLACK);
		lblGameOver.setForeground(Color.RED);
		lblGameOver.setBounds(100, 128, 243, 54);
		
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
					score++;
					
					//Body b1 = new Body(20, )
					scoreAdded = true;
					scoreLabel.setText("Score: " + String.format("%d", score));
					pelletCoordx = possiblex[(int)(Math.random()*possiblex.length)];
					pelletCoordy = possibley[(int)(Math.random()*possibley.length)];
					repaint();
				}
				else {
					scoreAdded = false;
				}
					
				ulx += dx;
				uly += dy;
				repaint();
				}
				
				
				else {
					add(lblGameOver);
					add(btnRetry);
					add(homeButton);
					if(score > highScore) {
						highScore = score;
						lblHighScore.setText("Score: " + String.format("%02d", highScore));

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
		g.fillRect(ulx, uly, snake.getSideLength(), snake.getSideLength());
		
		g.setColor(Color.RED);
		g.fillRect(pelletCoordx, pelletCoordy, SIDE_LENGTH, SIDE_LENGTH);
		
		//if(scoreAdded) {
			g.setColor(Color.GREEN);
			g.fillRect(ulx-20, uly, SIDE_LENGTH, SIDE_LENGTH);
		//}
		
		//sets white borders
		g.setColor(Color.WHITE);
		g.drawLine(0, 60, 450, 60);
		g.drawLine(439, 60, 439, 430);
		g.drawLine(0, 60, 0, 430);
		g.drawLine(0, 422, 450, 422);
	}
	/*
	@Override
	
	public void addLength(Graphics h) {
		super.paintComponent(h);
		h.setColor(Color.GREEN);
		h.fillRect(ulx-26, uly-26, SIDE_LENGTH, SIDE_LENGTH);
	}
	*/
	
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
