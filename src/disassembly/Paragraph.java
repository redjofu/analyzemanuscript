package disassembly;

import sampleBooks.TomSawyer;

public class Paragraph
{
  private static String newLineChar = "\r\n";
  
  private static int countNumParagraphs(String chapter)
  {
    int numCharInChapter = chapter.length();
    int numAfterReplace = chapter.replace(newLineChar,"").length();
    
    return ((numCharInChapter - numAfterReplace) / newLineChar.length()) + 1;
  }
  
  static String[] separateChapterToParagraphs(String chapter)
  {
    // Setting up the array. I know how many paragraphs there will be based on how many line breaks there are.
    String[] paragraphs = new String[countNumParagraphs(chapter)];
    
    // A paragraph is determined by all of the words between line breaks. This goes through the chapter, grabbing all
    // the text up to the next line break. It uses the chapterIndex variable to remember where the last paragraph left
    // off.
    int chapterIndex = 0;
    for (int i=0; i<paragraphs.length; i++)
    {
      if (i < paragraphs.length - 1) // If there are at least two paragraphs left
      {
        paragraphs[i] = chapter.substring(chapterIndex, chapter.indexOf(newLineChar, chapterIndex));    
      }
      else // If this is the last paragraph
      {
        paragraphs[i] = chapter.substring(chapterIndex, chapter.length());
      }

      // The chapterIndex value needs to be adjusted after each paragraph so the next iteration in the loop knows
      // where to begin the next paragraph.
      chapterIndex = chapter.indexOf(newLineChar, chapterIndex) + newLineChar.length();  
    }
    
    return paragraphs;
  }

  public static void main(String[] args)
  {
    String chapter = TomSawyer.firstChapter;
    separateChapterToParagraphs(Chapter.prepareChapter(chapter));
  }

}