package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title = "Search";
	
	private JPanel contentPane;

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
	}

}
