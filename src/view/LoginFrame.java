package view;
import javax.swing.*;

import controller.Controller;
import model.User;

import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

	public static void main(String[] args) {
		LoginFrame frameTabel = new LoginFrame();
	}

	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField txuser = new JTextField(15);
	JPasswordField pass = new JPasswordField(15);
	MainFrame regFace;
	
	public LoginFrame() {
		super("Login Autentification");
		setSize(300, 200);
		setLocation(500, 280);
		panel.setLayout(null);

		txuser.setBounds(70, 30, 150, 20);
		pass.setBounds(70, 65, 150, 20);
		blogin.setBounds(110, 100, 80, 20);

		panel.add(blogin);
		panel.add(txuser);
		panel.add(pass);

		
		Controller controller = new Controller();
			
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionlogin(controller,this);
	}

	public void actionlogin(Controller controller, LoginFrame login) {
		blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = txuser.getText();
				String password = pass.getText();
				
				User currentUser = controller.login(username,password);
				
				if (currentUser != null) {
					regFace = new MainFrame(currentUser,controller, login);
					login.setVisible(false);
					regFace.setVisible(true);
					
				} else {

					JOptionPane.showMessageDialog(null, "Wrong Password / Username");
					txuser.setText("");
					pass.setText("");
					txuser.requestFocus();
				}

			}
		});
	}
	
	public JButton getLoginButton(){
		return blogin;
	}
	
	public JTextField getUserField(){
		return txuser;
	}
	
	public JPasswordField getPassField(){
		return pass;
	}
	
	public MainFrame getMainFrame(){
		return regFace;
	}
}