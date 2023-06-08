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
    
    // Check if the word is an acronym and, if so, format it so that each letter is pronounced individually.
    word = Acronyms.detectAcronyms(word);
    
    // The later methods require the word to be in all lower-case to determine syllable count. However, this can't
    // be done before the detectAcronyms method since that method depends on knowing whether a word is in ALL CAPS.
    word = word.toLowerCase();
    
    // Check through a short list of abbreviations and convert to full words (e.g. mr --> mister).
    word = Abbreviations.convertAbbreviations(word);
    
    // This method replaces "w" with "double-u." I couldn't think of a more appropriate place to do that, so I made it
    // its own method.
    word = SingleW.replaceSingleW(word);
    
    // Several of these methods add hyphens around individual letters or words. This method removes those unnecessary
    // hyphens.
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