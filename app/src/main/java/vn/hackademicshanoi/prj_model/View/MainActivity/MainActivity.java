package vn.hackademicshanoi.prj_model.View.MainActivity;

import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.MainActivity.Fragment.FragmentHome;
import vn.hackademicshanoi.prj_model.View.MainActivity.Fragment.FragmentSetting;
import vn.hackademicshanoi.prj_model.View.MainActivity.Fragment.FragmentTalk;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imTabHome,imTabTalk,imTabSetting;
    TextView tvHome,tvTalk,tvSetting;
    RelativeLayout rlHome,rlTalk,rlSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imTabHome = (ImageView) findViewById(R.id.activity_main_bt_tab_home);
        imTabTalk = (ImageView) findViewById(R.id.activity_main_bt_tab_talk);
        imTabSetting = (ImageView) findViewById(R.id.activity_main_bt_tab_setting);
        tvHome = (TextView) findViewById(R.id.activity_main_txt_home);
        tvTalk = (TextView) findViewById(R.id.activity_main_txt_talk);
        tvSetting = (TextView) findViewById(R.id.activity_main_txt_setting);
        rlHome = (RelativeLayout) findViewById(R.id.activity_main_tab_home);
        rlTalk = (RelativeLayout) findViewById(R.id.activity_main_tab_talk);
        rlSetting = (RelativeLayout) findViewById(R.id.activity_main_tab_setting);

        FragmentManager fragmentManager2 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
        FragmentHome fragmentHome = new FragmentHome();
        fragmentTransaction2.add(R.id.activity_content,fragmentHome);
        fragmentTransaction2.commit();

        tvHome.setTextColor(getIdColor(R.color.colorRed));
        imTabHome.setColorFilter(getIdColor(R.color.colorRed));

        rlHome.setOnClickListener(this);
        rlTalk.setOnClickListener(this);
        rlSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.activity_main_tab_home:
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                FragmentHome fragmentHome = new FragmentHome();
                fragmentTransaction2.add(R.id.activity_content,fragmentHome);
                fragmentTransaction2.commit();
                tvHome.setTextColor(getIdColor(R.color.colorRed));
                tvTalk.setTextColor(getIdColor(R.color.colorWhile));
                tvSetting.setTextColor(getIdColor(R.color.colorWhile));
                imTabHome.setColorFilter(getIdColor(R.color.colorRed));
                imTabTalk.setColorFilter(getIdColor(R.color.colorWhile));
                imTabSetting.setColorFilter(getIdColor(R.color.colorWhile));


                break;
            case R.id.activity_main_tab_talk:
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                FragmentTalk fragmentTalk = new FragmentTalk();
                fragmentTransaction1.add(R.id.activity_content,fragmentTalk);
                fragmentTransaction1.commit();
                tvTalk.setTextColor(getIdColor(R.color.colorRed));
                tvHome.setTextColor(getIdColor(R.color.colorWhile));
                tvSetting.setTextColor(getIdColor(R.color.colorWhile));
                imTabHome.setColorFilter(getIdColor(R.color.colorWhile));
                imTabTalk.setColorFilter(getIdColor(R.color.colorRed));
                imTabSetting.setColorFilter(getIdColor(R.color.colorWhile));
                break;
            case R.id.activity_main_tab_setting:
                FragmentManager fragmentManager3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                FragmentSetting fragmentSetting = new FragmentSetting();
                fragmentTransaction3.add(R.id.activity_content,fragmentSetting);
                fragmentTransaction3.commit();
                tvSetting.setTextColor(getIdColor(R.color.colorRed));
                tvTalk.setTextColor(getIdColor(R.color.colorWhile));
                tvHome.setTextColor(getIdColor(R.color.colorWhile));
                imTabHome.setColorFilter(getIdColor(R.color.colorWhile));
                imTabTalk.setColorFilter(getIdColor(R.color.colorWhile));
                imTabSetting.setColorFilter(getIdColor(R.color.colorRed));
                break;
        }
    }

    private int getIdColor(int idcolor){

        int color = 0;
        if(Build.VERSION.SDK_INT > 21){
            color = ContextCompat.getColor(this,idcolor);
        }else {
            color = getResources().getColor(idcolor);
        }

        return color;

    }
}
