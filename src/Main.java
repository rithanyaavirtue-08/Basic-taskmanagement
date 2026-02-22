import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        User[] existingUser = new User[5];

        while(true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome");
            System.out.println("Enter your Username:");
            String username = new String(sc.nextLine());

            System.out.println("Welcome " + username);
            User currentUser = null;
            for (int i = 0; i < existingUser.length; i++) {
                if (existingUser[i] == null) {
                    currentUser = new User(username);
                    existingUser[i] = currentUser;
                    break;
                }
                else if (existingUser[i] != null) {
                    if (existingUser[i].getUsername().equals(username)) {
                        System.out.println("Welcome back " + username);
                        break;
                    }
                }
            }
            User tasks = null;
            boolean no=false;
            boolean exit = false;
            boolean yes=false;
            int taskCnt=0;
            Integer choice = 0;
            while (choice != 4) {
                System.out.println("What you need?");
                System.out.println("1.Add task");
                System.out.println("2.List Task");
                System.out.println("3.Exit");
                System.out.println("Enter your choice:");
                choice =new Integer(sc.nextLine());

                if (choice == 1) {
                    try
                    {while(!yes)
                    {

                    String[] arr = currentUser.getTaskArray();
                    boolean isTaskAvailable=false;

                            for(int i=0;i<currentUser.getTaskArray().length;i++){
                                if(arr[i]!=null){
                                    String Title=currentUser.getTaskArray()[i];
                            System.out.print(i+1+".");
                            System.out.println(Title);
                                isTaskAvailable=true;}
                                else{
                                    break;
                                }
                            }
                            if(isTaskAvailable){
                                System.out.println("Your previous Task displayed!");

                            }
                            else{
                                System.out.println("No task added before");
                            }


                    System.out.println("Enter your Task Title:");
                    String taskTitle =new String(sc.nextLine());
                    if (currentUser != null) {
                        currentUser.getTaskArray()[taskCnt]=taskTitle;
                    }
                    taskCnt++;
                    while(!yes) {
                        System.out.println("Do you what to Continue?(yes/no)or give exit");
                        String con = new String(sc.nextLine());
                        if (con.equals("yes")) {
                            break;
                        }
                        else if (con.equals("no") || con.equals("exit")) {
                            throw new Exception();
                        }
                        else {
                            System.out.println("Enter proper value of string");
                        }
                    }
                }
                    }catch(Exception e){
                        System.out.println("Your added task exited");

                    }

                }
                else if(choice==2){
                    String[] arr = currentUser.getTaskArray();
                    boolean isTaskAvailable=false;
                    for(int i=0;i<currentUser.getTaskArray().length;i++){
                        if(arr[i]!=null){
                            String Title=currentUser.getTaskArray()[i];
                            System.out.print(i+1+".");
                            System.out.println(Title);
                            isTaskAvailable=true;}
                        else{
                            break;
                        }
                    }
                    if(!isTaskAvailable){
                        System.out.println("No task available in list");
                    }
                }
                else if(choice==3){
                    while(!yes){
                            try{
                                String[] arr = currentUser.getTaskArray();
                                boolean isTaskAvailable=false;
                                for(int i=0;i<currentUser.getTaskArray().length;i++){
                                    if(arr[i]!=null){
                                        String Title=currentUser.getTaskArray()[i];
                                        System.out.print(i+1+".");
                                        System.out.println(Title);
                                        isTaskAvailable=true;}
                                    else{
                                        break;
                                    }
                                }
                                if(!isTaskAvailable){
                                    System.out.println("No task available in list");
                                }

                        System.out.println("Enter your task number to update:");
                        Integer upt = new Integer(sc.nextLine());
                       {
                        if (upt < currentUser.getTaskArray().length && currentUser.getTaskArray()[upt-1] != null) {
                            System.out.println("Enter what do you want to update:");
                            String upName = new String(sc.nextLine());
                            currentUser.getTaskArray()[upt-1] = upName;
                            System.out.println("your Task Updated!");
                        }
                        else{
                            throw new Exception();
                        }}
                        try{
                        while (!yes) {
                            System.out.println("Do you what to Continue?(yes/no)or give exit");
                            String con = new String(sc.nextLine());
                            if (con.equals("yes")) {
                                break;
                            }
                            else if (con.equals("no") || con.equals("exit")) {
                                throw new Exception();
                            }
                            else {
                                System.out.println("Enter proper value of string");
                            }
                        }
                    }catch(Exception e){
                            System.out.println("Your Exited!");
                            break;
                        }



                }catch(Exception e){
                        System.out.println("Enter the proper value to update!");
                        continue;
                    }
                }}
                else if (choice == 4) {
                    System.out.println("Task Manager Exited");
                    break;
                }
                else {
                    System.out.println("Enter a value choice");
                }
            }
        }
    }
}
