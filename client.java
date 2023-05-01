import java.net.*;
import java.io.*;
import java.util.*;

public class Client{
  public static void main(String[] args){
    try{
      Socket client = new Socket("localhost" , 7000);
      System.out.println("Client is connected");

      Scanner sc = new Scanner(System.in);

      BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
      PrintWriter pw = new PrintWriter(client.getOutputStream());
      
        // String data = br.readLine();
        // System.out.println("Data from server: " + data);
        

        System.out.println("Enter text: ");
        String input = sc.nextLine();

        pw.println(input);
        pw.flush();

        String output = br.readLine();

        System.out.println("Data from server: " +  output);

      
    }catch(Exception err){
      System.out.println(err);
    }
  }
}