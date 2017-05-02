package frame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

/**
 *
 * @author Mikey
 */
public class LoadFlags extends SwingWorker<ArrayList<ImageIcon>, String> {

    @Override
    public ArrayList<ImageIcon> doInBackground() throws Exception {
        File folder = new File("C:\\Users\\Mikey\\Documents\\NetBeansProjects\\CSC420Homework4\\src\\Pictures");
        File[] listOfFiles = folder.listFiles();
        ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
      //  ArrayList<ImageIcon> newImages = new ArrayList<ImageIcon>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                images.add(new ImageIcon(listOfFiles[i].getAbsolutePath()));
            }
        }
        return images;
    }
    
   

    
    public int updateBar() throws IOException {
        int update = 0;
        File folder = new File("C:\\Users\\Mikey\\Documents\\NetBeansProjects\\CSC420Homework4\\src\\Pictures");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            update = i;
        }

        return update;
    }

}
