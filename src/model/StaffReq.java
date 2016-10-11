package model;

public class StaffReq {
	@Override
	public String toString() {
		return "[event=" + event + ", team=" + team + ", description=" + description + ", id=" + id + "]";
	}

	private Event event;
	private Team team;
	private String description;
	private int id;
	
	public StaffReq(Event event, Team team, String description, int id) {
		this.event = event;
		this.team = team;
		this.description = description;
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
