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
	JButton btnListStaffReq = new JButton("List Staff Requests");
	private final JButton btnLogout = new JButton("Logout");
	JButton btnCreateStaffRequest = new JButton("Create Staff Request");
	private final JButton btnListClients = new JButton("List Clients");
	private final JButton btnCreateTask = new JButton("Create Task");
	private final JButton btnListTasks = new JButton("List Tasks");
	JButton btnCreateResourceRequest = new JButton("Create Resource Request");
	JButton btnListResourceRequest = new JButton("List Resource Request");
	
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

		createEventButton.setVisible(false);
		createClientButton.setVisible(false);
		listEventsButton.setVisible(false);
		btnListStaffReq.setVisible(false);
		btnCreateStaffRequest.setVisible(false);
		btnListClients.setVisible(false);
		btnCreateTask.setVisible(false);
		btnCreateResourceRequest.setVisible(false);
		btnListResourceRequest.setVisible(false);
		btnListTasks.setVisible(false);
		
		switch(currentUser.getRole()){
		case CustomerService: 
			createEventButton.setVisible(true); 
			break;
		case SeniorCustomerService:
			listEventsButton.setVisible(true);
			createClientButton.setVisible(true);
			btnListClients.setVisible(true);
			break;
		case FinancialManager:
			listEventsButton.setVisible(true);
			btnListResourceRequest.setVisible(true);
			btnListClients.setVisible(true);
			break;
		case AdministrationManager:
			listEventsButton.setVisible(true);
			btnListClients.setVisible(true);
			break;
		case ProductionManager:
			btnCreateTask.setVisible(true);
			btnCreateStaffRequest.setVisible(true);
			btnCreateResourceRequest.setVisible(true);
			btnListTasks.setVisible(true);
			break;
		case ServiceManager:
			btnCreateTask.setVisible(true);
			btnCreateStaffRequest.setVisible(true);
			btnCreateResourceRequest.setVisible(true);
			btnListTasks.setVisible(true);
			break;
		case HR:
			btnListStaffReq.setVisible(true);
			break;
		case Chef:
		case Music:
		case Photography:
		case Waitress:
			btnListTasks.setVisible(true);
			break;
		}
		
		
		
		createEventButton.setBounds(12, 23, 157, 25);
		panel.add(createEventButton);
		

		createClientButton.setBounds(12, 71, 157, 25);
		panel.add(createClientButton);
		
		
		listEventsButton.setBounds(12, 122, 157, 25);
		panel.add(listEventsButton);
		btnLogout.setBounds(450, 314, 117, 25);
		
		panel.add(btnLogout);
		btnListClients.setBounds(12, 169, 157, 25);
		
		panel.add(btnListClients);
		btnCreateTask.setBounds(12, 213, 150, 25);
		
		panel.add(btnCreateTask);
		btnListTasks.setBounds(234, 23, 150, 25);
		
		panel.add(btnListTasks);
		
		
		btnCreateStaffRequest.setBounds(234, 71, 150, 25);
		panel.add(btnCreateStaffRequest);
		
		
		btnListStaffReq.setBounds(237, 122, 147, 25);
		panel.add(btnListStaffReq);
		
		btnCreateResourceRequest.setBounds(234, 169, 150, 25);
		panel.add(btnCreateResourceRequest);
		
		btnListResourceRequest.setBounds(234, 213, 150, 25);
		panel.add(btnListResourceRequest);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		createEventAction();
		createClientAction();
		listEventsAction();
		listClientsAction();
		createTaskAction();
		listTasksAction();
		createStaffReq();
		createResourceReq();
		listStaffReq();
		listResourceReq();
		logoutAction();
	}
	
	public void createStaffReq(){
		btnCreateStaffRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateStaffRequest frame = new CreateStaffRequest(controller,user);
			}
		});
	}
	
	public void createResourceReq(){
		btnCreateResourceRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateResourceReq frame = new CreateResourceReq(controller,user);
			}
		});
	}
	
	public void listStaffReq(){
		btnListStaffReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListStaffReq frame = new ListStaffReq(controller,user);
			}
		});
	}
	
	public void listResourceReq(){
		btnListResourceRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListResourceReq frame = new ListResourceReq(controller,user);
			}
		});
	}
	
	public void createTaskAction(){
		btnCreateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateTaskFrame frame = new CreateTaskFrame(controller,user);
			}
		});
	}
	
	public void listClientsAction(){
		btnListClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientListFrame frame = new ClientListFrame(controller);
			}
		});
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
	
	public void listTasksAction(){
		btnListTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTaskFrame frame = new ListTaskFrame(controller, user);
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
