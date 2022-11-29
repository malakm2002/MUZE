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

public class server {
    public static void main(String[] args) throws IOException{
        System.out.println("Server Running");
        receiveFilefromClient(HomeFrame.file);
    }

    
    public static void receiveFilefromClient(File file) throws IOException {
         
        // Create a server socket that the server will be listening with.
        ServerSocket serverSocket = new ServerSocket(5555);
        Socket socket;
        DataInputStream dataInputStream;
        DataOutputStream dataOutputstream;

        // This while loop will run forever so the server will never stop unless the application is closed.

        while (true) {
            try {
                // Wait for a client to connect and when they do create a socket to communicate with them.
                socket = serverSocket.accept();

                // Stream to receive data from the client through the socket.
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputstream = new DataOutputStream(socket.getOutputStream());


                // String fileName = dataInputStream.readUTF(); //getname: make sure of how to get the name of the file.

                Thread thread = new ClientHandler(socket, dataInputStream, dataOutputstream);

                thread.start();

            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}

class ClientHandler extends Thread {
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String fileName;

    ClientHandler(Socket socket, DataInputStream dataInputStream, DataOutputStream dataOutputStream){
        this.socket = socket;
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
    }

    public void run() {
        try {
            // Read the size of the file name so know when to stop reading.
            int fileNameLength = dataInputStream.readInt();
            // If the file exists
            if (fileNameLength > 0) {
                // Byte array to hold name of file.
                byte[] fileNameBytes = new byte[fileNameLength];
                // Read from the input stream into the byte array.
                dataInputStream.readFully(fileNameBytes, 0, fileNameBytes.length);
                // Create the file name from the byte array.
                String fileName = new String(fileNameBytes);
                // Read how much data to expect for the actual content of the file.
                long size = dataInputStream.readLong();
                int bytes = 0;
                byte[] buffer = new byte[10*1024];
                // If the file exists.
                if (size > 0) {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\Malak\\Desktop\\AUB\\FALL 2022\\CMPS 242\\project\\muze database\\" + fileName));
                    System.out.println("file uploaded succesfully to the server and added to the database");
                    //TODO handle inserting the audio file to the database
                    while (size > 0 && ((bytes = dataInputStream.read(buffer, 0, (int) Math.min(buffer.length, size)))) != -1) {
                        fileOutputStream.write(buffer, 0, bytes);
                        size -= bytes;
                    }
                    fileOutputStream.close();
                }
                dataInputStream.close();
            }
            else{
                System.out.println("no file to read");
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
