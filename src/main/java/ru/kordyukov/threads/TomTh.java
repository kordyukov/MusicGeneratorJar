package ru.kordyukov.threads;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Bass;
import ru.kordyukov.instruments.Trigers.Trigers;

import java.io.File;
import java.io.IOException;

public class TomTh implements Runnable {

    @Override
    public void run() {
        Musician musician = new Trigers();
        Bass bass = new Bass();

        File file = null;
        file = new File("Tom.wav");
        byte[] data = new byte[1024];

        int temp;
        while (true) {
            temp = musician.tempoTrigerBass() * 4;
            bass.play(file, temp, musician.noteTrigerSpeedBass(), data);
            try {
                Thread.sleep(temp);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
