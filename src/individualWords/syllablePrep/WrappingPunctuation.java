package individualWords.syllablePrep;

public class WrappingPunctuation
{
  
  static String noPunctuation = "[a-zA-Z\\d]";
  
  private static String removeBeginningPunctuation(String wordToConvert)
  {
    String word = wordToConvert;
    
    // As long as the first character is not an alphanumeric character, replace the word with a version without that
    // first character.
    while (!String.valueOf(word.charAt(0)).matches(noPunctuation))
    {
      word = word.substring(1);
    }
    
    return word;
  }
  
  private static String removeEndingPunctuation(String wordToConvert)
  {
    String word = wordToConvert;
    
    // As long as the last character is not an alphanumeric character, replace that last character with emptiness.
    while (!String.valueOf(word.charAt(word.length()-1)).matches(noPunctuation))
    {
      word = word.replaceFirst(".$", "");
    }
    
    return word;
  }
  
  public static String removeWrappingPunctuation(String wordToConvert)
  {
    String word = wordToConvert;
    
    word = removeBeginningPunctuation(word);
    word = removeEndingPunctuation(word);
    
    return word;
  }

  public static void main(String[] args)
  {
    String test = "(kirby)";
    
    removeWrappingPunctuation(test);
  }

}