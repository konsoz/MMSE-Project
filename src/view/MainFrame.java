package view;

import javax.swing.*;

import controller.Controller;
import model.User;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

	private final Controller controller;
	private final User user;

	JPanel panel = new JPanel();
	JButton createEventButton = new JButton("Create event");
	JButton createClientButton = new JButton("Create client");
	
	public MainFrame(User currentUser, Controller controller) {
		super("Welcome to SEP System");
		setSize(600, 400);
		setLocation(500, 280);
		panel.setLayout(null);
		user = currentUser;
		this.controller = controller;
		
		createEventButton.setVisible(false);

		getContentPane().add(panel);

		if (currentUser.getRole().equals("cs"))
			createEventButton.setVisible(true);

		createEventButton.setBounds(12, 23, 157, 25);
		panel.add(createEventButton);
		

		createClientButton.setBounds(12, 71, 157, 25);
		panel.add(createClientButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		createEventAction();
		createClientAction();
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
	
}
