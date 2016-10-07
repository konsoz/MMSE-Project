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
import model.User;

import javax.swing.SwingConstants;

public class ClientListFrame extends JFrame {
	
	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField clientNameField;
	private JTextField clientPhoneField;
	private JLabel lblDate;
	private JTextPane clientEventField;
	private JLabel lblClientEvents;
	private JTextField clientEmailField;
	private JLabel lblDateTo;
	private JList eventList;
	private int currentEventId;


	public ClientListFrame(Controller controller) {
		super("SEP System");
		setSize(600, 400);
		setLocation(500, 280);
		panel.setLayout(null);
		
		this.controller = controller;
		

		getContentPane().add(panel);
		
		clientNameField = new JTextField();
		clientNameField.setBounds(164, 10, 114, 19);
		panel.add(clientNameField);
		clientNameField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(47, 12, 70, 15);
		panel.add(lblName);
		
		clientPhoneField = new JTextField();
		clientPhoneField.setBounds(164, 41, 114, 19);
		panel.add(clientPhoneField);
		clientPhoneField.setColumns(10);
		
		lblDate = new JLabel("Phone nr.");
		lblDate.setBounds(47, 39, 99, 15);
		panel.add(lblDate);
		
		clientEventField = new JTextPane();
		clientEventField.setBounds(127, 122, 156, 175);
		panel.add(clientEventField);
		
		lblClientEvents = new JLabel("Events");
		lblClientEvents.setBounds(47, 120, 99, 15);
		panel.add(lblClientEvents);
		
		
		JLabel clientsLabel = new JLabel("Clients");
		clientsLabel.setBounds(328, 32, 70, 15);
		panel.add(clientsLabel);
		
		clientEmailField = new JTextField();
		clientEmailField.setBounds(164, 64, 114, 19);
		panel.add(clientEmailField);
		clientEmailField.setColumns(10);
		
		lblDateTo = new JLabel("Email");
		lblDateTo.setBounds(47, 66, 70, 15);
		panel.add(lblDateTo);
		
		List<Client> client = controller.getClients();
		Client[] clients  = client.toArray(new Client[client.size()]);
		
		eventList = new JList(clients);
		panel.add(eventList);
		eventList.setBounds(356, 59, 228, 167);
	    JScrollPane pane = new JScrollPane();

	    getContentPane().add(pane, BorderLayout.NORTH);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addListMouseListener(eventList);
		
		
		setVisible(true);
		
		
		
	}
	
	public void addListMouseListener(JList list) {
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				int index = list.locationToIndex(evt.getPoint());
				Client client = (Client) list.getModel().getElementAt(index);
				List <Event> events = controller.getEventsWithClient(client);
				StringBuilder bldr = new StringBuilder();
				for (Event event : events) {
					bldr.append(event.getName() + " budget: " +  event.getBudget() + "\n");
				}
				clientEventField.setText(bldr.toString());
				clientNameField.setText(client.getName());
				clientEmailField.setText(client.getEmail());
				clientPhoneField.setText(client.getPhoneNumber());
			}
			
		});
	}

}

