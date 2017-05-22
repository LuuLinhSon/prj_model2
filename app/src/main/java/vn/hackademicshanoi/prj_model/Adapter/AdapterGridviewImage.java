package vn.hackademicshanoi.prj_model.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.hackademicshanoi.prj_model.Model.Object.ImageProfile;
import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.Popup.PopupAvatar;
import vn.hackademicshanoi.prj_model.View.Profile.FragmentProfileThree;

import static java.security.AccessController.getContext;
import static vn.hackademicshanoi.prj_model.View.Profile.FragmentProfileThree.RESQUEST_CODE_IMAGE;

/**
 * Created by Admin on 5/17/2017.
 */

public class AdapterGridviewImage extends BaseAdapter {

    Context context;
    int layout;
    List<ImageProfile> imageProfileList;
    ImageProfile imageProfile;
    ViewHolder viewHolder;
    View view;

    public AdapterGridviewImage(Context context, int layout, List<ImageProfile> imageProfileList){
        this.context = context;
        this.layout = layout;
        this.imageProfileList = imageProfileList;
    }

    @Override
    public int getCount() {
        return imageProfileList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageProfileList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return imageProfileList.get(position).getId();
    }

    public class ViewHolder{
       ImageView imImage,imDelete;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            viewHolder.imImage = (ImageView) view.findViewById(R.id.imImage);
            viewHolder.imDelete = (ImageView) view.findViewById(R.id.imDelete);

            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        imageProfile = imageProfileList.get(position);
        viewHolder.imImage.setImageBitmap(imageProfile.getBitmap());
        viewHolder.imDelete.setImageBitmap(imageProfile.getBitmapDelete());

        viewHolder.imDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){
                    imageProfile.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.mipmap.frame_photo_a));
                    imageProfileList.set(position,imageProfile);
                    notifyDataSetChanged();
                }else if (position == 1){
                    imageProfile.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.mipmap.frame_photo_b));
                    imageProfileList.set(position,imageProfile);
                    notifyDataSetChanged();
                }else if(position == 2){
                    imageProfile.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.mipmap.frame_photo_c));
                    imageProfileList.set(position,imageProfile);
                    notifyDataSetChanged();
                }else {
                    imageProfile.setBitmap(BitmapFactory.decodeResource(context.getResources(),R.mipmap.frame_photo_d));
                    imageProfileList.set(position,imageProfile);
                    notifyDataSetChanged();
                }
            }
        });

        return view;
    }
}
