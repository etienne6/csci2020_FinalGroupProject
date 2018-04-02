package sample.network;

import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        String userInput = "";
        boolean userCon = false;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            Socket s = new Socket("localhost", 6069);
            DataOutputStream dout = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line;

            do{
                dout = new DataOutputStream(s.getOutputStream());

                //will ask the user what they want to say then, will send to server
                System.out.println("What would you like to say?");
                userInput = br.readLine();
                dout.writeUTF(userInput);

                //will take the input coming from the server
                line = in.readLine();
                System.out.println(line);//show the user what they said

                //send response
                userInput = br.readLine();
                dout.writeUTF(userInput);

                if(userInput == "Y"){

                }

            /*System.out.println("End chat?\n[Y] - Yes\n[N] - No");
            userInput = br.readLine();
            if (userInput == "Y"){
              userFin = true;
            }*/
                dout.flush();
            }while(!userCon);
            dout.close();

            s.close();
        }catch(Exception e){System.out.println(e);}
    }
}
