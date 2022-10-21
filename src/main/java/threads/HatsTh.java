package threads;

import lombok.SneakyThrows;
import src.FortePiano;
import src.Musician;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class HatsTh implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        File file;

        file = new File("hats.wav");

        FortePiano hats = new FortePiano();
        Musician musician = new Trigers();
        final int[] temp = {0};

        while (true) {
            temp[0] = musician.tempoTrigerFortePiano() * 2;
            hats.play(file, temp[0], musician.noteTrigerFortePiano());
            Thread.sleep(temp[0]);
        }
    }
}
