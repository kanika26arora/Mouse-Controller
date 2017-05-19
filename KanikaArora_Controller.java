import java.awt.Point;
import java.awt.Robot;

class KanikaArora_Controller extends javax.swing.JFrame
{
  Robot r;
  int x,y;
  public boolean leftKeyPressed = false;
  public boolean rightKeyPressed = false;
  public boolean upKeyPressed = false;
  public boolean downKeyPressed = false;
  public boolean spaceKeyPressed = false;
  
  public KanikaArora_Controller()
  {
    createAndShowGUI();
  }
  
  private void createAndShowGUI()
  {
    setTitle("Move Cursor with Keyboard");
    setDefaultCloseOperation(3);
    

    setUndecorated(true);
    setOpacity(0.0F);
    setVisible(true);
    

    try
    {
      r = new Robot();
    }
    catch (Exception localException) {}
    addKeyListener(new java.awt.event.KeyAdapter()
    {

      public void keyPressed(java.awt.event.KeyEvent paramAnonymousKeyEvent)
      {

        if (r == null) { return;
        }
        
        Point localPoint = java.awt.MouseInfo.getPointerInfo().getLocation();
        int i = paramAnonymousKeyEvent.getKeyCode();
        
        if (i == 38)
        {
          r.mouseMove(x, y - 1);
          upKeyPressed = true;
        }
        
        if (i == 40)
        {
          r.mouseMove(x, y + 1);
          downKeyPressed = true;
        }
        
        if (i == 37)
        {
          r.mouseMove(x - 1, y);
          leftKeyPressed = true;
        }
        
        if (i == 39)
        {
          r.mouseMove(x + 1, y);
          rightKeyPressed = true;
        }
        

        if ((rightKeyPressed) && (downKeyPressed)) {
          r.mouseMove(x + 1, y + 1);
        }
        if ((rightKeyPressed) && (upKeyPressed)) {
          r.mouseMove(x + 1, y - 1);
        }
        if ((leftKeyPressed) && (upKeyPressed)) {
          r.mouseMove(x - 1, y - 1);
        }
        if ((leftKeyPressed) && (downKeyPressed)) {
          r.mouseMove(x - 1, y + 1);
        }
        if (i == 32)
        {
          r.mousePress(16);
          r.mouseRelease(16);
        }
        
        if ((i == 32) && ((downKeyPressed) || (upKeyPressed) || (rightKeyPressed) || (leftKeyPressed)))
        {
          r.mousePress(4);
          r.mouseRelease(4);
        }
      }
      
      public void keyReleased(java.awt.event.KeyEvent paramAnonymousKeyEvent) {
        int i = paramAnonymousKeyEvent.getKeyCode();
        
        if (i == 39)
        {
          rightKeyPressed = false;
        }
        
        if (i == 38)
        {
          upKeyPressed = false;
        }
        
        if (i == 40)
        {
          downKeyPressed = false;
        }
        
        if (i == 37)
        {
          leftKeyPressed = false;
        }
      }
    });
  }
  





  public static void main(String[] paramArrayOfString)
  {
    new KanikaArora_Controller();
  }
}
