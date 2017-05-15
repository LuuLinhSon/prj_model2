package vn.hackademicshanoi.prj_model.View.BeforeLogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.ManagerLogin.ManagerLogin;
import vn.hackademicshanoi.prj_model.View.Profile.FragmentProfileOne;

/**
 * Created by Admin on 5/10/2017.
 */

public class BeforeLoginActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnAbout,btnManagerLogin,btnInstagramLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_login);

        btnAbout = (ImageButton) findViewById(R.id.before_login_bt_about);
        btnManagerLogin = (ImageButton) findViewById(R.id.before_login_bt_manage_login);
        btnInstagramLogin = (ImageButton) findViewById(R.id.before_login_bt_instagram_login);

        btnAbout.setOnClickListener(this);
        btnManagerLogin.setOnClickListener(this);
        btnInstagramLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.before_login_bt_about:
                break;

            case R.id.before_login_bt_manage_login:
                Intent iManagerLogin = new Intent(this, ManagerLogin.class);
                startActivity(iManagerLogin);
                finish();
                break;

            case R.id.before_login_bt_instagram_login:
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentProfileOne fragmentProfileOne = new FragmentProfileOne();
                fragmentTransaction.addToBackStack("BeforeLoginActivity");
                fragmentTransaction.add(R.id.content,fragmentProfileOne);
                fragmentTransaction.commit();
                break;
        }
    }
}
