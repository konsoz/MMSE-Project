package test;

import org.junit.Test;

import controller.Controller;
import org.junit.Assert;
import model.Client;
import model.Event;
import model.Role;
import model.Task;
import model.Team;
import model.User;

public class TaskTest {
	
	
	@Test
	public void createTask(){
		Controller controller = new Controller();
		controller.createClient("Peter", "Peter@gmail.com", "07600000");
		Client client = controller.getClients().get(0);
		controller.createEvent("dateFrom", "dateTo", "description", "funny party", client, 1000);
		Event event = controller.getEvents().get(0);
		
		User sm = new User("sm","123",Role.ServiceManager);
		User chef = new User("chef","123",Role.Chef);
		User anotherChef = new User("chef1","123",Role.Chef);
		
		Team team = new Team(sm,"chef team 1");
		
		team.addMember(chef);
		team.addMember(anotherChef);
		
		controller.createTask(sm, 100, 0, "time to cook", "", event,team);
		
		Task task = controller.getTasks().get(0);
		
		Assert.assertEquals(team,task.getTeam());
		Assert.assertEquals(sm, task.getTeam().getManager());
		Assert.assertEquals("chef team 1", task.getTeam().getName());
		
	}
	
	@Test
	public void updateStatus(){
		Controller controller = new Controller();
		controller.createClient("Peter", "Peter@gmail.com", "07600000");
		Client client = controller.getClients().get(0);
		controller.createEvent("dateFrom", "dateTo", "description", "funny party", client, 1000);
		Event event = controller.getEvents().get(0);
		
		User sm = new User("sm","123",Role.ServiceManager);
		User chef = new User("chef","123",Role.Chef);
		User anotherChef = new User("chef1","123",Role.Chef);
		
		Team team = new Team(sm,"chef team 1");
		
		team.addMember(chef);
		team.addMember(anotherChef);
		
		controller.createTask(sm, 100, 0, "time to cook", "", event,team);
		
		Task task = controller.getTasks().get(0);
		
		controller.updateTask(1000, "cooking and stuff like that", task);
		
		
		Assert.assertEquals(1000, task.getAdditionalBudget(),0);
		Assert.assertEquals("cooking and stuff like that", task.getExpectedPlan());
	}
}
