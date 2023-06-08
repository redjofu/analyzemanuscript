package analysis;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import disassembly.ManuscriptData;
import individualWords.MapCreator;
import sampleBooks.*;
import readability.ParagraphStats;

public class AnalyzeManuscript
{ 
  static NumberFormat twoDecimals = new DecimalFormat("0.00");
  
  private static void printReadabilityStats(String[][][] chapter)
  {
    float[][]readabilityStats = ParagraphStats.calculateParagraphStats(chapter);
    
    for (int i = 0; i < readabilityStats.length; i++)
    {
      String fleschKincaid = twoDecimals.format(readabilityStats[i][0]);
      float fleschfloat = readabilityStats[i][1];
      String judgement = judgeReadability(fleschfloat);
      String flesch = twoDecimals.format(readabilityStats[i][1]);
      
      System.out.println("Paragraph " + i + ": " + judgement + " (Flesch-Kincaid Grade Level: " + fleschKincaid + 
        " | Flesch Reading Ease: " + flesch + ")");
    }
  }
  
  private static void printTotalReadabilityStats()
  {
    float[] totalReadabilityStats = ParagraphStats.calculateTotalFleschKincaid();
    String totalFleschKincaid = twoDecimals.format(totalReadabilityStats[0]);
    float totalFleschFloat = totalReadabilityStats[1];
    String judgement = judgeReadability(totalFleschFloat);
    String totalFlesch = twoDecimals.format(totalFleschFloat);
    
    System.out.println(judgement);
    System.out.println("Flesch-Kincaid Grade Level: " + totalFleschKincaid);
    System.out.println("Flesch Reading Ease: " + totalFlesch);
  }
  
  private static String judgeReadability(float flesch)
  {
    // These judgments are based partly on established standards for the Flesch readability formula and partly on my
    // interpretation of those standards.
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
  
  private static void printWordCount(HashMap<String, Integer>sortedMap)
  {
    HashMap<String, Integer>countMap = sortedMap;
    
    for (Entry<String, Integer> entry : countMap.entrySet())
    {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
  
  private static HashMap<String, Integer> sortHashMap(HashMap<String, Integer>mapToSort)
  {
    HashMap<String, Integer>countMap = mapToSort;
    
    // LinkedHashMap is required to preserve order.
    LinkedHashMap<String, Integer>keySortedMap = new LinkedHashMap<String, Integer>(); 
    LinkedHashMap<String, Integer>finalSortedMap = new LinkedHashMap<String, Integer>();

    // A list of all the words (keys) in the map
    ArrayList<String> wordList = new ArrayList<>();
    // A list of all the unique numbers (values) in the map
    ArrayList<Integer> countList = new ArrayList<>();
    
    for (Entry<String, Integer> entry : countMap.entrySet())
    {
      wordList.add(entry.getKey());
      // I only want to add a number to the countList if it's unique.
      if (!countList.contains(entry.getValue()))
      {
        countList.add(entry.getValue());
      }
    }
    
    // Alphabetize the wordList
    Collections.sort(wordList);
    
    // Now that the wordList is alphabetized, I use it to populate the keySortedMap with an alphabetically sorted 
    // version of the countMap.
    for (String word : wordList)
    {
      for (Entry<String, Integer> entry: countMap.entrySet())
      {
        if (word.equals(entry.getKey()))
        {
          keySortedMap.put(entry.getKey(), entry.getValue());
        }
      }
    }
    
    // Sort the countList in descending order (highest numbers first)
    Collections.sort(countList, Collections.reverseOrder());
    
    // Now that the countList is ordered, I use it to populate the finalSortedMap, higher count values first. In cases
    // where the count values are equal, the previously calculated alphabetical order is preserved.
    for (int count : countList)
    {
      for (Entry<String, Integer> entry : keySortedMap.entrySet())
      {
        if (count == entry.getValue())
        {
          finalSortedMap.put(entry.getKey(), entry.getValue());
        }
      }
    }
    
    return finalSortedMap;
  }

  public static void printWordTotalCount()
  {
    int totalWords = ParagraphStats.totalWords;
    int totalUniqueWords = MapCreator.count.size();
    
    System.out.println("Total Word Count: " + totalWords);
    System.out.println("Total Unique Words: " + totalUniqueWords);
    
    float uniqueWordDivision = (float) totalUniqueWords / totalWords;
    
    int uniqueWordPercentage = Math.round(uniqueWordDivision * 100);
    
    System.out.println("Percentage of Unique Words: " + uniqueWordPercentage + "%");
  }
  
  
  // This is the actual main method currently used that brings everything together.
  public static void main(String[] args) throws IOException
  {
    // I comment various sample chapters in and out as part of my testing. This is the data that I'm feeding the rest
    // of the program.
    String sampleChapter = TomSawyer.firstChapter;
//    String sampleChapter = AliceFirstChapter.firstChapter;
//    String sampleChapter = Forgone.firstPart;
    
    // This parses the sample manuscript/chapter into its various components, stored in a multidimensional array.
    // All of that is handled by various classes in the "disassembly" package, which is accessed via the ManuscriptData
    // class.
    String[][][] chapter = ManuscriptData.createAllManuscriptData(sampleChapter);
    
    System.out.println("*******************************************");
    System.out.println("*************READABILITY STATS*************");
    System.out.println("*******************************************");
    
    // This prints out various readability stats in the console. Each paragraph gets its own line.
    printReadabilityStats(chapter);

    System.out.println("*******************************************");
    System.out.println("*************WORD COUNT STATS**************");
    System.out.println("*******************************************");
    
    // To before printing the "count" HashMap, I first want to sort it by count (more frequent words showing first) and
    // then sort alphabetically.
    HashMap<String, Integer>sortedMap = sortHashMap(MapCreator.count);
    
    // This prints the number of times each word appears in the manuscript in the console. Each word gets its own line.
    printWordCount(sortedMap);
    
    System.out.println("*******************************************");
    System.out.println("****************TOTAL STATS****************");
    System.out.println("*******************************************");
    
    // This prints out readability stands for the entire manuscript (not just individual paragraphs).
    printTotalReadabilityStats();
    
    System.out.println("*******************************************");
    
    // This prints out word counts stats for the entire manuscript.
    printWordTotalCount(); 
  }
}