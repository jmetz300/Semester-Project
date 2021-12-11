import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		//Lists of user details used to create User objects
		List<User> users = new ArrayList<User>();
		List<String> firstNames = List.of("Sean", "Ken");
		List<String> lastNames = List.of("Harrison", "Smith");
		List<String> usernames = List.of("SHarrison", "KSmith");
		List<String> passwords = List.of("3pointshot", "sup3rh0t");
		List<Integer> accountNums = List.of(123456789, 987654321);
		List<String> emails = List.of("sharrison@mail.com", "ksmith@mail.com");
	    List<String> addresses = List.of("123 Main Street", "456 Washington Avenue");
		
		//Creates User objects and puts them in the users list
		for(int i = 0; i < firstNames.size(); i++) {
			User user = new User();
			user.setFirstName(firstNames.get(i));
			user.setLastName(lastNames.get(i));
			user.setUsername(usernames.get(i));
			user.setPassword(passwords.get(i));
			user.setAccountNum(accountNums.get(i));
			user.setEmail(emails.get(i));
			user.setAddress(addresses.get(i));
			users.add(user);
		}
		
		//Deposit money into the accounts of both users
		users.get(0).checking.deposit(10000);
		users.get(0).savings.deposit(50000);
		
		users.get(1).checking.deposit(2000);
		users.get(1).savings.deposit(2500);
		
		//Print out the details of the users
		System.out.println(users.get(0).toString());
		System.out.println(users.get(1).toString());
		System.out.println("");
		
		//Transfer money from checking to savings
		System.out.println("Transfer from checking account to savings");
		users.get(0).checking.transferToSavings(500, users.get(0).savings);
		users.get(1).checking.transferToSavings(1000, users.get(1).savings);
		System.out.println(users.get(0).toString());
		System.out.println(users.get(1).toString());
		System.out.println("");
		
		//Transfer money from savings to checking
		System.out.println("Transfer from savings to checking acount");
		users.get(0).savings.transferToChecking(2500, users.get(0).checking);
		users.get(1).savings.transferToChecking(300, users.get(1).checking);
		System.out.println(users.get(0).toString());
		System.out.println(users.get(1).toString());
		System.out.println("");
		
		//Withdraw from checking account
		System.out.println("Withdraw from checking account");
		users.get(0).checking.withdraw(5000);
		users.get(1).checking.withdraw(500);
		System.out.println(users.get(0).toString());
		System.out.println(users.get(1).toString());
		System.out.println("");
		
		//Trying to transfer too much money out of savings, going below the minimum balance
		System.out.println("Attempt to transfer too much money out of savings");
		users.get(0).savings.transferToChecking(48000, users.get(0).checking);
		users.get(1).savings.transferToChecking(3200, users.get(1).checking);
		System.out.println(users.get(0).toString());
		System.out.println(users.get(1).toString());
		System.out.println("");
		
	}

}
