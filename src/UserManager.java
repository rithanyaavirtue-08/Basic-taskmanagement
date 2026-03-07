import java.util.Scanner;

public class UserManager implements UserManagerInterface{
    boolean yes = false;
    Scanner sc = new Scanner(System.in);
    public void Create(User currentUser) {
        TaskInterface[] tasks = currentUser.getTaskArray();
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
            System.out.println("There is no previous Task");
        }
        for (int i = 0; i < tasks.length; i++) {
            {
                if (tasks[i] == null) {
                    System.out.println("Enter your task title:");
                    String title = sc.nextLine();
                    TaskInterface task = new Task(title, "To Do");
                    tasks[i] = task;
                    while (!yes) {
                        System.out.println("Do you want to add Description? (yes/no)");
                        String ans = sc.nextLine();
                        if (ans.equals("yes")) {
                            System.out.println("Enter Description:");
                            String desc = sc.nextLine();
                            task.setDescription(desc);
                            break;

                        }
                        else if (ans.equals("no") || (ans.equals("exit"))) {
                            break;
                        }
                        else {
                            System.out.println("Enter valid input");
                        }
                    }
                    System.out.println("Task Created!");
                    try {
                        CommonMethods.continueCheck(sc, false);

                    } catch (Exception e) {
                        System.out.println("Your created task Exited");
                        break;
                    }
                }
            }
        }
    }

    public void Read(User currentUser) {
        TaskInterface[] tasks = currentUser.getTaskArray();
        if (tasks[0] != null) {
            while (!yes) {
                System.out.println("1.Display only Task in 'ToDo'");
                System.out.println("2.Display Tasks in 'In Progress'");
                System.out.println("3.Display Tasks in 'Progress Done'");
                System.out.println("4.Display All tasks");
                System.out.println("Enter your choice:");
                Integer Display = new Integer(sc.nextLine());
                boolean isTask = false;
                if (Display == 1) {
                    int tasknum = 0;
                    for (int i = 0; i < tasks.length; i++) {
                        if (tasks[i] != null && tasks[i].getStatus().equals("To Do")) {
                            CommonMethods.tasksDis(tasknum, tasks, i);//static method,no need obj
                            tasknum++;
                            isTask = true;
                        }

                    }
                    if (!isTask) {
                        System.out.println("There is no Task in To Do");
                    }
                }
                else if (Display == 2) {
                    int tasknum = 0;
                    for (int i = 0; i < tasks.length; i++) {
                        if ((tasks[i] != null) && tasks[i].getStatus().equals("In Progress")) {
                            CommonMethods.tasksDis(tasknum, tasks, i);//static method,no need obj
                            tasknum++;
                            isTask = true;
                        }

                    }
                    if (!isTask) {
                        System.out.println("There is no Task in In Progress");
                    }
                }
                else if (Display == 3) {
                    int tasknum = 0;
                    for (int i = 0; i < tasks.length; i++) {
                        if ((tasks[i] != null) && tasks[i].getStatus().equals("Progress Done")) {
                            CommonMethods.tasksDis(tasknum, tasks, i);//static method,no need obj
                            tasknum++;
                            isTask = true;
                        }
                    }
                    if (!isTask) {
                        System.out.println("There is no Task in Progress Done");
                    }
                }
                else if (Display == 4) {
                    int tasknum = 0;
                    for (int i = 0; i < tasks.length; i++) {
                        if ((tasks[i] != null)) {
                            CommonMethods.tasksDis(tasknum, tasks, i);//static method,no need obj
                            tasknum++;
                        }
                    }
                }
                else {
                    System.out.println("Enter the Valid Task choice!");
                    continue;
                }
                try {
                    CommonMethods.continueCheck(sc, false);
                } catch (Exception e) {
                    System.out.println("Read task exited");
                    break;
                }

            }
        }
        else {
            System.out.println("There is no Task Available");
        }
    }

    public void Update(User currentUser) {
        while (!yes) {
            try {
                TaskInterface[] tasks = currentUser.getTaskArray();
                if (tasks[0] != null) {
                    for (int i = 0; i < tasks.length; i++) {
                        if (tasks[i] != null) {
                            System.out.println((i + 1) + ". " + tasks[i].getTitle());
                        }
                        else {
                            break;
                        }
                    }
                }
                else {
                    System.out.println("There is No task!");
                    break;
                }
                System.out.println("Enter your Task number to Update:");
                Integer UpNum = new Integer(sc.nextLine());
                if (UpNum - 1 >= tasks.length || tasks[UpNum - 1] == null) {
                    System.out.println("Invalid Task Number");
                    continue;
                }
                String status = tasks[UpNum - 1].getStatus();
                String description = tasks[UpNum - 1].getDescription();
                System.out.println("Status:" + status);
                System.out.println("Description:" + description + "\n");

                System.out.println("1.Title");
                System.out.println("2.Status");
                System.out.println("3.Description");
                System.out.println("Which you want to Update?");
                int UpdateChoice = new Integer(sc.nextLine());
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
                try {
                    CommonMethods.continueCheck(sc, false);
                } catch (Exception e) {
                    System.out.println("Your Update task Exited");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Enter valid numbers only");
            }
        }

    }

    public void Delete(User currentUser) {
        while (!yes) {
            try {

                TaskInterface[] tasks = currentUser.getTaskArray();
                if (tasks[0] != null) {
                    for (int i = 0; i < tasks.length; i++) {
                        if (tasks[i] != null) {
                            System.out.println((i + 1) + ". " + tasks[i].getTitle());
                        }
                    }
                }
                else {
                    System.out.println("There is No task!");
                    break;
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
                try {
                    CommonMethods.continueCheck(sc, false);
                } catch (Exception e) {
                    System.out.println("Your Delete task Exited");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Enter only valid number!");
            }

        }
    }
}
