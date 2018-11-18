package com.comaiu.daniyar.comalatoomobile.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.data.entity.TabPagerItem;
import com.comaiu.daniyar.comalatoomobile.ui.academ_calendar.AcademicCalendarActivity;
import com.comaiu.daniyar.comalatoomobile.ui.bachelor.BachelorActivity;
import com.comaiu.daniyar.comalatoomobile.ui.bachelor.admission.BachelorAdmissionFragment;
import com.comaiu.daniyar.comalatoomobile.ui.bachelor.courses.BachelorCoursesFragment;
import com.comaiu.daniyar.comalatoomobile.ui.bachelor.exam_rules.BachelorExamRulesFragment;
import com.comaiu.daniyar.comalatoomobile.ui.master.MasterActivity;
import com.comaiu.daniyar.comalatoomobile.ui.master.admission.MasterAdmissionFragment;
import com.comaiu.daniyar.comalatoomobile.ui.master.courses.MasterCoursesFragment;
import com.comaiu.daniyar.comalatoomobile.ui.master.graduate_research.MasterGraduateFragment;
import com.comaiu.daniyar.comalatoomobile.ui.master.overview.MasterOverviewFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
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

        AccountHeader header = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header_logo)
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

        PrimaryDrawerItem academicCalendarDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.academic_calendar)
                .withIdentifier(3)
                .withIcon(R.drawable.ic_date_range_black_24dp);

        PrimaryDrawerItem stuffDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.stuff)
                .withIdentifier(4)
                .withIcon(R.drawable.ic_person_black_24dp);

        PrimaryDrawerItem labsDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.labs)
                .withIdentifier(5)
                .withIcon(R.drawable.ic_computer_black_24dp);

        PrimaryDrawerItem contactDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.contact_us)
                .withIdentifier(6)
                .withIcon(R.drawable.ic_perm_contact_calendar_black_24dp);

        PrimaryDrawerItem exitDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.exit)
                .withIdentifier(7)
                .withIcon(R.drawable.ic_exit_to_app_black_24dp);

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withOnDrawerItemClickListener(this)
                .withAccountHeader(header)
                .withSelectedItem(-1)
                .withToolbar(mToolbar)
                .addDrawerItems(bachelorDrawerItem,
                        masterDrawerItem,
                        academicCalendarDrawerItem,
                        stuffDrawerItem,
                        labsDrawerItem,
                        new DividerDrawerItem(),
                        contactDrawerItem,
                        exitDrawerItem)
                .build();
        Log.d("DAN", "getDrawer: ");
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

        switch ((int) drawerItem.getIdentifier()){
            case 1:
                startActivity(new Intent(this, BachelorActivity.class));
                mDrawer.setSelection(-1);
                break;
            case 2:
                startActivity(new Intent(this, MasterActivity.class));
                mDrawer.setSelection(-1);
                break;
            case 3:
                startActivity(new Intent(this, AcademicCalendarActivity.class));
                mDrawer.setSelection(-1);
                break;
            case 4:
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.this_function), Toast.LENGTH_LONG).show();
                mDrawer.setSelection(-1);
                break;
            case 5:
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.this_function), Toast.LENGTH_LONG).show();
                mDrawer.setSelection(-1);
                break;
            case 6:
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.this_function), Toast.LENGTH_LONG).show();
                mDrawer.setSelection(-1);
                break;
            case 7:
                finish();
                break;
        }
        return false;
    }

    protected void getTabLayout(String type){
        ArrayList<TabPagerItem> tabPagerItems = new ArrayList<>();
        if(type.equals("bachelor")){
            tabPagerItems.add(new TabPagerItem(new BachelorCoursesFragment(), getResources().getString(R.string.courses)));
            tabPagerItems.add(new TabPagerItem(new BachelorExamRulesFragment(), getResources().getString(R.string.exam_rules)));
            tabPagerItems.add(new TabPagerItem(new BachelorAdmissionFragment(), getResources().getString(R.string.admission)));
        }
        else if(type.equals("master")){
            tabPagerItems.add(new TabPagerItem(new MasterOverviewFragment(), getResources().getString(R.string.overview)));
            tabPagerItems.add(new TabPagerItem(new MasterCoursesFragment(), getResources().getString(R.string.course)));
            tabPagerItems.add(new TabPagerItem(new MasterGraduateFragment(), getResources().getString(R.string.graduate_research)));
            tabPagerItems.add(new TabPagerItem(new MasterAdmissionFragment(), getResources().getString(R.string.admission)));
        }

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager(), tabPagerItems);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    protected void switchFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
