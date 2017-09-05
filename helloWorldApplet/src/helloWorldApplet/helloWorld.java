package helloWorldApplet;

import java.applet.Applet;
import java.awt.*;

public class helloWorld extends Applet {

	String str = "Hello World!";   
    public void paint(Graphics g)
    {
        g.drawString(str, 50, 50);
    }

}
