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
