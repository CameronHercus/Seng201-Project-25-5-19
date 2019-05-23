import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		
		JButton returnToShipButton = new JButton("Return to Ship");
		returnToShipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		returnToShipButton.setBounds(649, 11, 125, 51);
		window.getContentPane().setLayout(null);
		
		JButton selectedMedicineButton = new JButton("");
		selectedMedicineButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		selectedMedicineButton.setBounds(463, 486, 125, 65);
		window.getContentPane().add(selectedMedicineButton);
		
		JButton selectedFoodButton = new JButton("");
		selectedFoodButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		selectedFoodButton.setBounds(463, 342, 125, 65);
		window.getContentPane().add(selectedFoodButton);
		window.getContentPane().add(returnToShipButton);
		
		JLabel inventoryLabel = new JLabel(getText("inventory"));
		inventoryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		inventoryLabel.setBounds(109, 11, 344, 199);
		window.getContentPane().add(inventoryLabel);
		
		JLabel medicineCostLabel = new JLabel("Total Cost:");
		medicineCostLabel.setFont(new Font("Arial", Font.BOLD, 16));
		medicineCostLabel.setBounds(608, 429, 176, 60);
		window.getContentPane().add(medicineCostLabel);
		
		JLabel foodCostLabel = new JLabel("Total Cost:");
		foodCostLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		foodCostLabel.setBounds(598, 286, 176, 60);
		window.getContentPane().add(foodCostLabel);
		
		JLabel remainingMoneylabel = new JLabel(getText("amountMoney"));
		remainingMoneylabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		remainingMoneylabel.setBounds(83, 214, 226, 51);
		window.getContentPane().add(remainingMoneylabel);
		
		JLabel itemStatsLabel = new JLabel("Item Stats");
		itemStatsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		itemStatsLabel.setVerticalAlignment(SwingConstants.TOP);
		itemStatsLabel.setBounds(463, 158, 309, 133);
		window.getContentPane().add(itemStatsLabel);
		
		JComboBox medicineQuantityComboBox = new JComboBox();
		medicineQuantityComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (medicineDeque.size() >= 1) {
					medicineCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantityComboBox.getSelectedItem() + "</html>");
				}
				
			}
		});
		
		JComboBox foodQuantityComboBox = new JComboBox();
		foodQuantityComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (foodDeque.size() >= 1) {
					foodCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantityComboBox.getSelectedItem() + "</html>");
				}
			}
		});
		foodQuantityComboBox.setModel(new DefaultComboBoxModel(comboBoxOptions.toArray()));
		foodQuantityComboBox.setMaximumRowCount(10);
		foodQuantityComboBox.setBounds(598, 357, 45, 50);
		window.getContentPane().add(foodQuantityComboBox);
		medicineQuantityComboBox.setModel(new DefaultComboBoxModel(comboBoxOptions.toArray()));
		medicineQuantityComboBox.setMaximumRowCount(10);
		medicineQuantityComboBox.setBounds(594, 500, 45, 51);
		window.getContentPane().add(medicineQuantityComboBox);
		
		JButton selectedNutsButton = new JButton("Nuts");
		selectedNutsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Nuts());
				selectedFoodButton.setText(foodDeque.getLast().getFoodName());
				foodCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantityComboBox.getSelectedItem() + "</html>");
			}
		});
		selectedNutsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				itemStatsLabel.setText(getFoodDescription("nuts"));
			}
		});
		selectedNutsButton.setBounds(10, 276, 125, 60);
		window.getContentPane().add(selectedNutsButton);
		
		JButton selectedAntidoteButton = new JButton("Antidote");
		selectedAntidoteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (medicineDeque.size() == 1) {
					medicineDeque.removeLast();
				}
				medicineDeque.add(new Antidote());
				selectedMedicineButton.setText(medicineDeque.getLast().getMedicineName());
				medicineCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantityComboBox.getSelectedItem() + "</html>");
			}
		});
		selectedAntidoteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				itemStatsLabel.setText(getFoodDescription("antidote"));
			}
		});
		
		JButton selectedSoupButton = new JButton("Soup");
		selectedSoupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Soup());
				selectedFoodButton.setText(foodDeque.getLast().getFoodName());
				foodCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantityComboBox.getSelectedItem() + "</html>");
			}
		});
		selectedSoupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				itemStatsLabel.setText(getFoodDescription("soup"));
			}
		});
		selectedSoupButton.setBounds(309, 347, 125, 60);
		window.getContentPane().add(selectedSoupButton);
		
		JButton selectedCornedBeefButton = new JButton("Corned Beef");
		selectedCornedBeefButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new CornedBeef());
				selectedFoodButton.setText(foodDeque.getLast().getFoodName());
				foodCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantityComboBox.getSelectedItem() + "</html>");
			}
		});
		selectedCornedBeefButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				itemStatsLabel.setText(getFoodDescription("cornedBeef"));
			}
		});
		
		JButton selectedTeaButton = new JButton("Tea");
		selectedTeaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Tea());
				selectedFoodButton.setText(foodDeque.getLast().getFoodName());
				foodCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantityComboBox.getSelectedItem() + "</html>");
			}
		});
		selectedTeaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				itemStatsLabel.setText(getFoodDescription("tea"));
			}
		});
		selectedTeaButton.setBounds(10, 347, 125, 60);
		window.getContentPane().add(selectedTeaButton);
		
		JButton selectedBreadButton = new JButton("Bread");
		selectedBreadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Bread());
				selectedFoodButton.setText(foodDeque.getLast().getFoodName());
				foodCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantityComboBox.getSelectedItem() + "</html>");
			}
		});
		selectedBreadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				itemStatsLabel.setText(getFoodDescription("bread"));
			}
		});
		selectedBreadButton.setBounds(158, 347, 125, 60);
		window.getContentPane().add(selectedBreadButton);
		
		JButton selectedApplesButton = new JButton("Apples");
		selectedApplesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (foodDeque.size() == 1) {
					foodDeque.removeLast();
				}
				foodDeque.add(new Apple());
				selectedFoodButton.setText(foodDeque.getLast().getFoodName());
				foodCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + foodDeque.getLast().getfoodCost() * (int) foodQuantityComboBox.getSelectedItem() + "</html>");
			}
		});
		selectedApplesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				itemStatsLabel.setText(getFoodDescription("apples"));
			}
		});
		selectedApplesButton.setBounds(158, 276, 125, 60);
		window.getContentPane().add(selectedApplesButton);
		selectedCornedBeefButton.setBounds(309, 276, 125, 60);
		window.getContentPane().add(selectedCornedBeefButton);
		selectedAntidoteButton.setBounds(10, 491, 125, 60);
		window.getContentPane().add(selectedAntidoteButton);
		
		JButton selectedMedKitButton = new JButton("Med Kit");
		selectedMedKitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				itemStatsLabel.setText(getFoodDescription("medKit"));
			}
		});
		selectedMedKitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (medicineDeque.size() == 1) {
					medicineDeque.removeLast();
				}
				medicineDeque.add(new MedKit());
				selectedMedicineButton.setText(medicineDeque.getLast().getMedicineName());
				medicineCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantityComboBox.getSelectedItem() + "</html>");
			}
		});
		JButton selectedFirstAidKitButton = new JButton("First-Aid Kit");
		selectedFirstAidKitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (medicineDeque.size() == 1) {
					medicineDeque.removeLast();
				}
				medicineDeque.add(new FirstAidKit());
				selectedMedicineButton.setText(medicineDeque.getLast().getMedicineName());
				medicineCostLabel.setText("<html>" + "Total Cost:" + "<br>" + "$" + medicineDeque.getLast().getMedicineCost() * (int) medicineQuantityComboBox.getSelectedItem() + "</html>");
			}
		});
		selectedFirstAidKitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				itemStatsLabel.setText(getFoodDescription("first-AidKit"));
			}
		});
		selectedFirstAidKitButton.setBounds(158, 491, 125, 60);
		window.getContentPane().add(selectedFirstAidKitButton);
		selectedMedKitButton.setBounds(309, 491, 125, 60);
		window.getContentPane().add(selectedMedKitButton);
		
		JLabel foodSelectedPromptLabel = new JLabel("Selected:");
		foodSelectedPromptLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		foodSelectedPromptLabel.setBounds(463, 302, 109, 29);
		window.getContentPane().add(foodSelectedPromptLabel);
		
		JLabel medicineSelectedPromptLabel = new JLabel("Selected:");
		medicineSelectedPromptLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		medicineSelectedPromptLabel.setBounds(463, 446, 109, 29);
		window.getContentPane().add(medicineSelectedPromptLabel);
		JButton purchaseFoodButton = new JButton("Purchase");
		purchaseFoodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (foodDeque.size() > 0) {
					if (gameLogic.purchaseFood(foodDeque.getLast(), (int) foodQuantityComboBox.getSelectedItem())) {
						foodDeque.removeLast();
						selectedFoodButton.setText("");
						foodCostLabel.setText("Total Cost:");
						remainingMoneylabel.setText(getText("amountMoney"));
						inventoryLabel.setText(getText("inventory"));
					} else {
						JOptionPane.showMessageDialog(null, "You have insufficient funds for this purchase");
					}
				}
			}
		});
		purchaseFoodButton.setFont(new Font("Arial", Font.BOLD, 16));
		purchaseFoodButton.setBounds(649, 357, 123, 50);
		window.getContentPane().add(purchaseFoodButton);
		
		JButton purchaseMedicineButton = new JButton("Purchase");
		purchaseMedicineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (medicineDeque.size() > 0) {
					if (gameLogic.purchaseMedicine(medicineDeque.getLast(), (int) medicineQuantityComboBox.getSelectedItem())) {
						medicineDeque.removeLast();
						selectedMedicineButton.setText("");
						medicineCostLabel.setText("Total Cost:");
						remainingMoneylabel.setText(getText("amountMoney"));
						inventoryLabel.setText(getText("inventory"));
					} else {
						JOptionPane.showMessageDialog(null, "You have insufficient funds for this purchase");
					}
				}
			}
		});
		purchaseMedicineButton.setFont(new Font("Arial", Font.BOLD, 16));
		purchaseMedicineButton.setBounds(649, 500, 125, 50);
		window.getContentPane().add(purchaseMedicineButton);
	}
	public String getText(String switchStatement) {
		switch (switchStatement) {
		case "amountMoney": return "Amount of Money: " + gameLogic.getShipAndCrew().getAmountMoney();
		case "inventory": return gameLogic.getInvetory();
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
	}
}
