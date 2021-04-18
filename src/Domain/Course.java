package Domain;

// Course object class

public class Course {
    private final String name;
    private final String subject;
    private final String text;

    public Course(String name, String subject, String text) {
        this.name = name;
        this.subject = subject;
        this.text = text;
    }

    //This method retrieves the course name.
    public String getName() {
        return name;
    }

    //This method retrieves the description of the course.
    public String getText() {
        return text;
    }

    //This method converts the objects in course into a string.
    public String toString() {
        return name + ", " + subject + ", " + text;
    }

}
