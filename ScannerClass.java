import greenfoot.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerClass extends Actor {
    List<String> wordList = new ArrayList<>();
    private String txtFile;

    public ScannerClass(String txtFile) {
        this.txtFile = txtFile;
        loadWords();
    }

    private void loadWords() {
        try (Scanner scan = new Scanner(new File(txtFile))) {
            while (scan.hasNextLine()) {
                wordList.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + txtFile);
        }
    }

    public void addWord(String word) {
        wordList.add(word);
        FileUpdater.addWordToFile(txtFile, word);
    }

    public List<String> getWordList() {
        return new ArrayList<>(wordList); // Return a copy to prevent external modification
    }
}
