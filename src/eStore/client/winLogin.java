package eStore.client;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.*;
import javax.swing.LayoutStyle.*;
import javax.swing.GroupLayout.*;

import eStore.*;

public class winLogin {
	private JFrame frame;
	private JTextField txtUsername;
	private JLabel lblEnterUsername;
	private JLabel lblEnterPassword;
	private JPasswordField passPassword;
	private String username;
	private String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winLogin window = new winLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public winLogin() {
		try {
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter ip");
		String ip = userInput.readLine();
		System.out.println("Enter Port");
		int port = Integer.parseInt(userInput.readLine());
		ConnectorClient.getCommand().connect(ip,port);
	} catch(Exception e) {
	}
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = txtUsername.getText().toString();
				password = passPassword.getPassword().toString();
				
				if(username == null || password == null) {
					if(username == null) {
						//Messagebox
					}
					if(password == null) {
						//MessageBox
					}
					
				}
				else {
					User user = new User(username,password);
					Control.getControl().Login(user);
				}
				
			}
		});
		
		JButton btnExit = new JButton("Exit");
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		lblEnterUsername = new JLabel("Enter Username:");
		
		lblEnterPassword = new JLabel("Enter Password");
		
		passPassword = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblEnterPassword, Alignment.LEADING)
						.addComponent(lblEnterUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(passPassword)
								.addComponent(txtUsername))
							.addGap(66))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblEnterUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblEnterPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(passPassword))
					.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnExit))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
