package vn.hackademicshanoi.prj_model.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import vn.hackademicshanoi.prj_model.R;
import vn.hackademicshanoi.prj_model.View.Popup.PopupAvatar;

/**
 * Created by Admin on 5/16/2017.
 */

public class AdapterImageProfileThree extends RecyclerView.Adapter<AdapterImageProfileThree.ViewHolderImage> {

    Context context;
    public static final int RESQUEST_CODE_IMAGE = 1212;
    List<Bitmap> bitmapList;

    public AdapterImageProfileThree(Context context,List<Bitmap> bitmapList){
        this.context = context;
        this.bitmapList = bitmapList;
    }

    public class ViewHolderImage extends RecyclerView.ViewHolder {
        ImageView imImage,imDelete;
        public ViewHolderImage(View itemView) {
            super(itemView);
            imImage = (ImageView) itemView.findViewById(R.id.imImage);
            imDelete = (ImageView) itemView.findViewById(R.id.imDelete);
        }
    }

    @Override
    public ViewHolderImage onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_profile03a,parent,false);

        ViewHolderImage viewHolderImage = new ViewHolderImage(view);
        return viewHolderImage;
    }

    @Override
    public void onBindViewHolder(final ViewHolderImage holder, final int position) {
        if(position == 0){
            holder.imImage.setImageResource(R.mipmap.frame_photo_a);
        }else if(position == 1){
            holder.imImage.setImageResource(R.mipmap.frame_photo_b);
        }else if(position == 2){
            holder.imImage.setImageResource(R.mipmap.frame_photo_c);
        }else {
            holder.imImage.setImageResource(R.mipmap.frame_photo_d);
        }

        if(bitmapList.size() != 0){
            holder.imImage.setImageBitmap(bitmapList.get(position));
        }

//        holder.imImage.setImageBitmap(bitmapList.get(position));

        holder.imImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PopupAvatar.class);
                intent.putExtra("position",position);
                ((AppCompatActivity)context).startActivityForResult(intent,RESQUEST_CODE_IMAGE);
            }
        });

    }
    @Override
    public int getItemCount() {
        return 15;
    }

}
