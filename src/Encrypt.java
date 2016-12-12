import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.math.BigInteger;

public class Encrypt
{
    public static String hashString(String passwordToHash, byte[] salt){
        String generatedHash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.digest(passwordToHash.getBytes());
            md.update(salt);
            generatedHash = new BigInteger(1, md.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedHash;
    }

    public static String hashPrep(Object objectToHash) throws NoSuchAlgorithmException, NoSuchProviderException{
        return hashString(objectToHash.toString(), getSalt());
    }

    public static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}