package com.rohit.lpregister.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {

    public Context context;

    public SharedPreference(Context context) {
        this.context = context;
    }

    /**
     * Method to store the email id and password in the shared Preference file
     * @param email user email id
     * @param password user Password
     */

    public void saveLoginDetails(String email, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", email);
        editor.putString("Password", password);
        editor.apply();
    }

    /**
     * Method to dave the email to shared Preference file.
     * @param email candidate Email
     */

    public void saveEmail(String email) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", email);
        editor.apply();
    }

    /**
     *
     * @return boolean true or false (user email or password are present or not in the file)
     */

    public boolean isUserLogedOut() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        boolean isEmailEmpty = sharedPreferences.getString("Email", "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("Password", "").isEmpty();
        return isEmailEmpty || isPasswordEmpty;
    }

    /**
     * method to clear the user data from the shared preference file.
     */

    public void clear() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("Email");
        editor.remove("Password");
        editor.apply();
    }

    /**
     * This to provide email id from the sharedPreference.
     * @return candidate Email id
     */

    public String getEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Email", "");
    }


}
