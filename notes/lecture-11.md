# Lecture 11 - Compound Graphics and Events

## Course Content

### Images, Polygons, and Compounds

`GImage` displays an image loaded from a file. Its size can be inspected or scaled after loading.

A `GPolygon` begins as an empty shape. Vertices can be added relative to the polygon's reference point with `addVertex(x, y)`, or an edge can be described relative to the previous vertex with `addEdge(dx, dy)`. The final vertex is automatically connected to the first. When the polygon is placed on the canvas, its location refers to the polygon's reference point.

A `GCompound` groups several graphics objects so they can be moved, scaled, and used as one object. Each component is positioned relative to the compound. The `GFace` example extends `GCompound` and combines a head, eyes, nose, and mouth. Because the result is still a `GObject`, it can replace the oval in the bouncing-ball program with very few changes. However, a compound does not automatically implement every interface that one of its parts supports.

### Event-Driven Programs

Event-driven programs respond when the user clicks, moves the mouse, or presses a key. They are asynchronous because the program does not know when an event will occur. A graphics program first registers interest with `addMouseListeners()` or `addKeyListeners()`. The ACM library then calls specially named callback methods.

Mouse callbacks include `mouseClicked`, `mousePressed`, `mouseReleased`, `mouseMoved`, and `mouseDragged`. Each receives a `MouseEvent`, whose `getX()` and `getY()` methods report the event position. `ClickForFace` uses `init()` to install listeners and adds a face inside `mouseClicked`. `MouseTracker` keeps a label as an instance variable so `mouseMoved` can update it across method calls.

Keyboard callbacks include `keyPressed`, `keyReleased`, and `keyTyped`. A `KeyEvent` can provide either the typed character or a key code for special keys such as the arrows.

The UFO example brings these ideas together: a compound graphical object responds to keyboard or mouse input while an animation loop changes its position. Instance variables hold the state that must be shared by setup, event callbacks, and animation updates.

## My Takeaways

`GCompound` is the idea I expect to reuse most. If a face, game piece, or labeled box is represented as one compound, the rest of the program can move and store it without knowing every line and oval inside it. That is composition serving the same abstraction goal as helper methods.

Events introduce a different control flow: the framework calls my methods when something happens. Registering the listener is therefore part of the program's setup, not optional boilerplate. Information that connects `mousePressed`, `mouseDragged`, and `mouseReleased` belongs in instance variables because those callbacks occur as separate method calls.
