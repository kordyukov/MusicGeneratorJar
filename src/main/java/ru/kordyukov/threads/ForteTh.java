package ru.kordyukov.threads;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Trigers.Trigers;
import ru.kordyukov.instruments.Forte;

import java.io.File;
import java.io.IOException;

public class ForteTh implements Runnable {

    @Override
    public void run() {
        Forte forte = new Forte();
        Musician musician = new Trigers();

        File file = null;
        try {
            file = new ClassPathResource("/forte.wav").getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] data = new byte[1024];

        int temp = 0;
        while (true) {
            temp = musician.tempoTrigerForte();
            forte.play(file, temp, musician.noteTrigerSpeedForte(), data);
            forte.play(file, temp, musician.noteTrigerSpeedForte(), data);
            try {
                Thread.sleep(temp);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
