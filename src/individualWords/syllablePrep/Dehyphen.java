<<<<<<< HEAD
package individualWords.syllablePrep;

class Dehyphen
{

  private static String replaceMultipleHyphens(String word)
  { 
    while (word.contains("--"))
    {
      word = word.replaceAll("--", "-");
    }
    
    return word;
  }
  
  static String dehyphen(String word)
  {
    if (word.contains("-"))
    {
      word = replaceMultipleHyphens(word);
      word = WrappingPunctuation.removeWrappingPunctuation(word);
    }
    
    return word;
  }
  
  public static void main(String[] args)
  {
    String test = "-double-u--double-u--double-u-";
    String test2 = dehyphen(test);
    System.out.println(test2);
  }
}
=======
package individualWords.syllablePrep;

class Dehyphen
{

  private static String replaceMultipleHyphens(String wordToConvert)
  {
    String word = wordToConvert;
    
    while (word.contains("--"))
    {
      word = word.replaceAll("--", "-");
    }
    
    return word;
  }
  
  static String dehyphen(String wordToConvert)
  {
    String word = wordToConvert;
    
    if (word.contains("-"))
    {
      word = replaceMultipleHyphens(word);
      word = WrappingPunctuation.removeWrappingPunctuation(word);
    }
    
    return word;
  }
  
  public static void main(String[] args)
  {
    String test = "-double-u--double-u--double-u-";
    
    String test2 = dehyphen(test);
    
    System.out.println(test2);

  }

}
>>>>>>> branch 'main' of https://github.com/redjofu/analyzemanuscript.git
