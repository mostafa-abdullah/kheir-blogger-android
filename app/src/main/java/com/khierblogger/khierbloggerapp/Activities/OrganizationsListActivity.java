package com.khierblogger.khierbloggerapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.khierblogger.khierbloggerapp.Adapters.OrganizationsAdapter;
import com.khierblogger.khierbloggerapp.CircleImageView;
import com.khierblogger.khierbloggerapp.Intefaces.OrganizationClickedCallback;
import com.khierblogger.khierbloggerapp.Intefaces.OrganizationsResponseCallback;
import com.khierblogger.khierbloggerapp.KhierBloggerServer;
import com.khierblogger.khierbloggerapp.MainClasses.Organization;
import com.khierblogger.khierbloggerapp.R;
import com.khierblogger.khierbloggerapp.Utils;

import java.util.ArrayList;

public class OrganizationsListActivity extends AppCompatActivity implements OrganizationClickedCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizations_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        KhierBloggerServer.getAllOrganizations(new OrganizationsResponseCallback() {
            @Override
            public void onOrganizationFetched(final ArrayList<Organization> organizations) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                        recyclerView.setLayoutManager(new LinearLayoutManager(OrganizationsListActivity.this));
                        recyclerView.setAdapter(new OrganizationsAdapter(organizations , OrganizationsListActivity.this));
                    }
                });
            }

            @Override
            public void onError(final String errorMessage) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OrganizationsListActivity.this, "Couldn't load Organizations", Toast.LENGTH_SHORT).show();
                        Utils.Log(errorMessage);
                    }
                });
            }
            @Override
            public Context getContext() {
                return OrganizationsListActivity.this;
            }
        });
    }

    @Override
    public void onOrganizationClicked(Organization organization ,CircleImageView sharedImageView) {
        Intent intent = new Intent(this , OrganizationActivity.class);
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                Pair.create((View) sharedImageView, getString(R.string.organization_image_activity_transaction)));
        startActivity(intent, compat.toBundle());
    }
}
