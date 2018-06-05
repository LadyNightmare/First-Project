package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import plantsSrc.Comment;
import plantsSrc.Post;
import plantsSrc.User;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CreateCommentWindow extends JFrame {

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
					CreateCommentWindow frame = new CreateCommentWindow(null, null);
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
	public CreateCommentWindow(Post POST, User loggedin) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateCommentWindow.class.getResource("/img/leaf16.png")));
		setTitle("DataPlant 1.0 - Comment post");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel postName = new JLabel("POST: " + POST.getHead());
		postName.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		postName.setHorizontalAlignment(SwingConstants.CENTER);
		postName.setBounds(12, 12, 426, 15);
		contentPane.add(postName);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 39, 426, 180);
		contentPane.add(scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setIcon(new ImageIcon(CreateCommentWindow.class.getResource("/img/back.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(324, 233, 114, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Comment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random r = new Random();
				Comment COMMENT = new Comment(Integer.toString(r.nextInt(Integer.MAX_VALUE)), textPane.getText(),
						loggedin.getUsername(), POST.getID());
				loggedin.addComment(COMMENT);
				
				PopupWindow.pShow("Comment created succesfully!");
				dispose();
				PostWindow newpost = new PostWindow(POST.getID(), 1, loggedin);
				newpost.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(CreateCommentWindow.class.getResource("/img/contract.png")));
		btnNewButton_1.setBounds(78, 233, 189, 25);
		contentPane.add(btnNewButton_1);
	}
}
