package download;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by misterti.me on 5/27/2014.
 */
public class Verifier {
    /**
     *
     * @param fileToVerify The file to be verified
     * @param checksum The SHA1 checksum from the XML
     * @return true if checksum matches SHA1 of fileToVerify
     * @throws IOException because there's a file
     */
    public static boolean verifyFile(File fileToVerify, String checksum) throws IOException {
//        MessageDigest SHA1 = MessageDigest.getInstance("SHA1");
//        FileInputStream fis = new FileInputStream(fileToVerify);
//
//        byte[] data = new byte[1024];
//        int read = 0;
//        while ((read = fis.read(data)) != -1) {
//            SHA1.update(data, 0, read);
//        }
//        byte[] hashBytes = SHA1.digest();
//
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < hashBytes.length; i++) {
//            sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
//        }
//
//        String fileHash = sb.toString();
//
//        return fileHash.equals(checksum);

        FileInputStream fis = new FileInputStream(fileToVerify);
        String hash = org.apache.commons.codec.digest.DigestUtils.shaHex(fis);
        System.out.println("[Verifier] Expected hash " + checksum + " and got hash " + hash);
        return hash.equals(checksum);
    }
}
