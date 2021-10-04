package com.guiTrying;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI2 implements ActionListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	JTextField userfield;
	JLabel passwordLabel;
	JPasswordField passwordfield;
	JButton button;
	JLabel success;
	
	public GUI2()  {
		panel = new JPanel();
		
		frame = new JFrame();
		frame.setSize(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.add(panel);
		panel.setLayout(null);
		
		label = new JLabel("Usuário");
		label.setBounds(10, 20, 80, 25);
		panel.add(label);
		
		userfield = new JTextField(20);
		userfield.setBounds(100, 20, 165, 25);
		panel.add(userfield);
		
		passwordLabel = new JLabel("Senha");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordfield = new JPasswordField();
		passwordfield.setBounds(100, 50, 165, 25);
		panel.add(passwordfield);
		
		button = new JButton("Login");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(this);
		panel.add(button);
		
		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);
		
		
		frame.setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new GUI2();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String userText = userfield.getText();
		String userPassword = passwordfield.getText();
		System.out.println(userText+" "+userPassword);
		
	}

}
