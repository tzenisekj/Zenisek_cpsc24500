package application;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Modal.Exercise;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	// Main frame init
	private static MainFrame app = new MainFrame(); 
	
	// variables
	private final String[] exerciseTypes = { "RunWalk", "RockClimbing", "WeightLifting" };
	
	// menu bar menus
	private final Menu f = new Menu("File");
	private final Menu h = new Menu("Help"); 
	
	// menu items for menu File
	private final MenuItem m1 = new MenuItem("Login");
	private final MenuItem m2 = new MenuItem("Logout");
	
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
	private final JTextField txtExerciseName = new JTextField(15);
	private final JTextField txtExerciseDuration = new JTextField(15);
	private final JTextField txtExerciseDate = new JTextField(15);
	private final JTextField txtExerciseDistance = new JTextField(15);
	private final JTextField txtExerciseWallHeight = new JTextField(15);
	private final JTextField txtExerciseRepititions = new JTextField(15);
	private final JTextField txtExerciseWeightLifted = new JTextField(15);
	
	// combo box for exercise type
	private final JComboBox cBox = new JComboBox(exerciseTypes);
	
	// text area for user comment input
	private final JTextArea txtExerciseComment = new JTextArea();
	
	// list box to store adding exercises
	private final JList listBox = new JList();
	
	// buttons
	private final JButton btnAddExercise = new JButton("Add Exercise");
	
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
	
	// constructor to build frame
	MainFrame() {
		// adding items to menus
		f.add(m1);
		f.add(m2);
		
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
		rightPane.add(listBox);
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
		
		// listeners for add exercise button
		btnAddExercise.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// check user input and add exercise done to list
				
			}
		});
		
		// listener for combo box change
		cBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		
		// disabling everything for login 
		cBox.setEnabled(false);
		txtExerciseName.setEnabled(false);
		txtExerciseDate.setEnabled(false);
		txtExerciseDuration.setEnabled(false);
		txtExerciseDistance.setEnabled(false);
		txtExerciseComment.setEnabled(false);
		btnAddExercise.setEnabled(false);
		
	}
	
	public static void main(String[] args) {
		app = new MainFrame(); 
		app.setTitle("Exercise Tracker");
		app.setVisible(true);
		app.setSize(1000,750);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setLocationRelativeTo(null); // Center the frame
	}
}
