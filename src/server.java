import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class server {
    public static void main(String[] args) throws IOException{
        receiveFilefromClient(new File("C:\\Users\\Lenovo\\Desktop\\Cmps 242\\Project\\Listen.jpeg"));
    }

    
    public static void receiveFilefromClient(File file) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2222);
        
        System.out.println("Server is Starting in port 2222");
        Socket clientSocket = serverSocket.accept();
        clientSocket.getKeepAlive();
        System.out.println("Connected");
        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        long filesize = dataInputStream.readLong();
        byte[] buffer = new byte[4 * 1024];
        int bytes = dataInputStream.read(buffer, 0, (int) Math.min(buffer.length, filesize));

        while(filesize > 0){
            fileOutputStream.write(buffer,0,bytes);
            filesize-=bytes;
        }

        fileOutputStream.close();
        dataInputStream.close();
        dataOutputStream.close();
        clientSocket.close();
    }
}