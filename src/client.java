import java.io.*;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class client {
    public static void main(String[] args) throws IOException {
      //  sendFiletoServer(new File("C:\\Users\\Malak\\Desktop\\=rand()\\RANDOM\\music\\DESPACITO ( FRENCH VERSION ) LUIS FONSI FT. DADDY YANKEE ( SARA'H COVER ).mp3"), );
    }
    
    public static void sendUsertoServer(User user) throws UnknownHostException, IOException, ClassNotFoundException, SQLException{
        Socket socket = new Socket("localhost", 5555);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        int portnumber = socket.getLocalPort();
        user.setPortNB(portnumber);
        PreparedStatement stmt = SignUpFrame.con.prepareStatement("UPDATE user SET portnumber = " + portnumber + " WHERE email = \"" + user.getEmail() + "\"");
        stmt.executeUpdate();
        out.writeChars("!" + user.getFirstName());
        out.writeChars("@" + user.getLastName());
        out.writeChars("#" + user.getEmail());
        out.writeChars("$" + user.getPassword());
        out.writeChars("%" + user.getPortNB());
        out.close();
       System.out.print("User information send to the server");

        // out.close();
        // in.close();
        // socket.close();
        // malak meh mmm131@mail.aub.edu malak1234 malak1234

    }
    
    public static void sendFiletoServer(File file, String Uploader) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 5555);
        try (FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath())) {
            // Create an output stream to write to write to the server over the socket
            // connection.
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            // Get the name of the file you want to send and store it in filename.
            String fileName = file.getName();
            // Convert the name of the file into an array of bytes to be sent to the server.
            byte[] fileNameBytes = fileName.getBytes();
            // Create a byte array the size of the file so don't send too little or too much
            // data to the server.
            System.out.println("file length: "+file.length());
            // byte[] fileBytes = new byte[(int) file.length()];
            // // Put the contents of the file into the array of bytes to be sent so these
            // // bytes can be sent to the server.
            // fileInputStream.read(fileBytes);
            // Send the length of the name of the file so server knows when to stop reading.
            dataOutputStream.writeInt(fileNameBytes.length);
            // Send the file name.
            dataOutputStream.write(fileNameBytes);

            dataOutputStream.writeLong(file.length());
            // Send the length of the byte array so the server knows when to stop reading.
            // dataOutputStream.writeInt(fileBytes.length);
            // Send the actual file.
            // dataOutputStream.write(fileBytes);

            byte[] buffer = new byte[10*1024];
            int bytes = 0;
            while ((bytes = fileInputStream.read(buffer)) != -1) {
                dataOutputStream.write(buffer, 0, bytes);
                dataOutputStream.flush();
            }

            dataOutputStream.close();
            fileInputStream.close();
            socket.close();
        }

    }
}