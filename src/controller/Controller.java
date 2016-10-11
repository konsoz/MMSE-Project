package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Client;
import model.Event;
import model.Login;
import model.ResourceReq;
import model.Role;
import model.StaffReq;
import model.Status;
import model.Task;
import model.Team;
import model.User;

public class Controller {

	
	private Login login;
	
	private int clientIdCounter;
	private int eventIdCounter;
	private int taskIdCounter;
	private int staffreqCounter;
	private int resourcereqCounter;
	
	private List<Client> clients;
	private List<Event> events;
	private List<Task> tasks;
	private List<StaffReq> staffrequests;
	private List<ResourceReq> resourcereq;
	
	private Team music;
	private Team photography;
	private Team chefs;
	private Team waitresses;
	
	
	public Controller(){
		login = new Login();
		clients = new ArrayList<>();
		events = new ArrayList<>();
		tasks = new ArrayList<>();
		staffrequests = new ArrayList<>();
		resourcereq = new ArrayList<>();
		
		initTeams();
		
		clients.add(new Client("Peter", "peter@gmail", "123", 0));
		events.add(new Event("6 oct 2016", "7 oct 2016", "Party time", "Crazy praty 3000", clients.get(0), 0, 1000));
		
		
	}
	
	public void createEvent(String dateFrom,String dateTo, String description, String name, Client client, double budget){
		Event event = new Event(dateFrom,dateTo, description, 
								name, client, eventIdCounter, budget);
		events.add(event);
		eventIdCounter++;
	}
	
	public void createResourceRequest(Event event, String description, String resources, User manager){
		ResourceReq req = new ResourceReq(event, description, resources, manager, resourcereqCounter);
		resourcereq.add(req);
		resourcereqCounter++;
	}
	
	public List<Event> getEventsWithClient(Client client){
		List <Event> eventsForClient = new ArrayList<>();
		for (Event event : events) {
			if(event.getClient().getId() == client.getId())
				eventsForClient.add(event);
		}
		return eventsForClient;
	}
	
	public User login(String username,String password){
		return login.login(username, password);
	}

	public void createClient(String name, String email, String phone) {
		Client client = new Client(name,email,phone,clientIdCounter);
		clients.add(client);
		clientIdCounter++;
	}
	
	public List<Client> getClients(){
		return clients;
	}
	
	public List<Event> getEvents(){
		return events;
	}

	public void changeStatus(int currentEventId, User currentUser) {
		Event event = events.get(currentEventId);
		Status newStatus;
		
		switch(currentUser.getRole()) {
			case SeniorCustomerService :
						if(event.getStatus() == Status.Created) {
							newStatus = Status.AcceptedBySCS;
						} else
							newStatus = Status.Finalized;
						break;
			case  FinancialManager : 
						newStatus = Status.AcceptedByFM;
						break;
			case  AdministrationManager : 
						newStatus = Status.AcceptedByAM;
						break;
			default: newStatus = null;
		}
		
		event.setStatus(newStatus);
		
	}
	
	public void createTask(User currentUser, double originalBudget, double additionalBudget, String description,
			String expectedPlan, Event event, Team team) {
			Task task = new Task(team, originalBudget, additionalBudget, description, expectedPlan, event, taskIdCounter);
			tasks.add(task);
			taskIdCounter++;
	}
	
	public List<Team> getProductionTeam(){
		List<Team> newList = new ArrayList<>();
		newList.add(music);
		newList.add(photography);
		return newList;
	}
	
	public List<Team> getServiceTeam(){
		List<Team> newList = new ArrayList<>();
		newList.add(chefs);
		newList.add(waitresses);
		return newList;
	}
	
	public void initTeams(){
		music = new Team(login.getUserWithRole(Role.ProductionManager), "Music team 1");
		photography = new Team(login.getUserWithRole(Role.ProductionManager), "Photography team 1");
		
		chefs = new Team(login.getUserWithRole(Role.ServiceManager),"Chefs team 1");
		waitresses = new Team(login.getUserWithRole(Role.ServiceManager),"Waitress team 1");
		
		for (User user : login.getUsers()) {
			switch(user.getRole()) {
			case Music: music.addMember(user); break;
			case Photography: photography.addMember(user); break;
			case Chef: chefs.addMember(user); break;
			case Waitress: waitresses.addMember(user); break;
			}
		}
	}
	
	public void updateTask(double additionalBudget,String expectedPlan,Task task){
		for (Task t : tasks) {
			if(t.getId() == task.getId()) {
				t.setExpectedPlan(expectedPlan);
				t.setAdditionalBudget(additionalBudget);
			}
		}
	}
	
	public void updateEvent(double newBudget, Event event) {
		for(Event e : events) {
			if(e.getId() == event.getId()) {
				e.setBudget(newBudget);
			}
		}
	}
	
	public void deleteEvent(Event event) {
		for(Iterator<Event> iter = events.listIterator(); iter.hasNext();) {
			Event e = iter.next();
			if(e.getId() == event.getId()) iter.remove();
		}
	}
	
	public void createStaffReq(Event event, Team team, String description){
		staffrequests.add(new StaffReq(event, team, description, staffreqCounter));
		staffreqCounter++;
	}
	
	public List<StaffReq> getStaffReq(){
		return staffrequests;
	}
	
	public List<ResourceReq> getResourceReq(){
		return resourcereq;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void deleteStaffReq(StaffReq req) {
		for(Iterator<StaffReq> iter = staffrequests.listIterator(); iter.hasNext();) {
			StaffReq r = iter.next();
			if(r.getId() == req.getId()) iter.remove();
		}
	}
	
	public void deleteResourceReq(ResourceReq req) {
		for(Iterator<ResourceReq> iter = resourcereq.listIterator(); iter.hasNext();) {
			ResourceReq r = iter.next();
			if(r.getId() == req.getId()) iter.remove();
		}
	}
	
}
