package threads;

import lombok.SneakyThrows;
import src.Musician;
import src.instruments.Bass;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class TomTh implements Runnable{

    @SneakyThrows
    @Override
    public void run() {
        Musician musician = new Trigers();
        Bass bass = new Bass();

        File file = new File("Tom.wav");

        int temp;
        while (true) {
            temp = musician.tempoTrigerBass() * 4;
            bass.play(file, temp, musician.noteTrigerSpeedBass());
            Thread.sleep(temp);
        }
    }
}
