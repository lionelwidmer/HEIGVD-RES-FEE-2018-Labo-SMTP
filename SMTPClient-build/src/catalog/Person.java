package catalog;

public class Person {
    // Instance variables
    private String email;

    // Constructors
    public Person (String email) {
        this.email = email;
    }
    public Person() {}

    // Methods
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
