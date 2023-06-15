package userInterface;

import java.io.File;
import javax.swing.*;
import util.Constants;

public class Launcher
{ 
  private static final String PROGRAM_NAME = Constants.PROGRAM_NAME.name;
  private static FileSelector chooseFile;
  private static File chosenFile;
  
  
  private static void createOpenScreen()
  {
    JFrame openScreen = new JFrame(PROGRAM_NAME);
    
    String openingText = "<html><p>Welcome to " + PROGRAM_NAME + "! " +
      "To begin, please select a PDF file of your manuscript.</p></html>";
    JLabel openLabel = new JLabel(openingText);
    openLabel.setBounds(50, 50, 370, 50);
    
    JButton selectButton = new JButton("Open Manuscript PDF");
    selectButton.setBounds(100, 150, 300, 50);
    selectButton.addActionListener(e -> {
      openFileSelector(chooseFile);
    });
    
    JButton closeButton = new JButton("Close");
    closeButton.setBounds(100, 220, 300, 50);
    closeButton.addActionListener(e -> {
      openScreen.dispose();
    });
    
    openScreen.add(openLabel);
    openScreen.add(selectButton);
    openScreen.add(closeButton);
    
    openScreen.setSize(520, 350);
    openScreen.setLayout(null);
    openScreen.setVisible(true);
  }
  
  private static void openFileSelector(FileSelector chooseFile)
  {
    chooseFile = new FileSelector();
  }

  public static void main(String[] args)
  {
    createOpenScreen();

  }
}
