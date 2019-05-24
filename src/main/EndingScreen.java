package main;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;

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
		
		JButton closeGameButton = new JButton("Close Game");
		closeGameButton.setBounds(21, 452, 125, 51);
		closeGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
			}
		});
		window.getContentPane().setLayout(null);
		window.getContentPane().add(closeGameButton);
		
		JLabel resultsLabel = new JLabel("");
		resultsLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		if (gameLogic.getNumberOfPiecesRemaining() <= 0) {
			resultsLabel.setText("<html>" + "You have found all the Ship Parts for " + gameLogic.getShipAndCrew().getShipName() + "<br>" + "Congratulations on completing the game!" + "<br>" + "<br>" + 
					"Days remaining: " + gameLogic.getRemainingDays() +  "<br>" + "<br>" + 
					 "Remaining amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney() + "<br>" + "<br>" + 
					 "Your score for this game was: " + gameLogic.getGameScore() + "</html>");
		} else {
			resultsLabel.setText("<html>" + "Unfortunately you have failed to complete the game" + "<br>" + "You didnt manage to get all the Ship Parts for " + gameLogic.getShipAndCrew().getShipName() + "<br>" + "<br>" + 
					"Days remaining: " + gameLogic.getRemainingDays() +  "<br>" + "<br>" + 
					 "Remaining amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney() + "<br>" + "<br>" + 
					 "Your score for this game was: " + gameLogic.getGameScore() + "</html>");
		}

		resultsLabel.setBounds(178, 53, 477, 450);
		window.getContentPane().add(resultsLabel);
	}
}
