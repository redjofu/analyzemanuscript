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
//    try
//    {
//      TimeUnit.SECONDS.sleep(5);
//    }
//    catch (InterruptedException e)
//    {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
    statusBar.update("PDF file found", 1);
//    try
//    {
//      TimeUnit.SECONDS.sleep(5);
//    }
//    catch (InterruptedException e)
//    {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
    Manuscript ms = new Manuscript(statusBar, pdf); 
//    statusBar.update("Text extracted from PDF", 1);
  }
}
