package ass1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTabbedPane;
import javax.crypto.SecretKey;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class algorithm extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtInputRSA;
	private JTextField txtKeyRSA;
	private JTextField txtOutputRSA;
	private JTextField txtInputDES;
	private JTextField txtKeyDES;
	private JTextField txtOutputDes;
	private JTextField txtInputAES;
	private JTextField txtKeyAES;
	private JTextField txtOutputAES;

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					algorithm frame = new algorithm();
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
	public algorithm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(230, 230, 250));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("RSA", null, panel_1, null);
		panel_1.setLayout(null);
		
		txtInputRSA = new JTextField();
		txtInputRSA.setBounds(93, 55, 174, 20);
		panel_1.add(txtInputRSA);
		txtInputRSA.setColumns(10);
		
		JButton btnChooseInputRSA = new JButton("Choose");
		btnChooseInputRSA.setBounds(290, 54, 100, 23);
		btnChooseInputRSA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      txtInputRSA.setText(filename);
			}
		});
		panel_1.add(btnChooseInputRSA);
		
		txtKeyRSA = new JTextField();
		txtKeyRSA.setBounds(93, 96, 174, 20);
		panel_1.add(txtKeyRSA);
		txtKeyRSA.setColumns(10);
		
		JButton btnChooseKeyRSA = new JButton("Choose");
		btnChooseKeyRSA.setBounds(290, 95, 100, 23);
		btnChooseKeyRSA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      txtKeyRSA.setText(filename);
			}
		});
		panel_1.add(btnChooseKeyRSA);
		
		txtOutputRSA = new JTextField();
		txtOutputRSA.setBounds(93, 138, 174, 20);
		panel_1.add(txtOutputRSA);
		txtOutputRSA.setColumns(10);
		
		JButton btnChooseOutputRSA = new JButton("Choose");
		btnChooseOutputRSA.setBounds(290, 137, 100, 23);
		btnChooseOutputRSA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JFileChooser chooser = new JFileChooser();
				  chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				  chooser.showSaveDialog(null);
			        String filename = chooser.getSelectedFile().toString();
			        txtOutputRSA.setText(filename);
			}
		});
		panel_1.add(btnChooseOutputRSA);
		
		JButton btnEncrytionRSA = new JButton(" ENCRYPTION");
		btnEncrytionRSA.setForeground(new Color(255, 255, 255));
		btnEncrytionRSA.setBackground(new Color(107, 142, 35));
		btnEncrytionRSA.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEncrytionRSA.setBounds(29, 179, 116, 23);
		btnEncrytionRSA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PUBLIC_KEY_FILE=txtKeyRSA.getText();
				ObjectInputStream inputStream = null;

				// Encrypt the string using the public key
				try {
					inputStream = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				PublicKey publicKey = null;
				try {
					publicKey = (PublicKey) inputStream.readObject();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				File inputFile = new File(txtInputRSA.getText());
				String filename = inputFile.getName();
				File encryptedFile = new File(txtOutputRSA.getText() + "\\" + filename);
				RSA.encrypt(publicKey,inputFile,encryptedFile);
				JOptionPane.showMessageDialog(frame, "Encryption Sucess");
				
			}
		});
		panel_1.add(btnEncrytionRSA);
		
		JButton btnDecrytionRSA = new JButton("DECRYPTION");
		btnDecrytionRSA.setForeground(new Color(0, 0, 139));
		btnDecrytionRSA.setBackground(new Color(192, 192, 192));
		btnDecrytionRSA.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDecrytionRSA.setBounds(155, 179, 113, 23);
		btnDecrytionRSA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectInputStream inputStream = null;
				String PRIVATE_KEY_FILE=txtKeyRSA.getText();
				  try {
					inputStream = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      PrivateKey privateKey = null;
				try {
					privateKey = (PrivateKey) inputStream.readObject();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				File inputFile1 = new File(txtInputRSA.getText());
		        String filename1 = inputFile1.getName();
		        File encryptedFile1 = new File(txtOutputRSA.getText() + "/" + filename1);
		        RSA.decrypt( privateKey,inputFile1,encryptedFile1);
		        JOptionPane.showMessageDialog(frame, "Decription Sucess");
			}
		});
		panel_1.add(btnDecrytionRSA);
		
		JLabel label = new JLabel("Key");
		label.setForeground(new Color(0, 0, 139));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(29, 95, 54, 21);
		panel_1.add(label);
		
		JLabel lblInput_1 = new JLabel("Input");
		lblInput_1.setForeground(new Color(0, 0, 139));
		lblInput_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInput_1.setBounds(29, 54, 54, 21);
		panel_1.add(lblInput_1);
		
		JLabel lblOutput_1 = new JLabel("Output");
		lblOutput_1.setForeground(new Color(0, 0, 139));
		lblOutput_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutput_1.setBounds(29, 137, 54, 21);
		panel_1.add(lblOutput_1);
		
		JButton btnBack_1 = new JButton("BACK");
		btnBack_1.setForeground(new Color(0, 0, 128));
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
		btnBack_1.setBounds(291, 179, 99, 23);
		panel_1.add(btnBack_1);
		
		JLabel lblRsaAlgorithm = new JLabel("RSA Algorithm");
		lblRsaAlgorithm.setForeground(new Color(0, 100, 0));
		lblRsaAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRsaAlgorithm.setBounds(106, 11, 176, 34);
		panel_1.add(lblRsaAlgorithm);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("AES", null, panel_2, null);
		panel_2.setLayout(null);
		
		txtInputAES = new JTextField();
		txtInputAES.setBounds(94, 58, 178, 20);
		panel_2.add(txtInputAES);
		txtInputAES.setColumns(10);
		
		JButton btnChooseInputAES = new JButton("Choose");
		btnChooseInputAES.setBounds(292, 57, 97, 23);
		btnChooseInputAES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      txtInputAES.setText(filename);
			}
		});
		panel_2.add(btnChooseInputAES);
		
		txtKeyAES = new JTextField();
		txtKeyAES.setBounds(94, 96, 178, 23);
		panel_2.add(txtKeyAES);
		txtKeyAES.setColumns(10);
		
		JButton btnChooseKeyAES = new JButton("Choose");
		btnChooseKeyAES.setBounds(292, 96, 97, 23);
		btnChooseKeyAES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      txtKeyAES.setText(filename);
			}
		});
		panel_2.add(btnChooseKeyAES);
		
		txtOutputAES = new JTextField();
		txtOutputAES.setBounds(94, 136, 178, 20);
		panel_2.add(txtOutputAES);
		txtOutputAES.setColumns(10);
		
		JButton btnChooseOutputAES = new JButton("Choose");
		btnChooseOutputAES.setBounds(292, 135, 97, 23);
		btnChooseOutputAES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				  chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				  chooser.showSaveDialog(null);
			        String filename = chooser.getSelectedFile().toString();
			        txtOutputAES.setText(filename);
			}
		});
		panel_2.add(btnChooseOutputAES);
		
		JLabel lblInput_2 = new JLabel("Input");
		lblInput_2.setForeground(new Color(0, 0, 139));
		lblInput_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInput_2.setBounds(30, 57, 54, 21);
		panel_2.add(lblInput_2);
		
		JLabel label_2 = new JLabel("Key");
		label_2.setForeground(new Color(0, 0, 139));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(30, 96, 54, 21);
		panel_2.add(label_2);
		
		JLabel lblOutput_2 = new JLabel("Output");
		lblOutput_2.setForeground(new Color(0, 0, 139));
		lblOutput_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutput_2.setBounds(30, 135, 54, 21);
		panel_2.add(lblOutput_2);
		
		JButton btnEncrytion = new JButton("ENCRYPTION");
		btnEncrytion.setForeground(new Color(255, 250, 250));
		btnEncrytion.setBackground(new Color(107, 142, 35));
		btnEncrytion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEncrytion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String AES_KEY_FILE = txtKeyAES.getText();
				ObjectInputStream inputStream = null;

				
				try {
					inputStream = new ObjectInputStream(new FileInputStream(AES_KEY_FILE));
					System.out.println(inputStream);
					System.out.println("flag");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				SecretKey secretKey = null;
				try {
					secretKey = (SecretKey) inputStream.readObject();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				File inputFile = new File(txtInputAES.getText());
				System.out.println(inputFile);
				String filename = inputFile.getName();
				System.out.println("ten file laf: " + filename);
				File encryptedFile = new File(txtOutputAES.getText() + "\\" + filename);
				AES.encrypt(inputFile,encryptedFile,secretKey);
				JOptionPane.showMessageDialog(frame, "Encryption Sucess");
			}
		});
		btnEncrytion.setBounds(30, 178, 112, 23);
		panel_2.add(btnEncrytion);
		
		JButton btnDecrytion = new JButton("DECRYPTION");
		btnDecrytion.setForeground(new Color(0, 0, 139));
		btnDecrytion.setBackground(new Color(192, 192, 192));
		btnDecrytion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDecrytion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ObjectInputStream inputStream = null;
				String AES_KEY_FILE=txtKeyAES.getText();
				  try {
					inputStream = new ObjectInputStream(new FileInputStream(AES_KEY_FILE));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      SecretKey secretKey = null;
				try {
					secretKey = (SecretKey) inputStream.readObject();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				File inputFile1 = new File(txtInputAES.getText());
		        String filename1 = inputFile1.getName();
		        File encryptedFile1 = new File(txtOutputAES.getText() + "/" + filename1);
		        AES.decrypt(inputFile1, encryptedFile1, secretKey);
		        JOptionPane.showMessageDialog(frame, "Decryption Sucess");
				
			}
		});
		btnDecrytion.setBounds(163, 178, 109, 23);
		panel_2.add(btnDecrytion);
		
		JLabel lblAesalgorithm = new JLabel("AES Algorithm");
		lblAesalgorithm.setForeground(new Color(0, 100, 0));
		lblAesalgorithm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAesalgorithm.setBounds(121, 11, 176, 34);
		panel_2.add(lblAesalgorithm);
		
		JButton btnBack_2 = new JButton("BACK");
		btnBack_2.setForeground(new Color(0, 0, 128));
		btnBack_2.setBackground(new Color(244, 164, 96));
		btnBack_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        home home = new home();
		        home.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        home.setLocationRelativeTo(null);
		        home.setVisible(true);
			}
		});
		btnBack_2.setBounds(292, 178, 97, 23);
		panel_2.add(btnBack_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("DES", null, panel, null);
		panel.setLayout(null);
		
		txtInputDES = new JTextField();
		txtInputDES.setBounds(91, 56, 181, 20);
		panel.add(txtInputDES);
		txtInputDES.setColumns(10);
		
		JButton btnChooseInputDES = new JButton("Choose");
		btnChooseInputDES.setBounds(292, 55, 101, 23);
		btnChooseInputDES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      txtInputDES.setText(filename);
			}
		});
		panel.add(btnChooseInputDES);
		
		txtKeyDES = new JTextField();
		txtKeyDES.setBounds(91, 99, 181, 20);
		panel.add(txtKeyDES);
		txtKeyDES.setColumns(10);
		
		JButton btnChooseKeyDES = new JButton("Choose");
		btnChooseKeyDES.setBounds(292, 98, 101, 23);
		btnChooseKeyDES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      txtKeyDES.setText(filename);
			}
		});
		panel.add(btnChooseKeyDES);
		
		txtOutputDes = new JTextField();
		txtOutputDes.setBounds(91, 140, 181, 20);
		panel.add(txtOutputDes);
		txtOutputDes.setColumns(10);
		
		JButton btnChooseOutputDES = new JButton("Choose");
		btnChooseOutputDES.setBounds(292, 139, 101, 23);
		btnChooseOutputDES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				  chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				  chooser.showSaveDialog(null);
			      String filename = chooser.getSelectedFile().toString();
			      txtOutputDes.setText(filename);
			}
		});
		panel.add(btnChooseOutputDES);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setForeground(new Color(0, 0, 139));
		lblInput.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInput.setBounds(29, 55, 54, 21);
		panel.add(lblInput);
		
		JLabel lblKey = new JLabel("Key");
		lblKey.setForeground(new Color(0, 0, 139));
		lblKey.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKey.setBounds(29, 98, 54, 21);
		panel.add(lblKey);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setForeground(new Color(0, 0, 139));
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutput.setBounds(29, 139, 54, 21);
		panel.add(lblOutput);
		
		JButton btnEncrytionDES = new JButton("ENCRYPTION");
		btnEncrytionDES.setForeground(new Color(255, 250, 250));
		btnEncrytionDES.setBackground(new Color(107, 142, 35));
		btnEncrytionDES.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEncrytionDES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String DES_KEY_FILE = txtKeyDES.getText();
				ObjectInputStream inputStream = null;

				
				try {
					inputStream = new ObjectInputStream(new FileInputStream(DES_KEY_FILE));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				SecretKey secretKey = null;
				try {
					secretKey = (SecretKey) inputStream.readObject();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				File inputFile = new File(txtInputDES.getText());
				String filename = inputFile.getName();
				File encryptedFile = new File(txtOutputDes.getText() + "\\" + filename);
				DES.encrypt(inputFile,encryptedFile,secretKey);
				JOptionPane.showMessageDialog(frame, "Encryption Sucess");
				
			}
		});
		btnEncrytionDES.setBounds(29, 179, 108, 23);
		panel.add(btnEncrytionDES);
		
		JButton btnDecrytionDES = new JButton("DECYPTION");
		btnDecrytionDES.setForeground(new Color(0, 0, 139));
		btnDecrytionDES.setBackground(new Color(192, 192, 192));
		btnDecrytionDES.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDecrytionDES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ObjectInputStream inputStream = null;
				String DES_KEY_FILE=txtKeyDES.getText();
				  try {
					inputStream = new ObjectInputStream(new FileInputStream(DES_KEY_FILE));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      SecretKey secretKey = null;
				try {
					secretKey = (SecretKey) inputStream.readObject();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				File inputFile1 = new File(txtInputDES.getText());
		        String filename1 = inputFile1.getName();
		        File encryptedFile1 = new File(txtOutputDes.getText() + "/" + filename1);
		        DES.decrypt(inputFile1, encryptedFile1, secretKey);
		        JOptionPane.showMessageDialog(frame, "Decryption Sucess");
				
			}
		});
		btnDecrytionDES.setBounds(164, 179, 108, 23);
		panel.add(btnDecrytionDES);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(new Color(0, 0, 128));
		btnBack.setBackground(new Color(244, 164, 96));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        home home = new home();
		        home.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        home.setLocationRelativeTo(null);
		        home.setVisible(true);
			}
		});
		btnBack.setBounds(292, 179, 101, 23);
		panel.add(btnBack);
		
		JLabel lblDesAlgorithm = new JLabel("DES Algorithm");
		lblDesAlgorithm.setForeground(new Color(0, 100, 0));
		lblDesAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDesAlgorithm.setBounds(121, 11, 176, 34);
		panel.add(lblDesAlgorithm);
	}
}
