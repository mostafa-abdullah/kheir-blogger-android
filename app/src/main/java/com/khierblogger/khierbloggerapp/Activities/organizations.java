package com.khierblogger.khierbloggerapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.khierblogger.khierbloggerapp.MainClasses.Organization;
import com.khierblogger.khierbloggerapp.R;

public class organizations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizations);

        Organization[] organizations ={new Organization(1, "organization1", "x@x.com", "password", "organization description", "", "12312", "",
        3, null, null)};
        ListAdapter myAdapter = new OrganizationListAdapter(this,organizations);
        ListView myListView = (ListView) findViewById(R.id.organizationsListView);
        myListView.setAdapter(myAdapter);
    }
}
