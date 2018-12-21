package com.comaiu.daniyar.comalatoomobile.ui.ams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.data.manager.ResourceManager;
import com.comaiu.daniyar.comalatoomobile.ui.BaseActivity;
import com.comaiu.daniyar.comalatoomobile.ui.ams.ams_terms.AmsTermsActivity;

public class AmsActivity extends BaseActivity implements AmsContract.View, View.OnClickListener {

    private AmsPresenter mPresenter;
    private EditText mEditTextLogin, mEditTextPassword;
    private Button mButtonLogin;

    @Override
    protected int getViewLayout() {
        return R.layout.activity_ams;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayout());

        mPresenter = new AmsPresenter(new ResourceManager(this));
        mPresenter.bind(this);
        getToolbar("University Management System", true);
        initializeViews();
        mPresenter.getLoginPass();

    }

    private void initializeViews(){
        mEditTextLogin = findViewById(R.id.editTextLogin);
        mEditTextPassword = findViewById(R.id.editTextPass);
        mButtonLogin = findViewById(R.id.buttonLogin);
        mButtonLogin.setOnClickListener(this);
    }

    @Override
    public void fillTheFields(String email, String password) {
        mEditTextLogin.setText(email);
        mEditTextPassword.setText(password);
    }

    @Override
    public void toastError(String message, String where) {
        if(where.equals("both")){
            mEditTextLogin.setError(message);
            mEditTextPassword.setError(message);
            return;
        }
        if(where.equals("email")){
            mEditTextLogin.setError(message);
            return;
        }
        if(where.equals("password")){
            mEditTextPassword.setError(message);
        }
    }

    @Override
    public void toastText(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToMain() {
        startActivity(new Intent(this, AmsTermsActivity.class));
    }

    @Override
    public void onClick(View view) {
        mPresenter.loginTo(mEditTextLogin.getText().toString(), mEditTextPassword.getText().toString());
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
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        mPresenter.unbind();
    }
}
