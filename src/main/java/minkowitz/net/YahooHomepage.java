package minkowitz.net;

import java.io.*;
import java.net.Socket;

public class YahooHomepage
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket("www.yahoo.com", 80);
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.write("GET /index.html\n\n");
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = null;
        while((line = reader.readLine()) != null)
        {
            System.out.println(line);
        }
    }
}
