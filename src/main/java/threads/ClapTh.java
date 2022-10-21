package threads;

import lombok.SneakyThrows;
import src.Musician;
import src.instruments.Snare;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class ClapTh implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        Musician musician = new Trigers();
        Snare snare = new Snare();
        File file;

        file = new File("clap.wav");

        while (true) {
            snare.play(file, musician.tempoTrigerSnare());
            Thread.sleep(musician.tempoTrigerSnare());
        }
    }
}
