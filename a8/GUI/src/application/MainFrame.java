/**
 * file: MainFrame
 * 
 * This class is the Main for the GUI application holding all components and component logic necessary for the application of the main page
 * 
 * SUMMARY
 * Application is an Exercise Tracker, allowing a user to input exercises and being able to see all of their exercises summarized by the exercise date,
 * custom name, exercise duration, and the calories burned. The user can choose to save these exercises to a file for later use and load the exercises
 * as wanted.
 * 
 * User must login with the username: healthy, and the password: donut in order to use the application. 
 * 
 * MEMBERS
 * - STATIC app	(this is the main object of the application. This is a JFrame)
 * - exerciseTypes	(this is a list of the exercsie types a user can input. needed for combo box)
 * - exerciseList	(this is a list of the exercises currently input or stored for the app to use)
 * 
 * COMPONENTS
 * - JFileChooser fileChooser			(this is the JfileChooser dialog that enables a user to choose a file to store their exercises to)
 * - Menu f								(The file menu object that holds menu items to load exercises, save exercises, login, logout, and exit the program)
 * - Menu h								(The file menu object that holds menu items for various help tips)
 * - MenuItem m1						(Clickable menu item found in file menu to login user)
 * - MenuItem m2						(Clicable menu item found in file menu to logout user)
 * - MenuItem m3						(Clickable menu item found in file menu to load the file chooser to save exercises to file)
 * - MenuItem m4						(Clicable menu item found in file menu to load the file chooser to load exercies from file)
 * - MenuItem m5						(Clickable menu item found in file menu to exit the program)
 * - MenuItem h1						(Clickable menu item found in help menu that gives tips to login)
 * - MenuItem h2 						(Clickable menu item found in help menu that gives tips to adding exercises)
 * - MenuBar mb							(Menu bar that holds menus atop of JFrame)
 * - JLabel lblExericesName				(Label that pairs with JTextField for inputting exercise name)
 * - JLabel lblExericesDate				(Label that pairs with JTextField for inputting exercise date)
 * - JLabel lblExericesDuration			(Label that pairs with JTextField for inputting exercise duration (in minutes))
 * - JLabel lblExericesDistance			(Label that pairs with JTextField for inputting exercise distance for RunWalk exercise type (in miles))
 * - JLabel lblExericesAmountLifted		(Label that pairs with JTextField for inputting exercise amount lifted for WeightLifting exercise type (in pounds))
 * - JLabel lblExericesWallHeight		(Label that pairs with JTextField for inputting exercise height of wall for RockClimbing exercise type (in feet))
 * - JLabel lblExericesRepititions		(Label that pairs with JTextField for inputting exercise repititions for RockClimbing exercise type)
 * - JLabel lblExericesComment			(Label that pairs with JTextArea for inputting comments for specific exercise)
 * - JLabel lblExericesSummary			(Label that pairs with JTextArea for displaying list of all exercises in summary format)
 * - JLabel lblExericesType				(Label that pairs with JComboBox for selecting differing types of exercises to input)
 * - JTextField txtExerciseName				(TextField to input exercise name)
 * - JTextField txtExerciseDate				(TextField to input exercise date)
 * - JTextField txtExerciseDuration			(TextField to input exercise duration (in minutes))
 * - JTextField txtExerciseDistance			(TextField to input exercise distance (in miles))
 * - JTextField txtExerciseWeightLifted		(TextField to input exercise amount lifted (in pounds))
 * - JTextField txtExerciseWallHeight		(TextField to input exercise rock wall height (in feet))
 * - JTextField txtExerciseRepititions		(TextField to input exercise repititions for scaling rock wall)
 * - JTextField txtExerciseDuration			(TextField to input exercise duration (in minutes))
 * - JComboBox cBox						(Combo box that holds exercise types allowing user to select which to input)
 * - JTextArea txtExerciseComment		(TextArea that user can add comments for specific exercises)
 * - JTextArea txtExerciseSummary		(TextArea that displays users inputted exercises. Is disabled)
 * - JButton btnAddExercise				(Button used to add an exercise to the list)
 * 
 * METHODS
 * - getRunWalkInputPanel()				(Returns JFrame that holds all input fields specific to a RunWalk exercise)
 * - getWeightLiftingInputPanel()		(Returns JFrame that holds all input fields specific to a WeightLifting exercise)
 * - getRockClimbingInputPanel()		(Returns JFrame that holds all input fields specific to a Rockclimbing exercise)
 * - enableAll()						(When called enables all necessary components for application use)
 * - disableAll()						(When called disables all components besides menu bar)
 * - validateRunWalkEntry()				(Checks input fields for RunWalk entry making sure they are all valid before adding exercise)
 * - validateRockClimbingEntry()		(Checks input fields for RockClimbing entry making sure they are all valid before adding exercise)
 * - validateWeightLiftingEntry()		(Checks input fields for WeightLifting entry making sure they are all valid before adding exercise)
 * - clearInput()						(Clears all input fields)
 * - addExercise()						(Takes in user input for each specific exercise type and creates that type as a new Exercise to store in the list and display on screen)
 * 
 * CONSTRUCTORS
 * - 1 Constructor that holds all build logic for the application. Creating containers and arranging components for screen display plus listeners
 * 
 * STATIC MAIN
 * - Main() 							(Static main method for application to launch)
 */
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
	private final JLabel lblExerciseDuration = new JLabel("Duration (Minutes)");
	private final JLabel lblExerciseDistance = new JLabel("Distance (Miles)");
	private final JLabel lblExerciseWallHeight = new JLabel("Wall Height (Feet)");
	private final JLabel lblExerciseRepititions = new JLabel("Repititions");
	private final JLabel lblExerciseWeightLifted = new JLabel("Weight Lifted (Pounds)");
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
	/**
	 * 
	 * @return	(Returns JPanel for input of RunWalk exercise)
	 */
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
	
	/**
	 * 
	 * @return	(Returns JPanel for input of RockClimbing exercise)
	 */
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
	
	/**
	 * 
	 * @return	(Returns JPanel for input of WeightLifting exercise)
	 */
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
	
	/**
	 * Method enables all necessary components for application use
	 */
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
	
	/**
	 * Method disables all components except for menu bar
	 */
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
	
	/**
	 * 
	 * @return	(Returns true if all required input fields are used and validated for creating a RunWalk exercise, Returns false otherwise)
	 */
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
	
	/**
	 * 
	 * @return	(Returns true if all required input fields are used and validated for creating a RockClimbing exercise, Returns false otherwise)
	 */
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
	
	/**
	 * 
	 * @return	(Returns true if all required input fields are used and validated for creating a WeightLifting exercise, Returns false otherwise)
	 */
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

	/**
	 * Method clears all input fields setting them back to an empty string
	 */
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
	
	/**
	 * Exercise calls validation methods and if true creates selected Exercise object and adds it to the list. Then clears all input. 
	 */
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
	
	
	/**
	 * Constructor for Main Frame which builds the display using all components and holds logic for event listeners necessary for application functionality
	 */
	MainFrame() {
		// adding file items to menu
		f.add(m1);
		f.add(m2);
		f.add(m3);
		f.add(m4);
		f.add(m5);
		
		// adding help items to menu
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
		/**
		 * Event Listener that runs when login button from file menu is clicked
		 * - Launches LoginFrame atop of Main Frame to get handle login validation
		 */
		m1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// prompt login frame to login user
				LoginFrame loginFrame = LoginFrame.V(app);
				loginFrame.setVisible(rootPaneCheckingEnabled);
			} 
        });
		
		/**
		 * Event Listener that runs when logout button from file menu is clicked
		 * - Simply disables all except for menu bar acting for no logged in user
		 */
		m2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// prompt logout frame to logout user
				disableAll();
			}
		});
		
		/**
		 * Event Listener that runs when save button from file menu is clicked
		 * - checks for list entries and if there are any launches the file selector dialog needed to saving to file
		 * - handles both success and failed save
		 */
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
		
		/**
		 * Event Listener that runs when load button is clicked from file menu	
		 * - Will launch file chooser to select a file wich saved exercises to load to list and display	
		 * 
		 * NOT IMPLMENTED YET
		 */
		m4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// prompt user to load exercises from file
				
			}
		});
		
		/**
		 * Event Listener for when exit button is clicked from file menu
		 * - checks for an entries and if there are any prompts user to choose a file to save to. Whether user chooses a file or not the program then terminates
		 */
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
		/**
		 * Event Listener for when user clicks on login help button from help menu
		 * - Simply displays a message dialog to help in logging in
		 */
		h1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// display help box
				JOptionPane.showMessageDialog(null, "Username: healthy\nPassword: donut", "Login Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		/**
		 * Event Listener for when user clicks on add exercises help button from help menu
		 * - Simply displays a message dialog to help the user in adding an exercise to the list
		 */
		h2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// display help box
				JOptionPane.showMessageDialog(null, "1. The COMMENT text area is the only optional field. All others must be filled.", "Adding Exercises Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		// listeners for add exercise button
		/**
		 * Event Listener for when button to add exercise is clicked
		 * - This will validate the user entered appropriate data for adding an exercise and then once that is done call the addExerciseFunction
		 * - Displays error dialog if validation fails. 
		 */
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
		/**
		 * Event Listener for when user selects a different item from combo box
		 * - Checks for change in item selection and updates the input frame as necessary for the specific exercise type
		 * 
		 * CURRENT BUG: On Change the display shows a gray box over half of the input frame. Only goes away upon reselecting item in combo box.
		 */
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
		/**
		 * Event Listener for when user tries to type a character to the date text field
		 * - handles the on type override function which makes sure the user can't type anything other than a number and a / at the appropriate locations in the string
		 * - enforces the date format mm/dd/yyyy
		 */
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
		
		/**
		 * Event Listener for when a user tries to type a entry to the duration text field
		 * - Makes sure that the user can only type numbers and a single period for decimal numbers
		 */
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
		
		/**
		 * Event Listener for when a user tries to type a entry to the distance text field
		 * - Makes sure that the user can only type numbers and a single period for decimal numbers
		 */
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
		
		/**
		 * Event Listener for when a user tries to type a entry to the wall height text field
		 * - Makes sure that the user can only type numbers and a single period for decimal numbers
		 */
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
		
		/**
		 * Event Listener for when a user tries to type a entry to the weight lifted text field
		 * - Makes sure that the user can only type numbers and a single period for decimal numbers
		 */
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
		
		/**
		 * Event Listener for when a user tries to type a entry to the repititions text field
		 * - Makes sure that the user can only whole numbers 
		 */
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
	
	/**
	 * 
	 * @param args
	 * 
	 * Main Function that initiates app object and launches the main frame to the screen
	 */
	public static void main(String[] args) {
		app = new MainFrame(); 
		app.setTitle("Exercise Tracker");
		app.setVisible(true);
		app.setSize(800,425);
		app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		app.setLocationRelativeTo(null); // Center the frame
	}
}
