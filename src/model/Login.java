package model;

import java.util.ArrayList;
import java.util.List;

public class Login {
	
	private final List<User> users;
	
	public Login(){
		
		users = new ArrayList<>();
		
		users.add(new User("cs","123",Role.CustomerService));
		users.add(new User("scs","123",Role.SeniorCustomerService));
		users.add(new User("fm","123",Role.FinancialManager));
		users.add(new User("am","123",Role.AdministrationManager));
	}
	
	public User login(String username,String password) {
		for (User user : users) {
			if(user.getPassword().equals(password) && user.getUsername().equals(username))
				return user;
		}
		return null;
	}
}
