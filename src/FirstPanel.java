import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class FirstPanel extends JPanel {
	
	private int score = 0;
	/**
	 * Create the panel.
	 */
	public FirstPanel() {
		setLayout(null);
		
		JLabel scoreLabel = new JLabel("Score: " + score);
		scoreLabel.setBounds(6, 6, 95, 34);
		add(scoreLabel);

	}
}
