package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import model.Team;
import model.User;

import javax.swing.SwingConstants;

import org.hamcrest.Description;

public class CreateResourceReq extends JFrame {
	
	private final Controller controller;


	JPanel panel = new JPanel();
	JButton createButton = new JButton("Create");
	private JTextField descriptionField;
	private JLabel lblDescription;
	private JList eventList;
	private User currentUser;
	private JLabel lblResources;
	private JTextField resourcesField;


	public CreateResourceReq(Controller controller, User currentUser) {
		super("SEP System");
		setSize(600, 400);
		setLocation(500, 280);
		panel.setLayout(null);
		
		this.controller = controller;
		this.currentUser = currentUser;
		

		getContentPane().add(panel);
		
		
		JLabel eventsLabel = new JLabel("Events");
		eventsLabel.setBounds(328, 12, 70, 15);
		panel.add(eventsLabel);
		
		
		createButton.setBounds(233, 313, 117, 25);
		panel.add(createButton);
		
		descriptionField = new JTextField();
		descriptionField.setBounds(135, 29, 163, 86);
		panel.add(descriptionField);
		descriptionField.setColumns(10);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(12, 27, 105, 15);
		panel.add(lblDescription);
		
		List<Event> eventss = controller.getEvents();
		Event[] events  = eventss.toArray(new Event[eventss.size()]);
		
		eventList = new JList(events);
		panel.add(eventList);
		eventList.setBounds(338, 42, 228, 93);
	    JScrollPane pane = new JScrollPane();

	    getContentPane().add(pane, BorderLayout.NORTH);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		lblResources = new JLabel("Resources");
		lblResources.setBounds(12, 159, 105, 15);
		panel.add(lblResources);
		
		resourcesField = new JTextField();
		resourcesField.setColumns(10);
		resourcesField.setBounds(135, 157, 163, 86);
		panel.add(resourcesField);
			
		
		createResourceAction();
		setVisible(true);
		
		
		
	}
	
	
	
	public void createResourceAction(){
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = descriptionField.getText();
				String resources = resourcesField.getText();
				Event event = (Event) eventList.getSelectedValue();
				controller.createResourceRequest(event, description, resources, currentUser);
			}
		});
	}
}
