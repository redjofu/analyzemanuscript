package userInterface;

import java.awt.Component;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
      chosenFile = new FileSelector().getFile();
      if (chosenFile != null) {
        String fileName = chosenFile.getName();
        boolean isPdf = checkIfPDF(fileName);
        if (isPdf)
        {
          openScreen.dispose();
          pdf = new PdfFile(chosenFile);
          Manuscript ms = new Manuscript(pdf); 
        }
        else
        {
          disableOpenScreen();
          ErrorAlertFrame pdfError = new ErrorAlertFrame(PDF_ERROR_TEXT, ErrorAlertFrame.RETURN_TO_LAUNCHER);
        }
      }
    
    //TODO: Change JFrame to reflect what the app is doing, e.g. opening file, importing chapters, etc.
    
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
