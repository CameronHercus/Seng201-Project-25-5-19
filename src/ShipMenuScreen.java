import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;
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
import java.util.Collections;
import java.util.EventObject;
import java.util.List;

public class ShipMenuScreen {
	private GameEnvironment gameLogic;
	private JFrame window;
	private JButton btnSearchParts;
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
		JLabel memberStatus1 = new JLabel(getText("member1"));
		JLabel memberStatus2 = new JLabel(getText("member2"));
		JLabel memberStatus4 = new JLabel(getText("member4"));
		JLabel memberStatus3 = new JLabel(getText("member3"));
		
		window = new JFrame();
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel currentDay = new JLabel("Current Day: " + gameLogic.getCurrentDay());
		currentDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currentDay.setBounds(0, 0, 98, 40);
		window.getContentPane().add(currentDay);
		
		memberStatus1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		memberStatus1.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus1.setBounds(591, 11, 185, 130);
		window.getContentPane().add(memberStatus1);
		
		memberStatus2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		memberStatus2.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus2.setBounds(591, 149, 185, 130);
		window.getContentPane().add(memberStatus2);
		
		memberStatus4.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		memberStatus4.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus4.setBounds(591, 428, 185, 130);
		window.getContentPane().add(memberStatus4);
		
		memberStatus3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		memberStatus3.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus3.setBounds(591, 288, 185, 130);
		window.getContentPane().add(memberStatus3);
		
		JLabel lblOnBoardMessage = new JLabel("You are on board " + gameLogic.getShipAndCrew().getShipName());
		lblOnBoardMessage.setFont(new Font("Arial", Font.BOLD, 18));
		lblOnBoardMessage.setBounds(150, 0, 330, 113);
		window.getContentPane().add(lblOnBoardMessage);
		
		JLabel lblShipStatus = new JLabel(getText("shipText"));
		lblShipStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblShipStatus.setBounds(45, 149, 269, 154);
		window.getContentPane().add(lblShipStatus);
		
