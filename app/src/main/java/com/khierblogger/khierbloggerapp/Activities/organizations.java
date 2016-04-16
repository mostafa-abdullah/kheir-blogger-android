package com.khierblogger.khierbloggerapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.khierblogger.khierbloggerapp.R;

public class organizations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizations);

        String[] organizations ={"Organization1","Organization2","Organization3","Organization4","Organization5","Organization6"};
        ListAdapter myAdapter = new OrganizationListAdapter(this,organizations);
        ListView myListView = (ListView) findViewById(R.id.organizationsListView);
        myListView.setAdapter(myAdapter);
    }
}
