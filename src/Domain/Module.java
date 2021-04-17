package Domain;

public class Module extends ContentItem {
    private final String title;
    private final String versionDescription;
    private final String contactName;
    private final String email;
    private final int serialNumber;

    public Module(int publicationDate, int id, String title, String versionDesc, String contact, String email, int serialNr) {
        super(publicationDate, id);
        this.title = title;
        this.versionDescription = versionDesc;
        this.contactName = contact;
        this.email = email;
        this.serialNumber = serialNr;
    }

    @Override
    public String toString() {
        return "Module{" +
                "title='" + title + '\'' +
                ", versionDescription='" + versionDescription + '\'' +
                ", contactName='" + contactName + '\'' +
                ", email='" + email + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }
}
