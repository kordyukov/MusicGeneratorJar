package ru.kordyukov.threads;

import java.time.Duration;

public class CleanMemory implements Runnable{
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(
                        Duration.ofSeconds(3).toMillis()
                );
                System.gc();
            } catch (InterruptedException ignored) {
            }
        }
    }
}
