package model;

public class Event {
	private  String dateFrom;
	private  String dateTo;
	private  String description;
	private  String name;
	private final Client client;
	private final int id;
	private double budget;
	private Status status;
	
	public Event(String dateFrom,String dateTo, String description, String name, Client client, int id, double budget){
		this.setDateFrom(dateFrom);
		this.setDateTo(dateTo);
		this.setDescription(description);
		this.setName(name);
		this.client = client;
		this.id = id;
		this.setBudget(budget);
		this.status = Status.Created;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", budget=" + budget + "]";
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client getClient() {
		return client;
	}

	public int getId() {
		return id;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
