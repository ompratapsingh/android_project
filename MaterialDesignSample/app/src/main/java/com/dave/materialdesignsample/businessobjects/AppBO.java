package com.dave.materialdesignsample.businessobjects;

import com.dave.materialdesignsample.constant.AppConstants;
import com.dave.materialdesignsample.utilities.HttpUtilities;

import java.util.HashMap;

/**
 * Created by osingh on 20-Jan-17.
 */
public class AppBO {

    /***
     * <p>This method for process user registration.</p>
     *
     * @param name
     * @param email
     * @param acception
     * @param mobiles
     * @return {String}
     */
    public String getRegistrationOFUser(String name, String email, String acception, String mobiles, String actionID) {
        String responsce = "";
        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put(AppConstants.R_NAME, name);
        queryMap.put(AppConstants.R_EMAIL, email);
        queryMap.put(AppConstants.R_ACCEPTION, acception);
        queryMap.put(AppConstants.R_MOBILE, mobiles);
        queryMap.put(AppConstants.APPS_REGISTRATION_ACTION_ID, actionID);
        try {
            responsce = HttpUtilities.execDynamicRequest(AppConstants.REGISTRATION_URL, queryMap);
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        return responsce;
    }
}
