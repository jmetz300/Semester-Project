import java.util.ArrayList;
import java.util.List;


public class ATM {
	static List<User> users = new ArrayList<User>();
	static boolean login = false;
	
	public static void main(String[] args) {
		
		//Lists used to create user objects
		
		List<String> firstNames = List.of("Sean", "Ken", "Sarah", "Jason");
		List<String> lastNames = List.of("Harrison", "Smith", "Johnson", "Ferris");
		List<String> usernames = List.of("SHarrison", "KSmith", "SarahJ", "JFerris");
		List<String> passwords = List.of("3pointshot", "sup3rh0t", "9913oct", "password123");
		List<Integer> accountNums = List.of(123456789, 987654321, 581290235, 418601326);
		List<String> emails = List.of("sharrison@mail.com", "ksmith@mail.com", "sarahj@mail.com", "jasonf@mail.com");
	    List<String> addresses = List.of("123 Main Street", "456 Washington Avenue", "391 Oak Avenue", "104 Ford Street");
	    
	    //Create user objects
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
		
		//Put money in each user's accounts
		users.get(0).checking.deposit(10000);
		users.get(0).savings.deposit(50000);
		
		users.get(1).checking.deposit(2000);
		users.get(1).savings.deposit(2500);
		
		users.get(2).checking.deposit(7000);
		users.get(2).savings.deposit(10000);
		
		users.get(3).checking.deposit(5000);
		users.get(3).savings.deposit(2500);
		
		Menu.main(args);

	}
	
	
	public static User Login(String username, String password) {
		Integer index = null;
			for(int i = 0; i < users.size(); i++) {
				if((username.equals(users.get(i).username)) && (password.equals(users.get(i).password))) {
					System.out.println("Login successful");
					index = i;
					return users.get(index);
				}
			}
			return null;
			
			
	}

}
