import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserInterface[] existingUser = new User[5];
        int AppChoice = 1;

        while (AppChoice != 2) {
            User currentUser = null;
            try
            {  System.out.println("1.Start");
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
                int returnNum = 0;
                while (returnNum != -1) {

                    System.out.println("Enter your Username:");
                    String userName = sc.nextLine();
                    System.out.println("Enter your Password:");
                    String password = sc.nextLine();
                    returnNum = CommonMethods.UserCheck(existingUser, userName, password);
                    if (returnNum ==-2) {
                        System.out.println("Invalid password");
                    }
                    else if (returnNum == -1) {

                        for (int i = 0; i < existingUser.length; i++) {
                            if (existingUser[i] == null) {
                                currentUser = new User(userName, password);
                                existingUser[i] = currentUser;
                                System.out.println("New User created");
                                break;
                            }
                        }
                    }

                    else{

                        {{System.out.println("Welcome Back!");
                                currentUser = (User)existingUser[returnNum];
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
                    choice = new Integer(sc.nextLine());
                    UserManager userManager=new UserManager();
                    if (choice > 5 || choice < 1) {
                        System.out.println("Enter the valid choice!");
                        continue;
                    }
                    if (choice == 1) {


                               userManager.Create(currentUser);


                    }
                    else if (choice == 2) {

                            userManager.Read(currentUser);

                    }
                    else if (choice == 3) {
                       {
                           userManager.Update(currentUser);
                        }


                    }
                    else if (choice == 4) {
                         {
                             userManager.Delete(currentUser);
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

    }
}