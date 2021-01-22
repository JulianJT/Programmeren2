package Domain;

public class Certificate {
    private int review;
    private String nameWorker;
    private String nameStudent;
    private String registration;

    public Certificate(String nameWorker, String nameStudent, String registration, int review) {
        this.nameStudent = nameStudent;
        this.review = review;
        this.registration = registration;
        this.nameWorker = nameWorker;
    }

    public String toString(){
        return "Name: " + nameStudent + " | " + "E-mail: " + review + "\n";
    }
}
