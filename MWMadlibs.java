// Mae Wolf
// Class: CS & 141
// Date: 02/15/2023
// Lab 5: Madlibs

import java.io.*;
import java.util.*;

public class MWMadlibs {
   public static void main(String []args) throws FileNotFoundException {    
   
      System.out.println("Welcome to the game of Mad Libs!");
      System.out.println("I will ask you to provide various words ");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      
      Scanner input = new Scanner(System.in);
      boolean promptAgain = true;
      char menuSelection;
      while(promptAgain == true){
         System.out.println("(C)reate mad-lib, (V)iew mad-lib, (Q)uit ");
         menuSelection = input.next().charAt(0);
       
         if (menuSelection == 'C' || menuSelection == 'c') {
            createMadlib();  
         }
         else if (menuSelection == 'V' || menuSelection == 'v') {
            viewMadlib();
         }
         else if (menuSelection == 'Q' || menuSelection == 'q') {
            promptAgain = false;
         }
         else {
            System.out.println("That is not a valid entry.");
         
         }
      }//end of while 
   }//end main
   
   
   public static void createMadlib() throws FileNotFoundException {
      Scanner input = new Scanner(System.in);
      
      System.out.println("input file name: ");
      String fileName = input.nextLine();
      Scanner fileScanner = new Scanner(new File(fileName));
       
      
      System.out.println("output file name: ");
   
      String outputName = input.next();
      PrintStream output = new PrintStream(new File(outputName));
           
      while (fileScanner.hasNextLine()) {
         
         String nextLine = fileScanner.nextLine();
         Scanner line = new Scanner(nextLine);
         
         while (line.hasNext()) {
            String word = line.next();
            if (word.startsWith("<")) {
               word = word.replace("<","");
               word = word.replace(">","");
               System.out.println("Please type" + vowels(word) + word + ": ");
               word = input.next();
               output.print(word + " ");
            }
            else {
            
               output.print(word + " ");
            }
         }
      
      }//end of while
      System.out.println("Your madlib has been created!");
   }//end of createMadlib
   
   public static void viewMadlib() throws FileNotFoundException {
      Scanner input = new Scanner(System.in);
   
      System.out.println("Which file would you like to view?");
      String fileName = input.nextLine();
      Scanner fileScanner = new Scanner(new File(fileName));  
   
      while (fileScanner.hasNextLine()) {
      
         System.out.println(fileScanner.nextLine());
      
      }//end while
   }//end of viewMadlib
   
   public static String vowels (String word) {
      char firstLetter = word.charAt(0);
      String a;
      
      if(firstLetter == 'a' || firstLetter == 'A' ||  firstLetter == 'e'|| firstLetter == 'E' 
         || firstLetter == 'i' || firstLetter == 'I' ||firstLetter == 'o' || 
         firstLetter == 'O' || firstLetter == 'u' || firstLetter == 'U') {
         
         a = " an ";
      }
      else { 
         a = " a ";
      }
      
      return a;
        
   }//end of vowels
        
}//end class
