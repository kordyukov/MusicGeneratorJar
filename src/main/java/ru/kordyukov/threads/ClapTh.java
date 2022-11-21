package ru.kordyukov.threads;

import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Trigers.Trigers;
import ru.kordyukov.instruments.Snare;

import java.io.File;

public class ClapTh implements Runnable {

    @Override
    public void run() {
        Musician musician = new Trigers();
        Snare snare = new Snare();
        File file;

        file = new File("clap.wav");
        byte[] data = new byte[1024];

        while (true) {
            snare.play(file, musician.tempoTrigerSnare(), data);
            try {
                Thread.sleep(musician.tempoTrigerSnare());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
