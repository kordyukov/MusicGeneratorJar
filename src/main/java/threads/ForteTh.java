package threads;

import lombok.SneakyThrows;
import src.Musician;
import src.instruments.Forte;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class ForteTh implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        Forte forte = new Forte();
        Musician musician = new Trigers();

        File file = new File("forte.wav");

        int temp = 0;
        while (true) {
            temp = musician.tempoTrigerForte();
            forte.play(file, temp, musician.noteTrigerSpeedForte());
            forte.play(file, temp, musician.noteTrigerSpeedForte());

            Thread.sleep(temp);
        }
    }
}
