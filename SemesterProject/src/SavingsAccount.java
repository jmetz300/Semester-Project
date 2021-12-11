
public class SavingsAccount extends Account {

	Integer MINBALANCE = 2500;
	
	public SavingsAccount() {
		super();
	}
	
	public void transferToChecking(Integer amount, CheckingAccount checking) {
		if(balance - amount > MINBALANCE) {
			balance = balance - amount;
			checking.balance = checking.balance + amount;

		}
		else {
			System.out.println("Transaction denied");
		}
	}

}
