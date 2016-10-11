package test.unit;

import java.util.List;

import org.junit.Test;

import controller.Controller;
import junit.framework.Assert;
import model.Role;
import model.Team;
import model.User;

public class TeamTest {

	@Test
	public void initTeam(){
		Controller controller = new Controller();
		
		controller.initTeams();
		
		List<Team> production = controller.getProductionTeam();
		List<Team> service = controller.getServiceTeam();
		
		
		for (Team team : service) {
			for (User user : team.getMembers()) {
				Assert.assertTrue(user.getRole() == Role.Chef || user.getRole() == Role.Waitress);
			}
		}
		
		for (Team team : production) {
			for (User user : team.getMembers()) {
				Assert.assertTrue(user.getRole() == Role.Music || user.getRole() == Role.Photography);
			}
		}
		
	}
	
}
