package ass1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

import javax.crypto.Cipher;

public class RSA {

	  public static final String ALGORITHM = "RSA";

	  public static void generateKey(String publickey_file,String privatekey_file) {
	    try {
	      final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
	      keyGen.initialize(1024);
	      final KeyPair key = keyGen.generateKeyPair();

	      File privateKeyFile = new File(privatekey_file);
	      File publicKeyFile = new File(publickey_file);

	      // Create files to store public and private key
	      if (privateKeyFile.getParentFile() != null) {
	        privateKeyFile.getParentFile().mkdirs();
	      }
	      privateKeyFile.createNewFile();

	      if (publicKeyFile.getParentFile() != null) {
	        publicKeyFile.getParentFile().mkdirs();
	      }
	      publicKeyFile.createNewFile();

	      // Saving the Public key in a file
	      ObjectOutputStream publicKeyOS = new ObjectOutputStream(
	          new FileOutputStream(publicKeyFile));
	      publicKeyOS.writeObject(key.getPublic());
	      publicKeyOS.close();

	      // Saving the Private key in a file
	      ObjectOutputStream privateKeyOS = new ObjectOutputStream(
	          new FileOutputStream(privateKeyFile));
	      privateKeyOS.writeObject(key.getPrivate());
	      privateKeyOS.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	  }


	  public static byte[] encrypt(PublicKey key,File inputFile, File outputFile) {
	    byte[] encryptBytes = null;
	    try {
	      // get an RSA cipher object and print the provider
	      final Cipher cipher = Cipher.getInstance(ALGORITHM);
	      // encrypt the plain text using the public key
	      cipher.init(Cipher.ENCRYPT_MODE, key);
	      
	      FileInputStream inputStream = new FileInputStream(inputFile);
	      byte[] inputBytes = new byte[(int) inputFile.length()];
	      inputStream.read(inputBytes);
	      FileOutputStream outputStream = new FileOutputStream(outputFile);
        
	      int len = (int) inputBytes.length;
	      for (int i = 0; i < len ; i=i+117){
        	byte[] newArray = null;
        	if(i+117>len)
        	{
        		newArray = Arrays.copyOfRange(inputBytes, i, len);
        		encryptBytes = cipher.doFinal(newArray);
        		outputStream.write(encryptBytes);
        	}
        	else
        	{
        		newArray = Arrays.copyOfRange(inputBytes, i, i +117);
          	    encryptBytes = cipher.doFinal(newArray);
          	    outputStream.write(encryptBytes);
        	}
	      }
        
	      outputStream.close();
	      inputStream.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return encryptBytes;
	  }

	  public static String decrypt( PrivateKey key,File inputFile, File outputFile) {
	    byte[] dectyptedText = null;
	    try {
	      // get an RSA cipher object and print the provider
	      final Cipher cipher = Cipher.getInstance(ALGORITHM);

	      // decrypt the text using the private key
	      cipher.init(Cipher.DECRYPT_MODE, key);
	      
	      FileInputStream inputStream = new FileInputStream(inputFile);
	      byte[] inputBytes = new byte[(int) inputFile.length()];
	      inputStream.read(inputBytes);
         
	      FileOutputStream outputStream = new FileOutputStream(outputFile);
	    
	      int len = (int) inputFile.length();
	      
	         for (int i = 0; i < len ; i=i+128){
	        	 byte[] newArray = null;
	        	 newArray = Arrays.copyOfRange(inputBytes, i, i +128);
	        	 dectyptedText = cipher.doFinal(newArray);
	        	 outputStream.write(dectyptedText);
	          }
	         
	      outputStream.close();      
	      inputStream.close();
	      
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }

	    return new String(dectyptedText);
	  }


}
