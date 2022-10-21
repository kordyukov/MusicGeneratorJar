package threads;

import lombok.SneakyThrows;
import src.constants.MusicGeneratorConst;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;

public class SocketRecTh implements Runnable{
    @SneakyThrows
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

        file = new File(MusicGeneratorConst.baseDirTomcat);
        if (!file.exists()) file.createNewFile();

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
