package controller;

import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Event;
import model.Login;
import model.Role;
import model.Status;
import model.Task;
import model.Team;
import model.User;

public class Controller {

	
	private Login login;
	private int clientIdCounter;
	private int eventIdCounter;
	private int taskIdCounter;
	private List<Client> clients;
	private List<Event> events;
	private List<Task> tasks;
	private Team music;
	private Team photography;
	private Team chefs;
	private Team waitresses;
	
	
	public Controller(){
		login = new Login();
		clients = new ArrayList<>();
		events = new ArrayList<>();
		tasks = new ArrayList<>();
		
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

	public List<Task> getTasks() {
		return tasks;
	}
	
}
