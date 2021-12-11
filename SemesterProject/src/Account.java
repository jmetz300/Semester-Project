
public class Account {
	
	Integer balance = null;
	
	public Account() {
		this.balance = 0;
	}
	
	public void deposit(Integer amount) {
		balance = balance + amount;
	}

	public void setBalance(Integer amount) {
		balance = amount;
	}

	public Integer getBalance() {
		return balance;
	}

}
