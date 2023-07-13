package analysis;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingWorker;

import manuscript.Manuscript;
import userInterface.StatusBar;
import pdfHandler.PdfFile;

public class CentralControl
{
  Manuscript manu;
  
  public CentralControl(PdfFile pdf)
  {
    // TODO: I might need to implement SwingWorker to get the statusBar updating correctly. However, after reading over
    // how to implement it and after trying to actually do so, I've decided to move forward with the rest of the
    // logic and return to SwingWorker later when I have more experience.
    // Resources:
    // https://stackoverflow.com/questions/20944719/how-to-use-swingworker
    // https://docs.oracle.com/javase/tutorial/uiswing/concurrency/simple.html
    
    StatusBar statusBar = new StatusBar();
    statusBar.update("PDF file found", 1);
    Manuscript ms = new Manuscript(statusBar, pdf);
    
    System.out.println("huh?");
  }
}
