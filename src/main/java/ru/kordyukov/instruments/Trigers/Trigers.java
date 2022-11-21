package ru.kordyukov.instruments.Trigers;

import ru.kordyukov.Musician;

import java.util.stream.IntStream;

import static ru.kordyukov.instruments.Trigers.Note.notes;

public class Trigers implements Musician {
    float[] noteSpeed = new float[]{0.50f, 0.56f, 0.63f, 0.66f, 0.75f, 0.84f, 0.94f, 1.0f, 1.12f, 1.27f, 1.34f, 1.50f, 1.66f, 1.86f, 1.98f};
    private Note note;
    private final int[] tempBass = IntStream.of(50, 200, 400).toArray();
    private final int[] tempForte = IntStream.of(50, 200, 400).toArray();
    private final int[] tempKick = IntStream.of(325, 650, 975, 1300).toArray();
    private final int[] tempPiano = IntStream.of(100, 200, 400, 800, 1600).toArray();
    private final int[] tempSnare = IntStream.of(325, 650, 975).toArray();
    private final int[] tempHat = IntStream.of(162, 325, 650, 81, 40, 20).toArray();
    private final int[] tempFortePiano = IntStream.of(325).toArray();
    private int tempo;
    private int tempo1;
    private int tempoKick;
    private int tempoSnare;
    private int tempoHat;
    private int tonicNoteCount;
    private float noteRand = noteSpeed[(int) (Math.random() * 14)];

    public int tempoTrigerBass() {
        tempo = tempBass[((int) (Math.random() * 0))];

        return tempo * 4;
    }

    public int tempoTrigerForte() {
        tempo = tempForte[((int) (Math.random() * 0))];

        return tempo * 4;

    }

    public int tempoTrigerPiano() {
        tempo = tempPiano[((int) (Math.random() * 4))];

        return tempo;
    }

    public int tempoTrigerKick() {
        int p1, p2, p3;
        boolean check;
        p1 = (int) (Math.random() * 9);
        p2 = (int) (Math.random() * 9);


        check = p1 == p2;

        tempoKick = tempKick[((int) (Math.random() * 3))];

        return tempoKick;
    }

    public int tempoTrigerSnare() {
        tempoSnare = tempSnare[((int) (Math.random() * 1))];

        return tempoSnare;
    }

    public int tempoTrigerHat() {
        int p1, p2;
        boolean check;
        p1 = (int) (Math.random() * 9);
        p2 = (int) (Math.random() * 9);

        check = p1 == p2;

        tempoHat = !check ? tempHat[((int) (Math.random() * 5))] : tempHat[((int) (Math.random() * 2))];

        return tempoHat;
    }

    public int tempoTrigerFortePiano() {
        int tempFortePianos = tempFortePiano[0];
        return tempFortePianos;
    }

    public int noteTrigerBass() {

        int a = (int) (Math.random() * 6);
        int b = (int) (Math.random() * 8);
        int note;
        note = notes[a][b];

        if (note < 12) {
            note += 12;
        } else if (note > 48) {
            note -= 24;
        }


        return note;
    }

    public float noteTrigerSpeedBass() {
        float note;
        int shans, shans1;
        boolean fort;
        note = noteSpeed[(int) (Math.random() * 14)];
        shans = (int) (Math.random() * 2);
        shans1 = (int) (Math.random() * 2);

        fort = shans1 == shans;


        if (!fort) {
            noteRand = noteRand;
            return noteRand;
        } else {
            return note;
        }
        //return noteSpeed[0];
    }

    public float noteTrigerSpeedForte() {

        float note = noteSpeed[(int) (Math.random() * 14)];
        int shans = (int) (Math.random() * 2);
        int shans1 = (int) (Math.random() * 2);

        boolean fort = shans1 == shans;


        if (!fort) {

            noteRand = noteRand;
            return noteRand;
        } else {
            return note;
        }

        //return noteSpeed[0];

    }

    public int noteTrigerPiano() {

        int a = (int) (Math.random() * 6);
        int b = (int) (Math.random() * 8);
        int note = notes[a][b];
        return note;
    }

    public float noteTrigerFortePiano() {
        float note;
        note = noteSpeed[(int) (Math.random() * 6)];
        int p1, p2;
        p1 = (int) (Math.random() * 1);
        p2 = (int) (Math.random() * 1);
        if (p1 == p2) {
            return note * 2;
        }

        return note;

    }
}
