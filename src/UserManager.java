import java.util.Scanner;

public class UserManager {
    Scanner sc=new Scanner(System.in);
    User[] existingUser = new User[5];
    User currentUser = null;
    public User getCurrentUser() {
        return currentUser;
    }
    public void user() {
        System.out.println("Welcome");
        System.out.println("Enter your Username:");
        String username = sc.nextLine();

        System.out.println("Welcome " + username);

        for (int i = 0; i < existingUser.length; i++) {
            if (existingUser[i] == null) {
                currentUser = new User(username);
                existingUser[i] = currentUser;
                break;
            }
            else if (existingUser[i] != null) {
                if (existingUser[i].getUsername().equals(username)) {
                    currentUser = existingUser[i];
                    System.out.println("Welcome back " + username);
                    break;
                }
            }
        }
    }
}
