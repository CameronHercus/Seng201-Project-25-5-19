import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ShipMenuScreen {
	private GameEnvironment gameLogic;
	private JFrame window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipMenuScreen window = new ShipMenuScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShipMenuScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblShipStatus = new JLabel("<html>" + "Days remaining: " + gameLogic.getRemainingDays() +  "<br>" + 
		 "Amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney() + "<br>" +
		 "Number of pieces remaining: " + gameLogic.getNumberOfPiecesRemaining() + "</html>");
		lblShipStatus.setFont(new Font("Arial", Font.BOLD, 16));
		lblShipStatus.setBounds(10, 10, 390, 79);
		window.getContentPane().add(lblShipStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(8, 514, 109, 40);
		window.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(542, 46, 125, 21);
		window.getContentPane().add(comboBox_1);
		
		JButton button = new JButton("");
		button.setBounds(484, 223, 125, 65);
		window.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(127, 488, 125, 65);
		window.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(651, 223, 125, 65);
		window.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(206, 356, 125, 65);
		window.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBounds(310, 489, 125, 65);
		window.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setBounds(651, 488, 125, 65);
		window.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setBounds(310, 223, 125, 65);
		window.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setBounds(484, 489, 125, 65);
		window.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setBounds(484, 104, 125, 65);
		window.getContentPane().add(button_8);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(8, 248, 109, 40);
		window.getContentPane().add(comboBox_2);
		
		JButton button_9 = new JButton("");
		button_9.setBounds(127, 223, 125, 65);
		window.getContentPane().add(button_9);
	}
}
