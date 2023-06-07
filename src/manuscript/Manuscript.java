package manuscript;
import sampleBooks.*;


// Intent here: create a singleton object for the manuscript. This only needs to be instantiated once because each
// time the program is run, there should only be one Manuscript object created.
public class Manuscript
{
  private static final Manuscript  instance = new Manuscript();
  
  private Manuscript() {}
  
  public static Manuscript getInstance() {
    return instance;
  }
}
