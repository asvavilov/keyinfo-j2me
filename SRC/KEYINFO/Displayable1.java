package keyinfo;

import javax.microedition.lcdui.*;

public class Displayable1 extends Canvas implements CommandListener {
  public Displayable1() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    // Set up this Displayable to listen to command events
    setCommandListener(this);
    // add the Exit command
    //addCommand(new Command("Exit", Command.EXIT, 1));
    this.setFullScreenMode(true);
    flagQuit=false;
  }

  public void commandAction(Command command, Displayable displayable) {
    /** @todo Add command handling code */
    if (command.getCommandType() == Command.EXIT) {
      // stop the MIDlet
      MIDlet1.quitApp();
    }
  }
private void clear(Graphics g) {
  int cW=g.getClipWidth();
  int cH=g.getClipHeight();
  int cX=g.getClipX();
  int cY=g.getClipY();
  int color=g.getColor();
  g.setColor(0xffffff);
  g.fillRect(cX,cY,cW,cH);
  g.setColor(color);
}
  protected void paint(Graphics g) {
    /** @todo Add paint codes */
    clear(g);
    g.drawString("Для выхода - \"0\" 2 раза",0,0,Graphics.LEFT|Graphics.TOP);
    g.drawString("keyCode = "+kC,0,15,Graphics.LEFT|Graphics.TOP);
    g.drawString("GameAction = "+GA,0,30,Graphics.LEFT|Graphics.TOP);
    g.drawString("KeyName = ",0,45,Graphics.LEFT|Graphics.TOP);
    g.drawString(KN,0,60,Graphics.LEFT|Graphics.TOP);
  }

private int kC;
private int GA;
private String KN;
private boolean flagQuit;

  protected void keyReleased(int keyCode) {
    kC=keyCode;
    GA=getGameAction(keyCode);
    KN=getKeyName(keyCode);
    repaint();
    if(kC==Canvas.KEY_NUM0) {
     if (flagQuit==true) {
       MIDlet1.quitApp();
     }
     flagQuit=true;
    } else {
     flagQuit=false;
    }
  }
}
