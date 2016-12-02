/**
 * Created by mat on 29/11/16.
 */
public abstract class Message {
    private String destination;
    private String source;
    private int timestamp;

    protected Message(String destination, String source, int timestamp){
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

    public int getTimestamp() {
        return timestamp;
    }

}
