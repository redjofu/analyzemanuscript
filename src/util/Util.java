package util;

public class Util
{
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
  
  public static void main(String[] args)
  {
    String testy = "A";
    String testy2 = lowerOrUpperCase(testy);
    System.out.println(testy2);

  }
}
