package view;

import javax.swing.*;

import controller.Controller;
import model.Role;
import model.User;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

	private final Controller controller;
	private  User user;
	private final LoginFrame loginFrame;
	
	JPanel panel = new JPanel();
	JButton createEventButton = new JButton("Create event");
	JButton createClientButton = new JButton("Create client");
	JButton listEventsButton = new JButton("List events");
	private final JButton btnLogout = new JButton("Logout");
	
	public MainFrame(User currentUser, Controller controller, LoginFrame login) {
		super("Welcome to SEP System");
		setSize(600, 400);
		setLocation(500, 280);
		panel.setLayout(null);
		user = currentUser;
		this.controller = controller;
		this.loginFrame = login;
		createEventButton.setVisible(false);

		getContentPane().add(panel);

		if (currentUser.getRole().equals(Role.CustomerService))
			createEventButton.setVisible(true);

		createEventButton.setBounds(12, 23, 157, 25);
		panel.add(createEventButton);
		

		createClientButton.setBounds(12, 71, 157, 25);
		panel.add(createClientButton);
		
		
		listEventsButton.setBounds(12, 122, 157, 25);
		panel.add(listEventsButton);
		btnLogout.setBounds(450, 314, 117, 25);
		
		panel.add(btnLogout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		createEventAction();
		createClientAction();
		listEventsAction();
		logoutAction();
	}
	
	public void createEventAction(){
		createEventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateEventFrame frame = new CreateEventFrame(controller);
			}
		});
	}
	
	public void createClientAction(){
		createClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateClientFrame frame = new CreateClientFrame(controller);
			}
		});
	}
	
	public void listEventsAction(){
		listEventsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListAndUpdateFrame frame = new ListAndUpdateFrame(controller, user);
			}
		});
	}
	
	public void logoutAction(){
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = null;
				loginFrame.setVisible(true);
				dispose();
			}
		});
	}

	public User getUser() {
		return user;
	}
}
