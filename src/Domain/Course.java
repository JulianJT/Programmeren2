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

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }


    public String toString() {
        return name + ", " + subject + ", " + text;
    }

}
