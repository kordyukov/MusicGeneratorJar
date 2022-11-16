package src.instruments;

import javax.sound.sampled.*;
import java.io.File;

public class Bass {
    public static int volume = 70;
    public void play(File file, int tempo, float note) {

        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file)) {
            float a = 1.0f;
            int k;
            byte[] data;
            data = new byte[1024];

            AudioFormat formatIn = audioInputStream.getFormat();
            AudioFormat format = new AudioFormat(formatIn.getSampleRate() * note, formatIn.getSampleSizeInBits(), formatIn.getChannels(), true, formatIn.isBigEndian());

            DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(dinfo);

            if (line != null) {
                line.open(format);
                line.start();

                while (true) {
                    k = audioInputStream.read(data, 0, data.length);
                    if (k < 0) break;

                    final var volumeControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
                    volumeControl.setValue(20.0f * (float) Math.log10(volume / 100.0));

                    line.write(data, 0, k);

                }

                Thread.sleep(tempo);
                line.stop();
                line.close();


            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
