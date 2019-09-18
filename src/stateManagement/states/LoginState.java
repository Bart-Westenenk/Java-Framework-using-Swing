package stateManagement.states;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.Printable;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import main.ApplicationMain;
import stateManagement.*;

public class LoginState extends AppState{
	
	
	public LoginState(StateManager stateManager) {
		super(stateManager);
		SM = stateManager;
	}
	
	String[] username = {"Dev1", "Test1", "Test2"};
	String[] password = {"Root", "Password", "1234"};

	JLabel loginLabel;
	JLabel usernameLabel;
	JTextField usernameInputField;
	JLabel passwordLabel;
	JPasswordField passwordInputField;
	JButton loginButton;
	
	Dimension panelDimension = new Dimension(ApplicationMain.WIDTH, ApplicationMain.HEIGHT);
	
	Dimension fieldDimension = new Dimension(250, 20);
	Dimension buttonDimension = new Dimension(100,20);
	
	ActionListener loginActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			login();
		}
	};
	
	StateManager SM;
	JPanel containerPanel;
	JPanel mainPanel;
	
	@Override
	public void init(JPanel panel) {
		mainPanel = panel;
		
		containerPanel = new JPanel();
		BoxLayout layout = new BoxLayout(containerPanel, BoxLayout.Y_AXIS);
		containerPanel.setLayout(layout);
		
		
		loginLabel = new JLabel("Login");
		loginLabel.setPreferredSize(fieldDimension);
		loginLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		loginLabel.setFont(new Font(loginLabel.getFont().getName(), Font.BOLD, 16));
		containerPanel.add(loginLabel);

		usernameLabel = new JLabel("Username: ");
		containerPanel.add(usernameLabel);
		
		usernameInputField = new JTextField();
		usernameInputField.setPreferredSize(fieldDimension);
		usernameInputField.setAlignmentX(Component.LEFT_ALIGNMENT);
		usernameInputField.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		usernameInputField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (usernameInputField.getText().equals("Please enter your username here.")) {
		            usernameInputField.setText("");
		            usernameInputField.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (usernameInputField.getText().isEmpty()) {
		            usernameInputField.setForeground(Color.GRAY);
		            usernameInputField.setText("Please enter your username here.");
		        }
		    }
		    });
		usernameInputField.addActionListener(loginActionListener);
		containerPanel.add(usernameInputField);
		
		
		passwordLabel = new JLabel("Password: ");
		containerPanel.add(passwordLabel);
		
		passwordInputField = new JPasswordField();
		passwordInputField.setPreferredSize(fieldDimension);
		passwordInputField.setAlignmentX(Component.LEFT_ALIGNMENT);
		passwordInputField.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		passwordInputField.addActionListener(loginActionListener);
		containerPanel.add(passwordInputField);


		loginButton = new JButton("LOGIN");
		loginButton.setPreferredSize(buttonDimension);
		
		loginButton.addActionListener(loginActionListener);
		containerPanel.add(loginButton);
		
		
		containerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setBackground(Color.green);
		mainPanel.add(containerPanel);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(JPanel panel) {

	}
	
	@Override
	public void disable() {
		mainPanel.remove(containerPanel);
	}
	
	
	protected void login() {
		char[] passChar = passwordInputField.getPassword();
		String password = new String();
		
		for(char x : passChar) {
		     password += x;	
		}
		
		System.out.printf("Attempt to login with following details %n Username: %s%n Password: %s%n",
				usernameInputField.getText(), password);
		boolean valid = authenticate(usernameInputField.getText(), password);
		System.out.println(valid ? "This is a valid USERNAME and PASSWORD combination." : "USERNAME or PASSWORD invalid.");
		
		if(valid) {
			try {
				SM.changeState(StateManager.TEMPLATESTATE);
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.out.println(e.toString());
			}
		}
		//System.out.println(authenticate(text1.getText(), password));
	}
	
	private boolean authenticate(String usernameString, String passString){
		for (int x = 0; x < username.length; x++) {
			if (usernameString.toLowerCase().equals(username[x].toLowerCase()) && passString.equals(password[x]))
			{
				return true;
			}
		}
		return false;
//		return true;
	}
}
