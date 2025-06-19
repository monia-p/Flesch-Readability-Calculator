//Tester class to test FleshReadability class
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
	  
	  //Prompt user to type text
	  System.out.println("Type your text: ");
      String userInput = scanner.nextLine();

	  testFleshReadability(userInput);
	
	  //Paste text
	  String test1 = "A path from a point approximately 330 metres east of the most south westerly corner of 17 Batherton Close, Widnes and approximately 208 metres east-south-east" + 
	  " of the most southerly corner of Unit 3 Foundry Industrial Estate, Victoria Street, Widnes, proceeding in a generally east-north-easterly direction for approximately 28 metres" + 
	  " to a point approximately 202 metres east-south-east of the most south-easterly corner of Unit 4 Foundry Industrial Estate, Victoria Street, and approximately 347 metres east" + 
	  " of the most south-easterly corner of 17 Batherton Close.";
      
	  testFleshReadability(test1);
	  scanner.close();
    }  
	  
	  // Method to test Flesch Readability
    public static void testFleshReadability(String text) {
        System.out.println("Results for text: \n" + text);
        int wordCount = FleshReadability.countWords(text);
        int syllableCount = FleshReadability.countSyllables(text);
        int sentenceCount = FleshReadability.countSentences(text);
        double fleshIndex = FleshReadability.calculateFleshIndex(wordCount, syllableCount, sentenceCount);

        // Output the results for this test
        System.out.printf("\nWords = %d, Sentences = %d, Syllables = %d.\n", wordCount, sentenceCount, syllableCount);
        System.out.printf("Flesch Readability Index = %.6f\n", fleshIndex);
        System.out.println(" ");
    }
   
   
   }

