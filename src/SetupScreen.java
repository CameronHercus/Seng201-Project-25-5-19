import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

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
		daysInputSlider.setSnapToTicks(true);
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
		selectedMember1.setBounds(46, 436, 125, 65);
		window.getContentPane().add(selectedMember1);
		
		JButton selectedMember2 = new JButton("");
		selectedMember2.setBounds(197, 436, 125, 65);
		window.getContentPane().add(selectedMember2);
		
		JButton selectedMember3 = new JButton("");
		selectedMember3.setBounds(356, 436, 125, 65);
		window.getContentPane().add(selectedMember3);
		
		JButton selectedMember4 = new JButton("");
		selectedMember4.setBounds(501, 436, 125, 65);
		window.getContentPane().add(selectedMember4);
		
		JLabel memberStats = new JLabel("Member Stats");
		memberStats.setVerticalAlignment(SwingConstants.TOP);
		memberStats.setBounds(543, 202, 185, 187);
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
		});
		crewType1bttn.setBounds(46, 217, 125, 80);
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
		});
		crewType2bttn.setBounds(197, 217, 125, 80);
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
		lblSelected.setBounds(46, 411, 109, 29);
		window.getContentPane().add(lblSelected);
		
		JButton btnDeque = new JButton("Deque");
		btnDeque.setFont(new Font("Tahoma", Font.BOLD, 14));
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
		btnDeque.setBounds(683, 450, 89, 39);
		window.getContentPane().add(btnDeque);
		
		selectedNameInput1 = new JTextField();
		selectedNameInput1.setText("Enter Name");
		selectedNameInput1.setBounds(46, 512, 125, 20);
		window.getContentPane().add(selectedNameInput1);
		selectedNameInput1.setColumns(10);
		
		selectedNameInput2 = new JTextField();
		selectedNameInput2.setText("Enter Name");
		selectedNameInput2.setColumns(10);
		selectedNameInput2.setBounds(197, 512, 125, 20);
		window.getContentPane().add(selectedNameInput2);
		
		selectedNameInput3 = new JTextField();
		selectedNameInput3.setText("Enter Name");
		selectedNameInput3.setColumns(10);
		selectedNameInput3.setBounds(356, 512, 125, 20);
		window.getContentPane().add(selectedNameInput3);
		
		selectedNameInput4 = new JTextField();
		selectedNameInput4.setText("Enter Name");
		selectedNameInput4.setColumns(10);
		selectedNameInput4.setBounds(501, 512, 125, 20);
		window.getContentPane().add(selectedNameInput4);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (String i: stringDeque) {
					switch(i) {
					case"The Medic": gameLogic.getShipAndCrew().addCrewMember(new Medic("bob"));
					break;
					case"The Thief": gameLogic.getShipAndCrew().addCrewMember(new Thief("bill"));
					break;
					case"The Haggler": gameLogic.getShipAndCrew().addCrewMember(new Haggler("harry"));
					break;
					default:
						break;
					}
				}
				gameLogic.getShipAndCrew().setShipName(shipNameInput.getText());
				gameLogic.setRemainingDays(daysInputSlider.getValue());
				gameLogic.setNumberOfPiecesRemaining((int) (Math.floor(gameLogic.getRemainingDays() * (float) 2/3)));
				finishedWindow();
					
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(683, 500, 91, 50);
		window.getContentPane().add(btnNewButton);
		
		JProgressBar IMPLEMENTLATER = new JProgressBar();
		IMPLEMENTLATER.setBounds(638, 426, 146, 14);
		window.getContentPane().add(IMPLEMENTLATER);
		
	}
	public void refreshGui() {
		
		
	}
}
