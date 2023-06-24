package userInterface;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Constants;

class StatusBar
{  
  private static final String PROGRAM_NAME = Constants.PROGRAM_NAME.name;
  private static final String STATUS_BAR_TITLE = "Status – " + PROGRAM_NAME;
  
  private static int totalStatus = 100;
  private static int currentStatus = 0;
//  private static float percentageStatus;
  
  private MyJFrame statusFrame;
//  private JPanel panel;
  private JLabel label;
  
  public StatusBar()
  {
    statusFrame = new MyJFrame(STATUS_BAR_TITLE, 300, 350, 3);
    statusFrame.setUndecorated(true);
    JPanel panel = statusFrame.getMainPanel();
    label = statusFrame.createLabel("Beginning analysis...");
  }
  
  public void updateStatusBar(String latestStatus, int amountToIncrement)
  {
    currentStatus += amountToIncrement;
    int percentageStatus = totalStatus / currentStatus;
    setLabel(latestStatus, percentageStatus);
  }
  
  private void setLabel(String latestStatus, int percentageStatus)
  {
    String updatedStatus = "<html>Latest update: " + latestStatus + ". <br>" + percentageStatus + "% complete.</html>";
    label.setText(updatedStatus);
  }
}
