package download;

import java.io.File;
import java.io.FileInputStream;
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
        StringBuffer hashBuffer = new StringBuffer();

//        TODO: Fix this. It's weird. The checksums aren't even the same length.
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] bytes = new byte[1024];

            int i = 0;
            while ((i = (new FileInputStream(fileToVerify)).read(bytes)) != -1) {
                md.update(bytes, 0, i);
            }

//            byte[] digestBytes = md.digest();
            for (int j = 0; j < md.digest().length; j++) {
                hashBuffer.append(Integer.toString((md.digest()[j] & 0xff) + 0x100, 16).substring(1));
            }

            System.out.println("[Verifier] Expected checksum " + checksum + " and got checksum " + hashBuffer.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Uh, no such algorithm. Did someone derp?");
            e.printStackTrace();
        }
        return hashBuffer.toString().equals(checksum);
    }
}
