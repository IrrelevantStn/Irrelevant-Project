import java.util.Date;

/**
 * Created by mat on 02/12/16.
 */
public class FileMessage extends PathMessage {
    private String m_filePath;

    public FileMessage(String destination, String source, Date timestamp, String contentDescription, String filePath) {
        super(destination, source, timestamp, contentDescription);
        this.m_filePath = filePath;
    }

    public String getFilePath() {
        return m_filePath;
    }
}
