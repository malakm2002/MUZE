package backend;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import FrontEnd0.HomeFrame;

public class server {
    public static void main(String[] args) throws IOException{
        receiveFilefromClient(new File("C:\\Users\\Malak\\Downloads\\listen.jpg"));
    }
    public static void receiveFilefromClient(File file) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2222);
        System.out.println("Server is Starting in port 2222");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connected");
        DataInputStream daInputStream = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream daOutputStream = new DataOutputStream(clientSocket.getOutputStream());

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        long filesize = daInputStream.readLong();
        byte[] buffer = new byte[4 * 1024];
        int bytes = daInputStream.read(buffer, 0, (int) Math.min(buffer.length, filesize));
        while(filesize>0 && bytes!=-1){
            fileOutputStream.write(buffer,0,bytes);
            filesize-=bytes;
        }
fileOutputStream.close();
daInputStream.close();
daOutputStream.close();
clientSocket.close();
    }
}
