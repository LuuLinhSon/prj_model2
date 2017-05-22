package vn.hackademicshanoi.prj_model.View.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.MainActivity.MainActivity;

/**
 * Created by Admin on 5/19/2017.
 */

public class FragmentRegisterComplete extends Fragment implements View.OnClickListener{

    ImageView imGoHome;
    TextView tvDone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_complete,container,false);
        imGoHome = (ImageView) view.findViewById(R.id.imGoHome);
        tvDone = (TextView) view.findViewById(R.id.fragment_register_complete_txt_done);

        imGoHome.setOnClickListener(this);
        tvDone.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.imGoHome:
                Intent iHome = new Intent(getActivity(), MainActivity.class);
                startActivity(iHome);
                break;
            case R.id.fragment_register_complete_txt_done:
                break;
        }
    }
}
