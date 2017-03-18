package ass1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

public class MD5_gui extends JFrame {

	private JPanel contentPane;
	private JTextField txtInputHashing;
	private JTextField txtOutputHashing;
	private JTextField txtInput2;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MD5_gui frame = new MD5_gui();
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
	public MD5_gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 424, 246);
		contentPane.add(tabbedPane);
		
		JPanel Hashing = new JPanel();
		Hashing.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Hashing", null, Hashing, null);
		Hashing.setLayout(null);
		
		txtInputHashing = new JTextField();
		txtInputHashing.setBounds(115, 48, 164, 20);
		Hashing.add(txtInputHashing);
		txtInputHashing.setColumns(10);
		
		txtOutputHashing = new JTextField();
		txtOutputHashing.setBounds(115, 99, 164, 20);
		Hashing.add(txtOutputHashing);
		txtOutputHashing.setColumns(10);
		
		JButton btnChooseInputHashing = new JButton("Choose");
		btnChooseInputHashing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
			    File f = chooser.getSelectedFile();
			    String filename = f.getAbsolutePath();
			    txtInputHashing.setText(filename);
			}
		});
		btnChooseInputHashing.setBounds(289, 47, 89, 23);
		Hashing.add(btnChooseInputHashing);
		
		JButton btnChooseOutputHashing = new JButton("Choose");
		btnChooseOutputHashing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser chooser = new JFileChooser();
				  chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				  chooser.showSaveDialog(null);
			      String filename = chooser.getSelectedFile().toString();
			      txtOutputHashing.setText(filename);
			}
		});
		btnChooseOutputHashing.setBounds(289, 98, 89, 23);
		Hashing.add(btnChooseOutputHashing);
		
		JButton btnHashing = new JButton("HASING");
		btnHashing.setForeground(new Color(255, 250, 250));
		btnHashing.setBackground(new Color(107, 142, 35));
		btnHashing.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHashing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 File inputFile = new File(txtInputHashing.getText());
			     File outputFile = new File(txtOutputHashing.getText() + "\\test.md5");
			     MD5.hasing(inputFile,outputFile);
			     JOptionPane.showMessageDialog(frame, "Hasing Sucess");
			}
		});
		btnHashing.setBounds(94, 158, 89, 23);
		Hashing.add(btnHashing);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(244, 164, 96));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        home h = new home();
		        h.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        h.setLocationRelativeTo(null);
		        h.setVisible(true);
			}
		});
		btnBack.setBounds(258, 158, 89, 23);
		Hashing.add(btnBack);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setForeground(new Color(0, 0, 139));
		lblInput.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInput.setBounds(51, 49, 46, 14);
		Hashing.add(lblInput);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setForeground(new Color(0, 0, 139));
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutput.setBounds(51, 101, 61, 14);
		Hashing.add(lblOutput);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Check", null, panel, null);
		panel.setLayout(null);
		
		JTextField txtInput1 = new JTextField();
		txtInput1.setBounds(117, 47, 159, 20);
		panel.add(txtInput1);
		txtInput1.setColumns(10);
		
		txtInput2 = new JTextField();
		txtInput2.setBounds(117, 104, 159, 20);
		panel.add(txtInput2);
		txtInput2.setColumns(10);
		
		JLabel lblInput_1 = new JLabel("Input 1");
		lblInput_1.setForeground(new Color(0, 0, 139));
		lblInput_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInput_1.setBounds(41, 50, 66, 14);
		panel.add(lblInput_1);
		
		JLabel lblInput_2 = new JLabel("Input 2");
		lblInput_2.setForeground(new Color(0, 0, 139));
		lblInput_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInput_2.setBounds(41, 107, 66, 14);
		panel.add(lblInput_2);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      txtInput1.setText(filename);
			}
		});
		btnChoose.setBounds(288, 46, 89, 23);
		panel.add(btnChoose);
		
		JButton btnChoose_1 = new JButton("Choose");
		btnChoose_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      txtInput2.setText(filename);
			}
		});
		btnChoose_1.setBounds(288, 103, 89, 23);
		panel.add(btnChoose_1);
		
		JButton btnCheck = new JButton("CHECK");
		btnCheck.setForeground(new Color(255, 250, 250));
		btnCheck.setBackground(new Color(107, 142, 35));
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  if (MD5.check(new File(txtInput1.getText()),new File(txtInput2.getText()))){
					  JOptionPane.showMessageDialog(frame,"2 file  match");
				  }
			        else
			        	JOptionPane.showMessageDialog(frame,"2 file non match");
			            
			}
		});
		btnCheck.setBounds(88, 164, 89, 23);
		panel.add(btnCheck);
		
		JButton btnBack_1 = new JButton("BACK");
		btnBack_1.setBackground(new Color(244, 164, 96));
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        home home = new home();
		        home.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        home.setLocationRelativeTo(null);
		        home.setVisible(true);
			}
		});
		btnBack_1.setBounds(247, 164, 89, 23);
		panel.add(btnBack_1);
	}
}
