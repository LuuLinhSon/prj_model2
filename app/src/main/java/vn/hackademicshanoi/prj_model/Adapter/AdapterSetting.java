package vn.hackademicshanoi.prj_model.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.hackademicshanoi.prj_model.R;

/**
 * Created by Admin on 5/22/2017.
 */

public class AdapterSetting extends BaseAdapter {

    Context context;
    int layout;
    List<String> list;
    ViewHolder viewHolder;

    public AdapterSetting(Context context, int layout, List<String> list){
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            viewHolder.textView = (TextView) view.findViewById(R.id.tvsetting);
            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        String ten = list.get(position);
        viewHolder.textView.setText(ten);
        return view;
    }
}
