package ru.kordyukov;

import ru.kordyukov.threads.BassTh;
import ru.kordyukov.threads.ClapTh;
import ru.kordyukov.threads.CleanMemory;
import ru.kordyukov.threads.ForteTh;
import ru.kordyukov.threads.HatTh;
import ru.kordyukov.threads.HatsTh;
import ru.kordyukov.threads.KickTh;
import ru.kordyukov.threads.LeadTh;
import ru.kordyukov.threads.PianoPTh;
import ru.kordyukov.threads.PianoTh;
import ru.kordyukov.threads.ServerStartTh;
import ru.kordyukov.threads.SnareTh;
import ru.kordyukov.threads.SocketRecTh;
import ru.kordyukov.threads.TomTh;
import ru.kordyukov.window.NewFrame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ru.kordyukov.simpleHttpServer.SimpleHttpServer.socketAddress;

public class MusicGenerator {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool;

        pool = Executors.newScheduledThreadPool(100);
        pool.submit(new ServerStartTh());

        new KickTh().start();

        pool.submit(new BassTh());
        pool.submit(new SnareTh());

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
        pool.submit(new PianoPTh());
        pool.submit(new PianoPTh());

        pool.submit(new PianoTh());

        pool.submit(new TomTh());
        pool.submit(new TomTh());
        pool.submit(new TomTh());
        pool.submit(new TomTh());
        pool.submit(new CleanMemory());

        new NewFrame("MusicGenerator 2022, version 1.0 beta by Kordyukov Denis(Russian, Kherson), " +
                "music translation on: " + socketAddress, 10, 10);
        pool.submit(new SocketRecTh());

    }

}
