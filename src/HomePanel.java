import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class HomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public HomePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblSnake = new JLabel("Snake");
		add(lblSnake, BorderLayout.NORTH);
		
		
		
	}

}
