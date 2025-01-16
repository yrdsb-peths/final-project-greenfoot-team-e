import java.io.FileWriter;
import java.io.IOException;

public class FileUpdater {
    public static void addWordToFile(String fileName, String wordToAdd) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(wordToAdd + "\n");
        } catch (IOException e) {
        }
    }
}
