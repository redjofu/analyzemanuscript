package userInterface;

import javax.swing.JPanel;

import util.Constants;

class StatusBar
{
  private static final String PROGRAM_NAME = Constants.PROGRAM_NAME.name;
  private static final String STATUS_BAR_TITLE = "Status – " + PROGRAM_NAME;
  
  public StatusBar()
  {
    MyJFrame openScreen = new MyJFrame(STATUS_BAR_TITLE, 300, 350, 2);
//    JPanel panel = openScreen.getMainPanel();
    
  }
}
