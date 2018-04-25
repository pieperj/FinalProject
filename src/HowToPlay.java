import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;

public class HowToPlay extends JPanel {

	/**
	 * Create the panel.
	 */
	public HowToPlay() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel howToPlayLabel = new JLabel("HOW TO PLAY");
		howToPlayLabel.setForeground(Color.WHITE);
		howToPlayLabel.setBounds(81, 6, 280, 40);
		howToPlayLabel.setFont(new Font("Futura", Font.PLAIN, 40));
		add(howToPlayLabel);
		
		JTextPane txtpnUseThe = new JTextPane();
		txtpnUseThe.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnUseThe.setForeground(Color.GREEN);
		txtpnUseThe.setBackground(Color.BLACK);
		txtpnUseThe.setText("• Use the arrow keys to move the snake up, down, left, and right.");
		txtpnUseThe.setBounds(64, 58, 324, 40);
		add(txtpnUseThe);
		
		JTextPane txtpnCollectThe = new JTextPane();
		txtpnCollectThe.setText("• Collect the pellet to earn points and make your snake grow.");
		txtpnCollectThe.setForeground(Color.GREEN);
		txtpnCollectThe.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnCollectThe.setBackground(Color.BLACK);
		txtpnCollectThe.setBounds(64, 110, 324, 40);
		add(txtpnCollectThe);
		
		JTextPane txtpnBeCareful = new JTextPane();
		txtpnBeCareful.setText("• Be careful! Don't run into your own body or the wall or you lose!");
		txtpnBeCareful.setForeground(Color.GREEN);
		txtpnBeCareful.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnBeCareful.setBackground(Color.BLACK);
		txtpnBeCareful.setBounds(64, 162, 324, 40);
		add(txtpnBeCareful);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(6, 265, 117, 29);
		add(btnHome);
		
		
		
	}
}
