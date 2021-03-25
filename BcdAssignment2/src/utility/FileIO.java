package utility;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileIO {
    public static void write(String filename, String data) {
        data += System.lineSeparator();
        try {
            File f = new File(filename);
            f.createNewFile(); //do nothing if already exist.
            Files.write(Paths.get(filename), data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> read(String filename) {
            try {
                File f = new File(filename);
                f.createNewFile(); //do nothing if already exist.
                return Files.readAllLines(Paths.get(filename));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } 
    }
}
