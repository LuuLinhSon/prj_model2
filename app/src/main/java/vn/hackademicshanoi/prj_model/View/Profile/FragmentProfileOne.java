package vn.hackademicshanoi.prj_model.View.Profile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.hackademicshanoi.prj_model.Model.Profile.ModelProfile;
import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.Popup.Popup;
import vn.hackademicshanoi.prj_model.View.Popup.PopupAvatar;

/**
 * Created by Admin on 5/11/2017.
 */

public class FragmentProfileOne extends Fragment implements View.OnClickListener{
    TextView tvGender,tvNext,tvHeight,tvWeight,tvSizeShoe,tvSizeClothes,tvBack;
    EditText edUsername;
    ImageView imAvatar;
    ArrayList<String> arrGender;
    ArrayList<String> arrHeight;
    ArrayList<String> arrWeight;
    ArrayList<String> arrSizeShoe;
    ArrayList<String> arrSizeClothes;
    ArrayList<String> arrMagazine;


    ArrayList<ArrayList> arrProfile;
    public static final int REQUES_CODE_GENDER = 1111;
    public static final int REQUES_CODE_HEIGHT = 2222;
    public static final int REQUES_CODE_WEIGHT= 3333;
    public static final int REQUES_CODE_SIZE_SHOE = 4444;
    public static final int REQUES_CODE_SIZE_CLOTHES = 5555;
    public static final int REQUES_CODE_MAGAZINE = 6666;
    public static final int REQUES_CODE_AVATAR = 8888;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_one,container,false);
        tvGender = (TextView) view.findViewById(R.id.fragment_profile_one_gender);
        tvNext = (TextView) view.findViewById(R.id.fragment_profile_one_next);
        tvBack = (TextView) view.findViewById(R.id.fragment_profile_one_back);
        edUsername = (EditText) view.findViewById(R.id.fragment_profile_one_name);
        tvHeight = (TextView) view.findViewById(R.id.fragment_profile_one_height);
        tvWeight = (TextView) view.findViewById(R.id.fragment_profile_one_weight);
        tvSizeShoe = (TextView) view.findViewById(R.id.fragment_profile_one_shoe_size);
        tvSizeClothes = (TextView) view.findViewById(R.id.fragment_profile_one_clothe_size);
        imAvatar = (ImageView) view.findViewById(R.id.fragment_profile_one_avatar);

        ModelProfile modelProfile = new ModelProfile();

        arrGender = new ArrayList<>();
        arrProfile = new ArrayList<>();
        arrHeight = new ArrayList<>();
        arrWeight = new ArrayList<>();
        arrSizeShoe = new ArrayList<>();
        arrSizeClothes = new ArrayList<>();
        arrMagazine = new ArrayList<>();


        arrProfile = modelProfile.LayDuLieuProfileOne(getContext());

        arrGender.add("Male");
        arrGender.add("Famale");
