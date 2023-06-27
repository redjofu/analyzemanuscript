package analysis;

import manuscript.Manuscript;
import userInterface.StatusBar;
import pdfHandler.PdfFile;

public class CentralControl
{
  public CentralControl(PdfFile pdf)
  {
    StatusBar status = new StatusBar();
    status.updateStatusBar("PDF file found.", 1);
    Manuscript ms = new Manuscript(pdf); 
    status.updateStatusBar("Text extracted from PDF.", 1);
  }
}
