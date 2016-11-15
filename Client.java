import java.io.PrintWriter;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Client{

  public static void log(String message){
    System.out.println(message);
  }

  public static void main(String args[]){
    try{
      String serverAddress = JOptionPane.showInputDialog("Enter the server IP address:");
      while(true){
        Socket socket = new Socket(serverAddress,9898);
        PrintWriter oStream = new PrintWriter(socket.getOutputStream(),true);
        oStream.println(new Scanner(System.in).nextLine());

        BufferedReader iStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        log(iStream.readLine());
    }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
