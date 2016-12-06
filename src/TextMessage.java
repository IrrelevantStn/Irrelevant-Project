import java.util.Date;

/**
 * Created by mat on 30/11/16.
 */
public class TextMessage extends Message{
    protected TextMessage(String destination, String source, Date timestamp, String contentText) {
        super(destination, source, timestamp);
        textFormatting(contentText);
    }

    public String getContentText() {
        return m_contentText;
    }

    protected void textFormatting(String contentText) {
        this.m_contentText = contentText;
    }

    private String m_contentText;
}
