package Domain;

// Registration object class

public class Registration {
    private final String name;
    private final String course;

    public Registration(String name, String course) {
        this.name = name;
        this.course = course;
    }

    //This method retrieves the student name.
    public String getName() {
        return name;
    }

    //This method retrieves the course name.
    public String getCourse() {
        return course;
    }

    //This method converts the objects in registration into a string.
    public String toString() {
        return name + ", " + course;
    }

}
