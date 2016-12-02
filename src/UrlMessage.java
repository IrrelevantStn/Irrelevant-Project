/**
 * Created by mat on 02/12/16.
 */
public class UrlMessage extends PathMessage{
    private String webAddress;

    public UrlMessage(String destination, String source, int timestamp, String contentDescription, String webAddress) {
        super(destination, source, timestamp, contentDescription);
        this.webAddress = webAddress;
    }

    public String getWebAddress() {
        return webAddress;
    }
}
