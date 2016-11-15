import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.PrintWriter;

public class Server{

  public static void log(String message){
    System.out.println(message);
  }
  public static void main(String args[]){
    try{

        ServerSocket listener = new ServerSocket(9898);
        log("Server started at port: 9898");
        try{
          while(true){
          Socket socket = listener.accept();
          BufferedReader iStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          log(iStream.readLine());

          PrintWriter oStream = new PrintWriter(socket.getOutputStream(),true);
          oStream.println(new Scanner(System.in).nextLine());
        }
        }catch(Exception e){
          e.printStackTrace();
        }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
