package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private final ExecutorService pool;
    private final int PORT;
    private boolean stopped;

    public HttpServer(int PORT,int poolSize) {
        this.PORT = PORT;
        pool = Executors.newFixedThreadPool(poolSize);
    }
    public void run(){
        try {
            //Создаем сервер
            var server = new ServerSocket(PORT);
            while (!stopped){
                //Ожидаем запрос
                var socket = server.accept();
                System.out.println("Socket accepted");
                pool.submit(()->processSocket(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {
            //step 1 handle request
            System.out.println("Request: "+new String(inputStream.readNBytes(400)));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //step 2 handle response
            var body = Files.readAllBytes(Path.of("resources","example.html"));
            var headers = ("HTTP/1.1 200 OK" +
                    " content-type: text/html").getBytes();
            outputStream.write(headers);
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(body);
        } catch (IOException e) {;
            //TODO: 2/27/21 log error message
            e.printStackTrace();
        }
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}

