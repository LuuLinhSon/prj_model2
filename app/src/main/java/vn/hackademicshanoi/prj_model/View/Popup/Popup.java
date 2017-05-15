package vn.hackademicshanoi.prj_model.View.Popup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import vn.hackademicshanoi.prj_model.R;

/**
 * Created by Admin on 5/12/2017.
 */

public class Popup extends AppCompatActivity {

    ListView lvPopup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        lvPopup = (ListView) findViewById(R.id.lvPopup);

        Intent intent = getIntent();
        final ArrayList<String> arr = intent.getStringArrayListExtra("listgender");
        final String title = intent.getStringExtra("gender");

        setTitle(title);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        lvPopup.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        lvPopup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = arr.get(position).toString();

                Intent iFPO = new Intent();
                iFPO.putExtra("gender",s);
                setResult(Activity.RESULT_OK,iFPO);
                finish();
            }
        });
    }


}
