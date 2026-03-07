import java.util.Scanner;

public class User implements UserInterface {
    private String username;
    private String password;
    private Task []TaskArray=new Task[10];



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Task[] getTaskArray() {
        return TaskArray;
    }


    public User(String username,String password){
        this.username=username;
        this.password=password;
    }





}

