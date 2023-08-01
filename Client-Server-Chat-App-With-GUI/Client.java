
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) throws IOException{
      Socket socket = new Socket("localhost",5678); //IP of my machine, server's port number
      
      Scanner fromConsole = new Scanner(System.in);
      Scanner fromServer = new Scanner(socket.getInputStream()); //recieves data from server
      PrintWriter fromClient  = new PrintWriter(socket.getOutputStream(), true);
      
      String input, output;
      while(true){
          System.out.print("Client: ");
          input = fromConsole.nextLine(); //taking client's message from console
          
          fromClient.println(input); //printing client's message
          if(input.equals("stop app")){ //exiting app condition if client wants to exit
              break;
          }
          
          output = fromServer.nextLine(); //taking server's message from console
          System.out.print("Server: ");
          System.out.println(output); //printing server's message
            if(output.equals("stop app")){ //exiting app condition if server wants to exit
              break;
          }
      }
      socket.close();  
  }  
}