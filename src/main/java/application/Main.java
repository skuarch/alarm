package application;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author skuarch
 */
public class Main {

    //==========================================================================
    public static void main(String[] args) {

        File file = new File("smb_pause.wav");
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {

                Clip clip = null;

                try {

                    clip = AudioSystem.getClip();
                    clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(file));
                    clip.start();
                    Thread.sleep(clip.getMicrosecondLength() / 1000);
                    System.out.println("alarm " + new Date());

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (clip != null) {
                        clip.stop();
                        clip.close();
                    }
                }
            }
        };
        
        timer.scheduleAtFixedRate(timerTask, 0, (1000 * 6000) + 20 );        
    }

}
