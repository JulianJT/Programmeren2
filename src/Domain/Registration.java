package Domain;

public class Registration {
    private String name;
    private String course;

    public Registration(String name, String course){
        this.name = name;
        this.course = course;
    }

    public String getRegistration() { return name; }

}
