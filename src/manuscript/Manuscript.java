package manuscript;
import java.util.ArrayList;

import pdfHandler.PdfFile;
import sampleBooks.*;


public class Manuscript extends TextBlock
{
  // Originally was going to implement this as a singleton... decided I didn't want to anymore.
//  private static final Manuscript instance = new Manuscript();
  private String msText;
  private int index = 0;
  
  // TODO: Allow the user to customize what separates chapters. Foreign languages? Other specific words?
  private String[] chapterVariations = {
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
  
  public Manuscript(PdfFile pdf) 
  {
    msText = pdf.getText();
    ArrayList<String> chapters = new ArrayList();


    // Will delete this, just used for experimenting
    String chapter1;
    String chapter2;
    
    // If there is text before the first chapter, it needs to be in position 0. Otherwise that spot will be null.
    if (isTextBeforeFirstChapter())
    {;
      chapters.add(addNextChapter());
    }
    else
    {
      chapters.add(null);
    }
    
//    while (index < msText.length())
    int count = 0;
    while (count < 6)
    {
      chapters.add(addNextChapter());
      count++;
    }
    
    
    chapter1 = msText.substring(0,msText.indexOf("Chapter"));
    msText = msText.substring(msText.indexOf("Chapter"));
    System.out.println("now what?");
  }
  
  private boolean isTextBeforeFirstChapter()
  {
    if (findNextChapterIndex() == 0)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  
  // If there is no next chapter, this will return -1.
  private int findNextChapterIndex()
  {
    int indexNum = -1;
    // Checks each variation of how a chapter might be divided
    for (String variation : chapterVariations)
    {
      int currentIndex = msText.indexOf(variation);
      if (currentIndex > -1 && (currentIndex < indexNum || indexNum < 0))
      {
        indexNum = currentIndex;
      }
    }
    return indexNum;
  }
  
  private String addNextChapter()
  {
    int nextIndex = findNextChapterIndex();
    String chapter = msText.substring(index, nextIndex);
    index = nextIndex;
    return chapter;
  }
  
//  private void setMsText(String text)
//  {
//    msText = text;
//  }
  
//  public static Manuscript getInstance() {
//    return instance;
//  }
}
