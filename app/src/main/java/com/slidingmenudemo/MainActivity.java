package com.slidingmenudemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

public class MainActivity extends SlidingActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.menu_frame);

        DrawerMenuFragment drawerMenuFragment = new DrawerMenuFragment();
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.menu_frame, drawerMenuFragment);
        t.commit();

        SlidingMenu sm = getSlidingMenu();
        sm.setOnClosedListener(new SlidingMenu.OnClosedListener() {

            @Override
            public void onClosed() {

            }
        });
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setFadeDegree(0.35f);
        sm.setMode(SlidingMenu.RIGHT);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        sm.setShadowDrawable(R.drawable.shadow);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.drawer_menu) {
            toggle();
        }
        return super.onOptionsItemSelected(item);
    }
}
