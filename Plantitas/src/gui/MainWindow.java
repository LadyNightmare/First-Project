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
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/leaf16.png")));
		setTitle("DataPlant 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSearchPlant = new JButton("Search plant");
		btnSearchPlant.setIcon(new ImageIcon(MainWindow.class.getResource("/img/leaf16.png")));
		btnSearchPlant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchWindow frame = new SearchWindow(0, null);
				frame.setVisible(true);
			}
		});
		btnSearchPlant.setBounds(127, 96, 177, 23);
		contentPane.add(btnSearchPlant);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginWindow frame = new LoginWindow();
				frame.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(127, 130, 177, 23);
		contentPane.add(btnLogin);

		JButton btnSign = new JButton("Sign up");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("A");
					SignupWindow frame = new SignupWindow();
					frame.setVisible(true);
					dispose();
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		btnSign.setBounds(127, 164, 177, 23);
		contentPane.add(btnSign);

		JLabel lblWelcome = new JLabel("Welcome to the most complete plant database!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(12, 12, 420, 14);
		contentPane.add(lblWelcome);

		JLabel logoImg = new JLabel("");
		logoImg.setIcon(new ImageIcon(MainWindow.class.getResource("/img/leaf32.png")));
		logoImg.setBounds(196, 44, 35, 39);
		contentPane.add(logoImg);
	}
}
