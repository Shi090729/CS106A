# Lecture 22 - Containers, Resizing, and NameSurfer

## Course Content

### The NameSurfer division of labor

This lecture uses the NameSurfer project to show how a larger GUI can be divided into cooperating parts. A database class reads name-ranking records and returns `NameSurferEntry` objects. A graph class owns the canvas and knows how to draw axes, decade labels, and one or more name curves. The main program connects the database, graph, text field, and buttons. Each class has a clear responsibility instead of one event handler doing everything.

### Containers and resize events

The lecture also clarifies the relationship between components and containers. A program window is itself a component, but it can contain other components. Panels provide intermediate containers with their own layout managers. A canvas can listen for component-resize events, clear its old graphical objects, and redraw using its current width and height. This is why a graph should calculate x positions from the canvas dimensions instead of assuming the original window size.

### Drawing missing data and multiple curves

NameSurfer also illustrates how data and graphics interact. A rank of zero means that a name did not appear in a decade, so the graph needs a deliberate convention for displaying that missing point. Adding a second name should preserve the first curve, while Clear should remove curves but leave the coordinate grid available for another query.

### ComponentListener and the MusicShop example

A `ComponentListener` receives callbacks when a component is resized, moved, shown, or hidden. NameSurfer uses `componentResized` to rebuild the graph from its stored entries. The empty callbacks still satisfy the interface contract for events the graph does not need.

The MusicShop example separates a data model from a display component and uses listeners to keep them connected. It reinforces the same controller/model/view division as NameSurfer without tying the design to baby-name data.

## My Takeaways

The project made “separation of concerns” concrete. The database should not know how a line is drawn, and the canvas should not parse raw file lines. When a bug appears, this separation gives me a smaller place to look.

Resize handling is not an optional visual detail. It tests whether the program's geometry is expressed in terms of the current container rather than the accidental size used during development.
Before adding a method, I should ask which object owns the information needed to perform it. That question usually reveals whether the method belongs in the data model, the graph, or the controller.
