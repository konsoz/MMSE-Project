package model;

public class Event {
	private  String dateFrom;
	private  String dateTo;
	private  String description;
	private  String name;
	private final int clientId;
	private final int id;
	private double budget;
	
	public Event(String dateFrom,String dateTo, String description, String name, int clientId, int id, double budget){
		this.setDateFrom(dateFrom);
		this.setDateTo(dateTo);
		this.setDescription(description);
		this.setName(name);
		this.clientId = clientId;
		this.id = id;
		this.setBudget(budget);
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

	public int getClientId() {
		return clientId;
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
	
}
