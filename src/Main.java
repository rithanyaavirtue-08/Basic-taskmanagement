import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User[] existingUser = new User[5];
        int AppChoice=1;
        while(AppChoice!=2){

            User currentUser = null;
            try{
            System.out.println("1.Start");
            System.out.println("2.Close");
            System.out.println("Enter you Application Choice:");
            AppChoice=new Integer(sc.nextLine());

            if(AppChoice>2){
                System.out.println("Enter the proper Value");
                continue;
            }
            if(AppChoice==2){
                break;
            }
            else {
                int CurrentUser=0;
                while(CurrentUser!=1&&CurrentUser!=-1){
                System.out.println("Enter your Username:");
                String userName = sc.nextLine();
                System.out.println("Enter your Password:");
                String password = sc.nextLine();


                 CurrentUser = User.UserCheck(existingUser, userName, password);
                if (CurrentUser == 0) {
                    System.out.println("Invalid password");
                }

                else if (CurrentUser == -1) {
                    for (int i = 0; i < existingUser.length; i++) {
                        if (existingUser[i] == null) {
                            currentUser = new User(userName, password);
                            existingUser[i] = currentUser;
                            System.out.println("New User created");
                            break;
                        }
                    }
                }
                else if(CurrentUser==1){
                    for (int i = 0; i < existingUser.length; i++) {
                        if (existingUser[i] != null &&
                                existingUser[i].getUsername().equals(userName) &&
                                existingUser[i].getPassword().equals(password)) {
                            System.out.println("Welcome Back!");
                            currentUser = existingUser[i];
                            break;
                        }
                    }
                }
                }
                }
                }catch(Exception e){
                System.out.println("Enter only valid numbers");
                continue;
            }
                int choice = 0;
                while (choice != 5) {
                    try{
                    System.out.println("Enter your choice");
                    System.out.println("1.Create Task");
                    System.out.println("2.Read Task");
                    System.out.println("3.Update Task");
                    System.out.println("4.Delete Task");
                    System.out.println("5.Exit");
                    choice = Integer.parseInt(sc.nextLine());
                    if(choice>5){
                        System.out.println("Enter the valid choice!");
                        continue;
                    }
                    if (choice == 1) {
                        try{
                        String[] tasks = currentUser.getTaskArray();
                        if (tasks[0] != null) {
                            for (int i = 0; i < tasks.length; i++) {
                                if (tasks[i] != null) {
                                    System.out.println((i + 1) + ". " + tasks[i]);
                                }
                            }
                        }
                        else {
                            System.out.println("There is no previous task Available!");
                        }
                        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                            System.out.println("Enter your task:");
                            String taskName = sc.nextLine();
                            currentUser.getTaskArray()[i] = taskName;
                            System.out.println("Your task created!");
                            System.out.println("Do you want to add another task? (yes/no)");
                            String ans = sc.nextLine();

                            if (ans.equals("no")) {
                                break;
                            }
                        }
                    }catch(Exception e){
                             System.out.println("Enter the valid number!");
                        }
                    }

                    else if (choice == 2) {

                        String[] tasks = currentUser.getTaskArray();
                        if (tasks[0] != null) {
                            for (int i = 0; i < tasks.length; i++) {
                                if (tasks[i] != null) {
                                    System.out.println((i + 1) + ". " + tasks[i]);
                                }
                            }
                        }
                        else {
                            System.out.println("There is no Task Available");
                            break;
                        }
                    }
                    else if(choice==3){
                        String[] tasks = currentUser.getTaskArray();
                        if (tasks[0] != null) {
                            for (int i = 0; i < tasks.length; i++) {
                                if (tasks[i] != null) {
                                    System.out.println((i + 1) + ". " + tasks[i]);
                                }
                            }
                            System.out.println("Enter your Task number to Update:");
                            Integer UpNum=new Integer(sc.nextLine());
                            System.out.println("Enter what do you want to Update:");
                            String TaskUpdate=sc.nextLine();
                            currentUser.getTaskArray()[UpNum-1]=TaskUpdate;
                            System.out.println("Your task Updated!");
                        }
                        else{
                            System.out.println("There is no Task");
                        }
                    }
                    else if(choice==4){
                        String[] tasks = currentUser.getTaskArray();
                        if (tasks[0] != null) {
                            for (int i = 0; i < tasks.length; i++) {
                                if (tasks[i] != null) {
                                    System.out.println((i + 1) + ". " + tasks[i]);
                                }
                            }
                            System.out.println("Enter your task number to delete:");
                            Integer delNum=new Integer(sc.nextLine());
                            currentUser.getTaskArray()[delNum-1]=null;
                            for(int i=0;i<currentUser.getTaskArray().length;i++){
                                if(currentUser.getTaskArray()[i]==null){
                                    for(int j=i+1;j<currentUser.getTaskArray().length;j++){
                                        if(currentUser.getTaskArray()[j]!=null){
                                            String temp=currentUser.getTaskArray()[j];
                                            currentUser.getTaskArray()[j]=currentUser.getTaskArray()[i];
                                            currentUser.getTaskArray()[i]=temp;
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            System.out.println("There is no Task");
                        }
                    }
                }catch(Exception e){
                        System.out.println("Enter only valid number!");
                    }
            }

        }
    }
}
