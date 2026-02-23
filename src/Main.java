import java.util.Scanner;

public class Main{
    static void main(String[] args){
        User[] existingUser = new User[5];

        while(true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome");
            System.out.println("Enter your Username:");
            String username = sc.nextLine();

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
            while (choice !=5) {
                System.out.println("What you need?");
                System.out.println("1.Add task");
                System.out.println("2.List Task");
                System.out.println("3.Update");
                System.out.println("4.Delete");
                System.out.println("5.Exit");
                System.out.println("Enter your choice:");
                choice = Integer.valueOf(sc.nextLine());

                if (choice == 1) {
                    try
                    {while(!yes)
                    {

                    Task[] arr = currentUser.getTaskArray();
                    boolean isTaskAvailable=false;

                            for(int i=0;i<currentUser.getTaskArray().length;i++)
                            {
                                if(arr[i]!=null){
                                    Task Title=currentUser.getTaskArray()[i];

                            System.out.print(i+1+".");
                            System.out.println(Title.getTitle());
                            if(Title.getStatus()==null){
                                System.out.println("Status:To Do");
                            }
                            else{
                            System.out.println("Status:"+Title.getStatus());}

                            System.out.println("Description:"+Title.getDescription());
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
                    Task taskTitle = new Task(sc.nextLine(),"To Do");
                    currentUser.getTaskArray()[taskCnt]=taskTitle;
                        while(!yes) {
                            System.out.println("Do you what to add Description?(yes/no)");
                            String con = sc.nextLine();
                            if (con.equals("yes")) {
                               System.out.println("Enter your Description");
                               String des=sc.nextLine();
                               currentUser.getTaskArray()[taskCnt].setDescription(des);
                               break;
                            }
                            else if (con.equals("no"))   {
                               break;
                            }
                            else {
                                System.out.println("Enter proper value of string");
                            }
                        }

                    taskCnt++;
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
                    }
                }
                    }catch(Exception e){
                        System.out.println("Your added task exited");

                    }

                }
                else if(choice==2)
                {Task[] arr = null;
                    if (currentUser != null) {
                        arr = currentUser.getTaskArray();

                    try{
                     {
                        boolean isTaskAvailable = false;
                        System.out.println("What do what to Display?");
                        System.out.println("1.Diplay ToDo Task");
                        System.out.println("2.Display In Progress Task");
                        System.out.println("3.Display Progress Done Task");
                        Integer display = new Integer(sc.nextLine());
                        if (display == 1) {
                            try{
                            for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                                Task task = currentUser.getTaskArray()[i];
                                if (task != null && "To Do".equals(task.getStatus())) {
                                    System.out.println((i+1) + ". " + task.getTitle());
                                }

                            }

                        }catch(Exception e){
                                System.out.println("No task available in list");
                            }
                        }
                        else if (display == 2) {
                            for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                                if (currentUser.getTaskArray()[i].getTitle().equals("In Progress")) {
                                    if (arr[i] != null) {
                                        Task Title = currentUser.getTaskArray()[i];
                                        System.out.print(i + 1 + ".");
                                        System.out.println(Title.getTitle());
                                        isTaskAvailable = true;
                                    }
                                    else {
                                        break;
                                    }
                                }
                            }
                            if (!isTaskAvailable) {
                                System.out.println("No task available in list");
                            }
                        }
                        else if (display == 3) {
                            for (int i = 0; i < currentUser.getTaskArray().length; i++)
                            {if (currentUser.getTaskArray()[i].getTitle().equals("Progress Done")) {
                                        if (arr[i] != null) {
                                            Task Title = currentUser.getTaskArray()[i];
                                            System.out.print(i + 1 + ".");
                                            System.out.println(Title.getTitle());
                                            isTaskAvailable = true;
                                        }
                                        else {
                                            break;
                                        }
                                    }
                            }
                                if (!isTaskAvailable) {
                                    System.out.println("No task available in list");

                                }
                        }
                    }
                        try {
                            while (!yes) {
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
                            }
                        } catch (Exception e) {
                            System.out.println("Your Exited!");
                            break;
                        }
                }catch(Exception e){
                        System.out.println("There is no Task Available");
                    }
                    }
                }
                else if(choice==3){
                    while(!yes){
                            try{
                                Task[] arr = currentUser.getTaskArray();
                                boolean isTaskAvailable=false;
                                for(int i=0;i<currentUser.getTaskArray().length;i++){
                                    if(arr[i]!=null){
                                        Task Title=currentUser.getTaskArray()[i];
                                        System.out.print(i+1+".");
                                        System.out.println(Title.getTitle());
                                        isTaskAvailable=true;}
                                    else{
                                        break;
                                    }
                                }
                                if(!isTaskAvailable){
                                    System.out.println("No task available in list");
                                }

                        System.out.println("Enter your task number to update:");
                        Integer upt = Integer.valueOf(sc.nextLine());
                                if (upt < currentUser.getTaskArray().length && currentUser.getTaskArray()[upt - 1] != null)
                                {
                                    System.out.println("Which you want to Update");
                                    System.out.println("1.Title");
                                    System.out.println("2.Status");
                                    System.out.println("3.Description");
                                    System.out.println("Enter your choice:");
                                    Integer cn = new Integer(sc.nextLine());
                                    if (cn == 1) {
                                        if (upt < currentUser.getTaskArray().length && currentUser.getTaskArray()[upt - 1] != null) {
                                            System.out.println("Enter what do you want to update:");
                                            Task upName = new Task(sc.nextLine());
                                            currentUser.getTaskArray()[upt - 1] = upName;
                                            System.out.println("your Task Title Updated!");
                                        }
                                        else {
                                            throw new Exception();
                                        }
                                        try {
                                            while (!yes) {
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
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Your Exited!");
                                            break;
                                        }

                                    }
                                    else if (cn == 2) {

                                        while (true) {
                                            System.out.println("What Status are you now?");
                                            System.out.println("1.To Do");
                                            System.out.println("2.In Progress");
                                            System.out.println("3.Progress Done");
                                            System.out.println("Enter your choice:");
                                            Integer status = new Integer(sc.nextLine());
                                            if (status == 1) {
                                                currentUser.getTaskArray()[upt - 1].setStatus("To Do");
                                                System.out.println("Status Updated!");
                                                break;
                                            }
                                            else if (status == 2) {
                                                currentUser.getTaskArray()[upt - 1].setStatus("In Progress");
                                                System.out.println("Status Updated!");
                                                break;
                                            }
                                            else if (status == 3) {
                                                currentUser.getTaskArray()[upt - 1].setStatus("Progress Done");
                                                break;
                                            }
                                            else {
                                                System.out.println("Enter proper choice");
                                            }
                                        }
                                    }
                                    else if (cn == 3) {
                                        System.out.println("Enter your Task Description:");
                                        String des = sc.nextLine();
                                        currentUser.getTaskArray()[upt - 1].setDescription(des);
                                        System.out.println("Your Description Updated");
                                    }
                                    else {
                                        System.out.println("Enter proper choice");
                                    }
                                    try {
                                        while (!yes) {
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
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Your Exited!");
                                        break;
                                    }
                                }
                                else{
                                    throw new Exception();
                                }

                            }catch(Exception e){
                        System.out.println("Enter the proper value to update!");
                        continue;
                    }
                }}
                else if (choice == 4) {
                    try{
                        while(!yes){

                            Task[] arr = currentUser.getTaskArray();
                    boolean isTaskAvailable=false;
                    for(int i=0;i<currentUser.getTaskArray().length;i++){
                        if(arr[i]!=null){
                            Task Title=currentUser.getTaskArray()[i];
                            System.out.print(i+1+".");
                            System.out.println(Title.getTitle());
                            isTaskAvailable=true;}
                        else{
                            break;
                        }
                    }
                    if(!isTaskAvailable){
                        System.out.println("No task available in list");
                    }
                    System.out.println("Enter task number to delete:");
                    Integer delNum= Integer.valueOf(sc.nextLine());
                    int delNumber=delNum-1;
                    if (delNumber < currentUser.getTaskArray().length && currentUser.getTaskArray()[delNumber] != null){
                        currentUser.getTaskArray()[delNumber]=null;
                        System.out.println("Your Task Deleted!");
                    }
                    for(int i=0;i<currentUser.getTaskArray().length;i++){
                        if(currentUser.getTaskArray()[i]==null){
                            for(int j=i+1;j<currentUser.getTaskArray().length;j++){
                                if(currentUser.getTaskArray()[j]!=null){
                                    Task temp=currentUser.getTaskArray()[j];
                                    currentUser.getTaskArray()[j]=currentUser.getTaskArray()[i];
                                    currentUser.getTaskArray()[i]=temp;
                                }
                            }

                        }
                    }
                    try{
                        while (!yes) {
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
                        }
                    }catch(Exception e){
                        System.out.println("Your Exited!");
                        break;
                    }
                }
                    }catch(Exception e){
                        System.out.println("Enter the proper value to update!");
                        continue;
                    }
                }
                else if (choice == 5) {
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
