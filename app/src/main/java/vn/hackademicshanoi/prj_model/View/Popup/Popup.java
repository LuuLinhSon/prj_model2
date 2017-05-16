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
     ArrayList<String> arr;
     String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        lvPopup = (ListView) findViewById(R.id.lvPopup);

        Intent intent = getIntent();
        String token = intent.getStringExtra("token");
        if(token.equals("1")){
            arr = intent.getStringArrayListExtra("listgender");
            title = intent.getStringExtra("gender");
        }else if(token.equals("2")){
            arr = intent.getStringArrayListExtra("listheight");
            title = intent.getStringExtra("height");
        }else if(token.equals("3")){
            arr = intent.getStringArrayListExtra("listweight");
            title = intent.getStringExtra("weight");
        }else if(token.equals("4")){
            arr = intent.getStringArrayListExtra("listsizeshoe");
            title = intent.getStringExtra("sizeshoe");
        }else if(token.equals("5")){
            arr = intent.getStringArrayListExtra("listsizeclothes");
            title = intent.getStringExtra("sizeclothes");
        }else if(token.equals("8")){
            arr = intent.getStringArrayListExtra("arrmagazine");
            title = intent.getStringExtra("magazine");
        }


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
                iFPO.putExtra("height",s);
                iFPO.putExtra("weight",s);
                iFPO.putExtra("sizeshoe",s);
                iFPO.putExtra("sizeclothes",s);
                iFPO.putExtra("magazine",s);
                setResult(Activity.RESULT_OK,iFPO);
                finish();
            }
        });
    }


}
