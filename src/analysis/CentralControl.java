package analysis;

import manuscript.Manuscript;
import userInterface.StatusBar;
import pdfHandler.PdfFile;

public class CentralControl
{
  public CentralControl(PdfFile pdf)
  {
    StatusBar statusBar = new StatusBar();
    statusBar.updateStatusBar("PDF file found", 1);
    Manuscript ms = new Manuscript(pdf); 
    statusBar.updateStatusBar("Text extracted from PDF", 1);
  }
}
