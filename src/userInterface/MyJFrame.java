package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
  public static final Font LABEL_FONT = new Font("SansSerif", Font.PLAIN, 20);
  public static final Font BUTTON_FONT = new Font("SansSerif", Font.BOLD, 24);
  
  private JPanel mainPanel;
  private GridLayout panelLayout;
  private int margin = 20;
  
  public MyJFrame(boolean hideHeaderBar, String title, int width, int height, int rows, boolean closeApp)
  {
    super(title);
    this.setUndecorated(hideHeaderBar);
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
  
  public MyJFrame(boolean hideHeaderBar, String title, int width, int height, int rows)
  {
    this(hideHeaderBar, title, width, height, rows, false);
  }
  
  public MyJFrame(String title, int width, int height, int rows, boolean closeApp)
  {
    this(false, title, width, height, rows, closeApp);
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
  
  public JLabel createLabel(String labelText)
  {
    JLabel label = new JLabel(labelText);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    label.setFont(LABEL_FONT);
    return label;
  }
  
  public JButton createCloseButton()
  {
    JButton closeButton = new JButton("Close");
    closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    closeButton.setFont(BUTTON_FONT);
    closeButton.addActionListener(e -> {
      this.dispose();
    });
    return closeButton;
  }
}
