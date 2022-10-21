package threads;

import lombok.SneakyThrows;
import src.Musician;
import src.instruments.Bass;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class BassTh implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        Musician musician = new Trigers();
        Bass bass = new Bass();

        File file = new File("Bass.wav");

        int temp;
        float note;

        while (true) {
            temp = musician.tempoTrigerBass();
            note = musician.noteTrigerSpeedBass();
            bass.play(file, temp, note);
            Thread.sleep(temp);
        }
    }
}
