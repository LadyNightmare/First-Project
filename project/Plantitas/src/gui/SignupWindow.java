package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import plantsSrc.Guest;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SignupWindow extends JFrame {
	Random r = new Random();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title = "Sign up";

	private JPanel contentPane;
	private JTextField userField;
	private JTextField mailField;
	private JTextField passField;
	private JTextField repassField;
	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblRepeatPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupWindow frame = new SignupWindow();
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
	public SignupWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignupWindow.class.getResource("/img/leaf16.png")));
		setTitle("DataPlant 1.0 - " + title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					dispose();
				} catch (Exception d) {
					d.printStackTrace();
				}
			}
		});
		btnBack.setIcon(new ImageIcon(LoginWindow.class.getResource("/img/back.png")));
		btnBack.setBounds(230, 217, 114, 25);
		contentPane.add(btnBack);

		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = userField.getText();
				String mail = mailField.getText();
				String password = passField.getText();
				String repass = repassField.getText();

				if (username.length() == 0 || mail.length() == 0 || password.length() == 0 || repass.length() == 0) {
					// check if there is any null field
					pError("Please complete all fields!");
				} else if (isMail(mail)) {
					// check if email is email
					pError("Invalid email!");
					mailField.setText("");
				} else if (!password.equals(repass)) {
					// check if passwords match
					pError("Passwords must match!");
					passField.setText("");
					repassField.setText("");
				} else if (password.length() < 5) {
					// check if password is too short
					pError("Password must be at least 5 characters long!");
					passField.setText("");
					repassField.setText("");
				} else if (username.length() <= 2) {
					// check if username is too short
					pError("Username must be at least 3 characters long");
					userField.setText("");
				} else if (Guest.login(username, password) == 0 || Guest.login(username, password) == 1) {
					// check if user already exists
					pError("User already exists");
					userField.setText("");
				} else {
					// call the signup method with the entered results
					// TODO: Make the signip method return true if the registration was succesful
					if (Guest.signUp(username, password, mail)) {
						PopupWindow.pShow("Registration succesfull!\nWelcome to the comunity, " + username);
						dispose();
						LoginWindow frame = new LoginWindow();
						frame.setVisible(true);
					} else {
						pError("Registration failed!\nPlease try again");
						dispose();
						SignupWindow s = new SignupWindow();
						s.setVisible(true);
					}

				}
			}

		}

		);
		btnSignUp.setBounds(120, 167, 114, 25);
		contentPane.add(btnSignUp);

		userField = new JTextField();
		userField.setBounds(193, 25, 124, 19);
		contentPane.add(userField);
		userField.setColumns(10);

		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(193, 56, 124, 19);
		contentPane.add(mailField);

		passField = new JPasswordField();
		passField.setColumns(10);
		passField.setBounds(193, 87, 124, 19);
		contentPane.add(passField);

		repassField = new JPasswordField();
		repassField.setColumns(10);
		repassField.setBounds(193, 118, 124, 19);
		contentPane.add(repassField);

		lblUsername = new JLabel("Username");
		lblUsername.setBounds(35, 25, 129, 15);
		contentPane.add(lblUsername);

		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(35, 56, 129, 15);
		contentPane.add(lblEmail);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(35, 87, 129, 15);
		contentPane.add(lblPassword);

		lblRepeatPassword = new JLabel("Repeat password");
		lblRepeatPassword.setBounds(35, 118, 129, 15);
		contentPane.add(lblRepeatPassword);
	}

	private boolean isMail(String mail) {
		return !mail.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}");
	}

	private void pError(String msg) {
		ErrorWindow.pError(msg);
	}

}
