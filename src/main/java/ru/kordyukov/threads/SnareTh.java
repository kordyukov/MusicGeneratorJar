package ru.kordyukov.threads;

import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Snare;
import ru.kordyukov.instruments.Trigers.Trigers;

import java.io.File;

public class SnareTh implements Runnable {

    @Override
    public void run() {
        Musician musician = new Trigers();
        Snare snare = new Snare();
        File file;

        file = new File("Snare.wav");
        byte[] data = new byte[1024];

        int temp = 0;
        while (true) {
            temp = musician.tempoTrigerSnare();
            snare.play(file, temp, data);
            try {
                Thread.sleep(temp);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
