import java.util.ArrayList;
import java.util.Scanner;

public class UserManager implements UserManagerInterface {
    Scanner sc=new Scanner(System.in);
    ArrayList<User> existingUser = new ArrayList<>();
    User currentUser;
    public User getCurrentUser() {
        return currentUser;
    }
    public void user() {
        System.out.println("Welcome");
        System.out.println("Enter your Username:");
        String username = sc.nextLine();

        System.out.println("Welcome " + username);
       boolean isUser=false;
        for (int i = 0; i < existingUser.size(); i++) {

                if (existingUser.get(i).getUsername().equals(username)) {
                    currentUser = existingUser.get(i);
                    System.out.println("Welcome back again!!");
                    isUser=true;
                    break;
                }

        }
         {
            if(!isUser){
            currentUser = new User(username);
            existingUser.add(currentUser);
            }

        }
    }
}
