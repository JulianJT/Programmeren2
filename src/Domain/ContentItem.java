package Domain;

public class ContentItem {
    private final int publicationDate;
    private final int id;
    private String status;

    public ContentItem(int publicationDate, int id) {
        this.publicationDate = publicationDate;
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "ContentItem{" +
                "publicationDate=" + publicationDate +
                ", id=" + id +
                '}';
    }
}
