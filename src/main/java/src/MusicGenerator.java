package src;

import threads.ClapTh;
import threads.ForteTh;
import threads.HatTh;
import threads.HatsTh;
import threads.KickTh;
import threads.LeadTh;
import threads.PianoPTh;
import threads.SnareTh;
import threads.TomTh;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MusicGenerator {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool;
        pool = Executors.newFixedThreadPool(50);
        new KickTh().start();

        pool.submit(new SnareTh());

        pool.submit(new PianoPTh());
        pool.submit(new HatTh());
        pool.submit(new HatsTh());
        pool.submit(new HatsTh());
        pool.submit(new HatsTh());
        pool.submit(new HatsTh());
        pool.submit(new ForteTh());
        pool.submit(new ClapTh());
        pool.submit(new LeadTh());
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(new PianoPTh());
        pool.submit(new TomTh());
        pool.submit(new TomTh());
    }

}
