package vn.hackademicshanoi.prj_model.View.MainActivity.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.hackademicshanoi.prj_model.Adapter.AdapterSetting;
import vn.hackademicshanoi.prj_model.R;

/**
 * Created by Admin on 5/19/2017.
 */

public class FragmentSetting extends Fragment {

    ListView lvSettings;
    List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,container,false);
        lvSettings = (ListView) view.findViewById(R.id.listviewsettings);

        list = new ArrayList<>();
        list.add("Thông tin");
        list.add("Instagram");
        list.add("ID của bạn");
        list.add("Sửa chữa");
        list.add("Thoát");

        AdapterSetting adapter = new AdapterSetting(getContext(),R.layout.custom_layout_setting,list);
        lvSettings.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
}
