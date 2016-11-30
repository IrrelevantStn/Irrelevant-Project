/**
 * Created by mat on 30/11/16.
 */
public class TextMessage extends Message{
    private String contentText;

    public TextMessage(String destination, String source, int timestamp, String contentText) {
        super(destination, source, timestamp);
        textFormatting(contentText);
    }

    private void textFormatting(String contentText) {
        this.contentText = contentText;
    }
    private TextMessage sendMessage(){
        return true;
    }
}
