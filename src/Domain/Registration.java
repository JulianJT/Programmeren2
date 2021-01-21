package Domain;

public class Registration {
    private String name;
    private String course;

    public Registration(String name, String course){
        this.name = name;
        this.course = course;
    }

    public String getName() { return name; }

    public String getCourse() { return course; }

    public String toString(){
        return name + ", " + course ;
    }

}
