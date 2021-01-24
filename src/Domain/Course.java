package Domain;

public class Course {
    private String name;
    private String subject;
    private String text;

    public Course(String name, String subject, String text) {
        this.name=name;
        this.subject=subject;
        this.text=text;
    }

    public String getName() { return name; }

    public String getSubject() { return subject; }
    public String getText() { return text; }


    public String toString(){
        return name + ", " + subject + ", " + text ;
    }

}
