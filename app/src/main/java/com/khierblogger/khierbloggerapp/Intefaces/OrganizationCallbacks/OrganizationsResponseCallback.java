package com.khierblogger.khierbloggerapp.Intefaces.OrganizationCallbacks;

import com.khierblogger.khierbloggerapp.Intefaces.BaseCallback;
import com.khierblogger.khierbloggerapp.MainClasses.Organization;

import java.util.ArrayList;

public interface OrganizationsResponseCallback extends BaseCallback {

    /**
     * Called when an Organizations response is fetched successfully
     * @param organizations ArrayList representing All the organizations on the server
     */
    void onOrganizationsFetched(ArrayList<Organization> organizations);
}
