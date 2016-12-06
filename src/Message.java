import java.util.Date;

/**
 * Created by mat on 29/11/16.
 */
public abstract class Message {
    private String destination;
    private String source;
    private Date timestamp;

    protected Message(String destination, String source, Date timestamp){
        this.destination = destination;
        this.source = destination;
        this.timestamp = timestamp;

    }
    protected abstract void textFormatting(String text);

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public Date getTimestamp() {
        return timestamp;
    }

}
