package com.khierblogger.khierbloggerapp.Intefaces;

import com.khierblogger.khierbloggerapp.CircleImageView;
import com.khierblogger.khierbloggerapp.MainClasses.Organization;

public interface OrganizationClickedCallback {
    void onOrganizationClicked(Organization organization , CircleImageView sharedImageView);
}
