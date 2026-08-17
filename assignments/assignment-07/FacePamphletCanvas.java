/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas
					implements FacePamphletConstants {
	private GLabel message;

	/**
	 * Constructor
	 * This method takes care of any initialization needed for
	 * the display
	 */
	public FacePamphletCanvas() {
		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
	}


	/**
	 * This method displays a message string near the bottom of the
	 * canvas.  Every time this method is called, the previously
	 * displayed message (if any) is replaced by the new message text
	 * passed in.
	 */
	public void showMessage(String msg) {
		if(message!=null)remove(message); message=new GLabel(msg,LEFT_MARGIN,getHeight()-BOTTOM_MESSAGE_MARGIN); message.setFont(MESSAGE_FONT); add(message);
	}


	/**
	 * This method displays the given profile on the canvas.  The
	 * canvas is first cleared of all existing items (including
	 * messages displayed near the bottom of the screen) and then the
	 * given profile is displayed.  The profile display includes the
	 * name of the user from the profile, the corresponding image
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		removeAll(); message=null; if(profile==null)return;
		GLabel name=new GLabel(profile.getName(),LEFT_MARGIN,TOP_MARGIN+24);name.setFont(PROFILE_NAME_FONT);add(name);
		if(profile.getImage()!=null){GImage img=profile.getImage();img.setSize(IMAGE_WIDTH,IMAGE_HEIGHT);add(img,LEFT_MARGIN,name.getY()+IMAGE_MARGIN);}else{GLabel no=new GLabel("No Image",LEFT_MARGIN,name.getY()+IMAGE_MARGIN+PROFILE_IMAGE_FONT.length());no.setFont(PROFILE_IMAGE_FONT);add(no);}
		GLabel status=new GLabel(profile.getStatus(),LEFT_MARGIN+IMAGE_WIDTH+40,name.getY()+IMAGE_MARGIN+24);status.setFont(PROFILE_STATUS_FONT);add(status);
		GLabel fl=new GLabel("Friends:",LEFT_MARGIN+IMAGE_WIDTH+40,status.getY()+40);fl.setFont(PROFILE_FRIEND_LABEL_FONT);add(fl);int y=(int)fl.getY()+25;for(Iterator<String> it=profile.getFriends();it.hasNext();){GLabel f=new GLabel(it.next(),LEFT_MARGIN+IMAGE_WIDTH+40,y);f.setFont(PROFILE_FRIEND_FONT);add(f);y+=22;}
	}


}
