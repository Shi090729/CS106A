# Assignment 1 - Karel the Robot

This assignment contains four Karel programs:

- `CollectNewspaperKarel` collects a newspaper and returns home.
- `StoneMasonKarel` repairs missing stones in several columns.
- `CheckerboardKarel` fills an empty world with a checkerboard pattern.
- `MidpointFindingKarel` places one beeper at the midpoint of 1st Street.

## What I Learned

I practiced breaking a problem into small methods instead of writing one long sequence of commands. The checkerboard problem showed me why odd, even, one-row, and one-column worlds need careful handling. The midpoint problem was the most difficult because Karel cannot count directly, so I used beepers to mark and shrink the possible midpoint range.

## Running the Programs

Add the course `karel.jar` file to the Java project, compile the `.java` files, and run the required class with a matching Karel world.

## Testing

All four programs compile with the course library. I also tested different world sizes and edge cases, including single-row and single-column checkerboards and midpoint worlds with widths from 1 to 12.
