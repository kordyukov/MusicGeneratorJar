package ru.kordyukov.threads;

import ru.kordyukov.FortePiano;
import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Trigers.Trigers;

import java.io.File;

public class HatsTh implements Runnable {

    @Override
    public void run() {
        File file;

        file = new File("hats.wav");

        FortePiano hats = new FortePiano();
        Musician musician = new Trigers();
        final int[] temp = {0};
        byte[] data = new byte[1024];

        while (true) {
            temp[0] = musician.tempoTrigerFortePiano() * 2;
            hats.play(file, temp[0], musician.noteTrigerFortePiano(), data);
            try {
                Thread.sleep(temp[0]);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
