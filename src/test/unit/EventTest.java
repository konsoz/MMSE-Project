package test.unit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import controller.Controller;
import model.Client;
import model.Event;
import model.Role;
import model.Status;
import model.User;

public class EventTest {
	@Test
	public void createEventTest() {
		Controller controller = new Controller();

		controller.createClient("Peter", "Peter@gmail.com", "07600000");

		Client client = controller.getClients().get(0);

		controller.createEvent("dateFrom", "dateTo", "description", "funny party", client, 1000);

		Event event = controller.getEvents().get(0);

		Assert.assertEquals(client.getId(), event.getClient().getId());
		Assert.assertEquals(0, event.getId());
		Assert.assertEquals("dateFrom", event.getDateFrom());
		Assert.assertEquals("dateTo", event.getDateTo());
		Assert.assertEquals("description", event.getDescription());
		Assert.assertEquals("funny party", event.getName());
		Assert.assertEquals(1000.0, event.getBudget(), 0);

	}

	@Test
	public void changeStatusTest() {
		Controller controller = new Controller();
		controller.createClient("Peter", "Peter@gmail.com", "07600000");
		Client client = controller.getClients().get(0);
		controller.createEvent("dateFrom", "dateTo", "description", "funny party", client, 1000);
		Event event = controller.getEvents().get(0);
		
		User scs = new User("scs","123",Role.SeniorCustomerService);
		User fm = new User("fm","123",Role.FinancialManager);
		User am = new User("am","123",Role.AdministrationManager);
		
		Assert.assertEquals(Status.Created, event.getStatus());
		
		controller.changeStatus(0, scs);
		
		Assert.assertEquals(Status.AcceptedBySCS, event.getStatus());
		controller.changeStatus(0, fm);
		
		Assert.assertEquals(Status.AcceptedByFM, event.getStatus());
		controller.changeStatus(0, am);
		
		Assert.assertEquals(Status.AcceptedByAM, event.getStatus());
	}
	
	@Test
	public void updateEvent() {
		Controller controller = new Controller();

		controller.createClient("Peter", "Peter@gmail.com", "07600000");

		Client client = controller.getClients().get(0);

		controller.createEvent("dateFrom", "dateTo", "description", "funny party", client, 1000);

		Event event = controller.getEvents().get(0);
		
		controller.updateEvent(55, event);
		
		Assert.assertEquals(55, event.getBudget(), 0);
	}
	
	@Test
	public void deleteTest() {
		Controller controller = new Controller();

		controller.createClient("Peter", "Peter@gmail.com", "07600000");

		Client client = controller.getClients().get(0);

		controller.createEvent("dateFrom", "dateTo", "description", "funny party", client, 1000);

		Event event = controller.getEvents().get(0);
		controller.deleteEvent(event);
		
		Assert.assertEquals(0, controller.getEvents().size());
	}
}
