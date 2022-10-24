package src.threads;

import src.FortePiano;

public class PianoPTh implements Runnable{

    @Override
    public void run() {
        FortePiano fortePiano = new FortePiano();

        while (true) {
            fortePiano.PlayPiano(1300);
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
