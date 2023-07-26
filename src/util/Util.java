package util;

import manuscript.Chapter;

public class Util
{
  /**
   * This method just determines if a word is in ALL CAPS (potentially an acronym) and, if so, allows to remain that
   * way. Otherwise, it makes the word lowercase.
   * 
   * @param word  The single word being checked
   * @return      The @word either in ALL CAPS or completely in lowercase
   */
  public static String lowerOrUpperCase(String word)
  {
    if (word.equals(word.toUpperCase()))
    {
      return word;
    }
    else
    {
      return word.toLowerCase();  
    }
  }
  
  /** 
   * Get the string for the next passage.
   * 
   * @param text            The full passage to be considered when finding the breakpoint.
   * @param index           The starting point index to begin finding the next breakpoint.
   * @param breakingPoint   The text used to determine where the next breakpoint is.
   * @param breakingPoint[] Multiple options of text used to determine where the next breakpoint is.
   * @param isFirstSearch   A boolean determining whether this is the first search, useful when the @breakingPoint might
   *                        be the first text in the passage.
   * @return                The passage text as a string.
   */
//  public static String getNextPassage(String text, PassageIndex index, String breakingPoint)
//  {
//    return getNextPassage(text, index, breakingPoint, false);
//  }
//  
//  public static String getNextPassage(String text, PassageIndex index, String[] breakingPoints)
//  {
//    return getNextPassage(text, index, breakingPoints, false);
//  }
//  
//  public static String getNextPassage(String text, PassageIndex index, String breakingPoint, boolean isFirstSearch)
//  {
//    String[] breakingPoints = {breakingPoint};
//    return getNextPassage(text, index, breakingPoints, isFirstSearch);
//  }
//  
//  public static String getNextPassage(String text, PassageIndex index, String[] breakingPoints, boolean isFirstSearch)
//  {
//    int nextIndex = findNextPassageIndex(text, index, breakingPoints, isFirstSearch);
//    String passage = extractPassage(text, index, nextIndex);
//    index.set(nextIndex);
//    return passage;
//  }
  public static String getNextPassage(String text, PassageIndex index, String breakingPoint)
  {
    String[] breakingPoints = {breakingPoint};
    return getNextPassage(text, index, breakingPoints);
  }
  
  public static String getNextPassage(String text, PassageIndex index, String[] breakingPoints)
  {
    int nextIndex = findNextPassageIndex(text, index, breakingPoints);
    String passage = extractPassage(text, index, nextIndex);
    index.set(nextIndex);
    return passage;
  }
  
  /** 
   * This is used to find where the next breakpoint is for a passage of text. If there is no next next passage, this 
   * will return -1.
   * 
   * @param text            The full passage to be considered when finding the breakpoint.
   * @param index           The starting point index to begin finding the next breakpoint.
   * @param breakingPoint   The text used to determine where the next breakpoint is.
   * @param breakingPoint[] Multiple options of text used to determine where the next breakpoint is.
   * @param isFirstSearch   A boolean determining whether this is the first search, useful when the @breakingPoint might
   *                        be the first text in the passage.
   * @return                The index in @text where the next @breakingPoint is found (or -1, if no index is found).
   */
//  public static int findNextPassageIndex(String text, PassageIndex index, String[] breakingPoints, 
//    boolean isFirstSearch)
//  {
//    int indexNum = -1;
//    int passageIndex = index.get();
////    int startingPoint = isFirstSearch ? passageIndex : passageIndex + 1;
//    int startingPoint = passageIndex + 1;
//    // Checks each variation of how a passage might be divided (e.g. either "chapter" or "prologue" or "epilogue")
//    for (String variation : breakingPoints)
//    {
//      int currentIndex = text.indexOf(variation, startingPoint);
//      if (currentIndex > -1 && (currentIndex < indexNum || indexNum < 0))
//      {
//        indexNum = currentIndex;
//      }
//    }
//    return indexNum;
//  }
  public static int findNextPassageIndex(String text, PassageIndex index, String[] breakingPoints)
  {
    int indexNum = -1;
    int startingPoint = index.get() + 1;
    // Checks each variation of how a passage might be divided (e.g. either "chapter" or "prologue" or "epilogue")
    for (String variation : breakingPoints)
    {
      int currentIndex = text.indexOf(variation, startingPoint);
      if (currentIndex > -1 && (currentIndex < indexNum || indexNum < 0))
      {
        indexNum = currentIndex;
      }
    }
    return indexNum;
  }
  
  private static String extractPassage(String text, PassageIndex index, int nextIndex)
  {
    String passage;
    int passageIndex = index.get();
    if (nextIndex != -1)
    {
      passage = text.substring(passageIndex, nextIndex);
    }
    else // For the final chapter
    {
      passage = text.substring(passageIndex);
    }
    return passage;
  }
  
  public static int countChar(String fullText, String textToCount)
  {
    int numCharInText = fullText.length();
    int numAfterReplace = fullText.replace(textToCount,"").length();
    
    return ((numCharInText - numAfterReplace) / textToCount.length()) + 1;
  }
  
  
  
//  public static void main(String[] args)
//  {
//    String testy = "A";
//    String testy2 = lowerOrUpperCase(testy);
//    System.out.println(testy2);
//
//  }
}