import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShipMenuScreen {
	private GameEnvironment gameLogic;
	private JFrame window;
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
		JLabel memberStatus1Label = new JLabel(getText("member1"));
		JLabel memberStatus2Label = new JLabel(getText("member2"));
		JLabel memberStatus3Label = new JLabel(getText("member3"));
		
		window = new JFrame();
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel currentDayLabel = new JLabel("Current Day: " + gameLogic.getCurrentDay());
		currentDayLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currentDayLabel.setBounds(0, 0, 98, 40);
		window.getContentPane().add(currentDayLabel);
		
		memberStatus1Label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		memberStatus1Label.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus1Label.setBounds(591, 11, 185, 130);
		window.getContentPane().add(memberStatus1Label);
		
		memberStatus2Label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		memberStatus2Label.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus2Label.setBounds(591, 149, 185, 130);
		window.getContentPane().add(memberStatus2Label);
		
		memberStatus3Label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		memberStatus3Label.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus3Label.setBounds(591, 288, 185, 130);
		window.getContentPane().add(memberStatus3Label);
		JLabel memberStatus4Label = new JLabel(getText("member4"));
		
		memberStatus4Label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		memberStatus4Label.setFont(new Font("Arial", Font.BOLD, 14));
		memberStatus4Label.setBounds(591, 428, 185, 130);
		window.getContentPane().add(memberStatus4Label);
		
		JLabel shipGreetingLabel = new JLabel("You are on board " + gameLogic.getShipAndCrew().getShipName());
		shipGreetingLabel.setFont(new Font("Arial", Font.BOLD, 18));
		shipGreetingLabel.setBounds(150, 0, 330, 113);
		window.getContentPane().add(shipGreetingLabel);
		
		JLabel shipStatusLabel = new JLabel(getText("shipText"));
		shipStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		shipStatusLabel.setBounds(45, 149, 269, 154);
		window.getContentPane().add(shipStatusLabel);
		
		JComboBox selectedMember = new JComboBox();
		selectedMember.setFont(new Font("Tahoma", Font.BOLD, 14));
		selectedMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		selectedMember.setMaximumRowCount(4);
		selectedMember.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMembersList().toArray()));
		selectedMember.setBounds(330, 263, 233, 46);
		window.getContentPane().add(selectedMember);
		
		JComboBox selectedFood = new JComboBox();
		selectedFood.setMaximumRowCount(6);
		selectedFood.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
		selectedFood.setBounds(14, 401, 165, 40);
		window.getContentPane().add(selectedFood);
		
		JComboBox selectedMedicine = new JComboBox();
		selectedMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		selectedMedicine.setMaximumRowCount(6);
		selectedMedicine.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicineList().toArray()));
		selectedMedicine.setBounds(211, 401, 166, 40);
		window.getContentPane().add(selectedMedicine);
		
		JComboBox selectedPilot = new JComboBox();
		selectedPilot.setFont(new Font("Tahoma", Font.BOLD, 10));
		selectedPilot.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMembersList().toArray()));
		selectedPilot.setMaximumRowCount(4);
		selectedPilot.setBounds(416, 401, 165, 40);
		window.getContentPane().add(selectedPilot);
		
		JButton applyMedicineButton = new JButton("<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>");
		applyMedicineButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		if (gameLogic.getShipAndCrew().getMedicineList().size() > 0) {
			applyMedicineButton.setText(getMemberTextUpdate("useMedicine", selectedMember.getSelectedItem().toString(), selectedMedicine.getSelectedItem().toString())); 
		}
		applyMedicineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((CrewMembers) selectedMember.getSelectedItem()).getRemainingActions() >= 1 && gameLogic.getShipAndCrew().getMedicineList().size() >= 1) {
					// called once here!!!!
					JOptionPane.showMessageDialog(null, gameLogic.applyMedicine(((MedicalItems) selectedMedicine.getSelectedItem()), ((CrewMembers) selectedMember.getSelectedItem())));
					selectedMedicine.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicineList().toArray()));
					memberStatus1Label.setText(getText("member1"));
					memberStatus2Label.setText(getText("member2"));
					memberStatus3Label.setText(getText("member3"));
					memberStatus4Label.setText(getText("member4"));
					shipStatusLabel.setText(getText("shipText"));
					if (gameLogic.getShipAndCrew().getMedicineList().size() > 0) {
						applyMedicineButton.setText("<html>" + "Apply Medical Item:");
					} else {
						applyMedicineButton.setText("<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>");
					}
				} else {
					if (gameLogic.getShipAndCrew().getMedicineList().size() == 0) {
						JOptionPane.showMessageDialog(null, "Your have no medicine to apply in your inventory");
					} else {
						JOptionPane.showMessageDialog(null, ((CrewMembers) selectedMember.getSelectedItem()).toString() + " has no actions remaining");
					}
				}
			}
		});
		applyMedicineButton.setBounds(211, 320, 165, 70);
		window.getContentPane().add(applyMedicineButton);
		
		JButton eatFoodButton = new JButton("<html>" + "You have no food" + "<br>" + "to eat" +  "</html>");
		eatFoodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((CrewMembers) selectedMember.getSelectedItem()).getRemainingActions() >= 1 && gameLogic.getShipAndCrew().getFoodList().size() >= 1) {
					if ((boolean) gameLogic.feed(((FoodItems) selectedFood.getSelectedItem()), ((CrewMembers) selectedMember.getSelectedItem()))) {
						JOptionPane.showMessageDialog(null, ((CrewMembers) selectedMember.getSelectedItem()).toString() + " is now less hungry");
						((CrewMembers) selectedMember.getSelectedItem()).setRemainingActions(((CrewMembers) selectedMember.getSelectedItem()).getRemainingActions()-1);
						selectedFood.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
						memberStatus1Label.setText(getText("member1"));
						memberStatus2Label.setText(getText("member2"));
						memberStatus3Label.setText(getText("member3"));
						memberStatus4Label.setText(getText("member4"));
						shipStatusLabel.setText(getText("shipText"));
						if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
							eatFoodButton.setText("<html>" + "Eat the following Food" + "</html>");
						} else {
							eatFoodButton.setText(getText("noFood"));
						}
					} else {
						JOptionPane.showMessageDialog(null, ((CrewMembers) selectedMember.getSelectedItem()).toString() + " is not hungry enough to eat");
					}
				} else {
					if (gameLogic.getShipAndCrew().getFoodList().size() == 0) {
						JOptionPane.showMessageDialog(null, "Your have no food to eat in your inventory");
					} else {
						JOptionPane.showMessageDialog(null, ((CrewMembers) selectedMember.getSelectedItem()).toString() + " has no actions remaining");
					}
				}
			}
		});
		eatFoodButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
			eatFoodButton.setText("<html>" + "Eat the following Food" +  "</html>");
		}
		eatFoodButton.setBounds(14, 320, 165, 70);
		window.getContentPane().add(eatFoodButton);
		
		JButton sleepButton = new JButton(getMemberChangeUpdate("sleep",  selectedMember.getSelectedItem().toString()));
		sleepButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		sleepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, gameLogic.memberSleep(((CrewMembers) selectedMember.getSelectedItem())));
					memberStatus1Label.setText(getText("member1"));
					memberStatus2Label.setText(getText("member2"));
					memberStatus3Label.setText(getText("member3"));
					memberStatus4Label.setText(getText("member4"));
					shipStatusLabel.setText(getText("shipText"));
			}
		});
		sleepButton.setBounds(416, 482, 165, 70);
		window.getContentPane().add(sleepButton);
		
		JButton repairShipButton = new JButton(getMemberChangeUpdate("repair",  selectedMember.getSelectedItem().toString()));
		repairShipButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		repairShipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,gameLogic.repairShip((CrewMembers) selectedMember.getSelectedItem())); 
					memberStatus1Label.setText(getText("member1"));
					memberStatus2Label.setText(getText("member2"));
					memberStatus3Label.setText(getText("member3"));
					memberStatus4Label.setText(getText("member4"));
					shipStatusLabel.setText(getText("shipText"));
			}
		});
		repairShipButton.setBounds(211, 482, 165, 70);
		window.getContentPane().add(repairShipButton);
		
		JButton visitOutpostButton = new JButton("Visit Nearest Outpost");
		visitOutpostButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		visitOutpostButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		visitOutpostButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
				gameLogic.launchOutpostOptionScreen();
			}
		});
		visitOutpostButton.setBounds(318, 100, 211, 46);
		window.getContentPane().add(visitOutpostButton);
		
		JButton pilotShipWithButton = new JButton(getMemberChangeUpdate("pilot",  selectedMember.getSelectedItem().toString()));
		pilotShipWithButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		pilotShipWithButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedMember.getSelectedItem() != selectedPilot.getSelectedItem()) {
					if (((CrewMembers) selectedMember.getSelectedItem()).getRemainingActions() >= 1 && ((CrewMembers) selectedPilot.getSelectedItem()).getRemainingActions() >= 1) {
						if (gameLogic.newPlanet((CrewMembers) selectedMember.getSelectedItem(), (CrewMembers) selectedPilot.getSelectedItem())) {
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
				memberStatus1Label.setText(getText("member1"));
				memberStatus2Label.setText(getText("member2"));
				memberStatus3Label.setText(getText("member3"));
				memberStatus4Label.setText(getText("member4"));
				shipStatusLabel.setText(getText("shipText"));
			}
		});
		pilotShipWithButton.setBounds(416, 320, 165, 70);
		window.getContentPane().add(pilotShipWithButton);
		
		JButton searchPartsButton = new JButton(getMemberChangeUpdate("parts",  selectedMember.getSelectedItem().toString()));
		searchPartsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		searchPartsButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchPartsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// search for parts is true;
				JOptionPane.showMessageDialog(null, ((CrewMembers) selectedMember.getSelectedItem()).toString() + gameLogic.searchForParts(((CrewMembers) selectedMember.getSelectedItem())));
				if (gameLogic.getNumberOfPiecesRemaining() <= 0) {
					if (gameLogic.isGameOver()) {
						finishedWindowEndGame();
					}
				}
				memberStatus1Label.setText(getText("member1"));
				memberStatus2Label.setText(getText("member2"));
				memberStatus3Label.setText(getText("member3"));
				memberStatus4Label.setText(getText("member4"));
				shipStatusLabel.setText(getText("shipText"));
				selectedFood.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
				selectedMedicine.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicineList().toArray()));
				if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
					eatFoodButton.setText("<html>" + "Eat the following Food" + "</html>");
				} else {
					eatFoodButton.setText(getText("noFood"));
				}
				if (gameLogic.getShipAndCrew().getMedicineList().size() > 0) {
					applyMedicineButton.setText("<html>" + "Apply Medical Item:");
				} else {
					applyMedicineButton.setText("<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>");
				}
				
			}
		});
		searchPartsButton.setBounds(14, 482, 165, 70);
		window.getContentPane().add(searchPartsButton);
		
		JButton proceedNextDayButton = new JButton("Proceed to next day");
		proceedNextDayButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		proceedNextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		proceedNextDayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// maybe change to have it do set remaining days before the if statement
				gameLogic.newDayChanges();
				// WILL HAVE TO CHANGE
				JOptionPane.showMessageDialog(null, "<html>" + "You are now on Day: " + gameLogic.getCurrentDay() + "<br>" + 
				gameLogic.newDayEvent() + "<br>" + "Your Crew Members are now more hungry, tired and have less health" + "<br>" + gameLogic.removeDeadCrewMembers() + "<br" + 
				gameLogic.removeActionsTired() + "<br>" + gameLogic.removeActionsSleepy() + "</html>");
				if (!gameLogic.isGameOver()) {
					selectedFood.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getFoodList().toArray()));
					selectedMedicine.setModel(new DefaultComboBoxModel(gameLogic.getShipAndCrew().getMedicineList().toArray()));
					memberStatus1Label.setText(getText("member1"));
					memberStatus2Label.setText(getText("member2"));
					memberStatus3Label.setText(getText("member3"));
					memberStatus4Label.setText(getText("member4"));
					shipStatusLabel.setText(getText("shipText"));
					if (gameLogic.getShipAndCrew().getFoodList().size() > 0) {
						eatFoodButton.setText("<html>" + "Eat the following Food" + "</html>");
					} else {
						eatFoodButton.setText(getText("noFood"));
					}
					if (gameLogic.getShipAndCrew().getMedicineList().size() > 0) {
						applyMedicineButton.setText("<html>" + "Apply Medical Item:");
					} else {
						applyMedicineButton.setText("<html>" + "You have no" + "<br>" + "medicine to use" +  "</html>");
					}
				} else {
					finishedWindowEndGame();
				}
				currentDayLabel.setText("Current Day: " + gameLogic.getCurrentDay());
				//terminate() and launch it again or make new thing called relaunch
				
			}
		});
		proceedNextDayButton.setBounds(96, 100, 211, 46);
		window.getContentPane().add(proceedNextDayButton);
		
		JLabel performingActionsLabel = new JLabel("<html>" + "Performing Actions for the" +"<br>" + "following Crew Member:" + "<html>");
		performingActionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		performingActionsLabel.setBounds(330, 186, 199, 75);
		window.getContentPane().add(performingActionsLabel);
	
	}
	public String getText(String switchStatement) {
		switch (switchStatement) {
		case "member1":
			if (gameLogic.getShipAndCrew().getMembersList().size() >= 1) {
				return "<html>" + gameLogic.getShipAndCrew().getMembersList().get(0).toString() + "<br>" +
						"Health " + gameLogic.getShipAndCrew().getMembersList().get(0).getHealthLevel() + "%" + "<br>" +
						"Hunger " + gameLogic.getShipAndCrew().getMembersList().get(0).getHungerLevel() + "%" +  "<br>" +
						"Tiredness " + gameLogic.getShipAndCrew().getMembersList().get(0).getTirednessLevel() + "%" + "<br>" +
						"Remaining Actions " + gameLogic.getShipAndCrew().getMembersList().get(0).getRemainingActions() + "<br>" + 
						"Space Plague Status: " + gameLogic.spacePlagueYesNo(gameLogic.getShipAndCrew().getMembersList().get(0)) + "</html>";
			}
		case "member2":
			if (gameLogic.getShipAndCrew().getMembersList().size() >= 2) {
				return "<html>" + gameLogic.getShipAndCrew().getMembersList().get(1).toString() + "<br>" +
						"Health " + gameLogic.getShipAndCrew().getMembersList().get(1).getHealthLevel() + "%" + "<br>" +
						"Hunger " + gameLogic.getShipAndCrew().getMembersList().get(1).getHungerLevel() + "%" + "<br>" +
						"Tiredness " + gameLogic.getShipAndCrew().getMembersList().get(1).getTirednessLevel() + "%" +  "<br>" +
						"Remaining Actions " + gameLogic.getShipAndCrew().getMembersList().get(1).getRemainingActions() + "<br>" + 
						"Space Plague Status: " + gameLogic.spacePlagueYesNo(gameLogic.getShipAndCrew().getMembersList().get(1)) + "</html>";
			}
		case "member3":
			if (gameLogic.getShipAndCrew().getMembersList().size() >= 3) {
				return "<html>" + gameLogic.getShipAndCrew().getMembersList().get(2).toString() + "<br>" +
						"Health " + gameLogic.getShipAndCrew().getMembersList().get(2).getHealthLevel() + "%" + "<br>" +
						"Hunger " + gameLogic.getShipAndCrew().getMembersList().get(2).getHungerLevel() + "%" + "<br>" +
						"Tiredness " + gameLogic.getShipAndCrew().getMembersList().get(2).getTirednessLevel() + "%" + "<br>" +
						"Remaining Actions " + gameLogic.getShipAndCrew().getMembersList().get(2).getRemainingActions() + "<br>" + 
						"Space Plague Status: " + gameLogic.spacePlagueYesNo(gameLogic.getShipAndCrew().getMembersList().get(2)) + "</html>";
			} else {
				return "";
			}
		case "member4":
			if (gameLogic.getShipAndCrew().getMembersList().size() == 4) {
				return "<html>" + gameLogic.getShipAndCrew().getMembersList().get(3).toString() + "<br>" +
						"Health " + gameLogic.getShipAndCrew().getMembersList().get(3).getHealthLevel() + "%" + "<br>" +
						"Hunger " + gameLogic.getShipAndCrew().getMembersList().get(3).getHungerLevel() + "%" + "<br>" +
						"Tiredness " + gameLogic.getShipAndCrew().getMembersList().get(3).getTirednessLevel() + "%" + "<br>" +
						"Remaining Actions " + gameLogic.getShipAndCrew().getMembersList().get(3).getRemainingActions() + "<br>" + 
						"Space Plague Status: " + gameLogic.spacePlagueYesNo(gameLogic.getShipAndCrew().getMembersList().get(3)) + "</html>";
			} else {
				
				return "";
			}
		case "noFood": return "<html>" + "You have no food" + "<br>" + "to eat" +  "</html>";
		case "shipText": return "<html>" + "Days remaining: " + gameLogic.getRemainingDays() +  "<br>" + "<br>" + 
				 "Amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney() + "<br>" + "<br>" + 
				 "Number of Ship Parts remaining: " + gameLogic.getNumberOfPiecesRemaining() + "<br>" + "<br>" + 
				 "Ship Part found on this Planet: " + gameLogic.foundPartOnPlanetYesNo() + "<br>" + "<br>" + 
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
			if (gameLogic.getShipAndCrew().getMedicineList().size() > 0) {
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
