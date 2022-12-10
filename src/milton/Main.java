package src.milton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];

        System.out.printf("Processing %s\n", fileName);

        // Open the file
        // Read the first 100 lines and print out each line
        // Close the file when done
        // If the file is less than 100 lines, close when done

        // try {
        //     FileReader fr = new FileReader(fileName);
        //     BufferedReader br = new BufferedReader(fr);
        //     Integer i = 0;
        //     do {
        //         String line = br.readLine();
        //         System.out.printf("%d: %s\n", i, line.toUpperCase());
        //         i++;
        //     }while (br.readLine() != null && i < 100);
        //     br.close();
        //     fr.close();
        //   } catch (FileNotFoundException e) {
        //     System.out.println("An error occurred.");
        //     e.printStackTrace();
        //   }

        // Count number of words in first 100 lines
        // try {
        //   FileReader fr = new FileReader(fileName);
        //   BufferedReader br = new BufferedReader(fr);
        //   Integer words = 0;
        //   for (Integer i = 0; i < 100; i++) {
        //       String line = br.readLine();
        //       words += wordsCounter(line);
        //   }
        //   System.out.printf("The number of words in first 100 lines: %d\n", words);
        //   br.close();
        //   fr.close();
        // } catch (FileNotFoundException e) {
        //   System.out.println("An error occurred.");
        //   e.printStackTrace();
        // }
        // 

        // Map with word as key and counter as value, whenever new word found increment counter else create a new key with word as key increment counter
        Map<String, String[]> bookList = new HashMap<>();  
        
        String publisher;
        String line;
        String[] bookArray;
        BufferedReader br = new BufferedReader(new FileReader("books.csv"));
        
        while((line = br.readLine()) != null){
            bookArray = line.split(",");
            publisher = bookArray[bookArray.length - 1];
            System.out.println(publisher);  
            //bookList.put(publisher, bookArray);
            //System.out.println(bookList.put(publisher, bookArray));
          }
          Set<String> uniqueWords = bookList.keySet();

          System.out.println("Sorted by Publisher:");
          File csvFile = new File("sortedPublisher.csv");
          FileWriter fileWriter = new FileWriter(csvFile);
          
          fileWriter.write("publisher " + "bookID " + "title " + "authors " + "average_rating " + "isbn " + "isbn13 " + "language_code " + " num_pages " + "ratings_count " + "text_reviews_count " + "publication_date " + "\n");
          
          for (String w: uniqueWords){
             //System.out.printf("> %s: %d\n", w, map.get(w));
            StringBuilder lineToWrite = new StringBuilder();

            for (int i = 0; i < bookList.get(uniqueWords).length; i++) {
              lineToWrite.append(w + " " + bookList.get(w)[i] + "\n");
              fileWriter.write(lineToWrite.toString());
              System.out.println(lineToWrite);
            }
             
           }
           fileWriter.close();
           br.close();

            // while (sc.hasNext()) {   //returns a boolean value                
            //   String[] tokens = sc.next().split(String.valueOf(","));        
            //   for (int i = 0; i < tokens.length; i++){
            //     System.out.println(tokens[i]);
            //   }
              //System.out.println(tokens);
              //publisher = tokens[tokens.length];
              //System.out.println(publisher);
              
              //System.out.print(sc.next());  //find and returns the next complete token from this scanner  
            }   
            //sc.close();  //closes the scanner    
            
          //Set<String> uniqueWords = bookList.keySet();

          //   System.out.printf("Number of unique words: %d\n", uniqueWords.size());
          //   File csvFile = new File("result.csv");
          //   FileWriter fileWriter = new FileWriter(csvFile);
          
          //   fileWriter.write("Number of unique words: " + uniqueWords.size() + "\n");
          //   fileWriter.write("Word, Count\n");
          //   for (String w: uniqueWords){
          //     System.out.printf("> %s: %d\n", w, bookList.get(w));
          //     StringBuilder lineToWrite = new StringBuilder();
          //     lineToWrite.append(w + " " + bookList.get(w) + "\n");
          //     fileWriter.write(lineToWrite.toString());
          //   }
          //   fileWriter.close();
          //   br.close();
          //   fr.close();
          // } catch (FileNotFoundException e) {
          //   System.out.println("An error occurred.");
          //   e.printStackTrace();
          //}
        }

        // private static int wordsCounter(String line) {
        //   int count = line.trim().split(" ").length;
        //   return count;
        // }

        /*
        In Main
        public static final String HEADER = "Word,Count";
        // Create CSV file
        FileOutputStream fos = new FileOutputStream(args[1]);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write(HEADER);

        for (String w : map.KeySet()) {
          String lineWrite = String.format("%s, %d\n", w, map.get(w));
          osw.write(lineWrite);
        }

        osw.flush();
        osw.close();
        fos.close();
        */
    