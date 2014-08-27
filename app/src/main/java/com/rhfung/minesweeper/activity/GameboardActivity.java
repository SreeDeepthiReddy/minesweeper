package com.rhfung.minesweeper.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.rhfung.minesweeper.R;
import com.rhfung.minesweeper.fragment.GameboardFragment;


public class GameboardActivity extends Activity {

    private static final String GAMEBOARD = "com.rhfung.minesweeper.GameboardFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameboard);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new GameboardFragment(), GAMEBOARD)
                    .commit();
        }
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case android.R.id.home:
                //User clicked home, do whatever you want
                GameboardFragment fragment = (GameboardFragment) getFragmentManager().findFragmentByTag(GAMEBOARD);
                if (fragment != null) {
                    fragment.cheatAndRevealMines();
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
