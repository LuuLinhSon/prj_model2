package vn.hackademicshanoi.prj_model.View.MainActivity.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.hackademicshanoi.prj_model.R;

/**
 * Created by Admin on 5/19/2017.
 */

public class FragmentTalk extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_one,container,false);



        return view;
    }
}
