<<<<<<< HEAD
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
=======
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
    
//    
//    word = word.replace("acct", "accountant");
//    word = word.replace("appt", "appointment");
//    word = word.replace("approx", "approximately");
//    word = word.replace("asst", "assistant");
//    word = word.replace("blvd", "boulevard");
//    word = word.replace("cm", "centimeter");
//    word = word.replace("cyn", "canyon");
//    word = word.replace("dept", "department");
//    word = word.replace("dr", "doctor");
//    word = word.replace("est", "established");
//    word = word.replace("iii", "the-third");
//    word = word.replace("ii", "the-second");
//    word = word.replace("jr", "junior");
//    word = word.replace("kg", "kilogram");
//    word = word.replace("ltd", "limited");
//    word = word.replace("mg", "milligram");
//    word = word.replace("mph", "miles-per-hour");
//    word = word.replace("mrs", "misses");
//    word = word.replace("mr", "mister");
//    word = word.replace("sra", "senora");
//    word = word.replace("sr", "senior");
//    word = word.replace("tbsp", "tablespoon");
//    word = word.replace("tsp", "teaspoon");
//    word = word.replace("vs", "versus");
    
    return word;
  }
  
  public static void main(String[] args)
  {
    String test = convertAbbreviations("mg");
    System.out.println(test);

  }

}
>>>>>>> branch 'main' of https://github.com/redjofu/analyzemanuscript.git
