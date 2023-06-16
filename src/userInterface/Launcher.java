package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.*;

import manuscript.Manuscript;
import pdfHandler.PdfFile;
import util.Constants;

public class Launcher
{ 
  private static final String PROGRAM_NAME = Constants.PROGRAM_NAME.name;
//  private static FileSelector fileSelector;
  private static File chosenFile;
  private static PdfFile pdf;
  
  
  private static void createOpenScreen()
  {
    JFrame openScreen = new JFrame(PROGRAM_NAME);
    
    openScreen.setSize(520, 350);
    openScreen.setLayout(new BorderLayout(10, 5));
    openScreen.setLocationRelativeTo(null);
    openScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    openScreen.setResizable(false);
    openScreen.setVisible(true);
    
    JPanel panel = new JPanel();
//    FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
    BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(layout);
    panel.setBackground(Color.WHITE);
    openScreen.add(panel);
    
    String openingText = "<html><p>Welcome to " + PROGRAM_NAME + "! " +
      "To begin, please select a PDF file of your manuscript.</p></html>";
    JLabel openLabel = new JLabel(openingText);
    openLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//    openLabel.setBounds(50, 50, 370, 50);
    
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
    });
    
    panel.add(openLabel);
    panel.add(selectButton);
    panel.add(closeButton);
  }
  
//  private static void openFileSelector(FileSelector chooseFile)
//  {
//    chooseFile = new FileSelector();
//    System.out.println("hi");
//  }

  public static void main(String[] args)
  {
    createOpenScreen();

  }
}
