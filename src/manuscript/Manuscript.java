package manuscript;
import java.util.ArrayList;

import pdfHandler.PdfFile;
import sampleBooks.*;
import userInterface.StatusBar;
import util.PassageIndex;
import util.Util;


public class Manuscript extends TextBlock
{
  // Originally was going to implement this as a singleton... decided I didn't want to anymore.
//  private static final Manuscript instance = new Manuscript();
//  static final String NEW_LINE_CHAR = "\r\n";
  
  private String msText;
  
  // TODO: Allow the user to customize what separates chapters. Foreign languages? Other specific words?
  private static String[] chapterVariations = {
    "Chapter",
    "chapter",
    "Prologue",
    "prologue",
    "Epilogue",
    "epilogue",
    "Prelude",
    "prelude",
    "Postlude",
    "postlude"
  };
  
//  public Manuscript()
//  {
//    // ??
//  }
  
  public Manuscript(StatusBar status, PdfFile pdf) 
  {
    msText = pdf.getText();
    status.update("Text extracted from PDF", 1);
    
    removeDuplicateLineBreaks();
    addSpacesAroundDashes();
    removeDuplicateSpaces();
    status.update("Extra spaces removed from manuscript", 1);

    ArrayList<Chapter> chapters = new ArrayList();

    // If there is text before the first chapter, it needs to be in position 0. Otherwise that spot will be null.
    // This also means that [1] is actually chapter 1, [2] is actually chapter 2, etc.
    if (isTextBeforeFirstChapter())
    {;
      chapters.add(new Chapter(Util.getNextPassage(msText, index, chapterVariations)));
    }
    else
    {
      chapters.add(null);
    }
    
    while (index.get() > -1) // Index is set in the addNextChapter method. It becomes -1 on the last chapter.
    {
      chapters.add(new Chapter(Util.getNextPassage(msText, index, chapterVariations)));
    }
    status.update("Divided manuscript into individual chapters", 1);
    
    msText = null; // It's no longer necessary for msText to store the full manuscript.
    System.out.println("now what?");
  }
  
  private boolean isTextBeforeFirstChapter()
  {
    if (Util.findNextPassageIndex(msText, index, chapterVariations) == 0)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  
//  // If there is no next chapter, this will return -1.
//  private int findNextChapterIndex(boolean isFirstSearch)
//  {
//    int indexNum = -1;
//    int startingPoint = isFirstSearch ? index : index + 1;
//    // Checks each variation of how a chapter might be divided
//    for (String variation : chapterVariations)
//    {
//      int currentIndex = msText.indexOf(variation, startingPoint);
//      if (currentIndex > -1 && (currentIndex < indexNum || indexNum < 0))
//      {
//        indexNum = currentIndex;
//      }
//    }
//    return indexNum;
//  }
  
//  private Chapter addNextChapter()
//  {
////    int nextIndex = findNextChapterIndex(false);
//    int nextIndex = Util.findNextPassageIndex(msText, index, chapterVariations);
//    String chapter = Util.addNextPassage(msText, index, nextIndex);
//    
//    
////    String chapter;
////    if (nextIndex != -1)
////    {
////      chapter = msText.substring(index, nextIndex);
////    }
////    else // For the final chapter
////    {
////      chapter = msText.substring(index);
////    }
////    index = nextIndex;
//    return new Chapter(chapter);
//  }
  
  private void removeDuplicateLineBreaks()
  {
    while (msText.contains(NEW_LINE_CHAR + NEW_LINE_CHAR)) 
    {
      msText = msText.replace(NEW_LINE_CHAR + NEW_LINE_CHAR, NEW_LINE_CHAR);
    }
  }
  
  private void addSpacesAroundDashes()
  {
    // Replace em dash with en dash
    msText = msText.replace("—", "–");
    
    // Add spaces around en dash. It's okay if extra spaces are created as they'll be removed later.
    msText = msText.replace("–", " – ");
  } 
  
  private void removeDuplicateSpaces()
  {
    while (msText.contains("  "))
    {
      msText = msText.replace("  ", " ");
    }
  }
  
//  private void setMsText(String text)
//  {
//    msText = text;
//  }
  
//  public static Manuscript getInstance() {
//    return instance;
//  }
}
