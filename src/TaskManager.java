import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.logging.Level.parse;

public class TaskManager implements TaskManagerInterface{

    boolean yes=false;
    int taskCnt=0;
    User currentUser;

    Scanner sc=new Scanner(System.in);
    public void addTask(){
        try
        {while(!yes)
        {

            ArrayList<Task> arr = currentUser.getTaskArray();
            boolean isTaskAvailable=false;

            for(int i=0;i<currentUser.getTaskArray().size();i++)
            {
                if(arr.get(i)!=null){
                    Task Title=currentUser.getTaskArray().get(i);

                    System.out.print(i+1+".");
                    System.out.println(Title.getTitle());
                    if(Title.getStatus()==null){
                        System.out.println("Status:To Do");
                    }
                    else{
                        System.out.println("Status:"+Title.getStatus());}

                    System.out.println("Description:"+Title.getDescription());
                    System.out.println("Start Date&Time:"+Title.getStartDateTime());
                    System.out.println("End Date&Time:"+Title.getEndDateTime());
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
            currentUser.getTaskArray().add(taskCnt, taskTitle);
            while(!yes) {
                System.out.println("Do you what to add Description?(yes/no)");
                String con = sc.nextLine();
                if (con.equals("yes")) {
                    System.out.println("Enter your Description");
                    String des=sc.nextLine();
                    currentUser.getTaskArray().get(taskCnt).setDescription(des);
                    break;
                }
                else if (con.equals("no"))   {
                    break;
                }
                else {
                    System.out.println("Enter proper value of string");
                }
            }

//            LocalDate date=LocalDate.now();
//            LocalTime time=LocalTime.now();
//            LocalDateTime dt=LocalDateTime.of(date,time);
//            System.out.println(dt);
//            DateTimeFormatter formate=DateTimeFormatter.ofPattern("dd-MM-yyyy,HH-mm-ss");
//            System.out.println(dt.(formate));
            while(!yes) {
                System.out.println("Do you want to add Start and End Date&Time?(yes/no)");
                String clan = sc.nextLine();
                if (clan.equals("yes")) {
                    System.out.println("Enter your Start date& time:(dd-MM-yyyy HH:mm)");
                    String dateTime = sc.nextLine();
                    DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    LocalDateTime datetime = LocalDateTime.parse(dateTime, formate);
                    //  LocalDate date=LocalDate.parse(dates);
                    System.out.println(datetime);
                    currentUser.getTaskArray().get(taskCnt).setStartDateTime(String.valueOf(datetime));
                    System.out.println("Enter your End date& time:(dd-MM-yyyy HH:mm)");
                    String endDateTime = sc.nextLine();
                    DateTimeFormatter endFormate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    LocalDateTime endDT = LocalDateTime.parse(endDateTime, endFormate);
                    currentUser.getTaskArray().get(taskCnt).setEndDateTime(String.valueOf(endDT));

                    break;

                }
                else if (clan.equals("no")) {
                    break;
                }
                else{
                    System.out.println("Enter the proper value!");
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
            ArrayList<Task> arr  = currentUser.getTaskArray();
            boolean hasTask = false;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) != null) {
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
                for (int i = 0; i < arr.size(); i++)
                {Task task = arr.get(i);
                    if (task == null)
                        continue;
                    String status = task.getStatus();
                    String  StartDateTime=task.getStartDateTime();
                    String EndDateTime=task.getEndDateTime();
                    if (display.equals("1") && "To Do".equals(status)) {
                        TaskUtilization.taskComm(currentUser, i, taskNum++);
                        System.out.println(status);
                        System.out.println("Start Date&Time:"+StartDateTime);
                        System.out.println("End Date&Time:"+EndDateTime);
                        isTaskAvailable = true;
                    }

                    else if (display.equals("2") && "In Progress".equals(status)) {
                        TaskUtilization.taskComm(currentUser, i, taskNum++);
                        System.out.println(status);
                        System.out.println("Start Date&Time:"+StartDateTime);
                        System.out.println("End Date&Time:"+EndDateTime);
                        isTaskAvailable = true;
                    }

                    else if (display.equals("3") && "Progress Done".equals(status)) {
                        TaskUtilization.taskComm(currentUser, i, taskNum++);
                        System.out.println(status);
                        System.out.println("Start Date&Time:"+StartDateTime);
                        System.out.println("End Date&Time:"+EndDateTime);
                        isTaskAvailable = true;
                    }
                    else if (display.equals("4")) {
                        TaskUtilization.taskComm(currentUser, i, taskNum++);
                        System.out.println("Start Date&Time:"+StartDateTime);
                        System.out.println("End Date&Time:"+EndDateTime);
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
    public void update() {
        while (!yes) {
            try {
                ArrayList<Task> arr = currentUser.getTaskArray();
                boolean isTaskAvailable = false;
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) != null) {
                        System.out.println((i + 1) + ". " + arr.get(i).getTitle());
                        isTaskAvailable = true;
                    }
                }
                if (!isTaskAvailable) {
                    System.out.println("No task available in list");
                    break;
                }
                System.out.println("Enter your task number to update:");
                int upt = Integer.parseInt(sc.nextLine());
                if (upt >= 1 && upt <= arr.size()) {
                    Task task = arr.get(upt - 1);
                    System.out.println("Status: " + task.getStatus());
                    System.out.println("Description: " + task.getDescription());
                    System.out.println("Which you want to Update");
                    System.out.println("1.Title");
                    System.out.println("2.Status");
                    System.out.println("3.Description");
                    System.out.println("Enter your choice:");

                    int cn = Integer.parseInt(sc.nextLine());
                    if (cn == 1) {
                        System.out.println("Enter new title:");
                        String newTitle = sc.nextLine();
                        task.setTitle(newTitle);
                        System.out.println("Task Title Updated!");
                    }
                    else if (cn == 2) {
                        while (true) {
                            System.out.println("What Status are you now?");
                            System.out.println("1.To Do");
                            System.out.println("2.In Progress");
                            System.out.println("3.Progress Done");
                            System.out.println("Enter your choice:");
                            int status = Integer.parseInt(sc.nextLine());
                            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                            if (status == 1) {
                                task.setStatus("To Do");
                                System.out.println("Status Updated!");
                                break;
                            }
                            else if (status == 2) {
                                task.setStatus("In Progress");
                                String startTime = LocalDateTime.now().format(formatter);
                                task.setStartDateTime(startTime);
                                System.out.println("Status Updated!");
                                break;
                            }
                            else if (status == 3) {
                                task.setStatus("Progress Done");
                                String endTime =LocalDateTime.now().format(formatter);
                                task.setEndDateTime(endTime);
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
                        task.setDescription(des);
                        System.out.println("Description Updated!");
                    }
                    else {
                        System.out.println("Enter proper choice");
                        continue;
                    }
                    System.out.println("Do you want to Continue?(yes/no or exit)");
                    String con = sc.nextLine();
                    if (con.equals("no")  || con.equals("exit")){
                        System.out.println("Your Exited!");
                        break;
                    }
                } else {
                    System.out.println("Invalid task number!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter numbers only!");
            }
            catch (Exception e) {
                System.out.println("Enter the proper value to update!");
            }
        }
    }
    public  void delete(){
        try{
            while(!yes){
                ArrayList<Task> arr = currentUser.getTaskArray();
                boolean isTaskAvailable=false;
                for(int i=0;i<currentUser.getTaskArray().size();i++){
                    if(arr.get(i)!=null){
                        Task Title=currentUser.getTaskArray().get(i);
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
                if (delNumber < currentUser.getTaskArray().size()&& currentUser.getTaskArray().get(delNumber) != null){
                    currentUser.getTaskArray().set(delNumber,null);
                    System.out.println("Your Task Deleted!");
                }
//                for(int i=0;i<currentUser.getTaskArray().length;i++){
//                    if(currentUser.getTaskArray()[i]==null){
//                        for(int j=i+1;j<currentUser.getTaskArray().length;j++){
//                            if(currentUser.getTaskArray()[j]!=null){
//                                Task temp=currentUser.getTaskArray()[j];
//                                currentUser.getTaskArray()[j]=currentUser.getTaskArray()[i];
//                                currentUser.getTaskArray()[i]=temp;
//                            }
//                        }
//
//                    }
//                }
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
