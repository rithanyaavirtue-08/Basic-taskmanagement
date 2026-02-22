public class User {
    private  String username;
    private String []taskArray=new String[10];
    User(String username){
        this.username=username;

    }

    public String getUsername() {
        return username;
    }


    public String[] getTaskArray() {
        return taskArray;
    }

    public void setTaskArray(String[] taskArray) {
        this.taskArray = taskArray;
    }
}
