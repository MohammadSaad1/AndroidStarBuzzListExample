package com.anbo.starbuzzlistexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrinkListItemAdapter extends ArrayAdapter<Drink> {
    private int resource;

    public DrinkListItemAdapter(Context context, int resource, Drink[] items) {
        super(context, resource, items);
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Drink item = getItem(position);
        String name = item.getName();
        String description = item.getDescription();
        LinearLayout itemView;
        if (convertView == null) {
            itemView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
            li.inflate(resource, itemView, true);
        } else {
            itemView = (LinearLayout) convertView;
        }
        TextView nameView = (TextView) itemView.findViewById(R.id.drinklist_item_name);
        TextView descriptionView = (TextView) itemView.findViewById(R.id.drinklist_item_description);
        nameView.setText(name);
        descriptionView.setText(description);
        return itemView;
    }
}
