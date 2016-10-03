package model;

import java.util.ArrayList;
import java.util.List;

public class Login {
	
	private final List<User> users;
	
	public Login(){
		
		users = new ArrayList<>();
		
		users.add(new User("cs","123","cs"));
		users.add(new User("scs","123","scs"));
	}
	
	public User login(String username,String password) {
		for (User user : users) {
			if(user.getPassword().equals(password) && user.getUsername().equals(username))
				return user;
		}
		return null;
	}
}