import java.util.Date;

/**
 * Created by mat on 30/11/16.
 */
public class TextMessage extends Message{
    private String contentText;

    protected TextMessage(String destination, String source, Date timestamp, String contentText) {
        super(destination, source, timestamp);
        textFormatting(contentText);
    }

    protected void textFormatting(String contentText) {
        this.contentText = contentText;
    }

    public String getContentText() {
        return contentText;
    }
}
