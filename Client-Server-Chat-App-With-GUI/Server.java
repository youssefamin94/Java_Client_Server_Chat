
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(5678); //create a new ServerSocket object and connect to this port
        Socket socket = serverSocket.accept(); //accepts the incoming request to the socket on client's side
        //server waits for client to send a message before running the rest of the code
        
        Scanner fromConsole = new Scanner(System.in);
        Scanner fromClient = new Scanner(socket.getInputStream()); //recieves socket data from client
        PrintWriter fromServer  = new PrintWriter(socket.getOutputStream(),true); //parameter true is equivalent to flush() function
        
        String inputFromServer, inputFromConsole;
        while(true){
            inputFromServer = fromClient.nextLine(); //taking client's message from socket
            System.out.println("Client: "+inputFromServer); //printing client's message      
            if(inputFromServer.equals("stop app")){ //exiting app condition if client wants to exit
              break;
          }
            
            System.out.print("Server: "); 
            inputFromConsole = fromConsole.nextLine(); //taking server's message from console
            fromServer.println(inputFromConsole); //printing server's message
            
              if(inputFromConsole.equals("stop app")){ //exiting app condition if server wants to exit
              break;
          }
        }
        socket.close();
    }
}