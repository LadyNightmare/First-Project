package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import plantsSrc.Guest;
import java.awt.Toolkit;

public class LoginWindow extends JFrame {
	private String title = "Login";
	private String user = "default";
	
	private JPanel contentPane;
	private JTextField userField;
	private JTextField passField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
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
	public LoginWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/img/leaf16.png")));
		setTitle("DataPlant 1.0 - " + title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		userField = new JTextField(20);
		userField.setBounds(183, 95, 152, 20);
		contentPane.add(userField);
		userField.setColumns(10);

		passField = new JPasswordField(20);
		passField.setColumns(10);
		passField.setBounds(183, 126, 152, 20);
		contentPane.add(passField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// get entered user and pass
				String enteredUser = userField.getText();
				String enteredPass = passField.getText();

				if (enteredUser.length() == 0 || enteredPass.length() == 0) {
					// error window
					try {
						ErrorWindow frame = new ErrorWindow("ERROR: Empty field username/password");
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} /*else {
					user = enteredUser;
					
					int res = Guest.login(enteredUser, enteredPass);

					if (res == -1) { // user not found
						// error window
					}
					if (res == 0) { // normal user
						// create logged window
						try {
							UserWindow frame = new UserWindow();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if (res == 1) { // admin user
						// create logged window and admin window
						try {
							UserWindow frame = new UserWindow();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// admin window
					}

				}*/
			}
		});
		btnLogin.setBounds(153, 157, 89, 23);
		contentPane.add(btnLogin);

		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(64, 98, 101, 14);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(64, 129, 101, 14);
		contentPane.add(lblPassword);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GuestWindow().setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(LoginWindow.class.getResource("/img/back.png")));
		btnBack.setBounds(268, 213, 114, 25);
		contentPane.add(btnBack);

		JLabel lblUsericon = new JLabel("");
		lblUsericon.setIcon(new ImageIcon(LoginWindow.class.getResource("/img/avatar.png")));
		lblUsericon.setBounds(154, 3, 64, 80);
		contentPane.add(lblUsericon);

		JButton btnTestLog = new JButton("Test");
		btnTestLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UserWindow frame = new UserWindow(user);
					frame.setVisible(true);
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnTestLog.setBounds(268, 156, 89, 23);
		contentPane.add(btnTestLog);

	}
}
