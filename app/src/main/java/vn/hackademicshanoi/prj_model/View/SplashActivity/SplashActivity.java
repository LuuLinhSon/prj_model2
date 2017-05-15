package vn.hackademicshanoi.prj_model.View.SplashActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.BeforeLogin.BeforeLoginActivity;
import vn.hackademicshanoi.prj_model.View.MainActivity.MainActivity;

/**
 * Created by Admin on 5/10/2017.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_splash);

        setContentView(R.layout.fragment_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,BeforeLoginActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);
    }
}
