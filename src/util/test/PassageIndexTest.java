package util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.PassageIndex;

class PassageIndexTest
{

  @Test
  void testGet()
  {
    PassageIndex index = new PassageIndex();
    int test = index.get();
    assertEquals(0,test);
    index = new PassageIndex(10);
    test = index.get();
    assertEquals(10,test);
  }

  @Test
  void testSet()
  {
    PassageIndex index = new PassageIndex();
    index.set(10);
    assertEquals(10,index.get());
    index.set(0);
    assertEquals(0,index.get());
  }

}
