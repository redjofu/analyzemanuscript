package manuscript;

import java.util.ArrayList;
//import commons.lang.StringUtils;

import util.PassageIndex;
import util.Util;

public class Chapter extends TextBlock
{
//  private static String NEW_LINE_CHAR = Manuscript.NEW_LINE_CHAR;
  public static String PARAGRAPH_SYMBOL = "U+00B6"; // Same as Unicode for "PILCROW SIGN" (paragraph symbol)
//  public static String END_PARAGRAPH_SYMBOL = "U+204B"; // Same as Unicode for "REVERSED PILCROW SIGN"
  public static String PAGE_SYMBOL = "U+21A1"; // Same as Unicode for "DOWNWARDS TWO HEADED ARROW"
  
  // Paragraph determination types
  private static int paragraphType; // This is set once per manuscript and then can be reused for future chapters.
  private static final int USE_PARAGRAPH_SYMBOL = 1;
  private static final int DOUBLE_SPACED_INDENT = 2;
  private static final int DOUBLE_LINE_BREAK = 3;
  private static final int DOUBLE_SPACED_CANT_DETERMINE = 4;
  private static final int CANT_DETERMINE = 5;
  
  /*
   * # of PARAGRAPH_SYMBOL == # of NEW_LINE_CHAR // Double spaced, check for space after PARAGRAPH_SYMBOL and text
   * PARAGRAPH_SYMBOL + " " // Indented line, probably start of new paragraph
   * # of PARAGRAPH_SYMBOL == # of PAGE_SYMBOL // Couldn't determine paragraphs at all, use alternate method
   * NEW_LINE_CHAR + NEW_LINE_CHAR // Double return, indicates paragraph
   * 
   * TODO: First determine which method of paragraph parsing is needed (method 1). Then parse (method 2).
   */
  
  public Chapter(String chapterText)
  {
 // TODO: This ArrayList should be a "Paragraph" object once I get that set up.
    ArrayList<String> paragraphs = new ArrayList();
    
    if (paragraphType == 0)
    {
      determineParagraphType(chapterText);
      float test = detectAverageLineLength(chapterText);
    }
    
    //TODO: Determine what should be the getNextPassage splitter. Also figure out how to deal with pagebreaks
    // (just do a simple copy replace PAGE_SYMBOLE + PARAGRAPH_SYMBOL with ""?)
    
    while (index.get() > -1) // Index is set in the addNextChapter method. It becomes -1 on the last chapter.
    {
      /* In PDFs, actual NEW_LINE_CHAR has to be doubled because PDFs put in hard breaks where there are actual breaks in the PDF but
       * not necessarily where there is a break in the text.
       * TODO: This is likely only applicable to PDFs. If I ever implement DOCX, a check will need to be implemented
       * to determine whether to double this or not.
       */
      paragraphs.add(new String(Util.getNextPassage(chapterText, index, PARAGRAPH_SYMBOL)));
    }
//    status.update("Divided manuscript into individual chapters", 1);
  }
  
  private void determineParagraphType(String chapterText)
  {
    int numParagraphSymbol = Util.countChar(chapterText, PARAGRAPH_SYMBOL);
    int numNewLine = Util.countChar(chapterText, NEW_LINE_CHAR);
    int numPageSymbol = Util.countChar(chapterText, PAGE_SYMBOL);
    int numLineBreaks = numNewLine + numPageSymbol;
    
    // For some reason, it is counting one more page symbol than actually exists, but I don't know why.
//    if (numParagraphSymbol == numLineBreaks || numParagraphSymbol == numLineBreaks - 1)
    if (isWithinOne(numParagraphSymbol, numLineBreaks))
    {
      if (chapterText.indexOf(PARAGRAPH_SYMBOL + " ") > -1)
      {
        paragraphType = DOUBLE_SPACED_INDENT;  
      }
      else
      {
        paragraphType = DOUBLE_SPACED_CANT_DETERMINE;
      }
    }
//    else if (numParagraphSymbol == numPageSymbol)
    else if (isWithinOne(numParagraphSymbol, numPageSymbol))
    {
      if (chapterText.indexOf(NEW_LINE_CHAR + NEW_LINE_CHAR) > -1 || 
        chapterText.indexOf(NEW_LINE_CHAR + " " + NEW_LINE_CHAR) > -1)
      {
        paragraphType = DOUBLE_LINE_BREAK;
      }
      else
      {
        paragraphType = CANT_DETERMINE;
      }
    }
    else
    {
      paragraphType = USE_PARAGRAPH_SYMBOL;
    }
    
    System.out.println("paragraphType: " + paragraphType);
  }
  
  private boolean isWithinOne(int firstNum, int secondNum)
  {
    if (firstNum == secondNum || firstNum == secondNum + 1 || firstNum == secondNum -1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  private float detectAverageLineLength(String chapterText)
  {
    PassageIndex tempIndex = new PassageIndex();
    int counter = 0;
    ArrayList<Integer> lines = new ArrayList();
    while (tempIndex.get() > -1 || counter < 50) // Index is set in the getNextPassage method. It becomes -1 on the last chapter.
    {
      counter++;
      String lineOfText = new String(Util.getNextPassage(chapterText, tempIndex, NEW_LINE_CHAR));
      int lineLength = lineOfText.length();
      lines.add(lineLength);
    }
    System.out.println("hello");
    return 1.0f;
  }
}
