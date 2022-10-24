package src.threads;

import src.Musician;
import src.instruments.Hat;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class HatTh implements Runnable{

    @Override
    public void run() {
        Hat hat = new Hat();
        Musician musician = new Trigers();
        File file;

        file = new File("Hat.wav");

        while (true) {
            hat.play(file, musician.tempoTrigerHat());
            try {
                Thread.sleep(musician.tempoTrigerHat());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
