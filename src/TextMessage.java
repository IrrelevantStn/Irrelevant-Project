import java.util.Date;
/**
 * Class to construct a Message with a text body, calling superclasses
 * to add additional properties of the message
 * @author Mathew Estienne
 */
public class TextMessage extends Message{
    protected TextMessage(String destination, String source, Date timestamp,
                          String contentText) {
        super(destination, source, timestamp);
        textFormatting(contentText);
    }

    /**
     * Returns the text body of the message
     * @return String
     */
    public String getContentText() {
        return m_contentText;
    }

    /**
     * Truncates the message body to a specified length, m_MESSAGE_LENGTH
     * @param contentText submitted text by the user, to be
     *        truncated
     * @return m_contentText the truncated text body of the
     *        message
     */
    protected void textFormatting(String contentText) {
        this.m_contentText = contentText.substring(0, Math.min(contentText
                        .length(), m_MESSAGE_LENGTH));
    }

    private String m_contentText;
    final int m_MESSAGE_LENGTH = 250;
}
