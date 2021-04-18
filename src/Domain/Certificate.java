package Domain;

// Certificate object class

public class Certificate {
    private final int review;
    private final int certificateId;
    private final String nameWorker;

    public Certificate(int certificateId, int review, String nameWorker) {
        this.review = review;
        this.nameWorker = nameWorker;
        this.certificateId = certificateId;
    }

    //This method converts the objects in certificate into a string.
    public String toString() {
        return "ID: " + certificateId + " | " + "Review: " + review + " | " + "Worker Name: " + nameWorker + "\n";
    }
}
