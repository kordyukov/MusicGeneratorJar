package src.instruments;

import src.constants.MusicGeneratorConst;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.*;
import java.io.File;

public class Hat {
    private int note = 42;
    private int temp;
    private int volume;

    public void playHat(int temp, int volume) {
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            MidiChannel[] channels = synth.getChannels();
            channels[MusicGeneratorConst.CHANNEL_HAT].programChange(MusicGeneratorConst.HAT);
            channels[MusicGeneratorConst.CHANNEL_HAT].noteOn(note, volume);
            Thread.sleep(temp); // in milliseconds
            channels[MusicGeneratorConst.CHANNEL_HAT].noteOff(note);
            synth.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void play(File file, int tempo) {

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            AudioFormat formatIn = audioInputStream.getFormat();
            AudioFormat format = new AudioFormat((float) (formatIn.getSampleRate()*1.0), formatIn.getSampleSizeInBits(), formatIn.getChannels(), true, formatIn.isBigEndian());

            byte[] data = new byte[1024];
            DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine line = (SourceDataLine)AudioSystem.getLine(dinfo);

            if(line!=null) {
                line.open(format);
                line.start();

                float vol = 100;

                while(true) {
                    int k = audioInputStream.read(data, 0, data.length);
                    if(k<0) break;
                    final var volumeControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
                    volumeControl.setValue(20.0f * (float) Math.log10( vol / 100.0 ));

                    line.write(data, 0, k);
                }
                Thread.sleep(tempo);
                line.stop();
                line.close();
            }
        }
        catch(Exception ex) { ex.printStackTrace(); }
    }
}
