import java.util.Scanner;

public class TaskManager implements TaskManagerInterface{

    boolean yes=false;
    int taskCnt=0;
    User currentUser;

    Scanner sc=new Scanner(System.in);
    public void addTask(){
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
    public void Display(){
        {
            Task[] arr = currentUser.getTaskArray();
            boolean hasTask = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    hasTask = true;
                    break;
                }
            }

            if (!hasTask) {
                System.out.println("No task available in list");
                return;   
            }

            while (true)
            {
                System.out.println("What do you want to Display?");
                System.out.println("1.Display ToDo Task");
                System.out.println("2.Display In Progress Task");
                System.out.println("3.Display Progress Done Task");
                System.out.println("4.Display All");
                System.out.println("Enter Your Choice (or type 'exit' to exit):");

                String display = sc.nextLine();

                if (display.equals("exit")) {
                    System.out.println("Exited from display section.");
                    break;
                }

                boolean isTaskAvailable = false;
                int taskNum = 1;

                for (int i = 0; i < arr.length; i++)
                {
                    Task task = arr[i];

                    if (task == null)
                        continue;

                    String status = task.getStatus();

                    if (display.equals("1") && "To Do".equals(status)) {
                        TaskUtilization.taskComm(currentUser, i, taskNum++);
                        System.out.println(status);
                        isTaskAvailable = true;
                    }

                    else if (display.equals("2") && "In Progress".equals(status)) {
                        TaskUtilization.taskComm(currentUser, i, taskNum++);
                        System.out.println(status);
                        isTaskAvailable = true;
                    }

                    else if (display.equals("3") && "Progress Done".equals(status)) {
                        TaskUtilization.taskComm(currentUser, i, taskNum++);
                        System.out.println(status);
                        isTaskAvailable = true;
                    }

                    else if (display.equals("4")) {
                        TaskUtilization.taskComm(currentUser, i, taskNum++);
                        System.out.println(status);
                        isTaskAvailable = true;
                    }
                }

                if (!isTaskAvailable) {
                    System.out.println("No task available in selected category.");
                }

                System.out.println("Do you want to Continue? (yes/no)");
                String con = sc.nextLine();

                if (!con.equals("yes")) {
                    System.out.println("Exited from display section.");
                    break;
                }
            }
        }
    }
    public void update(){
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

                }
                if(!isTaskAvailable){
                    System.out.println("No task available in list");
                    break;
                }

                System.out.println("Enter your task number to update:");
                Integer upt = Integer.valueOf(sc.nextLine());
                if (upt < currentUser.getTaskArray().length && currentUser.getTaskArray()[upt - 1] != null)
                {
                    String Status=currentUser.getTaskArray()[upt-1].getStatus();
                    String description=currentUser.getTaskArray()[upt-1].getDescription();
                    System.out.println("Status:"+Status);
                    System.out.println("Description:"+description);
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
                                    yes=true;
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
                                System.out.println("Status Updated!");
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
        }
    }
    public  void delete(){
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

                }
                if(!isTaskAvailable){
                    System.out.println("No task available in list");
                    break;
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
            System.out.println("Enter the proper value to delete!");

        }
    }

    public TaskManager(User user) {
        this.currentUser = user;
    }
}
