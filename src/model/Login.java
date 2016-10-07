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
		users.add(new User("sm","123",Role.ServiceManager));
		users.add(new User("pm","123",Role.ProductionManager));
		
		users.add(new User("photo","123",Role.Photography));
		users.add(new User("music","123",Role.Music));
		users.add(new User("chef","123",Role.Chef));
		users.add(new User("waitress","123",Role.Waitress));
		
	}
	
	public User login(String username,String password) {
		for (User user : users) {
			if(user.getPassword().equals(password) && user.getUsername().equals(username))
				return user;
		}
		return null;
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public User getUserWithRole(Role role){
		for (User user : users) {
			if(user.getRole() == role) return user;
		}
		return null;
	}
}
