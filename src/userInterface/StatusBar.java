package userInterface;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import util.Constants;

public class StatusBar
{  
  private static final String PROGRAM_NAME = Constants.PROGRAM_NAME.name;
  private static final String STATUS_BAR_TITLE = "Status – " + PROGRAM_NAME;
  
  private static final int TOTAL_STATUS = 100;
  private int currentStatus = 0;
//  private static float percentageStatus;
  
//  private MyJFrame statusFrame;
  private JLabel label;
  private JProgressBar progressBar;
  
  public StatusBar()
  {
    MyJFrame statusFrame = new MyJFrame(true, STATUS_BAR_TITLE, 500, 350, 3);
//    statusFrame.setUndecorated(true);
//    statusFrame.setDefaultCloseOperation(JFrame.);
    JPanel panel = statusFrame.getMainPanel();
    
    label = statusFrame.createLabel("Beginning analysis...");
    
    progressBar = new JProgressBar(0, 100);
//    progressBar.setValue(0);
    progressBar.setFont(MyJFrame.LABEL_FONT);
    progressBar.setStringPainted(true);
    
    JButton closeButton = statusFrame.createCloseButton();
    
    panel.add(label);
    panel.add(progressBar);
    panel.add(closeButton);
    
    statusFrame.toFront();
  }
  
  public void update(String latestStatus, int amountToIncrement)
  {
    int percentageStatus = determinePercentage(amountToIncrement); 
    setLabel(latestStatus);
    progressBar.setValue(percentageStatus);
  }
  
  private void setLabel(String latestStatus)
  {
    String updatedStatus = "<html>Latest update: " + latestStatus + ".</html>";
    label.setText(updatedStatus);
  }
  
  private int determinePercentage(int amountToIncrement)
  {
    currentStatus += amountToIncrement;
//    float currentFloat = (float)currentStatus;
//    float totalFloat = (float)TOTAL_STATUS;
//    float division = currentFloat / totalFloat;
//    float percent = division * 100.0F;
    float percent = ((float)currentStatus  / (float)TOTAL_STATUS) * 100.0F;
    return (int)percent;
  }
  
  public void close()
  {
    // how to close jframe?
  }
  
  // Used for JUnit testing
  public int getProgressBarValue()
  {
    return progressBar.getValue();
  }
  
  public String getStatusLabel()
  {
    return label.getText();
  }
  
  public int getTotalStatus()
  {
    return TOTAL_STATUS;
//    return 50;
  }
}
