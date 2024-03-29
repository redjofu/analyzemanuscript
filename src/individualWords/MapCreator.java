package individualWords;

import java.text.Normalizer;
import java.util.HashMap;
import individualWords.syllablePrep.SyllablePreparation;
import util.Util;

public class MapCreator
{
  // These HashMaps store important data about individual words. Since many words are repeated throughout a manuscript,
  // storing the information for specific words once allows me to store word info once and access it as needed. Beyond
  // these four HashMaps, I'll eventually add others that keep track of other information, such as character count.
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
    // Because a word at the beginning of a sentence will be capitalized, it's important to treat all words the same
    // regardless of capitalization – that way, I'm not storing the same information for capitalized and non-capitalized
    // versions of a word. Plus, that would mess up my counts later. However, I did decide it would be important to
    // treat words in ALL CAPS as separate since they could potentially be acronyms. So first off, I determine if a 
    // word is in ALL CAPS, and if so, I leave it that way. Otherwise, I make it all lower-case.
    String word = Util.lowerOrUpperCase(wordToAdd);
    int currentCount = 1;
    
    // I need to check to see if the word has already been added to the HashMaps. And if it has, I don't want to add it
    // again. I used the "normalized" HashMap for this check, though it could have been one of the others.
    if (!normalized.containsKey(word))
    {
      // The "normalized" HashMap stores a version of the word without accents and stuff. This is important for
      // counting syllables. However, later, I'll probably also use this to check for multiple entries on this HashMap
      // with the same values but different keys. That would allow me to identify instances where a manuscript may have
      // instances where some accents are missing from words they might need to be present for.
      String normalizedWord = Normalizer.normalize(word, Normalizer.Form.NFD).
        replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
      addToMap(normalized, word, normalizedWord);
      
      // The "syllablePrepped" HashMap converts the word into a version that I can use to count syllables, which is 
      // necessary to calculate readability according to the Flesch formulas. I do need the word normalized at first,
      // but there are a bunch of other steps. These are handled in the "individualWords.syllablePrep" package.
      String syllablePrepped = SyllablePreparation.prepareForSyllables(normalizedWord);    
      addToMap(syllablePrep, word, syllablePrepped);

      // I then use the syllablePrepped version of the word and use it to count syllables. I discovered that determining
      // a word's syllable count is sometimes not a straightforward process and may even be debated among linguists in
      // a few cases. There are some standard rules that can be determined programmatically that hold true in most
      // cases, however, and I added in some edge-case checks that gives a pretty good estimate of what a word's 
      // syllable count probably is.
      int syllableNum = Syllables.countSyllables(syllablePrepped);    
      addToMap(syllables, word, syllableNum);
    }
    // If a word has already been added to the HashMaps, I don't want them added again in most cases. However, the
    // "count" HashMap is used to count the number of times a word has appeared in the entire manuscript. This else
    // statement is used if the word has already been added to the HashMaps and merely checks what the current count is
    // and increments it. Then that is used to update the "count" HashMap below.
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