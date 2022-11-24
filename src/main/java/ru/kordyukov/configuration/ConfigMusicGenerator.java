package ru.kordyukov.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
public class ConfigMusicGenerator {
    @Bean
    public BassTh getBassTh() {
        return new BassTh();
    }

    @Bean
    public ClapTh getClapTh() {
        return new ClapTh();
    }

    @Bean
    public HatsTh getHatsTh() {
        return new HatsTh();
    }

    @Bean
    public SnareTh getSnareTh() {
        return new SnareTh();
    }

    @Bean
    public SocketRecTh getSocketRecTh() {
        return new SocketRecTh();
    }

    @Bean
    public TomTh getTomTh() {
        return new TomTh();
    }

    @Bean
    public ForteTh getForteTh() {
        return new ForteTh();
    }

    @Bean
    public KickTh getKickTh() {
        return new KickTh();
    }

    @Bean
    public LeadTh getLeadTh() {
        return new LeadTh();
    }

    @Bean
    public ServerStartTh getServerStartTh() {
        return new ServerStartTh();
    }

    @Bean
    public PianoPTh getPianoPTh() {
        return new PianoPTh();
    }

    @Bean
    public HatTh getHatTh() {
       return new HatTh();
    }

    @Bean
    public PianoTh getPianoTh() {
        return new PianoTh();
    }

}
