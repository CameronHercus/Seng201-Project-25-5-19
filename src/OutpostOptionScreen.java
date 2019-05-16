import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;

public class OutpostOptionScreen {
	private GameEnvironment gameLogic;
	ArrayDeque<FoodItems> foodDeque = new ArrayDeque<FoodItems>();
	ArrayDeque<MedicalSupplies> medicineDeque = new ArrayDeque<MedicalSupplies>();
	ArrayList<Integer> comboBoxOptions = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
	private JButton selectedMedicine;
	private JButton selectedFood;
	private JComboBox boxMedicineQuantity;
	private JComboBox boxFoodQuantity;
	private JFrame window;
	private JTextField txtEnterQuantity;
	private JTextField textField;
	private JButton lblMoneyRemaining;
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public OutpostOptionScreen(GameEnvironment incomingGameEnvironment) {
		gameLogic = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		gameLogic.closeOutpostOptionScreen(this);
	}

	private void initialize() {
		window = new JFrame();
		window.setTitle("Outpost");
		window.setBounds(100, 100, 800, 600
				);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Return to Ship");
		btnNewButton.setBounds(429, 11, 125, 95);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
			}
		});
		window.getContentPane().setLayout(null);
		window.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("Selected:");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(463, 415, 109, 29);
		window.getContentPane().add(label);
		
		JButton selectedMedicine = new JButton("");
		selectedMedicine.setBounds(463, 455, 125, 65);
		window.getContentPane().add(selectedMedicine);
		
		JButton selectedFood = new JButton("");
		selectedFood.setBounds(463, 250, 125, 65);
		window.getContentPane().add(selectedFood);
		
		JButton button_4 = new JButton("Deque");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_4.setBounds(619, 455, 103, 39);
		window.getContentPane().add(button_4);
		
		JButton btnAntidote = new JButton("Antidote");
		btnAntidote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAntidote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (medicineDeque.size() == 1) {
					medicineDeque.removeLast();
				}
				medicineDeque.add(new Antidote());
				selectedMedicine.setText(medicineDeque.getLast().getMedicineName());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnAntidote.setBounds(10, 455, 125, 80);
		window.getContentPane().add(btnAntidote);
		
		JButton btnNuts = new JButton("Nuts");
		btnNuts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Nuts());
				selectedFood.setText(foodDeque.getLast().getFoodName());
			}
		});
		btnNuts.setBounds(10, 197, 125, 80);
		window.getContentPane().add(btnNuts);
		
		JButton btnTea = new JButton("Tea");
		btnTea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Tea());
				selectedFood.setText(foodDeque.getLast().getFoodName());
			}
		});
		btnTea.setBounds(10, 296, 125, 80);
		window.getContentPane().add(btnTea);
		
		JButton btnFirstAidKit = new JButton("First-Aid Kit");
		btnFirstAidKit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (medicineDeque.size() == 1) {
					medicineDeque.removeLast();
				}
				medicineDeque.add(new FirstAidKit());
				selectedMedicine.setText(medicineDeque.getLast().getMedicineName());
			}
		});
		btnFirstAidKit.setBounds(158, 455, 125, 80);
		window.getContentPane().add(btnFirstAidKit);
		
		JButton btnBread = new JButton("Bread");
		btnBread.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Bread());
				selectedFood.setText(foodDeque.getLast().getFoodName());
			}
		});
		btnBread.setBounds(158, 296, 125, 80);
		window.getContentPane().add(btnBread);
		
		JButton btnApples = new JButton("Apples");
		btnApples.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Apple());
				selectedFood.setText(foodDeque.getLast().getFoodName());
			}
		});
		btnApples.setBounds(158, 197, 125, 80);
		window.getContentPane().add(btnApples);
		
		JButton btnMedKit = new JButton("Med Kit");
		btnMedKit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (medicineDeque.size() == 1) {
					medicineDeque.removeLast();
				}
				medicineDeque.add(new MedKit());
				selectedMedicine.setText(medicineDeque.getLast().getMedicineName());
			}
		});
		btnMedKit.setBounds(309, 455, 125, 80);
		window.getContentPane().add(btnMedKit);
		
		JButton btnCornedBeef = new JButton("Corned Beef");
		btnCornedBeef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new CornedBeef());
				selectedFood.setText(foodDeque.getLast().getFoodName());
			}
		});
		btnCornedBeef.setBounds(309, 197, 125, 80);
		window.getContentPane().add(btnCornedBeef);
		
		JButton btnSoup = new JButton("Soup");
		btnSoup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Soup());
				selectedFood.setText(foodDeque.getLast().getFoodName());
			}
		});
		btnSoup.setBounds(309, 296, 125, 80);
		window.getContentPane().add(btnSoup);
		
		JLabel lblItemStats = new JLabel("Item Stats");
		lblItemStats.setVerticalAlignment(SwingConstants.TOP);
		lblItemStats.setBounds(589, 11, 185, 187);
		window.getContentPane().add(lblItemStats);
		
		textField = new JTextField();
		textField.setText("Enter Quantity");
		textField.setColumns(10);
		textField.setBounds(463, 326, 65, 20);
		window.getContentPane().add(textField);
		
		JLabel label_2 = new JLabel("Selected:");
		label_2.setFont(new Font("Arial", Font.PLAIN, 18));
		label_2.setBounds(454, 210, 109, 29);
		window.getContentPane().add(label_2);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(582, 424, 48, 14);
		window.getContentPane().add(lblCost);
		
		JLabel label_3 = new JLabel("Cost");
		label_3.setBounds(582, 219, 48, 14);
		window.getContentPane().add(label_3);
		
		JButton button_5 = new JButton("Deque");
		button_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_5.setBounds(619, 250, 103, 39);
		window.getContentPane().add(button_5);
		
		JLabel lblMoneyRemaining = new JLabel("Amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney());
		lblMoneyRemaining.setBounds(252, 28, 146, 29);
		window.getContentPane().add(lblMoneyRemaining);
		
		JComboBox boxMedicineQuantity = new JComboBox();
		boxMedicineQuantity.setModel(new DefaultComboBoxModel(comboBoxOptions.toArray()));
		boxMedicineQuantity.setMaximumRowCount(10);
		boxMedicineQuantity.setBounds(543, 529, 45, 22);
		window.getContentPane().add(boxMedicineQuantity);
		
		txtEnterQuantity = new JTextField();
		txtEnterQuantity.setEditable(false);
		txtEnterQuantity.setText("Quantity");
		txtEnterQuantity.setColumns(10);
		txtEnterQuantity.setBounds(463, 530, 65, 20);
		window.getContentPane().add(txtEnterQuantity);
		
		JButton btnFoodPurchase = new JButton("Purchase");
		btnFoodPurchase.setFont(new Font("Arial", Font.BOLD, 16));
		btnFoodPurchase.setBounds(619, 296, 105, 50);
		window.getContentPane().add(btnFoodPurchase);
		
		JButton btnMedicinePurchase = new JButton("Purchase");
		btnMedicinePurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (gameLogic.purchaseMedicine(medicineDeque.getLast(), (int) boxMedicineQuantity.getSelectedItem())) {
					gameLogic.purchaseMedicine(medicineDeque.getLast(), (int) boxMedicineQuantity.getSelectedItem());
					window.setVisible(false);
					window.setVisible(true);
				}
			}
		});
		btnMedicinePurchase.setFont(new Font("Arial", Font.BOLD, 16));
		btnMedicinePurchase.setBounds(617, 500, 105, 50);
		window.getContentPane().add(btnMedicinePurchase);
		
		JComboBox boxFoodQuantity = new JComboBox();
		boxFoodQuantity.setMaximumRowCount(10);
		boxFoodQuantity.setBounds(543, 326, 45, 22);
		window.getContentPane().add(boxFoodQuantity);
	}
	public void refreshGui() {
		window.revalidate();

		
	}
}
