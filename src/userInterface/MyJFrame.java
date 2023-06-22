package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyJFrame extends JFrame
{
  /**
   * The MyJFrame uses a set of JFrame options so that all JFrames in the application are similar.
   */
  private static final long serialVersionUID = -4123844101559078546L;
  private JPanel mainPanel;
  private GridLayout panelLayout;
  private int margin = 20;
  
  public MyJFrame(String title, int width, int height, int rows, boolean closeApp)
  {
    super(title);
    this.setSize(width, height);
    this.setLayout(new BorderLayout(10, 5));
    this.setLocationRelativeTo(null);
    if (closeApp) {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } else {
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    this.setResizable(false);
    this.setVisible(true);
    
    mainPanel = new JPanel();
    panelLayout = new GridLayout(rows, 1, margin, margin);
    mainPanel.setLayout(panelLayout);
    mainPanel.setBorder(new EmptyBorder(margin, margin, margin, margin)); // Margin for panel
    mainPanel.setBackground(Color.WHITE);
    
    this.add(mainPanel);
  }
  
  public MyJFrame(String title, int width, int height)
  {
    this(title, width, height, 1, false);
  }
  
  public MyJFrame(String title, int width, int height, int rows)
  {
    this(title, width, height, rows, false);
  }
  
  public JPanel getMainPanel()
  {
    return mainPanel;
  }
  
//  public void panelAdd(String labelText)
//  {
//    JLabel label = new JLabel(labelText);
//    label.setAlignmentX(Component.CENTER_ALIGNMENT);
//    mainPanel.add(label);
//  }
//  
//  public void panelAdd(JButton button)
//  {
//    button.setAlignmentX(Component.CENTER_ALIGNMENT);
//    mainPanel.add(button);
//  }
}
