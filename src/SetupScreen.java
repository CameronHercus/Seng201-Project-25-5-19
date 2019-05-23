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
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupScreen {
	private GameEnvironment gameLogic;
	ArrayDeque<String> stringDeque = new ArrayDeque<String>();

	private JFrame window;
	private JTextField shipNameInput;
	private JTextField selectedNameInput1;
	private JTextField selectedNameInput2;
	private JTextField selectedNameInput3;
	private JTextField selectedNameInput4;
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
		
		JLabel welcomelbl = new JLabel("Welcome to Space game ");
		welcomelbl.setFont(new Font("Arial", Font.PLAIN, 18));
		welcomelbl.setBounds(26, 11, 315, 39);
		window.getContentPane().add(welcomelbl);
		
		JLabel numDayslbl = new JLabel("How many days would you like to play?");
		numDayslbl.setFont(new Font("Arial", Font.PLAIN, 18));
		numDayslbl.setBounds(26, 129, 324, 23);
		window.getContentPane().add(numDayslbl);
		
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
		
		shipNameInput = new JTextField();
		shipNameInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		shipNameInput.setBounds(371, 73, 296, 29);
		window.getContentPane().add(shipNameInput);
		shipNameInput.setColumns(10);
		
		JButton selectedMember1 = new JButton("");
		selectedMember1.setBounds(46, 436, 131, 65);
		window.getContentPane().add(selectedMember1);
		
		JButton selectedMember2 = new JButton("");
		selectedMember2.setBounds(197, 436, 131, 65);
		window.getContentPane().add(selectedMember2);
		
		JButton selectedMember3 = new JButton("");
		selectedMember3.setBounds(356, 436, 131, 65);
		window.getContentPane().add(selectedMember3);
		
		JButton selectedMember4 = new JButton("");
		selectedMember4.setBounds(508, 436, 131, 65);
		window.getContentPane().add(selectedMember4);
		
		JLabel memberStats = new JLabel("Member Stats");
		memberStats.setFont(new Font("Tahoma", Font.PLAIN, 13));
		memberStats.setVerticalAlignment(SwingConstants.TOP);
		memberStats.setBounds(508, 232, 235, 145);
		window.getContentPane().add(memberStats);
		
		JButton crewType1bttn = new JButton("The Medic");
		crewType1bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Medic");
					switch(stringDeque.size()) {
					case 1: selectedMember1.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStats.setText("<html>" + "Member Stats: The Medic" + "<br>" + "<br>" +"Health: 100%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Adds Medkit to inventory at start of the game" + "</html>");
				
			}
		});
		crewType1bttn.setBounds(46, 217, 131, 80);
		window.getContentPane().add(crewType1bttn);
		JButton crewType2bttn = new JButton("The Thief");
		crewType2bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Thief");
					// ^^ adds to end of the deque
					switch(stringDeque.size()) {
					case 1: selectedMember1.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStats.setText("<html>" + "Member Stats: The Thief" + "<br>" + "<br>" +"Health: 100%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Adds Corned Beef to inventory at the start of the game" + "</html>");
			}
		});
		crewType2bttn.setBounds(197, 217, 131, 80);
		window.getContentPane().add(crewType2bttn);
		
		JButton crewType3bttn = new JButton("The Haggler");
		crewType3bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Haggler");
					// ^^ adds to end of the deque
					switch(stringDeque.size()) {
					case 1: selectedMember1.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStats.setText("<html>" + "Member Stats: The Haggler" + "<br>" + "<br>" +"Health: 100%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Adds $20 to inventory at the start of the game" + "</html>");
			}
		});
		crewType3bttn.setBounds(356, 217, 131, 80);
		window.getContentPane().add(crewType3bttn);
		
		JButton crewType4bttn = new JButton("The Juggernaut");
		crewType4bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStats.setText("<html>" + "Member Stats: The Juggernaut" + "<br>" + "<br>" +"Health: 125%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Has 125% health" + "</html>");
			}
		});
		crewType4bttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Juggernaut");
					switch(stringDeque.size()) {
					case 1: selectedMember1.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
		});
		crewType4bttn.setBounds(46, 320, 131, 80);
		window.getContentPane().add(crewType4bttn);
		
		JButton crewType5bttn = new JButton("The Archeologist");
		crewType5bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStats.setText("<html>" + "Member Stats: The Archeologist" + "<br>" + "<br>" +"Health: 100%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Chance of finding a large amount of money when searching" + "</html>");
			}
		});
		crewType5bttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Archeologist");
					switch(stringDeque.size()) {
					case 1: selectedMember1.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
		});
		crewType5bttn.setBounds(197, 320, 131, 80);
		window.getContentPane().add(crewType5bttn);
		
		JButton crewType6bttn = new JButton("The Engineer");
		crewType6bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				memberStats.setText("<html>" + "Member Stats: The Engineer" + "<br>" + "<br>" +"Health: 100%" + "<br>" + "Tiredness: 0%" + "<br>" + "Hunger: 0%" + "<br>" + "Skill: Good at repairing the Ship" + "</html>");
			}
		});
		crewType6bttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stringDeque.size() <= 3) {
					stringDeque.add("The Engineer");
					switch(stringDeque.size()) {
					case 1: selectedMember1.setText(stringDeque.getLast());
						break;
					case 2: selectedMember2.setText(stringDeque.getLast());
						break;
					case 3: selectedMember3.setText(stringDeque.getLast());
						break;
					case 4: selectedMember4.setText(stringDeque.getLast());
						break;
						
					}
				}
			}
		});
		crewType6bttn.setBounds(357, 320, 131, 80);
		window.getContentPane().add(crewType6bttn);
		
		JLabel lblSelected = new JLabel("Selected:");
		lblSelected.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSelected.setBounds(46, 411, 109, 29);
		window.getContentPane().add(lblSelected);
		
		JButton btnDeque = new JButton("<html>" + "Remove" + "<br>" + "last Member" + "</html>");
		btnDeque.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (stringDeque.size() > 0 && stringDeque.size() <= 4) {
					switch(stringDeque.size()) {
					case 1: selectedMember1.setText("");
					stringDeque.removeLast();
					break;
					case 2: selectedMember2.setText("");
					stringDeque.removeLast();
					break;
					case 3: selectedMember3.setText("");
					stringDeque.removeLast();
					break;
					case 4: selectedMember4.setText("");
					stringDeque.removeLast();
					break;
					}
				}
			}
		});
		btnDeque.setBounds(648, 451, 109, 50);
		window.getContentPane().add(btnDeque);
		
		selectedNameInput1 = new JTextField();
		selectedNameInput1.setText("Enter Name");
		selectedNameInput1.setBounds(46, 512, 130, 20);
		window.getContentPane().add(selectedNameInput1);
		selectedNameInput1.setColumns(10);
		
		selectedNameInput2 = new JTextField();
		selectedNameInput2.setText("Enter Name");
		selectedNameInput2.setColumns(10);
		selectedNameInput2.setBounds(197, 512, 130, 20);
		window.getContentPane().add(selectedNameInput2);
		
		selectedNameInput3 = new JTextField();
		selectedNameInput3.setText("Enter Name");
		selectedNameInput3.setColumns(10);
		selectedNameInput3.setBounds(356, 512, 130, 20);
		window.getContentPane().add(selectedNameInput3);
		
		selectedNameInput4 = new JTextField();
		selectedNameInput4.setText("Enter Name");
		selectedNameInput4.setColumns(10);
		selectedNameInput4.setBounds(508, 512, 130, 20);
		window.getContentPane().add(selectedNameInput4);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//CHECK ERRORS HERE LIKE CHECK ALL NAMES IN SIZZE ARRAYDEQUE ARE FILLED BY NOT ENTER NAME AND CHECK SHIP HAS NAME
				if (stringDeque.size() >= 2 && shipNameInput.getText().length() >= 1) {
					int i =0;
					for (String j: stringDeque) {
						i += 1;
						switch (i) {
						case 1: addCrewMember(j, selectedNameInput1.getText());
						break;
						case 2: addCrewMember(j, selectedNameInput2.getText());
						break;
						case 3: addCrewMember(j, selectedNameInput3.getText());
						break; 
						case 4: addCrewMember(j, selectedNameInput4.getText());
						break;
						}
					}
					for (CrewMembersMainClass l: gameLogic.getShipAndCrew().getCrewList()) {
						if (l instanceof Haggler) {
							gameLogic.getShipAndCrew().setAmountMoney(gameLogic.getShipAndCrew().getAmountMoney()+20);
						} else if (l instanceof Medic) {
							gameLogic.getShipAndCrew().getMedicalList().add(new MedKit());
						} else if(l instanceof Thief) {
							gameLogic.getShipAndCrew().getFoodList().add(new CornedBeef());
						}
					}
					gameLogic.getShipAndCrew().setShipName(shipNameInput.getText());
					gameLogic.setRemainingDays(daysInputSlider.getValue());
					gameLogic.setNumberOfPiecesRemaining((int) (Math.floor(gameLogic.getRemainingDays() * (float) 2/3)));
					gameLogic.setInitialNumberOfPieces((int) (Math.floor(gameLogic.getRemainingDays() * (float) 2/3)));
					finishedWindow();
				} else {
					JOptionPane.showMessageDialog(null, "You must chose a ship name and select a minimum of 2 crew members with names to proceed");
				}

					
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(649, 521, 125, 29);
		window.getContentPane().add(btnNewButton);
		
	}
	public void addCrewMember(String memberClass, String memberName) {
		// PUT IN GAME LOGIC
			switch(memberClass) {
			case"The Medic": gameLogic.getShipAndCrew().addCrewMember(new Medic(memberName));
			break;
			case"The Thief": gameLogic.getShipAndCrew().addCrewMember(new Thief(memberName));
			break;
			case"The Haggler": gameLogic.getShipAndCrew().addCrewMember(new Haggler(memberName));
			break;
			case"The Engineer": gameLogic.getShipAndCrew().addCrewMember(new Engineer(memberName));
				break;
			case"The Archeologist": gameLogic.getShipAndCrew().addCrewMember(new Archeologist(memberName));
				break;
			case"The Juggernaut": gameLogic.getShipAndCrew().addCrewMember(new Juggernaut(memberName));
				break;
			default:
				break;
			}
		
	}
}
