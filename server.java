import java.net.*;
import java.io.*;
import java.util.*; 

public class Server {
  public static void main (String[] args){
      try{
        ServerSocket ss = new ServerSocket(7000);
        System.out.println("Waiting for Client");


        System.out.println("Server is Connected");

        Scanner sc = new Scanner(System.in);


        while(true){
          // System.out.println("Enter Data:");
          // String data = sc.nextLine();
          // pw.println(data);
          // pw.flush();
        Socket server = ss.accept();
        PrintWriter pw = new PrintWriter(server.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));

          String input;
          String output;

          input = br.readLine();
          

          output = input.toUpperCase() + '\n';

          pw.println(output);
          pw.flush();
        }
      } catch(Exception err){
        System.out.println(err);
      }
  }
}