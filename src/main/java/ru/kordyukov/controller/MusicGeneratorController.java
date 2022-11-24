package ru.kordyukov.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kordyukov.threads.BassTh;
import ru.kordyukov.threads.ClapTh;
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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RestController
public class MusicGeneratorController {

    private final BassTh bassTh;

    private final ClapTh clapTh;

    private final HatsTh hatsTh;

    private final SnareTh snareTh;

    private final SocketRecTh socketRecTh;

    private final TomTh tomTh;

    private final ForteTh forteTh;

    private final KickTh kickTh;

    private final LeadTh leadTh;

    private final ServerStartTh serverStartTh;

    private final PianoPTh pianoPTh;
    private final HatTh hatTh;
    private final PianoTh pianoTh;

    public MusicGeneratorController(BassTh bassTh, ClapTh clapTh,
                                    HatsTh hatsTh, SnareTh snareTh,
                                    SocketRecTh socketRecTh, TomTh tomTh,
                                    ForteTh forteTh, KickTh kickTh,
                                    LeadTh leadTh, ServerStartTh serverStartTh,
                                    PianoPTh pianoPTh, HatTh hatTh, PianoTh pianoTh) {
        this.bassTh = bassTh;
        this.clapTh = clapTh;
        this.hatsTh = hatsTh;
        this.snareTh = snareTh;
        this.socketRecTh = socketRecTh;
        this.tomTh = tomTh;
        this.forteTh = forteTh;
        this.kickTh = kickTh;
        this.leadTh = leadTh;
        this.serverStartTh = serverStartTh;
        this.pianoPTh = pianoPTh;
        this.hatTh = hatTh;
        this.pianoTh = pianoTh;
    }

    @GetMapping
    public String start() throws InterruptedException {
       // new NewFrame("MusicGenerator 2022, version 1.0 beta by Kordyukov Denis(Russian, Kherson)", 10, 10);
        ExecutorService pool;
        pool = Executors.newFixedThreadPool(100);
        pool.submit(kickTh);

        pool.submit(bassTh);

        pool.submit(snareTh);

        pool.submit(pianoPTh);

        pool.submit(hatTh);
        IntStream.range(0, 4).forEach(i -> pool.submit(hatsTh));
        IntStream.range(0, 3).forEach(i ->
                pool.submit(forteTh));

        pool.submit(clapTh);
        IntStream.range(0, 3).forEach(i ->
                pool.submit(leadTh));

        pool.submit(pianoPTh);
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(pianoPTh);
        Thread.sleep(100 + (int) (Math.random() * 5000));
        pool.submit(pianoPTh);
        Thread.sleep(100 + (int) (Math.random() * 5000));

        IntStream.range(0, 2).forEach(i ->
                pool.submit(pianoPTh));


        pool.submit(pianoTh);

        IntStream.range(0, 4).forEach(i ->
                pool.submit(tomTh));

    return "MusicGenerator 2022, version 1.0 beta by Kordyukov Denis(Russian, Kherson)";
    }

}
