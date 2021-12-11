
public class CheckingAccount extends Account {
	
	public CheckingAccount() {
		super();
	}

	public void withdraw(Integer amount) {
		if(balance - amount >= 0) {
			balance = balance - amount;
		}
		else {
			System.out.println("Transaction rejected");
		}
	}
	
	public void transferToSavings(Integer amount, SavingsAccount savings) {
		if(balance - amount >= 0) {
			balance = balance - amount;
			savings.balance = savings.balance + amount;
		}
		else {
			System.out.println("Transaction rejected");
		}
	}

}
