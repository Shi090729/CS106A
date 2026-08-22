/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * Displays profiles and application messages.
 */

import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;

import java.awt.Color;
import java.util.Iterator;

public class FacePamphletCanvas extends GCanvas
        implements FacePamphletConstants {

    private GLabel message;

    public void showMessage(String text) {
        if (message != null) {
            remove(message);
        }

        message = new GLabel(text);
        message.setFont(MESSAGE_FONT);
        double x = (getWidth() - message.getWidth()) / 2.0;
        double y = getHeight() - BOTTOM_MESSAGE_MARGIN;
        add(message, x, y);
    }

    public void displayProfile(FacePamphletProfile profile) {
        removeAll();
        message = null;

        if (profile == null) {
            return;
        }

        GLabel nameLabel = drawName(profile.getName());
        double imageTop = nameLabel.getY() + IMAGE_MARGIN;

        drawImage(profile.getImage(), imageTop);
        drawStatus(profile, imageTop);
        drawFriends(profile, imageTop);
    }

    private GLabel drawName(String name) {
        GLabel label = new GLabel(name);
        label.setFont(PROFILE_NAME_FONT);
        label.setColor(Color.BLUE);
        add(label, LEFT_MARGIN, TOP_MARGIN + label.getAscent());
        return label;
    }

    private void drawImage(GImage image, double imageTop) {
        if (image == null) {
            drawEmptyImage(imageTop);
        } else {
            image.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
            add(image, LEFT_MARGIN, imageTop);
        }
    }

    private void drawEmptyImage(double imageTop) {
        GRect border = new GRect(IMAGE_WIDTH, IMAGE_HEIGHT);
        add(border, LEFT_MARGIN, imageTop);

        GLabel noImage = new GLabel("No Image");
        noImage.setFont(PROFILE_IMAGE_FONT);
        double x = LEFT_MARGIN + (IMAGE_WIDTH - noImage.getWidth()) / 2.0;
        double y = imageTop + (IMAGE_HEIGHT + noImage.getAscent()
                - noImage.getDescent()) / 2.0;
        add(noImage, x, y);
    }

    private void drawStatus(FacePamphletProfile profile, double imageTop) {
        String text;
        if (profile.getStatus().isEmpty()) {
            text = "No current status";
        } else {
            text = profile.getName() + " is " + profile.getStatus();
        }

        GLabel status = new GLabel(text);
        status.setFont(PROFILE_STATUS_FONT);
        double statusTop = imageTop + IMAGE_HEIGHT + STATUS_MARGIN;
        add(status, LEFT_MARGIN, statusTop + status.getAscent());
    }

    private void drawFriends(FacePamphletProfile profile, double imageTop) {
        double x = getWidth() / 2.0;
        GLabel heading = new GLabel("Friends:");
        heading.setFont(PROFILE_FRIEND_LABEL_FONT);
        add(heading, x, imageTop);

        double y = imageTop + heading.getHeight();
        Iterator<String> friends = profile.getFriends();
        while (friends.hasNext()) {
            GLabel friend = new GLabel(friends.next());
            friend.setFont(PROFILE_FRIEND_FONT);
            add(friend, x, y);
            y += friend.getHeight();
        }
    }
}
