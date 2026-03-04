import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
          User[] existingUser=new User[5];
          User currentUser=null;
          System.out.println("Enter your Username:");
          String userName=sc.nextLine();
          System.out.println("Enter your Password:");
          String password=sc.nextLine();
          if(existingUser[0]!=null){
          for(int i=0;i<existingUser.length;i++) {
              if(existingUser[i].getUsername().equals(userName)){
                  System.out.println("Welcome Back"+userName);
                  break;
          }
              else{
                  existingUser[i].setUsername(userName);
                  existingUser[i]=currentUser;
              }
          }
          }
          System.out.println("Enter your choice");
          System.out.println("1.Create Task");
          System.out.println("2.Read Task");
          System.out.println("3.Update Task");
          System.out.println("4.Delete Task");
          int choice= new Integer(sc.nextLine());
          if(choice==1){
              int taskcnt=0;
              for(int i=0;i<existingUser[i].getTaskArray().length;i++){
                  if(existingUser[taskcnt].getTaskArray()==null){
              System.out.println("Enter your task:");
              String taskName=sc.nextLine();
              System.out.println("Your task created!");
              existingUser[taskcnt].getTaskArray()[taskcnt]=taskName;
              taskcnt++;
          }
          }}
          else if(choice==2){
              if(existingUser[)
              for(int i=0;i<existingUser[i].getTaskArray().length;i++){
                  if(existingUser[i].getTaskArray()!=null) {
                      String tasks = existingUser[i].getTaskArray()[i];
                      System.out.println(i + 1 + "." + tasks);
                  }
                  else{
                     System.out.println("Task Displayed!");
                      break;
                  }
              } System.out.println("There is no task Available");


          }
          else if(choice==3){

          }
          else if(choice==4){

          }
          else{

          }

    }
}