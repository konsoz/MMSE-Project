package controller;

import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Event;
import model.Login;
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
	
}
