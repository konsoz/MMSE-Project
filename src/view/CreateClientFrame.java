package view;

import javax.swing.*;

import controller.Controller;
import model.User;

import java.awt.*;
import java.awt.event.*;

public class CreateClientFrame extends JFrame {

	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField clientName;
	private JTextField clientEmail;
	private JLabel lblDate;
	private JTextField clientPhone;
	private JLabel lblDateTo;
	JButton btnNewButton = new JButton("Submit");
	

	public CreateClientFrame(Controller controller) {
		super("SEP System");
		setSize(600, 400);
		setLocation(500, 280);
		panel.setLayout(null);
		
		this.controller = controller;
		
		

		getContentPane().add(panel);
		
		clientName = new JTextField();
		clientName.setBounds(164, 30, 114, 19);
		panel.add(clientName);
		clientName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(47, 32, 70, 15);
		panel.add(lblName);
		
		clientEmail = new JTextField();
		clientEmail.setBounds(164, 76, 114, 19);
		panel.add(clientEmail);
		clientEmail.setColumns(10);
		
		lblDate = new JLabel("Email");
		lblDate.setBounds(47, 78, 99, 15);
		panel.add(lblDate);
		
	
		
		btnNewButton.setBounds(161, 176, 117, 25);
		panel.add(btnNewButton);
		
		clientPhone = new JTextField();
		clientPhone.setBounds(164, 114, 114, 19);
		panel.add(clientPhone);
		clientPhone.setColumns(10);
		
		lblDateTo = new JLabel("Phone n.");
		lblDateTo.setBounds(47, 116, 99, 15);
		panel.add(lblDateTo);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		createClientAction();
	}
	
	public void createClientAction(){
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = clientName.getText();
				String email = clientEmail.getText();
				String phone = clientPhone.getText();
				controller.createClient(name,email,phone);
			}
		});
	}
	
	public JButton getSubmitBtn(){
		return btnNewButton;
	}

	public JTextField getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName.setText(clientName);
	}

	public JTextField getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail.setText(clientEmail);
	}

	public JLabel getLblDate() {
		return lblDate;
	}

	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}

	public JTextField getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone.setText(clientPhone);
	}

	public JLabel getLblDateTo() {
		return lblDateTo;
	}

	public void setLblDateTo(JLabel lblDateTo) {
		this.lblDateTo = lblDateTo;
	}
}
