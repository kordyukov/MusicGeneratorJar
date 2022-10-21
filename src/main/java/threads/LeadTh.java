package threads;

import lombok.SneakyThrows;
import src.Musician;
import src.instruments.Piano;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class LeadTh implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        File file;

        file = new File("lead.wav");
        Musician musician = new Trigers();
        final int[] temp = {0};
        Piano piano = new Piano();

        while (true) {
            temp[0] = musician.tempoTrigerBass();
            piano.play(file, temp[0], musician.noteTrigerSpeedBass());
            Thread.sleep(temp[0] *2);
        }
    }
}
