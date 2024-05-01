package application; 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Main extends Application {
	private boolean isLoggedIn = false; 
	public final Stage mainStage = new Stage(); 
	
	public boolean getIsLoggedIn() { return isLoggedIn; }
	public void setIsLoggedIn() { this.isLoggedIn = !this.isLoggedIn; }
	
    public static void main(String[] args) {
        launch(args);
    }

    public Stage getFailedLoginStage() {
    	Stage failedLoginStage = new Stage();
    	StackPane r = new StackPane();
    	
    	Text t = new Text("Username or Password invalid. Please try again...");
    	
    	Button closeBtn = new Button("Close");
    	closeBtn.setOnAction(new EventHandler<ActionEvent>() {
    		// handles on click or on submit
    		@Override
    		public void handle(ActionEvent e) {
    			failedLoginStage.close();
    		}
    	});
    	
    	StackPane.setMargin(closeBtn, new Insets(75,0,0,0));
    
    	r.getChildren().add(t);
    	r.getChildren().add(closeBtn);
    	failedLoginStage.setScene(new Scene(r, 300, 125));
    	
    	return failedLoginStage; 
    }
    
    public Stage getLogoutStage() {
    	Stage logoutStage = new Stage();
    	StackPane r = new StackPane();
    	
    	Text t = new Text("Are you sure you want to logout?");
    	
    	Button logoutBtn = new Button("Logout");
    	logoutBtn.setOnAction(new EventHandler<ActionEvent>() {
    		// handles on click or on submit
    		@Override
    		public void handle(ActionEvent e) {
    			setIsLoggedIn();
    			start(mainStage);
    			logoutStage.close();
    		}
    	});
    	
    	Button cancelBtn = new Button("Cancel");
    	cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
    		// handles on click or on submit
    		@Override
    		public void handle(ActionEvent e) {
    			logoutStage.close();
    		}
    	});
    	
    	StackPane.setMargin(logoutBtn, new Insets(75,100,0,0));
    	StackPane.setMargin(cancelBtn, new Insets(75,0,0,100));
    	
    	r.getChildren().add(cancelBtn);
    	r.getChildren().add(logoutBtn);
    	r.getChildren().add(t);
    	logoutStage.setScene(new Scene(r, 200, 125));
    	return logoutStage; 
    }
    
    public Stage getLoginStage() {
    	final String USERNAME = "healthy"; 
    	final String PASSWORD = "donut"; 
    	
    	Stage loginStage = new Stage(); 
    	loginStage.setTitle("Please log in");
    	
    	//Creating a GridPane container
    	GridPane grid = new GridPane();
    	grid.setPadding(new Insets(10, 10, 10, 10));
    	grid.setVgap(5);
    	grid.setHgap(5);
    	grid.setAlignment(Pos.CENTER);
    	
    	//Defining the userName text field
    	Label usernameLabel = new Label("Username"); 
    	final TextField userName = new TextField();
    	userName.setPromptText("Enter your username.");
    	userName.setPrefColumnCount(10);
    	userName.getText();
    	
    	GridPane.setConstraints(usernameLabel, 0, 0);
    	GridPane.setConstraints(userName,0,1);
    	grid.getChildren().add(userName);
    	grid.getChildren().add(usernameLabel); 
    	
    	//Defining the Password text field
    	Label passwordLabel = new Label("Password");
    	final TextField password = new TextField();
    	password.setPromptText("Enter your password.");
    	GridPane.setConstraints(passwordLabel, 0, 3);
    	GridPane.setConstraints(password, 0, 4);
    	grid.getChildren().add(password);
    	grid.getChildren().add(passwordLabel);
    	
    	//Defining the Submit button
    	Button submit = new Button("Submit");
    	submit.setOnAction(new EventHandler<ActionEvent>() {
    		// handles on click or on submit
    		@Override
    		public void handle(ActionEvent e) {
    			if (userName.getText().equals(USERNAME) && password.getText().equals(PASSWORD)) {
    				// logging in with valid credentials
    				setIsLoggedIn();
    				start(mainStage);
    				loginStage.close();
    			}
    			else {
    				getFailedLoginStage().show();
    			}
    		}
    	});
    	GridPane.setConstraints(submit, 0, 5);
    	grid.getChildren().add(submit);
    	
    	//Defining the Cancel button
    	Button cancelBtn = new Button("Cancel");
    	cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent e) {
    			loginStage.close();
    		}
    	});
    	GridPane.setConstraints(cancelBtn, 0, 5);
    	GridPane.setMargin(cancelBtn, new Insets(0,0,0,100));
    	grid.getChildren().add(cancelBtn);
    	
    	loginStage.setScene(new Scene(grid, 400, 400));
    	
    	return loginStage; 
    }
    
	@Override
    public void start(Stage primaryStage) {
		// variables
		
		// Creating File Menu
		Menu f = new Menu("File");
		
		// File menu items
		MenuItem m1 = new MenuItem("Login"); 
		
		m1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				getLoginStage().show();
			}
		});
		
		MenuItem m2 = new MenuItem("Logout"); 
		
		m2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				getLogoutStage().show();
			}
		});
		
		// Adding File menu items
		if (getIsLoggedIn()) { f.getItems().add(m2); }
		else { f.getItems().add(m1); }
		
		// Creating Help Menu
		Menu h = new Menu("Help"); 
		
		// Creating menu bar
		MenuBar mb = new MenuBar(); 
		
		// adding menus to menu bar
		mb.getMenus().add(f);
		mb.getMenus().add(h); 
		
		// setting menu bar in VBox atop of Stage
		VBox vb = new VBox(mb); 
		
		
		// Set Stage
        mainStage.setTitle("Exercise Tracker");
        
        StackPane root = new StackPane();
        root.getChildren().add(vb);
        mainStage.setScene(new Scene(root, 700, 450));
        mainStage.show();
    }
}
