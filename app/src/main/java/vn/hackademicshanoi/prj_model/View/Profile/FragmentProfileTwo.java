package vn.hackademicshanoi.prj_model.View.Profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.Popup.Popup;

/**
 * Created by Admin on 5/11/2017.
 */

public class FragmentProfileTwo extends Fragment implements View.OnClickListener{

    ArrayList<String> arrMagazine;
    EditText edWeb,edSalon,edTv,edIntro;
    TextView tvMagazine,tvNext,tvBack;
    public static final int REQUES_CODE_MAGAZINE_TWO = 9999;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_two,container,false);

        edWeb = (EditText) view.findViewById(R.id.fragment_profile_two_fee_web);
        edSalon = (EditText) view.findViewById(R.id.fragment_profile_two_fee_salon);
        edTv = (EditText) view.findViewById(R.id.fragment_profile_two_fee_tv);
        edIntro = (EditText) view.findViewById(R.id.fragment_profile_two_introduction);
        tvMagazine = (TextView) view .findViewById(R.id.fragment_profile_two_magazine);
        tvNext = (TextView) view.findViewById(R.id.fragment_profile_two_next);
        tvBack = (TextView) view.findViewById(R.id.fragment_profile_two_back);

        sharedPreferences = getContext().getSharedPreferences("profileone", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        edWeb.setText(sharedPreferences.getString("web",""));
        edSalon.setText(sharedPreferences.getString("salon",""));
        edTv.setText(sharedPreferences.getString("tv",""));
        tvMagazine.setText(sharedPreferences.getString("magazine",""));
        edIntro.setText(sharedPreferences.getString("intro",""));

        tvMagazine.setOnClickListener(this);
        tvNext.setOnClickListener(this);
        tvBack.setOnClickListener(this);

    // Nhận dữ liệu dưới dạng bundle được gửi sang từ fragment_profile_one
        Bundle bundle = getArguments();
        try {
            arrMagazine = bundle.getStringArrayList("arrmagazine");
        }catch (NullPointerException e){

        }

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fragment_profile_two_magazine:
                Intent iMagazinePopup = new Intent(getContext(), Popup.class);
                iMagazinePopup.putStringArrayListExtra("arrmagazine",arrMagazine);
                iMagazinePopup.putExtra("magazine","Magazine");
                iMagazinePopup.putExtra("token","8");
                startActivityForResult(iMagazinePopup,REQUES_CODE_MAGAZINE_TWO);
                break;
            case R.id.fragment_profile_two_next:
                String web = edWeb.getText().toString();
                String salon = edSalon.getText().toString();
                String tv = edSalon.getText().toString();
                String intro = edIntro.getText().toString();
                //Lưu lại dữ liệu các trường vào sharepreference để không bị mất dữ liệu khi back lại
                editor.putString("web",web);
                editor.putString("salon",salon);
                editor.putString("tv",tv);
                editor.putString("intro",intro);
                editor.commit();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentProfileThree fragmentProfileThree = new FragmentProfileThree();
                fragmentTransaction.add(R.id.content,fragmentProfileThree);
                fragmentTransaction.commit();
                break;
            case R.id.fragment_profile_two_back:
                FragmentManager fragmentManager2 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                FragmentProfileOne fragmentProfileOne = new FragmentProfileOne();
                fragmentTransaction2.add(R.id.content,fragmentProfileOne);
                fragmentTransaction2.commit();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUES_CODE_MAGAZINE_TWO){
            if(resultCode == Activity.RESULT_OK){
                Intent result = data;
                String magazine = result.getStringExtra("magazine");
                tvMagazine.setText(magazine);
                editor.putString("magazine",magazine);
                editor.commit();
            }
        }
    }
}
