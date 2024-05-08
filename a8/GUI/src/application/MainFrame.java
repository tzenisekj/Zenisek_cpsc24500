package application;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import Modal.Exercise;
import Modal.ExerciseWriter;
import Modal.RockClimbing;
import Modal.RunWalk;
import Modal.WeightLifting;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	// Main frame init
	private static MainFrame app = new MainFrame();
	
	// variables
	private String[] exerciseTypes = { "RunWalk", "RockClimbing", "WeightLifting" }; 
	private ArrayList<Exercise> exerciseList = new ArrayList<>(); 
	
	// file dialog
	JFileChooser fileChooser = new JFileChooser();
	
	// menu bar menus
	private final Menu f = new Menu("File");
	private final Menu h = new Menu("Help"); 
	
	// menu items for menu File
	private final MenuItem m1 = new MenuItem("Login");
	private final MenuItem m2 = new MenuItem("Logout");
	private final MenuItem m3 = new MenuItem("Save");
	private final MenuItem m4 = new MenuItem("Load");
	private final MenuItem m5 = new MenuItem("Exit"); 
	
	// menu items for menu help
	private final MenuItem h1 = new MenuItem("Can't Login");
	private final MenuItem h2 = new MenuItem("Can't get program to add exercise");
	
	// menu bar for main frame
	private final MenuBar mb = new MenuBar(); 
	 
	// labels for main
	private final JLabel lblExerciseType = new JLabel("Type");
	private final JLabel lblExerciseName = new JLabel("Name"); 
	private final JLabel lblExerciseDate = new JLabel("Date");
	private final JLabel lblExerciseDuration = new JLabel("Duration");
	private final JLabel lblExerciseDistance = new JLabel("Distance");
	private final JLabel lblExerciseWallHeight = new JLabel("Wall Height");
	private final JLabel lblExerciseRepititions = new JLabel("Repititions");
	private final JLabel lblExerciseWeightLifted = new JLabel("Weight Lifted");
	private final JLabel lblExerciseComment = new JLabel("Add Comment");
	private final JLabel lblExerciseSummary = new JLabel("Exercise Summary"); 
	
	// text fields for user input
	private final JTextField txtExerciseName = new JTextField(20);
	private final JTextField txtExerciseDuration = new JTextField(20);
	private final JTextField txtExerciseDate = new JTextField(20);
	private final JTextField txtExerciseDistance = new JTextField(20);
	private final JTextField txtExerciseWallHeight = new JTextField(20);
	private final JTextField txtExerciseRepititions = new JTextField(20);
	private final JTextField txtExerciseWeightLifted = new JTextField(20);
	
	// combo box for exercise type
	private final JComboBox cBox = new JComboBox(exerciseTypes);
	
	// text area for user comment input
	private final JTextArea txtExerciseComment = new JTextArea();
	
	// text area for displaying exercises
	private final JTextArea txtExerciseListSummary = new JTextArea();
	
	// buttons
	private final JButton btnAddExercise = new JButton("Add Exercise");
	
	// class methods
	private JPanel getRunWalkInputPanel() {
		JPanel runWalkPanel = new JPanel();
		BoxLayout runWalkLayout = new BoxLayout(runWalkPanel, BoxLayout.Y_AXIS);
		runWalkPanel.setLayout(runWalkLayout);
		
		JPanel exerciseNamePanel = new JPanel();
		exerciseNamePanel.add(lblExerciseName);
		exerciseNamePanel.add(txtExerciseName);
		runWalkPanel.add(exerciseNamePanel);
		
		JPanel exerciseDatePanel = new JPanel();
		exerciseDatePanel.add(lblExerciseDate);
		exerciseDatePanel.add(txtExerciseDate);
		runWalkPanel.add(exerciseDatePanel);
		
		JPanel exerciseDurationPanel = new JPanel();
		exerciseDurationPanel.add(lblExerciseDuration);
		exerciseDurationPanel.add(txtExerciseDuration);
		runWalkPanel.add(exerciseDurationPanel);
		
		JPanel exerciseDistancePanel = new JPanel();
		exerciseDistancePanel.add(lblExerciseDistance);
		exerciseDistancePanel.add(txtExerciseDistance);
		runWalkPanel.add(exerciseDistancePanel);
		
		return runWalkPanel; 
	}
	
	private JPanel getRockClimbingInputPanel() {
		JPanel rockClimbingPanel = new JPanel();
		BoxLayout runWalkLayout = new BoxLayout(rockClimbingPanel, BoxLayout.Y_AXIS);
		rockClimbingPanel.setLayout(runWalkLayout);
		
		JPanel exerciseNamePanel = new JPanel();
		exerciseNamePanel.add(lblExerciseName);
		exerciseNamePanel.add(txtExerciseName);
		rockClimbingPanel.add(exerciseNamePanel);
		
		JPanel exerciseDatePanel = new JPanel();
		exerciseDatePanel.add(lblExerciseDate);
		exerciseDatePanel.add(txtExerciseDate);
		rockClimbingPanel.add(exerciseDatePanel);
		
		JPanel exerciseDurationPanel = new JPanel();
		exerciseDurationPanel.add(lblExerciseDuration);
		exerciseDurationPanel.add(txtExerciseDuration);
		rockClimbingPanel.add(exerciseDurationPanel);
		
		JPanel exerciseWallHeightPanel = new JPanel();
		exerciseWallHeightPanel.add(lblExerciseWallHeight);
		exerciseWallHeightPanel.add(txtExerciseWallHeight);
		rockClimbingPanel.add(exerciseWallHeightPanel);
		
		JPanel exerciseRepititionsPanel = new JPanel();
		exerciseRepititionsPanel.add(lblExerciseRepititions);
		exerciseRepititionsPanel.add(txtExerciseRepititions);
		rockClimbingPanel.add(exerciseRepititionsPanel);
		
		return rockClimbingPanel; 
	}
	
	private JPanel getWeightLiftingInputPanel() {
		JPanel weightLiftingPanel = new JPanel();
		BoxLayout runWalkLayout = new BoxLayout(weightLiftingPanel, BoxLayout.Y_AXIS);
		weightLiftingPanel.setLayout(runWalkLayout);
		
		JPanel exerciseNamePanel = new JPanel();
		exerciseNamePanel.add(lblExerciseName);
		exerciseNamePanel.add(txtExerciseName);
		weightLiftingPanel.add(exerciseNamePanel);
		
		JPanel exerciseDatePanel = new JPanel();
		exerciseDatePanel.add(lblExerciseDate);
		exerciseDatePanel.add(txtExerciseDate);
		weightLiftingPanel.add(exerciseDatePanel);
		
		JPanel exerciseDurationPanel = new JPanel();
		exerciseDurationPanel.add(lblExerciseDuration);
		exerciseDurationPanel.add(txtExerciseDuration);
		weightLiftingPanel.add(exerciseDurationPanel);
		
		JPanel exerciseWeightLiftedPanel = new JPanel();
		exerciseWeightLiftedPanel.add(lblExerciseWeightLifted);
		exerciseWeightLiftedPanel.add(txtExerciseWeightLifted);
		weightLiftingPanel.add(exerciseWeightLiftedPanel);
		
		return weightLiftingPanel; 
	}
	
	public void enableAll() {
		cBox.setEnabled(true);
		if (cBox.getSelectedItem().equals("RunWalk")) {
			txtExerciseName.setEnabled(true);
			txtExerciseDate.setEnabled(true);
			txtExerciseDuration.setEnabled(true);
			txtExerciseDistance.setEnabled(true);
			txtExerciseComment.setEnabled(true);
			btnAddExercise.setEnabled(true);
		}
		else if (cBox.getSelectedItem().equals("RockClimbing")) {
			txtExerciseName.setEnabled(true);
			txtExerciseDate.setEnabled(true);
			txtExerciseDuration.setEnabled(true);
			txtExerciseRepititions.setEnabled(true);
			txtExerciseWallHeight.setEnabled(true);
			txtExerciseComment.setEnabled(true);
			btnAddExercise.setEnabled(true);
		}
		else {
			txtExerciseName.setEnabled(true);
			txtExerciseDate.setEnabled(true);
			txtExerciseDuration.setEnabled(true);
			txtExerciseWeightLifted.setEnabled(true);
			txtExerciseComment.setEnabled(true);
			btnAddExercise.setEnabled(true);
		}
	}
	
	public void disableAll() {
		cBox.setEnabled(false);
		txtExerciseListSummary.setEnabled(false);
		if (cBox.getSelectedItem().equals("RunWalk")) {
			txtExerciseName.setEnabled(false);
			txtExerciseDate.setEnabled(false);
			txtExerciseDuration.setEnabled(false);
			txtExerciseDistance.setEnabled(false);
			txtExerciseComment.setEnabled(false);
			btnAddExercise.setEnabled(false);
		}
		else if (cBox.getSelectedItem().equals("RockClimbing")) {
			txtExerciseName.setEnabled(false);
			txtExerciseDate.setEnabled(false);
			txtExerciseDuration.setEnabled(false);
			txtExerciseRepititions.setEnabled(false);
			txtExerciseWallHeight.setEnabled(false);
			txtExerciseComment.setEnabled(false);
			btnAddExercise.setEnabled(false);
		}
		else {
			txtExerciseName.setEnabled(false);
			txtExerciseDate.setEnabled(false);
			txtExerciseDuration.setEnabled(false);
			txtExerciseWeightLifted.setEnabled(false);
			txtExerciseComment.setEnabled(false);
			btnAddExercise.setEnabled(false);
		}
	}
	
	private boolean validateRunWalkEntry() {
		if (txtExerciseName.getText().trim().length() == 0) {
			return false;
		}
		else if (txtExerciseDate.getText().length() != 10) {
			return false;
		}
		else if (txtExerciseDuration.getText().length() == 0 || txtExerciseDuration.getText().charAt(txtExerciseDuration.getText().length() - 1) == '.' || Double.parseDouble(txtExerciseDuration.getText()) == 0.0) {
			return false;
		}
		else if (txtExerciseDistance.getText().length() == 0 || txtExerciseDistance.getText().charAt(txtExerciseDistance.getText().length() - 1) == '.' || Double.parseDouble(txtExerciseDistance.getText()) == 0.0) {
			return false; 
		}
		else {
			return true; 
		}
	}
	
	private boolean validateRockClimbingEntry() {
		if (txtExerciseName.getText().trim().length() == 0) {
			return false;
		}
		else if (txtExerciseDate.getText().length() != 10) {
			return false;
		}
		else if (txtExerciseDuration.getText().length() == 0 || txtExerciseDuration.getText().charAt(txtExerciseDuration.getText().length() - 1) == '.' || Double.parseDouble(txtExerciseDuration.getText()) == 0.0) {
			return false;
		}
		else if (txtExerciseWallHeight.getText().length() == 0 || txtExerciseWallHeight.getText().charAt(txtExerciseWallHeight.getText().length() - 1) == '.' || Double.parseDouble(txtExerciseWallHeight.getText()) == 0.0) {
			return false; 
		}
		else if (txtExerciseRepititions.getText().length() == 0 || txtExerciseRepititions.getText() == "0") {
			return false; 
		}
		else {
			return true; 
		}
	}
	
	private boolean validateWeightLiftingEntry() {
		if (txtExerciseName.getText().trim().length() == 0) {
			return false;
		}
		else if (txtExerciseDate.getText().length() != 10) {
			return false;
		}
		else if (txtExerciseDuration.getText().length() == 0 || txtExerciseDuration.getText().charAt(txtExerciseDuration.getText().length() - 1) == '.' || Double.parseDouble(txtExerciseDuration.getText()) == 0.0) {
			return false;
		}
		else if (txtExerciseWeightLifted.getText().length() == 0 || txtExerciseWeightLifted.getText().charAt(txtExerciseWeightLifted.getText().length() - 1) == '.' || Double.parseDouble(txtExerciseWeightLifted.getText()) == 0.0) {
			return false; 
		}
		else {
			return true; 
		}
	}

	
	private void clearInput() {
		txtExerciseName.setText("");
		txtExerciseDate.setText("");
		txtExerciseDuration.setText("");
		txtExerciseDistance.setText("");
		txtExerciseWeightLifted.setText("");
		txtExerciseRepititions.setText("");
		txtExerciseWallHeight.setText("");
		txtExerciseComment.setText("");
		
		txtExerciseName.setFocusable(true);
	}
	
	private void addExercise() {
		if (cBox.getSelectedItem().equals("RunWalk")) {
			RunWalk ne = new RunWalk(txtExerciseName.getText().trim(), txtExerciseDate.getText(), Double.parseDouble(txtExerciseDuration.getText()), Double.parseDouble(txtExerciseDistance.getText()), txtExerciseComment.getText().trim());
			exerciseList.add(ne);
			System.out.println("Updated List: " + ne.toString());
			txtExerciseListSummary.setText(ExerciseWriter.tabulateSummary(exerciseList));
			clearInput();
		}
		else if (cBox.getSelectedItem().equals("WeightLifting")) {
			WeightLifting ne = new WeightLifting(txtExerciseName.getText().trim(), txtExerciseDate.getText(), Double.parseDouble(txtExerciseDuration.getText()), Double.parseDouble(txtExerciseWeightLifted.getText()), txtExerciseComment.getText().trim());
			exerciseList.add(ne);
			txtExerciseListSummary.setText(ExerciseWriter.tabulateSummary(exerciseList));
			System.out.println("Updated List: " + ne.toString());
			clearInput();
		}
		else if (cBox.getSelectedItem().equals("RockClimbing")) {
			RockClimbing ne = new RockClimbing(txtExerciseName.getText().trim(), txtExerciseDate.getText(), Double.parseDouble(txtExerciseDuration.getText()), Double.parseDouble(txtExerciseWallHeight.getText()), Integer.parseInt(txtExerciseRepititions.getText()), txtExerciseComment.getText().trim());
			exerciseList.add(ne);
			txtExerciseListSummary.setText(ExerciseWriter.tabulateSummary(exerciseList));
			System.out.println("Updated List: " + ne.toString()); 
			clearInput();
		}
	}
	
	
	// constructor to build frame
	MainFrame() {
		// adding items to menus
		f.add(m1);
		f.add(m2);
		f.add(m3);
		f.add(m4);
		f.add(m5);
		
		h.add(h1);
		h.add(h2);
		
		// adding menus to menu bar
		mb.add(f);
		mb.add(h);
		
		// setting menu bar
		setMenuBar(mb);
		
		// creating frame layout
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		// creating layout for left side of frame for user input
		JPanel leftPane = new JPanel();		
		BoxLayout leftPaneLayout = new BoxLayout(leftPane, BoxLayout.Y_AXIS);
		leftPane.setLayout(leftPaneLayout);

		// creating layout for right side of frame for displaying users exercises
		JPanel rightPane = new JPanel();
		BoxLayout rightPaneLayout = new BoxLayout(rightPane, BoxLayout.Y_AXIS);
		rightPane.setLayout(rightPaneLayout);
		
		// setting user input area
		leftPane.add(lblExerciseType);
		leftPane.add(cBox);
		JPanel userInputPanel = new JPanel();
		userInputPanel.add(getRunWalkInputPanel());
		leftPane.add(userInputPanel);
		
		// setting comment sections
		leftPane.add(lblExerciseComment);
		leftPane.add(txtExerciseComment);
		
		c.add(leftPane, BorderLayout.WEST);
		
		// setting list of exercises
		rightPane.add(lblExerciseSummary);
		txtExerciseListSummary.setText("Name\tType\tDate\tCalories Burned\n=====================================================");
		rightPane.add(txtExerciseListSummary);
		c.add(rightPane, BorderLayout.EAST);
		
		// setting buttons
		c.add(btnAddExercise, BorderLayout.SOUTH);
		
		// setting event listeners for menu "File"
		m1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// prompt login frame to login user
				LoginFrame loginFrame = LoginFrame.V(app);
				loginFrame.setVisible(rootPaneCheckingEnabled);
			} 
        });
		
		m2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// prompt logout frame to logout user
				disableAll();
			}
		});
		
		m3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// prompt user to save exercises to specified file
				if (exerciseList.size() == 0) { return; }
				
				fileChooser.setDialogTitle("Save To File");
				int userSelection = fileChooser.showSaveDialog(c);
				
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					
					if (ExerciseWriter.writeToFile(exerciseList, selectedFile)) {
						// returns when exercises successfully saved
						System.out.println("Successfully Saved");
					}
					else {
						// returns if failed to save to selected file
						System.out.println("Failed To save to file"); 
					}
				}
				
			}
		});
		
		m4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// prompt user to load exercises from file
				
			}
		});
		
		m5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// prompt user to save if their are exercises to save
				if (exerciseList.size() > 0) {
					int userSelection = fileChooser.showSaveDialog(c);
					
					if (userSelection == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fileChooser.getSelectedFile();
						
						if (ExerciseWriter.writeToFile(exerciseList, selectedFile)) {
							// returns when exercises successfully saved
							System.out.println("Successfully Saved");
						}
						else {
							// returns if failed to save to selected file
							System.out.println("Failed to save to file"); 
						}
					}
				}
				
				// close program
				MainFrame.app.dispose();
			}
		});
		
		// setting event listener for help 
		h1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// display help box
				JOptionPane.showMessageDialog(null, "Username: healthy\nPassword: donut", "Login Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		h2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// display help box
				JOptionPane.showMessageDialog(null, "1. The COMMENT text area is the only optional field. All others must be filled.", "Adding Exercises Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		// listeners for add exercise button
		btnAddExercise.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// check user input and add exercise done to list
				if (cBox.getSelectedItem() == "RunWalk") {
					if (!validateRunWalkEntry()) {
						JOptionPane.showMessageDialog(null, "Not all mandatory fields are correct", "ExerciseTracker", JOptionPane.ERROR_MESSAGE );
						return; 
					}
				}
				else if (cBox.getSelectedItem() == "RockClimbing") {
					if (!validateRockClimbingEntry()) {
						JOptionPane.showMessageDialog(null, "Not all mandatory fields are correct", "ExerciseTracker", JOptionPane.ERROR_MESSAGE );
						return; 
					}
				}
				else if (cBox.getSelectedItem() == "WeightLifting") {
					if (!validateWeightLiftingEntry()) {
						JOptionPane.showMessageDialog(null, "Not all mandatory fields are correct", "ExerciseTracker", JOptionPane.ERROR_MESSAGE );
						return; 
					}
				}
				
				// call function to add exercise to application
				addExercise(); 
			}
		});
		
		// listener for combo box change
		cBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// changes panel on change
				
				userInputPanel.removeAll();
				
				if (cBox.getSelectedItem().equals("RunWalk")) {
					userInputPanel.add(getRunWalkInputPanel());
				}
				else if (cBox.getSelectedItem().equals("RockClimbing")) {
					userInputPanel.add(getRockClimbingInputPanel());
				}
				else if (cBox.getSelectedItem().equals("WeightLifting")) {
					userInputPanel.add(getWeightLiftingInputPanel());
				}
			}
			
		});
		
		// listeners for text fields
		txtExerciseDate.addKeyListener(new KeyAdapter() {
			// constraints user input to date format
			public void keyTyped(KeyEvent e) {
				String currValue = txtExerciseDate.getText().trim();
				if (currValue.length() == 10) {
					e.consume();
				}
				else if (currValue.length() == 2 || currValue.length() == 5) {
					if (e.getKeyChar() != '/') {
						e.consume();
					}
				}
				else {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
			}
		});
		
		txtExerciseDuration.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// constraints user to input double value
				String currValue = txtExerciseDuration.getText().trim();
				if (e.getKeyChar() == '.') {
					if (currValue.contains(".")) {
						e.consume();
					}
				}
				else if (currValue.length() > 15) {
					e.consume();
				}
				else {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
			}
		});
		
		txtExerciseDistance.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// constraints user to input double value
				String currValue = txtExerciseDistance.getText().trim();
				if (e.getKeyChar() == '.') {
					if (currValue.contains(".")) {
						e.consume();
					}
				}
				else if (currValue.length() > 15) {
					e.consume();
				}
				else {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
			}
		});
		
		txtExerciseWallHeight.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// constraints user to input double value
				String currValue = txtExerciseWallHeight.getText().trim();
				if (e.getKeyChar() == '.') {
					if (currValue.contains(".")) {
						e.consume();
					}
				}
				else if (currValue.length() > 15) {
					e.consume();
				}
				else {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
			}
		});
		
		txtExerciseWeightLifted.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// constraints user to input double value
				String currValue = txtExerciseWeightLifted.getText().trim();
				if (e.getKeyChar() == '.') {
					if (currValue.contains(".")) {
						e.consume();
					}
				}
				else if (currValue.length() > 15) {
					e.consume();
				}
				else {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
			}
		});
		
		txtExerciseRepititions.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// constraints user to input double value
				String currValue = txtExerciseRepititions.getText().trim();
				if (currValue.length() > 15) {
					e.consume();
				}
				else {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
			}
		});
		
		
		// disabling everything for login 
		disableAll(); 
		
		// styling labels
		lblExerciseName.setLabelFor(txtExerciseName);
		
		// styling text fields
		
		// styling buttons
		
		// styling list box
		
	}
	
	public static void main(String[] args) {
		app = new MainFrame(); 
		app.setTitle("Exercise Tracker");
		app.setVisible(true);
		app.setSize(800,425);
		app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		app.setLocationRelativeTo(null); // Center the frame
	}
	
	public class ExerciseRenderer extends JTextField implements ListCellRenderer<Exercise> {

		@Override
		public Component getListCellRendererComponent(JList<? extends Exercise> list, Exercise value, int index,
				boolean isSelected, boolean cellHasFocus) {
			setText(value.toString());
			return this; 
		}
	     
	}
}
