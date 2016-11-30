/**
 * Created by mat on 29/11/16.
 */
public abstract class Message {
    private String destination;
    private String source;
    private int timestamp;

    public Message(String destination, String source, int timestamp){
        this.destination = destination;
        this.source = destination;
        this.timestamp = timestamp;

    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public int getTimestamp() {
        return timestamp;
    }

    abstract void textFormatting();

    abstract void sendMessage();
}
