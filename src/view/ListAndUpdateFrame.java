package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.Controller;
import model.Client;
import model.Event;
import model.Role;
import model.Status;
import model.Task;
import model.User;

import javax.swing.SwingConstants;

public class ListAndUpdateFrame extends JFrame {
	
	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField eventName;
	private JTextField dateFrom;
	JButton acceptButton = new JButton("Accept");
	JButton updateButton = new JButton("Update");
	JButton rejectButton = new JButton("Reject");
	private JLabel lblDate;
	private JTextField budget;
	private JLabel lblBudget;
	private JTextPane description;
	private JLabel lblDiscription;
	private JTextField dateTo;
	private JLabel lblDateTo;
	private JList eventList;
	private JTextField clientInfo;
	private JLabel statusLabel;
	private JLabel currentStatusLabel;
	private int currentEventId;
	private User currentUser;


	public ListAndUpdateFrame(Controller controller, User currentUser) {
		super("SEP System");
		setSize(600, 400);
		setLocation(500, 280);
		panel.setLayout(null);
		
		this.controller = controller;
		this.currentUser = currentUser;
		

		getContentPane().add(panel);
		
		eventName = new JTextField();
		eventName.setBounds(164, 10, 114, 19);
		panel.add(eventName);
		eventName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(47, 12, 70, 15);
		panel.add(lblName);
		
		dateFrom = new JTextField();
		dateFrom.setBounds(164, 41, 114, 19);
		panel.add(dateFrom);
		dateFrom.setColumns(10);
		
		lblDate = new JLabel("Date from");
		lblDate.setBounds(47, 39, 99, 15);
		panel.add(lblDate);
		
		budget = new JTextField();
		budget.setBounds(164, 91, 114, 19);
		panel.add(budget);
		budget.setColumns(10);
		
		lblBudget = new JLabel("Budget");
		lblBudget.setBounds(47, 93, 70, 15);
		panel.add(lblBudget);
		
		description = new JTextPane();
		description.setBounds(164, 122, 119, 88);
		panel.add(description);
		
		lblDiscription = new JLabel("Description");
		lblDiscription.setBounds(47, 120, 99, 15);
		panel.add(lblDiscription);
		
		
		JLabel eventsLabel = new JLabel("Events");
		eventsLabel.setBounds(328, 32, 70, 15);
		panel.add(eventsLabel);
		
		
		acceptButton.setBounds(61, 314, 117, 25);
		panel.add(acceptButton);
		
		dateTo = new JTextField();
		dateTo.setBounds(164, 64, 114, 19);
		panel.add(dateTo);
		dateTo.setColumns(10);
		
		lblDateTo = new JLabel("Date to");
		lblDateTo.setBounds(47, 66, 70, 15);
		panel.add(lblDateTo);
		
		List<Event> eventss = controller.getEvents();
		Event[] events  = eventss.toArray(new Event[eventss.size()]);
		
		eventList = new JList(events);
		panel.add(eventList);
		eventList.setBounds(356, 59, 228, 167);
	    JScrollPane pane = new JScrollPane();

	    getContentPane().add(pane, BorderLayout.NORTH);
		

		
		
		JLabel clientLable = new JLabel("Client");
		clientLable.setBounds(47, 224, 70, 15);
		panel.add(clientLable);
		
		clientInfo = new JTextField();
		clientInfo.setBounds(164, 222, 114, 19);
		panel.add(clientInfo);
		clientInfo.setColumns(10);
		
		
		updateButton.setBounds(237, 314, 117, 25);
		panel.add(updateButton);
		
		
		rejectButton.setBounds(413, 314, 117, 25);
		panel.add(rejectButton);
		
		statusLabel = new JLabel("Status");
		statusLabel.setBounds(47, 267, 70, 15);
		panel.add(statusLabel);
		
		currentStatusLabel = new JLabel("");
		currentStatusLabel.setBounds(164, 267, 398, 15);
		panel.add(currentStatusLabel);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addListMouseListener(eventList);
		
		acceptButton.setVisible(false);
		rejectButton.setVisible(false);
		updateButton.setVisible(false);
		
		accaptEventAction();
		updateEventAction();
		rejectEventAction();
		setVisible(true);
		
		
		
	}
	
	public void addListMouseListener(JList list) {
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				int index = list.locationToIndex(evt.getPoint());
				Event event = (Event) list.getModel().getElementAt(index);
				eventName.setText(event.getName());
				dateFrom.setText(event.getDateFrom());
				dateTo.setText(event.getDateTo());
				budget.setText(String.valueOf(event.getBudget()));
				description.setText(event.getDescription());
				clientInfo.setText(event.getClient().getName());
				currentStatusLabel.setText(event.getStatus().toString());
				currentEventId = event.getId();
				
				if(currentUser.getRole() == Role.SeniorCustomerService && event.getStatus() == Status.Created){
					acceptButton.setVisible(true);
					rejectButton.setVisible(true);
				}
				
				if(currentUser.getRole() == Role.FinancialManager && event.getStatus() == Status.AcceptedBySCS){
					acceptButton.setVisible(true);
					rejectButton.setVisible(true);
					updateButton.setVisible(true);
				}
				
				if(currentUser.getRole() == Role.AdministrationManager && event.getStatus() == Status.AcceptedByFM) {
					acceptButton.setVisible(true);
					rejectButton.setVisible(true);
				}
				
				if(currentUser.getRole() == Role.FinancialManager && event.getStatus() == Status.AcceptedByAM) {
					updateButton.setVisible(true);
				}
			}
			
		});
	}
	
	public void accaptEventAction(){
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeStatus(currentEventId,currentUser);
			}
		});
	}
	
	public void updateEventAction(){
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double newBudget = Double.valueOf(budget.getText());
				Event event = (Event) eventList.getSelectedValue();
				controller.updateEvent(newBudget, event);
			}
		});
	}
	
	public void rejectEventAction(){
		rejectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Event event = (Event) eventList.getSelectedValue();
				controller.deleteEvent(event);
			}
		});
	}
}
