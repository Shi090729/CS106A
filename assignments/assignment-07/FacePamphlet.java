/*
 * File: FacePamphlet.java
 * -----------------------
 * Provides the user interface for a small social network.
 */

import acm.graphics.GImage;
import acm.program.Program;
import acm.util.ErrorException;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FacePamphlet extends Program implements FacePamphletConstants {

    private FacePamphletDatabase database;
    private FacePamphletCanvas canvas;
    private FacePamphletProfile currentProfile;

    private JTextField nameField;
    private JTextField statusField;
    private JTextField pictureField;
    private JTextField friendField;

    public void init() {
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

        database = new FacePamphletDatabase();
        canvas = new FacePamphletCanvas();
        add(canvas);

        addNorthInteractors();
        addWestInteractors();
        addActionListeners();
    }

    private void addNorthInteractors() {
        nameField = new JTextField(TEXT_FIELD_SIZE);

        add(new JLabel("Name"), NORTH);
        add(nameField, NORTH);
        add(new JButton("Add"), NORTH);
        add(new JButton("Delete"), NORTH);
        add(new JButton("Lookup"), NORTH);
    }

    private void addWestInteractors() {
        statusField = createActionField("Change Status");
        add(statusField, WEST);
        add(new JButton("Change Status"), WEST);
        addSpacer();

        pictureField = createActionField("Change Picture");
        add(pictureField, WEST);
        add(new JButton("Change Picture"), WEST);
        addSpacer();

        friendField = createActionField("Add Friend");
        add(friendField, WEST);
        add(new JButton("Add Friend"), WEST);
    }

    private JTextField createActionField(String command) {
        JTextField field = new JTextField(TEXT_FIELD_SIZE);
        field.setActionCommand(command);
        field.addActionListener(this);
        return field;
    }

    private void addSpacer() {
        add(new JLabel(EMPTY_LABEL_TEXT), WEST);
        add(new JLabel(EMPTY_LABEL_TEXT), WEST);
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("Add")) {
            addProfile();
        } else if (command.equals("Delete")) {
            deleteProfile();
        } else if (command.equals("Lookup")) {
            lookupProfile();
        } else if (command.equals("Change Status")) {
            changeStatus();
        } else if (command.equals("Change Picture")) {
            changePicture();
        } else if (command.equals("Add Friend")) {
            addFriend();
        }
    }

    private void addProfile() {
        String name = nameField.getText();
        if (name.isEmpty()) {
            return;
        }

        if (database.containsProfile(name)) {
            currentProfile = database.getProfile(name);
            canvas.displayProfile(currentProfile);
            canvas.showMessage("A profile with the name " + name
                    + " already exists");
        } else {
            currentProfile = new FacePamphletProfile(name);
            database.addProfile(currentProfile);
            canvas.displayProfile(currentProfile);
            canvas.showMessage("New profile created");
        }
    }

    private void deleteProfile() {
        String name = nameField.getText();
        if (name.isEmpty()) {
            return;
        }

        boolean profileExists = database.containsProfile(name);
        database.deleteProfile(name);
        currentProfile = null;
        canvas.displayProfile(null);

        if (profileExists) {
            canvas.showMessage("Profile of " + name + " deleted");
        } else {
            showMissingProfileMessage(name);
        }
    }

    private void lookupProfile() {
        String name = nameField.getText();
        if (name.isEmpty()) {
            return;
        }

        currentProfile = database.getProfile(name);
        canvas.displayProfile(currentProfile);

        if (currentProfile == null) {
            showMissingProfileMessage(name);
        } else {
            canvas.showMessage("Displaying " + name);
        }
    }

    private void changeStatus() {
        String status = statusField.getText();
        if (status.isEmpty()) {
            return;
        }

        if (currentProfile == null) {
            canvas.showMessage("Please select a profile to change status");
            return;
        }

        currentProfile.setStatus(status);
        canvas.displayProfile(currentProfile);
        canvas.showMessage("Status updated to " + status);
    }

    private void changePicture() {
        String filename = pictureField.getText();
        if (filename.isEmpty()) {
            return;
        }

        if (currentProfile == null) {
            canvas.showMessage("Please select a profile to change picture");
            return;
        }

        try {
            GImage image = new GImage(filename);
            currentProfile.setImage(image);
            canvas.displayProfile(currentProfile);
            canvas.showMessage("Picture updated");
        } catch (ErrorException exception) {
            canvas.showMessage("Unable to open image file: " + filename);
        }
    }

    private void addFriend() {
        String friendName = friendField.getText();
        if (friendName.isEmpty()) {
            return;
        }

        if (currentProfile == null) {
            canvas.showMessage("Please select a profile to add friend");
            return;
        }

        FacePamphletProfile friendProfile = database.getProfile(friendName);
        if (friendProfile == null) {
            canvas.showMessage(friendName + " does not exist.");
        } else if (currentProfile.addFriend(friendName)) {
            friendProfile.addFriend(currentProfile.getName());
            canvas.displayProfile(currentProfile);
            canvas.showMessage(friendName + " added as a friend");
        } else {
            canvas.showMessage(currentProfile.getName() + " already has "
                    + friendName + " as a friend.");
        }
    }

    private void showMissingProfileMessage(String name) {
        canvas.showMessage("A profile with the name " + name
                + " does not exist");
    }
}
