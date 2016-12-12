import java.util.Date;
/**
 * Root of the Message Hierarchy, Constructing the base attributes of any
 * message and forcing implementation of a concrete method elsewhere in the
 * hierarchy
 * @author Mathew Estienne
 */
public abstract class Message {
    protected Message(String destination, String source, Date timestamp){
        this.m_destination = destination;
        this.m_source = source;
        this.m_timestamp = timestamp;
    }

    /**
     * Returns the intended recipient of the message
     * @return String
     */
    public String getDestination() {
        return m_destination;
    }

    /**
     * Returns the sender of the message
     * @return String
     */
    public String getSource() {
        return m_source;
    }

    /**
     * Returns the time the message was sent
     * @return String
     */
    public Date getTimestamp() {
        return m_timestamp;
    }

    /**
     * Force character restrictions in the heirarchy
     * @see PathMessage for concrete implementation
     * @see TextMessage for concrete implementation
     */
    protected abstract void textFormatting(String text);

    private String m_destination;
    private String m_source;
    private Date m_timestamp;
}
