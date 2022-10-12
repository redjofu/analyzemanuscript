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
    String[] paragraphs = new String[countNumParagraphs(chapter)];
    
    int chapterIndex = 0;
    
    for (int i=0; i<paragraphs.length; i++)
    {
      if (i < paragraphs.length - 1)
      {
        paragraphs[i] = chapter.substring(chapterIndex, chapter.indexOf(newLineChar, chapterIndex));    
      }
      else
      {
        paragraphs[i] = chapter.substring(chapterIndex, chapter.length());
      }

      chapterIndex = chapter.indexOf(newLineChar, chapterIndex) + newLineChar.length();    
      
//      System.out.println("Paragraph " + (i+1) + "(Length: " + paragraphs[i].length() + ") – " + paragraphs[i]);
    }
    
    return paragraphs;
  }
  
  private static void toyingAround()
  {
//    StringBuilder aliceParagraphs = new StringBuilder(Chapter.aliceFirstChapter);
//    
//    System.out.println(aliceParagraphs.indexOf("blah"));
//    
//    System.out.println(aliceParagraphs.indexOf("\r\n"));
//    System.out.println(aliceParagraphs.length());
//    
//    
////    aliceParagraphs.delete(aliceParagraphs.indexOf("\r\n"), aliceParagraphs.length());
//    System.out.println(aliceParagraphs.indexOf("\r\n"));
//    aliceParagraphs = aliceParagraphs.delete(0, aliceParagraphs.indexOf("\r\n"));
//    aliceParagraphs = aliceParagraphs.delete(0, aliceParagraphs.indexOf("\r\n"));
//    aliceParagraphs = aliceParagraphs.delete(0, aliceParagraphs.indexOf("\r\n"));
//    aliceParagraphs = aliceParagraphs.delete(0, aliceParagraphs.indexOf("\r\n"));
//    aliceParagraphs =  aliceParagraphs.delete(0, aliceParagraphs.indexOf("\r\n"));
//    aliceParagraphs =  aliceParagraphs.delete(0, aliceParagraphs.indexOf("\r\n"));
//    
//    System.out.println(aliceParagraphs);
//    System.out.println(aliceParagraphs.indexOf("\r\n"));
//    
//    
////    Chapter firstChapter = new Chapter();
//    
//    StringBuilder[] paragraphs;
//    
//    paragraphs.
    
//    paragraphs.add("hello");
    
//    aliceParagraphs.delete(20,)
    
    
    
//    System.out.println(firstChapter.aliceFirstChapter);
  }
  

  public static void main(String[] args)
  {

//    toyingAround();
    String chapter = TomSawyer.firstChapter;
    separateChapterToParagraphs(Chapter.prepareChapter(chapter));
    
    
//    System.out.println("Hello");
//    System.out.println(countNumParagraphs(Chapter.adjustedChapter));
    

    
//    paragraphs[numParagraphs-1] = "Hello " + (numParagraphs-1);
    
//    System.out.println(paragraphs[numParagraphs-1]);
    
//    System.out.println(numParagraphs);
    
//    System.out.println(chapter.indexOf(newLineChar));
//    
//    String firstParagraph = chapter.substring(0, chapter.indexOf(newLineChar, 0));
//    
//    System.out.println(firstParagraph);
//    
//    String secondParagraph = chapter.substring(304, chapter.indexOf(newLineChar, 304));
//    
//    System.out.println(secondParagraph);
    

  }

}
