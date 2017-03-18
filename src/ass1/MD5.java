package ass1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

public class MD5 {
	public static void hasing(File inputFile, File outputFile){
        try{
        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream inputStream = new FileInputStream(inputFile);
        ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream(outputFile));
        byte[] dataBytes = new byte[1024];

        int nread = 0;
        while ((nread = inputStream.read(dataBytes)) != -1) {
          md.update(dataBytes, 0, nread);
        };
        byte[] mdbytes = md.digest();
        
        //convert the byte to hex format
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<mdbytes.length;i++) {
    		String hex=Integer.toHexString(0xff & mdbytes[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    
        
        outputStream.writeObject(hexString);
        outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public static boolean check(File inputFile1, File inputFile2){
        boolean flag=true;
        try{
            ObjectInputStream inputStream = null;
            inputStream = new ObjectInputStream(new FileInputStream(inputFile1));
            StringBuffer input1=(StringBuffer)inputStream.readObject();
            inputStream = new ObjectInputStream(new FileInputStream(inputFile2));
            StringBuffer input2=(StringBuffer)inputStream.readObject();
//            System.out.println("Digest(in hex format):: " + input1.toString());
//            System.out.println("Digest(in hex format):: " + input2.toString());
            flag = input1.toString().equals(input2.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

}
