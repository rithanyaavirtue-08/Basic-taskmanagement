public class User{
    private String username;
    private String password;
    private String []TaskArray=new String[10];

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getTaskArray() {
        return TaskArray;
    }

    public void setTaskArray(String[] taskArray) {
        TaskArray = taskArray;
    }
}

