package client;

import java.io.IOException;
import java.net.URL;

public class UrlExample {
    public static void main(String[] args) throws IOException {

    }
    public static void checkFile() throws IOException {
        var file  = new URL("file:C:/Users/mudan/IdeaProjects/sockets/com/mks/http/sockets/DatagramRunner.java");
        var connect = file.openConnection();
        System.out.println(connect.getContentLength());
    }
    public static void checkGoogle() throws IOException {
        var url = new URL("https://google.com");
        var urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        try(var outputStream = urlConnection.getOutputStream()){
        }
        System.out.println();
    }
}
