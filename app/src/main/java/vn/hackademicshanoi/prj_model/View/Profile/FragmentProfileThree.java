package vn.hackademicshanoi.prj_model.View.Profile;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import vn.hackademicshanoi.prj_model.Adapter.AdapterGridviewImage;
import vn.hackademicshanoi.prj_model.Model.Object.ImageProfile;
import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.Popup.PopupAvatar;

/**
 * Created by Admin on 5/11/2017.
 */

public class FragmentProfileThree extends Fragment implements View.OnClickListener{

    List<ImageProfile> imageProfileList;
    public static final int RESQUEST_CODE_IMAGE = 1212;
    public GridView gridView;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView tvBack,tvNext;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_three,container,false);
        gridView = (GridView) view.findViewById(R.id.gridImage);
        tvBack = (TextView) view.findViewById(R.id.fragment_profile_three_back);
        tvNext = (TextView) view.findViewById(R.id.done);

        sharedPreferences = getContext().getSharedPreferences("profileone", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        imageProfileList = new ArrayList<>();
        // Khởi tạo 15 đối tượng tương đương 15 ảnh
        ImageProfile imageProfile = new ImageProfile();
        ImageProfile imageProfile2 = new ImageProfile();
        ImageProfile imageProfile3 = new ImageProfile();
        ImageProfile imageProfile4 = new ImageProfile();
        ImageProfile imageProfile5 = new ImageProfile();
        ImageProfile imageProfile6 = new ImageProfile();
        ImageProfile imageProfile7 = new ImageProfile();
        ImageProfile imageProfile8 = new ImageProfile();
        ImageProfile imageProfile9 = new ImageProfile();
        ImageProfile imageProfile10 = new ImageProfile();
        ImageProfile imageProfile11 = new ImageProfile();
        ImageProfile imageProfile12 = new ImageProfile();
        ImageProfile imageProfile13 = new ImageProfile();
        ImageProfile imageProfile14 = new ImageProfile();
        ImageProfile imageProfile15 = new ImageProfile();

        // khai báo bitmap mặc định
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.frame_photo_a);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.frame_photo_b);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(),R.mipmap.frame_photo_c);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(),R.mipmap.frame_photo_d);

        //Xét bitmap mặc định cho đối tượng imageProfile
        imageProfile.setBitmap(bitmap);
        imageProfile2.setBitmap(bitmap2);
        imageProfile3.setBitmap(bitmap3);
        imageProfile4.setBitmap(bitmap4);
        imageProfile5.setBitmap(bitmap4);
        imageProfile6.setBitmap(bitmap4);
        imageProfile7.setBitmap(bitmap4);
        imageProfile8.setBitmap(bitmap4);
        imageProfile9.setBitmap(bitmap4);
        imageProfile10.setBitmap(bitmap4);
        imageProfile11.setBitmap(bitmap4);
        imageProfile12.setBitmap(bitmap4);
        imageProfile13.setBitmap(bitmap4);
        imageProfile14.setBitmap(bitmap4);
        imageProfile15.setBitmap(bitmap4);

        // Add 15 đối tượng này vào một imageProfileList
        imageProfileList.add(imageProfile);
        imageProfileList.add(imageProfile2);
        imageProfileList.add(imageProfile3);
        imageProfileList.add(imageProfile4);
        imageProfileList.add(imageProfile5);
        imageProfileList.add(imageProfile6);
        imageProfileList.add(imageProfile7);
        imageProfileList.add(imageProfile8);
        imageProfileList.add(imageProfile9);
        imageProfileList.add(imageProfile10);
        imageProfileList.add(imageProfile11);
        imageProfileList.add(imageProfile12);
        imageProfileList.add(imageProfile13);
        imageProfileList.add(imageProfile14);
        imageProfileList.add(imageProfile15);

        // khởi tạo gridview
        AdapterGridviewImage adapterGridviewImage = new AdapterGridviewImage(getContext(),R.layout.item_profile03a,imageProfileList);
        gridView.setAdapter(adapterGridviewImage);
        adapterGridviewImage.notifyDataSetChanged();
        // xét sự kiện click vào item cho gridview
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), PopupAvatar.class);
                // Truyền position sang PopupAvatar để sau này popupavatar trả về position còn biết add vào list ở position nào
                intent.putExtra("position",position);
                startActivityForResult(intent,RESQUEST_CODE_IMAGE);
            }
        });

        tvBack.setOnClickListener(this);
        tvNext.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESQUEST_CODE_IMAGE){
            if(resultCode == Activity.RESULT_OK){
                Intent intent = data;
                Bitmap bm = (Bitmap) intent.getExtras().get("hinhanh");
                int position = intent.getIntExtra("position",0);

                ImageProfile imageProfile = new ImageProfile();
                imageProfile.setBitmap(bm);
                imageProfile.setPosition(position);
                Bitmap bitmapDelete = BitmapFactory.decodeResource(getResources(),R.mipmap.bt_remove_photo);
                imageProfile.setBitmapDelete(bitmapDelete);

                // khi nhận được dữ liệu ảnh và position trả về ta tiến hành xét ảnh vào position được gửi qua
                imageProfileList.set(position,imageProfile);
                // Cập nhật lại gridview
                AdapterGridviewImage adapterGridviewImage = new AdapterGridviewImage(getContext(),R.layout.item_profile03a,imageProfileList);
                gridView.setAdapter(adapterGridviewImage);
                adapterGridviewImage.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fragment_profile_three_back:
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentProfileTwo fragmentProfileTwo = new FragmentProfileTwo();
                fragmentTransaction.add(R.id.content,fragmentProfileTwo);
                fragmentTransaction.commit();
                break;
            case R.id.done:
                editor.clear().commit();
                FragmentManager fragmentManager2 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                FragmentRegisterComplete fragmentRegisterComplete = new FragmentRegisterComplete();
                fragmentTransaction2.add(R.id.content,fragmentRegisterComplete);
                fragmentTransaction2.commit();
                break;
        }
    }
}
