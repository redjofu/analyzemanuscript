package readability;

class FleschKincaid
{
  static float calculateFleschKincaid(int sentencesNum, int wordsNum, int syllablesNum)
  {
    float sentences = sentencesNum;
    float words = wordsNum;
    float syllables = syllablesNum;
    
    float fleschKincaid = (0.39F*(words / sentences)) + (11.8F*(syllables/words)) - 15.59F;
    
    return fleschKincaid;
  }
  
  static float calculateFlesch(int sentencesNum, int wordsNum, int syllablesNum)
  {
    float sentences = sentencesNum;
    float words = wordsNum;
    float syllables = syllablesNum;
    
    float flesch = 206.835F - (1.015F*(words/sentences)) - (84.6F*(syllables/words));
    
    return flesch;
  }

  public static void main(String[] args)
  {
    System.out.println(calculateFleschKincaid(15, 292, 357));
    System.out.println(calculateFlesch(15, 292, 357));

  }

}
