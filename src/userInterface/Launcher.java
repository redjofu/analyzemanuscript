package userInterface;

import java.awt.Component;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import analysis.CentralControl;
import manuscript.Manuscript;
import pdfHandler.PdfFile;
import util.Constants;

public class Launcher
{ 
  /**
   * Launcher creates the initial menu JFrame that allows the user to select a file for their manuscript. It is
   * intended to be the starting point for the app.
   */
  private static final String PROGRAM_NAME = Constants.PROGRAM_NAME.name;
  private static final String APP_NAME_VERSION = PROGRAM_NAME + " – v" + Constants.VERSION.name;
  private static final String OPENING_TEXT = "<html><p>Welcome to " + PROGRAM_NAME + "! " +
    "To begin, please select a PDF file of your manuscript.</p></html>"; 
  private static final String PDF_ERROR_TEXT = "<html><p>It appears you did not select a PDF file. You must select a " +
    "PDF file. Other file types are not supported at this time.</p></html>";
  private static final String CANT_READ_ERROR_TEXT = "<html><p>The file has a .pdf extension, but it cannot be read " +
    "as a PDF file for unknown reasons. Consider converting your manuscript to a PDF via a different " +
    "method.</p></html>";

  private static MyJFrame openScreen;
  private static File chosenFile;
  private static PdfFile pdf;
  private static int screenEnabled = 0;
  
  private static void init()
  {
    openScreen = new MyJFrame(APP_NAME_VERSION, 520, 350, 3);
    JPanel panel = openScreen.getMainPanel();
    JLabel openLabel = openScreen.createLabel(OPENING_TEXT);
    
    JButton selectButton = createSelectButton();
    JButton closeButton = openScreen.createCloseButton();
    
    // Note: These must be created separately first before any of them are actually added to the panel or they won't
    // display.
    panel.add(openLabel);
    panel.add(selectButton);
    panel.add(closeButton);
  }
  
  private static JButton createSelectButton()
  {
    JButton selectButton = new JButton("Open Manuscript PDF");
    selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    selectButton.setFont(MyJFrame.BUTTON_FONT);
    selectButton.addActionListener(e -> {
//      StatusBar statusBar = new StatusBar();
//      statusBar.update("Begun file selection process", 1);
      chosenFile = new FileSelector().getFile();
      if (chosenFile != null) {
        String fileName = chosenFile.getName();
        boolean isPdf = checkIfPDF(fileName);
        if (isPdf)
        {
          try // Just in case it has a .pdf extension but can't be read as an actual PDF file
          {
            pdf = new PdfFile(chosenFile);
          }
          catch (Exception ex)
          {
            disableOpenScreen();
            new ErrorAlertFrame(CANT_READ_ERROR_TEXT, ErrorAlertFrame.RETURN_TO_LAUNCHER);
            ex.printStackTrace();
          }
          if (pdf != null)
          {
            openScreen.dispose();
            new CentralControl(pdf);
          }
          else
          {
//            statusBar.close();
          }
        }
        else
        {
//          statusBar.close();
          disableOpenScreen();
          new ErrorAlertFrame(PDF_ERROR_TEXT, ErrorAlertFrame.RETURN_TO_LAUNCHER);
        }
      }
      else
      {
//        statusBar.close();
      }
    });
    
    return selectButton;
  }
  
  private static boolean checkIfPDF(String fileName)
  {
    int dotIndex = fileName.lastIndexOf(".");
    String fileExtension = "";
    if (dotIndex > -1)
    {
      fileExtension = fileName.substring(dotIndex + 1);
    }
    fileExtension = fileExtension.toLowerCase();
    if (fileExtension.equals("pdf"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  private static void disableOpenScreen()
  {
    screenEnabled++;
    openScreen.setEnabled(false);
  }
  
  public static void enableOpenScreen()
  {
    screenEnabled--;
    if (screenEnabled == 0)
    {
      openScreen.setEnabled(true);
    }
  }

  public static void main(String[] args)
  {
    init();
  }
}
