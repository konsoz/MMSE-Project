package view;

import javax.swing.*;

import controller.Controller;
import model.Client;
import model.User;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class CreateEventFrame extends JFrame {

	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField eventName;
	private JTextField dateFrom;
	JButton btnNewButton = new JButton("Submit");
	private JLabel lblDate;
	private JTextField budget;
	private JLabel lblBudget;
	private JTextPane description;
	private JLabel lblDiscription;
	private JTextField dateTo;
	private JLabel lblDateTo;
	private JList clientList;


	public CreateEventFrame(Controller controller) {
		super("SEP System");
		setSize(600, 400);
		setLocation(500, 280);
		panel.setLayout(null);
		
		this.controller = controller;
		
		

		getContentPane().add(panel);
		
		eventName = new JTextField();
		eventName.setBounds(164, 30, 114, 19);
		panel.add(eventName);
		eventName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(47, 32, 70, 15);
		panel.add(lblName);
		
		dateFrom = new JTextField();
		dateFrom.setBounds(164, 76, 114, 19);
		panel.add(dateFrom);
		dateFrom.setColumns(10);
		
		lblDate = new JLabel("Date from");
		lblDate.setBounds(47, 78, 99, 15);
		panel.add(lblDate);
		
		budget = new JTextField();
		budget.setBounds(164, 145, 114, 19);
		panel.add(budget);
		budget.setColumns(10);
		
		lblBudget = new JLabel("Budget");
		lblBudget.setBounds(47, 147, 70, 15);
		panel.add(lblBudget);
		
		description = new JTextPane();
		description.setBounds(159, 192, 119, 88);
		panel.add(description);
		
		lblDiscription = new JLabel("Description");
		lblDiscription.setBounds(47, 192, 99, 15);
		panel.add(lblDiscription);
		
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(328, 32, 70, 15);
		panel.add(lblClient);
		
		
		btnNewButton.setBounds(233, 317, 117, 25);
		panel.add(btnNewButton);
		
		dateTo = new JTextField();
		dateTo.setBounds(164, 114, 114, 19);
		panel.add(dateTo);
		dateTo.setColumns(10);
		
		lblDateTo = new JLabel("Date to");
		lblDateTo.setBounds(47, 116, 70, 15);
		panel.add(lblDateTo);
		
		List<Client> clientss = controller.getClients();
		Client[] clients  = clientss.toArray(new Client[clientss.size()]);
		
		clientList = new JList(clients);
		panel.add(clientList);
		clientList.setBounds(356, 59, 228, 167);
	    JScrollPane pane = new JScrollPane();

	    getContentPane().add(pane, BorderLayout.NORTH);
		
		//panel.add(clientList);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		createEventAction(clientList);
	}
	
	public void createEventAction(JList clientList){
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dateFrom1 = dateFrom.getText();
				String dateTo1 = dateTo.getText(); 
				String description1 = description.getText();
				String name1 = eventName.getText();
				Client client = (Client) clientList.getSelectedValue();
				double budget1 = Double.parseDouble(budget.getText());
				controller.createEvent(dateFrom1,dateTo1,description1,name1,client,budget1);
			}
		});
	}
}
