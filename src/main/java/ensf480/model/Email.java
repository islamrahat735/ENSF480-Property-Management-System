package ensf480.model;

public class Email {
    private String from;
    private String title;
    private String message;

    public Email(String from, String title, String message) {
        this.from = from;
        this.title = title;
        this.message = message;
    }

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
