package catalog;

public class Prank {
    // Instance variables
    private String subject;
    private String body;

    // Constructor
    public Prank (String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    // Methods
    public String getBody() {
        return this.body;
    }
    public String getSubject() {
        return this.subject;
    }
}
