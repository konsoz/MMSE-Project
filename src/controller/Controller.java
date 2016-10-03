package controller;

import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Login;
import model.User;

public class Controller {

	
	private Login login;
	private int clientIdCounter;
	private List<Client> clients;
	
	public Controller(){
		login = new Login();
		clients = new ArrayList<>();
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
	
}
