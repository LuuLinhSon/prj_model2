package vn.hackademicshanoi.prj_model.View.Profile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import vn.hackademicshanoi.prj_model.Adapter.AdapterImageProfileThree;
import vn.hackademicshanoi.prj_model.R;

/**
 * Created by Admin on 5/11/2017.
 */

public class FragmentProfileThree extends Fragment {

    RecyclerView recyclerImage;
    List<Bitmap> bitmapList;
    AdapterImageProfileThree adapterImageProfileThree;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_three,container,false);
        recyclerImage = (RecyclerView) view.findViewById(R.id.rycyclerImage);
        bitmapList = new ArrayList<>();

        adapterImageProfileThree = new AdapterImageProfileThree(getContext(),bitmapList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2, LinearLayoutManager.VERTICAL,false);

        recyclerImage.setAdapter(adapterImageProfileThree);
        recyclerImage.setLayoutManager(layoutManager);

        adapterImageProfileThree.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AdapterImageProfileThree.RESQUEST_CODE_IMAGE){
            if(resultCode == Activity.RESULT_OK){
                Intent intent = data;
                Bitmap bm = (Bitmap) intent.getExtras().get("hinhanh");
                int position = intent.getIntExtra("position",0);
                Log.d("info", "onActivityResult: " + bm.toString() + position + "");
                Toast.makeText(getContext(),bm.toString() + position + "",Toast.LENGTH_SHORT).show();
                bitmapList.add(position,bm);
                adapterImageProfileThree = new AdapterImageProfileThree(getContext(),bitmapList);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2, LinearLayoutManager.VERTICAL,false);

                recyclerImage.setAdapter(adapterImageProfileThree);
                recyclerImage.setLayoutManager(layoutManager);

                adapterImageProfileThree.notifyDataSetChanged();
            }
        }
    }
}
