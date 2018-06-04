package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import plantsSrc.DB;
import plantsSrc.Post;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PostWindow extends JFrame {
	DB database = new DB();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostWindow frame = new PostWindow("0");
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
	public PostWindow(String id) {
		String title = "Post";
		setTitle("DataPlant 1.0 - " + title);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PostWindow.class.getResource("/img/leaf16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Post POST = getPost(id);
		Post POST = testgetPost(id);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon(PostWindow.class.getResource("/img/back.png")));
		btnBack.setBounds(391, 360, 114, 25);
		contentPane.add(btnBack);

		JLabel label = new JLabel("Post #" + POST.getID() + " - " + POST.getHead());
		label.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 0, 493, 27);
		contentPane.add(label);

		JLabel lblText = new JLabel(POST.getBody());
		lblText.setVerticalAlignment(SwingConstants.TOP);
		lblText.setBounds(12, 32, 493, 311);
		contentPane.add(lblText);

	}
	
	private Post testgetPost(String id) {
		return new Post(id, "headtest", "bodytest", "usertest", "planttest");
	}

	private Post getPost(String id) {
		Post post = null;
		try {
			ResultSet res = database.makeQuery("SELECT * FROM post WHERE id LIKE '" + id + "'");
			while (res.next()) {
				post = new Post(res.getString("ID"), res.getString("Head"), res.getString("Body"),
						res.getString("User"), res.getString("Plant"));
			}
		} catch (SQLException e) {

		}

		return post;
	}
}
