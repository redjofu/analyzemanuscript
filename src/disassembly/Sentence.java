package disassembly;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Sentence
{
  static boolean showSysout = false;
  
//  static String sampleParagraph = "She went to the open door and stood in it and looked out among the tomato vines and “jimpson” weeds that constituted the garden. No Tom. So she lifted up her voice at an angle calculated for distance and shouted:";
  
//  final private static String[] waysToEndSentence = 
//  {
//    ".",
//    "!",
//    "?"
//    /* Regardless of how the paragraph ends, everything after the final "sentence" is also considered a sentence.
//     * So if the paragraph ends with a colon, a comma, or no punctuation at all, it's considered the end of a
//     * sentence. 
//     */
//  };
  
//  private static int countNumSentences(String paragraph, String wayToEndSentence)
//  {
//    int numCharInParagraph = paragraph.length();
//    int numAfterReplace = paragraph.replace(wayToEndSentence,"").length();
//    
////    return ((numCharInParagraph - numAfterReplace) / wayToEndSentence.length()) + 1;
//    return ((numCharInParagraph - numAfterReplace) / wayToEndSentence.length());
//  }
  
//  private static int countTotalSentences(String paragraph)
//  {
//    int counter = 0;
//    
//    for (String thisWay : waysToEndSentence)
//    {
//      counter += countNumSentences(paragraph, thisWay);
//      
//      System.out.println("Counting sentences using " + thisWay);      
//      System.out.println("Counter is currently at " + counter);
//    }
//    
//    return counter + 1;
//  }
  
//  static String[] separateParagraphToSentences(String paragraph)
//  {
//    String[] sentences = new String[countTotalSentences(paragraph)];
//    
//    int paragraphIndex = 0;
//    
////    for (int i=0; i<sentences.length; i++)
////    {
////      if (i < sentences.length - 1)
////      {
////        sentences[i] = paragraph.substring(paragraphIndex, paragraph.indexOf(newLineChar, paragraphIndex));    
////      }
////      else
////      {
////        sentences[i] = paragraph.substring(paragraphIndex, paragraph.length());
////      }
////
////      paragraphIndex = paragraph.indexOf(newLineChar, paragraphIndex) + newLineChar.length();    
////      
////      System.out.println("Sentence " + (i+1) + "(Length: " + sentences[i].length() + ") – " + sentences[i]);
////    }
//    
//    return sentences;
//  }
  
//  static void toyingAround()
//  {
//    System.out.println(countTotalSentences(sampleParagraph));
//  }
  
  static String[] separateParagraphToSentences(String paragraph) throws IOException
  {
//    SentenceModel model;
//    try (InputStream modelIn = new FileInputStream("en-sent.bin")) {
//      model = new SentenceModel(modelIn);
//    } 
//    finally
//    {
//      System.out.println("Failed");
//    }
//    SentenceModel model = new SentenceModel("en-sent.bin");
    
//    String paragraph = "Apache openNLP supports the most common NLP tasks, such as tokenization, sentence segmentation, part-of-speech tagging, named entity extraction, chunking, parsing, and coreference resolution. These tasks are usually required to build more advanced text processing services. OpenNLP also includes maximum entropy and perceptron based machine learning.";
//    String paragraph = samplePar;
    
    // refer to model file "en-sent,bin", available at link http://opennlp.sourceforge.net/models-1.5/
    InputStream iS = new FileInputStream("C:\\Users\\jeffl\\eclipse-workspace\\opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin");
    SentenceModel model = new SentenceModel(iS);

    // load the model
    SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);

    // detect sentences in the paragraph
    String sentences[] = sentenceDetector.sentDetect(paragraph);
    iS.close();
    
//    
    if (showSysout == true)
    {
      for(int i=0;i<sentences.length;i++)
      {
        System.out.println(sentences[i]);
      }
    }

  
    
    return sentences;
    
    

//    return sentences;
//    
//    
//    
//    
//    
//    SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
//    
//    String sentences2[] = sentenceDetector.sentDetect("Hello threre. I'm a person.");
  }
  
  public static void main(String[] args) throws IOException
  {
    String sampleParagraph2 = "My mind strains at the specifics of the memory, desperate to remember how any of the functionality works. And then I remember. My fingers tickle the fibers on the underside of each sleeve, beginning at the elbow out to the wrist. The motion activates microbulbs embedded at the cuffs below my wrists. And voila! Light! The beam isn’t particularly strong, but that’s to be expected with lumitech so small it’s embedded in clothing.";
//    toyingAround();
//    String paragraphs[] = Paragraph.separateChapterToParagraphs(Chapter.sampleChapter());
    separateParagraphToSentences(sampleParagraph2);
//    sentencer(paragraphs[20]);

  }

}
