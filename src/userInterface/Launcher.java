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
//  private static FileSelector fileSelector;
  private static File chosenFile;
  private static PdfFile pdf;
  
  
  private static void init()
  {
    MyJFrame openScreen = new MyJFrame(APP_NAME_VERSION, 520, 350, 3, true);
    JPanel panel = openScreen.getMainPanel();
//    openScreen.add(panel);
    
    JLabel openLabel = createOpenScreenLabel();
    panel.add(openLabel);

    
    JButton selectButton = new JButton("Open Manuscript PDF");
    selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//    selectButton.setBounds(100, 150, 300, 50);
    selectButton.addActionListener(e -> {
//      openFileSelector(chooseFile);
//      fileSelector = new FileSelector();
//      chosenFile = fileSelector.getFile();
      chosenFile = new FileSelector().getFile();
      pdf = new PdfFile(chosenFile);
      Manuscript ms = new Manuscript(pdf);

      
      //TODO: Change JFrame to reflect what the app is doing, e.g. opening file, importing chapters, etc.
      
    });
    
    JButton closeButton = new JButton("Close");
    closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//    closeButton.setBounds(100, 220, 300, 50);
    closeButton.addActionListener(e -> {
      openScreen.dispose();
//      System.exit(0);
    });
    
    panel.add(selectButton);
    panel.add(closeButton);
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
  
  private static JLabel createOpenScreenLabel()
  {
    String openingText = "<html><p>Welcome to " + PROGRAM_NAME + "! " +
      "To begin, please select a PDF file of your manuscript.</p></html>";
    JLabel openLabel = new JLabel(openingText);
    openLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//    openLabel.setBounds(50, 50, 370, 50);
    return openLabel;
  }

  public static void main(String[] args)
  {
    init();

  }
}
