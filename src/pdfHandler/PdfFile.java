package pdfHandler;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfFile
{
  private String pdfText;
  
  public PdfFile(File file)
  {
    pdfText = getPdfText(file);
  }
  
  private String getPdfText(File file)
  {
    try
    {
      PDDocument document = PDDocument.load(file);
      PDFTextStripper pdfStripper = new PDFTextStripper();
      String pdfText = pdfStripper.getText(document);
      return pdfText;
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public String getText()
  {
    return pdfText;
  }
  
  public static void main(String[] args)
  {
    String testy = "A";
//    System.out.println(testy2);

  }
}
