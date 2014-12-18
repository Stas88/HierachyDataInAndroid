package com.onefinestay.onefinestay.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.onefinestay.onefinestay.model.IHouseLevelModel;

import java.util.List;

/**
 * Created by stanislavsikorsyi on 18.12.14.
 */
public class HouseLevelAdapter extends ArrayAdapter<IHouseLevelModel> {

    private final Context context;
    private final List<IHouseLevelModel> houseLevelModels;
    private LayoutInflater inflater;


    public HouseLevelAdapter(Context context, List<IHouseLevelModel> houseLevelModel) {
        super(context, android.R.layout.simple_list_item_2, houseLevelModel);
        this.context = context;
        this.houseLevelModels = houseLevelModel;
        inflater = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (null == rowView) {
            rowView = inflater.inflate(android.R.layout.simple_list_item_2, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) rowView.findViewById(android.R.id.text1);
            rowView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String houseName = houseLevelModels.get(position).getName();
        holder.name.setText(houseName);
        return rowView;
    }

    private static class ViewHolder {
        public TextView name;
    }

    public List<IHouseLevelModel> getHouseLevelModelList()
    {
        return houseLevelModels;
    }

}