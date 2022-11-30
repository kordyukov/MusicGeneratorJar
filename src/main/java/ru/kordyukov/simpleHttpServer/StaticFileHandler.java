package ru.kordyukov.simpleHttpServer;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;

@SuppressWarnings("restriction")
public class StaticFileHandler implements HttpHandler {

    private final String baseDir;

    public StaticFileHandler(String baseDir) {
        this.baseDir = baseDir;
    }

    @Override
    public void handle(HttpExchange ex) {
        try {
            IOException e = null;
            URI uri = ex.getRequestURI();

            String name = new File(uri.getPath()).getName();
            File path = new File(baseDir, name);

            Headers h = ex.getResponseHeaders();
            // Could be more clever about the content type based on the filename here.
            h.add("Content-Type", "audio/wav");
            OutputStream out = ex.getResponseBody();

            if (path.exists()) {
                ex.sendResponseHeaders(200, path.length());
                out.write(Files.readAllBytes(path.toPath()));
            } else {
                System.err.println("File not found: " + path.getAbsolutePath());

                ex.sendResponseHeaders(404, 0);
                out.write("404 File not found.".getBytes());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}