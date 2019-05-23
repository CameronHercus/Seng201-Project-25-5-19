import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class EndingScreen {
	private GameEnvironment gameLogic;
	private JFrame window;
	public static void main(String[] args) {

	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public EndingScreen(GameEnvironment incomingGameEnvironment) {
		gameLogic = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameLogic.closeEndingScreen(this);
	}
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton finishbttn = new JButton("Close Game");
		finishbttn.setBounds(21, 452, 125, 51);
		finishbttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
			}
		});
		window.getContentPane().setLayout(null);
		window.getContentPane().add(finishbttn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText("<html>" + "You have found all the Ship Parts!" + "<br>" + "Congratulations on completing the game!" + "<br>" + "<br>" + 
				"Days remaining: " + gameLogic.getRemainingDays() +  "<br>" + "<br>" + 
				 "Remaining amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney() + "<br>" + "<br>" + 
				 "Your score for this game was: " + gameLogic.gameScoreCalculation() + "</html>");
		lblNewLabel.setBounds(268, 91, 350, 282);
		window.getContentPane().add(lblNewLabel);
	}
}
