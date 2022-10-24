package src.threads;

import src.Musician;
import src.instruments.Piano;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class PianoTh implements Runnable {

    @Override
    public void run() {
        File file;
        final int[] temp = {0};
        Piano piano = new Piano();
        Musician musician = new Trigers();
        final boolean[] leadPlay = {false};

        file = new File("pad.wav");

        while (true) {
            temp[0] = musician.tempoTrigerBass();
            piano.play(file, temp[0], leadPlay[0] ? musician.noteTrigerSpeedBass() : musician.noteTrigerSpeedBass() * 2);

            try {
                Thread.sleep(temp[0]);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            leadPlay[0] = true;
        }
    }
}
