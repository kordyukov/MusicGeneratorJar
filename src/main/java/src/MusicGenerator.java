package src;

import src.threads.*;
import src.window.NewFrame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MusicGenerator {
    public static void main(String[] args) throws InterruptedException {
        new NewFrame("Генератор музыки 2022, версия 1.0 beta by Kordyukov Denis(Russian, Kherson)", 10, 10);
        ExecutorService pool;
        pool = Executors.newFixedThreadPool(100);
        new KickTh().start();
        pool.submit(new BassTh());
        pool.submit(new SnareTh());

        pool.submit(new PianoPTh());
        pool.submit(new HatTh());
        pool.submit(new HatsTh());
        pool.submit(new HatsTh());
        pool.submit(new HatsTh());
        pool.submit(new HatsTh());
        pool.submit(new ForteTh());
        pool.submit(new ForteTh());
        pool.submit(new ForteTh());
        pool.submit(new ClapTh());
        pool.submit(new LeadTh());
        pool.submit(new LeadTh());
        pool.submit(new LeadTh());

        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));

        pool.submit(new PianoTh());

        pool.submit(new PianoPTh());
        pool.submit(new TomTh());
        pool.submit(new TomTh());
        pool.submit(new TomTh());
        pool.submit(new TomTh());

    }

}
