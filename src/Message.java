import java.util.Date;

public abstract class Message {
    protected Message(String destination, String source, Date timestamp){
        this.m_destination = destination;
        this.m_source = source;
        this.m_timestamp = timestamp;

    }

    public String getDestination() {
        return m_destination;
    }

    public String getSource() {
        return m_source;
    }

    public Date getTimestamp() {
        return m_timestamp;
    }

    protected abstract void textFormatting(String text);

    private String m_destination;
    private String m_source;
    private Date m_timestamp;

}
