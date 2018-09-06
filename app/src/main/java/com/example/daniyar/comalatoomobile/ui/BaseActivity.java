package com.example.daniyar.comalatoomobile.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.ViewPagerItem;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

public abstract class BaseActivity extends AppCompatActivity implements Drawer.OnDrawerItemClickListener {

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

        AccountHeader header = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.primary)
                .addProfiles(profileDrawerItem)
                .withSelectionListEnabledForSingleProfile(false)
                .build();

        PrimaryDrawerItem bachelorDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.bachelor)
                .withIdentifier(1)
                .withIcon(R.drawable.ic_format_bold_black_24dp);

        PrimaryDrawerItem masterDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.master_degree)
                .withIdentifier(2)
                .withIcon(R.drawable.ic_account_balance_black_24dp);

        PrimaryDrawerItem stuffDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.stuff)
                .withIdentifier(3)
                .withIcon(R.drawable.ic_person_black_24dp);

        PrimaryDrawerItem labsDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.labs)
                .withIdentifier(4)
                .withIcon(R.drawable.ic_computer_black_24dp);

        PrimaryDrawerItem contactDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.contact_us)
                .withIdentifier(5)
                .withIcon(R.drawable.ic_perm_contact_calendar_black_24dp);

        PrimaryDrawerItem exitDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.exit)
                .withIdentifier(6)
                .withIcon(R.drawable.ic_exit_to_app_black_24dp);

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withOnDrawerItemClickListener(this)
                .withAccountHeader(header)
                .withSelectedItem(-1)
                .withToolbar(mToolbar)
                .addDrawerItems(bachelorDrawerItem,
                        masterDrawerItem,
                        stuffDrawerItem,
                        labsDrawerItem,
                        new DividerDrawerItem(),
                        contactDrawerItem,
                        exitDrawerItem)
                .build();
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

        switch ((int) drawerItem.getIdentifier()){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
        }
        return false;
    }

    protected void getTabLayout(){
        ArrayList<ViewPagerItem> viewPagerItems = new ArrayList<>();

    }

    protected void switchFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
