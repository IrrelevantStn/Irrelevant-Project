import java.util.Date;

public class TextMessage extends Message{
    protected TextMessage(String destination, String source, Date timestamp,
                          String contentText) {
        super(destination, source, timestamp);
        textFormatting(contentText);
    }

    public String getContentText() {
        return m_contentText;
    }

    protected void textFormatting(String contentText) {
        this.m_contentText = contentText.substring(0, Math.min(contentText
                        .length(), 250));
    }

    private String m_contentText;
}
