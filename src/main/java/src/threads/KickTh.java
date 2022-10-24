package src.threads;

import src.Musician;
import src.instruments.Bass;
import src.instruments.Kick;
import src.instruments.Trigers.Trigers;

import java.io.File;

public class KickTh extends Thread {
    public static boolean kickPlay = false;

    @Override
    public void run() {
        Bass bass = new Bass();
        Kick kick = new Kick();
        Musician musician = new Trigers();

        File file, file1;

        file1 = new File("Bass.wav");
        file = new File("Kick.wav");
        int temp;
        float note;

        while (true) {
            if (kickPlay) {
                kick.play(file, musician.tempoTrigerKick());
                try {
                    Thread.sleep(musician.tempoTrigerKick());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                kickPlay = false;
            } else {
                temp = musician.tempoTrigerBass();
                note = musician.noteTrigerSpeedBass();
                bass.play(file1, temp, note);
                try {
                    Thread.sleep(temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                kickPlay = true;
            }
        }
    }
}

