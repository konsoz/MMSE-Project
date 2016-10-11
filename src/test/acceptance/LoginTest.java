package test.acceptance;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import org.fest.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import view.LoginFrame;

public class LoginTest {
	private LoginFrame login;
	
	@Before
		public void setUp() {
		login = new LoginFrame();
		login.setVisible(true);
	  }

	   @Test public void login() throws AWTException {
	    JButton button = login.getLoginButton();
	    login.getUserField().setText("cs");
	    login.getPassField().setText("123");
	    click(button);
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Assert.assertNotEquals(null, login.getMainFrame());
	  }
	   
	   @After
		public void tearDown() {
		   
		}

	  private void click(JButton button) throws AWTException {
	    Point point = button.getLocationOnScreen();
	    Robot robot = new Robot();
	    robot.setAutoWaitForIdle(true);
	    robot.mouseMove(point.x + 10, point.y + 10);
	    robot.mousePress(MouseEvent.BUTTON1_MASK);
	    robot.mouseRelease(MouseEvent.BUTTON1_MASK);
	  }
	}

