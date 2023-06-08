<<<<<<< HEAD
package disassembly;
import sampleBooks.*;

public class Chapter
{
  private static String newLineChar = "\r\n";
  
  private static String removeDuplicateLineBreaks(String chapter)
  {
    while (chapter.contains(newLineChar + newLineChar)) 
    {
      chapter = chapter.replace(newLineChar + newLineChar, newLineChar);
    }
    return chapter;
  }
  
  private static String addSpacesAroundDashes(String chapter)
  {
    // Replace em dash with en dash
    chapter = chapter.replace("—", "–");
    
    // Add spaces around en dash. It's okay if extra spaces are created as they'll be removed later.
    chapter = chapter.replace("–", " – ");
    
    return chapter;
  } 
  
  private static String removeDuplicateSpaces(String chapter)
  {
    while (chapter.contains("  "))
    {
      chapter = chapter.replace("  ", " ");
    }
    
    return chapter;
  }
  
  static String prepareChapter(String chapter)
  {
    chapter = removeDuplicateLineBreaks(chapter);
    chapter = addSpacesAroundDashes(chapter);
    chapter = removeDuplicateSpaces(chapter);
    
    return chapter;
  }

  public static void main(String[] args)
  {
    String chapter = TomSawyer.firstChapter; 
    System.out.println(prepareChapter(chapter));
  }

}
=======
package disassembly;
//import sampleBooks.AliceFirstChapter;
import sampleBooks.*;

public class Chapter
{
  private static String newLineChar = "\r\n";
  
  private static String removeDuplicateLineBreaks(String chapter)
  {
    return chapter.replace(newLineChar + newLineChar, newLineChar);
  }
  
  private static String addSpacesAroundDashes(String chapter)
  {
    // Replace em dash with en dash
    chapter = chapter.replace("—", "–");
    
    // Add spaces around en dash. It's okay if extra spaces are created as they'll be removed later.
    chapter = chapter.replace("–", " – ");
    
    return chapter;
  } 
  
  private static String removeDuplicateSpaces(String chapterWithSpaces)
  {
    String chapter = chapterWithSpaces;
    
    while (chapter.indexOf("  ") >= 0)
    {
      chapter = chapter.replace("  ", " ");
    }
    
    return chapter;
  }
  
//  public static String adjustedChapter = aliceFirstChapter.replace("\r\n\r\n","\r\n");
  
  static String prepareChapter(String chapter)
  {
//    String chapter = TomSawyer.firstChapter;
    
    chapter = removeDuplicateLineBreaks(chapter);
    chapter = addSpacesAroundDashes(chapter);
    chapter = removeDuplicateSpaces(chapter);
    
    return chapter;
  }

  public static void main(String[] args)
  {
//    StringBuilder alice = new StringBuilder(aliceFirstChapter);
//    StringBuilder alice = new StringBuilder(adjustedChapter);
    
//    System.out.println(alice);
    String chapter = TomSawyer.firstChapter;
    
    
    System.out.println(prepareChapter(chapter));
    
//    System.out.println(removeDuplicateSpaces(sampleChapter()).indexOf("  "));
  }

}
>>>>>>> branch 'main' of https://github.com/redjofu/analyzemanuscript.git
