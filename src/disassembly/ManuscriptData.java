<<<<<<< HEAD
package disassembly;

import java.io.IOException;

import individualWords.MapCreator;
import sampleBooks.TomSawyer;

public class ManuscriptData
{

  private static String[][] buildParagraphsOfSentences(String[] paragraphsToBuild) throws IOException
  {
    String[][] paragraphs = new String[paragraphsToBuild.length][];
    
    // Loop through each paragraph, separating it into sentences.
    for (int i=0; i<paragraphs.length; i++)
    {
      paragraphs[i] = Sentence.separateParagraphToSentences(paragraphsToBuild[i]);
    }
    
    return paragraphs;
  }
  
  private static String[][][] buildParsOfSentOfWords(String[][] sentencesToBuild) throws IOException
  {
    String[][][] sentences = new String[sentencesToBuild.length][][];

    // Loop through each sentence, separating it into words.
    for (int i=0; i<sentences.length; i++)
    {
      String[][] listOfWords = new String[sentencesToBuild[i].length][];
      for (int j=0; j<listOfWords.length; j++)
      {
        // I use an external library to parse the words, but it only parses by tokens, which can be either words or
        // punctuation. So I first go through and build an array of the tokens.
        String[] wordsAndPunctuationTogether = Word.tokenizeParagraph(sentencesToBuild[i][j]);
        // Then I use that to build a multidimensional array separating words and punctuation.
        String[][] wordsAndPunctuationSeparated = Word.splitTokensIntoWordsAndPunctuation(wordsAndPunctuationTogether);
        // Then I only utilize the array of words, ignoring the punctuation. 
        String[] onlyTheWords = wordsAndPunctuationSeparated[0];
        listOfWords[j] = onlyTheWords;
        
        // These words are then added to various HashMaps. Originally I was going to create a different object for each
        // word that I could use to store data about that word. But I couldn't figure out a way to do that which made
        // sense, so I went the HashMap route instead once I learned more about those.
        addEachWordToWordMap(onlyTheWords);
      }
      sentences[i] = listOfWords;
    }
    
    return sentences;
  }
  
  private static void addEachWordToWordMap(String[] listOfWords)
  {
    for (String word : listOfWords)
    {
      MapCreator.addWord(word);
    }
  }
  
  // This is the method used to ultimately parse all of the manuscript data.
  public static String[][][] createAllManuscriptData(String chapterToAnalyze) throws IOException
  {
    // Eventually I'll parse a full manuscript into chapters first, but for now, I'm just taking a chapter and getting
    // it ready for the rest of the process. This is basically just cleanup stuff -- removing double line breaks between
    // paragraphs, adding spaces on the either side of dashes to help with parsing words, and removing double spaces
    // between sentences.
    String chapter = Chapter.prepareChapter(chapterToAnalyze);
    
    // This is the first parsing step, separating the chapter into paragraphs.
    String[] paragraphs = Paragraph.separateChapterToParagraphs(chapter);
    
    // Second parsing step, separating the paragraphs into sentences. I use an external library to do that.
    String[][] sentences = buildParagraphsOfSentences(paragraphs);
    
    // Third parsing step, separating the sentences into words. I use an external library to do that.
    String[][][] words = buildParsOfSentOfWords(sentences);
    
    return words;
  }
  
  public static void main(String[] args) throws IOException
  {
    String chapter = TomSawyer.firstChapter;
    
    String[][][] manuscript = createAllManuscriptData(chapter);
    
    System.out.println(MapCreator.count);
  }
}
=======
package disassembly;

import java.io.IOException;

import individualWords.MapCreator;
import sampleBooks.TomSawyer;

public class ManuscriptData
{

  private static String[][] buildParagraphsOfSentences(String[] paragraphsToBuild) throws IOException
  {
    String[][] paragraphs = new String[paragraphsToBuild.length][];
    
//    int counter = 0;
    
    for (int i=0; i<paragraphs.length; i++)
    {
      paragraphs[i] = Sentence.separateParagraphToSentences(paragraphsToBuild[i]);
      
//      String testy1 = "hello" + counter++;
//      String testy2 = "there" + counter++;
//      String array[] = {testy1, testy2};
//      paragraphs[i] = array;
      
      
//      String whatIsThis = paragraphsToBuild[i];
//      String[] paragraphArray = Sentence.separateParagraphToSentences(whatIsThis);
      
    }
    
    return paragraphs;
  }
  
  private static String[][][] buildParsOfSentOfWords(String[][] sentencesToBuild) throws IOException
  {
    String[][][] sentences = new String[sentencesToBuild.length][][];
//    System.out.println(sentencesToBuild.length);
//    System.out.println(sentencesToBuild[22][5]);
    for (int i=0; i<sentences.length; i++)
    {
//      System.out.println(sentencesToBuild[i]);
      String[][] listOfWords = new String[sentencesToBuild[i].length][];
      for (int j=0; j<listOfWords.length; j++)
      {
        String[] wordsAndPunctuationTogether = Word.tokenizeParagraph(sentencesToBuild[i][j]);
        String[][] wordsAndPunctuationSeparated = Word.splitTokensIntoWordsAndPunctuation(wordsAndPunctuationTogether);
        String[] onlyTheWords = wordsAndPunctuationSeparated[0];
        listOfWords[j] = onlyTheWords;
        addEachWordToWordMap(onlyTheWords);
//        temporarySentences[j] = Word.tokenizeParagraph(sentencesToBuild[i][j]);
//        
//        if (i==22)
//        {
//          System.out.println("i == " + i);
//          System.out.println("j == " + j);
//          System.out.println(sentencesToBuild[i][j]);
//        }
        
        
      }
      sentences[i] = listOfWords;
    }
    
    return sentences;
  }
  
  private static void addEachWordToWordMap(String[] listOfWords)
  {
    for (String word : listOfWords)
    {
      MapCreator.addWord(word);
    }
  }
  
  public static String[][][] createAllManuscriptData(String chapterToAnalyze) throws IOException
  {
    String chapter = Chapter.prepareChapter(chapterToAnalyze);
    
    String[] paragraphs = Paragraph.separateChapterToParagraphs(chapter);
    
    String[][] sentences = buildParagraphsOfSentences(paragraphs);
    
    String[][][] words = buildParsOfSentOfWords(sentences);
    
    
//    String[][] sentences
//    String[][][] words
    
//    String[][] sentences 
    
    
    /*
     * 1. Paragraph
     *    a. Sentence
     *    b. S2
     *    c. S3
     *    d. S4
     *    e. S5
     * 2. P2
     *    a. S1
     *    b. S2
     *    c. S3
     * 3. P3
     *    a. S1
     *    b. S2
     */
    
    return words;
  }
  
  public static void main(String[] args) throws IOException
  {
    String chapter = TomSawyer.firstChapter;
    
    String[][][] manuscript = createAllManuscriptData(chapter);
    
//    System.out.println(manuscript[22][11][6]);
//    System.out.println(manuscript[22][11][8]);
    
    System.out.println(MapCreator.count);
    
//    String[] array1 = {"hello","there"};
//    String[] array2 = {"are","you","my","friend"};
//    String[][] twoDArray = {array1, array2};
//    System.out.println(twoDArray[1][3]);
  }

}
>>>>>>> branch 'main' of https://github.com/redjofu/analyzemanuscript.git
