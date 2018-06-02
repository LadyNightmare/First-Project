package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class UserWindow extends JFrame {
	private String title = "User zone";
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
					UserWindow frame = new UserWindow("defUser");
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
	public UserWindow(String user) {
		setTitle("DataPlant 1.0 - " + title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnLogOut = new JButton("");
		btnLogOut.setBounds(165, 206, 43, 29);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
					dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		btnLogOut.setIcon(new ImageIcon(UserWindow.class.getResource("/img/exit.png")));
		contentPane.add(btnLogOut);
		
		JButton btnPost = new JButton("Write new post");
		btnPost.setHorizontalAlignment(SwingConstants.LEFT);
		btnPost.setIcon(new ImageIcon(UserWindow.class.getResource("/img/contract.png")));
		btnPost.setBounds(93, 109, 171, 34);
		contentPane.add(btnPost);
		
		JButton btnComment = new JButton("Add comment");
		btnComment.setIcon(new ImageIcon(UserWindow.class.getResource("/img/contract.png")));
		btnComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComment.setHorizontalAlignment(SwingConstants.LEFT);
		btnComment.setBounds(93, 160, 171, 34);
		contentPane.add(btnComment);
		
		JButton btnSearch = new JButton("Search plant");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SearchWindow frame = new SearchWindow(1);
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnSearch.setIcon(new ImageIcon(UserWindow.class.getResource("/img/search.png")));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setBounds(93, 63, 171, 34);
		contentPane.add(btnSearch);
		
		JLabel lblWelcomeBack = new JLabel("Welcome back, " + user + "!");
		lblWelcomeBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeBack.setFont(new Font("Courier 10 Pitch", Font.BOLD | Font.ITALIC, 16));
		lblWelcomeBack.setBounds(12, 12, 340, 34);
		contentPane.add(lblWelcomeBack);
	}
}
