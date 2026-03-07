import java.util.Scanner;

public class CommonMethods {
    public static void tasksDis(int tasknum,TaskInterface tasks[],int i){
        System.out.println((tasknum + 1) + "." + tasks[i].getTitle());
        System.out.println("Description:" + tasks[i].getDescription());
        System.out.println("Status:" + tasks[i].getStatus());

    }
    public static void continueCheck(Scanner sc,boolean yes)
        throws Exception
    {
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
    public static int UserCheck(UserInterface[] existingUser, String userName, String password) {
        if (existingUser[0] != null) {
            for (int i = 0; i < existingUser.length; i++) {
                if (existingUser[i] != null ){
                    if(existingUser[i].getUsername().equals(userName)){
                        if(existingUser[i].getPassword().equals(password)) {
                            return i;
                        }
                        else {
                            return -2;
                        }

                    }
                }
                else{
                    return -1;
                }
            }
        }
        return -1;
    }
//public static void login(int AppChoice,Scanner sc){
//    try
//    {  System.out.println("1.Start");
//        System.out.println("2.Close");
//        System.out.println("Enter you Application Choice:");
//        AppChoice = new Integer(sc.nextLine());
//
//        if (AppChoice != 1 && AppChoice != 2) {
//            System.out.println("Enter the proper Value");
//            continue;
//        }
//
//        else if(AppChoice == 2) {
//            break;
//        }
//    } catch (Exception e) {
//        System.out.println("Enter only valid numbers");
//        continue;
//    }
//}
}
