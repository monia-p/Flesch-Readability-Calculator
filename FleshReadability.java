import java.util.Scanner;

public class FleshReadability {

    public static double calculateFleshReadability(String text) {
        int wordCount = countWords(text);
        int syllableCount = countSyllables(text);
        int sentenceCount = countSentences(text);
        double fleshIndex = calculateFleshIndex(wordCount, syllableCount, sentenceCount);
        return fleshIndex; 
    }

    // Method to calculate Flesch Readability Index
    public static double calculateFleshIndex(int words, int syllables, int sentences) {
        // Use the Flesch Readability Index formula
        return 206.835 - 84.6 * ((double) syllables / words) - 1.015 * ((double) words / sentences);
    }

    // Method to count words
    public static int countWords(String text) {
        int words = 0;
        boolean prevCharWasALetter = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean charIsALetter = ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));

            // Adding new word when letter occurs after a non-letter character.
            if (charIsALetter) {
                if (!prevCharWasALetter) {
                    words++;
                }
            }
            prevCharWasALetter = charIsALetter;
        }
        return words;
    }

    // Method to count syllables
    public static int countSyllables(String text) {
        int syllables = 0;

        // Listing vowels as a string
        String vowels = "aeiouy";

        // Change text to lowercase and remove whitespace at the beginning and at the end of the string
        text = text.toLowerCase().trim();

        // Extract words from the text
        String[] words = text.split("\\s+");

        // Iterate through each word in the string
        for (String word : words) {
            // Remove all non letter-characters from the string to avoid counting puctuation as a letter.
            word = word.replaceAll("[^a-zA-Z]", ""); 

            // Introducting exception for common words with one syllable
            if (isException(word)) {
                syllables++; 
                continue;  
            }

            // Count syllables for the current word
            int wordSyllables = 0;
            boolean prevCharWasVowel = false;

          
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                boolean charIsVowel = vowels.indexOf(c) >= 0;

                // Add a new syllable when current element is a vowel and the previous element was not a vowel
                if (charIsVowel && !prevCharWasVowel) {
                    wordSyllables++;
                }

                prevCharWasVowel = charIsVowel;
            }

            // Reducing syllable count if "e" is at the end of the word
            if (word.length() > 1 && word.charAt(word.length() - 1) == 'e') {
                wordSyllables--;  
            }

            syllables += wordSyllables;
        }

        // Add at least one syllable per word
        return Math.max(syllables, 1);
    }

    // Checking for exception words
    private static boolean isException(String word) {
        String[] exceptions = {"the", "a", "an", "i", "to", "of", "and", "but", "or", "as", "in", "it", "close"};
        for (String exception : exceptions) {
            if (word.equals(exception)) {
                return true;
            }
        }
        return false;
    }

    // Method to count sentences
    public static int countSentences(String text) {
        int sentences = 0;
        String endOfSentence = ".:;!?";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (endOfSentence.indexOf(c) >= 0) {
                sentences++;
            }
        }

        return sentences;
    }
}

