package vn.hackademicshanoi.prj_model.Model.Object;

import android.graphics.Bitmap;
import android.net.Uri;

/**
 * Created by Admin on 5/17/2017.
 */

public class ImageProfile {

    int id;
    Bitmap bitmap;
    Bitmap BitmapDelete;
    int position;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Bitmap getBitmapDelete() {
        return BitmapDelete;
    }

    public void setBitmapDelete(Bitmap bitmapDelete) {
        BitmapDelete = bitmapDelete;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
