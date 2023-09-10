package semIV;

import java.awt.*;
import java.awt.event.*;

public class AWTButtonExample {
   public static void main(String[] args) {
      Frame f = new Frame("AWT Button Example");
      Button b = new Button("Click Me!");

      b.setBounds(50, 50, 80, 30); // set button position and size

      f.add(b);
      f.setSize(200, 100); // set window frame size
      f.setLayout(null); // set layout to null to manually set component position

      f.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });

      f.setVisible(true);
   }
}
