package uag.vlarios.greenhousecontrol;

/**
 * Created by vlarios on 11/24/2014.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class SensorsListItemAdapter  extends BaseAdapter {

    private Context mContext = null;
    private ArrayList <ListItem> mArrayList = null;
    private LayoutInflater mLayoutInflater = null;

    public SensorsListItemAdapter (Context context, ArrayList <ListItem> arrayList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mArrayList = arrayList;
    }

    @Override
    public Object getItem(int position) {

        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getCount (){
        return mArrayList.size();
    }

    static class Holder {
        TextView txtHeader;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        View view = convertView;
        //Check if view is null
        if (view == null){
            holder = new Holder ();
            view = mLayoutInflater.inflate(R.layout.list_item,null);
            holder.txtHeader = (TextView)view.findViewById(R.id.text_header);
            view.setTag(holder);
        }
        else{
            holder=(Holder)view.getTag();

        }

        holder.txtHeader.setText(mArrayList.get(position).getHeader());


        return view;
    }

}
