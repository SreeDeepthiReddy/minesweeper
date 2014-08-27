package com.rhfung.minesweeper.view;

import android.content.Context;
import android.widget.Button;

import com.rhfung.minesweeper.R;
import com.rhfung.minesweeper.model.GameModel;

/**
 * Defines the user's current state of the game.
 */
public class GameCell extends Button {

    public static final int STATE_HIDDEN = 0;
    public static final int STATE_REVEALED = 1;

    public GameCell(Context context) {
        super(context);
        setBackgroundResource(R.drawable.cell_background);
    }

    /**
     * Assigns the cell's attributes.
     * @param row
     * @param column
     * @param mineValue {@link com.rhfung.minesweeper.model.GameModel#MINE} for a mine,
     *                  0 for nothing nearby,
     *                  and a positive value for count of nearby mines
     */
    public void setPositionAndValue(int row, int column, int mineValue) {
        setTag(R.id.game_row, row);
        setTag(R.id.game_col, column);
        setTag(R.id.game_value, mineValue);
    }

    /**
     * Sets whether a user pressed on a cell.
     * @param isRevealed
     */
    public void setRevealed(boolean isRevealed) {
        setTag(R.id.game_state, isRevealed);
        if (isRevealed) {
            int mineValue = (Integer) getTag(R.id.game_value);
            if (mineValue == 0){
                setText("");
                setBackgroundResource(R.drawable.cell_grid_revealed);
            } else if (mineValue == GameModel.MINE) {
                setText("M");
                setBackgroundResource(R.drawable.cell_grid_mine);
            } else {
                setText(Integer.toString(mineValue));
                setBackgroundResource(R.drawable.cell_grid_revealed);
            }
        } else {
            setBackgroundResource(R.drawable.cell_grid_hidden);
            setText("");
        }
    }

    /**
     * Cheat and reveal the mine without "revealing" it to the game state.
     */
    public void cheatAndRevealMine() {
        int mineValue = (Integer) getTag(R.id.game_value);
        if (mineValue == GameModel.MINE) {
            setText("M");
        }
    }

    /**
     * @return true if the user tapped the cell
     */
    public boolean isRevealed() {
        Boolean revealed = (Boolean) getTag(R.id.game_state);
        return revealed != null ? revealed : false;
    }

    /**
     * @return row of the game cell
     */
    public int getRow() {
        return (Integer) getTag(R.id.game_row);
    }

    /**
     * @return column of the game cell
     */
    public int getColumn() {
        return (Integer) getTag(R.id.game_col);
    }

}
