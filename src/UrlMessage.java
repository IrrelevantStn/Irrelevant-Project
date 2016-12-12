import java.util.Date;
/**
 * Class to construct a Message with a URL as the content, calling superclasses
 * to add additional properties of the message
 * @author Mathew Estienne
 */
public class UrlMessage extends PathMessage{
    public UrlMessage(String destination, String source, Date timestamp,
                      String contentDescription, String webAddress) {
        super(destination, source, timestamp, contentDescription);
        this.m_webAddress = webAddress;
    }
    /**
     * Returns the path to a remote webaddress, specified in the message
     * @return String
     */
    public String getWebAddress() {
        return m_webAddress;
    }

    private String m_webAddress;
}
