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
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
    public static int UserCheck(User[] existingUser, String userName, String password) {
        if (existingUser[0] != null) {
            for (int i = 0; i < existingUser.length; i++) {
                if (existingUser[i] != null ){
                    if(existingUser[i].getUsername().equals(userName)){
                        if(existingUser[i].getPassword().equals(password)) {
                           return 1;
                       }
                        else {
                            return 0;
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
}

