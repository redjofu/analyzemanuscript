package util;

public enum Constants
{
  PROGRAM_NAME("Manuscript Compass"),
  PROGRAM_AUTHOR_NAME("Ian Compass"),
  COMPANY_NAME("Red Feather Marketing LLC"),
  VERSION("0.11");
  
  public final String name;
  
  private Constants(String name)
  {
    this.name = name;
  }
}