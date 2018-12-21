package com.comaiu.daniyar.comalatoomobile.ui.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.comaiu.daniyar.comalatoomobile.ComApplication;
import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.data.widget.BottomNavigationViewHelper;
import com.comaiu.daniyar.comalatoomobile.ui.BaseActivity;
import com.comaiu.daniyar.comalatoomobile.ui.ams.AmsActivity;
import com.comaiu.daniyar.comalatoomobile.ui.exams.ExamsFragment;
import com.comaiu.daniyar.comalatoomobile.ui.home.HomeFragment;
import com.comaiu.daniyar.comalatoomobile.ui.news.NewsFragment;
import com.comaiu.daniyar.comalatoomobile.ui.timetable.TimetableFragment;

public class MainActivity extends BaseActivity implements MainContract.View{

    private MainPresenter mPresenter;
    @Override
    protected int getViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayout());

        mPresenter = new MainPresenter();
        mPresenter.bind(this);

        getToolbar("", false);
        getDrawer();
        switchFragment(new HomeFragment());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.removeShiftMode(navigation);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    switchFragment(new HomeFragment());
                    return true;
                case R.id.navigation_news:
                    switchFragment(new NewsFragment());
                    return true;
                case R.id.navigation_timetable:
                    switchFragment(new TimetableFragment());
                    return true;
                case R.id.navigation_exam:
                    switchFragment(new ExamsFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_item_ams:
                startActivity(new Intent(this, AmsActivity.class));

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }

}
