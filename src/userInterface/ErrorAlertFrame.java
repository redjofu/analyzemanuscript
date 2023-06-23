package userInterface;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorAlertFrame extends MyJFrame
{
  public ErrorAlertFrame(String errorText)
  {
    super("Error", 450, 250, 2);
    JPanel panel = this.getMainPanel();
    JLabel errorLabel = this.createLabel(errorText);
    JButton closeErrorButton = this.createCloseButton();
    panel.add(errorLabel);
    panel.add(closeErrorButton);
  }
}
