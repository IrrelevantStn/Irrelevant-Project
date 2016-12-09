import java.util.Date;

public class UrlMessage extends PathMessage{
    public UrlMessage(String destination, String source, Date timestamp,
                      String contentDescription, String webAddress) {
        super(destination, source, timestamp, contentDescription);
        this.m_webAddress = webAddress;
    }

    public String getWebAddress() {
        return m_webAddress;
    }

    private String m_webAddress;
}
