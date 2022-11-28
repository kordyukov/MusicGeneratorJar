package ru.kordyukov.threads;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Trigers.Trigers;
import ru.kordyukov.instruments.Hat;

import java.io.File;
import java.io.IOException;

public class HatTh implements Runnable {

    @Override
    public void run() {
        Hat hat = new Hat();
        Musician musician = new Trigers();
        File file;

        try {
            file = new ClassPathResource("/Hat.wav").getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] data = new byte[1024];

        while (true) {
            hat.play(file, musician.tempoTrigerHat(), data);
            try {
                Thread.sleep(musician.tempoTrigerHat());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
