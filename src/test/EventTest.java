package test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import controller.Controller;
import model.Client;
import model.Event;

public class EventTest {
	@Test
	public void createEventTest(){
		Controller controller = new Controller();
		
		controller.createClient("Peter", "Peter@gmail.com", "07600000");
		
		
		Client client = controller.getClients().get(0);
		
		controller.createEvent("dateFrom", "dateTo", "description", "funny party", client,1000);
		
		Event event = controller.getEvents().get(0);
		
		Assert.assertEquals(client.getId(), event.getClient().getId());
		Assert.assertEquals(0, event.getId());
		Assert.assertEquals("dateFrom", event.getDateFrom());
		Assert.assertEquals("dateTo", event.getDateTo());
		Assert.assertEquals("description", event.getDescription());
		Assert.assertEquals("funny party", event.getName());
		Assert.assertEquals(1000.0, event.getBudget(),0);
		
	}
}
