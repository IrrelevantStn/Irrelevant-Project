import java.util.Date;

/**
 * Created by mat on 02/12/16.
 */
public abstract class PathMessage extends Message{
    protected PathMessage(String destination, String source, Date timestamp, String contentDescription) {
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
