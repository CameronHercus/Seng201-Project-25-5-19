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
	private JFrame window;
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
		btnNewButton.setBounds(387, 11, 125, 95);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
			}
		});
		window.getContentPane().setLayout(null);
		
		JButton selectedMedicine = new JButton("");
		selectedMedicine.setBounds(463, 455, 125, 65);
		window.getContentPane().add(selectedMedicine);
		
		JButton selectedFood = new JButton("");
		selectedFood.setBounds(463, 250, 125, 65);
		window.getContentPane().add(selectedFood);
		window.getContentPane().add(btnNewButton);
		
		JLabel medicineCost = new JLabel("Total cost");
		medicineCost.setFont(new Font("Arial", Font.BOLD, 16));
		medicineCost.setBounds(619, 465, 123, 14);
		window.getContentPane().add(medicineCost);
		
		JLabel foodCost = new JLabel("Total cost");
		foodCost.setFont(new Font("Tahoma", Font.BOLD, 16));
		foodCost.setBounds(619, 263, 123, 29);
		window.getContentPane().add(foodCost);
		
		JLabel lblMoneyRemaining_1 = new JLabel("Amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney());
		lblMoneyRemaining_1.setBounds(387, 157, 146, 29);
		window.getContentPane().add(lblMoneyRemaining_1);
		
		JLabel lblItemStats = new JLabel("Item Stats");
		lblItemStats.setVerticalAlignment(SwingConstants.TOP);
		lblItemStats.setBounds(532, 11, 242, 187);
		window.getContentPane().add(lblItemStats);
		
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
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText("Bread");
			}
		});
		
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
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText("Tea");
			}
		});
		
		JComboBox medicineQuantity = new JComboBox();
		medicineQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medicineCost.setText("Cost: $" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantity.getSelectedItem());
				
			}
		});
		medicineQuantity.setModel(new DefaultComboBoxModel(comboBoxOptions.toArray()));
		medicineQuantity.setMaximumRowCount(10);
		medicineQuantity.setBounds(543, 529, 45, 22);
		window.getContentPane().add(medicineQuantity);
		btnTea.setBounds(10, 296, 125, 80);
		window.getContentPane().add(btnTea);
		
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
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText("Nuts");
			}
		});
		btnNuts.setBounds(10, 197, 125, 80);
		window.getContentPane().add(btnNuts);
		btnBread.setBounds(158, 296, 125, 80);
		window.getContentPane().add(btnBread);
		
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
				medicineCost.setText("Cost: $" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantity.getSelectedItem());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText("Antidote");
			}
		});
		
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
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText("Apples");
			}
		});
		btnApples.setBounds(158, 197, 125, 80);
		window.getContentPane().add(btnApples);
		
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
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText("Soup");
			}
		});
		btnSoup.setBounds(309, 296, 125, 80);
		window.getContentPane().add(btnSoup);
		
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
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText("Corned Beef");
			}
		});
		btnCornedBeef.setBounds(309, 197, 125, 80);
		window.getContentPane().add(btnCornedBeef);
		btnAntidote.setBounds(10, 455, 125, 80);
		window.getContentPane().add(btnAntidote);
		
		JButton btnMedKit = new JButton("Med Kit");
		btnMedKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (medicineDeque.size() == 1) {
					medicineDeque.removeLast();
				}
				medicineDeque.add(new MedKit());
				selectedMedicine.setText(medicineDeque.getLast().getMedicineName());
				medicineCost.setText("Cost: $" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantity.getSelectedItem());
			}
		});

		
		JButton btnFirstAidKit = new JButton("First-Aid Kit");
		btnFirstAidKit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (medicineDeque.size() == 1) {
					medicineDeque.removeLast();
				}
				medicineDeque.add(new FirstAidKit());
				selectedMedicine.setText(medicineDeque.getLast().getMedicineName());
				medicineCost.setText("Cost: $" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantity.getSelectedItem());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText("First-Aid Kit");
			}
		});
		btnFirstAidKit.setBounds(158, 455, 125, 80);
		window.getContentPane().add(btnFirstAidKit);
		btnMedKit.setBounds(309, 455, 125, 80);
		window.getContentPane().add(btnMedKit);
		
		JComboBox boxFoodQuantity_1 = new JComboBox();
		boxFoodQuantity_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boxFoodQuantity_1.setModel(new DefaultComboBoxModel(comboBoxOptions.toArray()));
		boxFoodQuantity_1.setMaximumRowCount(10);
		boxFoodQuantity_1.setBounds(543, 326, 45, 22);
		window.getContentPane().add(boxFoodQuantity_1);
		
		JLabel label_2 = new JLabel("Selected:");
		label_2.setFont(new Font("Arial", Font.PLAIN, 18));
		label_2.setBounds(454, 210, 109, 29);
		window.getContentPane().add(label_2);
		
		JLabel label = new JLabel("Selected:");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(463, 415, 109, 29);
		window.getContentPane().add(label);
		JButton btnFoodPurchase = new JButton("Purchase");
		btnFoodPurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() > 0) {
					if (gameLogic.purchaseFood(foodDeque.getLast(), (int) boxFoodQuantity_1.getSelectedItem())) {
						selectedFood.setText("");
						foodCost.setText("");
					} else {
						System.out.println("NOT ENOUGH FUNDS");
					}
				}
			}
		});
		btnFoodPurchase.setFont(new Font("Arial", Font.BOLD, 16));
		btnFoodPurchase.setBounds(619, 296, 123, 50);
		window.getContentPane().add(btnFoodPurchase);
		
		JButton btnMedicinePurchase = new JButton("Purchase");
		btnMedicinePurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMedicinePurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (medicineDeque.size() > 0) {
					if (gameLogic.purchaseMedicine(medicineDeque.getLast(), (int) medicineQuantity.getSelectedItem())) {
						selectedMedicine.setText("");
						medicineCost.setText("");
					} else {
						System.out.println("NOT ENOUGH FUNDS");
					}
				}
			}
		});
		btnMedicinePurchase.setFont(new Font("Arial", Font.BOLD, 16));
		btnMedicinePurchase.setBounds(617, 500, 125, 50);
		window.getContentPane().add(btnMedicinePurchase);
	}
	public void refreshGui() {
		window.revalidate();

		
	}
}
