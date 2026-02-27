public class Task implements TaskInterface {
    private String title;
    private String Status;
    private String Description;
    private String StartDateTime;
    private String EndDateTime;



    public String getTitle() {
        return title;
    }

    Task(String Title) {
        this.title = Title;
    }

    Task(String title, String Status) {
        this.title = title;
        this.Status = Status;
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

    public String getStartDateTime() {
        return StartDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        StartDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return EndDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        EndDateTime = endDateTime;
    }
}
