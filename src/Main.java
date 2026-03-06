import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User[] existingUser = new User[5];
        int AppChoice = 1;

        while (AppChoice != 2) {

            User currentUser = null;

            try {
                System.out.println("1.Start");
                System.out.println("2.Close");
                System.out.println("Enter you Application Choice:");
                AppChoice = Integer.parseInt(sc.nextLine());

                if (AppChoice != 1 && AppChoice != 2) {
                    System.out.println("Enter the proper Value");
                    continue;
                }

                else if(AppChoice == 2) {
                    break;
                }
                int CurrentUser = 0;
                while (CurrentUser != 1 && CurrentUser != -1) {

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

                    else if (CurrentUser == 1) {

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

            } catch (Exception e) {
                System.out.println("Enter only valid numbers");
                continue;
            }

            Integer choice = 0;
            while (choice != 5) {
                try {
                    System.out.println("1.Create Task");
                    System.out.println("2.Read Task");
                    System.out.println("3.Update Task");
                    System.out.println("4.Delete Task");
                    System.out.println("5.Exit");
                    System.out.println("Enter your choice");
                    boolean yes = false;
                    choice = new Integer(sc.nextLine());

                    if (choice > 5 || choice < 1) {
                        System.out.println("Enter the valid choice!");
                        continue;
                    }
                    if (choice == 1) {
                        Task[] tasks = currentUser.getTaskArray();
                        if (tasks[0] != null) {
                            for (int i = 0; i < tasks.length; i++) {
                                if (tasks[i] != null) {
                                    System.out.println((i + 1) + ". " + tasks[i].getTitle());
                                    System.out.println("Description: " + tasks[i].getDescription());
                                    System.out.println("Status: " + tasks[i].getStatus());
                                }
                            }
                        }
                        else {
                            System.out.println("There is no Task Available");
                        }

                        for (int i = 0; i < tasks.length; i++) {
                            {
                                if (tasks[i] == null) {
                                    System.out.println("Enter your task title:");
                                    String title = sc.nextLine();
                                    Task task = new Task(title, "To DO");
                                    tasks[i] = task;
                                    while(!yes){
                                    System.out.println("Do you want to add Description? (yes/no)");
                                    String ans = sc.nextLine();
                                    if (ans.equals("yes")) {
                                        System.out.println("Enter Description:");
                                        String desc = sc.nextLine();
                                        task.setDescription(desc);

                                    }
                                    else if(ans.equals("no")||(ans.equals("exit")))
                                    {
                                        break;
                                    }
                                    else{
                                        System.out.println("Enter valid input");
                                    }
                                    }
                                    System.out.println("Task Created!");
                                    try {
                                        while (!yes) {
                                            System.out.println("Do you want to Continue?(yes/no)or give exit");
                                            String con = sc.nextLine();
                                            if (con.equals("yes")) {
                                                break;
                                            }
                                            else if (con.equals("no") || con.equals("exit")) {
                                                throw new Exception();
                                            }
                                            else {
                                                System.out.println("Enter the proper Value");
                                            }
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Your created task Exited");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    else if (choice == 2) {
                        Task[] tasks = currentUser.getTaskArray();
                        if (tasks[0] != null)
                        {   while()
                            System.out.println("1.Display only Task in 'ToDo'");
                            System.out.println("2.Display Tasks in 'In Progress'");
                            System.out.println("3.Display Tasks in 'Progress Done'");
                            System.out.println("4.Display All tasks");
                            System.out.println("Enter your choice:");
                            Integer Display=new Integer(sc.nextLine());
                            if(Display==1){
                                int tasknum=0;
                            for (int i = 0; i < tasks.length; i++) {
                                if ((tasks[i] != null)&& tasks[i].getStatus().equals("To Do")) {
                                    System.out.println((tasknum+1) + ". " + tasks[i].getTitle());
                                    System.out.println("Description: " + tasks[i].getDescription());
                                    System.out.println("Status: " + tasks[i].getStatus());
                                    tasknum++;
                                }
                                else{
                                    continue;
                                }
                            }
                            }
                            else if(Display==2){
                                int tasknum=0;
                                for (int i = 0; i < tasks.length; i++) {
                                    if ((tasks[i] != null)&& tasks[i].getStatus().equals("In Progress")) {
                                        System.out.println((tasknum+1) + ". " + tasks[i].getTitle());
                                        System.out.println("Description: " + tasks[i].getDescription());
                                        System.out.println("Status: " + tasks[i].getStatus());
                                        tasknum++;
                                    }
                                    else{
                                        continue;
                                    }
                                }
                            }
                            else if(Display==3){
                                int tasknum=0;
                                for (int i = 0; i < tasks.length; i++) {
                                    if ((tasks[i] != null)&& tasks[i].getStatus().equals("To Do")) {
                                        System.out.println((tasknum+1) + ". " + tasks[i].getTitle());
                                        System.out.println("Description: " + tasks[i].getDescription());
                                        System.out.println("Status: " + tasks[i].getStatus());
                                        tasknum++;
                                    }
                                    else{
                                        continue;
                                    }
                                }
                            }
                            else if(Display==4) {
                                int tasknum = 0;
                                for (int i = 0; i < tasks.length; i++) {
                                    if ((tasks[i] != null) && tasks[i].getStatus().equals("Progress Done")) {
                                        System.out.println((tasknum + 1) + ". " + tasks[i].getTitle());
                                        System.out.println("Description: " + tasks[i].getDescription());
                                        System.out.println("Status: " + tasks[i].getStatus());
                                        tasknum++;
                                    }
                                    else {
                                        continue;
                                    }
                                }
                            }
                            else{
                                System.out.println("Enter the Valid Task choice!");
                            }
                            while(!yes) {
                                try{
                                    System.out.println("Do you what to Continue?(yes/no)or give exit");
                                    String con = sc.nextLine();
                                    if (con.equals("yes")) {
                                        continue;
                                    }
                                    else if (con.equals("no") || con.equals("exit")) {
                                        throw new Exception();
                                    }
                                    else {
                                        System.out.println("Enter proper value of string");
                                    }
                                }catch(Exception e) {
                                    System.out.println("Your Update task Exited");
                                    break;
                                }
                            }

                        }
                        else {
                            System.out.println("There is no Task Available");
                        }
                    }
                    else if (choice == 3) {
                    while(!yes){
                        Task[] tasks = currentUser.getTaskArray();
                        if(tasks[0]!=null){
                        for (int i = 0; i < tasks.length; i++) {
                            if (tasks[i] != null) {
                                System.out.println((i + 1) + ". " + tasks[i].getTitle());
                            }
                            else {
                                break;
                            }
                        }
                        }
                        else{
                            break;
                        }
                        System.out.println("Enter your Task number to Update:");
                        Integer UpNum = new Integer(sc.nextLine());
                        if (UpNum - 1 >= tasks.length || tasks[UpNum - 1] == null) {
                            System.out.println("Invalid Task Number");
                            continue;
                        }
                        System.out.println("Which you want to Update");
                        System.out.println("1.Title");
                        System.out.println("2.Status");
                        System.out.println("3.Description");

                        int UpdateChoice = Integer.parseInt(sc.nextLine());

                        if (UpdateChoice == 1) {
                            System.out.println("Enter new task name:");
                            String title = sc.nextLine();
                            tasks[UpNum - 1].setTitle(title);
                            System.out.println("Task Title Updated!");
                        }
                        else if (UpdateChoice == 2) {
                            int statusChoice = 0;
                            while (statusChoice != 1 && statusChoice != 2 && statusChoice != 3) {
                                System.out.println("Update your Current Task Status!");
                                System.out.println("1.To Do");
                                System.out.println("2.In Progress");
                                System.out.println("3.Progress Done");
                                statusChoice = new Integer(sc.nextLine());
                                if (statusChoice == 1) {
                                    tasks[UpNum - 1].setStatus("To Do");
                                }
                                else if (statusChoice == 2) {
                                    tasks[UpNum - 1].setStatus("In Progress");
                                }
                                else if (statusChoice == 3) {
                                    tasks[UpNum - 1].setStatus("Progress Done");
                                }

                                else {
                                    System.out.println("Enter proper value!");
                                }
                            }

                            System.out.println("Status Updated!");
                        }

                        else if (UpdateChoice == 3) {
                            System.out.println("Enter new Description:");
                            String desc = sc.nextLine();
                            tasks[UpNum - 1].setDescription(desc);
                            System.out.println("Description Updated!");
                        }

                            while(!yes) {
                                try{
                                System.out.println("Do you what to Continue?(yes/no)or give exit");
                                String con = sc.nextLine();
                                if (con.equals("yes")) {
                                    continue;
                                }
                                else if (con.equals("no") || con.equals("exit")) {
                                    throw new Exception();
                                }
                                else {
                                    System.out.println("Enter proper value of string");
                                }
                            }catch(Exception e) {
                                    System.out.println("Your Update task Exited");
                                    break;
                                }
                        }
                    }

                    }
                    else if (choice == 4) {
                        while (true) {
                            try {
                                Task[] tasks = currentUser.getTaskArray();
                                for (int i = 0; i < tasks.length; i++) {
                                    if (tasks[i] != null) {
                                        System.out.println((i + 1) + ". " + tasks[i].getTitle());
                                    }
                                }
                                System.out.println("Enter your task number to delete:");
                                int delNum = new Integer(sc.nextLine());
                                if (delNum - 1 >= tasks.length || tasks[delNum - 1] == null) {
                                    System.out.println("Invalid Task Number");
                                    continue;
                                }
                                tasks[delNum - 1] = null;
                                for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                                    if (currentUser.getTaskArray()[i] == null) {
                                        for (int j = i + 1; j < currentUser.getTaskArray().length; j++) {
                                            if (currentUser.getTaskArray()[j] != null) {
                                                Task temp = currentUser.getTaskArray()[j];
                                                currentUser.getTaskArray()[j] = currentUser.getTaskArray()[i];
                                                currentUser.getTaskArray()[i] = temp;
                                            }
                                        }
                                    }
                                }
                                System.out.println("Task Deleted!");
                               try{
                                while(!yes) {

                                    System.out.println("Do you what to Continue?(yes/no)or give exit");
                                    String con = sc.nextLine();
                                    if (con.equals("yes")) {
                                        break;
                                    }
                                    else if (con.equals("no") || con.equals("exit")) {
                                        throw new Exception();
                                    }
                                    else {
                                        System.out.println("Enter proper value of string");
                                    }
                                }}catch(Exception e){
                                   System.out.println("Your Delete task Exited");
                                   break;
                               }
                        }catch(Exception e){
                                System.out.println("Enter only valid number!");
                        }

                    }
                }
                    else if (choice == 5) {
                        System.out.println("Your Exiting");
                        break;
                    }

                } catch (Exception e) {

                    System.out.println("Enter only valid number!");

                }
            }
        }
        while (AppChoice != 2) {
            try {
                System.out.println("1.Start");
                System.out.println("2.Close");
                System.out.println("Enter you Application Choice:");
                AppChoice = Integer.parseInt(sc.nextLine());

                if (AppChoice != 1 && AppChoice != 2) {
                    System.out.println("Enter the proper Value");
                    continue;
                }
                else if (AppChoice == 2) {
                    System.out.println("Application Closed");
                    break;
                }
            }catch(Exception e){
                System.out.println("Enter only valid numbers");
                continue;
                }

            }
}
    }