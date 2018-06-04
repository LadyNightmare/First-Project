package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import plantsSrc.Post;
import plantsSrc.User;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class WritePostWindow extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextField plantField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WritePostWindow frame = new WritePostWindow("default");
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
	public WritePostWindow(String user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WritePostWindow.class.getResource("/img/leaf16.png")));
		setTitle("DataPlant 1.0 - Write post");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(WritePostWindow.class.getResource("/img/back.png")));
		btnBack.setBounds(483, 261, 114, 25);
		contentPane.add(btnBack);

		titleField = new JTextField();
		titleField.setBounds(103, 12, 213, 19);
		contentPane.add(titleField);
		titleField.setColumns(10);

		plantField = new JTextField();
		plantField.setColumns(10);
		plantField.setBounds(437, 12, 124, 19);
		contentPane.add(plantField);

		JLabel lblTitle = new JLabel("TITLE:");
		lblTitle.setBounds(32, 14, 66, 15);
		contentPane.add(lblTitle);

		JLabel lblPlant = new JLabel("PLANT:");
		lblPlant.setBounds(354, 14, 66, 15);
		contentPane.add(lblPlant);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 47, 565, 195);
		contentPane.add(scrollPane);

		JTextPane postPane = new JTextPane();
		scrollPane.setViewportView(postPane);

		JButton btnPost = new JButton("POST");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random r = new Random();
				String id = Integer.toString(r.nextInt(Integer.MAX_VALUE));
				String head = titleField.getText();
				String body = postPane.getText();
				String plant = plantField.getText();

				Post post = new Post(id, head, body, user, plant);

				User.writePost(post);
				
				PopupWindow.pShow("Post created succesfully!");
				dispose();
			}
		});
		btnPost.setBounds(357, 261, 114, 25);
		contentPane.add(btnPost);

	}
}
