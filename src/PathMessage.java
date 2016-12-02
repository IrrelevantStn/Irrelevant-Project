/**
 * Created by mat on 02/12/16.
 */
public abstract class PathMessage extends Message{
    private String contentDescription;

    protected PathMessage(String destination, String source, int timestamp, String contentDescription) {
        super(destination, source, timestamp);
        textFormatting(contentDescription);
    }

    protected void textFormatting(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getContentDescription() {
        return contentDescription;
    }

}
