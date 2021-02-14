import java.io.*;
import java.net.*;
import java.util.*;


public class Krogg_Client{

  String username = "", address = "localhost";
  ArrayList<String> users = new ArrayList<>();
  int port = 2222;
  Boolean isConnected = false;

  Socket sock;
  BufferedReader reader;
  PrintWriter writer;

  public void ListenThread(){
       Thread IncomingReader = new Thread(new IncomingReader());
       IncomingReader.start();
  }
  public void userAdd(String data){
       users.add(data);
  }
  public void userRemove(String data){
       System.out.println(data + " is now offline.\n");
  }
  public void writeUsers(){
       String[] tempList = new String[(users.size())];
       users.toArray(tempList);
       for (String token:tempList)
       {
           //users.append(token + "\n");
       }
  }
  public void sendDisconnect(){
      String bye = (username + ": :Disconnect");
      try
      {
          writer.println(bye);
          writer.flush();
      } catch (Exception e){};
  }
  public void Disconnect(){
      try
      {
          System.out.println("Disconnected.\n");
          sock.close();
      } catch(Exception ex) {}
      isConnected = false;
  }

  public class IncomingReader implements Runnable{
      @Override
      public void run()
      {
          String[] data;
          String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

          try
          {
              while ((stream = reader.readLine()) != null)
              {
                   data = stream.split(":");

                   if (data[2].equals(chat))
                   {
                      System.out.println(data[0] + ": " + data[1] + "\n");
                   }
                   else if (data[2].equals(connect))
                   {
                      userAdd(data[0]);
                   }
                   else if (data[2].equals(disconnect))
                   {
                       userRemove(data[0]);
                   }
                   else if (data[2].equals(done))
                   {
                      //users.setText("");
                      writeUsers();
                      users.clear();
                   }
              }
         }catch(Exception ex) { }
      }
  }

  //button option
  public void connect()throws IOException{
    if (isConnected == false)
    {
        reader = new BufferedReader(new InputStreamReader(System.in));

        //simulates log in screen
        System.out.println("Username?");
        username = reader.readLine();


        sock = new Socket(address, port);
        InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
        reader = new BufferedReader(streamreader);
        writer = new PrintWriter(sock.getOutputStream());
        writer.println(username + ":has connected.:Connect");
        writer.flush();
        isConnected = true;


        ListenThread();

    } else if (isConnected == true)
    {
        System.out.println("You are already connected. \n");
    }
  }

  //button option
  public void disconnect(){
    sendDisconnect();
    Disconnect();
  }

  public void send()throws IOException{
    reader = new BufferedReader(new InputStreamReader(System.in));

    String nothing = "";
    System.out.println("Message? : ");
    nothing = reader.readLine();

    try {
       writer.println(username + ":" + nothing + ":" + "Chat");
       writer.flush(); // flushes the buffer
    } catch (Exception ex) {}
  }


  public static void main(String[] args)throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Krogg_Client newval = new Krogg_Client();
    String userchoice = " ";
    newval.connect();

    do{
      System.out.println("[1] - Message\n[2] - Disconnect");
      userchoice = reader.readLine();
      if(userchoice.equals("1")){
        newval.send();
      }else if(userchoice.equals("2")){
        newval.disconnect();
      }
    }while(userchoice.equals("1"));

  }
}
