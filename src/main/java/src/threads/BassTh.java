package src.threads;

import src.Musician;
import src.instruments.Bass;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class BassTh implements Runnable{

    @Override
    public void run() {
        Musician musician = new Trigers();
        Bass bass = new Bass();

        File file = new File("Bass.wav");

        int temp;
        float note;

        while (true) {
            temp = musician.tempoTrigerBass();
            note = musician.noteTrigerSpeedBass();

            if (!KickTh.kickPlay) {
                bass.play(file, temp, note);
            }

            try {
                Thread.sleep(temp);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
