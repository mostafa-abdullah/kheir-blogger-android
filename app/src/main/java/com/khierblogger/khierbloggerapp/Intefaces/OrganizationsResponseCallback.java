package com.khierblogger.khierbloggerapp.Intefaces;

import com.khierblogger.khierbloggerapp.MainClasses.Organization;

import java.util.ArrayList;

public interface OrganizationsResponseCallback extends BaseCallback {

    /**
     * Called when an organization response is fetched successfully
     * @param organizations ArrayList representing All the organizations on the server
     */
    void onOrganizationFetched(ArrayList<Organization> organizations);
}
