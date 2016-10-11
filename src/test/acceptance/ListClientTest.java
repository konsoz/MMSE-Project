package test.acceptance;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import model.Role;
import model.User;
import view.ClientListFrame;
import view.CreateClientFrame;
import view.LoginFrame;
import view.MainFrame;

public class ListClientTest {
	private MainFrame mainFrame;
	private CreateClientFrame clientFrame;
	
	@Before
	public void setUp() {
		
		User user = new User("scs","123",Role.SeniorCustomerService);
		
		Controller controller = new Controller();
		
		mainFrame = new MainFrame(user, controller, new LoginFrame());
		
		clientFrame = new CreateClientFrame(controller);
		clientFrame.setVisible(true);
	}
	
	@Test public void login() throws AWTException {
	    JButton button = clientFrame.getSubmitBtn();
	    clientFrame.setClientEmail("peter@gmail.com");
	    clientFrame.setClientName("Peter");
	    clientFrame.setClientPhone("1234567");
	    click(button);
	    
	    
	    
	    delay();
	    
	    clientFrame.dispose();
	    
	    mainFrame.setVisible(true);
	    
	    JButton listClients = mainFrame.getBtnListClients();
	    
	    click(listClients);
	    
	    delay();
	    
	    ClientListFrame clientListFrame = mainFrame.getListClientsFrame();
	    
	    clickOnlist(clientListFrame.getEventList());
	    
	    delay();
	    
	    Assert.assertEquals("Peter", clientListFrame.getClientNameField().getText());
	    
	    delay();
	    
	  }
	
	
	public void delay(){
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void click(JButton button) throws AWTException {
	    Point point = button.getLocationOnScreen();
	    Robot robot = new Robot();
	    robot.setAutoWaitForIdle(true);
	    robot.mouseMove(point.x + 10, point.y + 10);
	    robot.mousePress(MouseEvent.BUTTON1_MASK);
	    robot.mouseRelease(MouseEvent.BUTTON1_MASK);
	  }
	
	private void clickOnlist(JList list) throws AWTException {
	    Point point = list.getLocationOnScreen();
	    Robot robot = new Robot();
	    robot.setAutoWaitForIdle(true);
	    robot.mouseMove(point.x + 10, point.y + 10);
	    robot.mousePress(MouseEvent.BUTTON1_MASK);
	    robot.mouseRelease(MouseEvent.BUTTON1_MASK);
	  }
}
