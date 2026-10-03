# Chess

Two-player simplified chess. Moves are typed in the terminal, and the board is shown in a Swing window.

This is BIL 211 Homework 2, completed on 18 January 2019. The assignment handout is `bil211spring2018hw2.pdf`.

En passant and castling are not part of this game. A player wins by capturing the other king.

## Requirements

Java 8 or newer, and a graphical desktop.

## Run

Piece images are loaded from an `images` folder in the working directory, so start the game from `src`:

```bash
cd src
javac *.java
java Chess
```

White moves first. Enter a move as the piece's square, a space, and the destination square:

```text
e2 e4
```

To promote a pawn, add a space and one of `at`, `kale`, `fil`, or `vezir`:

```text
e7 e8 vezir
```

The prompts are in Turkish.
