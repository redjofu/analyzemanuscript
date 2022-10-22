package individualWords.syllablePrep;

class Abbreviations
{
  private static String checkAndConvertAbbreviations(String wordToConvert, String abbreviation, String fullWord)
  {
    String word = wordToConvert;
    
    if (word.equals(abbreviation))
    {
      word = word.replace(abbreviation, fullWord);
    }
    
    return word;
  }
  
  static String convertAbbreviations(String wordToConvert)
  {
    String word = wordToConvert;
    
    word = checkAndConvertAbbreviations(word, "acct", "accountant");
    word = checkAndConvertAbbreviations(word, "appt", "appointment");
    word = checkAndConvertAbbreviations(word, "approx", "approximately");
    word = checkAndConvertAbbreviations(word, "asst", "assistant");
    word = checkAndConvertAbbreviations(word, "blvd", "boulevard");
    word = checkAndConvertAbbreviations(word, "cm", "centimeter");
    word = checkAndConvertAbbreviations(word, "cyn", "canyon");
    word = checkAndConvertAbbreviations(word, "dept", "department");
    word = checkAndConvertAbbreviations(word, "dr", "doctor");
    word = checkAndConvertAbbreviations(word, "est", "established");
    word = checkAndConvertAbbreviations(word, "iii", "the-third");
    word = checkAndConvertAbbreviations(word, "ii", "the-second");
    word = checkAndConvertAbbreviations(word, "jr", "junior");
    word = checkAndConvertAbbreviations(word, "kg", "kilogram");
    word = checkAndConvertAbbreviations(word, "ltd", "limited");
    word = checkAndConvertAbbreviations(word, "mg", "milligram");
    word = checkAndConvertAbbreviations(word, "mph", "miles-per-hour");
    word = checkAndConvertAbbreviations(word, "mrs", "misses");
    word = checkAndConvertAbbreviations(word, "mr", "mister");
    word = checkAndConvertAbbreviations(word, "sra", "senora");
    word = checkAndConvertAbbreviations(word, "sr", "senior");
    word = checkAndConvertAbbreviations(word, "tbsp", "tablespoon");
    word = checkAndConvertAbbreviations(word, "tsp", "teaspoon");
    word = checkAndConvertAbbreviations(word, "vs", "versus");
    
    // Better suited for acronym class, but won't be picked up there because it's lower-case
    word = checkAndConvertAbbreviations(word, "www", "-w-w-w-");
    
    return word;
  }
  
  public static void main(String[] args)
  {
    String test = convertAbbreviations("mg");
    System.out.println(test);
  }
}
