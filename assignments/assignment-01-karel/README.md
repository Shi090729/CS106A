# Assignment 1 - Karel the Robot

This project is based on Stanford's official [`Assignment1` starter project](https://see.stanford.edu/materials/icspmcs106a/Assignment1.zip). It keeps the supplied Eclipse configuration and sample worlds, with my solutions added to the four Java files.

The four programs are:

- `CollectNewspaperKarel` collects a newspaper and returns home.
- `StoneMasonKarel` repairs missing stones in several columns.
- `CheckerboardKarel` fills an empty world with a checkerboard pattern.
- `MidpointFindingKarel` places one beeper at the midpoint of 1st Street.

## What I Learned

I practiced breaking a problem into small methods instead of writing one long sequence of commands. The checkerboard problem showed me why odd, even, one-row, and one-column worlds need careful handling. The midpoint problem was the most difficult because Karel cannot count directly, so I used beepers to mark and shrink the possible midpoint range.

## Running the Programs

Download the course `karel.jar` file and place it in this directory. Import the folder as an existing Eclipse project, then run a Java file with one of the matching worlds in `worlds/`.

## Testing

All four programs compile with the course library. I also tested different world sizes and edge cases, including single-row and single-column checkerboards and midpoint worlds with widths from 1 to 12.

## Attribution

The Eclipse project files, starter comments, and world files come from the official Stanford Engineering Everywhere CS106A Assignment 1 starter package. The completed Java implementations are my assignment work.
