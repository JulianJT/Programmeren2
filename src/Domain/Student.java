package Domain;

public class Student {
    private String name;
    private String address;
    private String email;


    public Student(String name, String address) {
        this.name=name;
        this.address=address;
        this.email=email;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
