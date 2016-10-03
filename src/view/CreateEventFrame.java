package view;

import javax.swing.*;

import controller.Controller;
import model.User;

import java.awt.*;
import java.awt.event.*;

public class CreateEventFrame extends JFrame {

	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField txtName;
	private JTextField textField;
	private JLabel lblDate;
	private JTextField textField_1;
	private JLabel lblBudget;
	private JTextPane textPane;
	private JLabel lblDiscription;
	private JTextField textField_2;
	private JLabel lblDateTo;
	private JList list_1;


	public CreateEventFrame(Controller controller) {
		super("SEP System");
		setSize(600, 400);
		setLocation(500, 280);
		panel.setLayout(null);
		
		this.controller = controller;
		
		

		getContentPane().add(panel);
		
		txtName = new JTextField();
		txtName.setBounds(164, 30, 114, 19);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(47, 32, 70, 15);
		panel.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(164, 76, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		lblDate = new JLabel("Date from");
		lblDate.setBounds(47, 78, 99, 15);
		panel.add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 145, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblBudget = new JLabel("Budget");
		lblBudget.setBounds(47, 147, 70, 15);
		panel.add(lblBudget);
		
		textPane = new JTextPane();
		textPane.setBounds(159, 192, 119, 88);
		panel.add(textPane);
		
		lblDiscription = new JLabel("Description");
		lblDiscription.setBounds(47, 192, 99, 15);
		panel.add(lblDiscription);
		
		DefaultListModel model;
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(328, 32, 70, 15);
		panel.add(lblClient);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(233, 317, 117, 25);
		panel.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(164, 114, 114, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		lblDateTo = new JLabel("Date to");
		lblDateTo.setBounds(47, 116, 70, 15);
		panel.add(lblDateTo);
		

		
		
		
		list_1 = new JList();
		list_1.setBounds(405, 30, 158, 250);
		panel.add(list_1);
		list_1.setListData(controller.getClients().toArray());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
