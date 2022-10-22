package disassembly;
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
  
  static String prepareChapter(String chapterToPrep)
  {
    String chapter = chapterToPrep;
    chapter = removeDuplicateLineBreaks(chapter);
    chapter = addSpacesAroundDashes(chapter);
    if (chapter.contains(newLineChar + newLineChar))
    {
      chapter = removeDuplicateSpaces(chapter);
      System.out.println("1");
    }
    
    if (chapter.contains(newLineChar + newLineChar))
    {
      chapter = removeDuplicateSpaces(chapter);
      System.out.println("2");
    }
    
    
    if (chapter.contains(newLineChar + newLineChar))
    {
      chapter = removeDuplicateSpaces(chapter);
      System.out.println("3");
    }
    
    
    if (chapter.contains(newLineChar + newLineChar))
    {
      chapter = removeDuplicateSpaces(chapter);
      System.out.println("4");
    }
    
    
    if (chapter.contains(newLineChar + newLineChar))
    {
      chapter = removeDuplicateSpaces(chapter);
      System.out.println("5");
    }
    
    if (chapter.contains(newLineChar + newLineChar))
    {
      chapter = removeDuplicateSpaces(chapter);
      System.out.println("6");
    }
    
    if (chapter.contains(newLineChar + newLineChar))
    {
      chapter = removeDuplicateSpaces(chapter);
      System.out.println("7");
    }
    
    
    return chapter;
  }

  public static void main(String[] args)
  {
    String chapter = TomSawyer.firstChapter; 
    System.out.println(prepareChapter(chapter));
  }

}
