package com.comaiu.daniyar.comalatoomobile.ui.bachelor;

import android.os.Bundle;
import android.view.MenuItem;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.config.AppConstants;
import com.comaiu.daniyar.comalatoomobile.ui.BaseActivity;

public class BachelorActivity extends BaseActivity implements BachelorContract.View{

    private BachelorPresenter mPresenter;

    @Override
    protected int getViewLayout() {
        return R.layout.activity_bachelor;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayout());

        mPresenter = new BachelorPresenter();
        mPresenter.bind(this);

        getToolbar(getResources().getString(R.string.bachelor), true);
        getTabLayout(AppConstants.BACHELOR);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }
}
