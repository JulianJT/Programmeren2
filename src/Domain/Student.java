package Domain;

// Student object class

public class Student {
    private final String name;
    private final String email;


    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "Name: " + name + " | " + "E-mail: " + email + "\n";
    }
}
