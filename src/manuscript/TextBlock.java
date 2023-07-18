package manuscript;

import util.PassageIndex;

abstract class TextBlock
{
  int wordCount;
  PassageIndex index = new PassageIndex();
  static final String NEW_LINE_CHAR = "\r\n";
}
