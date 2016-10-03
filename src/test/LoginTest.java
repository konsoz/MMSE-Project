package test;

import org.junit.Test;

import org.junit.Assert;
import system.Login;
import system.User;

public class LoginTest {

	@Test
	public void checkRole(){
		Login login = new Login();
		User user = new User("cs","123","cs");
		
		User loginUser = login.login(user.getUsername(), user.getPassword());
		Assert.assertEquals("cs", loginUser.getRole());
		
	}
}
