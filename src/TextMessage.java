import java.util.Date;

/**
 * Created by mat on 30/11/16.
 */
public class TextMessage extends Message{
    private String m_contentText;

    protected TextMessage(String destination, String source, Date timestamp, String contentText) {
        super(destination, source, timestamp);
        textFormatting(contentText);
    }

    protected void textFormatting(String contentText) {
        this.m_contentText = contentText;
    }

    public String getContentText() {
        return m_contentText;
    }
}
