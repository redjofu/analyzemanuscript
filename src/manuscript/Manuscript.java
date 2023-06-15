package manuscript;
import pdfHandler.PdfFile;
import sampleBooks.*;


public class Manuscript
{
  // Originally was going to implement this as a singleton... decided I didn't want to anymore.
//  private static final Manuscript instance = new Manuscript();
  private String msText;
  
//  public Manuscript()
//  {
//    // ??
//  }
  
  public Manuscript(PdfFile pdf) 
  {
    msText = pdf.getText();
    System.out.println("now what?");
  }
  
//  private void setMsText(String text)
//  {
//    msText = text;
//  }
  
//  public static Manuscript getInstance() {
//    return instance;
//  }
}
