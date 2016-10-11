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
import model.User;

import javax.swing.SwingConstants;

public class ListTaskFrame extends JFrame {
	
	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField originalBudgetField;
	private JTextField additionalBudgetField;
	JButton updateButton = new JButton("Update");
	private JLabel lblAdditionalBudget;
	private JTextPane descriptionField;
	private JLabel lblDiscription;
	private JList tasksList;
	private JTextField expectedPlanField;
	private int currentEventId;
	private User currentUser;


	public ListTaskFrame(Controller controller, User currentUser) {
		super("SEP System");
		setSize(600, 400);
		setLocation(500, 280);
		panel.setLayout(null);
		
		this.controller = controller;
		this.currentUser = currentUser;
		

		getContentPane().add(panel);
		
		originalBudgetField = new JTextField();
		originalBudgetField.setBounds(164, 10, 114, 19);
		panel.add(originalBudgetField);
		originalBudgetField.setColumns(10);
		
		JLabel lblOriginalBudget = new JLabel("Original Budget");
		lblOriginalBudget.setBounds(12, 12, 117, 15);
		panel.add(lblOriginalBudget);
		
		additionalBudgetField = new JTextField();
		additionalBudgetField.setBounds(164, 41, 114, 19);
		panel.add(additionalBudgetField);
		additionalBudgetField.setColumns(10);
		
		lblAdditionalBudget = new JLabel("Additional Budget");
		lblAdditionalBudget.setBounds(12, 39, 134, 15);
		panel.add(lblAdditionalBudget);
		
		descriptionField = new JTextPane();
		descriptionField.setBounds(164, 85, 119, 88);
		panel.add(descriptionField);
		
		lblDiscription = new JLabel("Description");
		lblDiscription.setBounds(12, 84, 134, 15);
		panel.add(lblDiscription);
		
		
		JLabel tasksLabel = new JLabel("Tasks");
		tasksLabel.setBounds(328, 32, 70, 15);
		panel.add(tasksLabel);
		
		List<Task> allTasks = controller.getTasks();
		List<Task> taskToDisplay = new ArrayList<>();
		
		for (Task task : allTasks) {
			if((currentUser.getRole() == Role.ProductionManager  || currentUser.getRole() == Role.ServiceManager) && 
			   task.getTeam().getManager().getRole() == currentUser.getRole()){
				taskToDisplay.add(task);
			} else {
				if(task.getTeam().getMembers().contains(currentUser)) taskToDisplay.add(task); 
			}
			
		}
		
		
		Task[] tasks  = taskToDisplay.toArray(new Task[taskToDisplay.size()]);
		
		tasksList = new JList(tasks);
		panel.add(tasksList);
		tasksList.setBounds(356, 59, 228, 167);
	    JScrollPane pane = new JScrollPane();

	    getContentPane().add(pane, BorderLayout.NORTH);
		

		
		
		JLabel lblPlan = new JLabel("Expected Plan");
		lblPlan.setBounds(12, 184, 105, 15);
		panel.add(lblPlan);
		
		expectedPlanField = new JTextField();
		expectedPlanField.setBounds(164, 185, 119, 93);
		panel.add(expectedPlanField);
		expectedPlanField.setColumns(10);
		
		
		updateButton.setBounds(237, 314, 117, 25);
		panel.add(updateButton);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addListMouseListener(tasksList);
		updateButton.setVisible(false);
		
	
		updateEventAction();
		
		setVisible(true);
		
		
		
	}
	
	public void addListMouseListener(JList list) {
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				int index = list.locationToIndex(evt.getPoint());
				Task task = (Task) list.getModel().getElementAt(index);
				originalBudgetField.setText(String.valueOf(task.getOriginalBudget()));
				additionalBudgetField.setText(String.valueOf(task.getAdditionalBudget()));
				descriptionField.setText(task.getDescription());
				expectedPlanField.setText(task.getExpectedPlan());
				
				if(!(currentUser.getRole() == Role.ServiceManager || currentUser.getRole() == Role.ProductionManager)){
					updateButton.setVisible(true);
				}
				
				
			}
			
		});
	}
	

	public void updateEventAction(){
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double additionalBudget = Double.valueOf(additionalBudgetField.getText());
				String expectedPlan = expectedPlanField.getText();
				Task task = (Task) tasksList.getSelectedValue();
				controller.updateTask(additionalBudget, expectedPlan, task);
				
			}
		});
	}
	
	
}
