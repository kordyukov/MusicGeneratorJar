package ru.kordyukov.instruments;

import ru.kordyukov.constants.MusicGeneratorConst;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.*;
import java.io.File;
public class Snare {
    public static int volume = 80;
    private int note = 38;
    private int temp;

    public void playSnare(int temp, int volume) {
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            MidiChannel[] channels = synth.getChannels();
            channels[MusicGeneratorConst.CHANNEL_SNARE].programChange(MusicGeneratorConst.SNARE);
            channels[MusicGeneratorConst.CHANNEL_SNARE].noteOn(note, volume);
            Thread.sleep(temp); // in milliseconds
            channels[MusicGeneratorConst.CHANNEL_SNARE].noteOff(note);
            synth.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(File file, int tempo, byte[] data) {

        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file)) {

            AudioFormat formatIn = audioInputStream.getFormat();
            AudioFormat format = new AudioFormat((float) (formatIn.getSampleRate() * 1.0), formatIn.getSampleSizeInBits(), formatIn.getChannels(), true, formatIn.isBigEndian());
            //a = a + 0.01;

            DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(dinfo);
            if (line != null) {
                line.open(format);
                line.start();
                while(true) {
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
        }
        catch(Exception ex) { ex.printStackTrace(); }
    }
}
