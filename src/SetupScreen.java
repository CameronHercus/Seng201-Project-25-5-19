import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupScreen {
	private GameEnvironment gameLogic;
	ArrayDeque<String> stringDeque = new ArrayDeque<String>();

	private JFrame window;
	private JTextField shipNameTextField;
	private JTextField selectedName1TextField;
	private JTextField selectedName2TextField;
	private JTextField selectedName3TextField;
	private JTextField selectedNameInput4;
	private boolean proceed = false;
	public static void main(String[] args) {
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public SetupScreen(GameEnvironment incomingGameEnvironment) {
		gameLogic = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		gameLogic.closeSetupScreen(this);
	}
	private void initialize() {
		window = new JFrame();
		window.setTitle("Setup Screen");
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to The Space Explorer game ");
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		welcomeLabel.setBounds(26, 11, 315, 39);
		window.getContentPane().add(welcomeLabel);
		
		JLabel numberDaysPromptLabel = new JLabel("How many days would you like to play?");
		numberDaysPromptLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		numberDaysPromptLabel.setBounds(26, 129, 324, 23);
		window.getContentPane().add(numberDaysPromptLabel);
		
		JLabel selectedPromptLabel = new JLabel("Selected:");
		selectedPromptLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		selectedPromptLabel.setBounds(46, 411, 109, 29);
		window.getContentPane().add(selectedPromptLabel);
		
		JSlider daysInputSlider = new JSlider();
		daysInputSlider.setPaintTicks(true);
		daysInputSlider.setPaintLabels(true);
		daysInputSlider.setMajorTickSpacing(1);
		daysInputSlider.setMaximum(10);
		daysInputSlider.setMinimum(3);
		daysInputSlider.setBounds(371, 115, 296, 50);
		window.getContentPane().add(daysInputSlider);
		
		JLabel nameShiplbl = new JLabel("Enter the name of your Starship:\r\n");
		nameShiplbl.setFont(new Font("Arial", Font.PLAIN, 18));
		nameShiplbl.setBounds(26, 75, 281, 23);
		window.getContentPane().add(nameShiplbl);
		
		shipNameTextField = new JTextField();
		shipNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		shipNameTextField.setBounds(371, 73, 296, 29);
		window.getContentPane().add(shipNameTextField);
		shipNameTextField.setColumns(10);
		
		JButton selectedMember1Button = new JButton("");
		selectedMember1Button.setBounds(46, 436, 131, 65);
		window.getContentPane().add(selectedMember1Button);
		
		JButton selectedMember2Button = new JButton("");
		selectedMember2Button.setBounds(197, 436, 131, 65);
		window.getContentPane().add(selectedMember2Button);
		
		JButton selectedMember3Button = new JButton("");
		selectedMember3Button.setBounds(356, 436, 131, 65);
		window.getContentPane().add(selectedMember3Button);
		
		JButton selectedMember4Button = new JButton("");
		selectedMember4Button.setBounds(508, 436, 131, 65);
		window.getContentPane().add(selectedMember4Button);
		
		JLabel memberStatsLabel = new JLabel("Member Stats");
		memberStatsLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		memberStatsLabel.setVerticalAlignment(SwingConstants.TOP);
		memberStatsLabel.setBounds(508, 232, 235, 145);
		window.getContentPane().add(memberStatsLabel);
		
		JButton crewTheMedicButton = new JButton("The Medic");
		crewTheMedicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Medic");
					switch(stringDeque.size()) {
					case 1: selectedMember1Button.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2Button.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3Button.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4Button.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
		});
		crewTheMedicButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStatsLabel.setText("<html>" + "Member Stats: The Medic" + "<br>" + "<br>" +"Health: 100%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Adds Medkit to inventory at start of the game" + "</html>");
				
			}
		});
		crewTheMedicButton.setBounds(46, 217, 131, 80);
		window.getContentPane().add(crewTheMedicButton);
		JButton crewTheThiefButton = new JButton("The Thief");
		crewTheThiefButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Thief");
					// ^^ adds to end of the deque
					switch(stringDeque.size()) {
					case 1: selectedMember1Button.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2Button.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3Button.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4Button.setText(stringDeque.getLast());
						break;
					}
				}
			}
		});
		crewTheThiefButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStatsLabel.setText("<html>" + "Member Stats: The Thief" + "<br>" + "<br>" +"Health: 100%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Adds Corned Beef to inventory at the start of the game" + "</html>");
			}
		});
		crewTheThiefButton.setBounds(197, 217, 131, 80);
		window.getContentPane().add(crewTheThiefButton);
		
		JButton crewTheHagglerButton = new JButton("The Haggler");
		crewTheHagglerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Haggler");
					// ^^ adds to end of the deque
					switch(stringDeque.size()) {
					case 1: selectedMember1Button.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2Button.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3Button.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4Button.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
		});
		crewTheHagglerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStatsLabel.setText("<html>" + "Member Stats: The Haggler" + "<br>" + "<br>" +"Health: 100%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Adds $20 to inventory at the start of the game" + "</html>");
			}
		});
		crewTheHagglerButton.setBounds(356, 217, 131, 80);
		window.getContentPane().add(crewTheHagglerButton);
		
		JButton crewTheJuggernautButton = new JButton("The Juggernaut");
		crewTheJuggernautButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStatsLabel.setText("<html>" + "Member Stats: The Juggernaut" + "<br>" + "<br>" +"Health: 125%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Has 125% health" + "</html>");
			}
		});
		crewTheJuggernautButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Juggernaut");
					switch(stringDeque.size()) {
					case 1: selectedMember1Button.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2Button.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3Button.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4Button.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
		});
		crewTheJuggernautButton.setBounds(46, 320, 131, 80);
		window.getContentPane().add(crewTheJuggernautButton);
		
		JButton crewTheArcheologistButton = new JButton("The Archeologist");
		crewTheArcheologistButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStatsLabel.setText("<html>" + "Member Stats: The Archeologist" + "<br>" + "<br>" +"Health: 100%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Chance of finding a large amount of money when searching" + "</html>");
			}
		});
		crewTheArcheologistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Archeologist");
					switch(stringDeque.size()) {
					case 1: selectedMember1Button.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2Button.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3Button.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4Button.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
		});
		crewTheArcheologistButton.setBounds(197, 320, 131, 80);
		window.getContentPane().add(crewTheArcheologistButton);
		
		JButton crewTheEngineerButton = new JButton("The Engineer");
		crewTheEngineerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStatsLabel.setText("<html>" + "Member Stats: The Engineer" + "<br>" + "<br>" +"Health: 100%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Good at repairing the Ship" + "</html>");
			}
		});
		crewTheEngineerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Engineer");
					switch(stringDeque.size()) {
					case 1: selectedMember1Button.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2Button.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3Button.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4Button.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
		});
		crewTheEngineerButton.setBounds(357, 320, 131, 80);
		window.getContentPane().add(crewTheEngineerButton);
		
		JButton removeLastButton = new JButton("<html>" + "Remove" + "<br>" + "last Member" + "</html>");
		removeLastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() > 0 && stringDeque.size() <= 4) {
					switch(stringDeque.size()) {
					case 1: selectedMember1Button.setText("");
					stringDeque.removeLast();
					break;
					case 2: selectedMember2Button.setText("");
					stringDeque.removeLast();
					break;
					case 3: selectedMember3Button.setText("");
					stringDeque.removeLast();
					break;
					case 4: selectedMember4Button.setText("");
					stringDeque.removeLast();
					break;
					}
				}
			}
		});
		removeLastButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		removeLastButton.setBounds(648, 451, 109, 50);
		window.getContentPane().add(removeLastButton);
		
		selectedName1TextField = new JTextField();
		selectedName1TextField.setBounds(46, 512, 130, 20);
		window.getContentPane().add(selectedName1TextField);
		selectedName1TextField.setColumns(10);
		
		selectedName2TextField = new JTextField();
		selectedName2TextField.setColumns(10);
		selectedName2TextField.setBounds(197, 512, 130, 20);
		window.getContentPane().add(selectedName2TextField);
		
		selectedName3TextField = new JTextField();
		selectedName3TextField.setColumns(10);
		selectedName3TextField.setBounds(356, 512, 130, 20);
		window.getContentPane().add(selectedName3TextField);
		
		selectedNameInput4 = new JTextField();
		selectedNameInput4.setColumns(10);
		selectedNameInput4.setBounds(508, 512, 130, 20);
		window.getContentPane().add(selectedNameInput4);
		
		JButton acceptButton = new JButton("Accept");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() == 2) {
					if (selectedName1TextField.getText().length() <= 0 || selectedName2TextField.getText().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Please chose valid Character Names");
						proceed = false;
					} else {
						proceed = true;
					}
				}
				if (stringDeque.size() == 3) {
					if (selectedName1TextField.getText().length() <= 0 || selectedName2TextField.getText().length() <= 0 || selectedName3TextField.getText().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Please chose valid Character Names");
						proceed = false;
					} else {
						proceed = true;
					}
				}
				if (stringDeque.size() == 4) {
					if (selectedName1TextField.getText().length() <= 0 || selectedName2TextField.getText().length() <= 0 || selectedName3TextField.getText().length() <= 0 || selectedNameInput4.getText().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Please chose valid Character Names");
						proceed = false;
					} else {
						proceed = true;
					}
				}
				//CHECK ERRORS HERE LIKE CHECK ALL NAMES IN SIZZE ARRAYDEQUE ARE FILLED BY NOT ENTER NAME AND CHECK SHIP HAS NAME
				if (stringDeque.size() >= 2 && shipNameTextField.getText().length() >= 1 && proceed) {
					int i =0;
					for (String j: stringDeque) {
						i += 1;
						switch (i) {
						case 1: addCrewMember(j, selectedName1TextField.getText());
						break;
						case 2: addCrewMember(j, selectedName2TextField.getText());
						break;
						case 3: addCrewMember(j, selectedName3TextField.getText());
						break; 
						case 4: addCrewMember(j, selectedNameInput4.getText());
						break;
						}
					}
					for (CrewMembers l: gameLogic.getShipAndCrew().getMembersList()) {
						if (l instanceof Haggler) {
							gameLogic.getShipAndCrew().setAmountMoney(gameLogic.getShipAndCrew().getAmountMoney()+20);
						} else if (l instanceof Medic) {
							gameLogic.getShipAndCrew().getMedicineList().add(new MedKit());
						} else if(l instanceof Thief) {
							gameLogic.getShipAndCrew().getFoodList().add(new CornedBeef());
						}
					}
					gameLogic.getShipAndCrew().setShipName(shipNameTextField.getText());
					gameLogic.setRemainingDays(daysInputSlider.getValue());
					gameLogic.setNumberOfPiecesRemaining((int) (Math.floor(gameLogic.getRemainingDays() * (float) 2/3)));
					gameLogic.setInitialNumberOfPieces((int) (Math.floor(gameLogic.getRemainingDays() * (float) 2/3)));
					finishedWindow();
				} else {
					JOptionPane.showMessageDialog(null, "You must chose a ship name and select a minimum of 2 crew members with names to proceed");
				}
			}
		});

		acceptButton.setFont(new Font("Arial", Font.BOLD, 16));
		acceptButton.setBounds(649, 521, 125, 29);
		window.getContentPane().add(acceptButton);
		
	}
	public void addCrewMember(String memberClass, String memberName) {
			switch(memberClass) {
			case"The Medic": gameLogic.getShipAndCrew().getMembersList().add(new Medic(memberName));
			break;
			case"The Thief": gameLogic.getShipAndCrew().getMembersList().add(new Thief(memberName));
			break;
			case"The Haggler": gameLogic.getShipAndCrew().getMembersList().add(new Haggler(memberName));
			break;
			case"The Engineer": gameLogic.getShipAndCrew().getMembersList().add(new Engineer(memberName));
				break;
			case"The Archeologist": gameLogic.getShipAndCrew().getMembersList().add(new Archeologist(memberName));
				break;
			case"The Juggernaut": gameLogic.getShipAndCrew().getMembersList().add(new Juggernaut(memberName));
				break;
			default:
				break;
			}
		
	}
}
