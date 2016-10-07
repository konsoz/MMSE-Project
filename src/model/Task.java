package model;

import java.util.List;

public class Task {
		private Team team;
		private double originalBudget;
		private double additionalBudget;
		private String description;
		private String expectedPlan;
		private Event event;
		private int id;
		
		public Task(Team team, double originalBudget, double additionalBudget, String description,
				String expectedPlan, Event event, int id) {
			this.team = team;
			this.originalBudget = originalBudget;
			this.additionalBudget = additionalBudget;
			this.description = description;
			this.expectedPlan = expectedPlan;
			this.event = event;
			this.id = id;
		}

		public Team getTeam() {
			return team;
		}

		public void setTeam(Team team) {
			this.team = team;
		}

		public double getOriginalBudget() {
			return originalBudget;
		}

		public void setOriginalBudget(double originalBudget) {
			this.originalBudget = originalBudget;
		}

		public double getAdditionalBudget() {
			return additionalBudget;
		}

		public void setAdditionalBudget(double additionalBudget) {
			this.additionalBudget = additionalBudget;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getExpectedPlan() {
			return expectedPlan;
		}

		public void setExpectedPlan(String expectedPlan) {
			this.expectedPlan = expectedPlan;
		}

		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		@Override
		public String toString() {
			return String.valueOf(id);
		}
		
}
