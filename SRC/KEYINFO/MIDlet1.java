package keyinfo;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MIDlet1 extends MIDlet {
  static MIDlet1 instance;
  Displayable1 displayable = new Displayable1();
  public MIDlet1() {
    instance = this;
  }

  public void startApp() {
    Display.getDisplay(this).setCurrent(displayable);
  }

  public void pauseApp() {
  }

  public void destroyApp(boolean unconditional) {
  }

  public static void quitApp() {
    instance.destroyApp(true);
    instance.notifyDestroyed();
    instance = null;
  }

}
