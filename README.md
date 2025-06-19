# Flesch Readability Calculator

A Java application that analyzes text complexity using the Flesch Readability Index algorithm. This tool helps determine how easy or difficult a piece of text is to read, making it useful for educators, content creators, and publishers.

## Features

- **Flesch Readability Index Calculation**: Implements the standard formula: `206.835 - 84.6 * (syllables/words) - 1.015 * (words/sentences)`
- **Advanced Text Analysis**: Counts words, sentences, and syllables with high accuracy
- **Smart Syllable Detection**: Custom algorithm with vowel pattern recognition and exception handling
- **Edge Case Handling**: Manages silent 'e', common one-syllable words, and punctuation
- **Interactive Testing**: Command-line interface for user input and predefined test cases

## How It Works

### Readability Score Interpretation
- **90-100**: Very Easy (5th grade level)
- **80-89**: Easy (6th grade level)
- **70-79**: Fairly Easy (7th grade level)
- **60-69**: Standard (8th-9th grade level)
- **50-59**: Fairly Difficult (10th-12th grade level)
- **30-49**: Difficult (College level)
- **0-29**: Very Difficult (Graduate level)

### Algorithm Components

**Word Counting**: Identifies word boundaries by detecting letter-to-non-letter transitions

**Sentence Counting**: Recognizes sentence endings using punctuation marks (. : ; ! ?)

**Syllable Counting**: 
- Detects vowel groups (a, e, i, o, u, y)
- Handles silent 'e' at word endings
- Includes exceptions for common one-syllable words
- Ensures minimum one syllable per word

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line interface

### Installation

1. Clone the repository:
```bash
git clone https://github.com/monia-p/flesch-readability-calculator.git
cd flesch-readability-calculator
```

2. Compile the Java files:
```bash
javac FleshReadability.java Tester.java
```

3. Run the application:
```bash
java Tester
```

## Usage

### Interactive Mode
When you run the program, you'll be prompted to enter text:
```
Type your text: 
> This is a sample sentence for testing readability.
```

### Sample Output
```
Results for text: 
This is a sample sentence for testing readability.

Words = 8, Sentences = 1, Syllables = 14.
Flesch Readability Index = 57.950000
```

### Test Cases
The program includes a predefined complex text example to demonstrate the algorithm's effectiveness with difficult, technical writing.

## Code Structure

### FleshReadability.java
Main calculation class containing:
- `calculateFleshReadability(String text)` - Main method that orchestrates the analysis
- `calculateFleshIndex(int words, int syllables, int sentences)` - Applies the Flesch formula
- `countWords(String text)` - Counts words using character transition detection
- `countSyllables(String text)` - Advanced syllable counting with exception handling
- `countSentences(String text)` - Sentence boundary detection
- `isException(String word)` - Handles special one-syllable word cases

### Tester.java
Testing framework that:
- Provides interactive user input
- Runs predefined test cases
- Displays formatted results
- Demonstrates practical usage

## Technical Implementation

### Syllable Counting Algorithm
```java
// Core logic for vowel detection
boolean charIsVowel = vowels.indexOf(c) >= 0;
if (charIsVowel && !prevCharWasVowel) {
    wordSyllables++;
}

// Handle silent 'e'
if (word.length() > 1 && word.charAt(word.length() - 1) == 'e') {
    wordSyllables--;  
}
```

### Exception Words
Common words that don't follow standard syllable rules:
`["the", "a", "an", "i", "to", "of", "and", "but", "or", "as", "in", "it", "close"]`

## Applications

- **Educational Tools**: Assess reading level of textbooks and materials
- **Content Creation**: Optimize blog posts and articles for target audiences
- **Publishing**: Evaluate manuscript complexity
- **Web Accessibility**: Ensure content meets readability standards
- **Technical Writing**: Simplify complex documentation

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/improvement`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/improvement`)
5. Create a Pull Request

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

**Monika Pejas**
- GitHub: [@monia-p](https://github.com/monia-p)
- Email: m.pejas1@universityofgalway.ie

## Acknowledgments

- Based on the Flesch Readability Index developed by Rudolf Flesch
- Inspired by the need for accessible content analysis tools
- Part of algorithm implementation coursework at University of Galway
