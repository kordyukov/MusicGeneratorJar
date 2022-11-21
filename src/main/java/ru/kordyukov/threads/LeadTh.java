package ru.kordyukov.threads;

import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Piano;
import ru.kordyukov.instruments.Trigers.Trigers;

import java.io.File;

public class LeadTh implements Runnable {

    @Override
    public void run() {
        File file;

        file = new File("lead.wav");
        Musician musician = new Trigers();
        final int[] temp = {0};
        Piano piano = new Piano();
        byte[] data = new byte[1024];

        while (true) {
            temp[0] = musician.tempoTrigerBass();
            piano.play(file, temp[0], musician.noteTrigerSpeedBass(), data);
            try {
                Thread.sleep(temp[0] * 2L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
