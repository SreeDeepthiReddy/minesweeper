minesweeper
===========

Minesweeper is an Android app written for a code challenge.

Rules of Minesweeper
---------------------

Minesweeper is a grid of tiles, each of which may or may not cover hidden mines.
The goal is to click on every tile except those that have mines. When a user clicks
a tile, one of two things happens. If the tile was covering a mine, the mine is
revealed and the game ends in failure. If the tile was not covering a mine, it
instead reveals the number of adjacent (including diagonals) tiles that are
covering mines – and, if that number was 0, behaves as if the user has clicked
on every cell around it. When the user is confident that all tiles not containing
mines have been clicked, the user presses a Validate button (often portrayed as
a smiley-face icon) that checks the clicked tiles: if the user is correct, the game
ends in victory, if not, the game ends in failure.


Features implemented
--------------------

* The board is an 8x8 grid and 10 hidden mines are randomly placed on the board.
* New Game: start a new, randomly generated game.
* Validate: check that a user has correctly marked all the tiles and end the game in either victory or failure
* Cheat: press the app icon to reveal mines on the board

Features not implemented
------------------------

* Tells you how many mines haven't been found
* Visual branding
* Handle fragment lifecycle restarts (game board isn't persisted)
