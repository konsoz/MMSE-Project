package test;

import org.junit.Test;

import model.Login;
import model.Role;
import model.User;

import org.junit.Assert;

public class LoginTest {

	@Test
	public void checkRole(){
		Login login = new Login();
		User user = new User("cs","123",Role.CustomerService);
		
		User loginUser = login.login(user.getUsername(), user.getPassword());
		Assert.assertEquals(Role.CustomerService, loginUser.getRole());
		
	}
	
	@Test
	public void checkIsLoggedIn(){
		Login login = new Login();
		User user = new User("cs","123",Role.CustomerService);
		
		User loginUser = login.login(user.getUsername(), user.getPassword());
		
		Assert.assertEquals("cs", loginUser.getUsername());
		Assert.assertEquals("123", loginUser.getPassword());
		Assert.assertEquals(Role.CustomerService, loginUser.getRole());
		
	}
}
