package Data.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Entry {

    private int id;
    private String ownerName;
    private String title;
    private String body;
    private final LocalDateTime currentDateTime = LocalDateTime.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", currentDateTime=" + currentDateTime +
                '}';
    }
}
