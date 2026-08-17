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

## My Takeaways

- A compound object is a useful way to hide the details of a complex picture.
- Composition and inheritance make graphics components easy to reuse in existing code.
- Registering listeners is essential; callbacks will not run without them.
- Event callbacks should use the information carried by the event object.
- Instance variables connect state that must be shared across separate callback calls.
