
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
    public static void main(String[] args) throws IOException{
        sendFiletoServer(new File("C:\\Users\\Malak\\Downloads\\songs.jpg"));
    }
    public static void sendFiletoServer(File file) throws UnknownHostException, IOException{
        Socket socket = new Socket("localhost", 2222);
            DataInputStream daInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream daOutputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("Send the file to the server");
        FileInputStream fileInputStream = new FileInputStream(file);
        daOutputStream.writeLong(file.length());
        
        byte[] buffer = new byte[4*1024];
        int bytes = fileInputStream.read(buffer);
        while(bytes!=-1){
            daOutputStream.write(buffer, 0, bytes);
            daOutputStream.flush();
        }
        daInputStream.close();
        daOutputStream.close();
    }

    
}
