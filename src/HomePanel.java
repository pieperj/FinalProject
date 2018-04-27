import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {

	private PanelChangeListener listener, listener2;
	
	
	/**
	 * Create the panel.
	 */
	
	public HomePanel(PanelChangeListener l) {
		setBackground(Color.BLACK);
		setLayout(null);
		this.listener = l;
		
		System.out.println("hello");
		
		
		JLabel snakeLabel = new JLabel("SNAKE");
		snakeLabel.setBounds(156, 5, 137, 54);
		snakeLabel.setForeground(Color.WHITE);
		snakeLabel.setFont(new Font("Futura", Font.PLAIN, 40));
		add(snakeLabel);
		
		JButton playButton = new JButton("PLAY");
		playButton.setBounds(166, 116, 117, 29);
		playButton.setFont(new Font("Futura", Font.PLAIN, 20));
		playButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("FirstPanel");
				
			}
			
		});
		add(playButton);
		
		JButton btnHowToPlay = new JButton("HOW TO PLAY");
		btnHowToPlay.setBounds(166, 157, 117, 29);
		add(btnHowToPlay);
		
		btnHowToPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				listener.changePanel("HowToPlay");
				
			}
			
		});
		
		
		
		
		
		
	}
}
