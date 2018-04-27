import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstPanel extends JPanel {
	
	private int score = 0;
	private int highScore = 00;
	
	
	
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
		
		JLabel lblHighScore = new JLabel("High");
		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setBounds(359, 0, 48, 32);
		lblHighScore.setFont(new Font("Futura", Font.PLAIN, 20));
		add(lblHighScore);
		
		JLabel lblHighScore2 = new JLabel("Score: " + String.format("%02d", highScore));
		lblHighScore2.setForeground(Color.WHITE);
		lblHighScore2.setBounds(353, 3, 138, 72);
		lblHighScore2.setFont(new Font("Futura", Font.PLAIN, 20));
		add(lblHighScore2);
	}
}
