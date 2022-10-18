package individualWords.syllablePrep;

public class SyllablePreparation
{

  public static String prepareForSyllables(String wordToPrepare)
  {
    String word = wordToPrepare;
    
    // Remove any non-alphanumeric characters from the beginning or end of the word.
    word = WrappingPunctuation.removeWrappingPunctuation(word);
    
    // Change numbers into full words. This doesn't always work perfectly, but it does get it to the point where it's 
    // going to recognize something like "105" as more than a single word without any vowels.
    word = NumbersToWords.convertNumbersIntoWords(word);
    
    word = Acronyms.detectAcronyms(word); 
    word = word.toLowerCase();
    word = Abbreviations.convertAbbreviations(word);  
    word = SingleW.replaceSingleW(word);
    word = Dehyphen.dehyphen(word);
    
    return word;
  }
  
  public static void main(String[] args)
  {
    String test = "WD-40";
    String test2 = prepareForSyllables(test);
    System.out.println(test2);
  }
}
