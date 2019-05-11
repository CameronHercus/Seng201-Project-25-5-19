import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ScreenSetup2 {
	private GameEnvironment gameLogic;
	
	private JFrame window;
	private JTextField shipNameInput;
	private JTextField descriptionDisplay;
	private JTextField crewClassDisplay1;
	private JTextField crewInput1;
	private JTextField crewInput2;
	private JTextField crewInput3;
	private JTextField crewInput4;
	private JTextField crewClassDisplay4;
	private JTextField crewClassDisplay2;
	private JTextField crewClassDisplay5;
	private JTextField crewClassDisplay3;
	private JTextField crewClassDisplay6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenSetup2 window = new ScreenSetup2();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public ScreenSetup2(GameEnvironment incomingGameEnvironment) {
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
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1024, 768);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel numDaysLBL = new JLabel("How many days would you like to play?");
		numDaysLBL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numDaysLBL.setBounds(33, 132, 324, 23);
		window.getContentPane().add(numDaysLBL);
		
		JSlider daysInputSlider = new JSlider();
		daysInputSlider.setPaintLabels(true);
		daysInputSlider.setMajorTickSpacing(1);
		daysInputSlider.setMaximum(10);
		daysInputSlider.setMinimum(3);
		daysInputSlider.setSnapToTicks(true);
		daysInputSlider.setPaintTicks(true);
		daysInputSlider.setBounds(386, 116, 413, 57);
		window.getContentPane().add(daysInputSlider);
		
		JLabel nameShipLBL = new JLabel("Enter the name of your Starship:\r\n");
		nameShipLBL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameShipLBL.setBounds(33, 45, 281, 23);
		window.getContentPane().add(nameShipLBL);
		
		shipNameInput = new JTextField();
		shipNameInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		shipNameInput.setBounds(386, 39, 413, 37);
		window.getContentPane().add(shipNameInput);
		shipNameInput.setColumns(10);
		
		JSlider numberCrewInputSlider = new JSlider();
		numberCrewInputSlider.setMajorTickSpacing(1);
		numberCrewInputSlider.setMinimum(2);
		numberCrewInputSlider.setMaximum(4);
		numberCrewInputSlider.setSnapToTicks(true);
		numberCrewInputSlider.setPaintTicks(true);
		numberCrewInputSlider.setPaintLabels(true);
		numberCrewInputSlider.setBounds(33, 631, 278, 64);
		window.getContentPane().add(numberCrewInputSlider);
		
		crewClassDisplay1 = new JTextField();
		crewClassDisplay1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				descriptionDisplay.setText(gameLogic.getClassList().get(0).toString() + 
						gameLogic.getClassList().get(0).getSkill());
			}
		});
		crewClassDisplay1.setText(gameLogic.getClassList().get(0).toString());
		crewClassDisplay1.setBackground(SystemColor.activeCaption);
		crewClassDisplay1.setEditable(false);
		crewClassDisplay1.setBounds(50, 255, 140, 131);
		window.getContentPane().add(crewClassDisplay1);
		crewClassDisplay1.setColumns(10);
		
		crewClassDisplay2 = new JTextField();
		crewClassDisplay2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				descriptionDisplay.setText(gameLogic.getClassList().get(1).toString() + 
						gameLogic.getClassList().get(1).getSkill());
			}
		});
		crewClassDisplay2.setText(gameLogic.getClassList().get(1).toString());
		crewClassDisplay2.setBackground(SystemColor.activeCaption);
		crewClassDisplay2.setEditable(false);
		crewClassDisplay2.setColumns(10);
		crewClassDisplay2.setBounds(253, 255, 140, 131);
		window.getContentPane().add(crewClassDisplay2);
		
		crewClassDisplay3 = new JTextField();
		crewClassDisplay3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				descriptionDisplay.setText(gameLogic.getClassList().get(2).toString() + 
						gameLogic.getClassList().get(2).getSkill());
			}
		});
		crewClassDisplay3.setText(gameLogic.getClassList().get(2).toString());
		crewClassDisplay3.setBackground(SystemColor.activeCaption);
		crewClassDisplay3.setEditable(false);
		crewClassDisplay3.setColumns(10);
		crewClassDisplay3.setBounds(464, 255, 140, 131);
		window.getContentPane().add(crewClassDisplay3);
		
		crewClassDisplay4 = new JTextField();
		crewClassDisplay4.setBackground(SystemColor.activeCaption);
		crewClassDisplay4.setEditable(false);
		crewClassDisplay4.setColumns(10);
		crewClassDisplay4.setBounds(50, 401, 140, 131);
		window.getContentPane().add(crewClassDisplay4);
		
		crewClassDisplay5 = new JTextField();
		crewClassDisplay5.setBackground(SystemColor.activeCaption);
		crewClassDisplay5.setEditable(false);
		crewClassDisplay5.setColumns(10);
		crewClassDisplay5.setBounds(253, 401, 140, 131);
		window.getContentPane().add(crewClassDisplay5);
		
		crewClassDisplay6 = new JTextField();
		crewClassDisplay6.setBackground(SystemColor.activeCaption);
		crewClassDisplay6.setEditable(false);
		crewClassDisplay6.setColumns(10);
		crewClassDisplay6.setBounds(464, 401, 140, 131);
		window.getContentPane().add(crewClassDisplay6);
		
		descriptionDisplay = new JTextField();
		descriptionDisplay.setText("Hover over class");
		descriptionDisplay.setBackground(SystemColor.activeCaptionBorder);
		descriptionDisplay.setEditable(false);
		descriptionDisplay.setBounds(656, 255, 324, 277);
		window.getContentPane().add(descriptionDisplay);
		descriptionDisplay.setColumns(10);
		
		JLabel lblNumberOfCrew = new JLabel("Number of crew members playing:");
		lblNumberOfCrew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfCrew.setBounds(33, 606, 228, 23);
		window.getContentPane().add(lblNumberOfCrew);
		
		crewInput1 = new JTextField();
		crewInput1.setBackground(Color.LIGHT_GRAY);
		crewInput1.setEditable(false);
		crewInput1.setColumns(10);
		crewInput1.setBounds(321, 599, 102, 96);
		window.getContentPane().add(crewInput1);
		
		crewInput2 = new JTextField();
		crewInput2.setBackground(Color.LIGHT_GRAY);
		crewInput2.setEditable(false);
		crewInput2.setColumns(10);
		crewInput2.setBounds(444, 599, 102, 96);
		window.getContentPane().add(crewInput2);
		
		crewInput3 = new JTextField();
		crewInput3.setBackground(Color.LIGHT_GRAY);
		crewInput3.setEditable(false);
		crewInput3.setColumns(10);
		crewInput3.setBounds(566, 599, 102, 96);
		window.getContentPane().add(crewInput3);
		
		crewInput4 = new JTextField();
		crewInput4.setBackground(Color.LIGHT_GRAY);
		crewInput4.setEditable(false);
		crewInput4.setColumns(10);
		crewInput4.setBounds(688, 599, 102, 96);
		window.getContentPane().add(crewInput4);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(gameLogic.inputDays(daysInputSlider.getValue()));
				System.out.println(gameLogic.getRemainingDays());
				System.out.println(gameLogic.inputShipName(shipNameInput.getText()));
				System.out.println(gameLogic.shipAndCrew.getShipName());
			}
		});
		btnNewButton.setBounds(874, 649, 89, 23);
		window.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/Webp.net-resizeimage_9.jpg")));
		lblNewLabel.setBounds(0, 0, 1008, 729);
		window.getContentPane().add(lblNewLabel);
	}
}
