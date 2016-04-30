package com.khierblogger.khierbloggerapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.khierblogger.khierbloggerapp.MainClasses.Organization;
import com.khierblogger.khierbloggerapp.R;
import com.khierblogger.khierbloggerapp.Utils;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDrawerAndToolbar();
    }

    private void initDrawerAndToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDrawerWidthDp(250)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.profile).withIcon(GoogleMaterial.Icon.gmd_account_circle).withIdentifier(0),
                        new PrimaryDrawerItem().withName(R.string.organizations).withIcon(GoogleMaterial.Icon.gmd_work).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.events).withIcon(GoogleMaterial.Icon.gmd_event).withIdentifier(2)
                )
                .addStickyDrawerItems(
                        new SecondaryDrawerItem().withName(R.string.action_settings).withIcon(GoogleMaterial.Icon.gmd_settings).withIdentifier(3),
                        new SecondaryDrawerItem().withName(R.string.open_source).withIcon(FontAwesome.Icon.faw_github).withIdentifier(4),
                        new SecondaryDrawerItem().withName(R.string.log_out).withIcon(FontAwesome.Icon.faw_sign_out).withIdentifier(5)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch ((int)drawerItem.getIdentifier()){
                            case 0:
                                Toast.makeText(MainActivity.this, "Manage profile", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                startActivity(new Intent(MainActivity.this , OrganizationsListActivity.class));
                                break;
                            case 2:
                                //TODO : Create events activity
                                break;
                            case 3:
                                startActivity(new Intent(MainActivity.this , SettingsActivity.class));
                                break;
                            case 4:
                                //TODO : create credits and open source Dialog
                                break;
                            case 5:
                                //TODO : sign out the user
                                break;
                        }
                        return false;
                    }
                })
                .build();
    }
}
