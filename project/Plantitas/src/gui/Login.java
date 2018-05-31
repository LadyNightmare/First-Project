package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JTextField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 143);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userField = new JTextField();
		userField.setBounds(112, 11, 86, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(112, 42, 86, 20);
		contentPane.add(passField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(82, 73, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(48, 14, 46, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(48, 45, 46, 14);
		contentPane.add(lblPassword);
		
		//TODO: get login data, call checkLogin and create a logged window or an error window
	}
	
	private boolean checkLogin(String username, String password) {
		boolean check = false;
		//search the user in the database
		int id = searchUser(); //this method should search the user in the database and return its id
		if(password == id.getPassword())//id.getPasword() should return an String with the password of id
			check = true;	
		
		return check;
	}
}
