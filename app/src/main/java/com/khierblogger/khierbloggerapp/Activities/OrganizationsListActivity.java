package com.khierblogger.khierbloggerapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.khierblogger.khierbloggerapp.Adapters.OrganizationsAdapter;
import com.khierblogger.khierbloggerapp.CustomViews.ErrorView.ErrorView;
import com.khierblogger.khierbloggerapp.Intefaces.OrganizationCallbacks.OrganizationClickedCallback;
import com.khierblogger.khierbloggerapp.Intefaces.OrganizationCallbacks.OrganizationsResponseCallback;
import com.khierblogger.khierbloggerapp.KhierBloggerServer;
import com.khierblogger.khierbloggerapp.MainClasses.Organization;
import com.khierblogger.khierbloggerapp.R;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;

public class OrganizationsListActivity extends AppCompatActivity implements OrganizationClickedCallback ,
        OrganizationsResponseCallback{

    private ErrorView errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizations_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        errorView = (ErrorView) findViewById(R.id.error_view);
        errorView.setOnRetryListener(new ErrorView.RetryListener() {
            @Override
            public void onRetry() {
                Toast.makeText(OrganizationsListActivity.this, "Trying one more time", Toast.LENGTH_SHORT).show();
                KhierBloggerServer.getAllOrganizations(OrganizationsListActivity.this);
            }
        });
        KhierBloggerServer.getAllOrganizations(this);
    }

    @Override
    public void onOrganizationClicked(Organization organization ,ImageView sharedImageView) {
        Intent intent = new Intent(this , OrganizationActivity.class);
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                Pair.create((View) sharedImageView, getString(R.string.organization_image_activity_transaction)));
        intent.putExtra(OrganizationActivity.ORGANIZATION_IDENTIFIER, organization.getId());
        startActivity(intent, compat.toBundle());
    }

    @Override
    public void onOrganizationsFetched(final ArrayList<Organization> organizations) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (errorView.getVisibility() == View.VISIBLE)
                    errorView.setVisibility(View.GONE);

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(OrganizationsListActivity.this));
                recyclerView.setAdapter(new OrganizationsAdapter(organizations , OrganizationsListActivity.this));
            }
        });
    }

    @Override
    public void onFailure(String errorMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                errorView.setVisibility(View.VISIBLE);
                if (isNetworkAvailable()) {
                    Toast.makeText(OrganizationsListActivity.this, getString(R.string.organization_load_error_message), Toast.LENGTH_SHORT).show();
                    errorView.setImage(R.drawable.error_view_cloud);
                    errorView.setSubtitle(R.string.no_internet_error_message);
                }else{
                    errorView.setImage(new IconicsDrawable(OrganizationsListActivity.this)
                            .icon(GoogleMaterial.Icon.gmd_signal_wifi_off)
                            .sizeDpX(100).sizeDpY(80).colorRes(R.color.white));
                    errorView.setSubtitle(R.string.no_internet_error_message);
                }
            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
