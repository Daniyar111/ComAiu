package com.example.daniyar.comalatoomobile.ui;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.daniyar.comalatoomobile.R;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;

public abstract class BaseActivity extends AppCompatActivity{

    protected abstract int getViewLayout();
    protected abstract int getToolbarId();

    private Toolbar mToolbar;
    private Drawer mDrawer;

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setContentView(getViewLayout());
    }

    protected void getToolbar(String title, boolean back){
        mToolbar = findViewById(getToolbarId());
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(back);
        }
    }

    protected void getDrawer(){

        ProfileDrawerItem profileDrawerItem = new ProfileDrawerItem()
                .withName(R.string.computer_science)
                .withEmail(R.string.aiu)
                .withIcon(R.drawable.cs_logo);
        
    }
}
