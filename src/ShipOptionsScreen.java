import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShipOptionsScreen {
	private GameEnvironment gameLogic;
	private JFrame window;

	public static void main(String[] args) {
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public ShipOptionsScreen(GameEnvironment tempGameLogic) {
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
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel shipNamelbl = new JLabel("You are onboard " + gameLogic.getShipAndCrew().getShipName());
		shipNamelbl.setFont(new Font("Arial", Font.PLAIN, 18));
		shipNamelbl.setBounds(10, 46, 698, 39);
		window.getContentPane().add(shipNamelbl);
		
		JButton btnVisitNearestOutpost = new JButton("Visit nearest outpost");
		btnVisitNearestOutpost.setBounds(36, 593, 164, 96);
		window.getContentPane().add(btnVisitNearestOutpost);
		
		JButton btnMoveToNext = new JButton("Move to next day");
		btnMoveToNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameLogic.setRemainingDays(gameLogic.getRemainingDays()-1);
				//terminate() and launch it again or make new thing called relaunch
			}
		});
		btnMoveToNext.setBounds(210, 593, 164, 96);
		window.getContentPane().add(btnMoveToNext);
		
		JLabel lblShipStatus = new JLabel("Ship shield: " + gameLogic.getShipAndCrew().getShipHealth() + "%");
		lblShipStatus.setBounds(10, 96, 237, 22);
		window.getContentPane().add(lblShipStatus);
		
		JLabel lblCrewMembersStatus = new JLabel("Crew Members Status:");
		lblCrewMembersStatus.setBounds(10, 159, 119, 14);
		window.getContentPane().add(lblCrewMembersStatus);
		
		JLabel lblDaysRemaining = new JLabel("Days remaining: " + gameLogic.getRemainingDays());
		lblDaysRemaining.setBounds(10, 11, 257, 24);
		window.getContentPane().add(lblDaysRemaining);
		
		JLabel crewMember1status = new JLabel("");
		crewMember1status.setBounds(21, 202, 125, 80);
		window.getContentPane().add(crewMember1status);
		crewMember1status.setText(gameLogic.getShipAndCrew().getCrewList().get(0).toStatus());
		
		JLabel crewMember2status = new JLabel("");
		crewMember2status.setBounds(156, 202, 125, 80);
		window.getContentPane().add(crewMember2status);
		crewMember2status.setText(gameLogic.getShipAndCrew().getCrewList().get(1).toStatus());
		
		JLabel crewMember3status = new JLabel("");
		crewMember3status.setBounds(291, 202, 125, 80);
		window.getContentPane().add(crewMember3status);
		try {
			crewMember3status.setText(gameLogic.getShipAndCrew().getCrewList().get(2).toStatus());
		} catch (java.lang.IndexOutOfBoundsException e) {
		}
		
		JLabel crewMember4status = new JLabel("");
		crewMember4status.setBounds(426, 202, 125, 80);
		window.getContentPane().add(crewMember4status);
		try {
			crewMember4status.setText(gameLogic.getShipAndCrew().getCrewList().get(3).toStatus());
		} catch (java.lang.IndexOutOfBoundsException e) {
		}
	}
}
