package irdeto;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

public class TestImageTracker implements Runnable {

    private final static String POSTER_PATH = "file:////home/irdeto/tmp/dvr/default/pushvod/catalog_Catalog_comp_SVOD_zip_19/PKPO5236190000000002";

    MediaTracker tracker;
    Image bg;
    
    public static void main(String[] args) {
        TestImageTracker testImageTracker = new TestImageTracker();
        testImageTracker.init();
    }
    
    public void init() {
        tracker = new MediaTracker(null);
        URL imageURL;
        try {
            imageURL = new URL("file:///C:\\dev\\workspace\\experiments\\bin\\images\\PKPO5236190000000002"); //WORKS!!
            bg = Toolkit.getDefaultToolkit().getImage(imageURL);
            tracker.addImage(bg, 0);
        } catch (MalformedURLException e1) {
            System.err.println();
        }
        

        try {
            
            Thread.sleep(1 * 1000L);
            System.out.println("waiting for image load : " + tracker.statusID(0, true));
            // System.out.println("waiting for image load");
        } catch (InterruptedException e) {

        }

        int status = tracker.statusID(0, true);

        if (status == MediaTracker.COMPLETE) {
            System.out.println("Image loaded");
        } else {
            System.out.println("Image not loaded : " + status);
        }

        /*
         * for (int i = 0 ; i < 2; i++) { anim[i] = getImage(getDocumentBase(), "images/anim" + i + ".gif");
         * tracker.addImage(anim[i], 1); }
         */
    }

    void findImage() {
        Image img = Toolkit.getDefaultToolkit().getImage(POSTER_PATH);
        if (img == null) {
            System.out.println("IMAGE DOES NOT EXIST : " + POSTER_PATH);
        }
        MediaTracker imageTracker = new MediaTracker(null);
        imageTracker.addImage(img, 0);

        try {
            Thread.sleep(5 * 1000L);
            if (imageTracker != null) {
                int status = imageTracker.statusID(0, false);
                if (status == MediaTracker.COMPLETE) {
                    System.out.println(POSTER_PATH + " downloaded successfully!");
                } else {
                    System.out.println(
                            POSTER_PATH + "- [NOT COMPLETE status = " + status
                                    + "] [IMAGE LOADING ERROR FOR ID = " + 0 + "]");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("findImage() - ERROR!!");
        }

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        //tracker.waitForID(0);
        
    }

}