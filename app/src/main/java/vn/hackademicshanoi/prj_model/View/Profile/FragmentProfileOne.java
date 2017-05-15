package vn.hackademicshanoi.prj_model.View.Profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.Popup.Popup;

/**
 * Created by Admin on 5/11/2017.
 */

public class FragmentProfileOne extends Fragment implements View.OnClickListener{
    TextView tvGender,tvNext;
    EditText edUsername;
    ArrayList<String> arrlist;
    public static final int REQUES_CODE_GENDER = 1111;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_one,container,false);
        tvGender = (TextView) view.findViewById(R.id.fragment_profile_one_gender);
        tvNext = (TextView) view.findViewById(R.id.fragment_profile_one_next);
        edUsername = (EditText) view.findViewById(R.id.fragment_profile_one_name);

        arrlist = new ArrayList<>();
        arrlist.add("Male");
        arrlist.add("Famale");

        tvGender.setOnClickListener(this);
        tvNext.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fragment_profile_one_gender:
                Intent iPopup = new Intent(getContext(), Popup.class);
                iPopup.putStringArrayListExtra("listgender",arrlist);
                iPopup.putExtra("gender","Gender");
                startActivityForResult(iPopup,REQUES_CODE_GENDER);
                break;
            case R.id.fragment_profile_one_next:
                String username = edUsername.getText().toString();
                String gender = tvGender.getText().toString();
                if(username.trim().equals("") || gender.trim().equals("")){
                    Toast.makeText(getActivity(),"Username và giới tính không được để trống",Toast.LENGTH_SHORT).show();
                }else {

                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUES_CODE_GENDER){
            if(resultCode == Activity.RESULT_OK){
                Intent result = data;
                String gender = result.getStringExtra("gender");
                tvGender.setText(gender);
            }
        }
    }
}
