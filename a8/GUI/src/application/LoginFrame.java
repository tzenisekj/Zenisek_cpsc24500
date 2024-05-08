/**
 * file: LoginFrame
 * 
 * Custom Dialog that displays a frame dedicated to a user being able to login and use the application
 * 
 */
package application;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.*;

@SuppressWarnings("serial")
class LoginFrame extends JDialog {
	
    private static LoginFrame v;
  //  JFrame parent;
    public static LoginFrame V(JFrame parent) {
    	if (v == null)
    		v = new LoginFrame(parent);
    	return v;
    }
    private final JLabel lblUsername = new JLabel("Username");
    private final JLabel lblPassword = new JLabel("Password");

    private final JTextField txtUsername = new JTextField(15);
    private final JPasswordField txtPassword = new JPasswordField(15);

    private final JButton btnLogin = new JButton("Login");
    private final JButton btnCancel = new JButton("Cancel");
    


    private LoginFrame() {
        this(null);
    }

    private LoginFrame(final JFrame parent) {
        super(parent, "Log in window");
       
        //code for creating the frame needed here...
        setBounds(300,150,300,150);
        setLocationRelativeTo(null);
		
        // setting up components
        Container c = this.getContentPane(); 
        c.setLayout(new BorderLayout());
        
        JPanel usernameInput = new JPanel();
        usernameInput.add(lblUsername);
        usernameInput.add(txtUsername);
        
        JPanel passwordInput = new JPanel();
        passwordInput.add(lblPassword);
        passwordInput.add(txtPassword);
        
        JPanel buttons = new JPanel();
        buttons.add(btnLogin); 
        buttons.add(btnCancel);
 
        c.add(usernameInput, BorderLayout.NORTH);
        c.add(passwordInput, BorderLayout.CENTER);
        c.add(buttons, BorderLayout.SOUTH);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//note how we get the password text from JTextPassword
            	String strPassword = String.valueOf(txtPassword.getPassword());
            	String strUsername = txtUsername.getText().trim();
            	
                if (verifyLogin(strUsername, strPassword)) {
                    parent.setVisible(true);
                    //Uncomment when MainWindow is ready (or Whatever you call the Main Frame for the application)
                    ((MainFrame) parent).enableAll(); 
                    txtPassword.setText("");
                    txtUsername.setText("");
                    setVisible(false);
                } else {
                	//play around with the options
                	JOptionPane.showMessageDialog(null, "Incorrect username/password", "Login", JOptionPane.ERROR_MESSAGE );
                }
            }

			private boolean verifyLogin(String strUsername, String strPassword) {
				//write the logic here
				String USERNAME = "healthy";
				String PASSWORD = "donut";
				
				if (strPassword.equals(PASSWORD) && strUsername.equals(USERNAME))
					return true;
				else
					return false; 
			}
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txtPassword.setText("");
            	txtUsername.setText("");
                setVisible(false);
            }
        });
    }
}