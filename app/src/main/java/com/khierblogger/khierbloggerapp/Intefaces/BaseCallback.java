package com.khierblogger.khierbloggerapp.Intefaces;


interface BaseCallback {

    /**
     * Called when an error happened while trying to get data from KhierBloggerServer
     * @param errorMessage Error message describing what went wrong
     */

    void onError(String errorMessage);
}
