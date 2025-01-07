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
    public static void removeWord(String fileName, String wordToRemove) throws IOException {
        File file = new File(fileName);
    
        Scanner scanner = new Scanner(file);
        StringBuilder modifiedContent = new StringBuilder();
    
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.equals(wordToRemove)) {
                    modifiedContent.append(word).append(" ");
                }
            }
            modifiedContent.append("\n");
        }
    
        scanner.close();
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(modifiedContent.toString().trim());
        }
    
        System.out.println("Word '" + wordToRemove + "' removed successfully.");
    }
    
    public static void clearFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(""); // Write an empty string to clear the file
        }
    }
    
}

