package threads;

import lombok.SneakyThrows;
import src.Musician;
import src.instruments.Snare;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class SnareTh implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        Musician musician = new Trigers();
        Snare snare = new Snare();
        File file;

        file = new File("Snare.wav");

        int temp = 0;
        while (true) {
            temp = musician.tempoTrigerSnare();
            snare.play(file, temp);
            Thread.sleep(temp);
        }
    }
}
