import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShipMenuScreen {
	private GameEnvironment gameLogic;
	private JFrame window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ShipMenuScreen(GameEnvironment tempGameLogic) {
		gameLogic = tempGameLogic;
		initialize();
		window.setVisible(true);
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		gameLogic.closeShipOptionsScreen(this);
	}
	public void finishedWindowEndGame() {
		gameLogic.closeShipOptionsScreen(this);
		gameLogic.launchEndingScreen();
		// rethink how it relates to all the close and launch menus
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
		lblShipStatus.setBounds(10, 10, 269, 79);
		window.getContentPane().add(lblShipStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(4);
		comboBox.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getCrewList().toArray()));
		comboBox.setBounds(325, 214, 129, 40);
		window.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumRowCount(10);
		comboBox_1.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
		comboBox_1.setBounds(14, 377, 145, 40);
		window.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setMaximumRowCount(10);
		comboBox_2.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicalList().toArray()));
		comboBox_2.setBounds(232, 377, 145, 40);
		window.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setMaximumRowCount(4);
		comboBox_3.setBounds(436, 377, 145, 40);
		window.getContentPane().add(comboBox_3);
		
		JButton button_1 = new JButton("Have " + comboBox.getSelectedItem() + " Apply " + comboBox_2.getSelectedItem());
		button_1.setBounds(232, 287, 145, 80);
		window.getContentPane().add(button_1);
		
		JButton button_3 = new JButton("Have " + comboBox.getSelectedItem() + " Eat " + comboBox_1.getSelectedItem());
		button_3.setBounds(14, 287, 145, 80);
		window.getContentPane().add(button_3);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSleep.setBounds(436, 472, 145, 80);
		window.getContentPane().add(btnSleep);
		
		JButton button_6 = new JButton("Repair the Ship");
		button_6.setBounds(232, 472, 145, 80);
		window.getContentPane().add(button_6);
		
		JButton btnVisitNearestOutpost = new JButton("Visit Nearest Outpost");
		btnVisitNearestOutpost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
				gameLogic.launchOutpostOptionScreen();
			}
		});
		btnVisitNearestOutpost.setBounds(275, 24, 125, 65);
		window.getContentPane().add(btnVisitNearestOutpost);
		
		JButton btnPilotShipWith = new JButton("Pilot ship with ");
		btnPilotShipWith.setBounds(436, 287, 145, 80);
		window.getContentPane().add(btnPilotShipWith);
		
		JLabel lblNewLabel = new JLabel("<html>" + gameLogic.getShipAndCrew().getCrewList().get(0).toString() + "<br>" +
				"Health " + gameLogic.getShipAndCrew().getCrewList().get(0).getHealthLevel() + "<br>" +
				"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(0).getHungerLevel() + "<br>" +
				"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(0).getTirednessLevel() + "<br>" +
				"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(0).getCrewActions() + "</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(134, 169, 129, 85);
		window.getContentPane().add(lblNewLabel);
		
		JButton button_4 = new JButton("Have " + comboBox.getSelectedItem() + " Search for parts ");
		button_4.setBounds(14, 472, 145, 80);
		window.getContentPane().add(button_4);
		
		JLabel label = new JLabel("<html>" + gameLogic.getShipAndCrew().getCrewList().get(0).toString() + "<br>" +
				"Health " + gameLogic.getShipAndCrew().getCrewList().get(0).getHealthLevel() + "<br>" +
				"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(0).getHungerLevel() + "<br>" +
				"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(0).getTirednessLevel() + "<br>" +
				"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(0).getCrewActions() + "</html>");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(631, 4, 145, 120);
		window.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("<html>" + gameLogic.getShipAndCrew().getCrewList().get(1).toString() + "<br>" +
				"Health " + gameLogic.getShipAndCrew().getCrewList().get(1).getHealthLevel() + "<br>" +
				"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(1).getHungerLevel() + "<br>" +
				"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(1).getTirednessLevel() + "<br>" +
				"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(1).getCrewActions() + "</html>");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(631, 134, 145, 120);
		window.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("<html><dynamic><br>Health 0<br>Hunger 0<br>Tiredness 0<br>Remaining Actions 0</html>");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(631, 287, 145, 120);
		window.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("<html><dynamic><br>Health 0<br>Hunger 0<br>Tiredness 0<br>Remaining Actions 0</html>");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(631, 432, 145, 120);
		window.getContentPane().add(label_3);
		
		JButton btnNewButton = new JButton("onto next day");
		btnNewButton.setBounds(422, 22, 125, 65);
		window.getContentPane().add(btnNewButton);
	}
}
