package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import plantsSrc.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AdminWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow frame = new AdminWindow(null);
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
	public AdminWindow(User user) {
		setTitle("DataPlant 1.0 - Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminTools = new JLabel("Admin tools / " + user.getUsername());
		lblAdminTools.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminTools.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblAdminTools.setBounds(12, 0, 426, 25);
		contentPane.add(lblAdminTools);
		
		JButton btnNewAdmin = new JButton("Give admin");
		btnNewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewAdmin.setBounds(105, 37, 230, 25);
		contentPane.add(btnNewAdmin);
		
		JButton btnRemoveAdmin = new JButton("Remove admin");
		btnRemoveAdmin.setBounds(105, 62, 230, 25);
		contentPane.add(btnRemoveAdmin);
		
		JButton btnLogOut = new JButton("Close");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnLogOut.setIcon(new ImageIcon(AdminWindow.class.getResource("/img/error.png")));
		btnLogOut.setBounds(342, 224, 96, 34);
		contentPane.add(btnLogOut);
		
		JButton btnDeletePost = new JButton("Delete post");
		btnDeletePost.setBounds(105, 99, 230, 25);
		contentPane.add(btnDeletePost);
		
		JButton btnDeleteComment = new JButton("Delete comment");
		btnDeleteComment.setBounds(105, 123, 230, 25);
		contentPane.add(btnDeleteComment);
		
		JButton btnModifyPlant = new JButton("Modify plant");
		btnModifyPlant.setBounds(105, 160, 230, 25);
		contentPane.add(btnModifyPlant);
		
		JButton btnCreatePlant = new JButton("Create plant");
		btnCreatePlant.setBounds(105, 184, 230, 25);
		contentPane.add(btnCreatePlant);
	}
}
