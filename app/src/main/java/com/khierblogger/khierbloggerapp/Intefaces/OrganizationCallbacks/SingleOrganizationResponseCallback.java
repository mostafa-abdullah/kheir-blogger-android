package com.khierblogger.khierbloggerapp.Intefaces.OrganizationCallbacks;

import com.khierblogger.khierbloggerapp.Intefaces.BaseCallback;
import com.khierblogger.khierbloggerapp.MainClasses.Organization;

public interface SingleOrganizationResponseCallback extends BaseCallback {
    /**
     * Called when a single Organization response is fetched successfully
     * @param organization ArrayList representing All the organizations on the server
     */
    void onOrganizationFetched(Organization organization);
}
