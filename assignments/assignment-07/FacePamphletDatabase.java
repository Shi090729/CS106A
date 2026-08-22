/*
 * File: FacePamphletDatabase.java
 * -------------------------------
 * Stores every profile in the social network.
 */

import java.util.HashMap;
import java.util.Map;

public class FacePamphletDatabase {

    private final Map<String, FacePamphletProfile> profiles;

    public FacePamphletDatabase() {
        profiles = new HashMap<String, FacePamphletProfile>();
    }

    public void addProfile(FacePamphletProfile profile) {
        profiles.put(profile.getName(), profile);
    }

    public FacePamphletProfile getProfile(String name) {
        return profiles.get(name);
    }

    public void deleteProfile(String name) {
        if (profiles.remove(name) != null) {
            for (FacePamphletProfile profile : profiles.values()) {
                profile.removeFriend(name);
            }
        }
    }

    public boolean containsProfile(String name) {
        return profiles.containsKey(name);
    }
}
