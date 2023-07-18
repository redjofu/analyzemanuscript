package util;

public class PassageIndex
{
  int indexInt;
  
  public PassageIndex()
  {
    this(0);
  }
  
  public PassageIndex(int startingIndex)
  {
    indexInt = startingIndex;
  }
  
  public int get()
  {
    return indexInt;
  }
  
  public void set(int newIndex)
  {
    indexInt = newIndex;
  }
}
