package vn.hackademicshanoi.prj_model.View.ManagerLogin;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import vn.hackademicshanoi.prj_model.Model.ModelLogIn;
import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.BeforeLogin.BeforeLoginActivity;
import vn.hackademicshanoi.prj_model.View.MainActivity.MainActivity;

/**
 * Created by Admin on 5/10/2017.
 */

public class ManagerLogin extends AppCompatActivity implements View.OnClickListener{

    TextView txtBack,txtError;
    ImageView imgLogIn,imgForgotPassword;
    EditText edID,edPassword;
    boolean checkID = false;
    boolean checkPass = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_manager);

        txtBack = (TextView) findViewById(R.id.fragment_login_manager_back);
        txtError = (TextView) findViewById(R.id.txtError);
        imgLogIn = (ImageView) findViewById(R.id.fragment_login_manager_bt_login);
        imgForgotPassword = (ImageView) findViewById(R.id.fragment_login_manager_bt_forgot);
        edID = (EditText) findViewById(R.id.fragment_login_manager_txt_id);
        edPassword = (EditText) findViewById(R.id.fragment_login_manager_txt_password);

        txtBack.setOnClickListener(this);
        imgLogIn.setOnClickListener(this);
        imgForgotPassword.setOnClickListener(this);

        edID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count > 0 || start > 0){
                    checkID = true;
                }else {
                    checkID = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(checkID && checkPass){
                    txtError.setText("");
                }else {
                    txtError.setText("Vui lòng nhập ID và Password");
                }
            }
        });

        edPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count > 0 || start > 0){
                    checkPass = true;
                }else {
                    checkPass = false;
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(checkID && checkPass){
                    txtError.setText("");
                }else {
                    txtError.setText("Vui lòng nhập ID và Password");
                }
            }
        });




    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fragment_login_manager_back:
                Intent iBeforeLogin = new Intent(this, BeforeLoginActivity.class);
                startActivity(iBeforeLogin);
                finish();
                break;
            case R.id.fragment_login_manager_bt_login:
                Intent iHome = new Intent(this, MainActivity.class);
                        startActivity(iHome);
//                if(checkConnectionNetword()){
//                    String idManager = edID.getText().toString();
//                    String passWord = edPassword.getText().toString();
//
//                    ModelLogIn modelLogIn = new ModelLogIn();
//                    boolean checkLogin = modelLogIn.KiemTraDangNhap(this,idManager,passWord);
//                    if(checkLogin){
//                        Intent iHome = new Intent(this, MainActivity.class);
//                        startActivity(iHome);
//                    }else {
//                        txtError.setText("Tên manager và password không đúng");
//                    }
//                }else {
//                    txtError.setText("Mất kết nối Internet.Vui lòng thử lại");
//                }
//                break;
            case R.id.fragment_login_manager_bt_forgot:
                break;

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(event.getAction() == KeyEvent.ACTION_DOWN){
                Intent iBeforeLogin = new Intent(this,BeforeLoginActivity.class);
                startActivity(iBeforeLogin);
                finish();
        }
        return false;
    }

    private boolean checkConnectionNetword(){
        ConnectivityManager connectivityManager = (ConnectivityManager) ManagerLogin.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        }else {
            return false;
        }
    }

}
