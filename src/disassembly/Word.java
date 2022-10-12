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
    InputStream iS = new FileInputStream("C:\\Users\\jeffl\\eclipse-workspace\\opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin");
    TokenizerModel model = new TokenizerModel(iS);

    // load the model
    TokenizerME tokenizer = new TokenizerME(model);

    // detect sentences in the paragraph
    String tokens[] = tokenizer.tokenize(sentence);
    iS.close();
    
//    for(int i=0;i<tokens.length;i++)
//    {
//      System.out.println(tokens[i]);
//    }
  
    
    return tokens;
  }
  
  public static String[][] splitTokensIntoWordsAndPunctuation(String[] tokenList) throws IOException
  {
//    String sampleSentence2 = "The figure lunges toward me, and I scream—the full-on blood-curdling kind, shriller than any I’ve ever released.";
//    sampleSentence2 = addSpacesAroundDashes(sampleSentence2);
//    String sample[] = tokenizeParagraph(sampleSentence2);
//    
//    String tokenList[] = tokenList2;
//    tokenList = sample;
    
    if (showSysout == true)
    {
      System.out.println("Number of tokens: " + tokenList.length);
    }
    
    
    
//    String alphaNumeric = "^[a-zA-Z0-9]*$";
    String alphaNumeric = "^.*[a-zA-Z0-9]+.*$";
    
    
    int totalWords = 0;
    
    for(String token : tokenList)
    {
      if (token != null && token.matches(alphaNumeric))
      {
        totalWords++;
      }
    }
    
    int totalPunctuation = tokenList.length - totalWords;
    
    String wordList[] = new String[totalWords];
    String punctuationList[] = new String[totalPunctuation];
    
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
  
//  public static String[] separateParagraphToSentences(String wordsAndPunctuation)
//  {
//    
//  }
  
  /* This is not for permanent use and is just here for convenience. Actual method is somewhere else, I think in chapter.java. */
  private static String addSpacesAroundDashes(String chapter)
  {
    // Replace em dash with en dash
    chapter = chapter.replace("—", "–");
    
    // Add spaces around en dash. It's okay if extra spaces are created as they'll be removed later.
    chapter = chapter.replace("–", " – ");
    
//    System.out.println(chapter);
    
    return chapter;
  } 
  
  public static void main(String[] args) throws IOException
  {
    String sampleSentence = "Following are the steps to be followed to write a program which detects the positions of the sentences from the given raw text.";
    String sampleSentence2 = "The figure lunges toward me, and I scream—the full-on blood-curdling kind, shriller than any I’ve ever released.";
    String sampleSentence3 = "I shift my attention to her, matching the intensity in her gaze. “Oh, acting like I’m part of the group now?” My eyes dart around the room again. “I’m just keeping a lookout. I saw the shadowman around here, remember? Can you blame me?”";
    
    sampleSentence2 = addSpacesAroundDashes(sampleSentence2);
    
//    separateParagraphToSentences(sampleSentence2);
    String tokenizedSample[] = tokenizeParagraph(sampleSentence3);
    
    
    splitTokensIntoWordsAndPunctuation(tokenizedSample);
  }

}
