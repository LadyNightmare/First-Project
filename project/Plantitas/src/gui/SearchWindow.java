package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import plantsSrc.Post;
import plantsSrc.User;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class SearchWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title = "Search";

	private JPanel contentPane;
	private JTextField searchField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchWindow frame = new SearchWindow(0);
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
	public SearchWindow(int from) {
		boolean show = false;
		setTitle("DataPlant 1.0 - " + title);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchWindow.class.getResource("/img/leaf16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (from == 0) { // if it comes from the guest window
					try {
						GuestWindow frame = new GuestWindow();
						frame.setVisible(true);
						dispose();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				if (from == 1) { // if it comes from the logged window
					try {
						UserWindow frame = new UserWindow("");
						frame.setVisible(true);
						dispose();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnBack.setIcon(new ImageIcon(SearchWindow.class.getResource("/img/back.png")));
		btnBack.setBounds(434, 243, 114, 35);
		contentPane.add(btnBack);

		searchField = new JTextField();
		searchField.setBounds(119, 12, 189, 20);
		contentPane.add(searchField);
		searchField.setColumns(10);

		JLabel lblPlantName = new JLabel("Plant name:");
		lblPlantName.setBounds(10, 14, 78, 17);
		contentPane.add(lblPlantName);

		JList<Post> list = new JList<Post>();
		list.setBounds(22, 53, 501, 165);
		contentPane.add(list);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String search = searchField.getText();

				if (search.length() == 0)
					pError("Please enter the plant name");
				else {
					// build the list
					// java.util.List<Post> Posts = User.searchPlant(search);
					java.util.List<Post> Posts = testSearchPlant();

				}
			}
		});
		btnSearch.setBounds(362, 11, 89, 23);
		contentPane.add(btnSearch);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(506, 53, 17, 165);
		contentPane.add(scrollBar);
	}

	private void pError(String msg) {
		ErrorWindow.pError(msg);
	}

	private List<Post> testSearchPlant() {
		List<Post> plantList = new ArrayList<>();
		Post p = new Post("1", "Head1", "Body1", "aguimorefran", "Strawberry");
		Post p2 = new Post("2", "Head2", "Body2", "mrarm", "Pineapple");

		plantList.add(p);
		plantList.add(p2);

		return plantList;
	}
}
