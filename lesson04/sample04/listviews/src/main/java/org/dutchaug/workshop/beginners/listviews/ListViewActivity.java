package org.dutchaug.workshop.beginners.listviews;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListViewActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getListView().setAdapter(new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.animals)));
    }

}