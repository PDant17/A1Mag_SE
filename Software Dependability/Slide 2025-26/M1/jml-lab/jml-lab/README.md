
# JML Lab

This repository contains hands-on materials for a two-hour lab on **JML (Java Modeling Language)** using **OpenJML**.

## Objective
- Declare **preconditions** (`requires`), **postconditions** (`ensures`), and **class invariants** (`invariant`).
- Run **static checks** (`-esc`) and **runtime assertion checks** (`-rac`) with OpenJML.
- Use **frame conditions** (`assignable`) and basic **loop invariants**.
- Get a glimpse of **ghost fields** for specification-only state.

## Structure
```
SETUP.md                  # Setup & typical commands
01-basics/                # Simple methods, contracts to fill
02-bankaccount/           # Core exercise: class invariants & method contracts
03-assignable-frames/     # Assignable clauses
04-loops/                 # Loop invariants: linear search
05-model-ghost/           # Ghost fields
06-challenges/            # Optional stretch: binary search contracts
scripts/                  # Helper scripts
solutions/     # Complete solutions (for instructors)
```

> Tip: Start with `01-basics`, then `02-bankaccount`, and use later folders as time permits.

## Quick start (command line)
Setup `openjml` using the instructions contained in the `SETUP.md` file.

Assuming you have `openjml` on your PATH and a Java JDK installed:

### Static checking (ESC)
```bash
openjml -esc 01-basics/*.java
openjml -esc 02-bankaccount/*.java
openjml -esc 03-assignable-frames/*.java
openjml -esc 04-loops/*.java
openjml -esc 05-model-ghost/*.java
```

### Runtime assertion checking (RAC)
Compile instrumented bytecode:
```bash
mkdir -p bin
openjml -rac -d bin 01-basics/*.java 02-bankaccount/*.java 03-assignable-frames/*.java 04-loops/*.java 05-model-ghost/*.java
```
Then run classes that contain `main` methods (if any) with
```bash
java -ea -cp bin Main
```

If you only want ESC, you can skip RAC.

## Notes
- Some exercises intentionally lack full specs; students should add them where marked `TODO`.
- The `solutions` folder contains filled-in versions.
- You can find many more examples at [https://www.openjml.org/tutorial/](https://www.openjml.org/tutorial/)

