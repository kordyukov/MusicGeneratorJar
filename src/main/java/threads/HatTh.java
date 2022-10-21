package threads;

import lombok.SneakyThrows;
import src.Musician;
import src.instruments.Hat;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class HatTh implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        Hat hat = new Hat();
        Musician musician = new Trigers();
        File file;

        file = new File("Hat.wav");

        while (true) {
            hat.play(file, musician.tempoTrigerHat());
            Thread.sleep(musician.tempoTrigerHat());
        }
    }
}
