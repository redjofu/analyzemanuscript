package individualWords.syllablePrep;

public class WrappingPunctuation
{
  
  static String noPunctuation = "[a-zA-Z\\d]";
  
  private static String removeBeginningPunctuation(String wordToConvert)
  {
    String word = wordToConvert;
    
    
//    System.out.println(word.charAt(0));
    
    while (!String.valueOf(word.charAt(0)).matches(noPunctuation))
    {
      word = word.substring(1);
//      System.out.println("Removed first character");
    }
    
//    if (!String.valueOf(word.charAt(0)).matches(noPunctuation))
//    {
//      System.out.println("hello");
//    }
    
    return word;
    
  }
  
  private static String removeEndingPunctuation(String wordToConvert)
  {
    String word = wordToConvert;
    
//    System.out.println(word.charAt(word.length()-1));
    
    while (!String.valueOf(word.charAt(word.length()-1)).matches(noPunctuation))
    {
      word = word.replaceFirst(".$", "");
//      System.out.println("Removed last character");
    }
    
    return word;
  }
  
  public static String removeWrappingPunctuation(String wordToConvert)
  {
    String word = wordToConvert;
    
    word = removeBeginningPunctuation(word);
    word = removeEndingPunctuation(word);
    
//    System.out.println(word);
    
    return word;
  }

  public static void main(String[] args)
  {
    String test = "(kirby)";
    
    removeWrappingPunctuation(test);
  }

}
