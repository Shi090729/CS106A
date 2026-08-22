import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoxDiagram extends GraphicsProgram {

    private static final double BOX_WIDTH = 120;
    private static final double BOX_HEIGHT = 50;
    private static final int MAX_NAME = 12;

    private final Map<String, GCompound> boxes =
            new HashMap<String, GCompound>();

    private JTextField nameField;
    private JButton addButton;
    private JButton removeButton;
    private JButton clearButton;
    private GCompound draggedBox;
    private double dragOffsetX;
    private double dragOffsetY;

    public void init() {
        createControls();
        addActionListeners();
        addMouseListeners();
    }

    private void createControls() {
        nameField = new JTextField(MAX_NAME);
        nameField.addActionListener(this);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        clearButton = new JButton("Clear");

        add(new JLabel("Name"), SOUTH);
        add(nameField, SOUTH);
        add(addButton, SOUTH);
        add(removeButton, SOUTH);
        add(clearButton, SOUTH);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        String name = nameField.getText();

        if (source == nameField || source == addButton) {
            addBox(name);
        } else if (source == removeButton) {
            removeBox(name);
        } else if (source == clearButton) {
            clearBoxes();
        }
    }

    private void addBox(String name) {
        GCompound box = new GCompound();
        GRect outline = new GRect(BOX_WIDTH, BOX_HEIGHT);
        GLabel label = new GLabel(name);

        box.add(outline, -BOX_WIDTH / 2, -BOX_HEIGHT / 2);
        box.add(label, -label.getWidth() / 2, label.getAscent() / 2);
        add(box, getWidth() / 2.0, getHeight() / 2.0);
        boxes.put(name, box);
    }

    private void removeBox(String name) {
        GCompound box = boxes.remove(name);
        if (box != null) {
            remove(box);
        }
    }

    private void clearBoxes() {
        for (GCompound box : boxes.values()) {
            remove(box);
        }
        boxes.clear();
    }

    public void mousePressed(MouseEvent event) {
        GObject object = getElementAt(event.getX(), event.getY());
        if (object instanceof GCompound) {
            draggedBox = (GCompound) object;
            dragOffsetX = event.getX() - draggedBox.getX();
            dragOffsetY = event.getY() - draggedBox.getY();
        }
    }

    public void mouseDragged(MouseEvent event) {
        if (draggedBox != null) {
            draggedBox.setLocation(
                    event.getX() - dragOffsetX,
                    event.getY() - dragOffsetY);
        }
    }

    public void mouseReleased(MouseEvent event) {
        draggedBox = null;
    }
}
