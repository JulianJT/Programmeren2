package Domain;

// Student object class

public class Student {
    private final String name;
    private final String email;


    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //This method retrieves the student name.
    public String getName() {
        return name;
    }

    //This method converts the objects in student into a string.
    public String toString() {
        return "Name: " + name + " | " + "E-mail: " + email + "\n";
    }
}
