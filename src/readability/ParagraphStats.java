package readability;

import individualWords.MapCreator;
import sampleBooks.TomSawyer;

import java.io.IOException;

import disassembly.ManuscriptData;
import util.Util;

//In order to calculate using the Flesch formulas, I need the total number of sentences, total number of words, and
// total number of syllables. This class determines those for every paragraph in the manuscript/chapter.

public class ParagraphStats
{
  // These variables are used to determine Flesch scores on a manuscript level.
  static int totalSentences = 0;
  public static int totalWords = 0;
  static int totalSyllables = 0;
  
  private static int calculateTotalSentences(String[][] paragraph)
  {
    return paragraph.length;
  }
  
  private static int calculateTotalWords(String[][] paragraph)
  {
    int totalWords = 0;
    for (String[] sentence : paragraph)
    {
      totalWords += sentence.length;
    }
    return totalWords;
  }
  
  private static int calculateTotalSyllables(String[][] paragraph)
  {
    int totalSyllables = 0;
    
    for (String[] sentence : paragraph)
    {
      for (String word : sentence)
      {
        totalSyllables += MapCreator.syllables.get(Util.lowerOrUpperCase(word));
      }
    }

    return totalSyllables;
  }
  
  public static float[][] calculateParagraphStats(String[][][] chapter)
  {
    // This array will hold readability scores for each paragraph.
    float[][] paragraphStats = new float[chapter.length][2];
    
    for (int i = 0; i < paragraphStats.length; i++)
    {
      String[][] paragraph = chapter[i];
      int sentences = calculateTotalSentences(paragraph);
      totalSentences += sentences;
      
      int words = calculateTotalWords(paragraph);
      totalWords += words;
      
      int syllables = calculateTotalSyllables(paragraph);
      totalSyllables += syllables;
      
      paragraphStats[i][0] = FleschKincaid.calculateFleschKincaid(sentences, words, syllables);
      paragraphStats[i][1] = FleschKincaid.calculateFlesch(sentences, words, syllables);
    }

    return paragraphStats;
  }
  
  // This method handles Flesch scores on the manuscript level instead of the paragraph level.
  public static float[] calculateTotalFleschKincaid()
  {
    float totalFleschKincaid =  FleschKincaid.calculateFleschKincaid(totalSentences, totalWords, totalSyllables);
    float totalFlesch = FleschKincaid.calculateFlesch(totalSentences, totalWords, totalSyllables);
    float[] fleschArray = {totalFleschKincaid, totalFlesch};
    return fleschArray;
  }

  public static void main(String[] args) throws IOException
  {
    String sampleChapter = TomSawyer.firstChapter;
    String[][][] chapter = ManuscriptData.createAllManuscriptData(sampleChapter);
    
    float[][] stats = calculateParagraphStats(chapter);
    System.out.println(stats[22][0]);
    System.out.println(stats[22][1]);
  }
}
