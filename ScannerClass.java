import greenfoot.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public void loadWords() {
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
    public static void removeWords(String fileName, List<String> wordsToRemove) throws IOException {
        File file = new File(fileName);

        Scanner scanner = new Scanner(file);
        StringBuilder modifiedContent = new StringBuilder();
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!wordsToRemove.contains(word)) {
                    modifiedContent.append(word).append(" ");
                }
            }
            modifiedContent.append("\n");
        }

        scanner.close();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(modifiedContent.toString());
        }

        System.out.println("Words removed successfully.");
    }
}