//        arrHeight = arrProfile.get(0);
//        arrWeight = arrProfile.get(1);
//        arrSizeShoe = arrProfile.get(2);
//        arrSizeClothes = arrProfile.get(3);
//        arrMagazine = arrProfile.get(4);

        tvGender.setOnClickListener(this);
        tvNext.setOnClickListener(this);
        tvHeight.setOnClickListener(this);
        tvWeight.setOnClickListener(this);
        tvSizeShoe.setOnClickListener(this);
        tvSizeClothes.setOnClickListener(this);
        tvBack.setOnClickListener(this);
        imAvatar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fragment_profile_one_avatar:
                Intent iPopupCamera = new Intent(getContext(), PopupAvatar.class);
                startActivityForResult(iPopupCamera,REQUES_CODE_AVATAR);

                break;
            case R.id.fragment_profile_one_gender:
                Intent iGenderPopup = new Intent(getContext(), Popup.class);
                iGenderPopup.putStringArrayListExtra("listgender",arrGender);
                iGenderPopup.putExtra("gender","Gender");
                iGenderPopup.putExtra("token","1");
                startActivityForResult(iGenderPopup,REQUES_CODE_GENDER);
                break;
            case R.id.fragment_profile_one_back:

                break;
            case R.id.fragment_profile_one_next:
                String username = edUsername.getText().toString();
                String gender = tvGender.getText().toString();
                if(username.trim().equals("") || gender.trim().equals("")){
                    Toast.makeText(getActivity(),"Username và giới tính không được để trống",Toast.LENGTH_SHORT).show();
                }else {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    FragmentProfileTwo fragmentProfileTwo = new FragmentProfileTwo();
                    fragmentTransaction.addToBackStack("BeforeLoginActivity");
                    fragmentTransaction.add(R.id.content,fragmentProfileTwo);
                    fragmentTransaction.commit();
                }
                break;
            case R.id.fragment_profile_one_height:
                Intent iHeightPopup = new Intent(getContext(), Popup.class);
                iHeightPopup.putStringArrayListExtra("listheight",arrHeight);
                iHeightPopup.putExtra("height","Height");
                iHeightPopup.putExtra("token","2");
                startActivityForResult(iHeightPopup,REQUES_CODE_HEIGHT);
                break;
            case R.id.fragment_profile_one_weight:
                Intent iWeightPopup = new Intent(getContext(), Popup.class);
                iWeightPopup.putStringArrayListExtra("listweight",arrWeight);
                iWeightPopup.putExtra("weight","Weight");
                iWeightPopup.putExtra("token","3");
                startActivityForResult(iWeightPopup,REQUES_CODE_WEIGHT);
                break;
            case R.id.fragment_profile_one_shoe_size:
                Intent iShoeSizePopup = new Intent(getContext(), Popup.class);
                iShoeSizePopup.putStringArrayListExtra("listsizeshoe",arrSizeShoe);
                iShoeSizePopup.putExtra("sizeshoe","Size Shoe");
                iShoeSizePopup.putExtra("token","4");
                startActivityForResult(iShoeSizePopup,REQUES_CODE_SIZE_SHOE);
                break;
            case R.id.fragment_profile_one_clothe_size:
                Intent iSizeClothesPopup = new Intent(getContext(), Popup.class);
                iSizeClothesPopup.putStringArrayListExtra("listsizeclothes",arrSizeClothes);
                iSizeClothesPopup.putExtra("sizeclothes","Size Clothes");
                iSizeClothesPopup.putExtra("token","5");
                startActivityForResult(iSizeClothesPopup,REQUES_CODE_SIZE_CLOTHES);
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
        }else if (requestCode == REQUES_CODE_HEIGHT){
            if(resultCode == Activity.RESULT_OK){
                Intent result = data;
                String height = result.getStringExtra("height");
                tvHeight.setText(height);
            }
        }else if (requestCode == REQUES_CODE_WEIGHT){
            if(resultCode == Activity.RESULT_OK){
                Intent result = data;
                String weight = result.getStringExtra("weight");
                tvWeight.setText(weight);
            }
        }else if (requestCode == REQUES_CODE_SIZE_SHOE){
            if(resultCode == Activity.RESULT_OK){
                Intent result = data;
                String sizeshoe = result.getStringExtra("sizeshoe");
                tvSizeShoe.setText(sizeshoe);
            }
        }else if (requestCode == REQUES_CODE_SIZE_CLOTHES){
            if(resultCode == Activity.RESULT_OK){
                Intent result = data;
                String sizeclothes = result.getStringExtra("sizeclothes");
                tvSizeClothes.setText(sizeclothes);
            }
        }else if (requestCode == REQUES_CODE_AVATAR){
            if(resultCode == Activity.RESULT_OK){
                Intent result = data;
                Bitmap bm = (Bitmap) result.getExtras().get("hinhanh");
                imAvatar.setImageBitmap(bm);
            }
        }
    }
}
