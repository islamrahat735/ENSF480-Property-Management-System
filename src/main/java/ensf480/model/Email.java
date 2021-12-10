package ensf480.model;

//represents an Email notification in the system
public class Email {
    private String from; //name of who it is from
    private String title; //title of message
    private String message;

    //constructor
    public Email(String from, String title, String message) {
        this.from = from;
        this.title = title;
        this.message = message;
    }

    //getters and setters
    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
