package individualWords;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Syllables
{
  private static boolean allowPrintln = false;
  
//  public static String sampleSentence[] = 
//  {
//    "The",
//    "figure",
//    "lunges",
//    "toward",
//    "me",
//    "and",
//    "I",
//    "scream",
//    "the",
//    "full",
//    "on",
//    "blood-curdling",
//    "kind",
//    "shriller",
//    "than",
//    "any",
//    "I’ve",
//    "ever",
//    "released"
//  };
  
  private static int countVowels(String word)
  {
    Pattern pattern = Pattern.compile("[aeiou]");
    Matcher matcher = pattern.matcher(word);
    
    long matches = matcher.results().count();
    
    if(allowPrintln == true)
    {
      System.out.println("Number of vowels for " + word + ": " + matches);
    }

    
    return (int)matches;
  }
  
  private static int countYAtEndOfWord(String word)
  {
    Pattern pattern = Pattern.compile("[y]$");
    Matcher matcher = pattern.matcher(word);
    
    long matches = matcher.results().count();
    
    if(allowPrintln == true)
    {
      System.out.println("Number of \"y\" at end of word: " + matches);
    }
    
    return (int)matches;
  }
  
  private static int countYBetweenConsonants(String word)
  {
    Pattern pattern = Pattern.compile("[bcdfghjklmnpqrstvwxz][y][bcdfghjklmnpqrstvwxz]");
    Matcher matcher = pattern.matcher(word);
    
    long matches = matcher.results().count();
    
    if(allowPrintln == true)
    {
      System.out.println("Number of \"y\" between consonants: " + matches);
    }
      
    return (int)matches;
  }
  
  private static int checkSilentE(String word, int currentCount)
  {
    int isSilentEPresent = 0;
    
    Pattern silentE = Pattern.compile("e$|es$|ed$");                            // Example: make
    Matcher silentEMatcher = silentE.matcher(word);
//    counter += silentEMatcher.results().count();
    
    Pattern exceptionsToSilentE = Pattern.compile("ges$|le$|les$|led$|[aeiou]e$|[aeiou]ed$|[aeiou]es$");     
    Matcher exceptionsMatcher = exceptionsToSilentE.matcher(word);
    /* Examples:
     * ges = lunges
     * le,les,led = responsible
     * [aieou]e,ed,es = funnies (these are removed instead in the diphthong section)
     */
//    
//    Pattern ges = Pattern.compile("ges$");                                      // Example: lunges
//    Matcher gesMatcher = ges.matcher(word);
////    counter += exceptionGesMatcher.results().count();
//    
//    Pattern le = Pattern.compile("le$|led$|led$");                              // Example: responsible
//    Matcher leMatcher = le.matcher(word);
////    counter += exceptionGesMatcher.results().count();
//    
//    Pattern vowelE = Pattern.compile("[aeiou]e$|[aeiou]ed$|[aeiou]es$");        // Example: funnies (removed instead in
//    Matcher vowelEmatcher = vowelE.matcher(word);                               //    dipthong section)
    
    Pattern exceptionsToExceptions = Pattern.compile("[aeiouy]le$|[aeiouy]led$|[aeiouy]les$"); 
    Matcher exceptionsExceptionsMatcher = exceptionsToExceptions.matcher(word);
    /* Examples:
     * [aeiouy]les$ = while, style
     */

    Pattern silentEInMiddleOfWord = Pattern.compile("^ninet");
    Matcher middleMatcher = silentEInMiddleOfWord.matcher(word);
    /* Examples:
     * ^ninet = nineteen
     */
    
    
    
    // Check for silent E
    if (silentEMatcher.find())
    {
      isSilentEPresent = 1;
      
      if(allowPrintln == true)
      {
        System.out.println("Silent E Found");
      }
        
      // Check for exception to silent E (i.e. not actually silent)
      if (exceptionsMatcher.find())
      {
        isSilentEPresent = 0;
        
        if(allowPrintln == true)
        {
          System.out.println("Silent E Exception Found");
        }
          
        // Check for exceptions to the exceptions
        if (exceptionsExceptionsMatcher.find())
        {
          isSilentEPresent = 1;
          
          if(allowPrintln == true)
          {
            System.out.println("Exception to Exception Found");
          }
        }
      }
    }
    else if (middleMatcher.find())
    {
      isSilentEPresent = 1;
    }
    
    // If the current vowel count is only 1 (i.e. "me" or "be")
    if (currentCount <= 1)
    {
      isSilentEPresent = 0;
    }
    
    if(allowPrintln == true)
    {
      System.out.println("Number of silent e: " + isSilentEPresent);
    }
    
    return isSilentEPresent;
  }
  
  private static int countDiphthongs(String word)
  { 
    Pattern pattern = Pattern.compile("a[aeiou]|e[aeiu]|i[ei]|o[eiou]|u[eiu]");
    Matcher matcher = pattern.matcher(word);
    
    long counter = matcher.results().count();
    
    // Exceptions to the above rules
    Pattern exceptionsTwoSyllables = Pattern.compile("^reapp|pean$|peans$|^ree|lue|dui|lui|quie|quir");
    Matcher twoSylMatcher = exceptionsTwoSyllables.matcher(word);
    /* Examples:
     * ^reapp = reapply
     * pean$ = European
     * ^ree = reelect
     * lue = influence
     * dui = conduit
     * lui = fluid
     * quie = acquiesce
     * quir = acquire
     */
    counter -= twoSylMatcher.results().count(); // They're not actually diphthongs.
    
    Pattern exceptionsOneSyllable = Pattern.compile("cia|rlia|qua|quo|luo|buo|quee|ree[a-z]$|ree[a-z]s$");
    Matcher oneSylMatcher = exceptionsOneSyllable.matcher(word);
    /* Examples:
     * cia = musician
     * rlia = parliament
     * qua = quad
     * quo = quote
     * luo = fluoride
     * buo = buoyant
     * quee = queen
     * ree[a-z] = reed
     */
    counter += oneSylMatcher.results().count(); // They're actually diphthongs.
    
    if(allowPrintln == true)
    {
      System.out.println("Number of diphthongs: " + counter);
    }
    
    return (int)counter;
  }
  
//  private static int countTripleVowel(String word)
//  {
//    /* Note: there are no true "triphthongs" in standard English which would count as a single syllable, so that does
//     * not need to be considered. However, there are some words with three vowels in succession (e.g. "gaia"), and this 
//     * accounts for that. */
//    
//    Pattern pattern = Pattern.compile("[aeiou][aeiou][aeiou]");
//    Matcher matcher = pattern.matcher(word);
//    
//    long matches = matcher.results().count();
//    
//    System.out.println("Number of triple vowels: " + matches);
//    
//    return (int)matches;
//  }
  
  private static int checkMc(String word)
  {
    if (word.length() > 1)
    {
      String mc = "mc";
      String firstTwoChar = String.valueOf(word.charAt(0) + String.valueOf(word.charAt(1)));
      if (firstTwoChar.equals(mc))
      {
        if (allowPrintln == true)
        {
          System.out.println("Mc present");
        }
        return 1;
      }
    }
    return 0;
  }
  
  private static int checkPluralS(String word)
  {
    if (word.length() > 2)
    {
      String apostropheS = "s's|s’s";
      String lastThreeChar = String.valueOf(word.charAt(word.length()-3) + 
          String.valueOf(word.charAt(word.length()-2)) + String.valueOf(word.charAt(word.length()-1)));
//      System.out.println("lastThreeChar: " + lastThreeChar);
      
      if (lastThreeChar.matches(apostropheS))
      {
        if (allowPrintln == true)
        {
          System.out.println("'s present");
        }
        return 1;
      }      
    }
    return 0;
  }
  
  private static int countTokenSyllables(String token)
  {
    int counter = 0;
    
    counter += countVowels(token);
    counter += countYAtEndOfWord(token);
    counter += countYBetweenConsonants(token);
    counter -= checkSilentE(token, counter);
    counter -= countDiphthongs(token);
    counter += checkMc(token);
    counter += checkPluralS(token);
//    counter += countTripleVowel(lowercaseWord);
    
    // For non-vowels words like pfft, shh, hmm, or crwth
    if (counter == 0) {
      counter = 1;
    }
    
    if(allowPrintln == true)
    {
      System.out.println("Number of syllables: " + counter + "\n");
    }
    
    return counter;
  }
  
  public static int countSyllables(String word)
  {
//    String lowercaseWord = word.toLowerCase();
    
    int counter = 0;
    
//    counter += countVowels(word);
//    counter += countYAtEndOfWord(word);
//    counter += countYBetweenConsonants(word);
//    counter -= checkSilentE(word, counter);
//    counter -= countDiphthongs(word);
//    counter += checkMc(word);
////    counter += countTripleVowel(lowercaseWord);
//    
//    // For non-vowels words like pfft, shh, hmm, or crwth
//    if (counter == 0) {
//      counter = 1;
//    }
    
//    String delimeter = "\\\\W|_";
    String delimiter = "-";
    Scanner sc = new Scanner(word);
    sc.useDelimiter(delimiter);
    
    while (sc.hasNext())
    {
      counter += countTokenSyllables(sc.next());
    }
    sc.close();
    
    if(allowPrintln == true)
    {
      System.out.println("Number of syllables: " + counter + "\n");
    }
    
    return counter;
  }
  

  public static void main(String[] args)
  {
//    for(int i=0; i<sampleSentence.length; i++)
//    {
//      System.out.println(countSyllables(sampleSentence[i]) + " - " + sampleSentence[i]);
//    }

    
    
    System.out.println(countSyllables("b-i-l-l-y"));
    
  }

}
