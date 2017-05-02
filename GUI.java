package csc420homework4;

import Frame.SplashScreen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class GUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ThreadForGUI());
    }

    private static class ThreadForGUI implements Runnable {

        @Override
        public void run() {
            try {
                GUI gui = new GUI();
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public GUI() throws Exception {
        SplashScreen splash = new SplashScreen("Loading Flags");
     }
}
