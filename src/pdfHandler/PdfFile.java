package pdfHandler;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import manuscript.Chapter;

public class PdfFile
{
  private String pdfText;
  
  public PdfFile(File file)
  {
    pdfText = getPdfText(file);
  }
  
  private String getPdfText(File file)
  {
    try
    {
      PDDocument document = PDDocument.load(file);
      PDFTextStripper pdfStripper = new PDFTextStripper();
      pdfStripper.setParagraphStart(Chapter.PARAGRAPH_SYMBOL);
      // TODO: Figure out how to split into actual paragraphs, not going by line breaks. This inserts a paragraph
      // symbol, but what about page breaks? It can't figure that out.
      String pdfText = pdfStripper.getText(document);
      return pdfText;
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public String getText()
  {
    return pdfText;
  }
}
