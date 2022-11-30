package ru.kordyukov.simpleHttpServer;

import com.sun.net.httpserver.HttpServer;
import ru.kordyukov.constants.MusicGeneratorConst;

import javax.swing.JLabel;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ru.kordyukov.window.NewFrame.MyFrame;

@SuppressWarnings("restriction")
public class SimpleHttpServer {

    private static final int PORT = 8080;
    public static InetSocketAddress socketAddress;
    private HttpServer server;

    public void start() {

        try {
            InetAddress addr = InetAddress.getLocalHost();
            socketAddress = new InetSocketAddress(addr, PORT);
            server = HttpServer.create(socketAddress, 0);

            server.createContext("/", new StaticFileHandler(MusicGeneratorConst.baseDirTomcat));

            server.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        server.stop(0);
    }
}