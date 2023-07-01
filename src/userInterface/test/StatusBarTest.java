package userInterface.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import userInterface.StatusBar;

class StatusBarTest
{
//  private StatusBar status;
  private final String STATUS_TEXT = "testing, testing...";
  private float totalStatus;
  
  @Before
  StatusBar instantiateStatusBar()
  {
    StatusBar status = new StatusBar();
    totalStatus = (float)status.getTotalStatus();
    return status;
  }
  
  @Test
  void testUpdateLabel()
  {
//    status = new StatusBar();
//    totalStatus = status.getTotalStatus();
    StatusBar status = instantiateStatusBar();
    status.update(STATUS_TEXT, 0);
    assertTrue(status.getStatusLabel().contains(STATUS_TEXT));
    
//    assertEquals(StatusBar.update("Test",1),2);
  }
  
  @Test
  void testUpdateProgressBarSmall()
  {
    StatusBar status = instantiateStatusBar();
    int test1 = 1;
    float float1 = (float)test1;
    int percent1 = (int)((float1 / totalStatus)*100);
    status.update(STATUS_TEXT, test1);
    assertEquals(status.getProgressBarValue(), percent1);
  }
  
  @Test
  void testUpdateProgressBarMedium()
  {
    StatusBar status = instantiateStatusBar();
    int test1 = 10;
    float float1 = (float)test1;
    int percent1 = (int)((float1 / totalStatus)*100);
    status.update(STATUS_TEXT, test1);
    assertEquals(status.getProgressBarValue(), percent1);
  }
  
  @Test
  void testUpdateProgressBarLarge()
  {
    StatusBar status = instantiateStatusBar();
    int test1 = 50;
    float float1 = (float)test1;
    int percent1 = (int)((float1 / totalStatus)*100);
    status.update(STATUS_TEXT, test1);
    assertEquals(status.getProgressBarValue(), percent1);
  }
  
  @Test
  void testUpdateProgressBarIrregular()
  {
    StatusBar status = instantiateStatusBar();
    int test1 = 17;
    float float1 = (float)test1;
    int percent1 = (int)((float1 / totalStatus)*100);
    status.update(STATUS_TEXT, test1);
    assertEquals(status.getProgressBarValue(), percent1);
  }
  
  @Test
  void testUpdateProgressBarMultiple()
  {
    StatusBar status = instantiateStatusBar();
    
    int test1 = 5;
    int test2 = 10;
    int test3 = 18;
    float float1 = (float)test1;
    float float2 = (float)test2 + float1;
    float float3 = (float)test3 + float2;
    int percent1 = (int)((float1 / totalStatus)*100);
    int percent2 = (int)((float2 / totalStatus)*100);
    int percent3 = (int)((float3 / totalStatus)*100);
    
    status.update(STATUS_TEXT, test1);
    assertEquals(status.getProgressBarValue(), percent1);
    
    status.update(STATUS_TEXT, test2);
    assertEquals(status.getProgressBarValue(), percent2);

    status.update(STATUS_TEXT, test3);
    assertEquals(status.getProgressBarValue(), percent3);
  }
}
