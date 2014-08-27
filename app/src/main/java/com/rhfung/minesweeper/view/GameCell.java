package com.rhfung.minesweeper.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Button;

import com.rhfung.minesweeper.R;
import com.rhfung.minesweeper.model.GameModel;

/**
 * Created by richard on 8/27/14.
 */
public class GameCell extends Button {

    public static final int STATE_HIDDEN = 0;
    public static final int STATE_REVEALED = 1;

    public GameCell(Context context) {
        super(context);
        setBackgroundResource(R.drawable.cell_background);
    }

    public void setPositionAndValue(int row, int column, int mineValue) {
        setTag(R.id.game_row, row);
        setTag(R.id.game_col, column);
        setTag(R.id.game_value, mineValue);
    }

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

    public boolean isRevealed() {
        Boolean revealed = (Boolean) getTag(R.id.game_state);
        return revealed != null ? revealed : false;
    }

    public int getRow() {
        return (Integer) getTag(R.id.game_row);
    }

    public int getColumn() {
        return (Integer) getTag(R.id.game_col);
    }

}
