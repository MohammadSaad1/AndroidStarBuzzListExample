package com.anbo.starbuzzlistexample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DrinkCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_drink_category);

        // http://stackoverflow.com/questions/18368010/listview-with-title
        ListView listView = getListView();
        TextView header = new TextView(this);
        // http://stackoverflow.com/questions/9494037/how-to-set-text-size-of-textview-dynamically-for-different-screens
        header.setTextSize(header.getTextSize() * 1.1f);
        header.setText("Drinks list");
        listView.addHeaderView(header);
        //ArrayAdapter<Drink> adapter = new ArrayAdapter<Drink>(
        //        this, android.R.layout.simple_list_item_1, Drink.drinks);
        DrinkListItemAdapter adapter = new DrinkListItemAdapter(this, R.layout.drinklist_item, Drink.drinks);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
        intent.putExtra(DrinkActivity.EXTRA_DRINKNO, id);
        startActivity(intent);
    }
}
