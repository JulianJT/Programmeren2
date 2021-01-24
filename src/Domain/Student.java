package Domain;

public class Student {
    private final String name;
    private final String address;
    private String email;


    public Student(String name, String address) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String toString() {

        return "Name: " + name + " | " + "E-mail: " + address + "\n";
    }
}
