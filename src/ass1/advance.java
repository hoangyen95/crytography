package ass1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.crypto.SecretKey;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class advance extends JFrame {

	private JPanel contentPane;
	private JTextField pathFolderr;
	private JTextField path_Key;
	private JTextField pathRes;
	private JTextField pathFolder1;
	private JTextField pathResult1;
	private JTextField pathFolder2;
	private JTextField pathResult2;
	
	private String choosertitle;
	private File[] directory;
	String[] paths;
	File desRsa, resRsa, desAes, resAes, desDes, resDes;
	private JTextField pathDes;
	private JTextField pathDes1;
	private JTextField pathKey1;
	private JTextField pathDes2;
	private JTextField pathKey2;
	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					advance frame = new advance();
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
	public advance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(230, 230, 250));
		tabbedPane.setBounds(0, 0, 434, 261);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("RSA", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(10, 56, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Key");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 87, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblResult = new JLabel("Res Path");
		lblResult.setForeground(new Color(0, 0, 128));
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResult.setBounds(10, 158, 61, 14);
		panel.add(lblResult);
		
		pathFolderr = new JTextField();
		pathFolderr.setBounds(81, 53, 191, 20);
		panel.add(pathFolderr);
		pathFolderr.setColumns(10);
		
		path_Key = new JTextField();
		path_Key.setBounds(81, 84, 191, 20);
		panel.add(path_Key);
		path_Key.setColumns(10);
		
		pathRes = new JTextField();
		pathRes.setBounds(81, 156, 191, 20);
		panel.add(pathRes);
		pathRes.setColumns(10);
		
		JButton btnFolder = new JButton("Choose Folder");
		btnFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(); 
				  chooser.setCurrentDirectory(new java.io.File("."));
				  chooser.setDialogTitle(choosertitle);
				  chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				  //
				  // disable the "All files" option.
				  //
				  chooser.setAcceptAllFileFilterUsed(false);
				  //    
				  if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
				    //System.out.println("getCurrentDirectory(): " +  chooser.getCurrentDirectory());
				    //System.out.println("getSelectedFile() : "  +  chooser.getSelectedFile());
				    File dir = chooser.getSelectedFile();
				    directory = dir.listFiles();
				    paths = dir.list();
				    
				    String path = "" + chooser.getSelectedFile();
				    pathFolderr.setText(path);
				    
//		    	    for (File file : directory) {
//		              System.out.println(file.getAbsolutePath());
//				    }
//				    System.out.println("\n-----------------------");
//		          
//				    System.out.println("String[] list():\n");
//				    int i = 0;
//		            for (String path : paths) {
//		        	  i++;
//		              System.out.println(i + " " + path);
//		              }
				    
				   }
				  else {
				    System.out.println("No Selection ");
				  }
			}
		});
		btnFolder.setBounds(291, 52, 126, 23);
		panel.add(btnFolder);
		
		JButton btnChoose = new JButton("Choose Key");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      path_Key.setText(filename);
			}
		});
		btnChoose.setBounds(291, 83, 126, 23);
		panel.add(btnChoose);
		
		JButton btnCreate = new JButton("Result Folder");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 resRsa = new File("C:\\ResultRSA");
		        
		        if (!resRsa.exists()) {
		            if (resRsa.mkdir()) {
		                System.out.println("Directory is created!");
		            } else {
		                System.out.println("Failed to create directory!");
		            }
		            String rdes = resRsa.getAbsolutePath();
		            pathRes.setText(rdes);
		        }
		        else {
		        	System.out.println("File exist!");
		        }
			}
		});
		btnCreate.setBounds(291, 155, 126, 23);
		panel.add(btnCreate);
		
		JButton btnEncryption = new JButton("ENCRYPTION");
		btnEncryption.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEncryption.setForeground(new Color(255, 255, 240));
		btnEncryption.setBackground(new Color(107, 142, 35));
		btnEncryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PUBLIC_KEY_FILE = path_Key.getText();
				ObjectInputStream inputStream = null;			
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
				for(int i = 0; i < directory.length; i++){				
					File inputFile = new File(directory[i].getAbsolutePath());
					String filename = inputFile.getName();
					File encryptedFile = new File(desRsa + "\\" +filename);
					RSA.encrypt(publicKey,inputFile,encryptedFile);
				}
				JOptionPane.showMessageDialog(frame, "Encryption Sucess");
			}
		});
		btnEncryption.setBounds(10, 199, 114, 23);
		panel.add(btnEncryption);
		
		JButton btnDecription = new JButton("DECRYPTION");
		btnDecription.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDecription.setForeground(new Color(0, 0, 139));
		btnDecription.setBackground(new Color(192, 192, 192));
		btnDecription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectInputStream inputStream = null;
				String PRIVATE_KEY_FILE=path_Key.getText();
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
				
		        
		        for(int i = 0; i < directory.length; i++){
					File inputFile = new File(directory[i].getAbsolutePath());
					String filename = inputFile.getName();
					File encryptedFile = new File(resRsa + "\\" +filename);
					RSA.decrypt(privateKey,inputFile,encryptedFile);
				}
		      JOptionPane.showMessageDialog(frame, "Decryption Sucess");
			}
		});
		btnDecription.setBounds(147, 199, 125, 23);
		panel.add(btnDecription);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setForeground(new Color(0, 0, 139));
		btnBack.setBackground(new Color(244, 164, 96));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				home h = new home();
				h.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        h.setLocationRelativeTo(null);
		        h.setVisible(true);
			}
		});
		btnBack.setBounds(291, 199, 126, 23);
		panel.add(btnBack);
		
		JLabel lblPath = new JLabel("Des Path");
		lblPath.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPath.setForeground(new Color(0, 0, 128));
		lblPath.setBounds(10, 122, 61, 14);
		panel.add(lblPath);
		
		pathDes = new JTextField();
		pathDes.setBounds(81, 119, 191, 20);
		panel.add(pathDes);
		pathDes.setColumns(10);
		
		JButton btnDecryptFolder = new JButton("Decrypt Folder");
		btnDecryptFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desRsa = new File("C:\\DescryptionRSA");
				if (!desRsa.exists()) {
		            if (desRsa.mkdir()) {
		                System.out.println("Directory is created!");
		            } else {
		                System.out.println("Failed to create directory!");
		            }
		            String pdes = desRsa.getAbsolutePath();
		            pathDes.setText(pdes);
		        }
		        else {
		        	System.out.println("File exist!");
		        }
			}
		});
		btnDecryptFolder.setBounds(291, 117, 128, 23);
		panel.add(btnDecryptFolder);
		
		JLabel lblRsaAlgorithm = new JLabel("RSA ALGORITHM");
		lblRsaAlgorithm.setForeground(new Color(0, 100, 0));
		lblRsaAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRsaAlgorithm.setBounds(132, 11, 191, 31);
		panel.add(lblRsaAlgorithm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("AES", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Input");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 59, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Key");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setBounds(10, 90, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Result");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setBounds(10, 158, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		pathFolder1 = new JTextField();
		pathFolder1.setBounds(85, 56, 190, 20);
		panel_1.add(pathFolder1);
		pathFolder1.setColumns(10);
		
		pathResult1 = new JTextField();
		pathResult1.setBounds(85, 155, 190, 20);
		panel_1.add(pathResult1);
		pathResult1.setColumns(10);
		
		JButton btnNewButton = new JButton("Choose Folder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser(); 
				 chooser.setCurrentDirectory(new java.io.File("."));
				 chooser.setDialogTitle(choosertitle);
				 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 chooser.setAcceptAllFileFilterUsed(false);
				 if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
				   File dir = chooser.getSelectedFile();
				   directory = dir.listFiles();
				   paths = dir.list();
				   String path = "" + chooser.getSelectedFile();
				   pathFolder1.setText(path);
				 }
				 else {
				   System.out.println("No Selection ");
				 }
			}
		});
		btnNewButton.setBounds(295, 55, 124, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Choose Key");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      pathKey1.setText(filename);
			}
		});
		btnNewButton_1.setBounds(295, 86, 124, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Result Folder");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resAes = new File("C:\\ResultAES");
				if (!resAes.exists()) {
		            if (resAes.mkdir()) {
		                System.out.println("Directory is created!");
		            } else {
		                System.out.println("Failed to create directory!");
		            }
		            String pdes = resAes.getAbsolutePath();
		            pathResult1.setText(pdes);
		        }
		        else {
		        	System.out.println("File exist!");
		        }
			}
		});
		btnNewButton_2.setBounds(295, 154, 124, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ENCRYPTION");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setForeground(new Color(255, 250, 250));
		btnNewButton_3.setBackground(new Color(107, 142, 35));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String AES_KEY_FILE = pathKey1.getText();
				ObjectInputStream inputStream = null;
				try {
					inputStream = new ObjectInputStream(new FileInputStream(AES_KEY_FILE));
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

				for(int i = 0; i < directory.length; i++){
					File inputFile = new File(directory[i].getAbsolutePath());
					String filename = inputFile.getName();
					File encryptedFile = new File(desAes + "\\" +filename);
					AES.encrypt(inputFile,encryptedFile,secretKey);
				}
				JOptionPane.showMessageDialog(frame, "Encryption Sucess");
			}
		});
		btnNewButton_3.setBounds(10, 199, 119, 23);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DECRYPTION");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setForeground(new Color(0, 0, 139));
		btnNewButton_4.setBackground(new Color(192, 192, 192));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectInputStream inputStream = null;
				String AES_KEY_FILE=pathKey1.getText();
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
				
		        for(int i = 0; i < directory.length; i++){
					File inputFile = new File(directory[i].getAbsolutePath());
					String filename = inputFile.getName();;
					File encryptedFile = new File(resAes + "\\" +filename);
					AES.decrypt(inputFile,encryptedFile,secretKey);
		        }
		        JOptionPane.showMessageDialog(frame, "Decryption Sucess");
			}
		});
		btnNewButton_4.setBounds(151, 199, 124, 23);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("BACK");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBackground(new Color(244, 164, 96));
		btnNewButton_5.setForeground(new Color(0, 0, 139));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				home h = new home();
				h.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        h.setLocationRelativeTo(null);
		        h.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(295, 199, 124, 23);
		panel_1.add(btnNewButton_5);
		
		JLabel lblAesAlgorithm = new JLabel("AES ALGORITHM");
		lblAesAlgorithm.setForeground(new Color(0, 100, 0));
		lblAesAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAesAlgorithm.setBounds(129, 11, 200, 34);
		panel_1.add(lblAesAlgorithm);
		
		JLabel lblDesPath = new JLabel("Des Path");
		lblDesPath.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesPath.setForeground(new Color(0, 0, 128));
		lblDesPath.setBounds(10, 124, 61, 14);
		panel_1.add(lblDesPath);
		
		pathDes1 = new JTextField();
		pathDes1.setBounds(85, 121, 190, 20);
		panel_1.add(pathDes1);
		pathDes1.setColumns(10);
		
		JButton btnDecryptFolder_1 = new JButton("Decrypt Folder");
		btnDecryptFolder_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desAes = new File("C:\\DescryptionAES");
				if (!desAes.exists()) {
		            if (desAes.mkdir()) {
		                System.out.println("Directory is created!");
		            } else {
		                System.out.println("Failed to create directory!");
		            }
		            String pdes = desAes.getAbsolutePath();
		            pathDes1.setText(pdes);
		        }
		        else {
		        	System.out.println("File exist!");
		        }
			}
		});
		btnDecryptFolder_1.setBounds(295, 120, 124, 23);
		panel_1.add(btnDecryptFolder_1);
		
		pathKey1 = new JTextField();
		pathKey1.setColumns(10);
		pathKey1.setBounds(85, 87, 190, 20);
		panel_1.add(pathKey1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("DES", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Input");
		lblNewLabel_5.setForeground(new Color(0, 0, 139));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 61, 46, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Key");
		lblNewLabel_6.setForeground(new Color(0, 0, 139));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 92, 46, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Res Path");
		lblNewLabel_7.setForeground(new Color(0, 0, 139));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 160, 63, 14);
		panel_2.add(lblNewLabel_7);
		
		pathFolder2 = new JTextField();
		pathFolder2.setBounds(85, 58, 187, 20);
		panel_2.add(pathFolder2);
		pathFolder2.setColumns(10);
		
		pathResult2 = new JTextField();
		pathResult2.setBounds(85, 157, 187, 20);
		panel_2.add(pathResult2);
		pathResult2.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Choose Folder");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser(); 
				 chooser.setCurrentDirectory(new java.io.File("."));
				 chooser.setDialogTitle(choosertitle);
				 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 chooser.setAcceptAllFileFilterUsed(false);
				 if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
				   File dir = chooser.getSelectedFile();
				   directory = dir.listFiles();
				   paths = dir.list();
				   String path = "" + chooser.getSelectedFile();
				   pathFolder2.setText(path);
				 }
				 else {
				   System.out.println("No Selection ");
				 }
			}
		});
		btnNewButton_6.setBounds(296, 57, 123, 23);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Choose Key");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				  chooser.showOpenDialog(null);
			      File f = chooser.getSelectedFile();
			      String filename = f.getAbsolutePath();
			      pathKey2.setText(filename);
			}
		});
		btnNewButton_7.setBounds(296, 88, 123, 23);
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Result Folder");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resDes = new File("C:\\ResultDES");
				if (!resDes.exists()) {
		            if (resDes.mkdir()) {
		                System.out.println("Directory is created!");
		            } else {
		                System.out.println("Failed to create directory!");
		            }
		            String pdes = resDes.getAbsolutePath();
		            pathResult2.setText(pdes);
		        }
		        else {
		        	System.out.println("File exist!");
		        }
			}
		});
		btnNewButton_8.setBounds(296, 156, 123, 23);
		panel_2.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("ENCRYPTION");
		btnNewButton_9.setForeground(new Color(255, 250, 250));
		btnNewButton_9.setBackground(new Color(107, 142, 35));
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DES_KEY_FILE = pathKey2.getText();
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

				for(int i = 0; i < directory.length; i++){
					File inputFile = new File(directory[i].getAbsolutePath());
					String filename = inputFile.getName();
					File encryptedFile = new File(desDes + "\\" +filename);
					DES.encrypt(inputFile,encryptedFile,secretKey);
				}
				JOptionPane.showMessageDialog(frame, "Encryption Sucess");
			
			}
		});
		btnNewButton_9.setBounds(10, 199, 123, 23);
		panel_2.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("DECRYPTION");
		btnNewButton_10.setForeground(new Color(0, 0, 139));
		btnNewButton_10.setBackground(new Color(192, 192, 192));
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectInputStream inputStream = null;
				String DES_KEY_FILE=pathKey2.getText();
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
				
		        for(int i = 0; i < directory.length; i++){
					File inputFile = new File(directory[i].getAbsolutePath());
					String filename = inputFile.getName();
					File encryptedFile = new File(resDes + "\\" +filename);
					DES.decrypt(inputFile,encryptedFile,secretKey);
		        }
		        JOptionPane.showMessageDialog(frame, "Decryption Sucess");
			}
			
		});
		btnNewButton_10.setBounds(154, 199, 118, 23);
		panel_2.add(btnNewButton_10);
		
		JButton btnBack_1 = new JButton("BACK");
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack_1.setBackground(new Color(244, 164, 96));
		btnBack_1.setForeground(new Color(0, 0, 139));
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				home h = new home();
				h.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        h.setLocationRelativeTo(null);
		        h.setVisible(true);
			}
		});
		btnBack_1.setBounds(296, 199, 123, 23);
		panel_2.add(btnBack_1);
		
		JLabel lblDesPath_1 = new JLabel("Des Path");
		lblDesPath_1.setForeground(new Color(0, 0, 139));
		lblDesPath_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesPath_1.setBounds(10, 126, 63, 14);
		panel_2.add(lblDesPath_1);
		
		pathDes2 = new JTextField();
		pathDes2.setBounds(85, 123, 187, 20);
		panel_2.add(pathDes2);
		pathDes2.setColumns(10);
		
		JButton btnDescryptFolder = new JButton("Descrypt Folder");
		btnDescryptFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desDes = new File("C:\\DescryptionDES");
				if (!desDes.exists()) {
		            if (desDes.mkdir()) {
		                System.out.println("Directory is created!");
		            } else {
		                System.out.println("Failed to create directory!");
		            }
		            String pdes = desDes.getAbsolutePath();
		            pathDes2.setText(pdes);
		        }
		        else {
		        	System.out.println("File exist!");
		        }
			}
		});
		btnDescryptFolder.setBounds(296, 122, 123, 23);
		panel_2.add(btnDescryptFolder);
		
		pathKey2 = new JTextField();
		pathKey2.setColumns(10);
		pathKey2.setBounds(85, 89, 187, 20);
		panel_2.add(pathKey2);
		
		JLabel lblDesAlgorithm = new JLabel("DES ALGORITHM");
		lblDesAlgorithm.setForeground(new Color(0, 100, 0));
		lblDesAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDesAlgorithm.setBounds(130, 11, 187, 36);
		panel_2.add(lblDesAlgorithm);
	}
}
