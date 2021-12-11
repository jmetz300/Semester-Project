
public class User {
	String firstName;
	String lastName;
	String username;
	String password;
	Integer accountNum;
	String email;
	String address;
	CheckingAccount checking;
	SavingsAccount savings;
	
/*	public User(String firstName, String lastName, String username, String password, Integer accountNum, String email, String address) {
		
	}*/
	
	public User() {
		checking = new CheckingAccount();
		savings = new SavingsAccount();
	}
	
	//Setter methods
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	//Getter methods
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Integer getAccountNum() {
		return accountNum;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String toString() {
		return "Name: " + getFirstName() + " " + getLastName() + "\nUsername: " + getUsername() + "\nPassword: " + getPassword() + 
				"\nAccount Number: " + getAccountNum() + "\nEmail address: " + getEmail() + "\nStreet address: "+ getAddress() + 
				"\nChecking account balance: " + checking.balance + "\nSavings account balance: " + savings.balance;
	}

}
