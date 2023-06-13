package userInterface;
import javax.swing.*;
import util.Constants;

public class Launcher
{ 
  private static final String PROGRAM_NAME = Constants.PROGRAM_NAME.name;
  private static void createOpenScreen()
  {
    JFrame openScreen = new JFrame(PROGRAM_NAME);
    
    String openingText = "<html><p>Welcome to " + PROGRAM_NAME + "! " +
      "To begin, please select a PDF file of your manuscript.</p></html>";
    JLabel openLabel = new JLabel(openingText);
    openLabel.setBounds(50, 50, 370, 50);
    
    
    JButton selectButton = new JButton("Open Manuscript PDF");
    selectButton.setBounds(100, 150, 300, 50);
    
    openScreen.add(openLabel);
    openScreen.add(selectButton);
    
    openScreen.setSize(520, 350);
    openScreen.setLayout(null);
    openScreen.setVisible(true);
  }

  public static void main(String[] args)
  {
    createOpenScreen();

  }
}
