import java.net.*;
import java.io.*;

public class Server {
  public static void main(String[] args){

  try{
    DatagramSocket server = new DatagramSocket(7000);

    byte[] receivedData =  new byte[1024];
    byte[] sendData;

    while(true){
      DatagramPacket receivePacket = new DatagramPacket(receivedData , receivedData.length);

      System.out.println("Waiting for client...");

      server.receive(receivePacket);

      System.out.println("Received...");

      String input = new String(receivePacket.getData() , 0 , receivePacket.getLength());

      InetAddress Ip = receivePacket.getAddress();

      int port = receivePacket.getPort();

      String output = input.toUpperCase();

      sendData = output.getBytes();

      DatagramPacket sendPacket = new DatagramPacket(sendData , sendData.length , Ip , port);

      server.send(sendPacket);

      System.out.println("Sent Successfully..." + "\n");
    }
  }
  catch(Exception err){
    System.out.println(err);
  }
  }
}