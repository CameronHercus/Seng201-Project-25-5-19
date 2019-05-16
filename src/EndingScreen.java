import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		window.getContentPane().setLayout(null);
		
		JButton finishbttn = new JButton("finish");
		finishbttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
			}
		});
		finishbttn.setBounds(21, 452, 89, 23);
		window.getContentPane().add(finishbttn);
	}
}
