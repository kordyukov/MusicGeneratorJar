package ru.kordyukov.threads;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import ru.kordyukov.Musician;
import ru.kordyukov.instruments.Bass;
import ru.kordyukov.instruments.Kick;
import ru.kordyukov.instruments.Trigers.Trigers;

import java.io.File;
import java.io.IOException;

public class KickTh extends Thread {
    public static boolean kickPlay = false;


    @Override
    public void run() {
        Bass bass = new Bass();
        Kick kick = new Kick();
        Musician musician = new Trigers();

        File file, file1;

        try {
            file1 = new ClassPathResource("/Bass.wav").getFile();
            file = new ClassPathResource("/Kick.wav").getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int temp;
        float note;

        byte[] data = new byte[1024];

        while (true) {
            if (kickPlay) {
                kick.play(file, musician.tempoTrigerKick());
                try {
                    Thread.sleep(musician.tempoTrigerKick());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                kickPlay = false;
            } else {
                temp = musician.tempoTrigerBass();
                note = musician.noteTrigerSpeedBass();
                bass.play(file1, temp, note, data);
                try {
                    Thread.sleep(temp);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                kickPlay = true;
            }
        }
    }
}

