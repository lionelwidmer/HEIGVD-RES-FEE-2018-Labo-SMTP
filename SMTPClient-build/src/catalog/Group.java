package catalog;

import java.util.ArrayList;
import java.util.List;

public class Group {
    // Instance variables
    private List<Person> people;
    private String name;

    // Constructor
    public Group(String name) {
        this.name = name;
        this.people = new ArrayList<>();
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
    public List<Person> members() {
        return people;
    }
}
