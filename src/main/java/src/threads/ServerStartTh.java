package src.threads;

import src.simpleHttpServer.SimpleHttpServer;

public class ServerStartTh implements Runnable{
    @Override
    public void run() {
        SimpleHttpServer server = new SimpleHttpServer();
        server.start();
    }
}
