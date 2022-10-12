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
