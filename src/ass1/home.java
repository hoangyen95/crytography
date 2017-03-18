package ass1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CRYPTOGRAPHY PROGRAM");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(81, 23, 297, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Generate Key");
		btnNewButton.setForeground(new Color(255, 255, 224));
		btnNewButton.setBackground(new Color(107, 142, 35));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				generateKey genKey  = new generateKey();
				genKey.setLocationRelativeTo(null);
				genKey.setVisible(true);
			}
		});
		btnNewButton.setBounds(81, 62, 266, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hasing MD5");
		btnNewButton_1.setForeground(new Color(255, 255, 224));
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MD5_gui md5  = new MD5_gui();
				md5.setLocationRelativeTo(null);
				md5.setVisible(true);
		        setVisible(false);
			}
		});
		btnNewButton_1.setBounds(81, 117, 266, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Encryption & Decryption");
		btnNewButton_2.setForeground(new Color(255, 255, 224));
		btnNewButton_2.setBackground(new Color(154, 205, 50));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				algorithm a  = new algorithm();
		        a.setLocationRelativeTo(null);
		        a.setVisible(true);
		        setVisible(false);
			}
		});
		btnNewButton_2.setBounds(81, 168, 266, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EXIT");
		btnNewButton_3.setBackground(new Color(255, 250, 250));
		btnNewButton_3.setForeground(new Color(75, 0, 130));
		btnNewButton_3.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(346, 260, 78, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Advanced Function");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(173, 255, 47));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				advance ad  = new advance();
		        ad.setLocationRelativeTo(null);
		        ad.setVisible(true);
		        setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_4.setBounds(81, 217, 266, 33);
		contentPane.add(btnNewButton_4);
	}
}
