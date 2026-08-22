/*
 * File: NameSurfer.java
 * ---------------------
 * Displays the popularity of names across the decades in the data set.
 */

import acm.program.Program;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NameSurfer extends Program implements NameSurferConstants {

    private NameSurferDataBase database;
    private NameSurferGraph graph;
    private JTextField nameField;

    public void init() {
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

        database = new NameSurferDataBase(NAMES_DATA_FILE);
        graph = new NameSurferGraph();
        add(graph);

        nameField = new JTextField(15);
        nameField.addActionListener(this);

        add(new JLabel("Name:"), SOUTH);
        add(nameField, SOUTH);
        add(new JButton("Graph"), SOUTH);
        add(new JButton("Clear"), SOUTH);
        addActionListeners();
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (event.getSource() == nameField || command.equals("Graph")) {
            graphName();
        } else if (command.equals("Clear")) {
            graph.clear();
            graph.update();
        }
    }

    private void graphName() {
        String name = nameField.getText().trim();
        NameSurferEntry entry = database.findEntry(name);

        if (entry != null) {
            graph.addEntry(entry);
            graph.update();
        }
    }
}
