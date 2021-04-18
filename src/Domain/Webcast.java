package Domain;

// Student object class

public class Webcast extends ContentItem {
    private final String title;
    private final String description;
    private final String nameSpeaker;
    private final String nameOrganisation;
    private final String url;

    public Webcast(int publicationDate, int id, String title, String desc, String speaker, String organisation, String url) {
        super(publicationDate, id);
        this.title = title;
        this.description = desc;
        this.nameSpeaker = speaker;
        this.nameOrganisation = organisation;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Webcast{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", nameSpeaker='" + nameSpeaker + '\'' +
                ", nameOrganisation='" + nameOrganisation + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
