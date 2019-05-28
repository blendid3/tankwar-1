import javafx.scene.media.*;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.File;
import java.util.Random;

class Tools {
    private static final Random RANDOM = new Random();

    static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    /**
     * generate a random number less than giving number
     * @param endExclusive  exclusive maximum number
     */
    static int nextInt(final int endExclusive) {
        return RANDOM.nextInt(endExclusive);
    }

    /**
     * generate a random number within the giving two numbers
     * @param beginInclusive inclusive minimum number
     * @param endExclusive  exclusive maximum number
     */
    static int nextInt(final int beginInclusive, final int endExclusive) {
        return beginInclusive + RANDOM.nextInt(endExclusive - beginInclusive);
    }

    private static boolean STOPPED = false;

    /**
     * Play an audio file located under directory "assets/audios"
     */
    static synchronized void playAudio(final String audioFile) {
        if (STOPPED) return;

        try {
            File file = new File("assets/audios/" + audioFile);
            Media media = new Media(file.toURI().toString());
            new MediaPlayer(media).play();
        } catch (MediaException e) {
            e.printStackTrace();
            STOPPED = true;
        }
    }

    /**
     * Get {@link Image} from given file
     * @param imageFileName name of image file under directory "assets/images"
     */
    static Image getImage(final String imageFileName) {
        return new ImageIcon("assets/images/" + imageFileName).getImage();
    }

    static void sleepSilently(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // -> Ignore
        }
    }
}
