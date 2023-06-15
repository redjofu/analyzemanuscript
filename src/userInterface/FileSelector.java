package userInterface;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

class FileSelector
{
  private File file;
  
  protected FileSelector()
  {
    file = openFileDialog();
  }
  
  private File openFileDialog()
  {
    JFileChooser fileChooser = new JFileChooser();
    // It is possible to set the directory that opens. Default is documents and is fine, but this could be changed.
//    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Document", "pdf"));
    
    int result = fileChooser.showOpenDialog(fileChooser);
    
    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      return selectedFile;
    }
    
    return null;
  }
  
  protected File getFile()
  {
    return file;
  }
  
  public static void main(String[] args)
  {
    Launcher.main(args);
    
//    openFileDialog();
//    FileSelector test = new FileSelector();
//    System.out.println("testing...");
  }

}
