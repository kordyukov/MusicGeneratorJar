package threads;

import src.Musician;
import src.instruments.Bass;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class TomTh implements Runnable{

    @Override
    public void run() {
        Musician musician = new Trigers();
        Bass bass = new Bass();

        File file = new File("Tom.wav");

        int temp;
        while (true) {
            temp = musician.tempoTrigerBass() * 4;
            bass.play(file, temp, musician.noteTrigerSpeedBass());
            try {
                Thread.sleep(temp);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
