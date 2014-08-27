package com.rhfung.minesweeper.model;

import java.util.Random;

/**
 * Created by richard on 8/27/14.
 */
public class GameModel {
    public static final int BOARD_WIDTH = 8;
    public static final int BOARD_HEIGHT = 8;
    public static final int NUMBER_OF_MINES = 10; // requirements state this number

    public static final int MINE = -1;

    private int gameGrid[][];

    public GameModel() {
        gameGrid = createGameBoard();
        addMinesToGameBoard(gameGrid);
    }

    /**
     * Creates a blank game board.
     */
    private int[][] createGameBoard() {
        int [][] gameboard = new int[BOARD_HEIGHT][];
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            gameboard[i] = new int[BOARD_WIDTH];
        }

        return gameboard;
    }

    /**
     * Game cells are represented by the number of nearby mines.
     * @return {@link #MINE} represents a mine,
     *         Positive value represents nearby mines,
     *         Zero means no nearby mines
     */
    public int getGameBoardAt(int row, int column) {
        return gameGrid[row][column];
    }

    /**
     * Adds several mines to the gameboard and updates the minefield count in the process.
     * @param gameboard
     */
    private void addMinesToGameBoard(int[][] gameboard) {
        Random random = new Random();
        for (int i = 0; i < NUMBER_OF_MINES; i++) {
            int mineRow = random.nextInt(BOARD_HEIGHT);
            int mineCol = random.nextInt(BOARD_WIDTH);

            if (gameboard[mineRow][mineCol] == MINE) {
                // don't count this placement and try again
                i--;
            } else {
                // place a new mine here
                addMineAt(mineRow, mineCol, gameboard);
            }
        }
    }

    /**
     * Adds a mine to a non-mine cell.
     * @param mineRow [0, BOARD_HEIGHT)
     * @param mineCol [0, BOARD_WIDTH)
     * @param gameboard
     */
    private void addMineAt(int mineRow, int mineCol, int[][] gameboard) {
        assert(gameboard[mineRow][mineCol] != MINE);

        // place the mine
        gameboard[mineRow][mineCol] = MINE;

        // now update adjacent cell counts to suggest nearby mines including diagonals
        for (int i = Math.max(0, mineRow - 1); i <= Math.min(mineRow + 1, BOARD_HEIGHT - 1); i++) {
            for (int j = Math.max(0, mineCol - 1); j <= Math.min(mineCol + 1, BOARD_WIDTH - 1); j++) {
                if (gameboard[i][j] != MINE) {
                    gameboard[i][j] += 1;
                }
            }
        }
    }
}
