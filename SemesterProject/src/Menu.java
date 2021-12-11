import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Run the program via the ATM class
//If you run it here, you will not be able to log in as a list of User objects is never created
public class Menu extends Application{
	
	User user = new User();

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ATM");
		
		///////////////Transaction Menu
		GridPane gridTransaction = new GridPane();
		gridTransaction.setVgap(10);
		gridTransaction.setHgap(10);
		gridTransaction.setAlignment(Pos.CENTER);
		gridTransaction.setPadding(new Insets(10));
		
		//Display balances
		Label checkingBalance = new Label();
		gridTransaction.add(checkingBalance, 0, 0);
		Label savingsBalance = new Label();
		gridTransaction.add(savingsBalance, 1, 0);
		

		//Objects used in making a transaction
		Label action = new Label();
		TextField amountText = new TextField();
		Button confirm = new Button("Confirm");
		
		//Deposit into checking account
		Button depositChecking= new Button("Deposit into Checking Account");
		gridTransaction.add(depositChecking, 0, 1);
		depositChecking.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				gridTransaction.add(action, 0, 7);
				gridTransaction.add(amountText, 0, 8);
				gridTransaction.add(confirm, 0, 9);
				action.setText("Enter amount to deposit");
				
				confirm.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						
						try {
							Integer amount = Integer.parseInt(amountText.getText());
							user.checking.deposit(amount);
							checkingBalance.setText("Checking Account: $" + Integer.toString( user.checking.balance));
							gridTransaction.getChildren().remove(action);
							gridTransaction.getChildren().remove(confirm);
							gridTransaction.getChildren().remove(amountText);
						}catch(NumberFormatException ex) {
							action.setText("Amount must be a number");
						}
						
						
					}});
			}
			
		});
		
		//Deposit into savings account
		Button depositSavings= new Button("Deposit into Savings Account");
		gridTransaction.add(depositSavings, 0, 2);
		depositSavings.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				gridTransaction.add(action, 0, 7);
				gridTransaction.add(amountText, 0, 8);
				gridTransaction.add(confirm, 0, 9);
				action.setText("Enter amount to deposit");
				
				confirm.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						
						try {
							Integer amount = Integer.parseInt(amountText.getText());
							user.savings.deposit(amount);
							savingsBalance.setText("Savings account: $" + Integer.toString(user.savings.balance));
							gridTransaction.getChildren().remove(action);
							gridTransaction.getChildren().remove(confirm);
							gridTransaction.getChildren().remove(amountText);
						}catch(NumberFormatException ex) {
							action.setText("Amount must be a number");
						}
						
					}});
				
			}
			
		});
		
		//Withdraw from checking account
		Button withdraw= new Button("Withdraw from Checking Account");
		gridTransaction.add(withdraw, 0, 3);
		withdraw.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				gridTransaction.add(action, 0, 7);
				gridTransaction.add(amountText, 0, 8);
				gridTransaction.add(confirm, 0, 9);
				action.setText("Enter amount to withdraw");
				
				confirm.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						
						try {
							Integer amount = Integer.parseInt(amountText.getText());
							user.checking.withdraw(amount);
							checkingBalance.setText("Checking account: $" + Integer.toString(user.checking.balance));
							gridTransaction.getChildren().remove(action);
							gridTransaction.getChildren().remove(confirm);
							gridTransaction.getChildren().remove(amountText);
						}catch(NumberFormatException ex) {
							action.setText("Amount must be a number");
						}
						
						
						
					}});
				
			}
			
		});
		
		//Transfer funds from savings account to checking account
		Button transferToChecking = new Button("Transfer money into Checking Account");
		gridTransaction.add(transferToChecking, 0, 4);
		transferToChecking.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				
				gridTransaction.add(action, 0, 7);
				gridTransaction.add(amountText, 0, 8);
				gridTransaction.add(confirm, 0, 9);
				action.setText("Enter amount to transfer");
				
				confirm.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						
						try {
							Integer amount = Integer.parseInt(amountText.getText());
							user.savings.transferToChecking(amount, user.checking);
							checkingBalance.setText("Checking account: $" + Integer.toString(user.checking.balance));
							savingsBalance.setText("Savings account: $" + Integer.toString(user.savings.balance));
							gridTransaction.getChildren().remove(action);
							gridTransaction.getChildren().remove(confirm);
							gridTransaction.getChildren().remove(amountText);
						}catch(NumberFormatException ex) {
							action.setText("Amount must be a number");
						}
						
						
						
					}});
				
			}
			
		});
		
		//Transfer funds from checking account to savings account
		Button transferToSavings= new Button("Transfer money into Savings Account");
		gridTransaction.add(transferToSavings, 0, 5);
		transferToSavings.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				gridTransaction.add(action, 0, 7);
				gridTransaction.add(amountText, 0, 8);
				gridTransaction.add(confirm, 0, 9);
				action.setText("Enter amount to transfer");
				confirm.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						try {
							Integer amount = Integer.parseInt(amountText.getText());
							user.checking.transferToSavings(amount, user.savings);
							checkingBalance.setText("Checking account: $" + Integer.toString(user.checking.balance));
							savingsBalance.setText("Savings account: $" + Integer.toString(user.savings.balance));
							gridTransaction.getChildren().remove(action);
							gridTransaction.getChildren().remove(confirm);
							gridTransaction.getChildren().remove(amountText);
						}catch(NumberFormatException ex) {
							action.setText("Amount must be a number");
						}
						
						
					}});	
			}
		});
		
		//Display the account's information
		Text infoText = new Text();
		gridTransaction.add(infoText, 0, 10);
		Button info = new Button("Display Info");
		gridTransaction.add(info, 0, 6);
		info.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				infoText.setText(user.toString());
						
			}
					
		});
		
		
		///////////////Login menu
		GridPane gridLogin = new GridPane();
		gridLogin.setVgap(10);
		gridLogin.setHgap(10);
		gridLogin.setAlignment(Pos.CENTER);
		gridLogin.setPadding(new Insets(10));
		
		//Header
		Text loginText = new Text("Login");
		gridLogin.add(loginText, 0, 0);
		
		//Username
		Label usernameLabel = new Label("Username");
		gridLogin.add(usernameLabel, 0, 1);
		
		TextField username = new TextField();
		username.setPromptText("username");
		gridLogin.add(username, 1, 1);
		
		//Password
		Label passwordLabel = new Label("Password");
		gridLogin.add(passwordLabel, 0, 2);
		
		PasswordField password = new PasswordField();
		password.setPromptText("password");
		gridLogin.add(password, 1, 2);
		
		//Attempt to log into an account
		Button loginButton = new Button("Login");
		gridLogin.add(loginButton, 1, 3);
		loginButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
			
				if(ATM.Login(username.getText(), password.getText()) != null) {
					user = ATM.Login(username.getText(), password.getText());
					primaryStage.setScene(new Scene(gridTransaction, 400, 500));
					primaryStage.show();
					checkingBalance.setText("Checking account: $"+ Integer.toString(user.checking.balance));
					savingsBalance.setText("Savings account: $" + Integer.toString(user.savings.balance));
				}else {
					System.out.println("Login failed");
				}
			
				
			}		
		});
	

	
	
		Scene loginScene = new Scene(gridLogin, 300, 300);
		primaryStage.setScene(loginScene);
		primaryStage.show();
	}

	public static void main(String[]args) {
		Application.launch(args);
	}
		
	
}
