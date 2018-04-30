package catalog;

import java.util.ArrayList;
import java.util.List;

public class Group {
    // Instance variables
    private List<Person> people;
    private String name;
    private String id;

    // Constructor
    public Group(String id, String name) {
        this.name = name;
        this.people = new ArrayList<>();
        this.id = id;
    }

    // Methods
    public boolean addPerson(Person p) {
        if (!people.contains(p)) {
            people.add(p);
            return true;
        } else {
            return false;
        }
    }
    public int numberOfMembers() {
        return this.people.size();
    }
    public String getName() {
        return this.name;
    }
    public String getId() {
        return this.id;
    }
    public List<Person> members() {
        return people;
    }
}
