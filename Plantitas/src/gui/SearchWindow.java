package gui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import plantsSrc.DB;
import plantsSrc.Post;
import plantsSrc.User;

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
		searchField.setBounds(121, 13, 247, 20);
		contentPane.add(searchField);
		searchField.setColumns(10);

		JLabel lblPlantName = new JLabel("Plant name:");
		lblPlantName.setBounds(10, 14, 130, 17);
		contentPane.add(lblPlantName);

		JScrollPane scroller = new JScrollPane();
		scroller.setBounds(20, 43, 505, 176);
		contentPane.add(scroller);

		JList<String> resultslist = new JList<String>();
		scroller.setViewportView(resultslist);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String search = searchField.getText();

				if (search.length() == 0)
					pError("Please enter the plant name");
				else {
					// build the list
					List<Post> posts = User.searchPlant(search);

					DefaultListModel<String> DLM = new DefaultListModel<String>();

					//List<Post> posts = testSearchPlant();
					for (int i = 0; i < posts.size(); i++) {
						String id = posts.get(i).getUsername();
						DB db = new DB();
						ResultSet res;
						String username = null;
						try {
							res = db.makeQuery("SELECT * FROM user WHERE ID ="+id);
							 while(res.next()){
								 username=res.getString("Username");
							 }
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						String line = posts.get(i).getID() + "#   " + posts.get(i).getHead() + "   / BY: "
								+ username;
						DLM.addElement(line);
					}
					resultslist.setModel(DLM);
				}
			}
		});
		btnSearch.setBounds(395, 11, 130, 23);
		contentPane.add(btnSearch);

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String line = resultslist.getSelectedValue();
				Scanner sc = new Scanner(line);
				sc.useDelimiter("[#]");
				String id = sc.next();
				
				PostWindow frame = new PostWindow(id, from);
				frame.setVisible(true);
				sc.close();
			}
		});
		btnOpen.setBounds(197, 231, 89, 23);
		contentPane.add(btnOpen);

	}

	private void pError(String msg) {
		ErrorWindow.pError(msg);
	}

	private List<Post> testSearchPlant() {
		List<Post> plantList = new ArrayList<>();
		Post p = new Post("1", "Head1", "Body1", "aguimorefran", "Strawberry");
		Post p2 = new Post("2", "Head2", "Body2", "mrarm", "Pineapple");
		Post p3 = new Post("3", "Head3", "Body3", "jd", "Apple");

		plantList.add(p);
		plantList.add(p2);
		plantList.add(p3);

		return plantList;
	}
}
