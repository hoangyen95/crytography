package ass1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DES {
	public static final String ALGORITHM = "DES/CBC/PKCS5Padding";
    private static String IV = "AAAAAAAA"; //64BIT 

    
    public static void generateKey(String keyFile) {
        try{
            SecretKey key= KeyGenerator.getInstance("DES").generateKey();
            File KeyFile = new File(keyFile);
            
            // Create files to store key
            KeyFile.createNewFile();
            
            // Saving the Public key in a file
            ObjectOutputStream ObjectKey = new ObjectOutputStream(new FileOutputStream(KeyFile));
            ObjectKey.writeObject(key);
            ObjectKey.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static byte[] encrypt(File inputFile, File outputFile, SecretKey key){
        byte[] encryptText = null;
        try {
          final Cipher cipher = Cipher.getInstance(ALGORITHM);
          cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes()));
          
          FileInputStream inputStream = new FileInputStream(inputFile);
          byte[] inputBytes = new byte[(int) inputFile.length()];
	      inputStream.read(inputBytes);
	      FileOutputStream outputStream = new FileOutputStream(outputFile);
          
          
          encryptText = cipher.doFinal(inputBytes);
          outputStream.write(encryptText);
          
          outputStream.close();
	      inputStream.close();
          
        } catch (Exception e) {
          e.printStackTrace();
        }
        
        return encryptText;
    }
    
    public static void decrypt(File inputFile, File outputFile, SecretKey key){
        byte[] decryptText = null;
        try {
          final Cipher cipher = Cipher.getInstance(ALGORITHM);
          cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes()));
          
          FileInputStream inputStream = new FileInputStream(inputFile);
          byte[] decryptBytes = new byte[((int) inputFile.length())];
          inputStream.read(decryptBytes);
          FileOutputStream outputStream = new FileOutputStream(outputFile);
          
          decryptText = cipher.doFinal(decryptBytes);
          outputStream.write(decryptText);
          outputStream.close();
	      inputStream.close();
          
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }
}
