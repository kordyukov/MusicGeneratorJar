package ru.kordyukov.threads;

import ru.kordyukov.simpleHttpServer.SimpleHttpServer;

public class ServerStartTh implements Runnable {
    @Override
    public void run() {
        SimpleHttpServer server = new SimpleHttpServer();
        server.start();
    }
}
