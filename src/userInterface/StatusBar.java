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
  private static int currentStatus = 0;
//  private static float percentageStatus;
  
//  private MyJFrame statusFrame;
  private JLabel label;
  private JProgressBar progressBar;
  
  public StatusBar()
  {
    MyJFrame statusFrame = new MyJFrame(STATUS_BAR_TITLE, 300, 350, 3);
    statusFrame.setUndecorated(true);
    JPanel panel = statusFrame.getMainPanel();
    
    label = statusFrame.createLabel("Beginning analysis...");
    
    progressBar = new JProgressBar(0, 100);
    progressBar.setValue(0);
    progressBar.setStringPainted(true);
    
    JButton closeButton = statusFrame.createCloseButton();
    
    panel.add(label);
    panel.add(progressBar);
    panel.add(closeButton);
  }
  
  public void updateStatusBar(String latestStatus, int amountToIncrement)
  {
    currentStatus += amountToIncrement;
    int percentageStatus = currentStatus / TOTAL_STATUS;
    setLabel(latestStatus, percentageStatus);
    progressBar.setValue(percentageStatus);
    
  }
  
  private void setLabel(String latestStatus, int percentageStatus)
  {
    String updatedStatus = "<html>Latest update: " + latestStatus + ". <br>" + percentageStatus + "% complete.</html>";
    label.setText(updatedStatus);
  }
}
