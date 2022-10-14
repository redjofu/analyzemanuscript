package disassembly;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Sentence
{
  // I use the showSysout variable to help me with debugging, turning some System.out.println lines off and on.
  static boolean showSysout = false;

  static String[] separateParagraphToSentences(String paragraph) throws IOException
  {
    // This utilizes the Apache OpenNLP library to parse sentences. I don't understand a lot of what's going on here...
    // I just followed some instructions.
    
    // refer to model file "en-sent,bin", available at link http://opennlp.sourceforge.net/models-1.5/
    InputStream iS = 
      new FileInputStream("C:\\Users\\jeffl\\eclipse-workspace\\opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin");
    SentenceModel model = new SentenceModel(iS);

    // load the model
    SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);

    // detect sentences in the paragraph
    String sentences[] = sentenceDetector.sentDetect(paragraph);
    iS.close();
    
    // Only used for debugging purposes.
    if (showSysout == true)
    {
      for(int i=0;i<sentences.length;i++)
      {
        System.out.println(sentences[i]);
      }
    }

    return sentences;
  }
  
  public static void main(String[] args) throws IOException
  {
    String sampleParagraph2 = "My mind strains at the specifics of the memory, desperate to remember how any of the functionality works. And then I remember. My fingers tickle the fibers on the underside of each sleeve, beginning at the elbow out to the wrist. The motion activates microbulbs embedded at the cuffs below my wrists. And voila! Light! The beam isn’t particularly strong, but that’s to be expected with lumitech so small it’s embedded in clothing.";
    separateParagraphToSentences(sampleParagraph2);
  }
}
