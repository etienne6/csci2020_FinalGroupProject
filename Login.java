import java.io.*;
import java.util.*;
import java.io.File;
import java.io.PrintWriter;


public class GameFiles{

  protected FileReader in = null;
  protected FileWriter out = null;
  protected String userName = "";
  protected String userPass = "";
  protected String newuserName = "";
  protected String newuserPass = "";
  protected final String dataBaseFile = "KroggDatabase.txt";
  public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public GameFiles(){}

  public void SignIn(){
    boolean success = true;
    do{
      try{

        /*******

        integrate UI here

        *********/

        System.out.println("Enter username:");
        this.userName = br.readLine();
        System.out.println("Enter password:");
        this.userPass = br.readLine();
      } catch(IOException e){System.out.println(e);}

      success = CheckUsername(this.userName, this.userPass, false);
      if(success){
        System.out.println("You have successfully logged in.");
      } else {
        System.out.println("\n\n\nPassword or Username may be incorrect. Please try again:\n\n\n");
      }
    }while(!success);
  }

  //checkusername parameters more meant for checking userName for register
  public boolean CheckUsername(String user, String pass, boolean register){
    String line = "";
    try{
      FileReader fileReader = new FileReader(this.dataBaseFile);
      BufferedReader bin = new BufferedReader(fileReader);
      try{
        while((line = bin.readLine()) != null){
          String[] array = line.split(" ");
          if(array[0].equals(user)){
            if(register){
                return true;
            }
            if(array[1].equals(pass)){
                return true;
            }
          }
        }

        bin.close();
        fileReader.close();
      }catch(IOException e){System.out.println(e);}
    }catch(FileNotFoundException e){System.out.println("Unable to open file.");}

    return false;
  }

  public void Register(){
    boolean taken = false;
    try{
      do{

        /*******

        integrate UI here

        *********/

        System.out.println("Please enter new username:");
        this.newuserName = br.readLine();

        //check if the username is taken
        taken = CheckUsername(this.newuserName, "fluff", true);
        if(taken){
          System.out.println("\n\nError: Username has been taken. Please try again.\n\n");
        }
      }while(taken);

      /*******

      integrate UI here

      *********/

      System.out.println("Please enter new password:");
      this.newuserPass = br.readLine();

      /*PrintWriter pw = new PrintWriter(dataBaseFile);
      pw.println((this.newuserName + " " + this.newuserPass));
      pw.close();*/

      FileWriter fileWriter = new FileWriter(this.dataBaseFile);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      bufferedWriter.write(this.newuserName + " " + this.newuserPass);

      bufferedWriter.close();
      fileWriter.close();


      System.out.println("Your account now has been saved.");
    }catch(IOException e){System.out.println(e);}
  }

  public String getUsername() { return this.userName; }
  public String getPassword() { return this.userPass; }

  public static void main(String[] args)throws IOException{
    GameFiles newuser = new GameFiles();


    /*******

    integrate UI here

    *********/


    if(args[0].equals("Login")){
      newuser.SignIn();
    }else if(args[0].equals("Register")){
      newuser.Register();
    }
  }
}
