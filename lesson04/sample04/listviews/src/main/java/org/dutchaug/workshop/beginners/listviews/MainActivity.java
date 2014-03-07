package org.dutchaug.workshop.beginners.listviews;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] entries = getResources().getStringArray(R.array.activities);

        int layoutId = android.R.layout.simple_list_item_1;

        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<CharSequence>(this, layoutId, entries);

        getListView().setAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, ListViewInLayoutActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, ListViewActivity.class));
                break;
        }
    }

}