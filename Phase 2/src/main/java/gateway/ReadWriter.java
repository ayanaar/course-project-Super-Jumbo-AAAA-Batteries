package gateway;
import java.io.IOException;


public interface ReadWriter {

    /**
     * @param filePath location of ser file
     * @param users object to be serialized
     */
    void saveToFile(String filePath, Object users) throws IOException;
}
