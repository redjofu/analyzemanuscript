package userInterface;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorAlertFrame extends MyJFrame
{
  /**
   * ErrorAlertFrame creates a basic error JFrame. When this class is used, all error JFrames have the same look.
   * If you want a specific action to occur when the close button is clicked, pass one of the final int variables to
   * the constructor when creating a new error ErrorAlertFrame.
   */
  private static final long serialVersionUID = 1493550398400089881L;
  public static final int NO_ACTION = 0;
  public static final int RETURN_TO_LAUNCHER = 1;

  public ErrorAlertFrame(String errorText, int actionOnClose)
  {
    super("Error", 450, 250, 2);
    JPanel panel = this.getMainPanel();
    JLabel errorLabel = this.createLabel(errorText);
    JButton closeErrorButton = this.createCloseButton();
    
    if (actionOnClose == RETURN_TO_LAUNCHER)
    {
      closeErrorButton.addActionListener(e -> { 
        Launcher.enableOpenScreen(); 
      });
    }
    
    panel.add(errorLabel);
    panel.add(closeErrorButton);
  }
  
  public ErrorAlertFrame(String errorText)
  {
    this(errorText, 0);
  }
  
//  private void returnToLauncher()
//  {
//    this.addActionListener(e -> {
//      this.dispose();
//  });
//  }
  
  

}
