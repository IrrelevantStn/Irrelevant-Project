
import java.text.SimpleDateFormat;
import java.util.Date;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Profile {

	public Profile(String userName, String password, String firstName, String lastName, String telephone, Date birthday,String city, Date lastLogin, String profImg) throws
			NoSuchAlgorithmException, NoSuchProviderException {

        this.m_profileId = m_counter++;
		this.m_userName = userName;
		this.m_password = password;
		this.m_salt = Encrypt.getSalt();
		this.m_firstName = firstName;
		this.m_lastName = lastName;
		this.m_telephone = telephone;
		this.m_birthday = birthday;
		this.m_city = city;
		this.m_lastLogin = new Date();
		this.m_profImg = profImg;

	}
    public int getProfileID() {
        return m_profileId;
    }

	public String getUserName() {
		return m_userName;
	}

	public String getPassword() {
		return m_password;
	}

	public void setPassword(String password) {
		this.m_password = password;
	}

	public byte[] getSalt() {
		return m_salt;
	}

	public void setSalt(byte[] salt) {
		this.m_salt = salt;
	}

	public String getFirstName() {
		return m_firstName;
	}

	public void setFirstName(String firstName) {
		this.m_firstName = firstName;
	}

	public String getLastName() {
		return m_lastName;
	}

	public void setLastName(String lastName) {
		this.m_lastName = lastName;
	}

	public String getTelephone() {
		return m_telephone;
	}

	public void setTelephone(String telephone) {
		this.m_telephone = telephone;
	}

	public Date getBirthday() {
		return m_birthday;
	}

	public void setBirthday(Date birthday) {
		this.m_birthday = birthday;
	}

	public String getCity() {
		return m_city;
	}

	public void setCity(String city) {
		this.m_city = city;
	}

	public Date getLastLogin() {
		return m_lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.m_lastLogin = lastLogin;
	}

	public String getProfImg() {
		return m_profImg;
	}

	public void setProfImg(String profImg) {
		this.m_profImg = profImg;
	}

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
