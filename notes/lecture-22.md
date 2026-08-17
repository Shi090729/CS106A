# Lecture 22 - Containers, Resizing, and NameSurfer

## Course Content

### The NameSurfer division of labor

This lecture uses the NameSurfer project to show how a larger GUI can be divided into cooperating parts. A database class reads name-ranking records and returns `NameSurferEntry` objects. A graph class owns the canvas and knows how to draw axes, decade labels, and one or more name curves. The main program connects the database, graph, text field, and buttons. Each class has a clear responsibility instead of one event handler doing everything.

NameSurfer is used to show how a project grows beyond one class. The database parses lines and answers name queries, the entry object represents one name's ranks, the graph owns drawing, and the controller connects controls to those services. This division keeps file-format details out of the graphics code.

### Containers and resize events

The lecture also clarifies the relationship between components and containers. A program window is itself a component, but it can contain other components. Panels provide intermediate containers with their own layout managers. A canvas can listen for component-resize events, clear its old graphical objects, and redraw using its current width and height. This is why a graph should calculate x positions from the canvas dimensions instead of assuming the original window size.

A component may also be a container, which means it can hold child components and have its own layout manager. The graph listens for a resize event because the canvas dimensions are not fixed. Redrawing from the current width and height is therefore part of correctness, not merely an enhancement.

### Drawing missing data and multiple curves

NameSurfer also illustrates how data and graphics interact. A rank of zero means that a name did not appear in a decade, so the graph needs a deliberate convention for displaying that missing point. Adding a second name should preserve the first curve, while Clear should remove curves but leave the coordinate grid available for another query.

A rank of zero has a semantic meaning: the name was not listed for that decade. The graph must choose a consistent visual treatment rather than plotting zero as if it were a real rank. Adding another name should preserve existing curves, while Clear should remove only the curves and retain the axes.

## My Takeaways

The project made “separation of concerns” concrete. The database should not know how a line is drawn, and the canvas should not parse raw file lines. When a bug appears, this separation gives me a smaller place to look.

Resize handling is not an optional visual detail. It tests whether the program's geometry is expressed in terms of the current container rather than the accidental size used during development.


Before adding a method, I should ask which object owns the information needed to perform it. That question usually reveals whether the method belongs in the data model, the graph, or the controller.
