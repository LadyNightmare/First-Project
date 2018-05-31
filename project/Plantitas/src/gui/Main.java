package gui;

import java.awt.BorderLayout;
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

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/leaf16.png")));
		setTitle("DataPlant 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearchPlant = new JButton("Search plant");
		btnSearchPlant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnSearchPlant.setBounds(79, 88, 133, 23);
		contentPane.add(btnSearchPlant);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(79, 122, 133, 23);
		contentPane.add(btnLogin);
		
		JButton btnSign = new JButton("Sign up");
		btnSign.setBounds(79, 156, 133, 23);
		contentPane.add(btnSign);
		
		JLabel lblWelcome = new JLabel("Welcome to the most complete plant database!");
		lblWelcome.setBounds(37, 11, 234, 14);
		contentPane.add(lblWelcome);
		
		JLabel logoImg = new JLabel("New label");
		logoImg.setIcon(new ImageIcon(Main.class.getResource("/img/leaf32.png")));
		logoImg.setBounds(129, 36, 35, 39);
		contentPane.add(logoImg);
	}
}
