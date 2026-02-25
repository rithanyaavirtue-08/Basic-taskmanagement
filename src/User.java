public class User {
    private  String username;
    private Task []taskArray=new Task[10];
    User(String username){
        this.username=username;

    }

    public String getUsername() {
        return username;
    }


    public Task[] getTaskArray() {
        return taskArray;
    }



}
