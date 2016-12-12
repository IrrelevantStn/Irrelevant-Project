import java.text.SimpleDateFormat;
import java.util.Date;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Class to model a Profile of a user
 * @author ryanx
 *
 */
public class Profile {
    //First Generation of Profile
	/**
	 * The constructor of the class
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param telephone
	 * @param birthday
	 * @param city
	 * @param lastLogin
	 * @param profImg
	 */
	public Profile(String userName, String password, String firstName, String lastName, String telephone, Date birthday,String city, Date lastLogin, String profImg) {

        this.m_profileId = m_counter++;
		this.m_userName = userName;
		this.m_password = password;
        try{
            this.m_salt = Encrypt.getSalt();
        } catch(NoSuchProviderException | NoSuchAlgorithmException e){
            System.out.println("Could not get Salt, check Encrypt.java");
        }
		this.m_firstName = firstName;
		this.m_lastName = lastName;
		this.m_telephone = telephone;
		this.m_birthday = birthday;
		this.m_city = city;
		this.m_lastLogin = new Date();
		this.m_profImg = profImg;
	}
    //Reconstruction of existing Profile (Pregenerated Salt)
	
	/**
	 * Constructor of the class
	 * @param userName
	 * @param password
	 * @param salt
	 * @param firstName
	 * @param lastName
	 * @param telephone
	 * @param birthday
	 * @param city
	 * @param lastLogin
	 * @param profImg
	 */
    public Profile(String userName, String password, byte[] salt, String firstName, String lastName, String telephone, Date birthday,String city, Date lastLogin, String profImg) {

        this.m_profileId = m_counter++;
        this.m_userName = userName;
        this.m_password = password;
        this.m_salt = salt;
        this.m_firstName = firstName;
        this.m_lastName = lastName;
        this.m_telephone = telephone;
        this.m_birthday = birthday;
        this.m_city = city;
        this.m_lastLogin = new Date();
        this.m_profImg = profImg;
    }

    /**
     * Gets the profile id
     * @return id
     */
    public int getProfileID() {
        return m_profileId;
    }

    /**
     * Gets the username
     * @return username
     */
	public String getUserName() {
		return m_userName;
	}

	/**
	 * Gets the password
	 * @return password
	 */
	public String getPassword() {
		return m_password;
	}

	/**
	 * Sets the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.m_password = password;
	}

	/**
	 * Gets the salt
	 * @return
	 */
	public byte[] getSalt() {
		return m_salt;
	}

	/**
	 * Sets the salt
	 * @param salt
	 */
	public void setSalt(byte[] salt) {
		this.m_salt = salt;
	}

	/**
	 * Gets the first name
	 * @return
	 */
	public String getFirstName() {
		return m_firstName;
	}

	/**
	 * Sets the first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.m_firstName = firstName;
	}

	/**
	 * Gets the last name
	 * @return
	 */
	public String getLastName() {
		return m_lastName;
	}

	/**
	 * Sets the last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.m_lastName = lastName;
	}

	/**
	 * Gets the telephone number
	 * @return
	 */
	public String getTelephone() {
		return m_telephone;
	}

	/**
	 * Sets the telephone number
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.m_telephone = telephone;
	}

	/**
	 * Gets the birthday
	 * @return
	 */
	public Date getBirthday() {
		return m_birthday;
	}

	/**
	 * Sets the birthday
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.m_birthday = birthday;
	}

	/**
	 * Gets the city
	 * @return
	 */
	public String getCity() {
		return m_city;
	}

	/**
	 * Sets the city
	 * @param city
	 */
	public void setCity(String city) {
		this.m_city = city;
	}

	/**
	 * Gets the last login
	 * @return
	 */
	public Date getLastLogin() {
		return m_lastLogin;
	}

	/**
	 * Sets the last login
	 * @param lastLogin
	 */
	public void setLastLogin(Date lastLogin) {
		this.m_lastLogin = lastLogin;
	}

	/**
	 * Gets the profile image
	 * @return
	 */
	public String getProfImg() {
		return m_profImg;
	}

	/**
	 * Sets the profile image
	 * @param profImg
	 */
	public void setProfImg(String profImg) {
		this.m_profImg = profImg;
	}

	/**
	 * Prints out summary of the class
	 */
	public String toString() {

		return "UserName: \t" + m_userName + "\r\n" + "First Name: \t" +
		        m_firstName + "\r\n" + "Last Name: \t" + m_lastName
				+ "\r\n" + "Telephone: \t" + m_telephone + "\r\n" + 
		        "Birthday: \t"+ new SimpleDateFormat("dd/MM/yyyy").format(
		        m_birthday) + "\r\n" + "City: \t" + m_city + "\r\n"
				+ "Last Login: \t" + new SimpleDateFormat("dd/MM/yyyy").format(
						m_lastLogin) + "\r\n";
	}

	private String m_userName;
	private String m_password;
	private byte[] m_salt;
	private String m_firstName;
	private String m_lastName;
	private String m_telephone;
	private Date m_birthday;
	private String m_city;
	private Date m_lastLogin;
	private String m_profImg;
    public final int m_profileId;
    private static int m_counter = 0;

}