import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JSlider;

import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class ShipMenuScreen {
	private GameEnvironment gameLogic;
	private JFrame window;
	public JLabel selectedMemberStatus;
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
	public void refresh() {
		
	}
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel memberStatus1 = new JLabel(getText("member1"));
		memberStatus1.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus1.setBounds(631, 38, 145, 120);
		window.getContentPane().add(memberStatus1);
		
		JLabel memberStatus2 = new JLabel(getText("member2"));
		memberStatus2.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus2.setBounds(631, 156, 145, 120);
		window.getContentPane().add(memberStatus2);
		
		JLabel memberStatus4 = new JLabel(getText("member4"));
		memberStatus4.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus4.setBounds(631, 432, 145, 120);
		window.getContentPane().add(memberStatus4);
		
		JLabel memberStatus3 = new JLabel(getText("member3"));
		memberStatus3.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus3.setBounds(631, 287, 145, 120);
		window.getContentPane().add(memberStatus3);
		
		JLabel lblOnBoardMessage = new JLabel("You are on board " + gameLogic.getShipAndCrew().getShipName());
		lblOnBoardMessage.setFont(new Font("Arial", Font.BOLD, 18));
		lblOnBoardMessage.setBounds(14, 11, 330, 26);
		window.getContentPane().add(lblOnBoardMessage);
		
		JLabel lblShipStatus = new JLabel(getText("shipText"));
		lblShipStatus.setFont(new Font("Arial", Font.BOLD, 16));
		lblShipStatus.setBounds(14, 44, 269, 79);
		window.getContentPane().add(lblShipStatus);
		
		JButton btnNewButton = new JButton("onto next day");
		btnNewButton.addMouseListener(new MouseAdapter() {
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
		btnNewButton.setBounds(456, 58, 125, 65);
		window.getContentPane().add(btnNewButton);
		
		JComboBox boxSelectedMember = new JComboBox();
		boxSelectedMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boxSelectedMember.setMaximumRowCount(4);
		boxSelectedMember.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getCrewList().toArray()));
		boxSelectedMember.setBounds(325, 214, 129, 40);
		window.getContentPane().add(boxSelectedMember);
		
		JComboBox boxFoodSelect = new JComboBox();
		boxFoodSelect.setMaximumRowCount(10);
		boxFoodSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
		boxFoodSelect.setBounds(14, 377, 145, 40);
		window.getContentPane().add(boxFoodSelect);
		
		JComboBox boxMedicineSelect = new JComboBox();
		boxMedicineSelect.setMaximumRowCount(10);
		boxMedicineSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicalList().toArray()));
		boxMedicineSelect.setBounds(232, 377, 145, 40);
		window.getContentPane().add(boxMedicineSelect);
		
		JComboBox boxPilotWithSelect = new JComboBox();
		boxPilotWithSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getCrewList().toArray()));
		boxPilotWithSelect.setMaximumRowCount(4);
		boxPilotWithSelect.setBounds(436, 377, 145, 40);
		window.getContentPane().add(boxPilotWithSelect);
		
		JButton applyMedicinebttn = new JButton(getMemberTextUpdate());
		applyMedicinebttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		applyMedicinebttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((CrewMembersMainClass) boxSelectedMember.getSelectedItem()).getCrewActions() >= 1) {
					System.out.println(((CrewMembersMainClass) boxSelectedMember.getSelectedItem()));
					gameLogic.applyMedicine(((MedicalSupplies) boxMedicineSelect.getSelectedItem()), 
							((CrewMembersMainClass) boxSelectedMember.getSelectedItem()));
					boxMedicineSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicalList().toArray()));
					gameLogic.remove1Action((CrewMembersMainClass) boxSelectedMember.getSelectedItem());
					memberStatus1.setText(getText("member1"));
					memberStatus2.setText(getText("member2"));
					memberStatus3.setText(getText("member3"));
					memberStatus4.setText(getText("member4"));
					lblShipStatus.setText(getText("shipText"));
					if (gameLogic.getShipAndCrew().getMedicalList().size() > 0) {
						applyMedicinebttn.setText("<html>" + "Have " + boxSelectedMember.getSelectedItem() + "<br>" + "Apply ");
					} else {
						applyMedicinebttn.setText("<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>");
					}
				}
			}
		});
		applyMedicinebttn.setBounds(232, 287, 145, 80);
		window.getContentPane().add(applyMedicinebttn);
		
		JButton eatFoodbttn = new JButton("<html>" + "You have no food" + "<br>" + "to eat" +  "</html>");
		if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
			eatFoodbttn.setText("<html>" + "Have " + boxSelectedMember.getSelectedItem() + "<br>" + " Eat " + 
					boxFoodSelect.getSelectedItem() + "</html>");
		}
		eatFoodbttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((CrewMembersMainClass) boxSelectedMember.getSelectedItem()).getCrewActions() >= 1) {
					gameLogic.feed(((FoodItems) boxFoodSelect.getSelectedItem()), 
							((CrewMembersMainClass) boxSelectedMember.getSelectedItem()));
					gameLogic.remove1Action((CrewMembersMainClass) boxSelectedMember.getSelectedItem());
					boxFoodSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
					memberStatus1.setText(getText("member1"));
					memberStatus2.setText(getText("member2"));
					memberStatus3.setText(getText("member3"));
					memberStatus4.setText(getText("member4"));
					if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
						eatFoodbttn.setText("<html>" + "Have " + boxSelectedMember.getSelectedItem() + "<br>" + " Eat " + 
								boxFoodSelect.getSelectedItem() + "</html>");
					} else {
						eatFoodbttn.setText(getText("noFood"));
					}
					
				} else {
					System.out.println("no actions remaining");
				}
				
			}
		});
		eatFoodbttn.setBounds(14, 287, 145, 80);
		window.getContentPane().add(eatFoodbttn);
		
		JButton btnSleep = new JButton("<html>" + "Have " + boxSelectedMember.getSelectedItem() + "<br>" +  "Sleep" + "</html>");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSleep.setBounds(436, 472, 145, 80);
		window.getContentPane().add(btnSleep);
		
		JButton btnRepairShip = new JButton("<html>" + "Have " + boxSelectedMember.getSelectedItem() + "<br>" +  "Repair the Ship" + "</html>");
		btnRepairShip.setBounds(232, 472, 145, 80);
		window.getContentPane().add(btnRepairShip);
		
		JButton btnVisitNearestOutpost = new JButton("Visit Nearest Outpost");
		btnVisitNearestOutpost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
				gameLogic.launchOutpostOptionScreen();
			}
		});
		btnVisitNearestOutpost.setBounds(293, 58, 125, 65);
		window.getContentPane().add(btnVisitNearestOutpost);
		
		JButton btnPilotShipWith = new JButton("<html>" + "Have " + boxSelectedMember.getSelectedItem() + "<br>" + "Pilot with " + "</html>");
		btnPilotShipWith.setBounds(436, 287, 145, 80);
		window.getContentPane().add(btnPilotShipWith);
		
		JButton btnSearchParts = new JButton("<html>" + "Have " + boxSelectedMember.getSelectedItem() + "<br>" + "Search for parts " + "</html>");
		btnSearchParts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchParts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameLogic.searchForParts(((CrewMembersMainClass) boxSelectedMember.getSelectedItem()));
				memberStatus1.setText(getText("member1"));
				memberStatus2.setText(getText("member2"));
				memberStatus3.setText(getText("member3"));
				memberStatus4.setText(getText("member4"));
				lblShipStatus.setText(getText("shipText"));
			}
		});
		btnSearchParts.setBounds(14, 472, 145, 80);
		window.getContentPane().add(btnSearchParts);
	
	}
	public String getText(String switchStatement) {
		switch (switchStatement) {
		case "member1":
			return "<html>" + gameLogic.getShipAndCrew().getCrewList().get(0).toString() + "<br>" +
			"Health " + gameLogic.getShipAndCrew().getCrewList().get(0).getHealthLevel() + "<br>" +
			"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(0).getHungerLevel() + "<br>" +
			"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(0).getTirednessLevel() + "<br>" +
			"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(0).getCrewActions() + "</html>";
		case "member2":
			return "<html>" + gameLogic.getShipAndCrew().getCrewList().get(1).toString() + "<br>" +
			"Health " + gameLogic.getShipAndCrew().getCrewList().get(1).getHealthLevel() + "<br>" +
			"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(1).getHungerLevel() + "<br>" +
			"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(1).getTirednessLevel() + "<br>" +
			"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(1).getCrewActions() + "</html>";
		case "member3":
			if (gameLogic.getShipAndCrew().getCrewList().size() >= 3) {
				return "<html>" + gameLogic.getShipAndCrew().getCrewList().get(2).toString() + "<br>" +
						"Health " + gameLogic.getShipAndCrew().getCrewList().get(2).getHealthLevel() + "<br>" +
						"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(2).getHungerLevel() + "<br>" +
						"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(2).getTirednessLevel() + "<br>" +
						"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(2).getCrewActions() + "</html>";
			} else {
				return "";
			}
		case "member4":
			if (gameLogic.getShipAndCrew().getCrewList().size() == 4) {
				return "<html>" + gameLogic.getShipAndCrew().getCrewList().get(3).toString() + "<br>" +
						"Health " + gameLogic.getShipAndCrew().getCrewList().get(3).getHealthLevel() + "<br>" +
						"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(3).getHungerLevel() + "<br>" +
						"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(3).getTirednessLevel() + "<br>" +
						"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(3).getCrewActions() + "</html>";
			} else {
				return "";
			}
		case "noFood": return "<html>" + "You have no food" + "<br>" + "to eat" +  "</html>";
		case "shipText": return "<html>" + "Days remaining: " + gameLogic.getRemainingDays() +  "<br>" + 
				 "Amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney() + "<br>" +
				 "Number of pieces remaining: " + gameLogic.getNumberOfPiecesRemaining() + "</html>";
		default:
			return "None";
		}
			
	}
	public String getMemberTextUpdate(String switchStatement, String memberName) {
		switch (switchStatement) {
		case "parts": return "<html>" + "Have " + memberName + "<br>" + "Search for parts " + "</html>";
		case "repair": return "<html>" + "Have " + memberName + "<br>" +  "Repair the Ship" + "</html>";
		case "pilot": return "<html>" + "Have " + memberName + "<br>" + "Pilot with " + "</html>";
		case "sleep": return "<html>" + "Have " + memberName + "<br>" +  "Sleep" + "</html>";
		case "eat": 
			if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
				return "<html>" + "Have " + memberName + "<br>" + " Eat " + memberName + "</html>";
			} else {
				return "<html>" + "You have no food" + "<br>" + "to eat" +  "</html>";
			}
		case "useMedicine": 
			if (gameLogic.getShipAndCrew().getMedicalList().size() > 0) {
				return "<html>" + "Have " + memberName + "<br>" + "Apply " + memberName + "</html>";
			} else {
				return "<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>";
			}
		default:
			return null;
		}
	}
	
}
