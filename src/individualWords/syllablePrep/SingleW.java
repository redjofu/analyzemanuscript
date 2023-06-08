package individualWords.syllablePrep;

class SingleW
{
  static String spokenW = "-double-u-";
  
  static String replaceSingleW(String wordToConvert)
  {
    String word = wordToConvert;
    
    if (word.equals("w"))
    {
      word = spokenW;
    }
    else if (word.contains("-w-"))
    {
      word = word.replaceAll("-w-", spokenW);
    }
    
    return word;
  }
  
  public static void main(String[] args)
  {
    String test = "-w-";
    
    String test2 = replaceSingleW(test);
    
    System.out.println(test2);
  }
}