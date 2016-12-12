import java.util.Date;
/**
 * Inaccessible class, purely to construct additional attributes of a
 * message and forcing implementation of a concrete method elsewhere in the
 * hierarchy
 * @author Mathew Estienne
 */
public abstract class PathMessage extends Message{
    protected PathMessage(String destination, String source, Date timestamp,
                          String contentDescription) {
        super(destination, source, timestamp);
        textFormatting(contentDescription);
    }

    /**
     * Returns the text description
     * @return String
     */
    public String getContentDescription() {
        return m_contentDescription;
    }

    /**
     * Truncates a description to a specified length, m_MESSAGE_LENGTH
     * @param contentDescription submitted description by the user, to be
     *        truncated
     * @return m_contentDescription the truncated text description of the
     *        message
     */
    protected void textFormatting(String contentDescription) {
        this.m_contentDescription = contentDescription.substring(0, Math.min
                (contentDescription.length(), m_MESSAGE_LENGTH));
    }

    private String m_contentDescription;
    final int m_MESSAGE_LENGTH = 50;
}
