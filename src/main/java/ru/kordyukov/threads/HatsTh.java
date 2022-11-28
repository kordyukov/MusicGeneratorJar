package ru.kordyukov.threads;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import ru.kordyukov.FortePiano;
import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Trigers.Trigers;

import java.io.File;
import java.io.IOException;

public class HatsTh implements Runnable {

    @Override
    public void run() {
        File file;

        try {
            file = new ClassPathResource("/hats.wav").getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FortePiano hats = new FortePiano();
        Musician musician = new Trigers();
        final int[] temp = {0};
        byte[] data = new byte[1024];

        while (true) {
            temp[0] = musician.tempoTrigerFortePiano() * 2;
            hats.play(file, temp[0], musician.noteTrigerFortePiano(), data);
            try {
                Thread.sleep(temp[0]);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
