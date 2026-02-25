public class TaskUtilization{
    public static void taskComm(User currentUser,int i,int taskNum){
        Task Title = currentUser.getTaskArray()[i];
        System.out.print(taskNum+ ".");
        System.out.println(Title.getTitle());
        System.out.println("Description:"+Title.getDescription());
        System.out.print("Status:");

    }
}
