package ru.kordyukov.threads;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Piano;
import ru.kordyukov.instruments.Trigers.Trigers;

import java.io.File;
import java.io.IOException;

public class PianoTh implements Runnable {

    @Override
    public void run() {
        File file;
        final int[] temp = {0};
        Piano piano = new Piano();
        Musician musician = new Trigers();
        final boolean[] leadPlay = {false};
        byte[] data = new byte[1024];

        try {
            file = new ClassPathResource("/pad.wav").getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            temp[0] = musician.tempoTrigerBass();
            piano.play(file, temp[0], leadPlay[0] ? musician.noteTrigerSpeedBass() : musician.noteTrigerSpeedBass() * 2, data);
            try {
                Thread.sleep(temp[0]);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            leadPlay[0] = true;
        }
    }
}
