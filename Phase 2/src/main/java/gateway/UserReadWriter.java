package gateway;

import java.io.*;


public class UserReadWriter implements ReadWriter {

    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param users    stores the list of users to be serialized
     */
    @Override
    public void saveToFile(String filePath, Object users) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(users);
        output.close();
    }
}
