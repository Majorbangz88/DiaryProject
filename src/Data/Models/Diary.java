package Data.Models;

import java.util.ArrayList;
import java.util.List;

public class Diary {

    private String username;
    private String password;
    private boolean isLocked;
    private final List<Entry> entry = new ArrayList<>();
    private int id;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isLocked=" + isLocked +
                ", entry=" + entry +
                ", id=" + id +
                '}';
    }
}
