package ru.kordyukov.threads;

import ru.kordyukov.constants.MusicGeneratorConst;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SocketRecTh implements Runnable {

    @Override
    public void run() {
        // текущий звуковой файл
        File file;
        // аудио формат
        AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
        int MONO = 1;
        // определение формата аудио данных
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, MONO, 2, 44100, true);
        // микрофонный вход
        TargetDataLine mike;
        boolean isBaseDirIdea;

        file = new File(MusicGeneratorConst.baseDir);
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // линию соединения
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
        // проверить, поддерживается ли линия
        if (!AudioSystem.isLineSupported(info)) {
            JOptionPane.showMessageDialog(null, "Line not supported" + info, "Line not supported", JOptionPane.ERROR_MESSAGE);
        }

        try {
            // получить подходящую линию
            mike = (TargetDataLine) AudioSystem.getLine(info);

            // открываем линию соединения с указанным
            // форматом и размером буфера
            mike.open(format, mike.getBufferSize());
            // поток микрофона
            AudioInputStream sound = new AudioInputStream(mike);
            // запустить линию соединения
            mike.start();
            // записать содержимое потока в файл
            AudioSystem.write(sound, fileType, file);
        } catch (LineUnavailableException ex) {
            JOptionPane.showMessageDialog(null, "Line not available" + ex, "Line not available", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "I/O Error " + ex, "I/O Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
