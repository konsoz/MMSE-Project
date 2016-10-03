package model;

public class Client {

	private final String name;
	private final String phoneNumber;
	private final String email;
	private final int id;
	
	public Client(String name, String email, String phone,int id){
		this.name = name;
		this.phoneNumber = phone;
		this.email = email;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", id=" + id + "]";
	}
}
