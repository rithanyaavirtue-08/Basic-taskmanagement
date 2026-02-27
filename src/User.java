import java.util.ArrayList;

public class User implements UserInterface {
    private  String username;
    private ArrayList<Task> taskArray=new ArrayList<>();
    User(String username){
        this.username=username;

    }

    public String getUsername() {
        return username;
    }


    public ArrayList<Task> getTaskArray() {
        return taskArray;
    }



}
