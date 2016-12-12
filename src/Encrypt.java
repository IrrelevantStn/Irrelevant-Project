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
            System.out.println("md created: " + md.toString());
            //Hash and get Hashed Bytes
            byte[] hashBytes = md.digest(passwordToHash.getBytes());
            md.update(salt);
            System.out.println("md created and salted: " + md.toString());
            System.out.println("hashBytes: " + hashBytes.toString());
            generatedHash = new BigInteger(1, md.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        System.out.println("generatedHash: " + generatedHash);
        return generatedHash;
    }

    public static String hashPrep(Object objectToHash) throws NoSuchAlgorithmException, NoSuchProviderException{
        return hashString(objectToHash.toString(), getSalt());
    }

    public static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        System.out.println("Salt: "+salt);
        //return salt
        return salt;
    }
}