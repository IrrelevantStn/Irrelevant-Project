import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Encrypt
{
    public String hashPrep(Object objectToHash){
        return hashingFunction(objectToHash.toString());
    }

    private String hashingFunction(String stringToHash){
        String generatedHash = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(stringToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //Conversion to Hex
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedHash = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedHash;
    }
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom secure = SecureRandom.getInstance("SHA1PRNG");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        secure.nextBytes(salt);
        return salt;
    }
}

