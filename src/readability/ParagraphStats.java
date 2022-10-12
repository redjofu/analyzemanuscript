package readability;

import individualWords.MapCreator;
import sampleBooks.TomSawyer;

import java.io.IOException;

import disassembly.ManuscriptData;
import util.Util;

public class ParagraphStats
{
//  int sentences;
//  int words;
//  int syllables;
//  
//  public ParagraphStats(String[][][] manuscript)
//  {
//    sentences = 
//  }
  
  static int totalSentences = 0;
  static int totalWords = 0;
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
   
//  public static int[][] calculateParagraphStats(String[][][] chapter)
//  {
//    int[][] paragraphStats = new int[chapter.length][3];
//    
//    for (int i = 0; i < paragraphStats.length; i++)
//    {
//      String[][] paragraph = chapter[i];
//      int sentences = calculateTotalSentences(paragraph);
//      totalSentences += sentences;
//      paragraphStats[i][0] = sentences;
//      
//      int words = calculateTotalWords(paragraph);
//      totalWords += words;
//      paragraphStats[i][1] = words;
//      
//      int syllables = calculateTotalSyllables(paragraph);
//      totalSyllables += syllables;
//      paragraphStats[i][2] = syllables;
//    }
//
//    return paragraphStats;
//  }
  
//  public static double[][] determineReadability(int[][] paragraphStats){
//    double[][] readabilityStats = new double[paragraphStats.length][2];
//    
//    for (int i = 0; i < readabilityStats.length; i++)
//    {
//      
//    }
//  }
  
  public static float[][] calculateParagraphStats(String[][][] chapter)
  {
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
//  
//  public static float[][] calculateParagraphReadability(int[][] paragraphStats)
//  {
//    float[][] paragraphReadability = new float[paragraphStats.length][2];
//    
//    for (int i = 0; i < paragraphReadability.length; i++)
//    {
////      String[] paragraph = paragraphStats[i];
//      int sentences = paragraphStats[i][0];
//      int words = paragraphStats[i][0];
//      int syllables = paragraphStats[i][0];
//      
//      paragraphReadability[i][0] = FleschKincaid.calculateFleschKincaid(sentences, words, syllables);
//      paragraphReadability[i][1] = FleschKincaid.calculateFlesch(sentences, words, syllables);
//    }
//
//    return paragraphReadability;
//  }
  
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
//
//    String[][] sampleParagraph = chapter[22];
//    
//    System.out.println(calculateTotalSentences(sampleParagraph));
//    System.out.println(calculateTotalWords(sampleParagraph));
//    System.out.println(calculateTotalSyllables(sampleParagraph));
    
    float[][] stats = calculateParagraphStats(chapter);
    System.out.println(stats[22][0]);
    System.out.println(stats[22][1]);
//    System.out.println(stats[22][2]);
  }

}
