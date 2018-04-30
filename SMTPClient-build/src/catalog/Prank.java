package catalog;

public class Prank {
    // Instance variables
    private String subject;
    private String body;
    private String id;

    // Constructor
    public Prank(String id, String subject, String body) {
        this.subject = subject;
        this.body = body;
        this.id = id;
    }

    // Methods
    public String getBody() {
        return this.body;
    }
    public String getSubject() {
        return this.subject;
    }
    public String getId() {
        return this.id;
    }
}
