package backend;
import FrontEnd0.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
    public static void sendFiletoServer(){
        File file = HomeFrame.file;
       byte[] byteArray = new byte[1];
       int bytesRead ;
       try{
        Socket  clienSocket = new Socket("127.0.0.1", 2222);
        InputStream iStream = clienSocket.getInputStream();
        ByteArrayOutputStream bOutputStream = new ByteArrayOutputStream();
        if(iStream!=null){
            FileOutputStream fOutputStream = new FileOutputStream(file);
        }

       }
       catch(Exception e){

       }
    }

    
}
