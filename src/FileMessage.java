import java.util.Date;

/**
 * Class to construct a Message with a file attachment, calling superclasses
 * to add additional properties of the message
 * @author Mathew Estienne
 */
public class FileMessage extends PathMessage {
    public FileMessage(String destination, String source, Date timestamp,
                       String contentDescription, String filePath) {
        super(destination, source, timestamp, contentDescription);
        this.m_filePath = filePath;
    }

    /**
     * Returns the path to a remote file, specified in the message
     * @return String
     */
    public String getFilePath() {
        return m_filePath;
    }

    private String m_filePath;
}
