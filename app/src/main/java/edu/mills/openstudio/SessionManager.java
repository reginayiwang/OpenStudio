package edu.mills.openstudio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

/**
 * Monitor if the user is logged into their account.
 */
public class SessionManager {
    private static String TAG = SessionManager.class.getSimpleName();
    SharedPreferences pref;

    Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "OpenStudioLogin";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";

    /**
     * Contructor for the class.
     * @param context login object
     */
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Set new login status
     * @param isLoggedIn true if user is logged in, false if user is not logged in
     */
    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    /**
     * Check if the user is logged in.
     * @return stored value saved in shared preferences
     */

    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }
}
