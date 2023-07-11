package analysis;

import java.util.concurrent.TimeUnit;

import manuscript.Manuscript;
import userInterface.StatusBar;
import pdfHandler.PdfFile;

public class CentralControl
{
  public CentralControl(StatusBar statusBar, PdfFile pdf)
  {
//    statusBar = new StatusBar();
    statusBar.update("PDF file found", 1);
    Manuscript ms = new Manuscript(statusBar, pdf); 
  }
}
