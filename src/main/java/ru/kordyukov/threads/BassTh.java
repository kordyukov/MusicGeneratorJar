package ru.kordyukov.threads;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Trigers.Trigers;
import ru.kordyukov.instruments.Bass;

import java.io.File;
import java.io.IOException;

public class BassTh implements Runnable {

    @Override
    public void run() {
        Musician musician = new Trigers();
        Bass bass = new Bass();

        File file = null;
        try {
            file = new ClassPathResource("/Bass.wav").getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] data = new byte[1024];

        int temp;
        float note;

        while (true) {
            temp = musician.tempoTrigerBass();
            note = musician.noteTrigerSpeedBass();

            if (!KickTh.kickPlay) {
                bass.play(file, temp, note, data);
            }
            try {
                Thread.sleep(temp);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
