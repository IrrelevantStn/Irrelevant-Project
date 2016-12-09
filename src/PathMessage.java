import java.util.Date;

public abstract class PathMessage extends Message{
    protected PathMessage(String destination, String source, Date timestamp,
                          String contentDescription) {
        super(destination, source, timestamp);
        textFormatting(contentDescription);
    }

    public String getContentDescription() {
        return m_contentDescription;
    }

    protected void textFormatting(String contentDescription) {
        this.m_contentDescription = contentDescription;
    }

    private String m_contentDescription;

}
