import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SetupScreen {
	private GameEnvironment gameLogic;
	/*
	 * 	try {
			crewInput1.setText(gameLogic.getShipAndCrew().getCrewList().get(0).toString());
		} catch (java.lang.IndexOutOfBoundsException e) {

        }
	 */
	private JFrame window;
	private JTextField shipNameInput;
	private JButton selectedMember1;
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
	public void terminate() {
		gameLogic.closeSetupScreen(this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel welcomelbl = new JLabel("Welcome to Space game idfk");
		welcomelbl.setFont(new Font("Arial", Font.PLAIN, 18));
		welcomelbl.setBounds(26, 11, 315, 39);
		window.getContentPane().add(welcomelbl);
		
		JLabel numDayslbl = new JLabel("How many days would you like to play?");
		numDayslbl.setFont(new Font("Arial", Font.PLAIN, 18));
		numDayslbl.setBounds(26, 129, 324, 23);
		window.getContentPane().add(numDayslbl);
		
		JSlider daysInputSlider = new JSlider();
		daysInputSlider.setPaintLabels(true);
		daysInputSlider.setMajorTickSpacing(1);
		daysInputSlider.setMaximum(10);
		daysInputSlider.setMinimum(3);
		daysInputSlider.setSnapToTicks(true);
		daysInputSlider.setPaintTicks(true);
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
		selectedMember1.setBounds(46, 477, 125, 65);
		window.getContentPane().add(selectedMember1);
		
		JButton selectedMember2 = new JButton("");
		selectedMember2.setBounds(197, 477, 125, 65);
		window.getContentPane().add(selectedMember2);
		
		JButton selectedMember3 = new JButton("");
		selectedMember3.setBounds(351, 477, 125, 65);
		window.getContentPane().add(selectedMember3);
		
		JButton selectedMember4 = new JButton("");
		selectedMember4.setBounds(500, 477, 125, 65);
		window.getContentPane().add(selectedMember4);
		
		JLabel memberStats = new JLabel("Member Stats");
		memberStats.setVerticalAlignment(SwingConstants.TOP);
		memberStats.setBounds(543, 202, 185, 187);
		window.getContentPane().add(memberStats);
		
		JButton crewType1bttn = new JButton("The Medic");
		crewType1bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (gameLogic.getDeque().size() <= 3) {
					gameLogic.getDeque().add(gameLogic.getClassList().get(0	));
					// ^^ adds to end of the deque
					switch(gameLogic.getDeque().size()) {
					case 1: selectedMember1.setText(gameLogic.getDeque().getLast().toString());
						break;
					case 2: selectedMember2.setText(gameLogic.getDeque().getLast().toString());
						break;
					case 3: selectedMember3.setText(gameLogic.getDeque().getLast().toString());
						break;
					case 4: selectedMember4.setText(gameLogic.getDeque().getLast().toString());
						break;
						
					}
				}
			}
		});
		crewType1bttn.setBounds(46, 217, 125, 80);
		window.getContentPane().add(crewType1bttn);
		// have it so everytime u click on thing it gets a deque from 
		// gameLogic and sets all the texts from selected == to index
		
		JButton crewType2bttn = new JButton("The Thief");
		crewType2bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (gameLogic.getDeque().size() <= 3) {
					gameLogic.getDeque().add(gameLogic.getClassList().get(2));
					//index two si the thief
					// ^^ adds to end of the deque
					switch(gameLogic.getDeque().size()) {
					case 1: selectedMember1.setText(gameLogic.getDeque().getLast().toString());
						break;
					case 2: selectedMember2.setText(gameLogic.getDeque().getLast().toString());
						break;
					case 3: selectedMember3.setText(gameLogic.getDeque().getLast().toString());
						break;
					case 4: selectedMember4.setText(gameLogic.getDeque().getLast().toString());
						break;
						
					}
				}
			}
		});
		crewType2bttn.setBounds(197, 217, 125, 80);
		window.getContentPane().add(crewType2bttn);
		
		JButton crewType3bttn = new JButton("The Haggler");
		crewType3bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (gameLogic.getDeque().size() <= 3) {
					gameLogic.getDeque().add(gameLogic.getClassList().get(1));
					// ^^ adds to end of the deque
					switch(gameLogic.getDeque().size()) {
					case 1: selectedMember1.setText(gameLogic.getDeque().getLast().toString());
						break;
					case 2: selectedMember2.setText(gameLogic.getDeque().getLast().toString());
						break;
					case 3: selectedMember3.setText(gameLogic.getDeque().getLast().toString());
						break;
					case 4: selectedMember4.setText(gameLogic.getDeque().getLast().toString());
						break;
						
					}
				}
			}
		});
		crewType3bttn.setBounds(356, 217, 125, 80);
		window.getContentPane().add(crewType3bttn);
		
		JButton crewType4bttn = new JButton("");
		crewType4bttn.setBounds(46, 320, 125, 80);
		window.getContentPane().add(crewType4bttn);
		
		JButton crewType5bttn = new JButton("");
		crewType5bttn.setBounds(197, 320, 125, 80);
		window.getContentPane().add(crewType5bttn);
		
		JButton crewType6bttn = new JButton("");
		crewType6bttn.setBounds(357, 320, 125, 80);
		window.getContentPane().add(crewType6bttn);
		
		JLabel lblSelected = new JLabel("Selected:");
		lblSelected.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSelected.setBounds(46, 442, 109, 29);
		window.getContentPane().add(lblSelected);
		
		JButton btnDeque = new JButton("Deque");
		btnDeque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (gameLogic.getDeque().size() > 0 && gameLogic.getDeque().size() <= 4) {
					switch(gameLogic.getDeque().size()) {
					case 1: selectedMember1.setText("");
					gameLogic.getDeque().removeLast();
					break;
					case 2: selectedMember2.setText("");
					gameLogic.getDeque().removeLast();
					break;
					case 3: selectedMember3.setText("");
					gameLogic.getDeque().removeLast();
					break;
					case 4: selectedMember4.setText("");
					gameLogic.getDeque().removeLast();
					break;
					}
				}
			}
		});
		btnDeque.setBounds(519, 443, 89, 23);
		window.getContentPane().add(btnDeque);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (gameLogic.getDeque().size() >= 2) {
					for (CrewMembersMainClass i: gameLogic.getDeque()) {
						gameLogic.getShipAndCrew().addCrewMember(i);
					}
					
					System.out.println(gameLogic.getShipAndCrew().getCrewList());
					gameLogic.getShipAndCrew().setShipName(shipNameInput.getText());
					gameLogic.setRemainingDays(daysInputSlider.getValue());
					terminate();
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(663, 482, 91, 50);
		window.getContentPane().add(btnNewButton);
		
	}
}
