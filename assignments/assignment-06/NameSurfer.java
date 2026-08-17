/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {
	private NameSurferDataBase database; private NameSurferGraph graph; private JTextField field;

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
		setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT); database=new NameSurferDataBase(NAMES_DATA_FILE); graph=new NameSurferGraph(); add(graph); field=new JTextField(15); add(new JLabel("Name:"),SOUTH); add(field,SOUTH); add(new JButton("Graph"),SOUTH); add(new JButton("Clear"),SOUTH); addActionListeners();
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Graph")){NameSurferEntry x=database.findEntry(field.getText().trim());if(x!=null){graph.addEntry(x);graph.update();}}else if(e.getActionCommand().equals("Clear")){graph.clear();graph.update();}
	}
}
