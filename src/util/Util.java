package util;

import manuscript.Chapter;

public class Util
{
  
  // This method just determines if a word is in ALL CAPS (potentially an acronym) and, if so, allows to remain that
  // way. Otherwise, it makes the word lower-case. I needed to use this in more that one package, so I set it aside
  // in a separate utility package and class. Presumably I'll end up using this package and class more later, but for
  // now, I just have one method here.
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
  
  public static String addNextPassage(String text, int index, int nextIndex)
  {
    String passage;
    if (nextIndex != -1)
    {
      passage = text.substring(index, nextIndex);
    }
    else // For the final chapter
    {
      passage = text.substring(index);
    }
    index = nextIndex;
    return passage;
  }
  
  public static void main(String[] args)
  {
    String testy = "A";
    String testy2 = lowerOrUpperCase(testy);
    System.out.println(testy2);

  }
}