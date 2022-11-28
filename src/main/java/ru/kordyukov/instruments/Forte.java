package ru.kordyukov.instruments;


import javax.sound.sampled.*;
import java.io.File;

public class Forte {
    public static int volume = 70;
    public void play(File file, int tempo, float note, byte[] data) {
        float a = 1.0F;
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file)) {
            AudioFormat formatIn = audioInputStream.getFormat();
            AudioFormat format = new AudioFormat(formatIn.getSampleRate() * note, formatIn.getSampleSizeInBits(), formatIn.getChannels(), true, formatIn.isBigEndian());

            DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(dinfo);
            //SourceDataLine line1 = (SourceDataLine) AudioSystem.getLine();
            if (line != null) {
                line.open(format);
                line.start();

                while (true) {
                    int k = audioInputStream.read(data, 0, data.length);
                    if (k < 0) break;

                    final var volumeControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
                    volumeControl.setValue(20.0f * (float) Math.log10(volume / 100.0));

                    line.write(data, 0, k);

                }

                Thread.sleep(tempo);
                line.stop();
                line.close();

                audioInputStream.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
