package individualWords.syllablePrep;

public class SyllablePreparation
{

  public static String prepareForSyllables(String wordToPrepare)
  {
    String word = wordToPrepare;
    
    word = WrappingPunctuation.removeWrappingPunctuation(word);
//    System.out.println("WrappingPunctuation: " + word);
    
    word = NumbersToWords.convertNumbersIntoWords(word);
//    System.out.println("NumbersToWords: " + word);
    
    word = Acronyms.detectAcronyms(word);
//    System.out.println("Acronyms: " + word);
    
    word = word.toLowerCase();
//    System.out.println("toLowerCase: " + word);
    
    word = Abbreviations.convertAbbreviations(word);
//    System.out.println("Abbreviations: " + word);
    
    word = SingleW.replaceSingleW(word);
//    System.out.println("SingleW: " + word);
    
    word = Dehyphen.dehyphen(word);
//    System.out.println("Dehyphen: " + word);
    
    return word;
  }
  
  public static void main(String[] args)
  {
    String test = "WD-40";
    
    String test2 = prepareForSyllables(test);
    
    System.out.println(test2);

  }

}
