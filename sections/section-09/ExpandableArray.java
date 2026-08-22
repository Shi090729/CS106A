public class ExpandableArray {

    private Object[] elements;

    public ExpandableArray() {
        elements = new Object[0];
    }

    public void set(int index, Object value) {
        if (index >= elements.length) {
            Object[] expandedElements = new Object[index + 1];
            for (int i = 0; i < elements.length; i++) {
                expandedElements[i] = elements[i];
            }
            elements = expandedElements;
        }

        elements[index] = value;
    }

    public Object get(int index) {
        if (index < 0 || index >= elements.length) {
            return null;
        }
        return elements[index];
    }
}
