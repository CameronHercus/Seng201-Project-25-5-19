

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class maingui extends JFrame {

	private JPanel contentPane;
	private JTextField shipnametextField;
	private JTextField bigboxtextfield;
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maingui frame = new maingui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public maingui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider days_slider = new JSlider();
		days_slider.setPaintLabels(true);
		days_slider.setMajorTickSpacing(1);
		days_slider.setMaximum(10);
		days_slider.setMinimum(3);
		days_slider.setSnapToTicks(true);
		days_slider.setPaintTicks(true);
		days_slider.setBounds(386, 116, 413, 57);
		contentPane.add(days_slider);
		
		JLabel lblHowManyDays = new JLabel("How many days would you like to play?");
		lblHowManyDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHowManyDays.setBounds(33, 132, 324, 23);
		contentPane.add(lblHowManyDays);
		
		JLabel lblShipName = new JLabel("Enter the name of your Starship:\r\n");
		lblShipName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblShipName.setBounds(33, 45, 281, 23);
		contentPane.add(lblShipName);
		
		shipnametextField = new JTextField();
		shipnametextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		shipnametextField.setBounds(386, 39, 413, 37);
		contentPane.add(shipnametextField);
		shipnametextField.setColumns(10);
		
		JSlider crew_slider = new JSlider();
		crew_slider.setMajorTickSpacing(1);
		crew_slider.setMinimum(2);
		crew_slider.setMaximum(4);
		crew_slider.setSnapToTicks(true);
		crew_slider.setPaintTicks(true);
		crew_slider.setPaintLabels(true);
		crew_slider.setBounds(33, 631, 278, 64);
		contentPane.add(crew_slider);
		
		bigboxtextfield = new JTextField();
		bigboxtextfield.setEditable(false);
		bigboxtextfield.setBounds(656, 255, 324, 277);
		contentPane.add(bigboxtextfield);
		bigboxtextfield.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(50, 255, 140, 131);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumberOfCrew = new JLabel("Number of crew members playing:");
		lblNumberOfCrew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfCrew.setBounds(33, 606, 228, 23);
		contentPane.add(lblNumberOfCrew);
		
		textField_6 = new JTextField();
		textField_6.setBackground(Color.LIGHT_GRAY);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(400, 599, 102, 96);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBackground(Color.LIGHT_GRAY);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(565, 599, 102, 96);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBackground(Color.LIGHT_GRAY);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(718, 599, 102, 96);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBackground(Color.LIGHT_GRAY);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(878, 599, 102, 96);
		contentPane.add(textField_9);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(50, 401, 140, 131);
		contentPane.add(textField_3);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(253, 255, 140, 131);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(253, 401, 140, 131);
		contentPane.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(464, 255, 140, 131);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(464, 401, 140, 131);
		contentPane.add(textField_5);
	}
}
