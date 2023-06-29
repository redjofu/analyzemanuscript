package analysis;

import manuscript.Manuscript;
import userInterface.StatusBar;
import pdfHandler.PdfFile;

public class CentralControl
{
  public CentralControl(PdfFile pdf)
  {
    StatusBar statusBar = new StatusBar();
    statusBar.update("PDF file found", 1);
    Manuscript ms = new Manuscript(pdf); 
    statusBar.update("Text extracted from PDF", 1);
  }
}
