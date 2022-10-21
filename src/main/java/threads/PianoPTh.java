package threads;

import lombok.SneakyThrows;
import src.FortePiano;

public class PianoPTh implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        FortePiano fortePiano = new FortePiano();

        while (true) {
            fortePiano.PlayPiano(1300);
            Thread.sleep(1300);
        }
    }
}
