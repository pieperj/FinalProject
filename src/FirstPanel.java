import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class FirstPanel extends JPanel {
	
	private int score = 0;
	private int highScore = 00;
	/**
	 * Create the panel.
	 */
	public FirstPanel() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel scoreLabel = new JLabel("Score: " + score);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setBounds(6, 15, 138, 37);
		scoreLabel.setFont(new Font("Futura", Font.PLAIN, 20));
		add(scoreLabel);
		
		JLabel Lblsnake = new JLabel("SNAKE");
		Lblsnake.setBounds(156, 5, 137, 54);
		Lblsnake.setForeground(Color.WHITE);
		Lblsnake.setFont(new Font("Futura", Font.PLAIN, 40));
		add(Lblsnake);
		
		JLabel lblHighScore = new JLabel("High Score: " + String.format("%02d", highScore));
		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setBounds(375, 15, 139, 37);
		lblHighScore.setFont(new Font("Futura", Font.PLAIN, 20));
		add(lblHighScore);
	}
}
