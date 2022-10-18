package individualWords.syllablePrep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NumbersToWords
{
  
  private static String convertNumberToWords(String number)
  {
    String word = "";
    
    if (number.length() == 4 && number.charAt(1) != '0' && number.charAt(2) != '0')
    {
      // If the number has exactly four digits, I treat it different as thought it's a year. The exception is if the
      // middle two digits are zeroes. The reasoning for this is that most years are pronounced separating the year
      // into two sets of words. So 1984 is pronounced "nineteen eighty-four" instead of "one thousand, nine hundred,
      // eighty-four." However, a year like 2009 doens't follow this pronunciation pattern.
      word = convertYearToWords(number);
    }
    else if (number.length() > 1)
    {
      int tensPlace = number.length()-2;
      int currentPlace = 1; // Starting from lower level. 1 == ones place, 2 == tens place, 3 == hundreds place, etc.
      int forLoopStartingPoint = number.length()-1;
      
      if (number.length() >= 2 && (number.charAt(tensPlace) == '1' || number.charAt(tensPlace) == '0'))
      {        
        forLoopStartingPoint -= 2;
        currentPlace = 3;
        word = replaceTeenWithWords(number, tensPlace);
      }
      
      for (int i = forLoopStartingPoint; i > -1; i--)
      {
        String currentNumber = String.valueOf(number.charAt(i));
        
        if (currentPlace == 1 && !currentNumber.equals("0"))
        { 
          word = replaceNumbersWithWords(currentNumber); 
        }
        else if (!currentNumber.equals("0"))
        {
          if (currentPlace == 2) { word = replaceTensPlaceWithWords(currentNumber) + word; }
          else if (currentPlace == 3) { word = replaceNumbersWithWords(currentNumber) + "hundred" + word; }
          else if (currentPlace == 4 && number.length() > currentPlace && number.charAt(i) == '1')
          {
            word = replaceTeenWithWords(number, currentPlace-1) + "thousand" + word;
            currentPlace++;
          }
          else if (currentPlace == 4) { word = replaceNumbersWithWords(currentNumber) + "-thousand-" + word; }
          else if (currentPlace == 5) { word = replaceTensPlaceWithWords(currentNumber) + word; }
          else if (currentPlace == 6) { word = replaceNumbersWithWords(currentNumber) + "-hundred-" + word; }
          else if (currentPlace == 7 && number.length() > currentPlace && number.charAt(i) == '1')
          { 
            word = replaceTeenWithWords(number, currentPlace-1) + "million" + word;
            currentPlace++;
          }
          else if (currentPlace == 7) { word = replaceNumbersWithWords(currentNumber) + "-million-" + word; }
          else if (currentPlace == 8) { word = replaceTensPlaceWithWords(currentNumber) + word; }
          else if (currentPlace == 9) { word = replaceNumbersWithWords(currentNumber) + "-hundred-" + word; }         
        }
        else
        {
          if (currentPlace == 4 && Integer.parseInt(number) > 9999) { word = "-thousand-" + word; }
          if (currentPlace == 7 && Integer.parseInt(number) > 9999999) { word = "-million-" + word; }
        }
        currentPlace++;
      }
    }
    else
    {
      // For those times when it's a single-digit number
      word = replaceNumbersWithWords(number);
    }
    
    return word;
  }
  
  private static String convertYearToWords(String year)
  {
    String word = "zero";
    
    // I need to separate a year into two the first two digits and the last two digits. I put in a try/catch here
    // mostly just to try it out... it's probably not necessary as I already check to make sure that there are only 
    // four digits before running the method. Still, there would be a problem if the method is run on something with
    // the wrong number of digits for some strange reason, and this would catch any issues with that and just return
    // the word back without making any changes if so.
    try
    {
      String firstTwoDigits = String.valueOf(year.charAt(0)) + String.valueOf(year.charAt(1));
      String secondTwoDigits = String.valueOf(year.charAt(2)) + String.valueOf(year.charAt(3));
      word = convertNumberToWords(firstTwoDigits) + convertNumberToWords(secondTwoDigits);
    }
    catch (Exception e)
    {
      System.out.println("Error with \"converYearToWords\" method, likely wrong number of digits: " + e); 
    }
    
    return word;
  }
  
  private static String replaceTeenWithWords(String teenWord, int placeToReplace)
  {
    String doubleDigitNumber = String.valueOf(teenWord.charAt(placeToReplace)) + 
    String.valueOf(teenWord.charAt(placeToReplace+1));
    
    return replaceNumbersWithWords(doubleDigitNumber);
  }
  
  private static String replaceNumbersWithWords(String wordWithNumbers)
  {
    String word = wordWithNumbers;
    
    // Double-digits need to come first so it doesn't so something like "-one--oh-" instead of "-ten-."
    word = word.replace("10", "-ten-");
    word = word.replace("11", "-eleven-");
    word = word.replace("12", "-twelve-");
    word = word.replace("13", "-thirteen-");
    word = word.replace("14", "-fourteen-");
    word = word.replace("15", "-fifteen-");
    word = word.replace("16", "-sixteen-");
    word = word.replace("17", "-seventeen-");
    word = word.replace("18", "-eighteen-");
    word = word.replace("19", "-nineteen-");
    word = word.replace("0", "-oh-");
    word = word.replace("1", "-one-");
    word = word.replace("2", "-two-");
    word = word.replace("3", "-three-");
    word = word.replace("4", "-four-");
    word = word.replace("5", "-five-");
    word = word.replace("6", "-six-");
    word = word.replace("7", "-seven-");
    word = word.replace("8", "-eight-");
    word = word.replace("9", "-nine-");
    word = word.replace(".", "-point-");
    
    return word;
  }
  
  private static String replaceTensPlaceWithWords(String tensPlace)
  {
    String word = tensPlace;
    
    word = word.replace("2", "-twenty-");
    word = word.replace("3", "-thirty-");
    word = word.replace("4", "-forty-");
    word = word.replace("5", "-fifty-");
    word = word.replace("6", "-sixty-");
    word = word.replace("7", "-seventy-");
    word = word.replace("8", "-eighty-");
    word = word.replace("9", "-ninety-");
    
    return word;
  }
  
  private static int checkForNumber(String word)
  {
    Pattern digits = Pattern.compile("(\\d)");
    Matcher digitMatcher = digits.matcher(word);
    
    Pattern nondigits = Pattern.compile("(\\D)");
    Matcher nondigitMatcher = nondigits.matcher(word);
    
    int areThereNumbers = 0;
    
    if (digitMatcher.find() && nondigitMatcher.find())
    {
      areThereNumbers = 2;  // Yes, numbers and non-numbers
    }
    else if (digitMatcher.find() && !nondigitMatcher.find())
    {
      if (word.length() < 10) // i.e. one billion or more
      {
        areThereNumbers = 1;  // Yes, numbers only
      }
      else
      {
        areThereNumbers = 2;  // Yes, but over one billion, so treat as though non-numbers included
      }
      
    }
    // I'm not sure why, but single-digit numbers don't match either pattern.
    else if (!digitMatcher.find() && !nondigitMatcher.find())
    {
      areThereNumbers = 2;    // Yes, single digit, so treat as though non-numbers included
    }
    
    return areThereNumbers;
  }
  
  static String convertNumbersIntoWords(String wordToPrep)
  {
    String word = wordToPrep;
    
    int areThereNumbers = checkForNumber(word);
    
    if (areThereNumbers == 2)       // Numbers and words, plus numbers only over 1 billion
    {
      word = replaceNumbersWithWords(word);
    }
    else if (areThereNumbers == 1)  // Numbers only (no words)
    {
      word = convertNumberToWords(word);
    }
    
    return word;
  }

  public static void main(String[] args)
  {
//    convertNumbersIntoWords("400100701");
    String test = convertNumbersIntoWords("1984");
    System.out.println(test);
//    String number = "1234";
//    System.out.println(number.charAt(1));
  }

}
