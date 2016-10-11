package test.unit;

import java.util.List;

import org.junit.Test;

import controller.Controller;
import org.junit.Assert;
import model.Client;
import model.Event;

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
	
	@Test
	public void correctEvents(){
		Controller controller = new Controller();
		
		controller.createClient("Peter", "Peter@gmail.com", "07600000");
		controller.createClient("Notpeter", "notpeter@gmail.com", "1234");
		Client peter = controller.getClients().get(0);
		Client notpeter = controller.getClients().get(1);
		
		controller.createEvent("dateFrom", "dateTo", "description", "funny party", peter, 1000);
		controller.createEvent("dateFrom", "dateTo", "description", "funny party", peter, 1000);
		controller.createEvent("dateFrom", "dateTo", "description", "time to study", notpeter, 1000);
		
		
		List <Event> peterEvents = controller.getEventsWithClient(peter);
		
		for (Event event : peterEvents) {
			Assert.assertEquals(peter.getId(),event.getClient().getId());
		}
	}
	
}
