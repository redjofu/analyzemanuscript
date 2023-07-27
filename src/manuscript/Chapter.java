package manuscript;

import java.util.ArrayList;
//import commons.lang.StringUtils;

import util.Util;

public class Chapter extends TextBlock
{
//  private static String NEW_LINE_CHAR = Manuscript.NEW_LINE_CHAR;
  public static String PARAGRAPH_SYMBOL = "U+00B6"; // Same as Unicode for "PILCROW SIGN" (paragraph symbol)
//  public static String END_PARAGRAPH_SYMBOL = "U+204B"; // Same as Unicode for "REVERSED PILCROW SIGN"
  public static String PAGE_SYMBOL = "U+21A1"; // Same as Unicode for "DOWNWARDS TWO HEADED ARROW"
  
  private static int paragraphType; // This is set once per manuscript and then can be reused for future chapters.
  private static final int DOUBLE_SPACED = 1;
  
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
    System.out.println(chapterText);
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
  
  private int determineParagraphType(String chapterText)
  {
//    int numNewLine = StringUtils.countMatches(chapterText, NEW_LINE_CHAR);
    int numNewLine = Util.countChar(chapterText, NEW_LINE_CHAR);
    int numParagraphSymbol = Util.countChar(chapterText, PARAGRAPH_SYMBOL);
    int numPageSymbol = Util.countChar(chapterText, PAGE_SYMBOL);
    
    if ((numParagraphSymbol == numNewLine) && (chapterText.indexOf(PARAGRAPH_SYMBOL + " ") > -1))
    {
      
    }
    
    return 1;
  }
  
}
