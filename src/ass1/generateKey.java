package ass1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class generateKey extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generateKey frame = new generateKey();
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
	public generateKey() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GENERATION KEY");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(115, 26, 239, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblAlgorithm = new JLabel("Algorithm");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlgorithm.setBounds(29, 91, 78, 23);
		contentPane.add(lblAlgorithm);
		
		JLabel lblPath = new JLabel("Path");
		lblPath.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPath.setBounds(27, 125, 62, 14);
		contentPane.add(lblPath);
		
		JRadioButton rdbtnRsa = new JRadioButton("RSA");
		rdbtnRsa.setForeground(new Color(75, 0, 130));
		rdbtnRsa.setBackground(new Color(230, 230, 250));
		rdbtnRsa.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnRsa.setBounds(115, 92, 53, 23);
		contentPane.add(rdbtnRsa);
		
		JRadioButton rdbtnAes = new JRadioButton("AES");
		rdbtnAes.setForeground(new Color(75, 0, 130));
		rdbtnAes.setBackground(new Color(230, 230, 250));
		rdbtnAes.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnAes.setBounds(207, 92, 53, 23);
		contentPane.add(rdbtnAes);
		
		JRadioButton rdbtnDes = new JRadioButton("DES");
		rdbtnDes.setForeground(new Color(75, 0, 130));
		rdbtnDes.setBackground(new Color(230, 230, 250));
		rdbtnDes.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnDes.setBounds(303, 91, 89, 23);
		contentPane.add(rdbtnDes);
		
		textField = new JTextField();
		textField.setBounds(115, 123, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showSaveDialog(null);
			    String filename = chooser.getSelectedFile().toString();
			    textField.setText(filename);
			}
		});
		btnChoose.setBounds(303, 122, 89, 23);
		contentPane.add(btnChoose);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(107, 142, 35));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path="";
				
				//generate key DES
				if(rdbtnDes.isSelected()){
					path=textField.getText();
					String private_Key=path +"/des.key";
					DES.generateKey(private_Key);
					JOptionPane.showMessageDialog(frame, "KeyGeneretion Sucess");
				}
				//generate key RSA
				if(rdbtnRsa.isSelected()){
					path=textField.getText();
					String public_Key=path +"/public.key";
					String private_Key=path +"/private.key";
					RSA.generateKey(public_Key, private_Key);
					JOptionPane.showMessageDialog(frame, "KeyGeneretion Sucess");
				}
				//generate key AES
				if(rdbtnAes.isSelected()){
					path=textField.getText();
					String private_Key=path +"/aes.key";
					AES.generateKey(private_Key);
					JOptionPane.showMessageDialog(frame, "KeyGeneretion Sucess");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(115, 176, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setForeground(new Color(25, 25, 112));
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        home h = new home();
		        h.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        h.setLocationRelativeTo(null);
		        h.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(303, 176, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