		JComboBox boxSelectedMember = new JComboBox();
		boxSelectedMember.setFont(new Font("Tahoma", Font.BOLD, 14));
		boxSelectedMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		boxSelectedMember.setMaximumRowCount(4);
		boxSelectedMember.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getCrewList().toArray()));
		boxSelectedMember.setBounds(330, 263, 233, 46);
		window.getContentPane().add(boxSelectedMember);
		
		JComboBox boxFoodSelect = new JComboBox();
		boxFoodSelect.setMaximumRowCount(6);
		boxFoodSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
		boxFoodSelect.setBounds(14, 401, 165, 40);
		window.getContentPane().add(boxFoodSelect);
		
		JComboBox boxMedicineSelect = new JComboBox();
		boxMedicineSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boxMedicineSelect.setMaximumRowCount(6);
		boxMedicineSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicalList().toArray()));
		boxMedicineSelect.setBounds(211, 401, 166, 40);
		window.getContentPane().add(boxMedicineSelect);
		
		JComboBox boxPilotWithSelect = new JComboBox();
		boxPilotWithSelect.setFont(new Font("Tahoma", Font.BOLD, 10));
		boxPilotWithSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getCrewList().toArray()));
		boxPilotWithSelect.setMaximumRowCount(4);
		boxPilotWithSelect.setBounds(416, 401, 165, 40);
		window.getContentPane().add(boxPilotWithSelect);
		
		JButton applyMedicinebttn = new JButton("<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>");
		applyMedicinebttn.setFont(new Font("Tahoma", Font.BOLD, 12));
		if (gameLogic.getShipAndCrew().getMedicalList().size() > 0) {
			applyMedicinebttn.setText(getMemberTextUpdate("useMedicine", boxSelectedMember.getSelectedItem().toString(), boxMedicineSelect.getSelectedItem().toString())); 
		}
		applyMedicinebttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		applyMedicinebttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((CrewMembersMainClass) boxSelectedMember.getSelectedItem()).getCrewActions() >= 1 && gameLogic.getShipAndCrew().getMedicalList().size() >= 1) {
					// called once here!!!!
					JOptionPane.showMessageDialog(null, gameLogic.applyMedicine(((MedicalSupplies) boxMedicineSelect.getSelectedItem()), ((CrewMembersMainClass) boxSelectedMember.getSelectedItem())));
					boxMedicineSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicalList().toArray()));
					memberStatus1.setText(getText("member1"));
					memberStatus2.setText(getText("member2"));
					memberStatus3.setText(getText("member3"));
					memberStatus4.setText(getText("member4"));
					lblShipStatus.setText(getText("shipText"));
					if (gameLogic.getShipAndCrew().getMedicalList().size() > 0) {
						applyMedicinebttn.setText("<html>" + "Apply Medical Item:");
					} else {
						applyMedicinebttn.setText("<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>");
					}
				} else {
					if (gameLogic.getShipAndCrew().getMedicalList().size() == 0) {
						JOptionPane.showMessageDialog(null, "Your have no medicine to apply in your inventory");
					} else {
						JOptionPane.showMessageDialog(null, ((CrewMembersMainClass) boxSelectedMember.getSelectedItem()).toString() + " has no actions remaining");
					}
				}
			}
		});
		applyMedicinebttn.setBounds(211, 320, 165, 70);
		window.getContentPane().add(applyMedicinebttn);
		
		JButton eatFoodbttn = new JButton("<html>" + "You have no food" + "<br>" + "to eat" +  "</html>");
		eatFoodbttn.setFont(new Font("Tahoma", Font.BOLD, 12));
		if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
			eatFoodbttn.setText("<html>" + "Eat the following Food:" +  "</html>");
		}
		eatFoodbttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((CrewMembersMainClass) boxSelectedMember.getSelectedItem()).getCrewActions() >= 1 && gameLogic.getShipAndCrew().getFoodList().size() >= 1) {
					if ((boolean) gameLogic.feed(((FoodItems) boxFoodSelect.getSelectedItem()), ((CrewMembersMainClass) boxSelectedMember.getSelectedItem()))) {
						JOptionPane.showMessageDialog(null, ((CrewMembersMainClass) boxSelectedMember.getSelectedItem()).toString() + " is now less hungry");
						gameLogic.remove1Action((CrewMembersMainClass) boxSelectedMember.getSelectedItem());
						boxFoodSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
						memberStatus1.setText(getText("member1"));
						memberStatus2.setText(getText("member2"));
						memberStatus3.setText(getText("member3"));
						memberStatus4.setText(getText("member4"));
						lblShipStatus.setText(getText("shipText"));
						if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
							eatFoodbttn.setText("<html>" + "Eat the following Food" + "</html>");
						} else {
							eatFoodbttn.setText(getText("noFood"));
						}
					} else {
						JOptionPane.showMessageDialog(null, ((CrewMembersMainClass) boxSelectedMember.getSelectedItem()).toString() + " is not hungry enough to eat");
					}
				} else {
					if (gameLogic.getShipAndCrew().getFoodList().size() == 0) {
						JOptionPane.showMessageDialog(null, "Your have no food to eat in your inventory");
					} else {
						JOptionPane.showMessageDialog(null, ((CrewMembersMainClass) boxSelectedMember.getSelectedItem()).toString() + " has no actions remaining");
					}
				}
				
			}
		});
		eatFoodbttn.setBounds(14, 320, 165, 70);
		window.getContentPane().add(eatFoodbttn);
		
		JButton btnSleep = new JButton(getMemberChangeUpdate("sleep",  boxSelectedMember.getSelectedItem().toString()));
		btnSleep.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, gameLogic.memberSleep(((CrewMembersMainClass) boxSelectedMember.getSelectedItem())));
					memberStatus1.setText(getText("member1"));
					memberStatus2.setText(getText("member2"));
					memberStatus3.setText(getText("member3"));
					memberStatus4.setText(getText("member4"));
					lblShipStatus.setText(getText("shipText"));
			}
		});
		btnSleep.setBounds(416, 482, 165, 70);
		window.getContentPane().add(btnSleep);
		
		JButton btnRepairShip = new JButton(getMemberChangeUpdate("repair",  boxSelectedMember.getSelectedItem().toString()));
		btnRepairShip.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,gameLogic.repairShip((CrewMembersMainClass) boxSelectedMember.getSelectedItem())); 
					memberStatus1.setText(getText("member1"));
					memberStatus2.setText(getText("member2"));
					memberStatus3.setText(getText("member3"));
					memberStatus4.setText(getText("member4"));
					lblShipStatus.setText(getText("shipText"));
			}
		});
		btnRepairShip.setBounds(211, 482, 165, 70);
		window.getContentPane().add(btnRepairShip);
		
		JButton btnVisitNearestOutpost = new JButton("Visit Nearest Outpost");
		btnVisitNearestOutpost.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVisitNearestOutpost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
				gameLogic.launchOutpostOptionScreen();
			}
		});
		btnVisitNearestOutpost.setBounds(318, 100, 211, 46);
		window.getContentPane().add(btnVisitNearestOutpost);
		
		JButton btnPilotShipWith = new JButton(getMemberChangeUpdate("pilot",  boxSelectedMember.getSelectedItem().toString()));
		btnPilotShipWith.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPilotShipWith.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (boxSelectedMember.getSelectedItem() != boxPilotWithSelect.getSelectedItem()) {
					if (((CrewMembersMainClass) boxSelectedMember.getSelectedItem()).getCrewActions() >= 1 && ((CrewMembersMainClass) boxPilotWithSelect.getSelectedItem()).getCrewActions() >= 1) {
						if (gameLogic.newPlanet((CrewMembersMainClass) boxSelectedMember.getSelectedItem(), (CrewMembersMainClass) boxPilotWithSelect.getSelectedItem())) {
							if (gameLogic.getShipAndCrew().getShipHealth() <= 0) {
								finishedWindowEndGame();
							}
							JOptionPane.showMessageDialog(null, "<html>" + "You have arrived on a new Planet" + "<br>" +  "However you had to pass through an asteroid belt and your ship has substained damage" + "</html>");
						} else {
							JOptionPane.showMessageDialog(null, "You have arrived on a new Planet and your ship has substained no damage");
						}
					} else {
						JOptionPane.showMessageDialog(null, "This pair of crew members does not have enough remaining Actions to perform this");
					}
				} else {
					JOptionPane.showMessageDialog(null, "You must chose a another crew member to pilot with");

				}
				memberStatus1.setText(getText("member1"));
				memberStatus2.setText(getText("member2"));
				memberStatus3.setText(getText("member3"));
				memberStatus4.setText(getText("member4"));
				lblShipStatus.setText(getText("shipText"));
			}
		});
		btnPilotShipWith.setBounds(416, 320, 165, 70);
		window.getContentPane().add(btnPilotShipWith);
		
		JButton btnSearchParts = new JButton(getMemberChangeUpdate("parts",  boxSelectedMember.getSelectedItem().toString()));
		btnSearchParts.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearchParts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// search for parts is true;
				JOptionPane.showMessageDialog(null, ((CrewMembersMainClass) boxSelectedMember.getSelectedItem()).toString() + gameLogic.searchForParts(((CrewMembersMainClass) boxSelectedMember.getSelectedItem())));
				if (gameLogic.getNumberOfPiecesRemaining() <= 0) {
					if (gameLogic.isGameOver()) {
						finishedWindowEndGame();
					}
					
				}
				memberStatus1.setText(getText("member1"));
				memberStatus2.setText(getText("member2"));
				memberStatus3.setText(getText("member3"));
				memberStatus4.setText(getText("member4"));
				lblShipStatus.setText(getText("shipText"));
				boxFoodSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
				boxMedicineSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicalList().toArray()));
				if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
					eatFoodbttn.setText("<html>" + "Eat the following Food" + "</html>");
				} else {
					eatFoodbttn.setText(getText("noFood"));
				}
				if (gameLogic.getShipAndCrew().getMedicalList().size() > 0) {
					applyMedicinebttn.setText("<html>" + "Apply Medical Item:");
				} else {
					applyMedicinebttn.setText("<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>");
				}
				
			}
		});
		btnSearchParts.setBounds(14, 482, 165, 70);
		window.getContentPane().add(btnSearchParts);
		
		JLabel lblNewLabel = new JLabel("<html>" + "Performing Actions for the" +"<br>" + "following Crew Member:" + "<html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(330, 186, 199, 75);
		window.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Proceed to next day");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// maybe change to have it do set remaining days before the if statement
				gameLogic.newDayChanges();
				// WILL HAVE TO CHANGE
				JOptionPane.showMessageDialog(null, "<html>" + "You are now on Day: " + gameLogic.getCurrentDay() + "<br>" + 
				gameLogic.newDayEvent() + "<br>" + "Your Crew Members are now more hungry, tired and have less health" + "<br>" + gameLogic.removeDeadCrewMembers() + "<br" + 
				gameLogic.removeActionsTired() + "<br>" + gameLogic.removeActionsSleepy() + "</html>");
				if (!gameLogic.isGameOver()) {
					boxFoodSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
					boxMedicineSelect.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicalList().toArray()));
					memberStatus1.setText(getText("member1"));
					memberStatus2.setText(getText("member2"));
					memberStatus3.setText(getText("member3"));
					memberStatus4.setText(getText("member4"));
					lblShipStatus.setText(getText("shipText"));
					if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
						eatFoodbttn.setText("<html>" + "Eat the following Food" + "</html>");
					} else {
						eatFoodbttn.setText(getText("noFood"));
					}
					if (gameLogic.getShipAndCrew().getMedicalList().size() > 0) {
						applyMedicinebttn.setText("<html>" + "Apply Medical Item:");
					} else {
						applyMedicinebttn.setText("<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>");
					}
				} else {
					finishedWindowEndGame();
				}
				currentDay.setText("Current Day: " + gameLogic.getCurrentDay());
				//terminate() and launch it again or make new thing called relaunch
				
			}
		});
		btnNewButton.setBounds(96, 100, 211, 46);
		window.getContentPane().add(btnNewButton);
	
	}
	public String getText(String switchStatement) {
		switch (switchStatement) {
		case "member1":
			if (gameLogic.getShipAndCrew().getCrewList().size() >= 1) {
				return "<html>" + gameLogic.getShipAndCrew().getCrewList().get(0).toString() + "<br>" +
						"Health " + gameLogic.getShipAndCrew().getCrewList().get(0).getHealthLevel() + "%" + "<br>" +
						"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(0).getHungerLevel() + "%" +  "<br>" +
						"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(0).getTirednessLevel() + "%" + "<br>" +
						"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(0).getCrewActions() + "<br>" + 
						"Space Plague Status: " + gameLogic.spacePlagueYesNo(gameLogic.getShipAndCrew().getCrewList().get(0)) + "</html>";
			}
		case "member2":
			if (gameLogic.getShipAndCrew().getCrewList().size() >= 2) {
				return "<html>" + gameLogic.getShipAndCrew().getCrewList().get(1).toString() + "<br>" +
						"Health " + gameLogic.getShipAndCrew().getCrewList().get(1).getHealthLevel() + "%" + "<br>" +
						"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(1).getHungerLevel() + "%" + "<br>" +
						"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(1).getTirednessLevel() + "%" +  "<br>" +
						"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(1).getCrewActions() + "<br>" + 
						"Space Plague Status: " + gameLogic.spacePlagueYesNo(gameLogic.getShipAndCrew().getCrewList().get(1)) + "</html>";
			}
		case "member3":
			if (gameLogic.getShipAndCrew().getCrewList().size() >= 3) {
				return "<html>" + gameLogic.getShipAndCrew().getCrewList().get(2).toString() + "<br>" +
						"Health " + gameLogic.getShipAndCrew().getCrewList().get(2).getHealthLevel() + "%" + "<br>" +
						"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(2).getHungerLevel() + "%" + "<br>" +
						"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(2).getTirednessLevel() + "%" + "<br>" +
						"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(2).getCrewActions() + "<br>" + 
						"Space Plague Status: " + gameLogic.spacePlagueYesNo(gameLogic.getShipAndCrew().getCrewList().get(2)) + "</html>";
			} else {
				return "";
			}
		case "member4":
			if (gameLogic.getShipAndCrew().getCrewList().size() == 4) {
				return "<html>" + gameLogic.getShipAndCrew().getCrewList().get(3).toString() + "<br>" +
						"Health " + gameLogic.getShipAndCrew().getCrewList().get(3).getHealthLevel() + "%" + "<br>" +
						"Hunger " + gameLogic.getShipAndCrew().getCrewList().get(3).getHungerLevel() + "%" + "<br>" +
						"Tiredness " + gameLogic.getShipAndCrew().getCrewList().get(3).getTirednessLevel() + "%" + "<br>" +
						"Remaining Actions " + gameLogic.getShipAndCrew().getCrewList().get(3).getCrewActions() + "<br>" + 
						"Space Plague Status: " + gameLogic.spacePlagueYesNo(gameLogic.getShipAndCrew().getCrewList().get(3)) + "</html>";
			} else {
				
				return "";
			}
		case "noFood": return "<html>" + "You have no food" + "<br>" + "to eat" +  "</html>";
		case "shipText": return "<html>" + "Days remaining: " + gameLogic.getRemainingDays() +  "<br>" + "<br>" + 
				 "Amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney() + "<br>" + "<br>" + 
				 "Number of Ship Parts remaining: " + gameLogic.getNumberOfPiecesRemaining() + "<br>" + "<br>" + 
				 "Ship Part found on this Planet: " + gameLogic.foundPartOnCurrentPlanet() + "<br>" + "<br>" + 
				 "Ship Health: " + gameLogic.getShipAndCrew().getShipHealth() + "%" + "</html>";
		default:
			return "None";
		}
			
	}
	public String getMemberTextUpdate(String switchStatement, String memberName, String itemName) {
		switch (switchStatement) {
		case "parts": return "<html>" + "Search for parts " + "</html>";
		case "repair": return "<html>" + "Repair the Ship" + "</html>";
		case "pilot": return "<html>" + "Pilot with Ship to a new planet with:" + "</html>";
		case "sleep": return "<html>" + "Sleep" + "</html>";
		case "eat": 
			if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
				return "<html>" + "Eat the following Food" + "</html>";
			} else {
				return "<html>" + "You have no food" + "<br>" + "to eat" +  "</html>";
			}
		case "useMedicine": 
			if (gameLogic.getShipAndCrew().getMedicalList().size() > 0) {
				return "<html>"+ "Apply Medical Item:" + "</html>";
			} else {
				return "<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>";
			}
		default:
			return null;
		}
	}
	public String getMemberChangeUpdate(String switchStatement, String memberName) {
		switch (switchStatement) {
		case "parts": return "<html>" + "Search for parts " + "</html>";
		case "repair": return "<html>" + "Repair the Ship" + "</html>";
		case "pilot": return "<html>" + "Pilot with Ship to a new planet with:" + "</html>";
		case "sleep": return "<html>" + "Sleep" + "</html>";
		default: return null;
		}
	}
}
