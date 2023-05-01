import java.net.*;
import java.io.*;
import java.util.*;

public class Client{
  public static void main(String[] args){
    try{
      DatagramSocket client = new DatagramSocket();
      Scanner sc = new Scanner(System.in);

      byte[] receiveData = new byte[1024];
      byte[] sendData;

      
      System.out.println("Enter text: ");
      String input = sc.nextLine();

      sendData = input.getBytes();

      InetAddress Ip = InetAddress.getByName("localhost");

      DatagramPacket sendPacket = new DatagramPacket(sendData , sendData.length , Ip , 7000);

      client.send(sendPacket);

      DatagramPacket receivePacket = new DatagramPacket(receiveData , receiveData.length);

      client.receive(receivePacket);

      String output = new String(receivePacket.getData() , 0 , receivePacket.getLength());

      System.out.println("From Server: " + output);

      client.close();
      
      
    } catch(Exception err){
      System.out.println(err);
    }
  }
}