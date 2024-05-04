package application;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	// Main frame init
	public static MainFrame app = new MainFrame(); 
	
	// menu bar menus
	Menu f = new Menu("File");
	Menu h = new Menu("Help"); 
	
	// menu items for menu File
	MenuItem m1 = new MenuItem("Login");
	MenuItem m2 = new MenuItem("Logout");
	
	// menu bar for main frame
	MenuBar mb = new MenuBar(); 
	 
	
	// constructor to build frame
	MainFrame() {
		// adding items to menus
		f.add(m1);
		f.add(m2);
		
		// adding menus to menu bar
		mb.add(f);
		mb.add(h);
		
		// setting menu bar
		this.setMenuBar(mb);
		
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
				
			}
		});
	}
	
	public static void main(String[] args) {
		app = new MainFrame(); 
		app.setTitle("Exercise Tracker");
		app.setVisible(true);
		app.setSize(500,200);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setLocationRelativeTo(null); // Center the frame
	}
}
