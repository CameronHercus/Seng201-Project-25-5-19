import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	public void finishedWindowEndGame() {
		gameLogic.closeShipOptionsScreen(this);
		gameLogic.launchEndingScreen();
		// rethink how it relates to all the close and launch menus
	}
	private void initialize() {
		window = new JFrame();
		window.setTitle("Ship");
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblDaysRemaining = new JLabel("Days remaining: " + gameLogic.getRemainingDays() + ", Number of pieces remaining: " + gameLogic.getNumberOfPiecesRemaining() + 
				"Amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney());
		lblDaysRemaining.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDaysRemaining.setBounds(10, 11, 555, 24);
		window.getContentPane().add(lblDaysRemaining);
		
		JLabel shipNamelbl = new JLabel("You are onboard " + gameLogic.getShipAndCrew().getShipName());
		shipNamelbl.setFont(new Font("Arial", Font.PLAIN, 18));
		shipNamelbl.setBounds(10, 26, 698, 39);
		window.getContentPane().add(shipNamelbl);
		
		JButton btnVisitNearestOutpost = new JButton("Visit nearest outpost");
		btnVisitNearestOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisitNearestOutpost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
				gameLogic.launchOutpostOptionScreen();
			}
		});
		btnVisitNearestOutpost.setBounds(609, 11, 165, 95);
		window.getContentPane().add(btnVisitNearestOutpost);
		
		JLabel lblShipStatus = new JLabel("Ship shield health: " + gameLogic.getShipAndCrew().getShipHealth() + "%");
		lblShipStatus.setFont(new Font("Arial", Font.PLAIN, 16));
		lblShipStatus.setBounds(265, 34, 237, 22);
		window.getContentPane().add(lblShipStatus);
		
		JLabel lblCrewMembersStatus = new JLabel("Crew Members Status:");
		lblCrewMembersStatus.setBounds(10, 76, 211, 14);
		window.getContentPane().add(lblCrewMembersStatus);
		
		JLabel crewMember1status = new JLabel("");
		crewMember1status.setHorizontalAlignment(SwingConstants.LEFT);
		crewMember1status.setBounds(10, 89, 125, 80);
		window.getContentPane().add(crewMember1status);
		try {
			crewMember1status.setText("<html>" + gameLogic.getShipAndCrew().getCrewList().get(0).toString() + "<br>" +
					"Health " + gameLogic.getShipAndCrew().getCrewList().get(0).getHealthLevel() + "<br>" +
					"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(0).getHungerLevel() + "<br>" +
					"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(0).getTirednessLevel() + "<br>" +
					"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(0).getCrewActions() + "</html>");
			
		} catch (java.lang.IndexOutOfBoundsException e) {
		}
		JLabel crewMember2status = new JLabel("");
		crewMember2status.setBounds(166, 89, 125, 80);
		window.getContentPane().add(crewMember2status);
		try {
			crewMember2status.setText("<html>" + gameLogic.getShipAndCrew().getCrewList().get(1).toString() + "<br>" +
					"Health " + gameLogic.getShipAndCrew().getCrewList().get(1).getHealthLevel() + "<br>" +
					"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(1).getHungerLevel() + "<br>" +
					"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(1).getTirednessLevel() + "<br>" +
					"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(1).getCrewActions() + "</html>");
		} catch (java.lang.IndexOutOfBoundsException e) {
		}
		
		JLabel crewMember3status = new JLabel("");
		crewMember3status.setBounds(301, 89, 125, 80);
		window.getContentPane().add(crewMember3status);
		try {
			crewMember3status.setText("<html>" + gameLogic.getShipAndCrew().getCrewList().get(2).toString() + "<br>" +
					"Health " + gameLogic.getShipAndCrew().getCrewList().get(2).getHealthLevel() + "<br>" +
					"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(2).getHungerLevel() + "<br>" +
					"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(2).getTirednessLevel() + "<br>" +
					"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(2).getCrewActions() + "</html>");
		} catch (java.lang.IndexOutOfBoundsException e) {
		}
		
		JLabel crewMember4status = new JLabel("");
		crewMember4status.setBounds(446, 89, 125, 80);
		window.getContentPane().add(crewMember4status);
		try {
			crewMember4status.setText("<html>" + gameLogic.getShipAndCrew().getCrewList().get(3).toString() + "<br>" +
					"Health " + gameLogic.getShipAndCrew().getCrewList().get(3).getHealthLevel() + "<br>" +
					"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(3).getHungerLevel() + "<br>" +
					"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(3).getTirednessLevel() + "<br>" +
					"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(3).getCrewActions() + "</html>");
			
		} catch (java.lang.IndexOutOfBoundsException e) {
		}
		
		
		JButton btnNewButton = new JButton("Use Item");
		btnNewButton.setBounds(31, 225, 80, 25);
		window.getContentPane().add(btnNewButton);
		
		JButton member1Sleep = new JButton("Sleep");
		member1Sleep.setBounds(10, 419, 125, 60);
		window.getContentPane().add(member1Sleep);
		
		JButton member2Sleep = new JButton("Sleep");
		member2Sleep.setBounds(155, 419, 125, 60);
		window.getContentPane().add(member2Sleep);
		
		JButton member3Sleep = new JButton("Sleep");
		member3Sleep.setBounds(301, 419, 125, 60);
		window.getContentPane().add(member3Sleep);
		
		JButton member4Sleep = new JButton("Sleep");
		member4Sleep.setBounds(446, 419, 125, 60);
		window.getContentPane().add(member4Sleep);
		
		JButton member1Repair = new JButton("Repair ship");
		member1Repair.setBounds(10, 490, 125, 60);
		window.getContentPane().add(member1Repair);
		
		JButton member2Repair = new JButton("Repair ship");
		member2Repair.setBounds(155, 490, 125, 60);
		window.getContentPane().add(member2Repair);
		
		JButton member3Repair = new JButton("Repair ship");
		member3Repair.setBounds(301, 490, 125, 60);
		window.getContentPane().add(member3Repair);
		
		JButton member4Repair = new JButton("Repair ship");
		member4Repair.setBounds(446, 490, 125, 60);
		window.getContentPane().add(member4Repair);
		
		JButton member1Parts = new JButton("Search for parts");
		member1Parts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameLogic.searchForParts(gameLogic.getShipAndCrew().getCrewList().get(0));
				finishedWindow();
				gameLogic.launchShipOptionsScreen();
			}
		});
		member1Parts.setBounds(10, 348, 125, 60);
		window.getContentPane().add(member1Parts);
		
		JButton member2Parts = new JButton("Search for parts");
		member2Parts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameLogic.searchForParts(gameLogic.getShipAndCrew().getCrewList().get(1));
				finishedWindow();
				gameLogic.launchShipOptionsScreen();
			}
		});
		member2Parts.setBounds(155, 348, 125, 60);
		window.getContentPane().add(member2Parts);
		
		JButton member3Parts = new JButton("Search for parts");
		if (gameLogic.getShipAndCrew().getCrewList().size() >= 3) {
			member3Parts.setVisible(true);
		} else {
			member3Parts.setVisible(false);
		}
		member3Parts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameLogic.searchForParts(gameLogic.getShipAndCrew().getCrewList().get(2));
				finishedWindow();
				gameLogic.launchShipOptionsScreen();
			}
		});
		member3Parts.setBounds(301, 348, 125, 60);
		window.getContentPane().add(member3Parts);
		//must set invisible for len of crew
		JButton member4Parts = new JButton("Search for parts");
		member4Parts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameLogic.searchForParts(gameLogic.getShipAndCrew().getCrewList().get(3));
				finishedWindow();
				gameLogic.launchShipOptionsScreen();
			}
		});
		if (gameLogic.getShipAndCrew().getCrewList().size() == 4) {
			member4Parts.setVisible(true);
		} else {
			member4Parts.setVisible(false);
		}
		member4Parts.setBounds(446, 348, 125, 60);
		window.getContentPane().add(member4Parts);
		
		
		JComboBox medicine1ComboBox = new JComboBox();
		medicine1ComboBox.setMaximumRowCount(10);
		medicine1ComboBox.setModel((new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicalList().toArray())));
		medicine1ComboBox.setBounds(10, 180, 125, 45);
		window.getContentPane().add(medicine1ComboBox);
		
		JComboBox food1ComboBox = new JComboBox();
		food1ComboBox.setBounds(10, 254, 125, 45);
		window.getContentPane().add(food1ComboBox);
		
		JComboBox medicine2ComboBox = new JComboBox();
		medicine2ComboBox.setBounds(155, 180, 125, 45);
		window.getContentPane().add(medicine2ComboBox);
		
		JComboBox food2ComboBox = new JComboBox();
		food2ComboBox.setBounds(155, 254, 125, 45);
		window.getContentPane().add(food2ComboBox);
		
		JComboBox medicine3ComboBox = new JComboBox();
		if (gameLogic.getShipAndCrew().getCrewList().size() >= 3) {
			medicine3ComboBox.setVisible(true);
		} else {
			medicine3ComboBox.setVisible(false);
		}
		medicine3ComboBox.setBounds(301, 180, 125, 45);
		window.getContentPane().add(medicine3ComboBox);
		
		JComboBox food3ComboBox = new JComboBox();
		if (gameLogic.getShipAndCrew().getCrewList().size() >= 3) {
			food3ComboBox.setVisible(true);
		} else {
			food3ComboBox.setVisible(false);
		}
		food3ComboBox.setBounds(301, 254, 125, 45);
		window.getContentPane().add(food3ComboBox);
		
		JComboBox medicine4ComboBox = new JComboBox();
		if (gameLogic.getShipAndCrew().getCrewList().size() == 4) {
			medicine4ComboBox.setVisible(true);
		} else {
			medicine4ComboBox.setVisible(false);
		}
		medicine4ComboBox.setBounds(446, 180, 125, 45);
		window.getContentPane().add(medicine4ComboBox);
		
		JComboBox food4ComboBox = new JComboBox();
		if (gameLogic.getShipAndCrew().getCrewList().size() == 4) {
			food4ComboBox.setVisible(true);
		} else {
			food4ComboBox.setVisible(false);
		}
		food4ComboBox.setBounds(446, 254, 125, 45);
		window.getContentPane().add(food4ComboBox);
		
		JButton btnMoveToNext = new JButton("Move to next day");
		btnMoveToNext.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {

				// maybe change to have it do set remaining days before the if statement
				gameLogic.newDayChanges();
				if (!gameLogic.isGameOver() && gameLogic.getRemainingDays() > 1) {
					gameLogic.setAllCrewmembersActions();
					gameLogic.setRemainingDays(gameLogic.getRemainingDays()-1);
					finishedWindow();
					gameLogic.launchShipOptionsScreen();
				} else {
					finishedWindowEndGame();
				}
				
				
				//terminate() and launch it again or make new thing called relaunch
				
			}
		});
		
		JButton newPlanet = new JButton("Visit new Planet");
		newPlanet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newPlanet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (gameLogic.newPlanet()) {
					//say the ship was hit by an asteroid
					System.out.println("WORKS");
				}
				if (!gameLogic.isGameOver()) {
					finishedWindow();
					gameLogic.launchShipOptionsScreen();
				} else {
					//CLOSE THE GAME
					finishedWindowEndGame();
				}

			}
		});
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(699, 466, 28, 22);
		window.getContentPane().add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(699, 491, 28, 22);
		window.getContentPane().add(comboBox);
		newPlanet.setBounds(609, 225, 165, 80);
		window.getContentPane().add(newPlanet);
		btnMoveToNext.setBounds(609, 119, 165, 95);
		window.getContentPane().add(btnMoveToNext);

		
	}
}
