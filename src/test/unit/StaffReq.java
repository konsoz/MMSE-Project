package test.unit;

import org.junit.Test;

import controller.Controller;
import org.junit.*;
import model.Client;
import model.Event;
import model.Team;

public class StaffReq {

	@Test
	public void createReq(){
		Controller controller = new Controller();
		controller.createClient("Peter", "Peter@gmail.com", "07600000");
		Client client = controller.getClients().get(0);
		controller.createEvent("dateFrom", "dateTo", "description", "funny party", client, 1000);
		Event event = controller.getEvents().get(0);
		
		Team team = controller.getProductionTeam().get(0);
		
		
		controller.createStaffReq(event, team, "more people");
		
		Assert.assertEquals(1, controller.getStaffReq().size());
	}
	
}
