package src.simpleHttpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import src.constants.MusicGeneratorConst;
import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class SimpleHttpServer {


    private static final int PORT = 99;

    private HttpServer server;

    public void start()  {

        try {
            InetAddress addr = InetAddress.getLocalHost();
            InetSocketAddress socketAddress = new InetSocketAddress(addr, PORT);
            server = HttpServer.create(socketAddress, 0);
            boolean isBaseDirIdea;

            Path path = Paths.get(MusicGeneratorConst.pathTomcat);

            isBaseDirIdea = !Files.exists(path);

                server.createContext("/", new StaticFileHandler(MusicGeneratorConst.baseDirTomcat ));
                System.out.println("src.SimpleHttpServer baseDirTomcat");

            server.start();
            System.out.println("server.start()");

        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void stop() {
        server.stop(0);
    }
}