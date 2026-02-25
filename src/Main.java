import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();

        while (true) {
            userManager.user();
            TaskManager taskmanager = new TaskManager(userManager.getCurrentUser());
            Integer choice = 0;
            while (choice != 5) {
                try {

                    System.out.println("What you need?");
                    System.out.println("1.Add task");
                    System.out.println("2.List Task");
                    System.out.println("3.Update");
                    System.out.println("4.Delete");
                    System.out.println("5.Exit");
                    System.out.println("Enter your choice:");
                    choice = Integer.valueOf(sc.nextLine());
                    if (choice < 1 || choice > 5) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Enter proper value");
                    continue;
                }
                if (choice == 1) {
                    taskmanager.addTask();
                }
                else if (choice == 2) {
                    taskmanager.Display();
                }
                else if (choice == 3) {
                    taskmanager.update();
                }
                else if (choice == 4) {
                    taskmanager.delete();
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