package com.example.daniyar.comalatoomobile.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.daniyar.comalatoomobile.ComApplication;
import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.widget.BottomNavigationViewHelper;
import com.example.daniyar.comalatoomobile.ui.BaseActivity;
import com.example.daniyar.comalatoomobile.ui.exams.ExamsFragment;
import com.example.daniyar.comalatoomobile.ui.home.HomeFragment;
import com.example.daniyar.comalatoomobile.ui.news.NewsFragment;
import com.example.daniyar.comalatoomobile.ui.timetable.TimetableFragment;

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
                Toast.makeText(this, "AMS", Toast.LENGTH_SHORT).show();

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
