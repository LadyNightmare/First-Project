package gui;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuestWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title = "Guest";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestWindow frame = new GuestWindow();
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
	public GuestWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuestWindow.class.getResource("/img/leaf16.png")));
		setTitle("DataPlant 1.0 - " + title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSearchPlant = new JButton("Search plant");
		btnSearchPlant.setIcon(new ImageIcon(GuestWindow.class.getResource("/img/leaf16.png")));
		btnSearchPlant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SearchWindow frame = new SearchWindow(0);
					frame.setVisible(true);
					dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnSearchPlant.setBounds(131, 95, 163, 23);
		contentPane.add(btnSearchPlant);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
					dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(146, 130, 133, 23);
		contentPane.add(btnLogin);

		JButton btnSign = new JButton("Sign up");
		btnSign.setBounds(146, 164, 133, 23);
		contentPane.add(btnSign);

		JLabel lblWelcome = new JLabel("Welcome to the most complete plant database!");
		lblWelcome.setBounds(56, 12, 355, 14);
		contentPane.add(lblWelcome);

		JLabel logoImg = new JLabel("");
		logoImg.setIcon(new ImageIcon(GuestWindow.class.getResource("/img/leaf32.png")));
		logoImg.setBounds(196, 44, 35, 39);
		contentPane.add(logoImg);
	}
}
