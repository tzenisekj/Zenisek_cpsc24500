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
    private final JPasswordField txtPassword = new JPasswordField();

    private final JButton btnLogin = new JButton("Login");
    private final JButton btnCancel = new JButton("Cancel");
    


    private LoginFrame() {
        this(null);
    }

    private LoginFrame(final JFrame parent) {
        super(parent, "Log in window");
       
        //code for creating the frame needed here...
        setBounds(500,200,500,200);
        setLocationRelativeTo(null);
		
        // setting up components
        Container c = this.getContentPane(); 
        c.setLayout(new BorderLayout());
        
        JPanel input = new JPanel(); 
        input.add(lblUsername);
        input.add(lblPassword);
        input.add(txtUsername);
        input.add(txtPassword);
        
        JPanel buttons = new JPanel();
        buttons.add(btnLogin); 
        buttons.add(btnCancel);
        
        c.add(input, BorderLayout.CENTER);
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
                    //((MainWindow) parent).endableAll(); 
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