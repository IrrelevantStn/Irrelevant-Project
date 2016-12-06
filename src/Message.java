import java.util.Date;

/**
 * Created by mat on 29/11/16.
 */
public abstract class Message {
    private String m_destination;
    private String m_source;
    private Date m_timestamp;

    protected Message(String destination, String source, Date timestamp){
        this.m_destination = destination;
        this.m_source = source;
        this.m_timestamp = timestamp;

    }
    protected abstract void textFormatting(String text);

    public String getDestination() {
        return m_destination;
    }

    public String getSource() {
        return m_source;
    }

    public Date getTimestamp() {
        return m_timestamp;
    }

}
