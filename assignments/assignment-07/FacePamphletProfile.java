/*
 * File: FacePamphletProfile.java
 * ------------------------------
 * Stores the information associated with one profile.
 */

import acm.graphics.GImage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FacePamphletProfile {

    private final String name;
    private GImage image;
    private String status;
    private final List<String> friends;

    public FacePamphletProfile(String name) {
        this.name = name;
        image = null;
        status = "";
        friends = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public GImage getImage() {
        return image;
    }

    public void setImage(GImage image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean addFriend(String friend) {
        if (friends.contains(friend)) {
            return false;
        }

        friends.add(friend);
        return true;
    }

    public boolean removeFriend(String friend) {
        return friends.remove(friend);
    }

    public Iterator<String> getFriends() {
        return friends.iterator();
    }

    public String toString() {
        String result = name + " (" + status + "): ";
        for (int index = 0; index < friends.size(); index++) {
            if (index > 0) {
                result += ", ";
            }
            result += friends.get(index);
        }
        return result;
    }
}
