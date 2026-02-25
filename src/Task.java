public class Task implements TaskInterface{
    private String title;
    private String Status;
    private String Description;


    public String getTitle() {
        return title;
    }
Task(String Title){
    this.title=Title;
}

Task(String title,String Status){
        this.title=title;
        this.Status=Status;
}

    public String getStatus() {
        return Status;
    }

    public String setStatus(String status) {
        Status = status;
        return status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
