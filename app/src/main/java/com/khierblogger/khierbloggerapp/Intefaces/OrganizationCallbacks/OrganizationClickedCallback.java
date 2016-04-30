package com.khierblogger.khierbloggerapp.Intefaces.OrganizationCallbacks;

import android.widget.ImageView;

import com.khierblogger.khierbloggerapp.MainClasses.Organization;

public interface OrganizationClickedCallback {
    void onOrganizationClicked(Organization organization , ImageView sharedImageView);
}
