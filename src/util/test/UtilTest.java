package util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.PassageIndex;
import util.Util;

class UtilTest
{
  private final String ALL_CAPS = "EXAMPLE";
  private final String LOWERCASE = "example";
  private final String FIRST_LETTER = "Example";
  private final String IRREGULAR = "eXample";
  
  private final int INDEX_BEGINNING = 0; // Beginning
  private final int INDEX_MIDDLE = 19; // First line after "Chapter 1"
  private final int INDEX_END = 47; // Epilogue
  private final String NEW_LINE_CHAR = "\r\n";
  private final String[] NO_VARIATIONS = {NEW_LINE_CHAR};
  private final String[] CHAPTER_VARIATIONS = {"Chapter","Epilogue"};
  private final String TEST_PASSAGE = "TITLE\r\nChapter 1:\r\nThis is a test.\r\nOr is it?\r\nEpilogue:\r\nYes, it is.";

  @Test
  void testLowerOrUpperCase_AllCaps()
  {
    String test = Util.lowerOrUpperCase(ALL_CAPS);
    assertEquals(ALL_CAPS,test);
  }
  
  @Test
  void testLowerOrUpperCase_Lowercase()
  {
    String test = Util.lowerOrUpperCase(LOWERCASE);
    assertEquals(LOWERCASE,test);
  }
  
  @Test
  void testLowerOrUpperCase_FirstLetter()
  {
    String test = Util.lowerOrUpperCase(FIRST_LETTER);
    assertEquals(LOWERCASE,test);
  }
  
  @Test
  void testLowerOrUpperCase_Irregular()
  {
    String test = Util.lowerOrUpperCase(IRREGULAR);
    assertEquals(LOWERCASE,test);
  }
  
  @Test
  void testGetNextPassage_Beginning_OneBreakPoint()
  {
    PassageIndex index = new PassageIndex(INDEX_BEGINNING);
    String test = Util.getNextPassage(TEST_PASSAGE, index, NEW_LINE_CHAR);
    assertEquals("TITLE",test);
  }
  
  @Test
  void testGetNextPassage_Middle_OneBreakPoint()
  {
    PassageIndex index = new PassageIndex(INDEX_MIDDLE);
    String test = Util.getNextPassage(TEST_PASSAGE, index, NEW_LINE_CHAR);
    assertEquals("This is a test.",test);
  }
  
  @Test
  void testGetNextPassage_End_OneBreakPoint()
  {
    PassageIndex index = new PassageIndex(INDEX_END);
    String test = Util.getNextPassage(TEST_PASSAGE, index, NEW_LINE_CHAR);
    assertEquals("Epilogue:",test);
  }
  
  @Test
  void testGetNextPassage_Beginning_MultiBreakPoint()
  {
    PassageIndex index = new PassageIndex(INDEX_BEGINNING);
    String test = Util.getNextPassage(TEST_PASSAGE, index, CHAPTER_VARIATIONS);
    assertEquals("TITLE\r\n",test);
  }
  
  @Test
  void testGetNextPassage_Middle_MultiBreakPoint()
  {
    PassageIndex index = new PassageIndex(INDEX_MIDDLE);
    String test = Util.getNextPassage(TEST_PASSAGE, index, CHAPTER_VARIATIONS);
    assertEquals("This is a test.\r\nOr is it?\r\n",test);
  }
  
  @Test
  void testGetNextPassage_End_MultiBreakPoint()
  {
    PassageIndex index = new PassageIndex(INDEX_END);
    String test = Util.getNextPassage(TEST_PASSAGE, index, CHAPTER_VARIATIONS);
    assertEquals("Epilogue:\r\nYes, it is.",test);
  }
  
  @Test
  void testGetNextPassage_Multiple_OneBreakPoint()
  {
    PassageIndex index = new PassageIndex(INDEX_BEGINNING);
    String test = Util.getNextPassage(TEST_PASSAGE, index, NEW_LINE_CHAR);
    assertEquals("TITLE",test);
    test = Util.getNextPassage(TEST_PASSAGE, index, NEW_LINE_CHAR);
    assertEquals("\r\nChapter 1:",test);
    test = Util.getNextPassage(TEST_PASSAGE, index, NEW_LINE_CHAR);
    assertEquals("\r\nThis is a test.",test);
    test = Util.getNextPassage(TEST_PASSAGE, index, NEW_LINE_CHAR);
    assertEquals("\r\nOr is it?",test);
    test = Util.getNextPassage(TEST_PASSAGE, index, NEW_LINE_CHAR);
    assertEquals("\r\nEpilogue:",test);
    test = Util.getNextPassage(TEST_PASSAGE, index, NEW_LINE_CHAR);
    assertEquals("\r\nYes, it is.",test);
  }
  
  @Test
  void testGetNextPassage_Multiple_MultiBreakPoint()
  {
    PassageIndex index = new PassageIndex(INDEX_BEGINNING);
    String test = Util.getNextPassage(TEST_PASSAGE, index, CHAPTER_VARIATIONS);
    assertEquals("TITLE\r\n",test);
    test = Util.getNextPassage(TEST_PASSAGE, index, CHAPTER_VARIATIONS);
    assertEquals("Chapter 1:\r\nThis is a test.\r\nOr is it?\r\n",test);
    test = Util.getNextPassage(TEST_PASSAGE, index, CHAPTER_VARIATIONS);
    assertEquals("Epilogue:\r\nYes, it is.",test);
  }

  @Test
  void testFindNextPassageIndex_Beginning_OneBreakpoint()
  {
    PassageIndex index = new PassageIndex(INDEX_BEGINNING);
    int test = Util.findNextPassageIndex(TEST_PASSAGE, index, NO_VARIATIONS);
    assertEquals(5,test);
  }
  
  @Test
  void testFindNextPassageIndex_Beginning_MultiBreakpoint()
  {
    PassageIndex index = new PassageIndex(INDEX_BEGINNING);
    int test = Util.findNextPassageIndex(TEST_PASSAGE, index, CHAPTER_VARIATIONS);
    assertEquals(7,test);
  }
  
  @Test
  void testFindNextPassageIndex_Middle_OneBreakpoint()
  {
    PassageIndex index = new PassageIndex(INDEX_MIDDLE);
    int test = Util.findNextPassageIndex(TEST_PASSAGE, index, NO_VARIATIONS);
    assertEquals(34,test);
  }
  
  @Test
  void testFindNextPassageIndex_Middle_MultiBreakpoint()
  {
    PassageIndex index = new PassageIndex(INDEX_MIDDLE);
    int test = Util.findNextPassageIndex(TEST_PASSAGE, index, CHAPTER_VARIATIONS);
    assertEquals(47,test);
  }
  
  @Test
  void testFindNextPassageIndex_End_OneBreakpoint()
  {
    PassageIndex index = new PassageIndex(INDEX_END);
    int test = Util.findNextPassageIndex(TEST_PASSAGE, index, NO_VARIATIONS);
    assertEquals(56,test);
  }
  
  @Test
  void testFindNextPassageIndex_End_MultiBreakpoint()
  {
    PassageIndex index = new PassageIndex(INDEX_END);
    int test = Util.findNextPassageIndex(TEST_PASSAGE, index, CHAPTER_VARIATIONS);
    assertEquals(-1,test);
  }

}
