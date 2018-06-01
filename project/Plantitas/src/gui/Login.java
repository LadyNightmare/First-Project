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

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField userField;
	private JTextField passField;
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
		setTitle("DataPlant 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		userField = new JTextField(20);
		userField.setBounds(183, 68, 152, 20);
		contentPane.add(userField);
		userField.setColumns(10);

		passField = new JPasswordField(20);
		passField.setColumns(10);
		passField.setBounds(183, 99, 152, 20);
		contentPane.add(passField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res = 
				if (res == -1) { // user not found
					JOptionPane.showMessageDialog(null, "Wrong Password / Username");
				}
				if (res == 0) { // normal user

				}
				if (res == 1) { // admin user

				}
			}
		});
		btnLogin.setBounds(153, 130, 89, 23);
		contentPane.add(btnLogin);

		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(64, 71, 101, 14);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(64, 102, 101, 14);
		contentPane.add(lblPassword);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main().setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(Login.class.getResource("/img/back.png")));
		btnBack.setBounds(268, 213, 114, 25);
		contentPane.add(btnBack);

	}

}
