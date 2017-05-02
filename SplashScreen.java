package Frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Mikey
 */
public class SplashScreen extends JFrame implements ActionListener {

    ArrayList<ImageIcon> images = null;
    String[] strings = new String[197];
    JProgressBar pbar;
    JButton okayButton;
    JLabel status;

    public SplashScreen(String title) throws Exception {
        super(title);
        setLocationRelativeTo(null);
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addComponents(getContentPane());
        addListeners();
        Thread.sleep(1000);
        loadBar(pbar);
    }

    public SplashScreen() throws Exception {
          loadArrays();
    }

    private void addComponents(Container contentPane) {
        pbar = new JProgressBar(0, 196);
        pbar.setValue(0);
        pbar.setStringPainted(true);

        okayButton = new JButton("Okay");

        status = new JLabel();
        status.setHorizontalAlignment(JLabel.CENTER);

        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
        JPanel controlPanel = new JPanel();

        controlPanel.add(status);
        controlPanel.add(okayButton);

        listPane.add(controlPanel);

        contentPane.setLayout(new BorderLayout());
        contentPane.add(pbar, BorderLayout.NORTH);
        contentPane.add(listPane, BorderLayout.CENTER);

    }

    private void addListeners() {
        okayButton.addActionListener(this);
    }

    private void loadBar(JProgressBar pbar) throws IOException, Exception {
        try {
            strings = Arrays.copyOf(getFlagNames(), strings.length);
        } catch (Exception ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            images = new ArrayList<ImageIcon>(new frame.LoadFlags().doInBackground());
        } catch (Exception ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }

      

        status.setText("Loading Flags");
        pbar.setValue(new frame.LoadFlags().updateBar());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (pbar.getValue() == pbar.getMaximum()) {
            status.setText("Flags done loading! ");

        }
    }
    
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equalsIgnoreCase("Okay")) {
            dispose();
            try {
                new Frame("CSC420 Drag and Drop");
            } catch (Exception ex) {
                Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String[] getFlagNames() throws Exception {
        File folder = new File("C:\\Users\\Mikey\\Documents\\NetBeansProjects\\CSC420Homework4\\src\\Pictures");
        File[] listOfFiles = folder.listFiles();
        String[] fileNames = new String[197];

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                fileNames[i] = listOfFiles[i].getName();
            } else if (listOfFiles[i].isDirectory()) {
            }
        }
        return fileNames;
    }
    
    public void loadArrays (){
        try {
            strings = Arrays.copyOf(getFlagNames(), strings.length);
        } catch (Exception ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            images = new ArrayList<>(new frame.LoadFlags().doInBackground());
        } catch (Exception ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
