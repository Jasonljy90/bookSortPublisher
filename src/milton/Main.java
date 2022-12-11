package src.milton;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        // Map with word as key and counter as value, whenever new word found increment counter else create a new key with word as key increment counter
        Map<String, ArrayList<String>> bookList = new HashMap<>();  
        
        String publisher;
        String line;
        String[] bookArray;
        
        BufferedReader br = new BufferedReader(new FileReader("books.csv"));
        
        while((line = br.readLine()) != null){
            bookArray = line.split(",");
            publisher = bookArray[bookArray.length - 1];
            publisher = publisher.replace('/', ' ');
            
            if (bookList.containsKey(publisher)){
              ArrayList<String> bookInfo = new ArrayList<String>();
              bookInfo = bookList.get(publisher);
              bookInfo.add(line);
              bookList.put(publisher, bookInfo);
              }else{
                ArrayList<String> bookInfo = new ArrayList<String>();
                bookInfo.add(line);
                bookList.put(publisher, bookInfo);
              }
          }
          br.close();
          //System.out.println(bookList.get("Crown")); // can get sorted books
          //System.out.println(bookList.get("Scholastic Inc."));
          ArrayList<String> readFile;
          for (Map.Entry<String,ArrayList<String>> entry : bookList.entrySet()) {
            // Create CSV file
            FileOutputStream fos = new FileOutputStream(entry.getKey() + ".csv");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write("bookID " + "title " + "authors " + "average_rating " + "isbn " + "isbn13 " + "language_code " + " num_pages " + "ratings_count " + "text_reviews_count " + "publication_date " + "publisher\n");
            readFile = entry.getValue();
            String lineToWrite = "";

            for (int i = 0; i < readFile.size(); i++) {
              lineToWrite = lineToWrite + readFile.get(i) + "\n";
              //System.out.println(lineToWrite);  
            }
            osw.write(lineToWrite);
            osw.flush(); 
            osw.close();
            fos.close();
          }
    }
  }
