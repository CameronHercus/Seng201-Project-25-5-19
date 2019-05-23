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
		btnNewButton.setBounds(649, 11, 125, 51);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finishedWindow();
			}
		});
		window.getContentPane().setLayout(null);
		
		JButton selectedMedicine = new JButton("");
		selectedMedicine.setFont(new Font("Tahoma", Font.BOLD, 14));
		selectedMedicine.setBounds(463, 486, 125, 65);
		window.getContentPane().add(selectedMedicine);
		
		JButton selectedFood = new JButton("");
		selectedFood.setFont(new Font("Tahoma", Font.BOLD, 14));
		selectedFood.setBounds(463, 342, 125, 65);
		window.getContentPane().add(selectedFood);
		window.getContentPane().add(btnNewButton);
		
		JLabel inventory = new JLabel(getText("inventory"));
		inventory.setFont(new Font("Tahoma", Font.BOLD, 14));
		inventory.setBounds(109, 11, 344, 199);
		window.getContentPane().add(inventory);
		
		JLabel medicineCost = new JLabel("Total Cost:");
		medicineCost.setFont(new Font("Arial", Font.BOLD, 16));
		medicineCost.setBounds(608, 429, 176, 60);
		window.getContentPane().add(medicineCost);
		
		JLabel foodCost = new JLabel("Total Cost:");
		foodCost.setFont(new Font("Tahoma", Font.BOLD, 16));
		foodCost.setBounds(598, 286, 176, 60);
		window.getContentPane().add(foodCost);
		
		JLabel lblMoneyRemaining = new JLabel(getText("amountMoney"));
		lblMoneyRemaining.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMoneyRemaining.setBounds(83, 214, 226, 51);
		window.getContentPane().add(lblMoneyRemaining);
		
		JLabel lblItemStats = new JLabel("Item Stats");
		lblItemStats.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblItemStats.setVerticalAlignment(SwingConstants.TOP);
		lblItemStats.setBounds(463, 158, 309, 133);
		window.getContentPane().add(lblItemStats);
		
		JComboBox medicineQuantity = new JComboBox();
		medicineQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medicineCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantity.getSelectedItem() + "</html>");
				
			}
		});
		
		JComboBox foodQuantity = new JComboBox();
		foodQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantity.getSelectedItem() + "</html>");
			}
		});
		foodQuantity.setModel(new DefaultComboBoxModel(comboBoxOptions.toArray()));
		foodQuantity.setMaximumRowCount(10);
		foodQuantity.setBounds(598, 357, 45, 50);
		window.getContentPane().add(foodQuantity);
		medicineQuantity.setModel(new DefaultComboBoxModel(comboBoxOptions.toArray()));
		medicineQuantity.setMaximumRowCount(10);
		medicineQuantity.setBounds(594, 500, 45, 51);
		window.getContentPane().add(medicineQuantity);
		
		JButton btnNuts = new JButton("Nuts");
		btnNuts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Nuts());
				selectedFood.setText(foodDeque.getLast().getFoodName());
				foodCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantity.getSelectedItem() + "</html>");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText(getFoodDescription("nuts"));
			}
		});
		btnNuts.setBounds(10, 276, 125, 60);
		window.getContentPane().add(btnNuts);
		
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
				medicineCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantity.getSelectedItem() + "</html>");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText(getFoodDescription("antidote"));
			}
		});
		
		JButton btnSoup = new JButton("Soup");
		btnSoup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Soup());
				selectedFood.setText(foodDeque.getLast().getFoodName());
				foodCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantity.getSelectedItem() + "</html>");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText(getFoodDescription("soup"));
			}
		});
		btnSoup.setBounds(309, 347, 125, 60);
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
				foodCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantity.getSelectedItem() + "</html>");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText(getFoodDescription("cornedBeef"));
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
				foodCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantity.getSelectedItem() + "</html>");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText(getFoodDescription("tea"));
			}
		});
		btnTea.setBounds(10, 347, 125, 60);
		window.getContentPane().add(btnTea);
		
		JButton btnBread = new JButton("Bread");
		btnBread.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Bread());
				selectedFood.setText(foodDeque.getLast().getFoodName());
				foodCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantity.getSelectedItem() + "</html>");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText(getFoodDescription("bread"));
			}
		});
		btnBread.setBounds(158, 347, 125, 60);
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
				foodCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantity.getSelectedItem() + "</html>");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText(getFoodDescription("apples"));
			}
		});
		btnApples.setBounds(158, 276, 125, 60);
		window.getContentPane().add(btnApples);
		btnCornedBeef.setBounds(309, 276, 125, 60);
		window.getContentPane().add(btnCornedBeef);
		btnAntidote.setBounds(10, 491, 125, 60);
		window.getContentPane().add(btnAntidote);
		
		JButton btnMedKit = new JButton("Med Kit");
		btnMedKit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText(getFoodDescription("medKit"));
			}
		});
		btnMedKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (medicineDeque.size() == 1) {
					medicineDeque.removeLast();
				}
				medicineDeque.add(new MedKit());
				selectedMedicine.setText(medicineDeque.getLast().getMedicineName());
				medicineCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantity.getSelectedItem() + "</html>");
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
				medicineCost.setText("<html>" + "Total Cost:" + "<br>" + "$" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantity.getSelectedItem() + "</html>");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblItemStats.setText(getFoodDescription("first-AidKit"));
			}
		});
		btnFirstAidKit.setBounds(158, 491, 125, 60);
		window.getContentPane().add(btnFirstAidKit);
		btnMedKit.setBounds(309, 491, 125, 60);
		window.getContentPane().add(btnMedKit);
		
		JLabel label_2 = new JLabel("Selected:");
		label_2.setFont(new Font("Arial", Font.PLAIN, 18));
		label_2.setBounds(463, 302, 109, 29);
		window.getContentPane().add(label_2);
		
		JLabel label = new JLabel("Selected:");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(463, 446, 109, 29);
		window.getContentPane().add(label);
		JButton btnFoodPurchase = new JButton("Purchase");
		btnFoodPurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (foodDeque.size() > 0) {
					if (gameLogic.purchaseFood(foodDeque.getLast(), (int) foodQuantity.getSelectedItem())) {
						selectedFood.setText("");
						foodCost.setText("Total Cost:");
						lblMoneyRemaining.setText(getText("amountMoney"));
						inventory.setText(getText("inventory"));
					} else {
						System.out.println("NOT ENOUGH FUNDS");
					}
				}
			}
		});
		btnFoodPurchase.setFont(new Font("Arial", Font.BOLD, 16));
		btnFoodPurchase.setBounds(649, 357, 123, 50);
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
						medicineCost.setText("Total Cost:");
						lblMoneyRemaining.setText(getText("amountMoney"));
						inventory.setText(getText("inventory"));
					} else {
						System.out.println("NOT ENOUGH FUNDS");
					}
				}
			}
		});
		btnMedicinePurchase.setFont(new Font("Arial", Font.BOLD, 16));
		btnMedicinePurchase.setBounds(649, 500, 125, 50);
		window.getContentPane().add(btnMedicinePurchase);
	}
	public String getText(String switchStatement) {
		switch (switchStatement) {
		case "amountMoney": return "Amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney();
		case "inventory": return gameLogic.getFoodFrequency();
		default: return null;
		}
	}
	public String getFoodDescription(String switchStatement) {
		switch (switchStatement) {
		case "tea": return "<html>" + "Tea" + "<br>" + "restores 5 Hunger" + "<br>" + "costs $5" + "</html>";
		case "nuts": return "<html>" + "Nuts" + "<br>" + "restores 10 Hunger" + "<br>" + "costs $10" + "</html>";
		case "bread": return "<html>" + "Bread" + "<br>" + "restores 20 Hunger" + "<br>" + "costs $20" + "</html>";
		case "cornedBeef": return "<html>" + "Corned Beef" + "<br>" + "restores 30 Hunger" + "<br>" + "costs $30" + "</html>";
		case "soup": return "<html>" + "Soup" + "<br>" + "restores 25 Hunger" + "<br>" + "costs $25" + "</html>";
		case "apples": return "<html>" + "Apples" + "<br>" + "restores 15 Hunger" + "<br>" + "costs $15" + "</html>";
		case "antidote": return "<html>" + "Antidote" + "<br>" + "Cures Space Plague" + "<br>" + "costs $15" + "</html>";
		case "medKit": return "<html>" + "Med Kit" + "<br>" + "restores 25 health" + "<br>" + "costs $20" + "</html>";
		case "first-AidKit": return "<html>" + "First-Aid Kit" + "<br>" + "restores 15 health" + "<br>" + "costs $15" + "</html>";
		default: return null;
		}
		// See the prices of each object. (d) See the attributes of the object, attributes will be better explained in section 3. 
	}
}
