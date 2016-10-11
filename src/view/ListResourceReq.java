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
import model.ResourceReq;
import model.Role;
import model.StaffReq;
import model.Status;
import model.Task;
import model.User;

import javax.swing.SwingConstants;

public class ListResourceReq extends JFrame {
	
	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField managerField;
	JButton closeButton = new JButton("Close");
	private JLabel lblResources;
	private JTextPane descriptionField;
	private JLabel lblDiscription;
	private JList requestList;
	private int currentEventId;
	private User currentUser;
	JTextPane resourcesField = new JTextPane();


	public ListResourceReq(Controller controller, User currentUser) {
		super("SEP System");
		setSize(600, 400);
		setLocation(500, 280);
		panel.setLayout(null);
		
		this.controller = controller;
		this.currentUser = currentUser;
		

		getContentPane().add(panel);
		
		managerField = new JTextField();
		managerField.setBounds(164, 10, 114, 19);
		panel.add(managerField);
		managerField.setColumns(10);
		
		JLabel lblManagerName = new JLabel("Manager");
		lblManagerName.setBounds(12, 12, 117, 15);
		panel.add(lblManagerName);
		
		lblResources = new JLabel("Resources");
		lblResources.setBounds(12, 39, 134, 15);
		panel.add(lblResources);
		
		descriptionField = new JTextPane();
		descriptionField.setBounds(164, 138, 119, 88);
		panel.add(descriptionField);
		
		lblDiscription = new JLabel("Description");
		lblDiscription.setBounds(12, 140, 134, 15);
		panel.add(lblDiscription);
		
		
		JLabel requestLabel = new JLabel("Resource Requests");
		requestLabel.setBounds(328, 32, 160, 15);
		panel.add(requestLabel);
		
		List<ResourceReq> req = controller.getResourceReq();
		
		ResourceReq[] requests  = req.toArray(new ResourceReq[req.size()]);
		
		requestList = new JList(requests);
		panel.add(requestList);
		requestList.setBounds(356, 59, 228, 167);
	    JScrollPane pane = new JScrollPane();

	    getContentPane().add(pane, BorderLayout.NORTH);
		
		
		closeButton.setBounds(237, 314, 117, 25);
		panel.add(closeButton);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addListMouseListener(requestList);
		
		
		resourcesField.setBounds(164, 41, 119, 88);
		panel.add(resourcesField);
		closeButton.setVisible(true);
		
	
		closeStaffReqAction();
		
		setVisible(true);
		
		
		
	}
	
	public void addListMouseListener(JList list) {
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				int index = list.locationToIndex(evt.getPoint());
				ResourceReq req = (ResourceReq) list.getModel().getElementAt(index);
				managerField.setText(req.getManager().getRole().toString());
				resourcesField.setText(req.getResources());
				
				descriptionField.setText(req.getDescription());
			}
			
		});
	}
	

	public void closeStaffReqAction(){
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResourceReq req = (ResourceReq) requestList.getSelectedValue();
				controller.deleteResourceReq(req);
				
			}
		});
	}
}
