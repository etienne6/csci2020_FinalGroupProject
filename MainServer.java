import java.net.*;
import java.io.*;
import java.util.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;


public class MainServer implements Runnable{

  protected int port = 6069;
  protected ServerSocket sSocket = null;
  protected Socket socket = null;
  protected boolean isStopped = false; //only family members can access protected variables
  protected Thread runningThread = null;

  public MainServer(int serverPort){
    this.port = serverPort;
  }

  public void run(){
    //declare variables for the program
    ArrayList<String> brain = new ArrayList<>();
    //determine if the
    synchronized(this){
      this.runningThread = Thread.currentThread();
    }

    //open the socket for server
    try{
      this.sSocket = new ServerSocket(this.port);

      while(! isStopped()){
        try{
          boolean finished = false;
          socket = this.sSocket.accept(); //connects client to server via connection

          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream dataInput = new DataInputStream(socket.getInputStream());
          String clientInput = (String)dataInput.readUTF();
          brain.add(clientInput);
          for(String val: brain){
            System.out.println(val);
          }

          do{
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Would you like to end the chat?\n[Y] - Yes\n[N] - No");
            clientInput = (String)dataInput.readUTF();
            if(clientInput == "Y"){
              finished = true;
            }
          } while(!finished);

        } catch (RuntimeException e) {System.out.println(e);}
        new Thread(new ClientConnectionHandler(socket, "Multithreaded")).start();
      }
    } catch(IOException e) { System.out.println(e); }
  }

  private synchronized boolean isStopped(){ //all other threads wait till intial thread is activated
    return this.isStopped;
  }

  public synchronized void stop(){
        this.isStopped = true;
        try {
            this.sSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

  public static void main(String[] args){

    MainServer server = new MainServer(6069);
    new Thread(server).start(); //allows for multhreading

    try {
        Thread.sleep(3600 * 1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    //try{
        server.stop();
    /*} catch (SocketException e){
      System.out.println("Server is stopping.");
    }*/

    }
}

