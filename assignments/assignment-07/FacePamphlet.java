/*
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public class FacePamphlet extends Program
					implements FacePamphletConstants {
	private FacePamphletDatabase database; private FacePamphletCanvas canvas; private JTextField nameField,statusField,imageField,friendField;

	/**
	 * This method has the responsibility for initializing the
	 * interactors in the application, and taking care of any other
	 * initialization that needs to be performed.
	 */
	public void init() {
		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT); database=new FacePamphletDatabase(); canvas=new FacePamphletCanvas(); add(canvas); nameField=new JTextField(TEXT_FIELD_SIZE);statusField=new JTextField(TEXT_FIELD_SIZE);imageField=new JTextField(TEXT_FIELD_SIZE);friendField=new JTextField(TEXT_FIELD_SIZE);
		add(new JLabel("Name"),WEST);add(nameField,WEST);add(new JButton("Add"),WEST);add(new JButton("Lookup"),WEST);add(new JButton("Delete"),WEST);add(new JLabel("Status"),WEST);add(statusField,WEST);add(new JButton("Change Status"),WEST);add(new JLabel("Image"),WEST);add(imageField,WEST);add(new JButton("Change Image"),WEST);add(new JLabel("Friend"),WEST);add(friendField,WEST);add(new JButton("Add Friend"),WEST);add(new JButton("Remove Friend"),WEST);addActionListeners();
    }


    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
	public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand(), name=nameField.getText(); FacePamphletProfile p=database.getProfile(name);
		if(cmd.equals("Add")){if(database.containsProfile(name))canvas.showMessage("A profile with that name already exists.");else{database.addProfile(new FacePamphletProfile(name));canvas.showMessage("Added profile for "+name);}}
		else if(cmd.equals("Lookup")){canvas.displayProfile(p);}
		else if(cmd.equals("Delete")){database.deleteProfile(name);canvas.showMessage("Deleted profile for "+name);}
		else if(p!=null&&cmd.equals("Change Status")){p.setStatus(statusField.getText());canvas.displayProfile(p);}
		else if(p!=null&&cmd.equals("Change Image")){p.setImage(new GImage(imageField.getText()));canvas.displayProfile(p);}
		else if(p!=null&&cmd.equals("Add Friend")){FacePamphletProfile f=database.getProfile(friendField.getText());if(f!=null){p.addFriend(f.getName());f.addFriend(p.getName());canvas.displayProfile(p);}}
		else if(p!=null&&cmd.equals("Remove Friend")){FacePamphletProfile f=database.getProfile(friendField.getText());if(f!=null){p.removeFriend(f.getName());f.removeFriend(p.getName());canvas.displayProfile(p);}}
	}

}
