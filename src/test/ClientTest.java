package test;

import java.util.List;

import org.junit.Test;

import controller.Controller;
import org.junit.Assert;
import model.Client;

public class ClientTest {

	
	@Test
	public void uniqueClientId(){
		Controller controller = new Controller();
		
		controller.createClient("Peter", "Peter@gmail.com", "07600000");
		controller.createClient("Peter", "Peter@gmail.com", "07600000");
		
		List<Client> clients = controller.getClients();
		
		Assert.assertEquals(0, clients.get(0).getId());
		Assert.assertEquals(1, clients.get(1).getId());
		
	}
	
}
