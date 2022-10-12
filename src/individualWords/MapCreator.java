package individualWords;

import java.text.Normalizer;
import java.util.HashMap;
import individualWords.syllablePrep.SyllablePreparation;
import util.Util;

public class MapCreator
{
  public static HashMap<String, String> normalized = new HashMap<String, String>();
  public static HashMap<String, String> syllablePrep = new HashMap<String, String>();
  public static HashMap<String, Integer> syllables = new HashMap<String, Integer>();
  public static HashMap<String, Integer> count = new HashMap<String, Integer>();
  
  private static void addToMap(HashMap<String, String> mapName, String word, String value)
  {
    mapName.put(word, value);
  }
  
  private static void addToMap(HashMap<String, Integer> mapName, String word, int value)
  {
    mapName.put(word, value);
  }
  
  public static void addWord(String wordToAdd)
  {
    String word = Util.lowerOrUpperCase(wordToAdd);
    int currentCount = 1;
    
    // Treat ALL CAPS versions of words as separate from any other capitalization scheme
//    if (wordToAdd.equals(wordToAdd.toUpperCase()))
//    {
//      word = wordToAdd;
//    }
//    else
//    {
//      word = wordToAdd.toLowerCase();  
//    }
    
    
    
    if (!normalized.containsKey(word))
    {
      String normalizedWord = Normalizer.normalize(word, Normalizer.Form.NFD).
        replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
      addToMap(normalized, word, normalizedWord);
      
      String syllablePrepped = SyllablePreparation.prepareForSyllables(normalizedWord);    
      addToMap(syllablePrep, word, syllablePrepped);

      int syllableNum = Syllables.countSyllables(syllablePrepped);    
      addToMap(syllables, word, syllableNum);
      
//      System.out.println("Hello");
    }
    else
    {
      currentCount += count.get(word);
    }
    
    
    addToMap(count, word, currentCount);

  }

  public static void main(String[] args)
  {
    addWord("biLly");
    addWord("green");
    addWord("BILLy");
    addWord("BILLY");

    
    System.out.println(count);
  }

}
