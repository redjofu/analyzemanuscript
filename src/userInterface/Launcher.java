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
  private static final String PROGRAM_NAME = Constants.PROGRAM_NAME.name;
  private static final String APP_NAME_VERSION = PROGRAM_NAME + " – v" + Constants.VERSION.name;
  private static final String OPENING_TEXT = "<html><p>Welcome to " + PROGRAM_NAME + "! " +
    "To begin, please select a PDF file of your manuscript.</p></html>"; 
  private static final String PDF_ERROR_TEXT = "<html><p>It appears you did not select a PDF file. You must select a " +
    "PDF file. Other file types are not supported at this time.</p></html>";
//  private static FileSelector fileSelector;
  private static File chosenFile;
  private static PdfFile pdf;
  
  
  private static void init()
  {
    MyJFrame openScreen = new MyJFrame(APP_NAME_VERSION, 520, 350, 3);
    JPanel panel = openScreen.getMainPanel();
//    openScreen.add(panel);
    
//    createOpenScreenLabel(openScreen);
    
//    JLabel openLabel = createOpenScreenLabel();
    JLabel openLabel = openScreen.createLabel(OPENING_TEXT);
    
    JButton selectButton = createSelectButton();
//    JButton closeButton = createCloseButton(openScreen);
    JButton closeButton = openScreen.createCloseButton();
    

    
//    createOpenScreenLabel(openScreen);
    panel.add(openLabel);
    panel.add(selectButton);
    panel.add(closeButton);
//    createPdfSelectionButton(openScreen);
//    openScreen.panelAdd(selectButton);
//    createCloseButton(openScreen);
  }
  
//  private static void openFileSelector(FileSelector chooseFile)
//  {
//    chooseFile = new FileSelector();
//    System.out.println("hi");
//  }
  
//  private static JFrame createOpenScreen()
//  {
//    MyJFrame openScreen = new MyJFrame(APP_NAME_VERSION, 10, 5, 3);
//    return openScreen;
//  }
  
//  private static JPanel createOpenScreenPanel()
//  {
////    JPanel panel = new JPanel();
//////    FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
//////    BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
////    GridLayout layout = new GridLayout(3, 1, 20, 20);
////    panel.setLayout(layout);
////    panel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Margin for panel
////    panel.setBackground(Color.WHITE);
////    return panel;
//  }
  
//  private static JLabel createLabel(String labelText)
//  {
//    JLabel label = new JLabel(labelText);
//    label.setAlignmentX(Component.CENTER_ALIGNMENT);
//    return label;
//  }
  
//  private static JLabel createOpenScreenLabel()
//  {
//    String openingText = "<html><p>Welcome to " + PROGRAM_NAME + "! " +
//      "To begin, please select a PDF file of your manuscript.</p></html>"; 
//    JLabel openLabel = createLabel(openingText);
//    return openLabel;
//  }
  
//  private static JLabel createPdfErrorLabel()
//  {
//    String errorText = "<html><p>It appears you did not select a PDF file. You must select a PDF file. " +
//      "Other file types are not supported at this time.</p></html>";
//    JLabel errorLabel = createLabel(errorText);
//    return errorLabel;
//  }
  
  private static JButton createSelectButton()
  {
    JButton selectButton = new JButton("Open Manuscript PDF");
    selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//  selectButton.setBounds(100, 150, 300, 50);
    selectButton.addActionListener(e -> {
//    openFileSelector(chooseFile);
//    fileSelector = new FileSelector();
//    chosenFile = fileSelector.getFile();
    chosenFile = new FileSelector().getFile();
    if (chosenFile != null) {
      String fileName = chosenFile.getName();
      boolean isPdf = checkIfPDF(fileName);
      if (isPdf)
      {
        pdf = new PdfFile(chosenFile);
        Manuscript ms = new Manuscript(pdf); 
      }
      else
      {
//        MyJFrame pdfError = new MyJFrame("Error", 450, 250, 2);
//        JPanel panel = pdfError.getMainPanel();
////        JLabel errorLabel = createPdfErrorLabel();
//        JLabel errorLabel = createLabel(PDF_ERROR_TEXT);
//        JButton closeErrorButton = createCloseButton(pdfError);
//        panel.add(errorLabel);
//        panel.add(closeErrorButton);
        
        ErrorAlertFrame pdfError = new ErrorAlertFrame(PDF_ERROR_TEXT);
        
      }

    }
    

    
    //TODO: Change JFrame to reflect what the app is doing, e.g. opening file, importing chapters, etc.
    
    });
    
    return selectButton;
  }
  
//  private static JButton createCloseButton(MyJFrame openScreen)
//  {
//    JButton closeButton = new JButton("Close");
//    closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
////    closeButton.setBounds(100, 220, 300, 50);
//    closeButton.addActionListener(e -> {
//      openScreen.dispose();
////      System.exit(0);
//    });
//    return closeButton;
//  }
  
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
  
//  private static void createOpenScreenLabel(MyJFrame frame)
//  {
//    String openingText = "<html><p>Welcome to " + PROGRAM_NAME + "! " +
//      "To begin, please select a PDF file of your manuscript.</p></html>";
//    frame.panelAdd(openingText);
//  }
  
//  private static void createPdfSelectionButton(MyJFrame frame)
//  {
//    JButton selectButton = new JButton("Open Manuscript PDF");
////    selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//    selectButton.addActionListener(e -> {
//      chosenFile = new FileSelector().getFile();
//      pdf = new PdfFile(chosenFile);
//      Manuscript ms = new Manuscript(pdf);
//
//      
//      //TODO: Change JFrame to reflect what the app is doing, e.g. opening file, importing chapters, etc.
//      
//    });
//    frame.panelAdd(selectButton);
//  }
  
//  private static void createCloseButton(MyJFrame frame)
//  {
//    JButton closeButton = new JButton("Close");
////    closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
////    closeButton.setBounds(100, 220, 300, 50);
//    closeButton.addActionListener(e -> {
//      frame.dispose();
////      System.exit(0);
//    });
//    frame.panelAdd(closeButton);
//  }

  public static void main(String[] args)
  {
    init();

  }
}
