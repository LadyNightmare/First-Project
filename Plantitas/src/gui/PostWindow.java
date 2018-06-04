package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import plantsSrc.Comment;
import plantsSrc.DB;
import plantsSrc.Post;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

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

		 Post POST = getPost(id);
		//Post POST = testgetPost(id);

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 39, 493, 309);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setEditable(false);
		textPane.setText(body(POST));

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

	private String testbody(Post POST) {
		StringBuilder sb = new StringBuilder();
		sb.append(POST.getBody() + "\n");
		sb.append("-----------------------\n");
		sb.append("COMMENTS: ");
		for (int i = 0; i < 20; i++) {
			sb.append("\n---------------------------------\n");
			sb.append(
					"Lorem ipsum dolor sit amet consectetur adipiscing elit id, primis porta vel praesent sociosqu rutrum nisl, montes pharetra mus hac dictum vehicula dignissim.");

		}
		sb.append("\n---------------------------------\n");

		return sb.toString();
	}

	private String body(Post POST) {
		StringBuilder sb = new StringBuilder();
		List<Comment> comments = null;
		try {
			comments = database.getComments(POST.getID());
		} catch (SQLException e) {
			sb.append("Could not retrieve the comments of this post.");
		}

		sb.append(POST.getBody() + "\n");
		sb.append("---------------------------------\n");
		sb.append("COMMENTS: ");

		for (Comment c : comments) {
			sb.append("---------------------------------\n");
			sb.append("#" + c.getComment_ID() + " " + c.getUser() + "\n");
			sb.append(c.getComment() + "\n");
			sb.append("---------------------------------");
		}

		return sb.toString();
	}
}
