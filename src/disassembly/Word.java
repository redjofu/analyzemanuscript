package disassembly;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import individualWords.syllablePrep.WrappingPunctuation;

public class Word
{
  private static boolean showSysout = false;

  public static String[] tokenizeParagraph(String sentence) throws IOException
  {
    // This uses the Apache OpenNLP library to parse the sentence into tokens.
    InputStream iS = new FileInputStream("C:\\Users\\jeffl\\eclipse-workspace\\opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin");
    TokenizerModel model = new TokenizerModel(iS);

    // load the model
    TokenizerME tokenizer = new TokenizerME(model);

    // detect sentences in the paragraph
    String tokens[] = tokenizer.tokenize(sentence);
    iS.close();
    
    return tokens;
  }
  
  public static String[][] splitTokensIntoWordsAndPunctuation(String[] tokenList) throws IOException
  {  
    // Only used for debugging purposes
    if (showSysout == true)
    {
      System.out.println("Number of tokens: " + tokenList.length);
    }
    
    // This is how I determine whether I am qualifying a token as a "word" or not. First, I determine how many of the
    // tokens qualify as words.
    String alphaNumeric = "^.*[a-zA-Z0-9]+.*$";
    int totalWords = 0;
    for(String token : tokenList)
    {
      if (token != null && token.matches(alphaNumeric))
      {
        totalWords++;
      }
    }
    
    // The number of non-word tokens (punctuation) is the number that's left over.
    int totalPunctuation = tokenList.length - totalWords;
    
    // Since I know how many words and non-words there are, I can create arrays of those sizes.
    String wordList[] = new String[totalWords];
    String punctuationList[] = new String[totalPunctuation];
    
    // Now I need to iterate through the tokens and place them into their respective word/punctuation arrays.
    int wordIndex = 0;
    int punctuationIndex = 0;
    for(String token : tokenList)
    {
      if (token != null && token.matches(alphaNumeric))
      {
        wordList[wordIndex++] = WrappingPunctuation.removeWrappingPunctuation(token);
      }
      else
      {
        punctuationList[punctuationIndex++] = token;
      }
    }
    
    // Used for debugging purposes
    if (showSysout == true)
    {
      System.out.println("Number of Words: " + wordList.length);
      
      for(int i=0;i<wordList.length;i++)
      {
        System.out.println("#" + i + ": " + wordList[i]);
      }
      
      System.out.println("Number of Punctuation Marks: " + punctuationList.length);
      
      for(int i=0;i<punctuationList.length;i++)
      {
        System.out.println("#" + i + ": " + punctuationList[i]);
      }
    }

    String[][] splitTokens = {wordList, punctuationList};
    return splitTokens;
  }
  
  public static void main(String[] args) throws IOException
  {
    String sampleSentence = "Following are the steps to be followed to write a program which detects the positions of the sentences from the given raw text.";
    String sampleSentence2 = "The figure lunges toward me, and I scream—the full-on blood-curdling kind, shriller than any I’ve ever released.";
    String sampleSentence3 = "I shift my attention to her, matching the intensity in her gaze. “Oh, acting like I’m part of the group now?” My eyes dart around the room again. “I’m just keeping a lookout. I saw the shadowman around here, remember? Can you blame me?”";
    
    // Note, for debugging purposes, I was using the addSpacesAroundDashes method from the chapter.java class. I'm done
    // debugging that, so I've removed it, but if needed again, that's where it's found.
//    sampleSentence2 = addSpacesAroundDashes(sampleSentence2);
    
    String tokenizedSample[] = tokenizeParagraph(sampleSentence3);

    splitTokensIntoWordsAndPunctuation(tokenizedSample);
  }
}
