import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import greenfoot.*;
import java.io.File;


public class Inventory extends Actor {
  public List<String> wordList = new ArrayList<>(); // List to store the words

    public Inventory() {
      loadWords(); // Load the words from the file
    }

  private void loadWords() {
    try {
      // Scanner to read from the file. The file has a different word on each line.
      Scanner scan = new Scanner(new File("Inventory.txt"));
      while (scan.hasNextLine()) {
        String word = scan.nextLine(); // Get the next line in the file
        wordList.add(word); // Add the word to the list
      }
      scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
  public void addWord(String word) {
    FileUpdater.addWordToFile("Inventory.txt", word);
    }   

}