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
//      NumberFormat twoDecimals = new DecimalFormat("0.00");
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
//    NumberFormat twoDecimals = new DecimalFormat("0.00");
    float[] totalReadabilityStats = ParagraphStats.calculateTotalFleschKincaid();
    String totalFleschKincaid = twoDecimals.format(totalReadabilityStats[0]);
    float totalFleschFloat = totalReadabilityStats[1];
    String judgement = judgeReadability(totalFleschFloat);
    String totalFlesch = twoDecimals.format(totalFleschFloat);
    
//    System.out.println(judgement + ": (Total – Flesch-Kincaid Grade Level: " + totalFleschKincaid + 
//      " | Flesch Reading Ease: " + totalFlesch + ")");
    System.out.println(judgement);
    System.out.println("Flesch-Kincaid Grade Level: " + totalFleschKincaid);
    System.out.println("Flesch Reading Ease: " + totalFlesch);
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
  
  private static void printWordCount(HashMap<String, Integer>sortedMap)
  {
//    HashMap<String, Integer>countMap = MapCreator.count;
    HashMap<String, Integer>countMap = sortedMap;
    
    for (Entry<String, Integer> entry : countMap.entrySet())
    {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
  
  private static HashMap<String, Integer> sortHashMap(HashMap<String, Integer>mapToSort)
  {
//    HashMap<String, Integer>countMap = MapCreator.count;
    HashMap<String, Integer>countMap = mapToSort;
//    TreeMap<String, Integer>keySortedMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
//    
//    keySortedMap.putAll(countMap);
//    
//    
//    ArrayList<Integer> countList = new ArrayList<>();
//    
//    for (Entry<String, Integer> entry : keySortedMap.entrySet())
//    {
////      System.out.println(entry);
////      wordList.add(entry.getKey());
//      if (!countList.contains(entry.getValue()))
//      {
//        countList.add(entry.getValue());
//      }
//    }
    
//    Collections.sort(countList, Collections.reverseOrder());
//    LinkedHashMap<String, Integer>finalSortedMap = new LinkedHashMap<String, Integer>();
//    
//    for (int count : countList)
//    {
////      System.out.println(count);
//      for (Entry<String, Integer> entry : keySortedMap.entrySet())
//      {
////        System.out.println(entry);
//        if (count == entry.getValue())
//        {
//          finalSortedMap.put(entry.getKey(), entry.getValue());
//        }
////        if ( entry.getValue()))
//      }
//    }
    
    
    LinkedHashMap<String, Integer>keySortedMap = new LinkedHashMap<>();

    ArrayList<String> wordList = new ArrayList<>();
    ArrayList<Integer> countList = new ArrayList<>();
    
    for (Entry<String, Integer> entry : countMap.entrySet())
    {
//      System.out.println(entry);
      wordList.add(entry.getKey());
      if (!countList.contains(entry.getValue()))
      {
        countList.add(entry.getValue());
      }
    }
    
    Collections.sort(wordList);
    
    for (String word : wordList)
    {
//      System.out.println(word);
      for (Entry<String, Integer> entry: countMap.entrySet())
      {
//        System.out.println(entry);
        if (word.equals(entry.getKey()))
        {
          keySortedMap.put(entry.getKey(), entry.getValue());
        }
      }
    }
    
    

    
    Collections.sort(countList, Collections.reverseOrder());
    LinkedHashMap<String, Integer>finalSortedMap = new LinkedHashMap<String, Integer>();
    
    for (int count : countList)
    {
//      System.out.println(count);
      for (Entry<String, Integer> entry : keySortedMap.entrySet())
      {
//        System.out.println(entry);
        if (count == entry.getValue())
        {
          finalSortedMap.put(entry.getKey(), entry.getValue());
        }
//        if ( entry.getValue()))
      }
    }
    
    
    
    
    
    
//    for (Entry<String, Integer> entry : finalSortedMap.entrySet())
//    {
//      System.out.println(entry);
//    }
    
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
  
  public static void main(String[] args) throws IOException
  {
//    String sampleChapter = TomSawyer.firstChapter;
    String sampleChapter = AliceFirstChapter.firstChapter;
    String[][][] chapter = ManuscriptData.createAllManuscriptData(sampleChapter);
    
    System.out.println("*******************************************");
    System.out.println("*************READABILITY STATS*************");
    System.out.println("*******************************************");
    
    printReadabilityStats(chapter);

    System.out.println("*******************************************");
    System.out.println("*************WORD COUNT STATS**************");
    System.out.println("*******************************************");
    
    HashMap<String, Integer>countMap = MapCreator.count;
    HashMap<String, Integer>sortedMap = sortHashMap(countMap);
    printWordCount(sortedMap);
    
    System.out.println("*******************************************");
    System.out.println("****************TOTAL STATS****************");
    System.out.println("*******************************************");
    
    printTotalReadabilityStats();
    
    System.out.println("*******************************************");
    
    printWordTotalCount();
    
    
    
//    float testy1 = 10.409F;
//    float testy2 = 10.5908F;
//    
//    int zesty1 = Math.round(testy1);
//    int zesty2 = Math.round(testy2);
//    
//    System.out.println(zesty1);
//    System.out.println(zesty2);
    
    
//    float uniqueWordDivision = (float) totalUniqueWords / totalWords;
//    
//    int uniqueWordPercentage = (int) (uniqueWordDivision * 100);
//    
//    System.out.println("Percentage of Unique Words: " + uniqueWordPercentage);
    

//    System.out.println("***********************end************************");
//    for (Entry<String, Integer> entry : countMap.entrySet())
//    {
//      System.out.println(entry.getKey() + ": " + entry.getValue());
//    }
//    
//    HashMap<String, String>normalizedMap = MapCreator.normalized;
//    
//    for (Entry<String, String> entry : normalizedMap.entrySet())
//    {
//      System.out.println(entry.getKey());
//    }
    
  }

}
