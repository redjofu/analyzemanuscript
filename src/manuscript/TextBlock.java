package manuscript;

import util.PassageIndex;

abstract class TextBlock
{
  int wordCount;
  PassageIndex index = new PassageIndex();
  static final String NEW_LINE_CHAR = "\r\n";
  
  String removeDuplicateSpaces(String textBlock)
  {
    String text = textBlock;
    while (text.contains("  "))
    {
      text = text.replace("  ", " ");
    }
    return text;
  }
}
