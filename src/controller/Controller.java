package controller;

import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Event;
import model.Login;
import model.Role;
import model.Status;
import model.User;

public class Controller {

	
	private Login login;
	private int clientIdCounter;
	private int eventIdCounter;
	private List<Client> clients;
	private List<Event> events;
	
	public Controller(){
		login = new Login();
		clients = new ArrayList<>();
		events = new ArrayList<>();
		
		clients.add(new Client("Peter", "peter@gmail", "123", 0));
		events.add(new Event("6 oct 2016", "7 oct 2016", "Party time", "Crazy praty 3000", clients.get(0), 0, 1000));
		
	}
	
	public void createEvent(String dateFrom,String dateTo, String description, String name, Client client, double budget){
		Event event = new Event(dateFrom,dateTo, description, 
								name, client, eventIdCounter, budget);
		events.add(event);
		eventIdCounter++;
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
	
}
