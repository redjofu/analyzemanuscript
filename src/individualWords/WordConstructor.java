package individualWords;

import individualWords.syllablePrep.SyllablePreparation;
import java.text.Normalizer;

public class WordConstructor
{
  String normalized;
  String syllablePrep;
  int syllables;
  
  public WordConstructor(String word) {
    normalized = Normalizer.normalize(word, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
//    System.out.println(normalized);
    syllablePrep = SyllablePreparation.prepareForSyllables(normalized);
    syllables = Syllables.countSyllables(syllablePrep);
    
  }

  public static void main(String[] args)
  {
    String testWord = "officially";
    WordConstructor test = new WordConstructor(testWord);
    
    System.out.println(testWord);
    System.out.println("normalized: " + test.normalized);
    System.out.println("syllablePrep: " + test.syllablePrep);
    System.out.println("syllables: " + test.syllables);

  }

}
