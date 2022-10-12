package analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import disassembly.ManuscriptData;
import individualWords.MapCreator;
import sampleBooks.TomSawyer;
import readability.ParagraphStats;

public class AnalyzeManuscript
{
  private static void printReadabilityStats(String[][][] chapter)
  {
    float[][]readabilityStats = ParagraphStats.calculateParagraphStats(chapter);
    
    for (int i = 0; i < readabilityStats.length; i++)
    {
      String fleschKincaid = String.valueOf(readabilityStats[i][0]);
      String flesch = String.valueOf(readabilityStats[i][1]);
      String judgement = judgeReadability(flesch);
      
      System.out.println("Paragraph " + i + ": " + judgement + "(Flesch-Kincaid Grade Level: " + fleschKincaid + 
        " | Flesch Reading Ease: " + flesch + ")");
    }
  }
  
  private static void printTotalReadabilityStats()
  {
    float[] totalReadabilityStats = ParagraphStats.calculateTotalFleschKincaid();
    String totalFleschKincaid = String.valueOf(totalReadabilityStats[0]);
    String totalFlesch = String.valueOf(totalReadabilityStats[1]);
    String judgement = judgeReadability(totalFlesch);
    
    System.out.println(judgement + ": (Total – Flesch-Kincaid Grade Level: " + totalFleschKincaid + 
      " | Flesch Reading Ease: " + totalFlesch + ")");
  }
  
  private static String judgeReadability(float flesch)
  {
    if (flesch > 100f)
    {
      return "Very Easy, Suitable for All Novel Readers";
    }
    else if (flesch > 75f)
    {
      return "Easy, Suitable for Older Children to Adults";
    }
    else if (flesch > 60f)
    {
      return "Moderately Difficult, Suitable for Teens and Adults";
    }
    else if (flesch > 40f)
    {
      return "Difficult, Suitable only for Adults";
    }
    else if (flesch > 20f)
    {
      return "Very Difficult, May Discourage Casual Readers"; 
    }
    else if (flesch > 0f)
    {
      return "Exceptionally Difficult, Likely to Discourage Readers";
    }
    else
    {
      return "Unusually Difficult, Likely to Discourage Even Readers with Advanced Degrees";
    }
  }
  
  private static void printWordCount()
  {
    HashMap<String, Integer>countMap = MapCreator.count;
    
    for (HashMap.Entry<String, Integer> entry : countMap.entrySet())
    {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
  
  private static HashMap<String, Integer> sortHashMap()
  {
    HashMap<String, Integer>countMap = MapCreator.count;
//    TreeMap<String, Integer>keySortedMap = new TreeMap<>();
    
    HashMap<String, Integer>sortedMap = new HashMap<String, Integer>();
    ArrayList<String> wordList = new ArrayList<>();
    ArrayList<Integer> countList = new ArrayList<>();
    
    for (HashMap.Entry<String, Integer> entry : countMap.entrySet())
    {
      wordList.add(entry.getKey());
      countList.add(entry.getValue());
    }
    
    
  }

  public static void main(String[] args) throws IOException
  {
    String sampleChapter = TomSawyer.firstChapter;
    String[][][] chapter = ManuscriptData.createAllManuscriptData(sampleChapter);
    
    System.out.println("*******************************************");
    System.out.println("*************READABILITY STATS*************");
    System.out.println("*******************************************");
    
    printReadabilityStats(chapter);

    printTotalReadabilityStats();

    System.out.println("*******************************************");
    System.out.println("*************WORD COUNT STATS**************");
    System.out.println("*******************************************");
    
    printWordCount();

  }

}
