# Lecture 20 - Interactors and Event-Driven Programs

## Course Content

### Controls and layout regions

The course moves from graphics that run in a fixed sequence to programs that wait for a user's actions. Swing interactors—buttons, labels, text fields, check boxes, and combo boxes—are components that appear in the program window. A program adds them to a region such as `NORTH`, `SOUTH`, or `EAST`, and the layout manager determines how they share the available space.

The interactor library is introduced as a set of components with different roles: buttons initiate commands, labels display information, text fields accept input, and check boxes or combo boxes represent choices. Layout regions and panels determine how those components occupy the window without requiring every coordinate to be calculated by hand.

### The event-handling cycle

An event-driven program has an initialization phase and a response phase. `init` creates the components, chooses their starting values, and registers listeners. When a user clicks a button, the program receives an action event and dispatches it to `actionPerformed`. The handler can inspect the event source or its action command, change the model, and then update the visible components.

The program has a setup phase and an event phase. During initialization it creates controls, chooses defaults, and registers listeners; later the framework calls `actionPerformed` with an event describing what happened. The handler should identify the command, update the state, and refresh any display that depends on that state.

### Keeping model and view in sync

This structure is different from a console loop. The program does not repeatedly ask for input in one method; instead, the framework calls the handler whenever an event occurs. Components that will be needed later must be stored in instance variables. Keeping the model state separate from the widgets makes it possible to update the display consistently after every action.

Controls are not the whole program. Values such as a score, selected option, or list of objects belong to the model, while labels and fields are views of that state. Keeping the model in instance variables prevents a handler from losing information when the next event arrives.

### Build behavior before decoration

A small application should be developed incrementally. The first version should establish reliable interactions and state transitions; visual polish can come afterward. This order makes it easier to tell whether a problem is in the event model or merely in the presentation.

## My Takeaways

The important shift is mental: the user is now driving the control flow. I should not write a giant loop that tries to predict the next click. I should set up the interface, wait for events, and make each handler responsible for one small transition.

I also want to name components according to their roles. A field such as `nameField` or `rollButton` communicates more than a generic variable like `x`, especially when several controls share one handler.


After every event, I should be able to answer two questions: what changed in the program's state, and which component now needs to reflect that change?
